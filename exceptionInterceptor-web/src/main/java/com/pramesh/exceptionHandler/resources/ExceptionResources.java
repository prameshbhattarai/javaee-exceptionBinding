/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pramesh.exceptionHandler.resources;

import com.pramesh.exceptionHandler.exception.CreateException;
import com.pramesh.exceptionHandler.exception.CustomException;
import java.nio.file.FileAlreadyExistsException;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author pramesh.bhattarai
 */
@Path("exception")
public class ExceptionResources {

    @Inject
    CreateException createException;

    @GET
    @Path("custom")
    public Response customException() throws CustomException {
        return Response.ok().entity(createException.customException()).build();
    }

    @GET
    @Path("fileAlreadyExist")
    public Response fileAlreadyExistException() throws FileAlreadyExistsException {
        return Response.ok().entity(createException.fileAlreadyExistException()).build();
    }

    @GET
    @Path("runtime")
    public Response runtimeException() {
        return Response.ok().entity(createException.runtimeException()).build();
    }
}
