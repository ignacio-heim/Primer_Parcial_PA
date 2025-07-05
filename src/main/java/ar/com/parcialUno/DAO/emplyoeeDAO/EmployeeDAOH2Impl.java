package ar.com.parcialUno.DAO.emplyoeeDAO;

import ar.com.parcialUno.DAO.DAO;
import ar.com.parcialUno.model.people.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOH2Impl implements DAO<Employee> {

    // URL de conexión (base en memoria)
    private static final String url = "jdbc:h2:~/testdb";
    private static final String user = "sa";
    private static final String password = "";
    private static final String table = "employee";

    public EmployeeDAOH2Impl() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            //org.h2.tools.Server.startWebServer(conn); //LO USO PARA CONECTARME A LA BBDD DE H2 EN LA WEB
            String createTable = "CREATE TABLE IF NOT EXISTS " + table +
                    "(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), lastname VARCHAR(255), age INT, " +
                            "charge VARCHAR(255))";
            stmt.executeUpdate(createTable);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Employee employee) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            String createEmployee = "INSERT INTO " + table + "(name, lastname, age, charge) VALUES (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(createEmployee);
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getLastName());
            stmt.setInt(3, employee.getAge());
            stmt.setString(4, employee.getCharge());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            System.out.println("Empleado creadado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);
            while (rs.next()) {
                String name = rs.getString("name");
                String lastName = rs.getString("lastname");
                int age = rs.getInt("age");
                String charge = rs.getString("charge");
                Employee myEmployee = new Employee(name, lastName, age, charge);
                employees.add(myEmployee);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void update(int id, Employee employee) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            String updateEmployee = "UPDATE FROM " + table + "SET name = ?, lastname = ?, age = ?, charge = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateEmployee);
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getLastName());
            stmt.setInt(3, employee.getAge());
            stmt.setString(4, employee.getCharge());
            stmt.setInt(5, id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getById(int id) {
        Employee employee = null;
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM " + table + " WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String name = rs.getString("name");
                String lastName = rs.getString("lastname");
                int age = rs.getInt("age");
                String charge = rs.getString("charge");
                employee = new Employee(name, lastName, age, charge);
            }
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void delete(int id, Employee myEmployee) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            String deleteEmployee = "DELETE FROM " + table + " WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(deleteEmployee);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("El empleado  " + myEmployee.getName() + " " + myEmployee.getLastName() + " eliminado exitosamente");
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
