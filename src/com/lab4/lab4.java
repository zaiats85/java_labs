/******************************************************************************
 *  Compilation:  javac lab4.java
 *  Execution:    java  lab4
 *  Dependencies:
 *  Data files:
 *
 *  Lab 4 creating lab4 with Aviaries for different animals.
 *
 ******************************************************************************/
package com.lab4;

public class lab4 {
    public static void main(String[] args){
        Aviary<Birds> birdsCage = new Aviary<Birds>(52);
        Aviary<Ungulates> ungulatesCage = new Aviary<Ungulates>(32);
        Aviary<Lion> lionsCage = new Aviary<Lion>(8);

        Zoo zoo = new Zoo();
        zoo.addAviary(birdsCage);
        zoo.addAviary(ungulatesCage);
        zoo.addAviary(lionsCage);

        /*compile errors cannot be applied to <E>
        cant do that now buddy, sorry no js.*/
        // birdsCage.add(new Lion());
        // birdsCage.add(new Mammal());
        // ungulatesCage.add(new Eagle());
        // ungulatesCage.add(new Lion());
        // birdsCage.add(new Geeraffe());
        // birdsCage.add(new Zeebra());

        /*Successfully add bird to birdsCage*/
        birdsCage.add(new Birds());

        /*Successfully add mammals to mammalsCage*/
        ungulatesCage.add(new Zeebra());
        ungulatesCage.add(new Geeraffe());

        /*Successfully add lion to lionsCage*/
        lionsCage.add(new Lion());

        /*Show capacity*/
        System.out.printf("Mammals Cage has %d animals capacity \n", ungulatesCage.getCapacity());
        System.out.printf("Birds Cage has %d animals capacity \n", birdsCage.getCapacity());
        System.out.printf("Lions Cage has %d animals capacity \n", lionsCage.getCapacity());

        /*Show occupied*/
        System.out.printf("Mammals Cage holds %d animals \n", ungulatesCage.getOccupied());
        System.out.printf("Birds Cage holds %d animals \n", birdsCage.getOccupied());
        System.out.printf("Lions Cage holds %d animals \n", lionsCage.getOccupied());

        System.out.printf("Total animals at the zoo: %d\n", zoo.getCountOfAnimals());

        Lion leo = new Lion();

        // Try removing leo while he is not in the cage
        lionsCage.remove(leo);

        /*Overload test*/
        /*int i = 0;
        while (i < mammalsCage.getCapacity()) {
            mammalsCage.add(new Zeebra());
            i++;
        }

        while (i < birdsCage.getCapacity()) {
            birdsCage.add(new Birds());
            i++;
        }

        while (i < birdsCage.getCapacity()) {
            lionsCage.add(new Lion());
            i++;
        }*/

    }
}
