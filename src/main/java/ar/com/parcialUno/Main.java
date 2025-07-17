package ar.com.parcialUno;


import ar.com.parcialUno.app.AppContext;
import ar.com.parcialUno.controller.AdoptionController;
import ar.com.parcialUno.controller.EmployeeController;
import ar.com.parcialUno.model.people.Adoptant;
import ar.com.parcialUno.model.people.Employee;
import ar.com.parcialUno.model.pets.Cat;
import ar.com.parcialUno.model.pets.Dog;
import ar.com.parcialUno.model.pets.Pet;
import ar.com.parcialUno.views.LoginFrame;

import java.util.List;


public class Main {

    public static void main(String[] args) {


        Employee employee = new Employee("Ignacio", "Heim", 34, "Asistente",
                "ignacio.heim@gmail.com", "1234");
        Employee employee2 = new Employee("Josefina", "Cafferatta", 33, "Asistente",
                "josecaffe@gmail.com", "4321");
        Employee employee3 = new Employee("Daniela", "Torres", 33, "Asistente",
                "daniela.torres@gmail.com", "4321");

        Pet pet = new Dog("Vitto", "2020-01-01",7.2,1);
        Pet pet2 = new Cat("Toto", "2016-04-23",2.6,2);
        Pet pet3 = new Cat("Luna", "2009-03-29",7.2,2);
        Pet pet4 = new Cat("Roco", "2009-03-29",7.2,2);
        Pet pet5 = new Cat("Sol", "2009-03-29",7.2,2);
        Pet pet6 = new Cat("Max", "2009-03-29",7.2,2);
        Pet pet7 = new Dog("Rocky", "2020-01-01",7.2,1);
        Pet pet8 = new Cat("Garfield", "2009-03-29",7.2,2);
        Pet pet9 = new Cat("Madona", "2009-03-29",7.2,2);
        Pet pet10 = new Cat("Mamadera", "2009-03-29",7.2,2);
        Pet pet11 = new Dog("Minerva", "2020-01-01",7.2,1);
        Pet pet12 = new Dog("Momo", "2020-01-01",7.2,1);

        Adoptant adoptant = new Adoptant("Juan", "Perez", 23, "Rivadavia 1307");
        Adoptant adoptant2 = new Adoptant("Ana", "López", 34, "Hondiras 3426");
        Adoptant adoptant3 = new Adoptant("Lucía", "Gozalez", 29, "Nicaragua 7042");

        AppContext.employeeController.saveEmployee(employee);
        AppContext.employeeController.saveEmployee(employee2);
        AppContext.employeeController.saveEmployee(employee3);

        AppContext.petController.insertPet(pet);
        AppContext.petController.insertPet(pet2);
        AppContext.petController.insertPet(pet3);
        AppContext.petController.insertPet(pet4);
        AppContext.petController.insertPet(pet5);
        AppContext.petController.insertPet(pet6);
        AppContext.petController.insertPet(pet7);
        AppContext.petController.insertPet(pet8);
        AppContext.petController.insertPet(pet9);
        AppContext.petController.insertPet(pet10);
        AppContext.petController.insertPet(pet11);
        AppContext.petController.insertPet(pet12);


        AppContext.adoptantController.insertAdoptant(adoptant);
        AppContext.adoptantController.insertAdoptant(adoptant2);
        AppContext.adoptantController.insertAdoptant(adoptant3);

        EmployeeController ec = AppContext.employeeController;

        AppContext.adoptionCOontroller.insertAdoption(employee, pet, adoptant3);
        AppContext.adoptionCOontroller.insertAdoption(employee, pet2, adoptant2);
        AppContext.adoptionCOontroller.insertAdoption(employee, pet3, adoptant);

        //AppContext.adoptionCOontroller.getAdoptions();

        //System.out.println(AppContext.adoptionCOontroller.getAdoption(3));

        LoginFrame frame = new LoginFrame(ec);


    }
}