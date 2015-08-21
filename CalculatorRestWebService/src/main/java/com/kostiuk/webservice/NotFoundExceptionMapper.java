package com.kostiuk.webservice;

import com.sun.jersey.api.ParamException;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

/**
 * @author okostiuk
 */
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<ParamException> {

    public Response toResponse(ParamException exception) {
        JSONObject errorJSON = new JSONObject();
        errorJSON.put("error", "Invalid value received.");
        return Response.status(Response.Status.BAD_REQUEST).entity(errorJSON.toString()).build();
    }
}