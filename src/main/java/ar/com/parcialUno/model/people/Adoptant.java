package ar.com.parcialUno.model.people;

import ar.com.parcialUno.model.exepctions.AdoptionExceptions;

public class Adoptant extends Person {

    private String adress;

    public Adoptant(String aName, String aLastName, Integer anAge, String anAdress) {
        super(aName, aLastName ,anAge);
        this.adress = anAdress;
    }

    public String getAdress() {
        return this.adress;
    }

    public void validate() {
        if (getName() == null || getName().isBlank()) {
            throw new AdoptionExceptions("Name is a required field.");
        }
        if (getAge() < 18) {
            throw new AdoptionExceptions("Sorry, only over 18 people can adopt a pet.");
        }
        if (getAdress() == null || getAdress().isBlank()) {
            throw new AdoptionExceptions("Adress is a required field.");
        }
    }

    @Override
    public String toString() {
        return "Adoptante: " +this.getName() + " "+ this.getLastName() + ". Age " + this.getAge();
    }
}
