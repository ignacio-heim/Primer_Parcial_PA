package ar.com.parcialUno.controller;

import ar.com.parcialUno.model.adoptions.Adoption;
import ar.com.parcialUno.model.people.Adoptant;
import ar.com.parcialUno.model.people.Employee;
import ar.com.parcialUno.model.pets.Pet;
import ar.com.parcialUno.service.AdoptionService;

import java.util.List;

public class AdoptionController {

    private AdoptionService adoptionService;

    public AdoptionController() {
        this.adoptionService = new AdoptionService();
    }

    public void insertAdoption(Employee employee, Pet pet, Adoptant adoptant) {
        try {
            adoptionService.createAdoption(employee, pet, adoptant);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<StringBuilder> getAdoptions() {
        try {
            return adoptionService.getAdoptions();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Adoption getAdoption(Integer id) {
        try {
            return adoptionService.getAdoption(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean deleteAdoption(Integer id) {
        try {
            return adoptionService.deleteAdoption(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean updateAdoptionById(Integer idAdoption, Integer idPet, Adoptant adoptant) {
        try {
            return adoptionService.updateAdoptionById(idAdoption, idPet, adoptant);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
