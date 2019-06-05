package com.Zoo;

import java.util.ArrayList;
import java.util.List;

class Aviary<E> {
    private int capacity;
    private List<E> aviary = new ArrayList<E>();

    // set initial capacity
    Aviary(int capacity){
        this.capacity = capacity;
    }

    // adds animal to avial
    public void add(E animal){
        if(isFull()){
            throw new ArithmeticException("Aviary is full. Please try again later");
        }
        aviary.add(animal);
    }

    // get by index
    public E getItem(int index) {
        return aviary.get(index);
    }

    // removes animal from avial
    public void remove(E animal){
        try{
            aviary.remove(animal);
        } catch (Exception e){
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
