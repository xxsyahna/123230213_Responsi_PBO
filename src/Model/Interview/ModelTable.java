package Model.Interview;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelInterview extends AbstractTableModel {

    List<ModelInterview> daftarInterview;
    
    String kolom[] = {"Name", "Path", "Writing", "Coding", "Interview", "Score", "Status"};
    
    public ModelTable(List<ModelInterview> daftarInterview) {
        this.daftarInterview = daftarInterview;
    }

    @Override
    public int getRowCount() {
        return daftarInterview.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return daftarInterview.get(rowIndex).getId();
            case 1:
                return daftarInterview.get(rowIndex).getNama();
            case 2:
                return daftarInterview.get(rowIndex).getPath();
            case 3:
                return daftarInterview.get(rowIndex).getScore();
            case 4:
                return daftarInterview.get(rowIndex).getStatus();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
}

