package com.epam.kostiuk.test.model;

/**
 * @author okostiuk
 */
public class ErrorResult implements ICalculatorResponse {

    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
