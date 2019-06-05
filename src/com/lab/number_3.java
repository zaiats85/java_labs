package com.lab;

public class number_3 {

    int x = 5;
    int y = 32;

    public static void main(String[] args) {
        number_3 myObj = new number_3();
        System.out.println(myObj.x);
        System.out.println(myObj.sum(32,4));
    }

    public int sum(int a, int b){
        return a + b;
    }

}
