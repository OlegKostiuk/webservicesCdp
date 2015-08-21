package com.epam.kostiuk.test.model;

/**
 * @author okostiuk
 */
public class Result implements ICalculatorResponse {

    String operation;
    double value1;
    double value2;
    double result;

    public Result() {
    }

    public Result(String operation, double value1, double value2, double result) {
        this.operation = operation;
        this.value1 = value1;
        this.value2 = value2;
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getValue1() {
        return value1;
    }

    public void setValue1(double value1) {
        this.value1 = value1;
    }

    public double getValue2() {
        return value2;
    }

    public void setValue2(double value2) {
        this.value2 = value2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

}
