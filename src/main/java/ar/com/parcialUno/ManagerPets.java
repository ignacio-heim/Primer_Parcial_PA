package ar.com.parcialUno;

import ar.com.parcialUno.model.pets.Pet;

import java.util.*;
import java.util.stream.Collectors;

public class ManagerPets {

    private List<Pet> pets;

    public ManagerPets() {
        this.pets = new ArrayList<>();
    }

    public void addAPet(Pet aPet) {
        pets.add(aPet);
    }

    public Map<String, Long> returnSpecie() {
        Map<String, Long> count = pets.stream()
                .collect(Collectors.groupingBy(Pet::getSpecie, Collectors.counting()));
        return count;
    }

    public List<String> sortNames() {
        List<String> names = new ArrayList<>();
        for (Pet pet : pets) {
            names.add(pet.getName());
        }
        Collections.sort(names);
        return names;
    }

    public List<Pet> weightPet(Double weight) {
        List<Pet> petsWeight = new ArrayList<>();
        for (Pet pet : pets) {
            if (pet.getWeight() > weight) {
                petsWeight.add(pet);
            }
        }
        return petsWeight;
    }

    public String namesSeparateByComa() {
        List<String> names = new ArrayList<>();
        for (Pet pet : pets) {
            names.add(pet.getName());
        }
        return names.toString().replace("[", "").replace("]", "");

    }

    public Map<String, String> newFormatPet() {
        Map<String,String> pets = new HashMap<>();
        for (Pet aPet : this.pets) {
            pets.put(aPet.getName(), aPet.getSpecie());
        }
        return pets;

    }
}
