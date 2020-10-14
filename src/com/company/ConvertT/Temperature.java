package com.company.ConvertT;

import java.util.HashMap;
import java.util.function.Function;

public class Temperature {
    private final HashMap<Character, Function<Double, Double>> signs;
    private double currentValue;
    private char currentSign;

    public Temperature(double t) {
        currentValue = t;
        currentSign = 'C';
        signs = new HashMap<>() {{
            put('C', (x) -> x);
            put('K', (x) -> x + 273.15);
            put('F', (x) -> x * 1.8 + 32);
        }};
    }

    public void changeSign(char ch) {
        currentValue = signs.get(ch).apply(currentValue);
        currentSign = ch;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public char getCurrentSign() {
        return currentSign;
    }
}
