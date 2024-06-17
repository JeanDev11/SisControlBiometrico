package Services;

import Model.HistorialAsistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JeanSL
 */
public class AsistenciaDao {

    public void getFechas(){
        ArrayList<String> fechas = new ArrayList<>();
        Conexion cx = new Conexion();
        ResultSet rs;
        
        String sql = "SELECT fecha_hora FROM asistencia";
        try {
            PreparedStatement ps = cx.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                fechas.add(rs.getString(1));
                System.out.println("fecha: "+ rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Se produjo un error");
        } finally {
            cx.desconexion();
        }
    }
    
    public ArrayList<String> getAños(){
        ArrayList<String> años = new ArrayList<>();
        Conexion cx = new Conexion();
        ResultSet rs;
        
        String sql = "SELECT DISTINCT EXTRACT(YEAR FROM fecha_hora) AS año FROM asistencia";
        try {
            PreparedStatement ps = cx.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                años.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Se produjo un error");
        } finally {
            cx.desconexion();
        }
        return años;
    }
    
    public ArrayList<String> getMeses(String año){
        ArrayList<String> meses = new ArrayList<>();
        Conexion cx = new Conexion();
        ResultSet rs;
        
        String sql = """
                     SELECT DISTINCT EXTRACT(MONTH FROM fecha_hora) AS mes
                     FROM asistencia
                     WHERE EXTRACT(YEAR FROM fecha_hora) = """ + año + " ORDER BY mes DESC";
        try {
            PreparedStatement ps = cx.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                meses.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Se produjo un error");
        } finally {
            cx.desconexion();
        }
        return meses;
    }
    
    public ArrayList<HistorialAsistencia> getHistorial(int año, int mes){
        ArrayList<HistorialAsistencia> historial = new ArrayList<>();
        Conexion cx = new Conexion();
        ResultSet rs;
        
        String sql = "SELECT e.codigo, e.nombre, e.apellidos, e.cargo, "
                + "TO_CHAR(a.fecha_hora, 'HH24:MI:SS') AS hora_minutos_segundos, " 
                + "TO_CHAR(a.fecha_hora, 'YYYY-MM-DD') AS fecha "
                + "FROM asistencia a "
                + "JOIN empleados e ON a.empleado_id = e.id "
                + "WHERE EXTRACT(YEAR FROM a.fecha_hora) = ? AND EXTRACT(MONTH FROM a.fecha_hora) = ?";
         
        try {
            PreparedStatement ps = cx.getConexion().prepareStatement(sql);
            ps.setInt(1, año);
            ps.setInt(2, mes);
            rs = ps.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString(1);
                String nombre = rs.getString(2);
                String apellidos = rs.getString(3);
                String cargo = rs.getString(4);
                String hora = rs.getString(5);
                String fecha = rs.getString(6);
                
                HistorialAsistencia h = new HistorialAsistencia(codigo, nombre, apellidos, cargo, hora, fecha);
                historial.add(h);
            }
        } catch (SQLException ex) {
            System.out.println("Aqui: "+ex.getMessage());
            //JOptionPane.showMessageDialog(null, "Se produjo un error");
        } finally {
            cx.desconexion();
        }
        return historial;
    }
    
}
