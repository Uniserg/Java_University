package com.company.checkelement;

public class CheckElementR<T> {
    T[] array;
    T el;
    boolean elIn;

    public CheckElementR(T[] array, T el) {
        this.array = array;
        this.el = el;
    }

    private void search(int i) {
        if (i == array.length)
            return;
        else if (array[i] == el) {
            elIn = true;
            return;
        }

        search(i + 1);
    }

    public boolean check() {
        search(0);
        return elIn;
    }
}
