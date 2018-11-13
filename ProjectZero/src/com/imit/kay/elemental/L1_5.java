package com.imit.kay.elemental;

import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.Math.sin;

public class L1_5 {
    /*0.1 1 2*/

    public static void main(String[] args) {
        double h, l, r;
        Scanner in = new Scanner(System.in);
        h = in.nextDouble();
        l = in.nextDouble(); //сравнить левое с правым
        r = in.nextDouble();

        /*вариант для совсем отбитых*/
        if (h == 0 && l == 0 && r == 0){
            System.out.println("Давай-ка еще разок");
            h = in.nextDouble();
            l = in.nextDouble();
            r = in.nextDouble();
        }

        if (h == 0 || h < 0){
            System.out.println("Шаг должеш быть больше 0");
            h = in.nextDouble();
        }

        if (l > r){
            l = l + r;
            r = l - r;
            l = l - r;
        }

        System.out.println("Sin x на проомежутке от " + l + " до " + r + " с шагом " + h);

        for (double i = l; i <= r || Math.abs(i - r) < 1e-9; i+=h) {
            System.out.format( "%.8f значение синуса %.10f \n", i, sin(i));
        }
    }
}
