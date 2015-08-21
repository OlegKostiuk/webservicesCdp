package com.epam.kostiuk.webservice.exception;

/**
 * @author okostiuk
 */
public class InvalidOperationException extends IllegalArgumentException {

    public InvalidOperationException() {
        super();
    }

    public InvalidOperationException(String message) {
        super(message);
    }

    public InvalidOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
