package Services;

import Model.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class EmpleadoDao {

    public void insertarEmpleado(Empleado e){
        Conexion cx = new Conexion();
        String sql = "INSERT INTO empleados (nombre, apellidos, codigo, dni, nacimiento, cargo) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = cx.getConexion().prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellidos());
            ps.setString(3, e.getCodigo());
            ps.setString(4, e.getDni());
            ps.setDate(5, e.getNacimiento());
            ps.setString(6, e.getCargo());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Se produjo un error");
        } finally {
            cx.desconexion();
        }
    }
}
