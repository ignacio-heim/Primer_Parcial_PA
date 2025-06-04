package ar.com.parcialUno;

import java.time.LocalDate;

public class RabbitAdoption extends Adoption {
    public RabbitAdoption(Employee anEmployee, Adoptant anAdoptant, Pet aPet, LocalDate aDate) {
        super(anEmployee, anAdoptant, aPet, aDate);
    }

    @Override
    public void verificarVacunas() {
        System.out.println("Vacunas de conejos");
    }

    @Override
    public void ofrecerRecomendaciones() {
        System.out.println("Recomendaciones para conejos");
    }


    public void cuidadosJaulas() {
        System.out.println("Cuidados Jaulas");
    }
}
