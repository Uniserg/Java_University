package com.company;

import java.util.*;

public class SelectionWeight<T> {
    private final T[] elements;
    private final int[] elementsWeight;
    int sumWeights;

    public SelectionWeight(T[] elements, int[] elementsWeight){
        this.elements = elements;
        this.elementsWeight = elementsWeight;
        sumWeights = Arrays.stream(elementsWeight).sum();
    }

    public T getRandom(){
        Random random = new Random();
        int randW = random.nextInt(sumWeights);
        int toWeight = 0;
        int i = 0;

        while (true){
            toWeight += elementsWeight[i];
            if (toWeight >= randW) break;
            i++;
        }
        return elements[i];
    }

}
