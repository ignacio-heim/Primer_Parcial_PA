package ar.com.parcialUno.DAO.emplyoeeDAO;

import ar.com.parcialUno.DAO.DAO;
import ar.com.parcialUno.DAO.repository.H2Connection;
import ar.com.parcialUno.model.people.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOH2Impl implements DAO<Employee>, EmployeeLogin, EmployeeEmail {

    // URL de conexión (base en memoria)

    private static final String table = "employee";

    public EmployeeDAOH2Impl() {
        try {
            Connection conn = H2Connection.getConnection();
            Statement stmt = conn.createStatement();
            //org.h2.tools.Server.startWebServer(conn); //LO USO PARA CONECTARME A LA BBDD DE H2 EN LA WEB
            String dropTable = "DROP TABLE IF EXISTS " + table;
            String createTable = "CREATE TABLE IF NOT EXISTS " + table +
                    "(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), lastname VARCHAR(255), age INT, " +
                    "charge VARCHAR(255), email VARCHAR(255), password VARCHAR(255))";
            stmt.executeUpdate(dropTable);
            stmt.executeUpdate(createTable);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Employee employee) {
        try {
            Connection conn = H2Connection.getConnection();
            String createEmployee = "INSERT INTO " + table + "(name, lastname, age, charge, email, password) " +
                    "VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(createEmployee);
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getLastName());
            stmt.setInt(3, employee.getAge());
            stmt.setString(4, employee.getCharge());
            stmt.setString(5, employee.getEmail());
            stmt.setString(6, employee.getPassword());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            //System.out.println("Empleado creadado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        try {
            Connection conn = H2Connection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);
            while (rs.next()) {
                String name = rs.getString("name");
                String lastName = rs.getString("lastname");
                int age = rs.getInt("age");
                String charge = rs.getString("charge");
                String email = rs.getString("email");
                String password = rs.getString("password");
                Employee myEmployee = new Employee(name, lastName, age, charge, email,password);
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
            Connection conn = H2Connection.getConnection();
            String updateEmployee = "UPDATE FROM " + table + "SET name = ?, lastname = ?, age = ?, charge = ?, email = ?" +
                    " password = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateEmployee);
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getLastName());
            stmt.setInt(3, employee.getAge());
            stmt.setString(4, employee.getCharge());
            stmt.setString(5, employee.getEmail());
            stmt.setString(6, employee.getPassword());
            stmt.setInt(7, id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getById(int id) {
        String sql = "SELECT * FROM " + table + " WHERE id = ?";
        try {
            Connection conn = H2Connection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("name"));
                String name = rs.getString("name");
                String lastName = rs.getString("lastname");
                int age = rs.getInt("age");
                String charge = rs.getString("charge");
                String email = rs.getString("email");
                String password = rs.getString("password");
                return new Employee(name, lastName, age, charge,email,password);
            }
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int id) {
        try {
            Connection conn = H2Connection.getConnection();
            String deleteEmployee = "DELETE FROM " + table + " WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(deleteEmployee);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            //System.out.println("El empleado eliminado exitosamente");
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getId(Employee employee) {
        try {
            Connection conn = H2Connection.getConnection();
            String sql = "SELECT id FROM " + table + " WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, employee.getEmail());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee login(Employee employee) {
        try {
            Connection conn = H2Connection.getConnection();
            String sql = "SELECT * FROM " + table + " WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, employee.getEmail());
            stmt.setString(2, employee.getPassword());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String lastName = rs.getString("lastname");
                int age = rs.getInt("age");
                String charge = rs.getString("charge");
                String email = rs.getString("email");
                String password = rs.getString("password");
                return new Employee(name, lastName, age, charge, email,password);
            }
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee getEmployeeByEmail(String anEmail) {
        String sql = "SELECT * FROM " + table +" WHERE email = ?";
        Employee employee = null;
        try {
            Connection conn = H2Connection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, anEmail);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String lastName = rs.getString("lastname");
                int age = rs.getInt("age");
                String charge = rs.getString("charge");
                String miEmail = rs.getString("email");
                String password = rs.getString("password");

                return new Employee(name, lastName, age, charge, miEmail, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
