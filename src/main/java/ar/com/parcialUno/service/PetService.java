package ar.com.parcialUno.service;

import ar.com.parcialUno.DAO.petDAO.PetDAOH2Impl;
import ar.com.parcialUno.model.people.Adoptant;
import ar.com.parcialUno.model.pets.Pet;

import java.util.List;

public class PetService {

    private PetDAOH2Impl petDAO;

    public PetService() {
        petDAO = new PetDAOH2Impl();
    }

    public void insertPet(Pet aPet) {
        if(aPet.getName() == null || aPet.getName() == null) {
            throw new IllegalArgumentException("Nombre del empleado no puede estar vacio");
        }
        petDAO.create(aPet);
    }

    public void updateEmployee(Integer id, Pet aPet) {
        if(id == null || id < 0) {
            throw new IllegalArgumentException("Id invalido");
        }
        petDAO.update(id, aPet);
    }

    public void deleteEmployee(Integer id) {
        if(id == null || id < 0) {
            throw new IllegalArgumentException("Id invalido");
        }
        petDAO.delete(id);
    }

    public Pet getPetById(Integer id) {
        if(id == null || id < 0) {
            throw new IllegalArgumentException("Id invalido");
        }
        return petDAO.getById(id);
    }

    public List<Pet> getAllPets() {
        if(petDAO == null) {
            throw new IllegalArgumentException("No hay mascotas en la base de datos");
        }
        return petDAO.getAll();
    }

    public List<Pet> getAllAdoptations() {
        if(petDAO == null) {
            throw new IllegalArgumentException("No hay mascotas en la base de datos");
        }
        return petDAO.getAllAdoptations();
    }

    public Integer getIdPet(Pet aPet) {
        if(aPet == null) {
            throw new IllegalArgumentException("No hay mascotas en la base de datos");
        }
        return petDAO.getId(aPet);
    }


}
