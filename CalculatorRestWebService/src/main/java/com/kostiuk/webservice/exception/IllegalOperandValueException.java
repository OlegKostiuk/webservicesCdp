package com.kostiuk.webservice.exception;

/**
 * @author okostiuk
 */
public class IllegalOperandValueException extends Exception {
    public IllegalOperandValueException() {
        super();
    }

    public IllegalOperandValueException(String message) {
        super(message);
    }

    public IllegalOperandValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
