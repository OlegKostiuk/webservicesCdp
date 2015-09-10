package com.epam.kostiuk.test;

import com.epam.kostiuk.webservice.Calculator;
import com.epam.kostiuk.webservice.CalculatorWebServiceService;
import javax.xml.ws.Holder;
import javax.xml.ws.soap.SOAPFaultException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author okostiuk
 */
public class CalculatorSoapTest {
    public static final Logger LOGGER = Logger.getLogger(CalculatorSoapTest.class);
    public static final String LOG_MESSAGE = "Send request to '%s' operation with value: %s, %s";

    public static final String FORMAT = "%.4f";
    public static final String RESULT_LOG = "Result received: %s";

    static private Calculator client;

    static {
        CalculatorWebServiceService service = new CalculatorWebServiceService();
        client = service.getCalculatorPort();
    }


    @DataProvider(name = "validInput")
    public static Object[][] validInput() {
        return new Object[][]{{10, 10},
            {100, 10},
            {1, 13},
            {-1, -1},
            {-99, 16}};
    }

    @Test(dataProvider = "validInput")
    public void testAddWithValidValue(float value1, float value2) {
        Holder<Double> result = new Holder<Double>();

        LOGGER.info(
            String.format(LOG_MESSAGE, "add", value1, value2));
        client.add(value1, value2, result);

        LOGGER.info(String.format(RESULT_LOG, result.value));
        Assert.assertEquals(String.format(FORMAT, result.value),
            String.format(FORMAT, value1 + value2));
    }

    @Test(dataProvider = "validInput")
    public void testDivWithValidValue(float value1, float value2) {
        Holder<Double> result = new Holder<Double>();

        LOGGER.info(
            String.format(LOG_MESSAGE, "div", value1, value2));
        client.div(value1, value2, result);

        LOGGER.info(String.format(RESULT_LOG, result.value));
        Assert.assertEquals(String.format(FORMAT, result.value),
            String.format(FORMAT, value1 / value2));
    }

    @Test(dataProvider = "validInput")
    public void testMulWithValidValue(float value1, float value2) {
        Holder<Double> result = new Holder<Double>();

        LOGGER.info(
            String.format(LOG_MESSAGE, "mul", value1, value2));
        client.mul(value1, value2, result);

        LOGGER.info(String.format(RESULT_LOG, result.value));
        Assert.assertEquals(String.format(FORMAT, result.value),
            String.format(FORMAT, value1 * value2));
    }

    @Test(dataProvider = "validInput")
    public void testPowWithValidValue(float value1, float value2) {
        Holder<Double> result = new Holder<Double>();

        LOGGER.info(
            String.format(LOG_MESSAGE, "pow", value1, value2));
        client.pow(value1, value2, result);

        LOGGER.info(String.format(RESULT_LOG, result.value));
        Assert.assertEquals(String.format(FORMAT, result.value),
            String.format(FORMAT, Math.pow(value1, value2)));
    }

    @Test(dataProvider = "validInput")
    public void testSubWithValidValue(float value1, float value2) {
        Holder<Double> result = new Holder<Double>();

        LOGGER.info(
            String.format(LOG_MESSAGE, "sub", value1, value2));

        client.sub(value1, value2, result);

        LOGGER.info(String.format(RESULT_LOG, result.value));
        Assert.assertEquals(String.format(FORMAT, result.value),
            String.format(FORMAT, value1 - value2));
    }

    @Test(expectedExceptions = SOAPFaultException.class, expectedExceptionsMessageRegExp = "Division on zero.")
    public void testDivOnZero() {
        float value1 = 10;
        float value2 = 0;

        LOGGER.info(
            String.format(LOG_MESSAGE, "div", value1, value2));
        Holder<Double> result = new Holder<Double>();

        client.div(value1, value2, result);
    }

    @Test(expectedExceptions = SOAPFaultException.class, expectedExceptionsMessageRegExp = "Invalid input.")
    public void powErrorValue() {
        float value1 = -10;
        float value2 = 0.1f;

        LOGGER.info(
            String.format(LOG_MESSAGE, "pow", value1, value2));
        Holder<Double> result = new Holder<Double>();

        client.pow(value1, value2, result);

    }
}
