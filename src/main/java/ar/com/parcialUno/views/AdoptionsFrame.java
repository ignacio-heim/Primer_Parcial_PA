package ar.com.parcialUno.views;

import ar.com.parcialUno.app.AppContext;
import ar.com.parcialUno.controller.AdoptantController;
import ar.com.parcialUno.controller.AdoptionController;
import ar.com.parcialUno.model.adoptions.Adoption;
import ar.com.parcialUno.model.people.Employee;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AdoptionsFrame extends JFrame {

    AdoptionController adc = AppContext.adoptionCOontroller;
    Employee employee;


    public AdoptionsFrame(Employee employee) {
        this.employee = employee;

        setTitle("Registro de Adopciones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Solo lectura
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        List<StringBuilder> adopciones = adc.getAdoptions();

        for (StringBuilder sb : adopciones) {
            textArea.append(sb.toString() + "\n");
        }
        JScrollPane scrollPane = new JScrollPane(textArea); // Para scroll si hay muchas líneas
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);

        JPanel bottomPanel = new JPanel(new FlowLayout());

        JLabel label = new JLabel("ID de adopción:");
        JTextField idField = new JTextField(10);
        JButton editButton = new JButton("Editar / Eliminar");
        JButton backButton = new JButton("Volver al inicio");

        editButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());

                Adoption adop = adc.getAdoption(id);

                if (adop != null) {
                    new EditAdoptionFrame(adop, id, employee);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró la adopción con ese ID.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            }
        });

        backButton.addActionListener(e -> {
            dispose();
            new HomeFrame(employee);
        });

        bottomPanel.add(label);
        bottomPanel.add(idField);
        bottomPanel.add(editButton);
        bottomPanel.add(backButton);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
}

