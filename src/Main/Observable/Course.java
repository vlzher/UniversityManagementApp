package Main.Observable;

import Main.Observers.Observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class Course implements Serializable, Subject {
    private static final long serialVersionUID = -8763018891294598855L;
    private String name;
    private HashSet<Student> students;
    private ArrayList<Observer> observers;

    public Course(String name) {
        this.name = name;
        this.students = new HashSet<Student>();
        this.observers= new ArrayList<Observer>();
    }

    @Override
    public String toString() {
        return name;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return name.equals(course.name);
    }

    public String getName() {
        return name;
    }

    public HashSet<Student> getStudents() {
        return students;
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
}
