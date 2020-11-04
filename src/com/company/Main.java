package com.company;

import com.company.CollectionTask.*;
import com.company.ConvertT.Temperature;
import com.company.Shape.*;
import com.company.StringBuilder.NotifyingStringBuilder;
import com.company.StringBuilder.UndoableStringBuilder;
import com.company.StringBuilder.myNotifier;
import com.company.cafe.Cafe;
import com.company.cafe.Food;
import com.company.cafe.Order;
import com.company.car.Car;
import com.company.car.Garage;
import com.company.car.Passenger;
import com.company.employees.Employee;
import com.company.employees.Employees;
import com.company.employees.FixedSalary;
import com.company.employees.HourlySalary;

import java.util.*;
import java.util.function.Function;


public class Main {

    public static String getCallerClassAndMethodName() {
        Throwable throwable = new Throwable();
        StackTraceElement[] runner = throwable.getStackTrace();
        if (runner.length < 3)
            return null;

        return runner[2].getClassName() + "#" + runner[2].getMethodName();
    }

    public static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();
    }

    public static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();
    }

    public static void m3() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        }

        return Math.sqrt(x);

    }

    public static void main(String[] args) throws Exception {

        anotherMethod();
        System.out.println(getCallerClassAndMethodName());
        m1();

        int repeating = 100;
        Matrix A = new Matrix(new double[][]{
                {1, 2, 2},
                {2, 1, 2}
        });
        Matrix B = new Matrix(new double[][]{
                {2, 10, 6},
                {6, 5, 5},
                {1, 3, 2}
        });


        System.out.println("*".repeat(repeating));
        System.out.println("<Задание на матрицы>\n");

        Matrix C = A.mul(B);
        System.out.println("Перемножение матриц:\n" + C);
        System.out.println("Транспонирование:\n" + C.transpose());
        System.out.println("Возведение в степень:\n" + B.pow(10));


        System.out.println("*".repeat(repeating));
        System.out.println("<Задание на векторы>\n");

        System.out.println("Генерация случайных векторов:");
        Vector3D[] D = Vector3D.generateVectors(5);
        for (var vector : D) {
            System.out.println(vector);
        }


        System.out.println("*".repeat(repeating));
        System.out.println("<Задание на фигуры>\n");

        Box myBox = new Box(1000);
        Shape[] toAdd = {new Ball(5),
                new Cylinder(3, 6),
                new Pyramid(2, 5),
                new Ball(10)
        };

        for (var figure : toAdd) {
            System.out.println(myBox.add(figure));
        }
        System.out.println(myBox);


        System.out.println("*".repeat(repeating));
        System.out.println("<Выбор элемента с учетом веса>");
        SelectionWeight<Integer> mySel = new SelectionWeight<>(new Integer[]{1, 2, 3}, new int[]{1, 2, 10});
        System.out.println("Выбор случайного элемента с учетом веса: " + mySel.getRandom());


//        Application.run();


        System.out.println("*".repeat(repeating));
        System.out.println("<Задание на коллекции>\n");

        ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(1, 2, 4, 4));
        System.out.println("Удаление дубликатов: " + CollectionTask.removeDuplicate(myList));

        int n = 200000;
        int m = 20000;
        double tArrayList = CollectionTask.measureTime(new ArrayList<>(), n, m);
        double tLinkedList = CollectionTask.measureTime(new LinkedList<>(), n, m);
        System.out.println("Время работы ArrayList(" + n + ", " + m + ")" + " = " + tArrayList);
        System.out.println("Время работы LinkedList(" + n + ", " + m + ")" + " = " + tLinkedList);

//        var dict = CollectionTask.FrequencyDict();
//        System.out.println();
//        int count = 0;
//        for (Iterator<String> it = dict.keySet().stream().sorted().iterator(); it.hasNext(); ) {
//            Object s = it.next();
//            count += dict.get(s);
//            System.out.println(s + ": " + dict.get(s));
//        }
//        System.out.println(count);

        HashMap<Character, Integer> myDict = new HashMap<>();
        myDict.put('A', 1);
        var swapping = CollectionTask.Swap(myDict);
        System.out.println(swapping.get(1));
        Integer[][] twoArray = new Integer[][]{{3, 2, 2}, {1, 2}, {1}, {5, 3, 1, 0}};
        Iterator<Integer> it1 = new TwoDimensionalArrayIterator<>(twoArray);
        Object[] array = new Object[]{3, 1, 1, it1, 1, 3, 0, 4};
        Iterator it2 = new ArrayIterator(array);

        Object[][] array2 = new Object[][]{
                {3, 4, it2},
                {new TwoDimensionalArrayIterator<>(twoArray), 1, 0},
                {5, 1, new ArrayIterator<>(new String[]{"Hello", "Java", "and", "COFFEE", "!!"})},
                {2, 4, 0},
        };

        TwoDimensionalArrayIterator it3 = new TwoDimensionalArrayIterator(array2);
        Map<Character, Integer> d = Map.of('a', 1, 'b', 2);
        HashMap<Character, Integer> myD = new HashMap<>() {{
            put('a', 1);
            put('b', 2);

        }};

//        while (it1.hasNext()) {
//            System.out.print(it1.next() + " ");
//        }

        System.out.println();
        List<Integer> myL = Arrays.asList(4, 2, 6, 8, 0, 5);
        Integer[] arr = new Integer[myL.size()];
        Arrays.setAll(arr, e -> e);
        Arrays.sort(arr, (Comparator.comparingInt(myL::get)));
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
        System.out.println();


//        Arrays.stream(IntStream.range(0, myL.size()).toArray()).sorted((o1, o2) -> Integer.compare(o1, o2))

//        IteratorsIterator<Integer> twoDimIterator = new IteratorsIterator<>(iters);
//        while (twoDimIterator.hasNext()) {
//            System.out.print(twoDimIterator.next() + " ");
//        }
//        System.out.println();

//        Iterator It = new ArrayIterator(array);

        RecursiveIterator recIt = new RecursiveIterator(it3);

        FlatIterator flIt = new FlatIterator(recIt);
        while (flIt.hasNext()) {
            System.out.print(flIt.next() + " ");
        }

        System.out.println();
        HashMap<Car, Integer> cars = new HashMap<>();
        cars.put(new Passenger("BMW 321", "blue", 210, "up", 130, 1400000, "BMW"), 2);
        cars.put(new Passenger("Mercedes 213", "blue", 210, "up", 130, 1400000, "Mercedes"), 1);
        Garage garage = new Garage();
        garage.setCars(cars);
        garage.printSortKey();
        HashMap<Character, Function<Double, Double>> funcs = new HashMap<>();
        funcs.put('C', (x) -> x + 4);
        System.out.println(funcs.get('C').apply(4d));

        Temperature t = new Temperature(36.6);
        t.changeSign('K');
        System.out.println(t.getCurrentValue());


        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers1 = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers2 = {
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers3 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers4 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords)
        };
        TextAnalyzer[] textAnalyzers5 = {
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers6 = {
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords)
        };
        // тестовые комментарии
        String[] tests = new String[8];
        tests[0] = "This comment is so good.";                            // OK
        tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
        tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
        tests[4] = "This comment is so bad....";                          // SPAM
        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
        tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
        tests[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG
        TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3,
                textAnalyzers4, textAnalyzers5, textAnalyzers6};

        int numberOfAnalyzer; // номер анализатора, указанный в идентификаторе textAnalyzers{№}
        int numberOfTest = 0; // номер теста, который соответствует индексу тестовых комментариев
        for (String test : tests) {
            numberOfAnalyzer = 1;
            System.out.print("test #" + numberOfTest + ": ");
            System.out.println(test);
            for (TextAnalyzer[] analyzers : textAnalyzers) {
                System.out.print(numberOfAnalyzer + ": ");
                System.out.println(checkLabels(analyzers, test));
                numberOfAnalyzer++;
            }
            numberOfTest++;
        }

        UndoableStringBuilder g = new UndoableStringBuilder();
        StringBuilder ss = new StringBuilder();
        var appended = g.append("2145kss");
        g.insert(2, new char[]{'1', '3', 'a', 'j'}, 1, 3);
        g.appendCodePoint(55);
        System.out.println(g.toString());
        g.undo();
        System.out.println(g.toString());

        NotifyingStringBuilder notifyingStringBuilder = new NotifyingStringBuilder();
        notifyingStringBuilder.setNotifier(new myNotifier());
        notifyingStringBuilder.append("Hello");
        notifyingStringBuilder.append(", ");
        notifyingStringBuilder.append("World!");

//        var game = new CrossZero(3, 3);
//        game.run();

        Integer[] test = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(FilterArray(test, x -> x % 2 == 0)));

        Employees emp = new Employees();
        emp.add(new FixedSalary("Sergei", "Tkachev", 166400));
        emp.add(new HourlySalary("Artem", "Bakanov", 1000));

        for (Employee e : emp.getEmployees()) {
            System.out.println(e.getLastName() + " " + e.getFirstName() + " " + e.getAverageMonthlySalary());
        }


        //CAFE
        ArrayList<Food> menuForBar = new ArrayList<>(
                Arrays.asList(
                        new Food("Коктейль", "-", 110, 120),
                        new Food("Кола", "-", 100, 1000),
                        new Food("Пиво", "-", 130, 250)
                ));
        ArrayList<Food> menuForKitchen = new ArrayList<>(
                Arrays.asList(
                        new Food("Креветки", "-", 150, 250),
                        new Food("Бургер", "-", 150, 120),
                        new Food("Шашлык", "-", 240, 150),
                        new Food("Пицца", "-", 350, 250),
                        new Food("Блинчики", "-", 160, 200)
                ));

        ArrayList<Food> stopListOfCafe = new ArrayList<>(
                Arrays.asList(
                        menuForKitchen.get(0),
                        menuForKitchen.get(2),
                        menuForBar.get(0)
                ));

        Cafe cafe = new Cafe(menuForKitchen, menuForBar, stopListOfCafe);

        cafe.setKitchen(menuForKitchen); // Создание нового меню


        System.out.println("\nДОБАВЛЕНИЕ ЗАКАЗОВ\n");

        //Добавление блюд в заказ с учетом стоп листа из меню бара
        for (int i = 0; i < 10; i++) {
            cafe.addOrder(generateOrder(cafe.getBarToday()));
        }

        //Добавление блюда из меню кухни
        for (int i = 0; i < 10; i++) {
            cafe.addOrder(generateOrder(cafe.getKitchenToday()));
        }

        cafe.getOrders().forEach(order1 -> {
            System.out.println(order1 + "\n");
        });


        System.out.println("\nЗАКРЫТИЕ ЗАКАЗОВ\n");
        for (int i = 0; i < 4; i++) {
            cafe.closeOrder(cafe.getOrders().get(i));
        }

        cafe.getOrders().forEach(order1 -> {
            System.out.println(order1 + "\n");
        });


    }

    public static Order generateOrder(ArrayList<Food> menu) {
        Random random = new Random();
        int n = menu.size();

        Order order = new Order(new Date());
        for (int i = 0; i < 7; i++) {
            order.add(menu.get(random.nextInt(n)));
        }

        return order;
    }

    public static <T> T[] FilterArray(T[] array, Function<T, Boolean> filter) {
        int c = 0;
        for (int i = 0; i < array.length; i++) {
            if (filter.apply(array[i])) {
                array[c] = array[i];
                c++;
            }
        }
        return Arrays.copyOf(array, c);
    }

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            Label process = analyzer.processText(text);
            if (process != Label.OK)
                return process;
        }
        return Label.OK;
    }

}

