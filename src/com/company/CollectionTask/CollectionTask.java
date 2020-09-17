package com.company.CollectionTask;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class CollectionTask{

    public static <T> Collection<T> removeDuplicate(Collection<T> col){
        return new HashSet<>(col);
    }

    public static void selectElements(List<Double> col, int n){
        Random random = new Random();
        for (int i = 0; i < n; i++){
            col.get(random.nextInt(n));
        }
    }

    public static void addElements(List<Double> col, int n){
        Random random = new Random();
        for (int i = 0; i < n; i++){
            col.add(random.nextDouble());
        }
    }

    public static double measureTime(List<Double> col, int n, int m){
        double start = System.currentTimeMillis();
        addElements(col, n);
        selectElements(col, m);
        return (System.currentTimeMillis() - start) / 1000;
    }
}
