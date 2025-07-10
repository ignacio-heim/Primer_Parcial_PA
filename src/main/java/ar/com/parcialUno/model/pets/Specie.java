package ar.com.parcialUno.model.pets;

public class Specie {

    private String specie;
    private String breed;

    public Specie(String specie, String breed) {
        this.specie = specie;
        this.breed = breed;
    }

    public String getSpecie() {
        return specie;
    }

    public String getBreed() { return breed; }

}
