package com.kostiuk.webservice.operations;

import com.kostiuk.webservice.exception.InvalidOperationException;
import java.util.HashMap;

/**
 * @author okostiuk
 */
public class OperationFactory {

    private static HashMap<String, CalculatorOperation> operationsMap = new HashMap<String, CalculatorOperation>();

    static {
        operationsMap.put("add", new Add());
        operationsMap.put("sub", new Sub());
        operationsMap.put("mul", new Mul());
        operationsMap.put("div", new Div());
        operationsMap.put("pow", new Pow());
    }

    public static CalculatorOperation getInstance(String operation) throws InvalidOperationException {
        if (!operationsMap.containsKey(operation)) {
            throw new InvalidOperationException("Invalid operation exception");
        }
        return operationsMap.get(operation);
    }
}
