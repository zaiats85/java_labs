package com.Zoo;

import java.util.ArrayList;
import java.util.Objects;

abstract class Aviary<T> {
    private int capacity;
    private ArrayList<? super Animal> aviary = new ArrayList<>();

    Aviary(int capacity){
        this.capacity = capacity;
    }

    public void showAnimals() {
        this.aviary.stream()
                .filter(Objects::nonNull)
                .forEach(System.out::println);
    }

    public void addAnimal(Animal animal){
        if(this.getOccupied() < this.capacity){
            this.aviary.add(animal);
        } else {
            throw new ArithmeticException("Aviary is full. Please try again later");
        }
    }

    public void removeAnimal(Animal animal){
        try{
            this.aviary.remove(animal);
        } catch (Exception e){
            throw new IllegalStateException("There is no such animal at the aviary");
        }
    }

    // get initial aviary capacity
    int getCapacity(){
        return capacity;
    }

    int getOccupied(){
        return this.aviary.size();
    }
}
