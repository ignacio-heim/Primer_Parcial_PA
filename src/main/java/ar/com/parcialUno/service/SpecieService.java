package ar.com.parcialUno.service;

import ar.com.parcialUno.DAO.petDAO.SpecieDAOH2;
import ar.com.parcialUno.model.pets.Specie;

import java.util.List;

public class SpecieService {

    private SpecieDAOH2 specieDAOH2;

    public SpecieService() {
        this.specieDAOH2 = new SpecieDAOH2();
    }

    public void insertSpecie(Specie specie) {
        if (specie.getSpecie() == null || specie.getSpecie().isEmpty()) {
            throw new IllegalArgumentException("La especie no puede ser nula");
        }
        this.specieDAOH2.insertSpecie(specie);
    }

    public void deleteSpecie(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("No hay especie para eliminar");
        }
        this.specieDAOH2.deleteSpecie(id);
    }

    public Specie getSpecie(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("No hay especie para eliminar");
        }
        return this.specieDAOH2.getSpecie(id);
    }

    public List<Specie> getSpecies() {
        if (specieDAOH2.getSpecies() == null) {
            throw new IllegalArgumentException("No hay especies para eliminar");
        }
        return specieDAOH2.getSpecies();
    }

    public void updateSpecie(Integer id, Specie specie) {
        if (specie.getSpecie() == null || specie.getSpecie().isEmpty()) {
            throw new IllegalArgumentException("La especie no puede ser nula");
        }
        specieDAOH2.updateSpecie(id, specie);
    }

}
