package Main.GUILast;

import Main.Observable.Student;
import Main.Observable.Course;
import Main.Observers.University;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AddStudentToCourse {
    private University university;
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();

    public AddStudentToCourse(University university) {
        this.university = university;
        panels();
    }

    private void panels() {
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(null);


        JLabel labelMain = new JLabel("Enter the information: ");
        labelMain.setBounds(10, 5, 165, 25);


        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(10, 30, 150, 25);
        JTextField idText = new JTextField(20);
        idText.setBounds(120, 30, 165, 25);


        JLabel nameLabel = new JLabel("Name of Course: ");
        nameLabel.setBounds(10, 60, 150, 25);
        JTextField nameText = new JTextField(20);
        nameText.setBounds(120, 60, 165, 25);


        JButton button = new JButton("Register");
        button.setBounds(35,90,110,25);

        JLabel successLabel = new JLabel("");
        successLabel.setBounds(10,110,300,40);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean success = true;
                Course course = null;
                Student student = null;
                try{
                    String nameOfCourse = nameText.getText();
                    int id = Integer.parseInt(idText.getText());
                    if(university.findCourseByName(nameOfCourse)!= null && university.findStudentByID(id)!=null) {
                        course = university.findCourseByName(nameOfCourse);
                        student = university.findStudentByID(id);
                    }
                    else{
                        success = false;
                    }

                }
                catch (Exception a){
                    successLabel.setText("Error");
                }
                if(course !=null && student != null){
                    student.addCourse(course);
                }
                else{
                    successLabel.setText("Error");
                    success = false;
                }

                if(success){
                    successLabel.setText("Student has been added to the course");
                    nameText.setText("");
                    idText.setText("");
                }
                else{
                    successLabel.setText("Error");
                }

            }
        });





        panel.add(labelMain);
        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(idText);
        panel.add(nameText);
        panel.add(button);
        panel.add(successLabel);
    }
}
