package com.company.getenumr;

public class GetEnumR {

    public void printEnum(int n) {
        if (n == 0)
            return;

        printEnum(n - 1);
        System.out.print(n + " ");
    }
}
