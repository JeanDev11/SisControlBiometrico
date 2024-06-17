package Model;

public class HistorialAsistencia {
    private final String codigo;
    private final String nombre;
    private final String apellidos;
    private final String cargo;
    private final String hora;
    private final String fecha;

    public HistorialAsistencia(String codigo, String nombre, String apellidos, String cargo, String hora, String fecha) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.hora = hora;
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCargo() {
        return cargo;
    }

    public String getHora() {
        return hora;
    }

    public String getFecha() {
        return fecha;
    }
    
}
