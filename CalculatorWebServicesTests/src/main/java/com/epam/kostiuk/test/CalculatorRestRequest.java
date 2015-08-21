package com.epam.kostiuk.test;

import com.epam.kostiuk.test.operations.CalculatorOperation;
import java.io.IOException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.client.WebClient;

/**
 * @author okostiuk
 */
public class CalculatorRestRequest {

    public Response performOperation(CalculatorOperation operation, double value1, double value2) throws IOException {
        WebClient client = WebClient.create("http://localhost:8080/CalculatorRestWebService/calculator");
        client.accept(MediaType.APPLICATION_JSON);
        client.path(operation).path(value1).path(value2);
        return client.get();

    }
}
