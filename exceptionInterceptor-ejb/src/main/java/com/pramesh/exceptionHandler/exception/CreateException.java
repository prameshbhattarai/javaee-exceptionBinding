/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pramesh.exceptionHandler.exception;

import com.pramesh.exceptionHandler.qualifier.BindException;
import com.pramesh.exceptionHandler.qualifier.ExceptionCollector;
import java.nio.file.FileAlreadyExistsException;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author pramesh.bhattarai
 */
@ApplicationScoped
public class CreateException {

    public CreateException() {
    }

    @BindException
    @ExceptionCollector(exception = {CustomException.class})
    public Object customException() throws CustomException {
        // throw custom exception
        // which will be bind by exception interceptor
        throw new CustomException("Exception is thrown from CustomException class");
    }

    @BindException
    @ExceptionCollector(exception = {FileAlreadyExistsException.class})
    public Object fileAlreadyExistException() throws FileAlreadyExistsException {
        // throw file already exists exception
        // which will be bind by exception interceptor
        throw new FileAlreadyExistsException("File in Z:/ dir not found");

    }

    @BindException
    @ExceptionCollector(exception = {RuntimeException.class})
    public Object runtimeException() throws RuntimeException {
        // throw runtime exception
        // which will be bind by exception interceptor
        throw new RuntimeException("Due to some issue there is runtime exception");

    }

}
