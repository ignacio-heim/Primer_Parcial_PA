package ar.com.parcialUno.views;

import ar.com.parcialUno.app.AppContext;
import ar.com.parcialUno.controller.AdoptantController;
import ar.com.parcialUno.controller.AdoptionController;
import ar.com.parcialUno.controller.PetController;
import ar.com.parcialUno.model.pets.Pet;

import javax.swing.*;

public class ModifiedAdoptionFrame extends JFrame {

    AdoptionController adc = AppContext.adoptionCOontroller;
    AdoptantController ac = AppContext.adoptantController;
    PetController pc = AppContext.petController;

    private JComboBox<Pet> petComboBox;
    private JTextField direccionField;
    private JButton saveButton;

    public ModifiedAdoptionFrame() {
        /*
        setTitle("Editar Adopción");
        setSize(400, 300);
        setLayout(new GridLayout(4, 2));

        // Dirección del adoptante
        add(new JLabel("Dirección:"));
        direccionField = new JTextField(adc.);
        add(direccionField);

        // Mascotas
        add(new JLabel("Mascota:"));
        petComboBox = new JComboBox<>();
        for (Pet p : pc.getAllPets()) {
            petComboBox.addItem(p);
            if (p.getId().equals(adoptionEntry.getPet().getId())) {
                petComboBox.setSelectedItem(p);
            }
        }
        add(petComboBox);

        saveButton = new JButton("Guardar Cambios");
        saveButton.addActionListener(e -> guardarCambios());
        add(saveButton);

        setVisible(true);
    }

    private void guardarCambios() {
        String nuevaDireccion = direccionField.getText();
        Pet nuevaMascota = (Pet) petComboBox.getSelectedItem();

        // Actualizar dirección del adoptante
        Adoptant adoptant = adoptionEntry.getAdoptant();
        adoptant.setAddress(nuevaDireccion);
        adoptantController.updateAdoptant(adoptant);

        // Actualizar adopción
        adoptionController.updateAdoption(
                adoptionEntry.getId(),
                adoptionEntry.getEmployee(),
                nuevaMascota,
                adoptant
        );

        JOptionPane.showMessageDialog(this, "Adopción actualizada correctamente.");
        dispose(); // Cierra el frame
         */
    }

}
