package com.lab4;

import java.util.*;

class Zoo {

    public List<Aviary> aviaries = new ArrayList<Aviary>();

    public int getCountOfAnimals(){
        int count = 0;
        for(Aviary x : aviaries ) count += x.getOccupied();
        return count;
    };

    public void addAviary(Aviary aviary){
        aviaries.add(aviary);
    }

}
