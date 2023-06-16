package Main.Observable;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private static final long serialVersionUID = -4121137534555707534L;
    private String surname;
    private String name;
    private int age;

    public Person(String surname, String name, int age) {
        this.surname = surname;
        this.name = name;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + age + " y.o.";
    }
}
