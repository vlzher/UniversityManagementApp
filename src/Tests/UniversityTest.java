package Tests;

import Main.Employees.Employee;
import Main.Employees.Strategy.CountSalaryAlgorytmUE1;
import Main.Employees.Strategy.CountSalaryAlgorytmUE2;
import Main.Employees.UniversityEmployee;
import Main.Observable.Course;
import Main.Observable.Student;
import Main.Observers.University;

import static org.junit.jupiter.api.Assertions.*;

class UniversityTest {

    @org.junit.jupiter.api.Test
    void addStudent() {
        //check if student has added to db of university
        University university = new University();
        Student student = new Student("/","/",1,1);
        university.addStudent(student);
        assertEquals(student,university.findStudentByID(student.getID()));
    }

    @org.junit.jupiter.api.Test
    void addEmployee() {
        //check if employee has added to db of university
        University university = new University();
        Employee employee = new UniversityEmployee("Aboba","Ahmed",18,"cleaner","night",12);
        university.addEmployee(employee);
        assertTrue(university.getEmployees().contains(employee));
    }

    @org.junit.jupiter.api.Test
    void update() {
        // check how number of actual students updates by adding them to the course
        University university = new University();
        Student student = new Student("Ahmed","Aboba",18,1);
        university.addStudent(student);
        Course course = new Course("1");
        university.addCourse(course);
        student.addCourse(course);
        assertEquals(1,university.getCourses().get(course));



    }

    @org.junit.jupiter.api.Test
    void switchAlgorytmUE() {
        // check how Algorithms are changing
        UniversityEmployee UE = new UniversityEmployee ("Ahmed","Aboba",23,"cleaner","night",12);
        University university = new University();
        university.addEmployee(UE);
        assertNull(UE.getCSS());
        university.switchAlgorytmUE();
        assertTrue(UE.getCSS() instanceof CountSalaryAlgorytmUE1);
        university.switchAlgorytmUE();
        assertTrue(UE.getCSS() instanceof CountSalaryAlgorytmUE2);
        university.switchAlgorytmUE();
        assertTrue(UE.getCSS() instanceof CountSalaryAlgorytmUE1);
    }

    @org.junit.jupiter.api.Test
    void listOfStudentsToBonus() {
        // check if student added with average mark >=5.0
        Student student = new Student("Ahmed","Aboba",18,1);
        University university = new University();
        university.addStudent(student);
        Course course = new Course("1");
        Course course1 = new Course("2");
        Course course2 = new Course("3");

        student.getCourses().put(course, 5.0);
        student.getCourses().put(course1,5.0);
        student.getCourses().put(course2,5.0);

        student.checkForBonus();

        assertTrue(university.getStudentsToBonus().contains(student));
    }
}