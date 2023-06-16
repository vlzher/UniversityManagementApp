package Employees;
import Main.Employees.Strategy.CountSalaryStrategy;
import Main.Observable.Person;

import java.io.Serializable;

public abstract class Employee extends Person implements Serializable {
    private static final long serialVersionUID = 5411841818832634957L;
    private String post;
    private int salary;
    protected CountSalaryStrategy CSS;

    public Employee(String surname, String name, int age, String post) {
        super(surname, name, age);
        this.post = post;
        this.salary = 0;
    }


    public void setPost(String post) {
        this.post = post;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPost() {
        return post;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString()+" post: " + post + " salary: " + salary;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (salary != employee.salary) return false;
        return post != null ? post.equals(employee.post) : employee.post == null;
    }

    @Override
    public int hashCode() {
        int result = post != null ? post.hashCode() : 0;
        result = 31 * result + salary;
        return result;
    }
}
