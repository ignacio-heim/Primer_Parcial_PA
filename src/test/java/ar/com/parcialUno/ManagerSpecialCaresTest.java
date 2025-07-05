package ar.com.parcialUno;

import ar.com.parcialUno.model.pets.Dog;
import ar.com.parcialUno.model.pets.Pet;
import ar.com.parcialUno.model.pets.states.ManagerSpecialCares;
import ar.com.parcialUno.model.pets.states.SpecialCares;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ManagerSpecialCaresTest {

    @Test
    @DisplayName("I create a list of Pets with special needs and retrieve me a list of pets with special needs")
    public void SpecialCaresPetList() {
        // Given
        ManagerSpecialCares specialCaresPets = new ManagerSpecialCares();
        Pet aPet = new Dog("Luna", "2020-07-12", 20.4,"Dog");
        aPet.setActualState(new SpecialCares());
        Pet aPet2 = new Dog("Vitto", "2015-01-12", 13.4,"Dog");
        aPet.setActualState(new SpecialCares());

        // When
        boolean pets = specialCaresPets.isEmpty();
        specialCaresPets.addPet(aPet);
        specialCaresPets.addPet(aPet2);
        specialCaresPets.getAll();


        // Then
        Assertions.assertEquals(true, pets);
        Assertions.assertEquals(List.of(aPet,aPet2), specialCaresPets.getAll());


    }


}
