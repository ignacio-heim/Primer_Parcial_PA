package ar.com.parcialUno.infrastructure.email;

public interface InterfaceEmailSender {
    public void sendEmail(String to, String subject, String body);
}
