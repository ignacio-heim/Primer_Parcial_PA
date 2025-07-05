package ar.com.parcialUno.model.people;

public abstract class Person {

    private String name;
    private String lastName;
    private Integer age;

    public Person(String aName, String lastname, Integer anAge) {
        this.name = aName;
        this.lastName = lastname;
        this.age = anAge;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() { return this.lastName; }

    public Integer getAge() {
        return this.age;
    }
}
