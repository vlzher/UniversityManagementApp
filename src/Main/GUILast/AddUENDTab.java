package Main.GUILast;

import Main.Employees.UniversityEmployeeND;
import Main.Observers.University;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AddUENDTab {
    private University university;
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();

    public AddUENDTab(University university) {
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


        JLabel surnameLabel = new JLabel("Surname");
        surnameLabel.setBounds(10, 30, 200, 25);
        JTextField surnameText = new JTextField(20);
        surnameText.setBounds(170, 30, 165, 25);


        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(10, 60, 200, 25);
        JTextField nameText = new JTextField(20);
        nameText.setBounds(170, 60, 165, 25);


        JLabel ageLabel = new JLabel("Age");
        ageLabel.setBounds(10, 90, 200, 25);
        JTextField ageText = new JTextField(20);
        ageText.setBounds(170, 90, 165, 25);

        JLabel postLabel = new JLabel("Post");
        postLabel.setBounds(10, 120, 200, 25);
        JTextField postText = new JTextField(20);
        postText.setBounds(170, 120, 165, 25);

        JLabel numberOFPublicationsLabel = new JLabel("Number of Publications");
        numberOFPublicationsLabel.setBounds(10, 150, 200, 25);
        JTextField numberOFPublicationsText = new JTextField(20);
        numberOFPublicationsText.setBounds(170, 150, 165, 25);

        JLabel numberOfCoursesLabel = new JLabel("Number Of Courses");
        numberOfCoursesLabel.setBounds(10, 180, 200, 25);
        JTextField numberOfCoursesText = new JTextField(20);
        numberOfCoursesText.setBounds(170, 180, 165, 25);

        JLabel numberOfOvertimeHoursLabel = new JLabel("Number Of Overtime Hours");
        numberOfOvertimeHoursLabel.setBounds(10, 210, 200, 25);
        JTextField numberOfOvertimeHoursText = new JTextField(20);
        numberOfOvertimeHoursText.setBounds(170, 210, 165, 25);

        JLabel successLabel = new JLabel("");
        successLabel.setBounds(10, 270, 300, 30);

        JButton button = new JButton("Register");
        button.setBounds(25, 240, 130, 25);



        panel.add(labelMain);
        panel.add(surnameLabel);
        panel.add(surnameText);
        panel.add(nameLabel);
        panel.add(nameText);
        panel.add(ageLabel);
        panel.add(ageText);
        panel.add(postLabel);
        panel.add(postText);
        panel.add(numberOfCoursesLabel);
        panel.add(numberOfCoursesText);
        panel.add(numberOFPublicationsLabel);
        panel.add(numberOFPublicationsText);
        panel.add(numberOfOvertimeHoursLabel);
        panel.add(numberOfOvertimeHoursText);
        panel.add(successLabel);
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean success = true;
                try {
                    String surname = surnameText.getText();
                    String name = nameText.getText();
                    int age = Integer.parseInt(ageText.getText());
                    String post = postText.getText();
                    int numberOfPublications = Integer.parseInt(numberOFPublicationsText.getText());
                    int numberOfCourses = Integer.parseInt(numberOfCoursesText.getText());

                    int numberOfOvertimeHours = Integer.parseInt(numberOfOvertimeHoursText.getText());
                    UniversityEmployeeND UEND = new UniversityEmployeeND(surname, name, age, post, numberOfPublications, numberOfCourses, numberOfOvertimeHours);
                    university.addEmployee(UEND);
                } catch (Exception a) {
                    success = false;
                }
                if (success) {
                    successLabel.setText("The new University Employee has been added");
                    surnameText.setText("");
                    nameText.setText("");
                    ageText.setText("");
                    postText.setText("");
                    numberOfCoursesText.setText("");
                    numberOfCoursesText.setText("");
                    numberOFPublicationsText.setText("");
                    numberOfOvertimeHoursText.setText("");
                } else {
                    successLabel.setText("Error");
                }
            }
        });
    }
}
