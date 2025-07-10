package ar.com.parcialUno.model.adoptions;

import ar.com.parcialUno.model.pets.Pet;
import ar.com.parcialUno.model.exepctions.PetExceptrion;
import ar.com.parcialUno.infrastructure.ticket.PrintAdoptionTicket;
import ar.com.parcialUno.model.exepctions.AdoptionExceptions;
import ar.com.parcialUno.model.people.Adoptant;
import ar.com.parcialUno.model.people.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Adoption {

    private Employee anEmployee;
    private Adoptant anAdoptant;
    private Pet aPet;
    public LocalDate adoptationDate;

    private List<String> pasosEjecutados = new ArrayList<>();
    private PrintAdoptionTicket ticket = new PrintAdoptionTicket(this);

    public Adoption(Employee anEmployee, Adoptant anAdoptant, Pet aPet) {
        this.anEmployee = anEmployee;
        this.anAdoptant = anAdoptant;
        this.aPet = aPet;
        this.adoptationDate = LocalDate.now();
    }

    protected void registerData(String mensaje) {
        pasosEjecutados.add(mensaje);
    }

    public boolean getAPet() {
        return aPet != null;
    }

    public String getNameAdoptant() {
        return anAdoptant.getName();
    }
    public String getLastName() { return anAdoptant.getLastName(); }
    public Integer getAgeAdoptant() {
        return anAdoptant.getAge();
    }
    public String getAdressAdoptant() {
        return anAdoptant.getAdress();
    }

    public String getNamePet() {
        return aPet.getName();
    }

    public String getBirthdayPet() {
        return aPet.getBirthDate();
    }

    public double getWeightPet() {
        return aPet.getWeight();
    }

    public Double getWeightPetDouble() {
        return aPet.getWeight();
    }

    public Integer getSpeciePet() {
        return aPet.getSpecie();
    }

    /*
    public StringBuilder getCaresPet() {
        return aPet.getCares();
    }*/

    public String getNameEmployee() {
        return anEmployee.getName();
    }

    public String getChargeEmployee() {
        return anEmployee.getCharge();
    }

    public LocalDate getAdoptationDate() {
        return this.adoptationDate;
    }

    @Override
    public String toString() {
        return "Adoption{" +
                "anEmployee=" + anEmployee +
                ", anAdoptant=" + anAdoptant +
                ", aPet=" + aPet +
                ", adoptationDate=" + adoptationDate +
                '}';
    }

    // Process adoption
    public void procesarAdopcion() {
        try {
            registerData("Starting adoptation");
            registrarDatosAdoptante();
            registrarEmpleado();
            guardarDatosMascota();
            //verificarVacunas();
            //ofrecerRecomendaciones();
            generarTicketFinal();
            ticket.printTicket();
        } catch (AdoptionExceptions | PetExceptrion e) {
            System.out.println("Ups, algo salió mal: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    protected void registrarDatosAdoptante() {
        anAdoptant.validate();
        System.out.println("Registrando datos del adoptante...");
    }

    protected void registrarEmpleado() {
        System.out.println("Registrando empleado encargado...");
    }

    protected void guardarDatosMascota() {
        aPet.validateBelongToVete();
        System.out.println("Guardando datos de la mascota...");
    }

    protected void generarTicketFinal() {
        System.out.println("Generando ticket final...");
    }

    /*
    protected abstract void verificarVacunas();
    protected abstract void ofrecerRecomendaciones();
    */

}
