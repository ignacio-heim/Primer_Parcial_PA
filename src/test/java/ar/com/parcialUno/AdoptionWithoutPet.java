package ar.com.parcialUno;

import ar.com.parcialUno.model.adoptions.Adoption;
import ar.com.parcialUno.model.adoptions.CatAdoption;
import ar.com.parcialUno.model.adoptions.DogAdoption;
import ar.com.parcialUno.model.people.Adoptant;
import ar.com.parcialUno.model.people.Employee;
import ar.com.parcialUno.model.pets.Cat;
import ar.com.parcialUno.model.pets.Dog;
import ar.com.parcialUno.model.pets.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AdoptionWithoutPet {

    @Test
    @DisplayName("Check if there is an adoptation without pet associaton")
    public void adoptPet() {
        // Given
        ManagerAdoption adoptions = new ManagerAdoption();
        Employee myEmployee = Employee.getInstance("Ignacio", "Perez",34, "assistant");
        Adoptant myAdoptant = new Adoptant("Josefina", "Perez",33, "Rep. Dominica 3366");
        Pet miPet = new Dog("Vitto", "2020-01-01", 14.3, "dog");
        Pet miPet2 = new Cat("Sol", "2024-03-13", 4.3, "cat");
        //Pet miPet3 = new Cat("Luna", "2020-01-01", 14.3, "cat");

        Adoption miAdoption = new DogAdoption(myEmployee, myAdoptant, miPet, LocalDate.of(2025,4,1));
        Adoption miAdoption2 = new CatAdoption(myEmployee, myAdoptant, miPet2, LocalDate.of(2025,5,7));

        // Add a pet null
        Adoption miAdoption3 = new CatAdoption(myEmployee, myAdoptant, null, LocalDate.of(2025,5,29));

        adoptions.addAdoption(miAdoption);
        adoptions.addAdoption(miAdoption2);
        adoptions.addAdoption(miAdoption3);

        // When
        adoptions.adoptionWithoutPet();
        adoptions.messageAdoptionWihoutPet();

        // Then
        Assertions.assertEquals(false, adoptions.adoptionWithoutPet());
        //Assertions.assertEquals("Everything is ok", adoptions.messageAdoptionWihoutPet());
        Assertions.assertEquals("There are adoptions without a pet", adoptions.messageAdoptionWihoutPet());
    }

}
