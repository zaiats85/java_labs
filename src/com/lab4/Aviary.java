package com.lab4;

import java.util.ArrayList;
import java.util.List;

class Aviary<E> {
    private int capacity;
    private List<E> aviary;

    // set initial capacity
    Aviary(int capacity){
        this.capacity = capacity;
        this.aviary = new ArrayList<E>();
    }

    public static void printAll(List<?> list) {
        for (Object item : list)
            System.out.println(item + " ");
    }

    // adds animal to avial
    public void add(E animal) throws ArrayIndexOutOfBoundsException{
        if(isFull()){
            throw new ArrayIndexOutOfBoundsException("Aviary is full. Please try again later");
        }
        aviary.add(animal);
    }

    // get by index
    public E getItem(int index) {
        return aviary.get(index);
    }

    // removes animal from avial
    public void remove(E animal) throws IllegalStateException {
        if (aviary.contains(animal)) {
            aviary.remove(animal);
        } else {
            throw new IllegalStateException("There is no such animal at the aviary");
        }
    }

    // get initial aviary capacity
    int getCapacity(){
        return capacity;
    }

    // get occupiedPlaces
    int getOccupied(){
        return aviary.size();
    }

    // check if is full
    private Boolean isFull(){
        return getOccupied() >= capacity;
    }

}
