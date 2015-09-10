package com.epam.kostiuk.test;

import com.epam.kostiuk.test.operations.CalculatorOperation;
import java.io.IOException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.log4j.Logger;

/**
 * @author okostiuk
 */
public class CalculatorRestRequest {

    public static final Logger LOGGER = Logger.getLogger(CalculatorSoapTest.class);
    public static final String REST_WEB_SERVICE_CALCULATOR
        = "http://localhost:8080/CalculatorRestWebService/calculator";

    public Response performOperation(CalculatorOperation operation, double value1, double value2) throws IOException {
        LOGGER.info(String.format("Send request to '%s' operation with value: %s, %s", operation.toString(), value1, value2));
        WebClient client = WebClient.create(REST_WEB_SERVICE_CALCULATOR);
        client.accept(MediaType.APPLICATION_JSON);
        client.path(operation).path(value1).path(value2);
        return client.get();

    }
}
