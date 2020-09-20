package com.company.CollectionTask;

import java.util.*;

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

    public static double measureTime(List<Double> col, int n, int m) {
        double start = System.currentTimeMillis();
        addElements(col, n);
        selectElements(col, m);
        return (System.currentTimeMillis() - start) / 1000;
    }

    public static HashMap<String, Integer> FrequencyDict() {
        HashMap<String, Integer> result = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        String data;
        while (true) {
            data = scanner.nextLine();
            if (data.equals("end")) break;
            for (String s : data.split("[^А-я-]")) {
                if (s.equals("")) continue;
                s = s.substring(0, 1).toUpperCase() + s.substring(1);
                if (result.containsKey(s)) {
                    result.put(s, result.get(s) + 1);
                } else {
                    result.put(s, 1);
                }
            }
        }
        return result;
    }
}
