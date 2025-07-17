package ar.com.parcialUno.infrastructure.ticket;

import ar.com.parcialUno.model.adoptions.Adoption;

import java.time.LocalDate;

public class PrintAdoptionTicket implements InterfaceAdoptationTicket {

    private Adoption anAdoption;
    public LocalDate today = LocalDate.now();

    public PrintAdoptionTicket(Adoption adoption) {
        this.anAdoption = adoption;
    }

    public String printTicket() {
        return ("REFUGIO PATITAS FELICES\n" +
                "TICKET DE ADOPCIÓN\nDía: " + today +"\n"+
                "\nDATOS DEL ADOPTANTE: "+
                "\n \tNombre: " + anAdoption.getNameAdoptant()+ " " + anAdoption.getLastNameAdopt() +
                "\n \tEdad: " + anAdoption.getAgeAdoptant()+
                "\n \tDirección: " + anAdoption.getAdressAdoptant()+
                "\n"+
                "\n DATOS DE LA MASCOTA: "+
                "\n \tNombre: " + anAdoption.getNamePet()+
                "\n \tCumpleaños: "+anAdoption.getBirthdayPet()+
                "\n \tPeso: "+anAdoption.getWeightPet()+
                "\n \tEspecie: "+anAdoption.getSpeciePet()+
                //"\n \tCares recommendation: \n"+anAdoption.getCaresPet()+
                "\n"+
                "\n Datos del Empleado: "+
                "\n \tNombre: "+anAdoption.getNameEmployee()+
                "\n \tCargo: "+anAdoption.getChargeEmployee()
        );

    }
}
