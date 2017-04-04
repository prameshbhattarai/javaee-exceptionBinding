/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pramesh.exceptionHandler.response;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;

/**
 *
 * @author pramesh.bhattarai
 */
public class ExceptionResponse {
    
     public static JsonObject createResponse(String message) {
        JsonObject response;
        response = Json.createObjectBuilder()
                .add("message", message)
                .add("status", "Exception")
                .add("statusCode", Response.Status.CONFLICT.getStatusCode())
                .build();
        return response;
    }
}
