package com.imit.kay.string;

import java.security.InvalidParameterException;

public class Main {

    public static void main(String[] args) {
        System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        System.out.println("Tests for Copy method");
        assert (StringProcessor.Copy("a", 3).equals("aaa")) : "Copy n times";
        assert (StringProcessor.Copy("a", 0).equals("")) : "Copy 0 times";

        try {
            StringProcessor.Copy("a", -1);
            assert (false) : "Copy negative not exception";
        } catch (InvalidParameterException ex) {
        }
        System.out.println("Copy method tests successful");

        System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        System.out.println("Tests for CountOf method");
        assert (StringProcessor.CountOf("aabaaac", "aa") == 3): "CountOf 3 times";
        assert (StringProcessor.CountOf("aabaaac", "bc") == 0): "CountOf 0 times";
        assert (StringProcessor.CountOf("aabaaac", "") == 0): "CountOf 0 times";
        assert (StringProcessor.CountOf("", "") == 0): "CountOf 0 times";
        System.out.println("CountOf method tests successful");

        System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        System.out.println("Tests for Change method");
        assert (StringProcessor.Change("11111").equals("oneoneoneoneone")): "Test 1";
        assert (StringProcessor.Change("222").equals("twotwotwo")): "Test 2";
        assert (StringProcessor.Change("333333").equals("threethreethreethreethreethree")): "Test 3";
        assert (StringProcessor.Change("123123").equals("onetwothreeonetwothree")): "Test 4";
        assert (StringProcessor.Change("33211233221").equals("threethreetwooneonetwothreethreetwotwoone")) : "Test 5";
        assert (StringProcessor.Change("225").equals("twotwo5")): "Test 6";
     //   assert false: "15";

        System.out.println("Change method tests successful");

        System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        System.out.println("Tests for DeleteEven method");
        StringBuilder s_test = new StringBuilder("garogosh");
        StringProcessor.DeleteEven(s_test);
        assert (s_test.toString().equals("grgs")): "Test 1";
        System.out.println("DeleteEven method tests successful");

    //*********************************************************************************************************

        System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        System.out.println("Tests for SpaceString method");

        s_test = new StringBuilder();
        StringProcessor.SpaceString(s_test);
        assert (s_test.toString().equals("")) : "Test 1";

        s_test = new StringBuilder("     ");
        StringProcessor.SpaceString(s_test);
        assert (s_test.toString().equals("     ")) : "Test 2";

        s_test = new StringBuilder(" kukuruza   ");
        StringProcessor.SpaceString(s_test);
        assert (s_test.toString().equals(" kukuruza   ")) : "Test 3";

        s_test = new StringBuilder("   a  b      c     ");
        StringProcessor.SpaceString(s_test);
        assert (s_test.toString().equals("   c  b      a     ")) : "Test 4";

        s_test = new StringBuilder("say  smthg im   given up   on u");
        StringProcessor.SpaceString(s_test);
        assert (s_test.toString().equals("u  smthg im   given up   on say")) : "Test 5";

        System.out.println("SpaceString method tests successful");
    }



}
