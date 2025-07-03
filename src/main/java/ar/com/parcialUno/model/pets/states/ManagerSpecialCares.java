package ar.com.parcialUno.model.pets.states;

import ar.com.parcialUno.model.Pet;

import java.util.ArrayList;
import java.util.List;

public class ManagerSpecialCares {


    private List<Pet> specialCaresPets;

    public ManagerSpecialCares() {
        specialCaresPets = new ArrayList<>();
    }


    public boolean isEmpty() {
        return specialCaresPets.isEmpty();
    }

    public void addPet(Pet aPet) {
        specialCaresPets.add(aPet);
    }

    public List<Pet> getAll() {
        List<Pet> pets = new ArrayList<>();
        for (Pet pet : specialCaresPets) {
            pets.add(pet);
        }
        return pets;
    }
}
