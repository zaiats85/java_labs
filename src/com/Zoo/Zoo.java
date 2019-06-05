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
        int allAnimals = 0;

        for(Aviary element: aviaries){
            allAnimals += element.getOccupied();
            System.out.println(element);
        }

        return 123;
    };

    public void addAviary(Aviary aviary){
        this.aviaries.add(aviary);
    }

    public static void main(String[] args){
        Aviary kozlu = new AviaryUngulates(32);
        Aviary lions = new AviaryLion(42);
        Aviary birds = new AviaryBirds(12);
        Aviary mammals = new AviaryMammal(52);

        Zoo zoo = new Zoo();

        zoo.addAviary(new AviaryUngulates(32));
        zoo.addAviary(new AviaryLion(42));
        zoo.addAviary(new AviaryBirds(12));
        zoo.addAviary(new AviaryMammal(52));

        Ungulates kozel = new Ungulates();

        mammals.addAnimal(kozel);
        for (int i = 0; i < 5; i++) {
            mammals.addAnimal(new Mammal());
        }

        for (int i = 0; i < 12; i++) {
            birds.addAnimal(new Eagle());
        }

        for (int i = 0; i < 12; i++) {
            kozlu.addAnimal(new Ungulates());
        }

        mammals.showAnimals();
        kozlu.showAnimals();
        birds.showAnimals();

        System.out.printf("%d%n", kozlu.getCapacity());
        System.out.printf("%d%n", lions.getCapacity());
        System.out.printf("%d%n", birds.getCapacity());
        System.out.printf("%d%n", mammals.getCapacity());
        System.out.printf("Animals occupied: %d places %n", mammals.getOccupied());
        System.out.printf("All animals at the zoo: %d", zoo.getCountOfAnimals());
    }
}

//class number_4 {
//
//    public static <T extends Number & Comparable<T>> T maximum(T x, T y, T z){
//        T max = x;
//
//        if(y.compareTo(max) > 0){
//            max = y;
//        }
//
//        if(z.compareTo(max) > 0){
//            max = z;
//        }
//
//        return max;
//    }
//
//    public static double sum(List<? extends Number> numberList){
//        double sum = 0.0;
//        for(Number n: numberList) sum += n.doubleValue();
//        return sum;
//    }
//
//    public static void main (String[] args){
//
//        List<Integer> integerList = Arrays.asList(1, 2, 3);
//        System.out.println("sum = " + sum(integerList));
//
//        List<Double> doubleList = Arrays.asList(1.2, 2.3, 3.5);
//        System.out.println("sum = " + sum(doubleList));
//
//        Map<Integer,Integer> integerMap
//                = new HashMap<Integer,Integer>();
//
//        integerMap.put(1, 10);
//        integerMap.put(2, 11);
//
//        // iterate keys.
//        Iterator<Integer> integerIterator   = integerMap.keySet().iterator();
//
//        while(integerIterator.hasNext()) {
//            System.out.printf("Integer Value :%d\n", integerIterator.next());
//        }
//
//        System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5, maximum( 3, 4, 5 ));
//        //System.out.printf("Max of %s, %s and %s is %s\n","pear", "apple", "orange", maximum("pear", "apple", "orange"));
//
//        // Create arrays of Integer, Double and Char;
//        Integer[] intArray = {1,2,3,4,5,1,2,3,4,};
//        Character[] charArray = {'O','L','E','G'};
//        Double[] doublesArray = {1.1, 2.2, 3.3, 4.4};
//
//        System.out.println("Array integerArray contains:");
//        printArray(intArray);
//
//        System.out.println("Array charArray contains:");
//        printArray(charArray);
//
//        System.out.println("Array doublesArray contains:");
//        printArray(doublesArray);
//
//        Box<Integer, String> box = new Box<Integer, String>();
//        box.add(Integer.valueOf(10), "Hello Generic");
//
//        box.set(Integer.valueOf(10));
//        System.out.printf("Integer Value :%d\n", box.getFirst());
//
//        System.out.printf("Integer value: %d\n", box.getFirst());
//        System.out.printf("String value: %s\n", box.getSecond());
//
//        Pair<String, Integer> pair = new Pair<String, Integer>();
//        pair.addKeyValue("1", Integer.valueOf(1213120));
//        System.out.printf("(Pair)Integer Value :%d\n", pair.getValue("1"));
//
//        Box rawbox = new Box();
//
//        rawbox = box;
//        System.out.printf("Integer Value :%d\n", rawbox.getFirst());
//
//        CustomList <Box> list = new CustomList<Box>();
//        list.addItem(box);
//
//        Box<Integer, List<String>> box2 = new Box<Integer, List<String>>();
//
//        List<String> messages = new ArrayList<String>();
//
//        messages.add("Hi");
//        messages.add("Hello");
//        messages.add("Bye");
//
//        box2.add(Integer.valueOf(10),messages);
//        System.out.printf("Integer Value :%d\n", box2.getFirst());
//        System.out.printf("String Value :%s\n", box2.getSecond());
//
//    }
//}


class Box <T, S> {
    private T t;
    private S s;

    public void set(T t){
        this.t = t;
    }

    public void add(T t, S s){
        this.t = t;
        this.s = s;
    }

    public T getFirst(){
        return t;
    }

    public S getSecond(){
        return s;
    }

}

class Pair <K, V> {
    private Map<K, V> map = new HashMap<K, V>();

    public void addKeyValue(K key, V value){
        map.put(key, value);
    }

    public V getValue(K key){
        return map.get(key);
    }

}

class CustomList <E> {
    private List<E> list = new ArrayList<E>();

    public void addItem(E value){
        list.add(value);
    }

    public E getItem(int index){
        return list.get(index);
    }
}