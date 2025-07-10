package ar.com.parcialUno.DAO.adoptationDAO;

import ar.com.parcialUno.DAO.repository.H2Connection;
import ar.com.parcialUno.controller.AdoptantController;
import ar.com.parcialUno.controller.EmployeeController;
import ar.com.parcialUno.controller.PetController;
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

    public List<String> getAdoptions() {
        List<String> adoptions = new ArrayList<>();
        try {
            Connection conn = H2Connection.getConnection();
            String query = "SELECT adop_date, pt.name as pt_name, ad.name as adp_name, ad.lastname as adp_lastname" +
                    " FROM " + table + " as adp join pet as pt on pt.id = adp.id_pet" +
                    " join adoptant as ad on ad.id = adp.id_adoptant";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String adop_date = rs.getString("adop_date");
                String pt_name = rs.getString("pt_name");
                String adop_name = rs.getString("adp_name");
                String adop_lastname = rs.getString("adp_lastname");

                StringBuilder sb = new StringBuilder();
                sb.append("Fecha: ").append(adop_date)
                        .append(" | Mascota: ").append(pt_name)
                        .append(" | Adoptante: ").append(adop_name)
                        .append(" ").append(adop_lastname);

                adoptions.add(sb.toString());
                return adoptions;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adoptions;
    }

}
