package Util;
/**
 * @author JeanSL
 */
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class EstiloTabla{

    public TableModel estilo(JTable jtable){
        //Alto de la cabecera
        jtable.getTableHeader().setPreferredSize(new Dimension(0, 32));
        //alto de la tabla (-cabecera)
        jtable.setRowHeight(30);
        //margen de las columnas
        jtable.getColumnModel().setColumnMargin(5);
        //edición de celdas
        jtable.setEnabled(false);
        return jtable.getModel();
    }
}
