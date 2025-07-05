package ar.com.parcialUno.model.adoptions;

import ar.com.parcialUno.model.pets.Pet;
import ar.com.parcialUno.model.people.Adoptant;
import ar.com.parcialUno.model.people.Employee;

import java.time.LocalDate;

public class CatAdoption extends Adoption {

    public CatAdoption(Employee anEmployee, Adoptant anAdoptant, Pet aPet, LocalDate aDate) {
        super(anEmployee, anAdoptant, aPet, aDate);
    }

    @Override
    public void verificarVacunas() {
        System.out.println("Vacunas de gatos");
    }

    @Override
    public void ofrecerRecomendaciones() {
        System.out.println("Recomendaciones para gatos");
    }


    public void entregarArenero () {
        System.out.println("Se ha entregado el arenero");
    }
}
