package ar.com.parcialUno;

public class Employee extends Person {

    private static Employee instance;
    private String aCharge;

    private Employee(String aName, Integer anAge, String aCharge) {
        super(aName, anAge);
        this.aCharge = aCharge;
    }

    public static Employee getInstance(String aName, Integer anAge, String aCharge) {
        if (instance == null) {
            instance = new Employee(aName,anAge, aCharge);
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

