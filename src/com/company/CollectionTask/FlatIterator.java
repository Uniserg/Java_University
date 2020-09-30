package com.company.CollectionTask;

import java.util.Iterator;
import java.util.Stack;

public class FlatIterator implements Iterator {
    private final Stack<Iterator> recursiveIterator;

    public FlatIterator(Iterator recursiveIterator) {
        this.recursiveIterator = new Stack<>();
        this.recursiveIterator.push(recursiveIterator);
    }

    @Override
    public boolean hasNext() {
        return recursiveIterator.stream().anyMatch(Iterator::hasNext);
    }

    @Override
    public Object next() {
        while (!recursiveIterator.empty() && !recursiveIterator.peek().hasNext()) {
            recursiveIterator.pop();
        }

        Object obj = recursiveIterator.peek().next();
        if (RecursiveIterator.class.equals(obj.getClass())) {
            recursiveIterator.push((RecursiveIterator) obj);
            return next();
        } else {
            return obj;
        }
    }
}
