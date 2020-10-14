package com.company;

import java.util.HashMap;
import java.util.Iterator;

public class Garage {
    HashMap<Car, Integer> cars;
    private int maxSize;

    public int getMaxSize() {
        return maxSize;
    }

    public void setCars(HashMap<Car, Integer> cars) {
        this.cars = cars;
    }

    public void printSortKey() {
        for (Iterator<Car> it = cars.keySet().stream().sorted().iterator(); it.hasNext(); ) {
            Car car = it.next();
            System.out.println(car.getName() + ": " + cars.get(car));
        }
    }
}
