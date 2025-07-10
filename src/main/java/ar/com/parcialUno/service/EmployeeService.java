package ar.com.parcialUno.service;

import ar.com.parcialUno.DAO.DAO;
import ar.com.parcialUno.DAO.emplyoeeDAO.EmployeeDAOH2Impl;
import ar.com.parcialUno.model.people.Employee;

import java.util.List;

public class EmployeeService {

    private EmployeeDAOH2Impl employeeDAO;

    public EmployeeService() {
        this.employeeDAO = new EmployeeDAOH2Impl();
    }


    public void insertEmployee(Employee anEmployee) {
        if(anEmployee.getName() == null || anEmployee.getName() == null) {
            throw new IllegalArgumentException("Nombre del empleado no puede estar vacio");
        }
        employeeDAO.create(anEmployee);
    }

    public void updateEmployee(Integer id, Employee anEmployee) {
        if(id == null || id < 0) {
            throw new IllegalArgumentException("Id invalido");
        }
        employeeDAO.update(id, anEmployee);
    }

    public void deleteEmployee(Integer id) {
        if(id == null || id < 0) {
            throw new IllegalArgumentException("Id invalido");
        }
        employeeDAO.delete(id);
    }

    public Employee getEmployeeById(Integer id) {
        if(id == null || id < 0) {
            throw new IllegalArgumentException("Id invalido");
        }
        return (Employee) employeeDAO.getById(id);
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeDAO.getAll();
        if(employees == null) {
            throw new IllegalArgumentException("No employees");
        }
        return employees;
    }

    public Integer getEmployeeId(Employee anEmployee) {
        if(anEmployee == null) {
            throw new IllegalArgumentException("Nombre del empleado no puede estar vacio");
        }
        return employeeDAO.getId(anEmployee);
    }


    public Employee getEmployeeByEmail(String email) {
        if(email == null || email.isEmpty()) {
            throw new IllegalArgumentException("No register user.");
        }
        return (Employee) employeeDAO.getEmployeeByEmail(email);
    }

    public Employee loginEmployee(String email, String password) {
        if(email == null || email.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Email and password are required");
        }
        Employee employee = employeeDAO.getEmployeeByEmail(email);
        if(!employee.getEmail().equals(email)) {
            throw new IllegalArgumentException("Invalid credentials emial");
        }
        if (!employee.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid credentials password");
        }
        //System.out.println("User " + employee.getName() + " " + employee.getLastName() + " succesfully logged in");
        return employee;
    }

}
