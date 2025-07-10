package ar.com.parcialUno.model.pets;


import ar.com.parcialUno.model.exepctions.PetExceptrion;
import ar.com.parcialUno.model.pets.states.DeliveryStates;
import ar.com.parcialUno.model.pets.states.Healthy;
import ar.com.parcialUno.model.pets.states.InterfaceState;

import java.util.ArrayList;
import java.util.List;

public class Pet {

    private String name;
    private String birthDate;
    private Double weight;
    private Integer specie;
    private List<String> cares;
    private DeliveryStates delivery;
    private InterfaceState state;
    boolean belongToVete;

    /*
    public Pet(String aName, String aBirthDate, Double aWeight, String aSpecie) {
        this.name = aName;
        this.birthDate=aBirthDate;
        this.weight=aWeight;
        this.specie=aSpecie;
        this.state=new Healthy();
        this.cares = new ArrayList<>();
        this.belongToVete=true;
    }*/

    public Pet(String name, String birthDate, Double weight, Integer specie) {
        this.name = name;
        this.birthDate=birthDate;
        this.weight=weight;
        this.specie=specie;
        this.state=new Healthy();
        this.belongToVete=true;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Double getWeight() {
        return weight;
    }

    public Integer getSpecie() {
        return this.specie;
    }

    public void addCare(String aCare) {
        this.cares.add(aCare);
    }

    public StringBuilder getCares() {
        StringBuilder petCares = new StringBuilder();
        for (String care : cares) {
            petCares.append(care+"\t\n");
        }
        return petCares;
    }

    public InterfaceState getState() {
        return this.state;
    }

    public void setActualState(InterfaceState aEstado) {
        this.state = aEstado;
    }

    public Integer getSpecieID() {
        return this.specie;
    }

    public void jugar() {
        DeliveryStates ed = new DeliveryStates();
        ed.obtenerEstado(this).quiereJugar();
    }
    //@Override

    public boolean isAnimal() {
        return true;
    }

    public void validateBelongToVete() {
        if (!belongToVete) {
            throw new PetExceptrion("The pet does not belong to a vet.");
        }
    }

    @Override
    public String toString() {
        return "Mascota: " + name +", Cumpleaños: " + birthDate + ", Peso: " + weight;
    }
}
