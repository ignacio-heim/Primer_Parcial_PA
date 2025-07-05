package ar.com.parcialUno.service;

import ar.com.parcialUno.DAO.DAO;
import ar.com.parcialUno.DAO.emplyoeeDAO.EmployeeDAOH2Impl;
import ar.com.parcialUno.model.people.Employee;

import java.util.List;

public class EmployeeService {

    private DAO employeeDAO = new EmployeeDAOH2Impl();

    public void insertEmployee(String firstName, String lastName, int age, String charge) {
        if(firstName == null || lastName == null) {
            throw new IllegalArgumentException("Nombre del empleado no puede estar vacio");
        }
        Employee employee = new Employee(firstName, lastName, age, charge);
        employeeDAO.create(employee);
    }

    public void updateEmployee(Integer id, Employee employee) {
        if(id == null || id < 0) {
            throw new IllegalArgumentException("Id invalido");
        }
        employeeDAO.update(id, employee);
    }

    public void deleteEmployee(Integer id, Employee employee) {
        if(id == null || id < 0) {
            throw new IllegalArgumentException("Id invalido");
        }
        employeeDAO.delete(id, employee);
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

}
