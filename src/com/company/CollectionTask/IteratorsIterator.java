package com.company.CollectionTask;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorsIterator<T> implements Iterator<T> {
    private final Iterator<T>[] iterators;
    int index = 0;

    public IteratorsIterator(Iterator<T>[] iterators) {
        this.iterators = iterators;
    }

    @Override
    public boolean hasNext() {
        return index < iterators.length - 1 || iterators[iterators.length - 1].hasNext();
    }

    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        if (iterators[index].hasNext()) {
            return iterators[index].next();
        } else {
            return iterators[++index].next();
        }
    }
}
