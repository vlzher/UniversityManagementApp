package Main.Observers;

import Main.ComparatorStudentByID;
import Main.Employees.Employee;
import Main.Employees.UniversityEmployee;
import Main.Employees.UniversityEmployeeND;
import Main.Observable.Course;
import Main.Observable.Student;
import Main.Observable.Subject;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class University implements Observer, Serializable {

    private static final long serialVersionUID = -9191554660897484007L;
    private HashSet<Student> students;
    private HashMap<Course,Integer> courses;
    private HashSet<Student> studentsToKick;
    private HashSet<Student> studentsToBonus;
    private HashSet<Employee> employees;

    public University() {
        this.students = new HashSet<Student>();
        this.courses = new HashMap<Course,Integer>();
        this.studentsToKick = new HashSet<Student>();
        this.studentsToBonus = new HashSet<Student>();
        this.employees = new HashSet<Employee>();
    }
    public void addCourse(Course course){
        courses.put(course,0);
        course.attach(this);

    }
    public void addStudent(Student student){
        students.add(student);
        student.getUniversities().add(this);
        student.attach((Observer) this);
    }
    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public HashSet<Student> getStudents() {
        return students;
    }

    public HashMap<Course, Integer> getCourses() {
        return courses;
    }

    @Override
    public void update(Subject subject) {
        if(subject instanceof Student) {
            Student student = (Student) subject;
            if (student.isToKick()) {
                studentsToKick.add(student);
            }
            if (student.isToBonus()) {
                studentsToBonus.add(student);
            }
            updateCourses();
        }
        if(subject instanceof Course){
            Course course = (Course) subject;
            courses.put(course,course.getStudents().size());
        }
    }
    public void updateCourses(){
        for(Course course : courses.keySet()){
            courses.put(course,course.getStudents().size());
        }
    }
    public Student findStudentByID(int id){
        for(Student student : students){
            if(id == student.getID()){
                return student;

            }
        }
        return null;
    }
    public Course findCourseByName(String name){
        for(Course course : courses.keySet()){
            if(name.equals(course.getName())){
                return course;
            }
        }
        return null;
    }
    public void wipedata(){
        this.courses.clear();
        this.employees.clear();
        this.students.clear();
        this.studentsToBonus.clear();
        this.studentsToKick.clear();
    }
    public static void saveData(University university) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("database.txt"));
        oos.writeObject(university);
        oos.flush();
        oos.close();
    }
    public static University writeData() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("database.txt"));
        University university = (University) ois.readObject();
        ois.close();
        return university;
    }
    public String printDB(){
        StringBuilder strb = new StringBuilder();
        strb.append("<html> Data base:\n");
        strb.append("Students: \n");
        for(Student student : students){
            strb.append(student.toString()).append("\n");
        }
        strb.append("Courses: \n");
        for(Course course : courses.keySet()){
            strb.append(course.toString()).append(" number of students: ").append(courses.get(course)).append("\n");
        }
        strb.append("Employees: \n");
        for(Employee employee : employees){
            strb.append(employee.toString()).append("\n");
        }
        strb.append("</html>");
        return strb.toString();

    }
    public void switchAlgorytmUE(){
        for(Employee emp : employees){
            if(emp instanceof UniversityEmployee){
                ((UniversityEmployee) emp).switchAlgorytm();
            }
        }
    }
    public void switchAlgorytmUEND(){
        for(Employee emp : employees){
            if(emp instanceof UniversityEmployeeND){
                ((UniversityEmployeeND) emp).switchAlgorytm();
            }
        }
    }
    public String listOfStudentsToKick(){
        StringBuilder strb = new StringBuilder();
        strb.append("<html> ").append("List students to kick<br/>");
        for (Student student : studentsToKick){
            strb.append(student.toString().replaceAll("\n", "<br/>")).append("<br/>");
        }
        strb.append("</html>");
        return strb.toString();
    }
    public String listOfStudentsToBonus(){
        StringBuilder strb = new StringBuilder();
        strb.append("<html> ").append("List students to bonus<br/>");
        ArrayList<Student> studentsToBonuslist = new ArrayList<Student>(studentsToBonus);
        studentsToBonuslist.sort(new ComparatorStudentByID());
        for (Student student : studentsToBonuslist){
            strb.append(student.toString().replaceAll("\n", "<br/>")).append("<br/>");
        }
        strb.append("</html>");
        return strb.toString();
    }

    public HashSet<Employee> getEmployees() {
        return employees;
    }

    public HashSet<Student> getStudentsToKick() {
        return studentsToKick;
    }

    public HashSet<Student> getStudentsToBonus() {
        return studentsToBonus;
    }
}
