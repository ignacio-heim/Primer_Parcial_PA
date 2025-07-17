package ar.com.parcialUno.views;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import ar.com.parcialUno.model.people.Employee;
import ar.com.parcialUno.model.pets.Pet;
import ar.com.parcialUno.model.adoptions.Adoption;
import ar.com.parcialUno.model.people.Adoptant;
import ar.com.parcialUno.controller.AdoptionController;
import ar.com.parcialUno.controller.PetController;
import ar.com.parcialUno.app.AppContext;

public class EditAdoptionFrame extends JFrame {

    AdoptionController adc = AppContext.adoptionCOontroller;
    PetController pc = AppContext.petController;
    private Integer idAdoption;
    private Pet aPet;
    private Adoptant adoptant;
    Employee employee;

    public EditAdoptionFrame(Adoption adoption, Integer id, Employee employee) {
        this.idAdoption = id;
        setTitle("Editar Adopción");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 350);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel del formulario
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // ComboBox de mascotas
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Mascota:"), gbc);

        JComboBox<Pet> comboBoxPets = new JComboBox<>();
        List<Pet> pets = pc.getAllAdoptations();
        for (Pet pet : pets) {
            comboBoxPets.addItem(pet);
        }
        aPet = (Pet) comboBoxPets.getSelectedItem();
        gbc.gridx = 1;
        formPanel.add(comboBoxPets, gbc);

        // Nombre adoptante
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("Nombre adoptante:"), gbc);
        JTextField nameField = new JTextField(adoption.getNameAdoptant());
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        // Apellido adoptante
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("Apellido adoptante:"), gbc);
        JTextField lastNameField = new JTextField(adoption.getLastNameAdopt());
        gbc.gridx = 1;
        formPanel.add(lastNameField, gbc);

        // Edad
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("Edad del adoptante:"), gbc);
        JTextField ageField = new JTextField(adoption.getAgeAdoptant().toString());
        gbc.gridx = 1;
        formPanel.add(ageField, gbc);

        // Dirección
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("Dirección del adoptante:"), gbc);
        JTextField adressField = new JTextField(adoption.getAdressAdoptant());
        gbc.gridx = 1;
        formPanel.add(adressField, gbc);

        // Panel de botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton saveButton = new JButton("Guardar");
        JButton deleteButton = new JButton("Eliminar");
        buttonPanel.add(saveButton);
        buttonPanel.add(deleteButton);

        // Botón guardar
        saveButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String lastName = lastNameField.getText().trim();
            String adress = adressField.getText().trim();
            Pet selectedPet = (Pet) comboBoxPets.getSelectedItem();

            if (name.isEmpty() || lastName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nombre y Apellido del adoptante son obligatorios.");
                return;
            }

            Integer age;
            try {
                age = Integer.parseInt(ageField.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Edad inválida.");
                return;
            }

            adoptant = new Adoptant(name, lastName, age, adress);
            Integer idPet = pc.getPetId(selectedPet);

            System.out.println(idAdoption);
            System.out.println(idPet);
            System.out.println(adoptant);

            Boolean updated = adc.updateAdoptionById(idAdoption, idPet, adoptant);
            if (updated) {
                JOptionPane.showMessageDialog(this, "Adopción actualizada correctamente.");
                dispose();
                new AdoptionsFrame(employee);
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar la adopción.");
            }
        });

        // Botón eliminar
        deleteButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que querés eliminar?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                Boolean deleted = adc.deleteAdoption(idAdoption);
                if (deleted) {
                    JOptionPane.showMessageDialog(this, "Adopción eliminada.");
                    dispose();
                    new AdoptionsFrame(employee);
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar.");
                }
            }
        });

        // Agregar paneles
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
}
