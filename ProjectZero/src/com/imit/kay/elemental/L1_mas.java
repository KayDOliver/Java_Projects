package com.imit.kay.elemental;

import java.util.Scanner;

public class L1_mas {
    public static void main(String[] args) {
        int n;

        //9
        int m[] = NewMass();
        System.out.println(" \n /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/* \n");

        //8
        RetMass(m);
        System.out.println(" \n /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/* \n");

        //10
        System.out.println("Sum is: " + Sum(m));
        System.out.println(" \n /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/* \n");

        //11
        System.out.println("Count of even elements in mass: " + Even(m));
        System.out.println(" \n /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/* \n");

        //12
        Scanner in = new Scanner(System.in);

        System.out.println("Enter interval of segment: \n");
        int a, b;
        a = in.nextInt();
        b = in.nextInt();

        System.out.println("The number of array elements belonging to the segment [a; b] is: "
                                                                          + Segment(m, a, b));
        System.out.println(" \n /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/* \n");

        //13
        System.out.println("All elements is positive: " + Positive(m));
        System.out.println(" \n /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/* \n");

        //14
        Turn(m);
        System.out.println(" \n /*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/* \n");


    }

    public static int[] NewMass() {
        Scanner in = new Scanner(System.in);

        System.out.println("Input count of elements");
        int n = in.nextInt();
        int m[] = new int[n];

        for (int i = 0; i < n; i++)
            m[i] = in.nextInt();

        return m;
    }

    public static void RetMass(int m[]) {
        for (int i : m)
            System.out.print(i + " ");            //Точно ли i?
        System.out.println();
    }

    public static int Sum(int m[]) {
        int sum = 0;
        for (int i : m)
            sum = sum + i;                        //Точно ли i?

        return sum;
    }

    public static int Even(int m[]) {
        int even = 0;
        for (int i : m)
            if (i % 2 == 0)                       //Точно ли i?
                even++;

        return even;
    }

    public static int Segment(int m[], int a, int b){

        int seg = 0;
        if (a > b){
            a = a + b;
            b = a - b;
            a = a - b;
        }

        for (int i : m){
            if (i > a && i < b || i ==a || i == b)
                seg++;
        }

        return seg;
    }

    public static boolean Positive(int m[]) {
        for (int i : m)
            if (i < 0) {
                return false;
            }
        return true;
    }

    public static void Turn(int m[]){
        int n = m.length;
        //if (n%2==0){
            for (int i = 0; i < n/2; i++){
                int buff = m[i];
                m[i]=m[n-1-i];
                m[n-1-i]=buff;
            }
      //  }


        for (int i : m)
            System.out.print(i + " ");            //Точно ли i?
        System.out.println();
    }
















}
