package Util;
/**
 * @author JeanSL
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

public class EstiloEncabezado implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JComponent componente=null;
        if(value instanceof String){
            componente = new JLabel((String) value);
            componente.setOpaque(true);
            componente.setPreferredSize(new Dimension(0, 24));
            componente.setBackground(new Color(134, 167, 137));
            componente.setFont(new Font("Segoe UI", 1, 16));
            componente.setBorder(BorderFactory.createMatteBorder(0,0,1,1,Color.BLACK));
            ((JLabel)componente).setHorizontalAlignment(SwingConstants.CENTER);
        }
        
        return componente;
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
