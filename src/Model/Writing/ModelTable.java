package Model.Writing;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelWriting extends AbstractTableModel {

    List<ModelWriting> daftarWriting
    
    String kolom[] = {"Name", "Path", "Writing", "Coding", "Interview", "Score", "Status"};
    
    public ModelTable(List<ModelWriting> daftarWriting) {
        this.daftarWriting = daftarWriting;
    }

    @Override
    public int getRowCount() {
        return daftarWritingsize();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return daftarWriting.get(rowIndex).getId();
            case 1:
                return daftarWriting.get(rowIndex).getNama();
            case 2:
                return daftarWriting.get(rowIndex).getPath();
            case 3:
                return daftarWriting.get(rowIndex).getScore();
            case 4:
                return daftarWriting.get(rowIndex).getStatus();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
}


