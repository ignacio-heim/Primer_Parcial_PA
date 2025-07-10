package ar.com.parcialUno.DAO.petDAO;

import ar.com.parcialUno.DAO.repository.H2Connection;
import ar.com.parcialUno.model.pets.Specie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpecieDAOH2 {

    Connection conn = H2Connection.getConnection();
    private static final String table = "specie";

    public SpecieDAOH2() {
        try {
            Statement stmt = conn.createStatement();
//            org.h2.tools.Server.startWebServer(conn); //LO USO PARA CONECTARME A LA BBDD DE H2 EN LA WEB
            String dropTable = "DROP TABLE IF EXISTS " + table;
            String createTable = "CREATE TABLE IF NOT EXISTS " + table +
                    "(id INT AUTO_INCREMENT PRIMARY KEY, specie VARCHAR(255), breed VARCHAR(255))";
            stmt.executeUpdate(dropTable);
            stmt.executeUpdate(createTable);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertSpecie(Specie anSpecie) {
        try {
            String createSpecie = "INSERT INTO " + table + " (specie, breed) VALUES (?,?)";
            PreparedStatement stmt = conn.prepareStatement(createSpecie);
            stmt.setString(1, anSpecie.getSpecie());
            stmt.setString(2, anSpecie.getBreed());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSpecie(Integer id) {
        try {
            String deleteSpecie = "DELETE FROM " + table + " WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(deleteSpecie);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Specie getSpecie(Integer id) {
        Specie specie = null;
        try {
            String selectSpecie = "SELECT * FROM " + table + " WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(selectSpecie);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                    String aSpecie = rs.getString("specie");
                    String aBreed = rs.getString("breed");
                    specie = new Specie(aSpecie, aBreed);
                    return specie;
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return specie;
    }

    public List<Specie> getSpecies() {
        List<Specie> species = null;
        try {
            String selectSpecie = "SELECT * FROM " + table;
            PreparedStatement stmt = conn.prepareStatement(selectSpecie);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String aSpecie = rs.getString("specie");
                String aBreed = rs.getString("breed");
                species = new ArrayList<Specie>();
                species.add(new Specie(aSpecie, aBreed));
                return species;
            }
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return species;
    }

    public void updateSpecie(Integer id, Specie anSpecie) {
        try {
            String updateSpecie = "UPDATE " + table + " SET specie = ?, breed = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateSpecie);
            stmt.setString(1, anSpecie.getSpecie());
            stmt.setString(2, anSpecie.getBreed());
            stmt.setInt(3, id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
