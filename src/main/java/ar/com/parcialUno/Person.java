package ar.com.parcialUno;

abstract class Person {

    private String name;
    private Integer age;

    public Person(String aName, Integer anAge) {
        this.name = aName;
        this.age = anAge;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }
}
