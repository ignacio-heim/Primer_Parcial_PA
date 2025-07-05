package ar.com.parcialUno.views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Form extends JFrame implements ActionListener {
    private JLabel label1, label2, label3;
    private JButton boton1;
    private JTextField tf1;

    public Form() {
        setTitle("Adoptant System ");
        this.setSize(400, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        label1 = new JLabel("Interfaz gráfica");
        label1.setBounds(10, 10, 100, 20);
        add(label1);

        label2 = new JLabel("Versión 1.0");
        label2.setBounds(10, 50, 100, 20);
        add(label2);
        boton1 = new JButton("Cerrar");
        boton1.setBounds(10, 80, 100, 20);
        add(boton1);
        boton1.addActionListener(this); //HACE REFERENCIA AL FORMULARIO

        tf1 = new JTextField(20);
        JPanel panel = new JPanel();
        panel.add(label1);
        panel.add(tf1);
        this.add(panel);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            Form formOne = new Form();
            formOne.setBounds(100, 100, 450, 300);
            formOne.setVisible(true);
            formOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
