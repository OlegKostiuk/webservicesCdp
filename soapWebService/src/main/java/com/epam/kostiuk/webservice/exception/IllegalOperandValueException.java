package com.epam.kostiuk.webservice.exception;

/**
 * @author okostiuk
 */
public class IllegalOperandValueException extends IllegalArgumentException {
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
