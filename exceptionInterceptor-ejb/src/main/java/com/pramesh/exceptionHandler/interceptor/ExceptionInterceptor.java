/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pramesh.exceptionHandler.interceptor;

import com.pramesh.exceptionHandler.response.ExceptionResponse;
import com.pramesh.exceptionHandler.qualifier.BindException;
import com.pramesh.exceptionHandler.qualifier.ExceptionCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author pramesh.bhattarai
 */
@Interceptor
@BindException
public class ExceptionInterceptor {

    List<Class<? extends Exception>> exceptions = new ArrayList<>();

    @AroundInvoke
    public Object methodInterceptor(InvocationContext ctx) throws Exception {
        System.out.println("Invoked method " + ctx.getMethod().getName());
        exceptionCollector(ctx);
        try {
            return ctx.proceed();
        } catch (Exception ex) {
            System.out.println("---------------------------------");
            System.out.println("Exception had been caught");
            System.out.println("Message :: " + ex.getMessage());
            System.out.println("---------------------------------");
            return ExceptionResponse.createResponse(ex.getMessage());
        }
    }
    

    protected void exceptionCollector(InvocationContext ctx) {
        if (ctx.getMethod().isAnnotationPresent(ExceptionCollector.class)) {
            ExceptionCollector annotation = ctx.getMethod().getAnnotation(ExceptionCollector.class);
            exceptions.addAll(Arrays.asList(annotation.exception()));
        }

    }
}
