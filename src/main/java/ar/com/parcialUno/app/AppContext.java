package ar.com.parcialUno.app;

import ar.com.parcialUno.controller.AdoptantController;
import ar.com.parcialUno.controller.AdoptionController;
import ar.com.parcialUno.controller.EmployeeController;
import ar.com.parcialUno.controller.PetController;

public class AppContext {

    public static final EmployeeController employeeController = new EmployeeController();
    public static final PetController petController = new PetController();
    public static final AdoptantController adoptantController = new AdoptantController();
    public static final AdoptionController adoptionCOontroller = new AdoptionController();

}
