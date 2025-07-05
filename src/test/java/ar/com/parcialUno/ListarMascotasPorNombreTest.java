package ar.com.parcialUno;

import ar.com.parcialUno.model.pets.Cat;
import ar.com.parcialUno.model.pets.Dog;
import ar.com.parcialUno.model.pets.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ListarMascotasPorNombreTest {

    @Test
    @DisplayName("List of pets and I retrive a list of pets, sorting by name")
    public void listarMascotasPorNombre() {
        // Given
        ManagerPets pets = new ManagerPets();
        Pet aPet = new Dog("Luna", "2020-07-12", 20.4,"Dog");
        Pet aPet2 = new Cat("Sol", "2020-07-12", 20.4,"Cat");
        Pet aPet3 = new Dog("Venus", "2020-07-12", 20.4,"Dog");
        pets.addAPet(aPet);
        pets.addAPet(aPet2);
        pets.addAPet(aPet3);

        // When
        pets.sortNames();

        // Then
        //Assertions.assertEquals(List.of("Sol", "Luna", "Venus"),pets.sortNames()); // This fail
        Assertions.assertEquals(List.of("Luna", "Sol", "Venus"),pets.sortNames()); // This fail
    }

}
