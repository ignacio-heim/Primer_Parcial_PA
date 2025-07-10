package ar.com.parcialUno.service;

import ar.com.parcialUno.DAO.adoptationDAO.AdoptionDAOH2;
import ar.com.parcialUno.model.people.Adoptant;
import ar.com.parcialUno.model.people.Employee;
import ar.com.parcialUno.model.pets.Pet;

import java.util.List;

public class AdoptionService {

    private AdoptionDAOH2 adoptionDAO;

    public AdoptionService() {
        this.adoptionDAO = new AdoptionDAOH2();
    }

    public void createAdoption(Employee employee, Pet pet, Adoptant adoptant) {
        if(employee == null || pet == null || adoptant == null) {
            throw new IllegalArgumentException("La adopcion no puede estar nual.");
        }
        adoptionDAO.insertAdoption(employee, pet, adoptant);
    }

    public List<String> getAdoptions() {
        if(adoptionDAO.getAdoptions().isEmpty()) {
            throw new IllegalArgumentException("La adopcion no puede estar nula.");
        }
        return adoptionDAO.getAdoptions();
    }

}
