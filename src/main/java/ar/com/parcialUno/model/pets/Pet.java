package ar.com.parcialUno.model.pets;

import ar.com.parcialUno.*;
import ar.com.parcialUno.model.exepctions.PetExceptrion;
import ar.com.parcialUno.model.pets.states.DeliveryStates;
import ar.com.parcialUno.model.pets.states.Healthy;
import ar.com.parcialUno.model.pets.states.InterfaceState;

import java.util.ArrayList;
import java.util.List;

abstract class Pet extends Contain {

    private String name;
    private String birthDate;
    private Double weight;
    private String specie;
    private List<String> cares;
    private DeliveryStates delivery;
    private InterfaceState state;
    boolean belongToVete;

    public Pet(String aName, String aBirthDate, Double aWeight, String aSpecie) {
        this.name = aName;
        this.birthDate=aBirthDate;
        this.weight=aWeight;
        this.specie=aSpecie;
        this.state=new Healthy();
        this.cares = new ArrayList<>();
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

    public String getSpecie() {
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

    public void jugar() {
        DeliveryStates ed = new DeliveryStates();
        ed.obtenerEstado(this).quiereJugar();
    }

    @Override
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
        return "Pet{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", weight=" + weight +
                ", specie='" + specie + '\'' +
                ", cares=" + cares +
                ", delivery=" + delivery +
                ", state=" + state +
                '}';
    }
}
