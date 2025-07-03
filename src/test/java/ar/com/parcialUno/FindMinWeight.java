package ar.com.parcialUno;

import ar.com.parcialUno.model.pets.Cat;
import ar.com.parcialUno.model.pets.Dog;
import ar.com.parcialUno.model.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FindMinWeight {

    @Test
    @DisplayName("I recive the list of peta with the minum weight that I set in the message parameter")
    public void findMinWeight() {
        // Give
        ManagerPets pets = new ManagerPets();
        Pet aPet = new Dog("Luna", "2020-07-12", 20.4,"Dog");
        Pet aPet2 = new Cat("Sol", "2020-07-12", 5.4,"Cat");
        Pet aPet3 = new Dog("Venus", "2020-07-12", 15.4,"Dog");
        Pet aPet4 = new Dog("Venus", "2020-07-12", 30.2,"Dog");
        pets.addAPet(aPet);
        pets.addAPet(aPet2);
        pets.addAPet(aPet3);
        pets.addAPet(aPet4);

        // When
        pets.weightPet(15.0);

        //Then
        Assertions.assertEquals(List.of(aPet,aPet3,aPet4),pets.weightPet(15.0));

    }
}
