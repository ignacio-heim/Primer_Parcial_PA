package ar.com.parcialUno.model.people;

public class Employee extends Person {

    private static Employee instance;
    private String aCharge;
    private String email;
    private String password;

    public Employee(String aName, String alastName, Integer anAge, String aCharge, String anEmail, String aPassword) {
        super(aName, alastName, anAge);
        this.aCharge = aCharge;
        this.email = anEmail;
        this.password = aPassword;
    }

    public static Employee getInstance(String aName, String aLastName, Integer anAge, String aCharge, String anEmail, String aPassword) {
        if (instance == null) {
            instance = new Employee(aName,aLastName,anAge ,aCharge, anEmail, aPassword);
        }
        return instance;
    }

    public String getCharge() {
        return this.aCharge;
    }
    public String getEmail() { return this.email; }
    public String getPassword() { return this.password; }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + this.getName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                "aCharge='" + aCharge + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + "}\n";
    }
}

