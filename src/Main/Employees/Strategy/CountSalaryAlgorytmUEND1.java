package Main.Employees.Strategy;

import Main.Employees.Employee;

import Main.Employees.UniversityEmployeeND;

import java.io.Serializable;

public class CountSalaryAlgorytmUEND1 implements CountSalaryStrategy, Serializable
{
    private static final long serialVersionUID = 7179103721966290767L;

    @Override
    public int countSalary(Employee employee) {
        UniversityEmployeeND ueND = (UniversityEmployeeND) employee;
        return (ueND.getNumberOfCourses()+ ueND.getNumberOfPublications())*300+40* ueND.getNumberOfOvertimeHours();
    }
}
