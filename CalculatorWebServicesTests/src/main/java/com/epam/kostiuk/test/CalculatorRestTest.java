package com.epam.kostiuk.test;

import com.epam.kostiuk.test.model.ErrorResult;
import com.epam.kostiuk.test.model.Result;
import com.epam.kostiuk.test.operations.CalculatorOperation;
import java.io.IOException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author okostiuk
 */
public class CalculatorRestTest {

    public static final String FORMAT = "%.4f";
    public static final Logger LOGGER = Logger.getLogger(CalculatorRestRequest.class);
    public static final String RESPONCE_CODE_RECEIVED = "Responce code received: ";
    public static final String RESULT_RECEIVED = "Result received: ";
    public static final String ERROR_MESSAGE_RECEIVED = "Error message received: ";
    public static final String MSSG_NOT_VALID_RESPONSE_RECEIVED = "Not valid response received";

    @DataProvider(name = "validInput")
    public static Object[][] validInput() {
        return new Object[][]{{CalculatorOperation.DIV, 100, 10},
            {CalculatorOperation.DIV, 1, 13},
            {CalculatorOperation.DIV, -1, -1},
            {CalculatorOperation.DIV, -99, 16},
            {CalculatorOperation.DIV, 10, -3},
            {CalculatorOperation.DIV, 10, 10},
            {CalculatorOperation.ADD, 100, 10},
            {CalculatorOperation.ADD, 1, 13},
            {CalculatorOperation.ADD, -1, -1},
            {CalculatorOperation.ADD, -99, 16},
            {CalculatorOperation.ADD, 10, -3},
            {CalculatorOperation.MUL, 10, 10},
            {CalculatorOperation.MUL, 100, 10},
            {CalculatorOperation.MUL, 1, 13},
            {CalculatorOperation.MUL, -1, -1},
            {CalculatorOperation.MUL, -99, 16},
            {CalculatorOperation.MUL, 10, -3},
            {CalculatorOperation.MUL, 10, 10},
            {CalculatorOperation.SUB, 10, 10},
            {CalculatorOperation.SUB, 100, 10},
            {CalculatorOperation.SUB, 1, 13},
            {CalculatorOperation.SUB, -1, -1},
            {CalculatorOperation.SUB, -99, 16},
            {CalculatorOperation.SUB, 10, -3},
            {CalculatorOperation.POW, 10, 10},
            {CalculatorOperation.POW, 100, 10},
            {CalculatorOperation.POW, 1, 13},
            {CalculatorOperation.POW, -1, -1},
            {CalculatorOperation.POW, -99, 16},
            {CalculatorOperation.POW, 10, -3}};
    }

    @Test(dataProvider = "validInput")
    public void testOperationWithValidValue(CalculatorOperation operation, float value1, float value2)
        throws IOException {

        Response response = new CalculatorRestRequest().performOperation(operation, value1, value2);

        int actualResponceCode =  response.getStatus();
        LOGGER.info(RESPONCE_CODE_RECEIVED + actualResponceCode);
        Assert.assertEquals(Response.Status.OK.getStatusCode(), actualResponceCode, MSSG_NOT_VALID_RESPONSE_RECEIVED);

        ObjectMapper mapper = new ObjectMapper();
        Result result = mapper.readValue(response.readEntity(String.class), Result.class);

        double actualResult = result.getResult();
        LOGGER.info(RESULT_RECEIVED + actualResult);
        Assert.assertEquals(String.format(FORMAT, actualResult),
            String.format(FORMAT, operation.perform(value1, value2)));

    }

    @Test
    public void testDivOnZero() throws IOException {

        float value1 = 10;
        float value2 = 0;

        Response response = new CalculatorRestRequest().performOperation(CalculatorOperation.DIV, value1, value2);

        int actualResponceCode =  response.getStatus();
        LOGGER.info(RESPONCE_CODE_RECEIVED + actualResponceCode);
        Assert.assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), actualResponceCode,
            MSSG_NOT_VALID_RESPONSE_RECEIVED);

        ObjectMapper mapper = new ObjectMapper();
        ErrorResult errorResult = mapper.readValue(response.readEntity(String.class), ErrorResult.class);

        String actualErrorMessage = errorResult.getError();
        LOGGER.info(ERROR_MESSAGE_RECEIVED + actualErrorMessage);
        Assert.assertEquals(actualErrorMessage, "Division on zero.", "Error message not found");
    }

    @Test
    public void invalidOperator() throws IOException {

        Response response = new CalculatorRestRequest().performOperation(CalculatorOperation.INVALID_OP, 10, 11);
        ObjectMapper mapper = new ObjectMapper();
        ErrorResult errorResult = mapper.readValue(response.readEntity(String.class), ErrorResult.class);

        String actualErrorMessage = errorResult.getError();
        LOGGER.info(ERROR_MESSAGE_RECEIVED + actualErrorMessage);
        Assert.assertEquals(actualErrorMessage, "Invalid operation exception",
            "Invalid operator message not found.");

    }

    @Test
    public void powErrorValue() throws IOException {

        float value1 = -10;
        float value2 = 0.1f;

        Response response = new CalculatorRestRequest().performOperation(CalculatorOperation.POW, value1, value2);

        Assert.assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus(),
            MSSG_NOT_VALID_RESPONSE_RECEIVED);

        ObjectMapper mapper = new ObjectMapper();
        ErrorResult errorResult = mapper.readValue(response.readEntity(String.class), ErrorResult.class);

        String actualErrorMessage = errorResult.getError();
        LOGGER.info(ERROR_MESSAGE_RECEIVED + actualErrorMessage);
        Assert.assertEquals(actualErrorMessage, "Invalid input.", "Error message not found");

    }

    @Test
    public void outOfFloatRange() throws IOException {

        double value1 = -99999999999999999999999999999999999999999d;
        float value2 = 156;

        Response response = new CalculatorRestRequest().performOperation(CalculatorOperation.DIV, value1, value2);

        Assert.assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus(),
            MSSG_NOT_VALID_RESPONSE_RECEIVED);

        ObjectMapper mapper = new ObjectMapper();
        ErrorResult errorResult = mapper.readValue(response.readEntity(String.class), ErrorResult.class);

        String actualErrorMessage = errorResult.getError();
        LOGGER.info(ERROR_MESSAGE_RECEIVED + actualErrorMessage);
        Assert.assertEquals(actualErrorMessage, "Value is out of float range.", "Error message not found");

    }


}
