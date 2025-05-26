package Controller;

import Model.Interview.*;
import Model.Interview.DAOInterview;
import View.Interview.*;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerInterview {

    ViewData halamanTable;
    InputData halamanInput;
    EditData halamanEdit;

    InterfaceDAOCoding daoInterview;

    List<ModelCoding> daftarInterview;

    public ControllerInterview(ViewData halamanTable) {
        this.halamanTable = halamanTable;
        this.daoInterview = new DAOInterview();
    }

    public ControllerInterview(InputData halamanInput) {
        this.halamanInput = halamanInput;
        this.daoInterview = new DAOInterview();
    }

    public ControllerInterview(EditData halamanEdit) {
        this.halamanEdit = halamanEdit;
        this.daoInterview = new DAOInterview();
    }

    public void showAllInterview() {
       
        daftarInterview = daoInterview.getAll();

        ModelTable table = new ModelTable(daftarInterview);

        halamanTable.getTableInterview().setModel(table);
    }

    public void insertInterview() {
        try {
            ModelInterview interviewBaru = new ModelInterview();

            String nama = halamanInput.getInputNama();
            String path = halamanInput.getInputPath();
            String score = halamanInput.getInputScore();
            String status = halamanInput.getInputStatus();

            if ("".equals(nama) || "".equals(path) || "".equals(score) || "".equals(status)) {
                throw new Exception("Nama, Path, Score, Status tidak boleh kosong!");
            }

            interviewBaru.setNama(nama);
            interviewBaru.setPath(path);
            interviewBaru.setScore(score);
            interviewBaru.setStatus(status);
            daoInterview.insert(interviewBaru);
            JOptionPane.showMessageDialog(null, "Interview baru berhasil ditambahkan.");

            halamanInput.dispose();
            new ViewData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void editInterview(int id) {
        try {
            ModelInterview interviewYangMauDiedit = new InterviewCoding()
            String nama = halamanEdit.getInputNama();
            String path = halamanEdit.getInputPath();
            String score = halamanEdit.getInputScore();
            String status = halamanEdit.getInputStatus();
            if("".equals(nama) || "".equals(path) || "".equals(score) || "".equals(status)) {
                throw new Exception("Nama, Path, Score, Status tidak boleh kosong!");
            }
            interviewYangMauDiedit.setId(id);
            interviewYangMauDiedit.setNama(nama);
            interviewYangMauDiedit.setPath(path);
            interviewYangMauDiedit.setScore(score);
            interviewYangMauDiedit.setStatus(status);

            daoInterview.update(interviewYangMauDiedit);
            JOptionPane.showMessageDialog(null, "Data interview berhasil diubah.");

            halamanEdit.dispose();
            new ViewData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deleteInterview(Integer baris) {
        Integer id = (int) halamanTable.getTableInterview().getValueAt(baris, 0);
        String nama = halamanTable.getTableInterview().getValueAt(baris, 1).toString();

        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus interview",
                JOptionPane.YES_NO_OPTION
        );
        if (input == 0) {
            daoInterview.delete(id);
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");
            showAllInterview();
        }
    }
}
