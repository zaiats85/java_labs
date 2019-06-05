package com.lab;
import com.google.gson.*;
import nl.jqno.equalsverifier.*;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public final class Person {

    private final String species;
    private final int age;
    private final String name;

    //Idea from effective Java : Item 9
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + age;
        result = 31 * result + Objects.hashCode(species);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "Person {species: " + species  + '\'' + ", age:" + age + ", name:" + name + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Person person = (Person) obj;
        return age == person.age && Objects.equals(species, person.species) && Objects.equals(name, person.name);
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
        this.species = "Homo Sapiens";
    }

    /*
      Demostrate diff between
      reference comparison and
      content comparison
    */
    public void comparison(){
        /*Integer check*/
        System.out.println(10 == 20);

        /*Char-type*/
        System.out.println('a' == 'b');

        /*Char and double type*/
        System.out.println('a' == 97.0);

        /*Boolean type*/
        System.out.println(true == true);

        /*Equals simple*/
        System.out.println("Stanislav".equals("Stanislav"));
    }

    public static void main(String[] args){
        /*Instantiate Person*/
        Person oleg = new Person("oleg", 33);
        Person dariya = new Person("dariya", 30);
        Person stanislav = new Person("stanislav", 3);

        System.out.println(oleg.equals(oleg));
        System.out.println(dariya.equals(stanislav));
        System.out.println(stanislav.equals(new Object()));

        /*Convert to JSON*/
        Gson gson = new Gson();

        /*Serialize to JSON*/
        String serializedPerson = gson.toJson(oleg);

        /*Deserialize from JSON*/
        Person deSerializedPerson = gson.fromJson(serializedPerson, Person.class);

        /*Check equality of initial and deserialized objects*/
        System.out.println(oleg.equals(deSerializedPerson));
        oleg.equalsContract();
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Person.class)
                .verify();
    }
}
