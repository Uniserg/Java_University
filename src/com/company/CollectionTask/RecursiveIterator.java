package com.company.CollectionTask;

import java.util.Iterator;

public class RecursiveIterator implements Iterator {
    private final Iterator iterator;

    public RecursiveIterator(Iterator iterator) {
        this.iterator = iterator;
    }


    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Object next() {
        Object cur = iterator.next();
        if (cur instanceof Iterator) {
            return new RecursiveIterator((Iterator) cur);
        } else {
            return cur.toString();
        }
    }
}
