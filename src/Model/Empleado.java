package Model;

import java.sql.Date;

public class Empleado {
    private final String nombre;
    private final String apellidos;
    private final String codigo;
    private final String dni;
    private final Date nacimiento;
    private final String cargo;

    public Empleado(String nombre, String apellidos, String codigo, String dni, Date nacimiento, String cargo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.codigo = codigo;
        this.dni = dni;
        this.nacimiento = nacimiento;
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDni() {
        return dni;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public String getCargo() {
        return cargo;
    }
    
}
