package ar.com.parcialUno;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class Last30DaysAdoptionsTest {

    @Test
    @DisplayName("The method must return the last 30 days adoptions ")
    public void last30DaysAdopt() {
        // Given
        ManagerAdoption adoptions = new ManagerAdoption();
        Employee myEmployee = Employee.getInstance("Ignacio", 34, "assistant");
        Adoptant myAdoptant = new Adoptant("Josefina", 33, "Rep. Dominica 3366");
        Pet miPet = new Dog("Vitto", "2020-01-01", 14.3, "dog");
        Pet miPet2 = new Cat("Sol", "2024-03-13", 4.3, "cat");
        Pet miPet3 = new Cat("Luna", "2020-01-01", 14.3, "cat");

        Adoption miAdoption = new DogAdoption(myEmployee, myAdoptant, miPet, LocalDate.of(2025,4,1));
        Adoption miAdoption2 = new CatAdoption(myEmployee, myAdoptant, miPet2, LocalDate.of(2025,5,7));
        Adoption miAdoption3 = new CatAdoption(myEmployee, myAdoptant, miPet3, LocalDate.of(2025,5,29));
        adoptions.addAdoption(miAdoption);
        adoptions.addAdoption(miAdoption2);
        adoptions.addAdoption(miAdoption3);

        // When
        adoptions.last30daysAdoptions();

        // Then
        Assertions.assertEquals(List.of(miAdoption2,miAdoption3),adoptions.last30daysAdoptions());


    }
}
