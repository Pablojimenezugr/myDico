package my.dico.gui.GUI;

import javax.swing.table.AbstractTableModel;
import my.dico.gui.Modelo.Dico;

public class TablaModeloAdapter extends AbstractTableModel {
    
    private Dico datos;

    public TablaModeloAdapter(Dico datos) {
        this.datos = datos;
    }

       
    public void actualizarTabla() {
        
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "Inglés";
            case 1 : return "Español";
            
            default: return "java me obliga a contemplarlo :(";
        }
    }
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        return null;
    }
    
}
