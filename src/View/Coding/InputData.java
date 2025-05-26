package View.Coding;

import Controller.ControllerCoding;
import java.awt.event.*;
import javax.swing.*;

public class InputData extends JFrame {

    ControllerCoding controller;

    JLabel header = new JLabel("Input Coding");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputPath = new JLabel("Path");
    JLabel labelInputScore = new JLabel("Score");
    JLabel labelInputStatus = new JLabel("Status");
    JTextField inputNama = new JTextField();
    JTextField inputPath = new JTextField();
    JTextField inputScore = new JTextField();
    JTextField inputStatus = new JTextField();
    JButton tombolTambah = new JButton("Tambah Coding");
    JButton tombolKembali = new JButton("Kembali");

    public InputData() {
        setTitle("Input Coding");
        setVisible(true);
        setSize(480, 240);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(header);
        add(labelInputNama);
        add(labelInputPath);
        add(labelInputScore);
        add(labelInputStatus);
        add(inputNama);
        add(inputPath);
        add(inputScore);
        add(inputStatus);
        add(tombolTambah);
        add(tombolKembali);

        header.setBounds(20, 8, 440, 24);
        labelInputNama.setBounds(20, 32, 440, 24);
        inputNama.setBounds(18, 56, 440, 36);
        labelInputPath.setBounds(20, 96, 440, 24);
        inputPath.setBounds(18, 120, 440, 36);
        labelInputScore.setBounds(20, 96, 440, 24);
        inputScore.setBounds(18, 120, 440, 36);
        labelInputStatus.setBounds(20, 96, 440, 24);
        inputStatus.setBounds(18, 120, 440, 36);
        tombolKembali.setBounds(20, 160, 215, 40);
        tombolTambah.setBounds(240, 160, 215, 40);

        controller = new ControllerCoding(this);

        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewData();
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.insertCoding();
            }
        });
    }

    public String getInputNama() {
        return inputNama.getText();
    }

    public String getInputPath() {
        return inputPath.getText();
    }
    
     public String getInputScore() {
        return inputScore.getText();
    } 
     
      public String getInputStatus() {
        return inputStatus.getText();
    } 
}
