package ar.com.parcialUno;

import java.time.LocalDate;

public class DogAdoption extends Adoption {

    public DogAdoption(Employee anEmployee, Adoptant anAdoptant, Pet aPet, LocalDate aDate) {
        super(anEmployee, anAdoptant, aPet, aDate);
    }

    @Override
    public void verificarVacunas() {
        System.out.println("Vacunas de perros");
    }

    @Override
    public void ofrecerRecomendaciones() {
        System.out.println("Recomendaciones para perros");
    }

    public void vacunasObligatorias() {
        System.out.println("Vacunas");
    }
}
