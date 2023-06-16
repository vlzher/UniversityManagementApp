package Main.GUILast;

import Main.Observable.Course;
import Main.Observers.University;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AddCourseTab {
    private University university;

    JPanel panel = new JPanel();
    JFrame frame = new JFrame();

    public AddCourseTab(University university) {
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

        JLabel nameLabel = new JLabel("Name of course: ");
        nameLabel.setBounds(10, 30, 150, 25);
        JTextField nameText = new JTextField(20);
        nameText.setBounds(120, 30, 165, 25);


        JLabel success = new JLabel("");
        success.setBounds(10,110,200,25);


        JButton button = new JButton("Submit");
        button.setBounds(25, 90, 130, 25);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Course course = new Course(nameText.getText());
                university.addCourse(course);
                success.setText("The course has been registered.");
                nameText.setText("");

            }
        });



        panel.add(labelMain);
        panel.add(nameLabel);
        panel.add(nameText);
        panel.add(button);
        panel.add(success);


    }
}
