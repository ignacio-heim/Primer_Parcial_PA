package ar.com.parcialUno;

import ar.com.parcialUno.model.pets.Cat;
import ar.com.parcialUno.model.pets.Dog;
import ar.com.parcialUno.model.pets.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConcatNamePetsTest {

    @Test
    @DisplayName("I send a string of names and I recieve a string of names separete by coma")
    public void concatNamePetsTest() {
        // Given
        ManagerPets pets = new ManagerPets();
        Pet aPet = new Dog("Luna", "2020-07-12", 20.4,"Dog");
        Pet aPet2 = new Cat("Sol", "2020-07-12", 5.4,"Cat");
        Pet aPet3 = new Dog("Venus", "2020-07-12", 15.4,"Dog");
        Pet aPet4 = new Dog("Saturno", "2020-07-12", 30.2,"Dog");
        pets.addAPet(aPet);
        pets.addAPet(aPet2);
        pets.addAPet(aPet3);
        pets.addAPet(aPet4);

        // When
        String namesByComa = pets.namesSeparateByComa();

        // Then
        Assertions.assertEquals("Luna, Sol, Venus, Saturno", namesByComa);
    }
}
