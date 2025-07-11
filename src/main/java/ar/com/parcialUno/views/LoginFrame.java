package ar.com.parcialUno.views;

import ar.com.parcialUno.controller.EmployeeController;
import ar.com.parcialUno.model.people.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    private JTextField txtEmail;
    private JTextField txtPassword;
    private final EmployeeController ec;

    public LoginFrame(EmployeeController  ec) {

        this.ec = ec;

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4,1));

        JPanel userPanel = new JPanel();
        userPanel.add(new JLabel("Email:"));
        txtEmail = new JTextField(15);
        userPanel.add(txtEmail);
        add(userPanel);

        JPanel passwordPanel = new JPanel();
        passwordPanel.add(new JLabel("Password:"));
        txtPassword = new JPasswordField(15);
        passwordPanel.add(txtPassword);
        add(passwordPanel);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginListener());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);
        add(buttonPanel);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new RegisterWindow());
        JPanel registerPanel = new JPanel();
        registerPanel.add(registerButton);
        add(registerPanel);

        setVisible(true);
    }

    private class LoginListener extends Component implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String email = txtEmail.getText();
            String password = txtPassword.getText();

            Employee employee = ec.getEmployeeByEmail(email);

            if (employee == null) {
                JOptionPane.showMessageDialog(null, "Correo no registrado", "Error", JOptionPane.ERROR_MESSAGE);
            }

            employee = ec.login(employee.getEmail(), password);

            if (employee != null) {
                JOptionPane.showMessageDialog(null, "¡Bienvenido, " + employee.getName() + "!");

                HomeFrame home = new HomeFrame(employee);
                //home.setVisible(true);
                LoginFrame.this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales inválidas", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private class RegisterWindow implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            EmployeeRegisterFrame register = new EmployeeRegisterFrame();
            //register.setVisible(true);
            LoginFrame.this.dispose();
        }
    }

}
