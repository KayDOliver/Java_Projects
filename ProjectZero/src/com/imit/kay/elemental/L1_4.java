package com.imit.kay.elemental;

import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.StrictMath.sqrt;
    /*1 0 -1*/
public class L1_4 {
    public static void main(String[] args) {
        double a, b, c, D;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Введите коэффициенты квадратного уравнения a, b, c:");
            a = in.nextDouble();
            b = in.nextDouble();
            c = in.nextDouble();
        }
        while (a == 0 && b == 0 && c == 0);


        if (a == 0 && b == 0 && c != 0) {
            System.out.println("Как ты до этого додумался? Нет решений тут. Решать нечего.");
            return;
        }

        /*варианты для странненьких*/
        if (a == 0 && c == 0 && b != 0) {
            System.out.println("x = 0");
            return;
        }
        if (a != 0 && c == 0 && b == 0) {
            System.out.println("x = 0");
            return;
        }

        /*вариант с а == 0*/
        if (a == 0 && b != 0 && c != 0) {
            System.out.println("x = " + (-1 * c) / b);
            return;
        }

        /*вариант с b == 0*/
        if (b == 0 && a != 0 && c != 0) {
            if (((-1 * c) / a) < 0)
                System.out.println("Решений нет");
            else {
                System.out.println("x1 = " + (-1)*sqrt(((-1 * c) / a)));
                System.out.println("x2 = " + sqrt(((-1 * c) / a)));
                return;
            }
        }

        /*вариант с == 0*/
        if (c == 0 && b != 0 && a != 0) {
            System.out.println("x1 = 0");
            System.out.println("x2 = " + (-1 * b) / a);
            return;
        }

            /*основа*/
            D = b * b - 4 * a * c;

            if (D == 0) {
                System.out.println("x = " + (-1 * b) / (2 * a));
                return;
            } else if (D > 0) {
                System.out.println("x1 = " + ((-b) - sqrt(D)) / (2 * a));
                System.out.println("x2 = " + ((-b) + sqrt(D)) / (2 * a));
            } else
                System.out.println("Решений нет");

        }
    }