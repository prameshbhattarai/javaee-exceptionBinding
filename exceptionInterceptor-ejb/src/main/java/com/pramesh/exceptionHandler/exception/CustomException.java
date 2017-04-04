/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pramesh.exceptionHandler.exception;

/**
 *
 * @author pramesh.bhattarai
 */
public class CustomException extends Exception{
    
    public CustomException() {}
    
    public CustomException(String message) {
        super(message);
    }
    
    public CustomException(Exception ex) {
        super(ex);
    }
    
    public CustomException(String message, Exception ex) {
        super(message, ex);
    }
    
    public Exception getCauseByException() {
        return (Exception) getCause();
    }
}
