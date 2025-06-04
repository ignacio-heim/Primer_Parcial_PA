package ar.com.parcialUno;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Employee myEmployee = Employee.getInstance("Ignacio", 34, "assistant");

        Adoptant myAdoptant = new Adoptant("Josefina", 19, "Rep. Dominica 3366");

        Pet miPet = new Dog("Vitto", "2020-01-01", 14.3, "dog");
        Pet miPet2 = new Dog("Vitto", "2020-01-01", 14.3, "dog");

        miPet.addCare("Alimentar dos veces por dia");
        miPet.addCare("Sacar a pasar dos veces por dia");

        Adoption miAdoption = new DogAdoption(myEmployee, myAdoptant, miPet, LocalDate.of(2023,10,29));
        miAdoption.procesarAdopcion();
        // ManagerAdoption managerAdoption = new ManagerAdoption();
        // managerAdoption.addAdoption(miAdoption);
        // System.out.println(managerAdoption.last30daysAdoptions());

        //System.out.println(miAdoption.toString());

        //Container<Pet> misMascotas = new Container();

        //misMascotas.addContaing(miPet);

        //System.out.println(misMascotas.hasAnAnimal());


    }
}