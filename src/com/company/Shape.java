package com.company;

public abstract class Shape {
    private final double volume;

    protected Shape(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

}
