package ar.com.parcialUno;


import ar.com.parcialUno.app.AppContext;
import ar.com.parcialUno.controller.EmployeeController;
import ar.com.parcialUno.model.people.Adoptant;
import ar.com.parcialUno.model.people.Employee;
import ar.com.parcialUno.model.pets.Cat;
import ar.com.parcialUno.model.pets.Dog;
import ar.com.parcialUno.model.pets.Pet;
import ar.com.parcialUno.views.LoginFrame;


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

        Adoptant adoptant = new Adoptant("Juan", "Perez", 23, "Rivadavia 1307");
        Adoptant adoptant2 = new Adoptant("Ana", "López", 34, "Hondiras 3426");
        Adoptant adoptant3 = new Adoptant("Lucía", "Gozalez", 29, "Nicaragua 7042");

        AppContext.employeeController.saveEmployee(employee);
        AppContext.employeeController.saveEmployee(employee2);
        AppContext.employeeController.saveEmployee(employee3);

        AppContext.petController.insertPet(pet);
        AppContext.petController.insertPet(pet2);
        AppContext.petController.insertPet(pet3);

        AppContext.adoptantController.insertAdoptant(adoptant);
        AppContext.adoptantController.insertAdoptant(adoptant2);
        AppContext.adoptantController.insertAdoptant(adoptant3);

        EmployeeController ec = AppContext.employeeController;

        LoginFrame frame = new LoginFrame(ec);


    }
}