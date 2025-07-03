package ar.com.parcialUno;

import ar.com.parcialUno.model.people.Adoptant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AverageAgeAdoptantTest {

    @Test
    @DisplayName("I create a list of adoptants and the program retrieve me the avg of ages")
    public void avgAgeAdopt() {
        // Given
        ManagerAdoptans adoptants = new ManagerAdoptans();
        boolean adopts = adoptants.isEmpty();
        Adoptant anAdoptant = new Adoptant("Juan", 20, "Rivadavia 1307");
        Adoptant anAdoptant2 = new Adoptant("Ana", 25, "Rivadavia 1307");
        adoptants.addAdoptant(anAdoptant);
        adoptants.addAdoptant(anAdoptant2);

        // When
        Double avgAge = adoptants.avgAgeAdopt();

        // Then
        Assertions.assertEquals(22.5, avgAge);
    }
}
