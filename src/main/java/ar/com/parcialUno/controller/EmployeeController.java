package ar.com.parcialUno.controller;

import ar.com.parcialUno.model.people.Employee;
import ar.com.parcialUno.service.EmployeeService;

import java.util.List;

public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController() {
        this.employeeService = new EmployeeService();
    }

    public void saveEmployee(Employee anEmployee) {
        try {
            employeeService.insertEmployee(anEmployee);
//            System.out.println("El empleado "+ anEmployee.getName() + " " + anEmployee.getLastName()+" se ha guardado correctamente");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(Integer id, Employee anEmployee) {
        try {
            employeeService.updateEmployee(id, anEmployee);
//            System.out.println("El empleado "+ anEmployee.getName() + " " + anEmployee.getLastName() +"se ha actualizado correctamente");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(Integer id) {
        try {
            employeeService.deleteEmployee(id);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public Employee getEmployee(Integer id) {
        try {
            return employeeService.getEmployeeById(id);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Employee> getAllEmployees() {
        try {
            return employeeService.getAllEmployees();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer getEmployeeId(Employee anEmployee) {
        try {
            return employeeService.getEmployeeId(anEmployee);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Employee getEmployeeByEmail(String email) {
        try {
            return employeeService.getEmployeeByEmail(email);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Employee login(String email, String password) {
        try {
            return employeeService.loginEmployee(email, password);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

}
