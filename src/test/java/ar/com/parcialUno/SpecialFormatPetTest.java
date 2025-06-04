package ar.com.parcialUno;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class SpecialFormatPetTest {

    @Test
    @DisplayName("Display the name and specie of the pet")
    public void newFormatPet() {
        // Given
        ManagerPets pets = new ManagerPets();
        Pet aPet = new Dog("Luna", "2020-07-12", 20.4,"Dog");
        //Pet aPet2 = new Cat("Sol", "2020-07-12", 20.4,"Cat");
        //Pet aPet3 = new Dog("Venus", "2020-07-12", 20.4,"Dog");
        pets.addAPet(aPet);
        //pets.addAPet(aPet2);
        //pets.addAPet(aPet3);

        // When
        pets.newFormatPet();

        // Then
        Assertions.assertEquals(Map.of("Luna", "Dog"),pets.newFormatPet());
    }
}
