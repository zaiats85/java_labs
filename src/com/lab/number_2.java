package com.lab;
import java.util.ArrayList;

/******************************************************************************
 *  Compilation:  javac number_2.java
 *  Execution:    java number_2
 *  Dependencies:
 *
 *  Program arguments: "longggggg short average qwe zxcv asdf ewe zxcv etc";
 *  Output String[] - words, with chars consequently increasing
 *
 ******************************************************************************/

public class number_2 {
    public static void main(String[] args) {

        // Get words from command arguments input row
        String[] words = splitRow(args[0]);

        // Init structure for checked words
        ArrayList<String> list = new ArrayList<String>();

        // Check every word
        for (int i = 0; i < words.length; i++) {

            // consequent ???
            if(checkIfConsequent(words[i])) {
                list.add(words[i]);
            }

        }

        // Output the result
        for(String s: list){
            System.out.println(s);
        }
    }

    public static Boolean checkIfConsequent(String word){

        int tmp = 0;
        int i = 0;
        int length = word.length();

        // iterating over an array
        while(i < length ){
            int asci = (int) word.charAt(i++);
            if(tmp > asci){
                return false;
            }
            tmp = asci;
        }

        return true;
    }

    public static String[] splitRow(String row) {
        String[] words = row.split("\\s+");
        return words;
    }
}
