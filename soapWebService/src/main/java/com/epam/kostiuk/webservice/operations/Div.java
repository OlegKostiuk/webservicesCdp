package com.epam.kostiuk.webservice.operations;


import com.epam.kostiuk.webservice.exception.IllegalOperandValueException;

/**
 * @author okostiuk
 */
public class Div extends CalculatorOperation {

    public static final String DIVISION_ON_ZERO = "Division on zero.";

    @Override
    public double perform(float value1, float value2) throws IllegalOperandValueException {
        if(!numbersHasValidRange(value1, value2)) {
            throw new IllegalOperandValueException(OUT_OF_RANGE_ERROR);
        }

        if(value2 == 0) {
            throw new IllegalOperandValueException(DIVISION_ON_ZERO);
        }

        return value1 / value2;
    }
}
