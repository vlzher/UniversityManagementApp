package Main.GUILast;

import Main.Observable.Student;
import Main.Observers.University;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class StudentAddingTab extends JFrame {
    private University university;
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    public StudentAddingTab(University university){
        this.university = university;
        panels();
    }
    private void panels(){
        frame.setSize(400,600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        //surname name age id
        panel.setLayout(null);


        JLabel labelMain = new JLabel("Enter the information: ");
        labelMain.setBounds(10,5,165,25);


        JLabel surnameLabel = new JLabel("Surname");
        surnameLabel.setBounds(10,30,150,25);
        JTextField surnameText = new JTextField(20);
        surnameText.setBounds(100,30,165,25);


        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(10,60,150,25);
        JTextField nameText = new JTextField(20);
        nameText.setBounds(100,60,165,25);


        JLabel ageLabel = new JLabel("Age");
        ageLabel.setBounds(10,90,150,25);
        JTextField ageText = new JTextField(20);
        ageText.setBounds(100,90,165,25);

        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(10,120,150,25);
        JTextField idText = new JTextField(20);
        idText.setBounds(100,120,165,25);

        JLabel successLabel = new JLabel("");
        successLabel.setBounds(10,190,250,30);

        JButton button = new JButton("Register");
        button.setBounds(25,160,130,25);

        button.addActionListener(new ActionListener() {
                                     @Override
                                     public void actionPerformed(ActionEvent e) {
                                         String surname = surnameText.getText();
                                         String name = nameText.getText();
                                         boolean success = false;
                                         try {
                                             int age = Integer.parseInt(ageText.getText());
                                             int ID = Integer.parseInt(idText.getText());
                                             Student student = new Student(surname,name,age,ID);
                                             success = true;
                                             university.addStudent(student);
                                         }
                                         catch (Exception exception){
                                             successLabel.setText("ENTER CORRECT DATA!!!");
                                         }
                                         if(success) {
                                             successLabel.setText("The student has successfully registered!");
                                             surnameText.setText("");
                                             nameText.setText("");
                                             ageText.setText("");
                                             idText.setText("");
                                         }
                                     }
                                 }
        );
        panel.add(labelMain);
        panel.add(surnameLabel);
        panel.add(surnameText);
        panel.add(nameLabel);
        panel.add(nameText);
        panel.add(ageLabel);
        panel.add(ageText);
        panel.add(idLabel);
        panel.add(idText);
        panel.add(button);
        panel.add(successLabel);
        frame.setVisible(true);

    }


}
