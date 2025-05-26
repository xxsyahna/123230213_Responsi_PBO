package Model.Coding;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelCoding extends AbstractTableModel {

    List<ModelCoding> daftarCoding;
    
    String kolom[] = {"Name", "Path", "Writing", "Coding", "Interview", "Score", "Status"};
    
    public ModelTable(List<ModelCoding> daftarCoding) {
        this.daftarCoding = daftarCoding;
    }

    @Override
    public int getRowCount() {
        return daftarCoding.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return daftarCoding.get(rowIndex).getId();
            case 1:
                return daftarCoding.get(rowIndex).getNama();
            case 2:
                return daftarCoding.get(rowIndex).getPath();
            case 3:
                return daftarCoding.get(rowIndex).getScore();
            case 4:
                return daftarCoding.get(rowIndex).getStatus();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
}

