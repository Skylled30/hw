package com.company;

public class Main {

    public static void main(String[] args) {
        Strings strings = new Strings();
        strings.add("hello");
        strings.add("mind");
        strings.add("laptop");

        System.out.println("Строка максимальной длины: " + strings.getMax());
        System.out.println("Среднее: " + strings.getAverage());
    }
}
