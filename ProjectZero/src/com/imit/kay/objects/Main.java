package com.imit.kay.objects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

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

        FinanceReport report1 = new FinanceReport();
        try {
            report1.ReadFromStream(new FileInputStream("Input.txt"));
        } catch (FileNotFoundException e) {
        }
        report1.WriteToStream(System.out);
        System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        report1.StartsWith(System.out, 'п');
        System.out.println("\n/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        report1.LessThen(System.out, 700000);
        System.out.println("\n/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        System.out.println(report1.SumInMonth("17.06.08"));
        System.out.println("\n/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        System.out.println(report1.SumInMonth("02.11.75"));
    }
}
