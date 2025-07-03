package ar.com.parcialUno;

import ar.com.parcialUno.model.people.Adoptant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AdoptantTest {

    @Test
    @DisplayName("I create a list with two names: Juan and Ana and retrieve me a list of Juan and Ana")
    public void obtainAdoptants() {
        // Given
        ManagerAdoptans adoptants = new ManagerAdoptans();
        boolean adopts = adoptants.isEmpty();
        Adoptant anAdoptant = new Adoptant("Juan", 20, "Rivadavia 1307");
        Adoptant anAdoptant2 = new Adoptant("Ana", 20, "Rivadavia 1307");
        adoptants.addAdoptant(anAdoptant);
        adoptants.addAdoptant(anAdoptant2);

        // When
        adoptants.getNameAdoptants();

        // Then
        Assertions.assertEquals(true,adopts);
        Assertions.assertEquals("Juan",anAdoptant.getName());
        Assertions.assertEquals(List.of("Juan","Ana"), adoptants.getNameAdoptants());
    }
}
