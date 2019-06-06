package com;
import java.util.*;

public class lab5 {
    public static void main(String[] args) {

        List<String> mylist = new ArrayList<String>();
        mylist.add("practice");
        mylist.add("code");
        mylist.add("code");
        mylist.add("quiz");
        mylist.add("geeksforgeeks");

        int freq = Collections.frequency(mylist, "code");
        System.out.println(freq);
    }
}
