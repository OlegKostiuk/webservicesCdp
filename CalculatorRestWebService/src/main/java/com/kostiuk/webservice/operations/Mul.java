package com.kostiuk.webservice.operations;

import com.kostiuk.webservice.exception.IllegalOperandValueException;

/**
 * @author okostiuk
 */
public class Mul extends CalculatorOperation {

    @Override
    public double perform(float value1, float value2) throws IllegalOperandValueException {
        if(!numbersHasValidRange(value1, value2)) {
            throw new IllegalOperandValueException(OUT_OF_RANGE_ERROR);
        }

        return value1 * value2;
    }
}
