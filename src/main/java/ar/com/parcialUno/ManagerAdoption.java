package ar.com.parcialUno;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ManagerAdoption {
    private List<Adoption> adoptions;

    public ManagerAdoption() {
        this.adoptions = new ArrayList<>();
    }

    public void addAdoption(Adoption adoption) {
        adoptions.add(adoption);
    }

    public void showAdoption() {
        for (Adoption adoption : adoptions) {
            System.out.println(adoption.toString());
        }
    }


    public List<Adoption> last30daysAdoptions() {
        List<Adoption> adoptions30days = new ArrayList<>();
        for (Adoption adoption : this.adoptions) {
            if (adoption.getAdoptationDate().isAfter(LocalDate.now().minusDays(30))) {
                adoptions30days.add(adoption);
            }
        }
        return adoptions30days;
    }

    public boolean adoptionWithoutPet() {
        for (Adoption adoption : this.adoptions) {
            if (!adoption.getAPet()) {
                return false;
            }
        }
        return true;
    }

    public String messageAdoptionWihoutPet() {
        String message = adoptionWithoutPet() ? "Everything is ok" : "There are adoptions without a pet";
        return message;
    }

}
