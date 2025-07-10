package ar.com.parcialUno.controller;

import ar.com.parcialUno.model.pets.Specie;
import ar.com.parcialUno.service.SpecieService;

public class SpecieController {

    private SpecieService specieService;

    public SpecieController() {
        this.specieService = new SpecieService();
    }

    public void insertSpecie(Specie specie) {
        try {
            specieService.insertSpecie(specie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSpecie(Integer id, Specie specie) {
        try {
            specieService.updateSpecie(id, specie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
