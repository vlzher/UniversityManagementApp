package Main.Employees;
import Main.Employees.Strategy.CountSalaryAlgorytmUE1;
import Main.Employees.Strategy.CountSalaryAlgorytmUE2;
import Main.Employees.Strategy.CountSalaryStrategy;

import java.io.Serializable;

public class UniversityEmployee extends Employee implements Serializable {
    private static final long serialVersionUID = 2026275398098731860L;
    private String shift;
    private int liczbaNadgodzin;

    public UniversityEmployee(String surname, String name, int age, String post, String shift, int liczbaNadgodzin) {
        super(surname, name, age, post);
        this.shift = shift;
        this.liczbaNadgodzin = liczbaNadgodzin;
    }

    public void setAlgorytmOfCountingSalary(CountSalaryStrategy CSS){
        this.CSS = CSS;
    }

    public String getShift() {
        return shift;
    }

    public int getLiczbaNadgodzin() {
        return liczbaNadgodzin;
    }
    public int countSalary(){
        int x = CSS.countSalary(this);
        this.setSalary(x);
        return x;
    }
    public String toString(){
        return super.toString()+"\n shift: "+ shift+" Liczba nadgodzin: "+ liczbaNadgodzin;
    }
    public void switchAlgorytm(){
        if(this.CSS == null){
            this.CSS = new CountSalaryAlgorytmUE1();
            this.countSalary();
        }
        else if (this.CSS instanceof CountSalaryAlgorytmUE1){
            this.CSS = new CountSalaryAlgorytmUE2();
            this.countSalary();
        }
        else{
            this.CSS = new CountSalaryAlgorytmUE1();
            this.countSalary();
        }
    }

    public CountSalaryStrategy getCSS() {
        return CSS;
    }
}
