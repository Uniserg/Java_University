package com.company.CollectionTask;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TwoDimensionalArrayIterator<T> implements Iterator<T> {
    private final T[][] matrix;
    private int index1 = 0;
    private int index2 = 0;

    public TwoDimensionalArrayIterator(T[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public boolean hasNext() {
        return index1 < matrix.length - 1 || index2 < matrix[matrix.length - 1].length;
    }

    @Override
    public T next() {
        if (!hasNext())
            throw new NoSuchElementException();
        if (index2 < matrix[index1].length) {
            return matrix[index1][index2++];
        } else {
            index2 = 0;
            return matrix[++index1][index2++];
        }
    }
}
