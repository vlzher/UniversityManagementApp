package Main.Observable;

import Main.Observers.Observer;
import Main.Observers.University;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import java.util.Random;

public class Student extends Person implements Subject, Serializable {
    private static final long serialVersionUID = 5638891750432206229L;
    private int ID;
    private HashMap<Course,Double> courses;
    private boolean toKick;
    private boolean toBonus;
    private HashSet<University> universities = new HashSet<>();
    private ArrayList<Observer> observers = new ArrayList<>();

    public Student(String surname, String name, int age, int ID) {
        super(surname, name, age);
        this.ID = ID;
        this.courses = new HashMap<Course,Double>();


    }

    public HashSet<University> getUniversities() {
        return universities;
    }

    public int getID() {
        return ID;
    }

    public void addCourse(Course course){
        Random rand1 = new Random();
        this.courses.put(course,(double)(rand1.nextInt(10)/2));

        course.getStudents().add(this);
        course.notifyObservers();
        checkForBonus();
        checkForKick();
    }
    public void checkForKick(){
        int i = 0;
        for(Course course: courses.keySet()){
            if(courses.get(course)<3.0){
                i++;
            }
        }
        if (i>=3){
            this.toKick = true;
            notifyObservers();

        }
    }
    public String coursesToString(){
        StringBuilder strb = new StringBuilder();
        for (Course course: courses.keySet()){
            strb.append(course.toString()).append(" : ").append(courses.get(course)).append(" ");
        }
        return strb.toString();
    }

    @Override
    public String toString() {
        return super.toString()+ "\n " + "ID" + ID + " courses = " + this.coursesToString();

    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(this);
        }
    }

    public boolean isToBonus() {
        return toBonus;
    }

    public void setToBonus(boolean toBonus) {
        this.toBonus = toBonus;
    }

    public boolean isToKick() {
        return toKick;
    }
    public void checkForBonus(){
        int sum = 0;
        int numberOfCourses = courses.size();
        for(Course course: courses.keySet()){
            sum+= courses.get(course);
        }
        if(sum/numberOfCourses>=5){
            this.setToBonus(true);
            notifyObservers();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return ID == student.ID;
    }

    @Override
    public int hashCode() {
        return ID;
    }

    public HashMap<Course, Double> getCourses() {
        return courses;
    }
}
