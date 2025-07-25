package ar.com.parcialUno.model.adoptions;

import ar.com.parcialUno.model.pets.Pet;
import ar.com.parcialUno.model.people.Adoptant;
import ar.com.parcialUno.model.people.Employee;

import java.time.LocalDate;

public class DogAdoption extends Adoption {

    public DogAdoption(Employee anEmployee, Adoptant anAdoptant, Pet aPet) {
        super(anEmployee, anAdoptant, aPet);
    }

    /*
    @Override
    public void verificarVacunas() {
        System.out.println("Vacunas de perros");
    }

    @Override
    public void ofrecerRecomendaciones() {
        System.out.println("Recomendaciones para perros");
    }
      */
    public void vacunasObligatorias() {
        System.out.println("Vacunas");
    }
}
