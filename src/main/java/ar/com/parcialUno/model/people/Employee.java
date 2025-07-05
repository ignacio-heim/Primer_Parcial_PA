package ar.com.parcialUno.model.people;

public class Employee extends Person {

    private static Employee instance;
    private String aCharge;

    public Employee(String aName, String alastName, Integer anAge, String aCharge) {
        super(aName, alastName, anAge);
        this.aCharge = aCharge;
    }

    public static Employee getInstance(String aName, String aLastName, Integer anAge, String aCharge) {
        if (instance == null) {
            instance = new Employee(aName,aLastName,anAge ,aCharge);
        }
        return instance;
    }

    public String getCharge() {
        return this.aCharge;
    }

    @Override
    public String toString() {
        return "Employee: \n" +"\tName: "+ this.getName() + ". Age " + this.getAge();
    }
}

