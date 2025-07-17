package ar.com.parcialUno.DAO.petDAO;

import ar.com.parcialUno.DAO.DAO;
import ar.com.parcialUno.DAO.repository.H2Connection;
import ar.com.parcialUno.model.people.Employee;
import ar.com.parcialUno.model.pets.Cat;
import ar.com.parcialUno.model.pets.Dog;
import ar.com.parcialUno.model.pets.Pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDAOH2Impl implements DAO<Pet> {

    // URL de conexión (base en memoria)
    private static final String table = "pet";

    public PetDAOH2Impl() {
        try {
            Connection conn = H2Connection.getConnection();
            Statement stmt = conn.createStatement();
//            org.h2.tools.Server.startWebServer(conn); //LO USO PARA CONECTARME A LA BBDD DE H2 EN LA WEB
            String dropTable = "DROP TABLE IF EXISTS " + table;
            String createTable = "CREATE TABLE IF NOT EXISTS " + table +
                    "(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), birthDate VARCHAR(255), weight FLOAT, " +
                    "specieID INT)";
            stmt.executeUpdate(dropTable);
            stmt.executeUpdate(createTable);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Pet aPet) {
        try {
            Connection conn = H2Connection.getConnection();
            String createPet = "INSERT INTO " + table + " (name, birthDate, weight, specieID) " +
                    "VALUES (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(createPet);
            stmt.setString(1, aPet.getName());
            stmt.setString(2, aPet.getBirthDate());
            stmt.setDouble(3, aPet.getWeight());
            stmt.setInt(4, aPet.getSpecie());

            stmt.executeUpdate();
            stmt.close();
            conn.close();
//            System.out.println("Mascota creada con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pet> getAll() {
        List<Pet> pets = new ArrayList<>();
        try {
            Connection conn = H2Connection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM pet WHERE id NOT IN (SELECT id_pet FROM adoption)"
            );

            while (rs.next()) {
                String name = rs.getString("name");
                String birthDate = rs.getString("birthDate");
                Double weight = rs.getDouble("weight");
                Integer specie = rs.getInt("specieID");
                if (specie == 1) {
                    Pet dog = new Dog(name, birthDate, weight, specie);
//                    System.out.println(dog.getName() + " " + dog.getBirthDate());
                    pets.add(dog);
                }
                if (specie == 2) {
                    Pet cat = new Cat(name, birthDate, weight, specie);
//                    System.out.println(cat.getName() + " " + cat.getBirthDate());
                    pets.add(cat);
                }
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    @Override
    public Pet getById(int id) {
        String sql = "SELECT * FROM " + table + " WHERE id = ?";
        try {
            Connection conn = H2Connection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String birthDate = rs.getString("birthDate");
                Double weight = rs.getDouble("weight");
                Integer specie = rs.getInt("specieID");
                if (specie == 1) {
                    Pet dog = new Dog(name, birthDate, weight, specie);
                    return dog;
                }
                if (specie == 2) {
                    Pet cat = new Cat(name, birthDate, weight, specie);
                    return cat;
                }
            }
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(int id, Pet aPet) {
        try {
            Connection conn = H2Connection.getConnection();
            String updateEmployee = "UPDATE FROM " + table + "SET name = ?, birthdate = ?, weight = ?, specieID = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateEmployee);
            stmt.setString(1, aPet.getName());
            stmt.setString(2, aPet.getBirthDate());
            stmt.setDouble(3, aPet.getWeight());
            stmt.setInt(4, aPet.getSpecieID());
            stmt.setInt(5, id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
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
//            System.out.println("La mascota eliminado exitosamente");
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer getId(Pet aPet) {
        try {
            Connection conn = H2Connection.getConnection();
            String id = "SELECT id FROM " + table + " WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(id);
            stmt.setString(1, aPet.getName());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Pet> getAllAdoptations() {
        List<Pet> pets = new ArrayList<>();
        try {
            Connection conn = H2Connection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM pet WHERE id IN (SELECT id_pet FROM adoption)"
            );

            while (rs.next()) {
                String name = rs.getString("name");
                String birthDate = rs.getString("birthDate");
                Double weight = rs.getDouble("weight");
                Integer specie = rs.getInt("specieID");
                if (specie == 1) {
                    Pet dog = new Dog(name, birthDate, weight, specie);
//                    System.out.println(dog.getName() + " " + dog.getBirthDate());
                    pets.add(dog);
                }
                if (specie == 2) {
                    Pet cat = new Cat(name, birthDate, weight, specie);
//                    System.out.println(cat.getName() + " " + cat.getBirthDate());
                    pets.add(cat);
                }
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

}
