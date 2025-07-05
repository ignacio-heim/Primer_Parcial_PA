package ar.com.parcialUno.controller;

import ar.com.parcialUno.service.EmployeeService;

public class EmployeeController {

    private EmployeeService employeeService = new EmployeeService();

    public void saveEmployee() {
        String aName = "";
        String aLastName = "";
        Integer anAge = null;
        String aCharge = "";

        try {
            employeeService.insertEmployee(aName, aLastName, anAge, aCharge);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }




}
