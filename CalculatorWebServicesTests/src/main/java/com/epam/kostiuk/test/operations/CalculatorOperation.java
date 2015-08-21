package com.epam.kostiuk.test.operations;

/**
 * @author okostiuk
 */
public enum CalculatorOperation {
    ADD("add") {
        public double perform(double value1, double value2) {
            return value1 + value2;
        }
    },

    MUL("mul") {
        public double perform(double value1, double value2) {
            return value1 * value2;
        }
    },

    SUB("sub") {
        public double perform(double value1, double value2) {
            return value1 - value2;
        }
    },

    DIV("div") {
        public double perform(double value1, double value2) {
            return value1 / value2;
        }
    },
    POW("pow") {
        public double perform(double value1, double value2) {
            return Math.pow(value1, value2);
        }
    },

    INVALID_OP("invalidOperation") {
            public double perform( double value1, double value2){
                return 0;
            }
        };

    private String value;

    CalculatorOperation(String value) {
        this.value = value;
    }

    public abstract double perform(double value1, double value2);

    @Override
    public String toString() {
        return value;
    }
}
