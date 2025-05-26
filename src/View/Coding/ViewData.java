package View.Coding;

import Controller.ControllerCoding;
import Model.Coding.ModelCoding;
import View.Home;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewData extends JFrame {
   
    Integer baris;
    
    ControllerCoding controller;

    JLabel header = new JLabel("Data Coding");
    JButton tombolTambah = new JButton("Tambah Coding");
    JButton tombolEdit = new JButton("Edit Coding");
    JButton tombolHapus = new JButton("Hapus Coding");
    JButton tombolKembali = new JButton("Kembali ke menu utama");
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    String namaKolom[] = {"ID", "Nama", "Path", "Score", "Status"};

    public ViewData() {
        tableModel = new DefaultTableModel(namaKolom, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        setTitle("Daftar Coding");
        setVisible(true);
        setSize(552, 580);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(header);
        add(scrollPane);
        add(tombolTambah);
        add(tombolEdit);
        add(tombolHapus);
        add(tombolKembali);

        header.setBounds(20, 8, 440, 24);
        scrollPane.setBounds(20, 36, 512, 320);
        tombolTambah.setBounds(20, 370, 512, 40);
        tombolEdit.setBounds(20, 414, 512, 40);
        tombolHapus.setBounds(20, 458, 512, 40);
        tombolKembali.setBounds(20, 502, 512, 40);

        controller = new ControllerCoding(this);
        controller.showAllCoding();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                baris = table.getSelectedRow();
            }
        });
        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   dispose();
                new InputData();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                if (baris != null) {
                    
                    ModelCoding codingTerpilih = new ModelCoding();
                    
                    Integer id = (int) table.getValueAt(baris, 0);
                    String nama = table.getValueAt(baris, 1).toString();
                    String path = table.getValueAt(baris, 2).toString();
                    String score = table.getValueAt(baris, 3).toString();
                    String status = table.getValueAt(baris, 24).toString();
                    
                    codingTerpilih.setId(id);
                    codingTerpilih.setNama(nama);
                    codingTerpilih.setPath(path);
                    codingTerpilih.setScore(score);
                    codingTerpilih.setStatus(status);
                    
                    dispose();
                    new EditData(codingTerpilih);
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });

        tombolHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null) {
                    controller.deleteCoding(baris);
                    baris = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });
        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Home();
            }
        });
    }

    public JTable getTableCoding() {
        return table;
    }
}
