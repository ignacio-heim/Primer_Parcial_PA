package ar.com.parcialUno;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class CountSpecieTest {

    @Test
    @DisplayName("Count how many speacie the are in my list of species")
    public void countSpecie() {
            // Given
            ManagerPets pets;
            pets = new ManagerPets();
            Pet aPet = new Dog("Luna", "2020-07-12", 20.4,"Dog");
            Pet aPet2 = new Cat("Sol", "2020-07-12", 20.4,"Cat");
            Pet aPet3 = new Dog("Venus", "2020-07-12", 20.4,"Dog");
            pets.addAPet(aPet);
            pets.addAPet(aPet2);
            pets.addAPet(aPet3);

            // When
            Map<String, Long> count = pets.returnSpecie();

            // Then
            Assertions.assertEquals(2,count.get("Dog"));
            Assertions.assertEquals(1,count.get("Cat"));
    }
}
