package ar.com.parcialUno.DAO.adoptantDAO;

import ar.com.parcialUno.DAO.DAO;
import ar.com.parcialUno.DAO.repository.H2Connection;
import ar.com.parcialUno.model.people.Adoptant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdoptantDAOH2Impl implements DAO<Adoptant> {

    // URL de conexión (base en memoria)
    private static final String table = "adoptant";

    public AdoptantDAOH2Impl() {
        try {
            Connection conn = H2Connection.getConnection();
            Statement stmt = conn.createStatement();
            //org.h2.tools.Server.startWebServer(conn); //LO USO PARA CONECTARME A LA BBDD DE H2 EN LA WEB
            String dropTable = "DROP TABLE IF EXISTS " + table;
            String createTable = "CREATE TABLE IF NOT EXISTS " + table +
                    "(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), lastname VARCHAR(255), age INT, " +
                    "adress VARCHAR(255))";
            stmt.executeUpdate(dropTable);
            stmt.executeUpdate(createTable);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Adoptant anAdoptant) {
        try {
            Connection conn = H2Connection.getConnection();
            String createEmployee = "INSERT INTO " + table + "(name, lastname, age, adress) " +
                    "VALUES (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(createEmployee);
            stmt.setString(1, anAdoptant.getName());
            stmt.setString(2, anAdoptant.getLastName());
            stmt.setInt(3, anAdoptant.getAge());
            stmt.setString(4, anAdoptant.getAdress());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            //System.out.println("Empleado creadado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Adoptant> getAll() {
        List<Adoptant> adoptants = new ArrayList<>();
        try {
            Connection conn = H2Connection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);
            while (rs.next()) {
                String name = rs.getString("name");
                String lastName = rs.getString("lastname");
                int age = rs.getInt("age");
                String adress = rs.getString("adress");
                adoptants.add(new Adoptant(name, lastName, age, adress));
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adoptants;
    }

    @Override
    public Adoptant getById(int id) {
        try {
            Connection conn = H2Connection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + table + " WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String lastName = rs.getString("lastname");
                int age = rs.getInt("age");
                String adress = rs.getString("adress");
                return new Adoptant(name, lastName, age, adress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(int id, Adoptant anAdoptant) {
        try {
            Connection conn = H2Connection.getConnection();
            String updateEmployee = "UPDATE FROM " + table + "SET name = ?, lastname = ?, age = ?, adress = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateEmployee);
            stmt.setString(1, anAdoptant.getName());
            stmt.setString(2, anAdoptant.getLastName());
            stmt.setInt(3, anAdoptant.getAge());
            stmt.setString(4, anAdoptant.getAdress());
            stmt.setInt(5, id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            Connection conn = H2Connection.getConnection();
            String deleteEmployee = "DELETE FROM " + table + " WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(deleteEmployee);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Integer getId(Adoptant anAdoptant) {
        try {
            Connection conn = H2Connection.getConnection();
            String id = "SELECT id FROM " + table + " WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(id);
            stmt.setString(1, anAdoptant.getName());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
