package Main.Employees.Strategy;

import Main.Employees.Employee;
import Main.Employees.UniversityEmployee;
import Main.Observers.University;

import java.io.Serializable;

public class CountSalaryAlgorytmUE1 implements CountSalaryStrategy, Serializable {
    private static final long serialVersionUID = -4778014064294564545L;

    @Override
    public int countSalary(Employee employee) {
        UniversityEmployee ue = (UniversityEmployee) employee;
        if(ue.getShift().equals("night")){
            return (int) (1.5*(3000+(ue.getLiczbaNadgodzin()*150)));
        }
        else{
            return 3000+(ue.getLiczbaNadgodzin()*150);
        }
    }

}
