package com.imit.kay.objects;

public class Main {
    public static void main(String[] args) {

        Payment zero = new Payment();
        Payment fst = new Payment("Семаев Ринат Парфенович",
                500000, 2014, 12, 2);
        Payment snd = new Payment("Сергеев Федор Петрович",
                5869500, 2018, 2, 15);
        Payment copy = new Payment(snd);

        System.out.println(zero.toString());

        System.out.println(copy.getName());
        copy.setName("Федоров Петр Сергеевич");
        System.out.println(snd.equals(copy));


    }
}
