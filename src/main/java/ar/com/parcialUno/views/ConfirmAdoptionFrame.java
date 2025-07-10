package ar.com.parcialUno.views;

import ar.com.parcialUno.infrastructure.pdf.PDFGenerator;
import ar.com.parcialUno.infrastructure.ticket.PrintAdoptionTicket;
import ar.com.parcialUno.model.adoptions.Adoption;
import ar.com.parcialUno.model.people.Adoptant;
import ar.com.parcialUno.model.people.Employee;
import ar.com.parcialUno.model.pets.Pet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Random;

public class ConfirmAdoptionFrame extends JFrame {

    public Employee anEmployee;
    public Adoptant anAdoptant;
    public Pet aPet;

    public ConfirmAdoptionFrame(Employee anEmployee, Adoptant anAdoptant, Pet aPet) {

        this.anEmployee = anEmployee;
        this.anAdoptant = anAdoptant;
        this.aPet = aPet;

        setTitle("Registro de adopcion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("¡Adopción confirmada!");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(new EmptyBorder(30, 0, 0, 0));
        add(label, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));

        JButton downloadButton = new JButton("Descargar Ticket Adopción");
        downloadButton.addActionListener(new ConfirmAdoptionFrame.DownloadTicketPDF());
        downloadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        downloadButton.setMaximumSize(new Dimension(200, 30));
        buttonsPanel.add(downloadButton);

        /*
        JButton emailButton = new JButton("Enviar Ticket por Correo");
        emailButton.addActionListener(new ConfirmAdoptionFrame.SendTicketPDF());
        emailButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        emailButton.setMaximumSize(new Dimension(200, 30));
        buttonsPanel.add(emailButton);
        */

        add(buttonsPanel, BorderLayout.CENTER); // ahora sí, ambos se ven

        setVisible(true);

    }

    class DownloadTicketPDF implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Adoption adoption = new Adoption(anEmployee, anAdoptant, aPet);

            PrintAdoptionTicket adoptionTicket = new PrintAdoptionTicket(adoption);

            String nombreArchivo = adoptionTicket.printTicket();

            String petName = aPet.getName();
            String adoptantFullName = anAdoptant.getName()+"_"+anAdoptant.getLastName();

            Random random = new Random();
            int number = random.nextInt(1000) + 1;

            PDFGenerator.generatePDF(nombreArchivo, "Ticket-"+petName+"-"+adoptantFullName+"-" +
                    number+".pdf");
        }
    }

    class SendTicketPDF implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }

}
