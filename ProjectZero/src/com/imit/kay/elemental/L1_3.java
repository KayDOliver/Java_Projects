package com.imit.kay.elemental;

import java.util.Scanner;

public class L1_3 {
    public static void main(String[] args) {
        int a, b, c;
        Scanner in = new Scanner(System.in);
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();



        System.out.println("Multiply: " + a * b * c);
        System.out.println("Arif: " + (a + b + c) / 3);

        if (a < b){
            if (a < c) {
                System.out.print(a + "  ");
                if (b < c)
                    System.out.println(b + "  " + c);
                else
                    System.out.println(c + "  " + b);
            }
            else
                System.out.println(c + "  " + a + "  " + b);
        }
        else {
            if (b < c) {
                System.out.print(b + "  ");
                if (a < c)
                    System.out.println(a + "  " + c);
                else
                    System.out.println(c + "  " + a);
            } else
                System.out.print(c + "  " + b + "  " + a);
        }
    }
}
