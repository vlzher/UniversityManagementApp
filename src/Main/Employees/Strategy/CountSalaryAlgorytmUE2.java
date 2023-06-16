package Main.Employees.Strategy;

import Main.Employees.Employee;

import Main.Employees.UniversityEmployee;

import java.io.Serializable;

public class CountSalaryAlgorytmUE2 implements CountSalaryStrategy, Serializable {

    private static final long serialVersionUID = -822764266185818081L;

    @Override
    public int countSalary(Employee employee) {
        UniversityEmployee ue = (UniversityEmployee) employee;

        return ue.getLiczbaNadgodzin()*200+3500;
    }
}
