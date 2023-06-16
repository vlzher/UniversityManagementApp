package Main;

import Main.Observable.Student;

import java.util.Comparator;
import java.util.List;

public class ComparatorStudentByID implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getID()<o2.getID()){
            return -1;
        }
        if(o1.getID()>o2.getID()){
            return 1;
        }
        else{
            return 0;
        }
    }
}
