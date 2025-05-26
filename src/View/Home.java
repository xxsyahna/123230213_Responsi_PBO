package View;

import Controller.ControllerCoding;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Home extends JFrame {
    ControllerCoding controller;
    
    JLabel header = new JLabel("123230213_Aisyah Nabila", SwingConstants.CENTER);
    JButton tombolCoding = new JButton("Menu Coding");
    JButton tombolInterview = new JButton("Menu Interview");
    JButton tombolWriting = new JButton("Menu Writing");

    public Home() {
        setVisible(true);
        setSize(480, 240);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(header);
        add(tombolCoding);
        add(tombolInterview);
        add(tombolWriting);
        header.setFont(new Font("Sans-Serif", Font.PLAIN, 24));
        
        header.setBounds(20, 12, 440, 36);
        tombolCoding.setBounds(80, 56, 320, 40);
        tombolInterview.setBounds(80, 100, 320, 40);
        tombolWriting.setBounds(80, 100, 320, 40);

        tombolCoding.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new View.Coding.ViewData();
            }
        });
        tombolInterview.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new View.Interview.ViewData();
            }
        });
        tombolWriting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new View.Writing.ViewData();
            }
        });
    }
}
