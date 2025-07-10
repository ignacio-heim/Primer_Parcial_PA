package ar.com.parcialUno.controller;

import ar.com.parcialUno.model.people.Adoptant;
import ar.com.parcialUno.service.AdoptantService;

import java.util.List;

public class AdoptantController {

    private AdoptantService adoptantService;

    public AdoptantController() {
        this.adoptantService = new AdoptantService();
    }

    public void insertAdoptant(Adoptant adoptant) {
        try {
            adoptantService.insertAdoptant(adoptant);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void updateAdoptant(Integer id, Adoptant adoptant) {
        try {
            adoptantService.updateAdoptant(id, adoptant);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void deleteAdoptant(Integer id) {
        try {
            adoptantService.deleteAdoptant(id);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public Adoptant getAdoptant(Integer id) {
        try {
            return adoptantService.getAdoptant(id);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Adoptant> getAllAdoptants() {
        try {
            return adoptantService.getAllAdoptants();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer getIdAdoptant(Adoptant adoptant) {
        try {
            return adoptantService.getIdAdoptant(adoptant);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

}
