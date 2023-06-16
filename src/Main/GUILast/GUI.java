package Main.GUILast;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Main.Observers.University;

public class GUI {
    private University university;


    private JPanel UniversityDataBase;
    private JPanel topLabel;


    private JButton addStudentButton;
    private JButton addCourseButton;
    private JButton addUniversityEmployeeNDButton;


    private JButton addStudentToTheButton;
    private JButton addUniversityEmployeeButton;


    private JButton switchAlgorytmSalaryOfButtonUEND;
    private JButton switchAlgorytmSalaryOfButton;

    private JButton printDBButton;
    private JButton listOfStudentsToButton1;
    private JButton listOfStudentsToButtonToKick;


    private JButton saveDataButton;
    private JButton wipeDataButton;


    private JLabel OutputZone;

    public GUI() throws IOException, ClassNotFoundException {
        try {
            this.university = University.writeData();
        }
        catch (Exception a){
            System.out.println(a);
            University university = new University();
            this.university = university;
        }
        printDBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OutputZone.setText(university.printDB().replaceAll("\n", "<br/>"));
            }
        });
        saveDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    University.saveData(university);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentAddingTab(university);
            }
        });

        wipeDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                university.wipedata();
            }
        });
        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCourseTab(university);
            }
        });
        addStudentToTheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddStudentToCourse(university);
            }
        });
        addUniversityEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUETab(university);
            }
        });
        addUniversityEmployeeNDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUENDTab(university);
            }
        });
        switchAlgorytmSalaryOfButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                university.switchAlgorytmUE();
            }
        });
        switchAlgorytmSalaryOfButtonUEND.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                university.switchAlgorytmUEND();
            }
        });
        listOfStudentsToButtonToKick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OutputZone.setText(university.listOfStudentsToKick());
            }
        });
        listOfStudentsToButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OutputZone.setText(university.listOfStudentsToBonus());
            }
        });

    }
    public JPanel getUniversityDataBase() {
        return UniversityDataBase;
    }


}





