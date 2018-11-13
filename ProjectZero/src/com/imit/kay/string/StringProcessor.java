package com.imit.kay.string;

import javafx.util.Pair;

import java.awt.*;
import java.security.InvalidParameterException;

public abstract class StringProcessor {
    public static String Copy(String s, int n) {
        if (n < 0)
            throw new InvalidParameterException();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(s);
        return sb.toString();
    }

    //throw new UnsupportedOperationException();
    public static int CountOf(String s1, String s2) {
        int k = 0;
        if (s2.length() == 0)
            return k;

        for (int i = 0; i < s1.length() - s2.length(); i++) {
            boolean end = true;
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    end = false;
                    break;
                }
            }
            if (end)
                k++;
        }
        return k;
    }

    public static String Change(String s1) {
        StringBuilder s_word = new StringBuilder();

        String s_one = "one";
        String s_two = "two";
        String s_three = "three";

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '1')
                s_word.append(s_one);
            else if (s1.charAt(i) == '2')
                s_word.append(s_two);
            else if (s1.charAt(i) == '3')
                s_word.append(s_three);
            else
                s_word.append(s1.charAt(i));
        }
        return s_word.toString();
    }

    public static void DeleteEven(StringBuilder s1) {
        //StringBuilder deleteCharAt(int index);

        for (int i = s1.length() - 1; i >= 0; i--) {
            if (i % 2 != 0)
                s1.deleteCharAt(i);
        }
    }
//*********************************************************************************************************
    /*  5.В строке типа StringBuilder поменяйте местами первое и последнее слова.
     *  Слова состоят из букв и разделяются произвольным числом пробелов,
     *  пробелы могут стоять также  в начале и в конце строки.
     */

    // 	isLetter() - буква

    // ___say__smthg_im___given_up___on_u___
    // s_fst == say
    // s_lst == u
    // s1 == ___u__smthg_im___given_up___on_say___

    public static void SpaceString(StringBuilder s1) {
        String[] res = s1.toString().split(" ");
        int p_fst_s =0;
        int p_fst_e =0;
        int p_lst_s =0;
        int p_lst_e =0;


        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != ' '){
                p_fst_s = i;
                p_fst_e = i+1;
                while (p_fst_e< s1.length() && s1.charAt(p_fst_e) !=' ')
                    p_fst_e++;
                break;
            }
        }

        for (int i = s1.length()-1; i >=0; i--) {
            if (s1.charAt(i) != ' '){
                p_lst_e = i+1;
                p_lst_s = i;
                while (p_lst_s>=0 && s1.charAt(p_lst_s) !=' ')
                    p_lst_s--;
                p_lst_s++;
                break;
            }
        }

        String fst = s1.substring( p_fst_s,p_fst_e);
        String lst = s1.substring( p_lst_s,p_lst_e);

        s1.replace( p_fst_s,p_fst_e, lst);
        s1.replace( p_lst_s,p_lst_e, fst);
    }


}