/******************************************************************************
 *  Compilation:  javac Zoo.java
 *  Execution:    java  Zoo
 *  Dependencies:
 *  Data files:
 *
 *  Lab 4 creating Zoo with Aviaries for different animals.
 *
 ******************************************************************************/
package com.Zoo;

import java.util.*;

public class Zoo {
    public List<Aviary> aviaries = new ArrayList<Aviary>();

    public int getCountOfAnimals(){
        return 123;
    };

    public void addAviary(Aviary aviary){
        this.aviaries.add(aviary);
    }

    public static void main(String[] args){
        Aviary<Birds> birds = new Aviary<Birds>(52);
        Aviary<Mammal> mammals = new Aviary<Mammal>(32);

        // compile error cannot be applied to Birds
        // birds.add(new Lion());
        // birds.add(new Mammal());
        // mammals.add(new Eagle());
        // mammals.add(new Birds());
        // birds.add(new Geeraffe());
        // birds.add(new Zeebra());

        birds.add(new Birds());
        mammals.add(new Lion());
        mammals.add(new Ungulates());
        mammals.add(new Zeebra());
        mammals.add(new Geeraffe());

        Zoo zoo = new Zoo();


        System.out.printf("(CustomList)Integer Value :%d\n", list.getItem(0).getName());

    }
}
