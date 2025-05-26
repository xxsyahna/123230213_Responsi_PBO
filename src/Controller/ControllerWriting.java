package Controller;

import Model.Writing.*;
import Model.Writing.DAOWriting;
import View.Writing.*;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerWriting {

    ViewData halamanTable;
    InputData halamanInput;
    EditData halamanEdit;

    InterfaceDAOWriting daoWriting;

    List<ModelWriting> daftarWriting;

    public ControllerWriting(ViewData halamanTable) {
        this.halamanTable = halamanTable;
        this.daoWriting = new DAOWriting();
    }

    public ControllerWriting(InputData halamanInput) {
        this.halamanInput = halamanInput;
        this.daoWriting = new DAOWriting();
    }

    public ControllerWriting(EditData halamanEdit) {
        this.halamanEdit = halamanEdit;
        this.daoWriting = new DAOWriting();
    }

    public void showAllWriting() {
       
        daftarWriting = daoWriting.getAll();

        ModelTable table = new ModelTable(daftarWriting;

        halamanTable.getTableWriting().setModel(table);
    }

    public void insertWriting() {
        try {
            ModelWriting WritingBaru = new ModelWriting();

            String nama = halamanInput.getInputNama();
            String path = halamanInput.getInputPath();
            String score = halamanInput.getInputScore();
            String status = halamanInput.getInputStatus();

            if ("".equals(nama) || "".equals(path) || "".equals(score) || "".equals(status)) {
                throw new Exception("Nama, Path, Score, Status tidak boleh kosong!");
            }

            writingBaru.setNama(nama);
            writingBaru.setPath(path);
           writingBaru.setScore(score);
           writingBaru.setStatus(status);
            daoWriting.insert(writingBaru);
            JOptionPane.showMessageDialog(null, "Interview baru berhasil ditambahkan.");

            halamanInput.dispose();
            new ViewData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void editWriting(int id) {
        try {
            ModelWriting interviewYangMauDiedit = new WritingCoding()
            String nama = halamanEdit.getInputNama();
            String path = halamanEdit.getInputPath();
            String score = halamanEdit.getInputScore();
            String status = halamanEdit.getInputStatus();
            if("".equals(nama) || "".equals(path) || "".equals(score) || "".equals(status)) {
                throw new Exception("Nama, Path, Score, Status tidak boleh kosong!");
            }
            writingYangMauDiedit.setId(id);
            writingYangMauDiedit.setNama(nama);
            writingYangMauDiedit.setPath(path);
            writingYangMauDiedit.setScore(score);
            writingYangMauDiedit.setStatus(status);

            daoWriting.update(interviewYangMauDiedit);
            JOptionPane.showMessageDialog(null, "Data Writing berhasil diubah.");

            halamanEdit.dispose();
            new ViewData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deleteInterview(Integer baris) {
        Integer id = (int) halamanTable.getTableWriting().getValueAt(baris, 0);
        String nama = halamanTable.getTableWriting().getValueAt(baris, 1).toString();

        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus interview",
                JOptionPane.YES_NO_OPTION
        );
        if (input == 0) {
            daoWriting.delete(id);
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");
            showAllWriting();
        }
    }
}
