package ar.com.parcialUno;

import ar.com.parcialUno.model.adoptions.Adoption;

import java.time.LocalDate;

public class PrintAdoptionTicket implements InterfaceAdoptationTicket {

    private Adoption anAdoption;
    public LocalDate today = LocalDate.now();

    public PrintAdoptionTicket(Adoption adoption) {
        this.anAdoption = adoption;
    }

    public void printTicket() {
        System.out.println("ADOPTION TICKET\nDate: " + today +"\n"+
                "\nADOPTER DATA: "+
                "\n \tName: " + anAdoption.getNameAdoptant()+
                "\n \tAge: " + anAdoption.getAgeAdoptant()+
                "\n \tAdress: " + anAdoption.getAdressAdoptant()+
                "\n"+
                "\n PET DATA: "+
                "\n \tPet: " + anAdoption.getNamePet()+
                "\n \tBirthday: "+anAdoption.getBirthdayPet()+
                "\n \tWeight: "+anAdoption.getWeightPet()+
                "\n \tSpecie: "+anAdoption.getSpeciePet()+
                "\n \tCares recommendation: \n"+anAdoption.getCaresPet()+
                "\n"+
                "\n EMPLOYEE: "+
                "\n \tName: "+anAdoption.getNameEmployee()+
                "\n \tCharge: "+anAdoption.getChargeEmployee()
        );

    }
}
