package ar.com.parcialUno.DAO.adoptationDAO;

import ar.com.parcialUno.DAO.repository.H2Connection;
import ar.com.parcialUno.controller.AdoptantController;
import ar.com.parcialUno.controller.EmployeeController;
import ar.com.parcialUno.controller.PetController;
import ar.com.parcialUno.model.adoptions.Adoption;
import ar.com.parcialUno.model.people.Adoptant;
import ar.com.parcialUno.model.people.Employee;
import ar.com.parcialUno.model.pets.Pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdoptionDAOH2 {

    private static final String table = "adoption";
    Date sqlDate = new java.sql.Date(System.currentTimeMillis());
    EmployeeController employeeController = new EmployeeController();
    PetController petController = new PetController();
    AdoptantController adoptantController = new AdoptantController();

    public AdoptionDAOH2() {
        try {
            Connection conn = H2Connection.getConnection();
            Statement stmt = conn.createStatement();
            //org.h2.tools.Server.startWebServer(conn); //LO USO PARA CONECTARME A LA BBDD DE H2 EN LA WEB
            String dropTable = "DROP TABLE IF EXISTS " + table;
            String createTable = "CREATE TABLE IF NOT EXISTS " + table +
                    "(id INT AUTO_INCREMENT PRIMARY KEY, adop_date date, id_employee INT, id_pet INT, id_adoptant INT)";
            stmt.executeUpdate(dropTable);
            stmt.executeUpdate(createTable);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertAdoption(Employee employee, Pet pet, Adoptant adoptant) {
        try {
            Connection conn = H2Connection.getConnection();
            Integer idEmployee = employeeController.getEmployeeId(employee);
            Integer idPet = petController.getPetId(pet);
            Integer idAdoptant = adoptantController.getIdAdoptant(adoptant);
            String insert = "INSERT INTO " + table + "(adop_date,id_employee,id_pet,id_adoptant) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insert);
            stmt.setDate(1, sqlDate);
            stmt.setInt(2, idEmployee);
            stmt.setInt(3, idPet);
            stmt.setInt(4, idAdoptant);
            stmt.executeUpdate();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<StringBuilder> getAdoptions() {
        List<StringBuilder> adoptions = new ArrayList<>();
        try {
            Connection conn = H2Connection.getConnection();
            String query = "SELECT adp.id as id_adp, adop_date, pt.name as pt_name, ad.name as adp_name, ad.lastname as adp_lastname" +
                    " FROM " + table + " as adp join pet as pt on pt.id = adp.id_pet" +
                    " join adoptant as ad on ad.id = adp.id_adoptant";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Integer idAdoption = rs.getInt("id");
                String adop_date = rs.getString("adop_date");
                String pt_name = rs.getString("pt_name");
                String adop_name = rs.getString("adp_name");
                String adop_lastname = rs.getString("adp_lastname");

                StringBuilder sb = new StringBuilder();
                sb.append("Id Adopcion: ").append(idAdoption).append(" | Fecha: ").append(adop_date)
                        .append(" | Mascota: ").append(pt_name)
                        .append(" | Adoptante: ").append(adop_name)
                        .append(" ").append(adop_lastname);

                adoptions.add(sb);
                //return adoptions;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adoptions;
    }

    public Adoption getAdoption(Integer id) {
        Adoption adoption = null;
        try {
            Connection conn = H2Connection.getConnection();
            String query = "SELECT id_employee,id_pet,id_adoptant FROM " + table + " WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Integer idEmployee = rs.getInt("id_employee");
                Integer idPet = rs.getInt("id_pet");
                Integer idAdoptant = rs.getInt("id_adoptant");

                Employee employee = employeeController.getEmployee(idEmployee);
                Pet pet = petController.getPetById(idPet);
                Adoptant adoptant = adoptantController.getAdoptant(idAdoptant);
                return new Adoption(employee, adoptant,pet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adoption;
    }

    public Boolean deleteAdoptionById(int id) {
        try (Connection conn = H2Connection.getConnection()) {
            String sql = "DELETE FROM " + table + " WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAdoptionById(int idAdoption, int idPet, Adoptant adoptant) {
        try (Connection conn = H2Connection.getConnection()) {
            Integer idAdoptant = adoptantController.getIdAdoptant(adoptant);

            // Si no existe el adoptante, lo creamos
            if (idAdoptant == null) {
                adoptantController.insertAdoptant(adoptant);
                idAdoptant = adoptantController.getIdAdoptant(adoptant);
            }

            String sql = "UPDATE adoption SET id_pet = ?, id_adoptant = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPet);
            stmt.setInt(2, idAdoptant);
            stmt.setInt(3, idAdoption);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



}
