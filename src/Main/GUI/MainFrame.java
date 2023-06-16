package Main.GUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    public MainFrame() {
        this.setTitle("University DataBase");
        this.setResizable(false);
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("logo.png").getImage());
        this.getContentPane().setBackground(new Color(1,1,1));
        this.setVisible(true);

//        Border border = BorderFactory.createLineBorder(Color.white,5);
//
//
        ImageIcon image = new ImageIcon("logo.png");
//
//
//
//
//
//        JLabel label = new JLabel();
//        label.setBorder(border);
//        label.setText("Bro, do you even code?");
//        label.setIcon(image);
//        label.setForeground(Color.white);
        JButton button = new JButton(image);
        button.setText("Zopa");
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalAlignment(JButton.CENTER);

        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBorderPainted(true);
        button.setForeground(Color.black);
        button.setBackground(Color.black);
        this.add(button);
//        this.add(label);
    }
}
