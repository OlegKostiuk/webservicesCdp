package com.epam.kostiuk.webservice.operations;


import com.epam.kostiuk.webservice.exception.IllegalOperandValueException;

/**
 * @author okostiuk
 */
public class Pow extends CalculatorOperation {

    @Override
    public double perform(float value1, float value2) throws IllegalOperandValueException {
        if(!numbersHasValidRange(value1, value2)) {
            throw new IllegalOperandValueException(OUT_OF_RANGE_ERROR);
        }

        if (value1 <= 0 && value2<1 & value2>0) {
            throw new IllegalOperandValueException("Invalid input.");
        }

        return Math.pow(value1, value2);
    }
}
