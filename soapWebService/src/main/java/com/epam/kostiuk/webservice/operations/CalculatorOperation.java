package com.epam.kostiuk.webservice.operations;


import com.epam.kostiuk.webservice.exception.IllegalOperandValueException;

/**
 * @author okostiuk
 */
public abstract class CalculatorOperation {

    public static final String OUT_OF_RANGE_ERROR = "Value is out of float range.";

    public abstract double perform(float value1, float value2) throws IllegalOperandValueException;

    protected boolean numbersHasValidRange(float value1, float value2) {
        return value1 <= Float.MAX_VALUE && value1 >= -Float.MAX_VALUE && value2 <= Float.MAX_VALUE
            && value2 >= -Float.MAX_VALUE;
    }
}
