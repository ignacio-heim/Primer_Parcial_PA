package ar.com.parcialUno.views;

import ar.com.parcialUno.controller.EmployeeController;
import ar.com.parcialUno.model.people.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeRegisterFrame extends JFrame {

    private JTextField txtName;
    private JTextField txtLastName;
    private JTextField txtAge;
    private JTextField txtCharge;
    private JTextField txtEmail;
    private JTextField txtPassword;
    private final EmployeeController ec;

    public EmployeeRegisterFrame() {

        this.ec = new EmployeeController();

        // DATOS GENERALES
        setTitle("Employee Register");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(12,1));


        // CAMPOS
        JPanel namePanel = new JPanel();
        namePanel.add(new JLabel("Name:"));
        txtName = new JTextField(15);
        namePanel.add(txtName);
        add(namePanel);

        JPanel lastNamePanel = new JPanel();
        lastNamePanel.add(new JLabel("Last Name:"));
        txtLastName = new JTextField(15);
        add(lastNamePanel);
        lastNamePanel.add(txtLastName);

        JPanel agePanel = new JPanel();
        agePanel.add(new JLabel("Age:"));
        txtAge = new JTextField(15);
        add(agePanel);
        agePanel.add(txtAge);

        JPanel chargePanel = new JPanel();
        chargePanel.add(new JLabel("Charge:"));
        txtCharge = new JTextField(15);
        add(chargePanel);
        chargePanel.add(txtCharge);

        JPanel emailPanel = new JPanel();
        emailPanel.add(new JLabel("Email:"));
        txtEmail = new JTextField(15);
        add(emailPanel);
        emailPanel.add(txtEmail);

        JPanel passwordPanel = new JPanel();
        passwordPanel.add(new JLabel("Password:"));
        txtPassword = new JTextField(15);
        add(passwordPanel);
        passwordPanel.add(txtPassword);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new EmployeeRegisterFrame.RegisterListener());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(registerButton);
        add(buttonPanel);

        setVisible(true);
    }

    private class RegisterListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String name = txtName.getText();
            String lastName = txtLastName.getText();
            Integer age = Integer.parseInt(txtAge.getText());
            String charge = txtCharge.getText();
            String email = txtEmail.getText();
            String password = txtPassword.getText();

            Employee employee = new Employee(name, lastName, age, charge, email, password);

            LoginFrame login = new LoginFrame(ec);

            ec.saveEmployee(employee);

            login.setVisible(true);
            EmployeeRegisterFrame.this.dispose();
        }
    }
}
