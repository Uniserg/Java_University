package com.company.findsolution;

import java.util.function.Function;

public class FindSolution {
    double a;
    double b;
    Function<Double, Double> f;
    double e;
    private Double x;

    public FindSolution(double a, double b, Function<Double, Double> f, double e) {
        this.a = a;
        this.b = b;
        this.f = f;
        this.e = e;
    }

    private double c(double a, double b) {
        return (a + b) / 2;
    }

    private void find(double a, double b) {
        if (b - a <= 2 * e) {
            x = c(a, b);
            return;
        }
        if (f.apply(a) * f.apply(c(a, b)) < 0)
            find(a, c(a, b));
        else
            find(c(a, b), b);
    }

    public String getFuncS() {
        return f + " = 0";
    }

    public double getX() {
        if (x == null)
            find(a, b);
        return x;
    }
}
