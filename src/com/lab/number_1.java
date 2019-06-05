package com.lab;
import java.util.ArrayList;

/******************************************************************************
 *  Compilation:  javac number_1.java
 *  Execution:    java number_1
 *  Dependencies:
 *
 *  Program arguments: "longggggg", "short", "average", "qwe", "zxcv""asdf", "qwe", "zxcv"... "etc";
 *  Output String[] - words, with legnth < average;
 *
 ******************************************************************************/

public class number_1 {

    public static void main(String[] args) {
        String[] list = lessThanAvarage(args);
        System.out.println("Length of the word < then average");
        for(String s: list){
            System.out.println(s);
        }
    }

    public static String[] lessThanAvarage(String[] strings) {
        int avarage = findAvarage(strings);
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() < avarage) {
                list.add(strings[i]);
            }
        }
        return list.toArray(new String[0]);
    }

    public static int findAvarage(String[] strings) {
        int total = 0;
        for (int i = 0; i < strings.length; i++) {
            total += strings[i].length();
        }
        return total / strings.length;
    }
}
