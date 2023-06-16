package Main.Employees;

import java.io.Serializable;

import Main.Employees.Strategy.CountSalaryAlgorytmUEND1;
import Main.Employees.Strategy.CountSalaryAlgorytmUEND2;
import Main.Employees.Strategy.CountSalaryStrategy;

public class UniversityEmployeeND extends Employee implements Serializable {
    private static final long serialVersionUID = -7699999577375837366L;
    private int numberOfPublications;
    private int numberOfCourses;
    private int numberOfOvertimeHours;


    public UniversityEmployeeND(String surname, String name, int age, String post, int numberOfPublications, int numberOfCourses, int numberOfOvertimeHours) {
        super(surname, name, age, post);
        this.numberOfPublications = numberOfPublications;
        this.numberOfCourses = numberOfCourses;
        this.numberOfOvertimeHours = numberOfOvertimeHours;
    }
    public void switchAlgorytm(){
        if(this.CSS == null){
            this.CSS = new CountSalaryAlgorytmUEND1();
            this.countSalary();
        }
        else if (this.CSS instanceof CountSalaryAlgorytmUEND1){
            this.CSS = new CountSalaryAlgorytmUEND2();
            this.countSalary();
        }
        else{
            this.CSS = new CountSalaryAlgorytmUEND1();
            this.countSalary();
        }
    }

    public int countSalary(){
        int x = CSS.countSalary(this);
        this.setSalary(x);
        return x;
    }
    public void setCSSND(CountSalaryStrategy CSS){
        this.CSS = CSS;

    }
    public String toString(){
        return super.toString()+"\n number of publicatons "+ numberOfPublications+" number of courses "+numberOfCourses + " number of overtime hours "+numberOfOvertimeHours;
    }

    public int getNumberOfPublications() {
        return numberOfPublications;
    }

    public int getNumberOfCourses() {
        return numberOfCourses;
    }

    public int getNumberOfOvertimeHours() {
        return numberOfOvertimeHours;
    }
}
