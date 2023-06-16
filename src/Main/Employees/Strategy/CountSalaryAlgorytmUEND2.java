package Main.Employees.Strategy;

import Main.Employees.Employee;
import Main.Employees.UniversityEmployeeND;

import java.io.Serializable;

public class CountSalaryAlgorytmUEND2 implements CountSalaryStrategy, Serializable {

    private static final long serialVersionUID = -3141739285885482527L;

    @Override
    public int countSalary(Employee employee) {
        UniversityEmployeeND ueND = (UniversityEmployeeND) employee;
        return (ueND.getNumberOfPublications()*2)*150+ueND.getNumberOfCourses()*200+ueND.getNumberOfOvertimeHours()*150+1;
    }
}
