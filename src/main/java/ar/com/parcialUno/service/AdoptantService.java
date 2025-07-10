package ar.com.parcialUno.service;

import ar.com.parcialUno.DAO.adoptantDAO.AdoptantDAOH2Impl;
import ar.com.parcialUno.model.people.Adoptant;

import java.util.List;

public class AdoptantService {

    private AdoptantDAOH2Impl adoptantDAO;

    public AdoptantService() {
        adoptantDAO = new AdoptantDAOH2Impl();
    }

    public void insertAdoptant(Adoptant adoptant) {
        if(adoptant.getName() == null || adoptant.getName().isEmpty()) {
            throw new IllegalArgumentException("Nombre del adoptante no puede estar vacio");
        }
        adoptantDAO.create(adoptant);
    }

    public Adoptant getAdoptant(int id) {
        if(id<0 || id > adoptantDAO.getAll().size()) {
            throw new IllegalArgumentException("Nombre del adoptante no puede estar vacio");
        }
        return adoptantDAO.getById(id);
    }

    public List<Adoptant> getAllAdoptants() {
        if(adoptantDAO.getAll().isEmpty()) {
            throw new IllegalArgumentException("No hay adoptantes en la base de datos");
        }
        return adoptantDAO.getAll();
    }

    public void updateAdoptant(Integer id, Adoptant anAdoptant) {
        if(anAdoptant.getName() == null || anAdoptant.getName().isEmpty()) {
            throw new IllegalArgumentException("Nombre del adoptante no puede estar vacio");
        }
        adoptantDAO.update(id, anAdoptant);
    }

    public void deleteAdoptant(int id) {
        if(id <= 0 || id > adoptantDAO.getAll().size()) {
            throw new IllegalArgumentException("Nombre del adoptante no puede estar vacio");
        }
        adoptantDAO.delete(id);
    }

    public Integer getIdAdoptant(Adoptant anAdoptant) {
        if(anAdoptant.getName() == null || anAdoptant.getName().isEmpty()) {
            throw new IllegalArgumentException("Nombre del adoptante no puede estar vacio");
        }
        return adoptantDAO.getId(anAdoptant);
    }

}
