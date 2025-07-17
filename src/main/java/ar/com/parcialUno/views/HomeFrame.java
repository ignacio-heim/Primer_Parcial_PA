package ar.com.parcialUno.views;

import ar.com.parcialUno.controller.AdoptionController;
import ar.com.parcialUno.controller.EmployeeController;
import ar.com.parcialUno.model.people.Employee;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeFrame extends JFrame {

    Employee employee;
    
    

    public HomeFrame(Employee employee) {

        this.employee = employee;

        setTitle("Inicio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        JLabel label = new JLabel("Bienvenido " + employee.getName());
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(new EmptyBorder(30, 0, 0, 0));
        add(label, BorderLayout.NORTH);

        setLayout(new GridLayout(0,1));
        setVisible(true);

        JButton registerButton = new JButton("Registrar Adopción");
        registerButton.addActionListener(new RegisterAdoptionWindow());
        JPanel registerPanel = new JPanel();
        registerPanel.add(registerButton);
        add(registerPanel);

        JButton adoptionButton = new JButton("Adopciones");
        adoptionButton.addActionListener(new AdoptionWindow());
        JPanel adoptionPanel = new JPanel();
        adoptionPanel.add(adoptionButton);
        add(adoptionPanel);

        /*
        JButton petButton = new JButton("Mascotas");
        petButton.addActionListener(new HomeFrame.PetWindow());
        JPanel petPanel = new JPanel();
        petPanel.add(petButton);
        add(petPanel);



        JButton adoptansButton = new JButton("Adoptantes");
        adoptansButton.addActionListener(new HomeFrame.AdoptansWindow());
        JPanel adoptansPanel = new JPanel();
        adoptansPanel.add(adoptansButton);
        add(adoptansPanel);
         */
    }

    public class RegisterAdoptionWindow implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AdoptionRegisterFrame arf = new AdoptionRegisterFrame(employee);
            arf.setVisible(true);
        }
    }
    public class AdoptionWindow implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AdoptionsFrame af = new AdoptionsFrame(employee);

        }
    }

    public class PetWindow implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }

    }

    public class AdoptansWindow implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


}