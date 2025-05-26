package Controller;

import Model.Coding.*;
import View.Coding.*;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerCoding {

    ViewData halamanTable;
    InputData halamanInput;
    EditData halamanEdit;

    InterfaceDAOCoding daoCoding;

    List<ModelCoding> daftarCoding;

    public ControllerCoding(ViewData halamanTable) {
        this.halamanTable = halamanTable;
        this.daoCoding = new DAOCoding();
    }

    public ControllerCoding(InputData halamanInput) {
        this.halamanInput = halamanInput;
        this.daoCoding = new DAOCoding();
    }

    public ControllerCoding(EditData halamanEdit) {
        this.halamanEdit = halamanEdit;
        this.daoCoding = new DAOCoding();
    }

    public void showAllCoding() {
       
        daftarCoding = daoCoding.getAll();

        ModelTable table = new ModelTable(daftarCoding);

        halamanTable.getTableCoding().setModel(table);
    }

    public void insertCoding() {
        try {
            ModelCoding codingBaru = new ModelCoding();

            String nama = halamanInput.getInputNama();
            String path = halamanInput.getInputPath();
            String score = halamanInput.getInputScore();
            String status = halamanInput.getInputStatus();

            if ("".equals(nama) || "".equals(path) || "".equals(score) || "".equals(status)) {
                throw new Exception("Nama, Path, Score, Status tidak boleh kosong!");
            }

            codingBaru.setNama(nama);
            codingBaru.setPath(path);
            codingBaru.setScore(score);
            codingBaru.setStatus(status);
            daoCoding.insert(codingBaru);
            JOptionPane.showMessageDialog(null, "Coding baru berhasil ditambahkan.");

            halamanInput.dispose();
            new ViewData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void editCoding(int id) {
        try {
            ModelCoding codingYangMauDiedit = new ModelCoding()
            String nama = halamanEdit.getInputNama();
            String path = halamanEdit.getInputPath();
            String score = halamanEdit.getInputScore();
            String status = halamanEdit.getInputStatus();
            if("".equals(nama) || "".equals(path) || "".equals(score) || "".equals(status)) {
                throw new Exception("Nama, Path, Score, Status tidak boleh kosong!");
            }
            codingYangMauDiedit.setId(id);
            codingYangMauDiedit.setNama(nama);
            codingYangMauDiedit.setPath(path);
            codingYangMauDiedit.setScore(score);
            codingYangMauDiedit.setStatus(status);

            daoCoding.update(codingYangMauDiedit);
            JOptionPane.showMessageDialog(null, "Data coding berhasil diubah.");

            halamanEdit.dispose();
            new ViewData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deleteCoding(Integer baris) {
        Integer id = (int) halamanTable.getTableCoding().getValueAt(baris, 0);
        String nama = halamanTable.getTableCoding().getValueAt(baris, 1).toString();

        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus Coding",
                JOptionPane.YES_NO_OPTION
        );
        if (input == 0) {
            daoCoding.delete(id);
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");
            showAllCoding();
        }
    }
}
