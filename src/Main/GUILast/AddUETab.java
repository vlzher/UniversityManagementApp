package Main.GUILast;

import Main.Employees.UniversityEmployee;
import Main.Observers.University;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AddUETab {
    private University university;
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    public AddUETab(University university){
        this.university = university;
        panels();
    }
    private void panels(){
        frame.setSize(400,600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        //surname name age post shift liczba nadgodzin
        panel.setLayout(null);


        JLabel labelMain = new JLabel("Enter the information: ");
        labelMain.setBounds(10,5,165,25);


        JLabel surnameLabel = new JLabel("Surname");
        surnameLabel.setBounds(10,30,200,25);
        JTextField surnameText = new JTextField(20);
        surnameText.setBounds(120,30,165,25);


        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(10,60,200,25);
        JTextField nameText = new JTextField(20);
        nameText.setBounds(120,60,165,25);


        JLabel ageLabel = new JLabel("Age");
        ageLabel.setBounds(10,90,200,25);
        JTextField ageText = new JTextField(20);
        ageText.setBounds(120,90,165,25);

        JLabel postLabel = new JLabel("Post");
        postLabel.setBounds(10,120,200,25);
        JTextField postText = new JTextField(20);
        postText.setBounds(120,120,165,25);

        JLabel shiftLabel = new JLabel("Shift");
        shiftLabel.setBounds(10,150,200,25);
        JTextField shiftText = new JTextField(20);
        shiftText.setBounds(120,150,165,25);

        JLabel nadgodzinLabel = new JLabel("Liczba nadgodzin");
        nadgodzinLabel.setBounds(10,180,200,25);
        JTextField nadgodzinText = new JTextField(20);
        nadgodzinText.setBounds(120,180,165,25);

        JLabel successLabel = new JLabel("");
        successLabel.setBounds(10,240,300,30);

        JButton button = new JButton("Register");
        button.setBounds(25,210,130,25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean success = true;
                try {
                    String surname = surnameText.getText();
                    String name = nameText.getText();
                    int age = Integer.parseInt(ageText.getText());
                    String post = postText.getText();
                    String shift = shiftText.getText();
                    int liczbaNadgodzin = Integer.parseInt(nadgodzinText.getText());
                    UniversityEmployee UE = new UniversityEmployee(surname,name,age,post,shift,liczbaNadgodzin);
                    university.addEmployee(UE);
                }
                catch (Exception a){
                    success = false;
                }
                if(success){
                    successLabel.setText("The new University Employee has been added");
                    surnameText.setText("");
                    nameText.setText("");
                    ageText.setText("");
                    postText.setText("");
                    shiftText.setText("");
                    nadgodzinText.setText("");
                }
                else{
                    successLabel.setText("Error");
                }
            }
        });





        panel.add(labelMain);
        panel.add(surnameLabel);
        panel.add(surnameText);
        panel.add(nameLabel);
        panel.add(nameText);
        panel.add(ageLabel);
        panel.add(ageText);
        panel.add(postLabel);
        panel.add(postText);
        panel.add(shiftLabel);
        panel.add(shiftText);
        panel.add(nadgodzinLabel);
        panel.add(nadgodzinText);
        panel.add(successLabel);
        panel.add(button);


    }
}
