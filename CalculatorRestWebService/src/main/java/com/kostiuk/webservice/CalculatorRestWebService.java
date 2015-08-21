package com.kostiuk.webservice;


import com.kostiuk.webservice.exception.IllegalOperandValueException;
import com.kostiuk.webservice.exception.InvalidOperationException;
import com.kostiuk.webservice.operations.CalculatorOperation;
import com.kostiuk.webservice.operations.OperationFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;


@Path("/")
public class CalculatorRestWebService {

    @Path("{operator}/{value1}/{value2}")
    @GET
    @Produces("application/json")
    public Response calc(@PathParam("operator") String operator, @PathParam("value1") float value1,
                         @PathParam("value2") float value2) throws JSONException {

        try {
            CalculatorOperation operation = OperationFactory.getInstance(operator);

            JSONObject resultJSON = new JSONObject();
            double result = operation.perform(value1, value2);

            resultJSON.put("value1", value1);
            resultJSON.put("value2", value2);
            resultJSON.put("operation", operator);
            resultJSON.put("result", result);

            String resultString = resultJSON.toString();
            return Response.status(Response.Status.OK).entity(resultString).build();

        } catch(InvalidOperationException e) {
            return initErrorResponce(Response.Status.NOT_FOUND, e.getMessage());
        } catch(IllegalOperandValueException e) {
            return initErrorResponce(Response.Status.BAD_REQUEST, e.getMessage());
        }

    }

    private Response initErrorResponce(Response.Status status, String message) {
        JSONObject errorJSON = new JSONObject();
        errorJSON.put("error", message);
        return Response.status(status).entity(errorJSON.toString()).build();
    }
}