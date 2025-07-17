package ar.com.parcialUno.controller;

import ar.com.parcialUno.model.pets.Pet;
import ar.com.parcialUno.service.PetService;

import java.util.List;

public class PetController {

    PetService petService;

    public PetController() {
        this.petService = new PetService();
    }

    public void insertPet(Pet aPet) {
        try {
            petService.insertPet(aPet);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void updatePet(Integer id, Pet aPet) {
        try {
            petService.updateEmployee(id, aPet);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void deletePet(Integer id) {
        try {
            petService.deleteEmployee(id);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public Pet getPetById(Integer id) {
        try {
            return petService.getPetById(id);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Pet> getAllPets() {
        try {
            return petService.getAllPets();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer getPetId(Pet aPet) {
        try {
            return petService.getIdPet(aPet);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Pet> getAllAdoptations() {
        try {
            return petService.getAllAdoptations();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

}
