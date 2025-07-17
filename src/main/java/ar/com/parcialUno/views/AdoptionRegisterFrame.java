package ar.com.parcialUno.views;

import ar.com.parcialUno.controller.AdoptantController;
import ar.com.parcialUno.controller.AdoptionController;
import ar.com.parcialUno.controller.EmployeeController;
import ar.com.parcialUno.controller.PetController;
import ar.com.parcialUno.model.people.Adoptant;
import ar.com.parcialUno.model.people.Employee;
import ar.com.parcialUno.model.pets.Pet;
import ar.com.parcialUno.app.AppContext;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

public class AdoptionRegisterFrame extends JFrame {

    ImageIcon icono = new ImageIcon("src/main/java/ar/com/parcialUno/resources/img/dg.jpg");
    EmployeeController ec = AppContext.employeeController;
    PetController pc = AppContext.petController;
    AdoptantController adc = AppContext.adoptantController;

    Adoptant anAdoptant;
    Pet aPet;
    Employee anEmployee;


    public AdoptionRegisterFrame(Employee employee) {

        anEmployee = employee;

        setTitle("Registro de adopcion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(0,1));

        List<Pet> pets = AppContext.petController.getAllPets();
        List<Adoptant> adoptants = AppContext.adoptantController.getAllAdoptants();

        JPanel userPanelPets = new JPanel();
        userPanelPets.setLayout(new BorderLayout());
        JLabel labelPets = new JLabel("Mascotas");
        labelPets.setHorizontalAlignment(SwingConstants.CENTER);
        labelPets.setBorder(new EmptyBorder(30, 0, 0, 0));
        userPanelPets.add(labelPets, BorderLayout.NORTH);

        JComboBox<Pet> comboBoxPets = new JComboBox<>();
        for (Pet aPet : pets) {
            comboBoxPets.addItem(aPet);
        }
        userPanelPets.add(comboBoxPets, BorderLayout.CENTER);
        comboBoxPets.addActionListener(e -> {
            aPet = (Pet) comboBoxPets.getSelectedItem();
        });


        JPanel userPanelAdoptants = new JPanel();
        userPanelAdoptants.setLayout(new BorderLayout());
        JLabel labelAdoptants = new JLabel("Adoptantes");
        labelAdoptants.setHorizontalAlignment(SwingConstants.CENTER);
        labelAdoptants.setBorder(new EmptyBorder(30, 0, 0, 0));
        userPanelAdoptants.add(labelAdoptants, BorderLayout.NORTH);

        JComboBox<Adoptant> comboBoxAdoptants = new JComboBox<>();
        for (Adoptant anAdoptant : adoptants) {
            comboBoxAdoptants.addItem(anAdoptant);
        }
        userPanelAdoptants.add(comboBoxAdoptants, BorderLayout.CENTER);
        comboBoxPets.addActionListener(e -> {
            anAdoptant = (Adoptant) comboBoxAdoptants.getSelectedItem();
        });

        JButton registerButton = new JButton("Confirmar Adopción");
        registerButton.addActionListener(new AdoptionRegisterFrame.ConfirmAdoption());
        JPanel registerPanel = new JPanel();
        registerPanel.add(registerButton);

        JButton backButton = new JButton("Volver al inicio");
        backButton.addActionListener(e -> {
            dispose();
            new HomeFrame(anEmployee);
        });
        registerPanel.add(backButton);

        add(userPanelPets);
        add(userPanelAdoptants);
        add(registerPanel);

        setVisible(true);

    }

    class ConfirmAdoption implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            int opcion = JOptionPane.showConfirmDialog(
                    null,
                    "¿Confirmás el registro de la adopción?",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    icono
            );
            if (opcion == JOptionPane.YES_OPTION) {


                AdoptionController ac = AppContext.adoptionCOontroller;

                Integer idEmployee = ec.getEmployeeId(anEmployee);
                Integer idPet = pc.getPetId(aPet);
                Integer idAdoptant = adc.getIdAdoptant(anAdoptant);

                anEmployee = ec.getEmployee(idEmployee);
                aPet = pc.getPetById(idPet);
                anAdoptant = adc.getAdoptant(idAdoptant);

                ac.insertAdoption(anEmployee,aPet,anAdoptant);

                ConfirmAdoptionFrame confirm = new ConfirmAdoptionFrame(anEmployee, anAdoptant, aPet);

                //setVisible(true);
            } else {
                // Acción si elige NO (opcional)
                System.out.println("Adopción cancelada por el usuario.");
            }

        }
    }

}