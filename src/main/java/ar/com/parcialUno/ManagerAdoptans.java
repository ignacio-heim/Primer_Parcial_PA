package ar.com.parcialUno;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManagerAdoptans {

    private List<Adoptant> adoptants;

    public ManagerAdoptans() {
        this.adoptants = new ArrayList<Adoptant>();
    }

    public boolean isEmpty() {
        return this.adoptants.isEmpty();
    }

    public void addAdoptant(Adoptant adoptant) {
        this.adoptants.add(adoptant);
    }

    public List<String> getNameAdoptants() {
        List<String> adoptantsName = new ArrayList<>();
        for (Adoptant adoptant : this.adoptants) {
            adoptantsName.add(adoptant.getName());
        }
        return adoptantsName;
    }

    public Double avgAgeAdopt() {
        Double avgAge = 0.0;
        for (Adoptant adoptant : this.adoptants) {
            avgAge+=adoptant.getAge();
        }
        return avgAge/this.adoptants.size();

    }
}
