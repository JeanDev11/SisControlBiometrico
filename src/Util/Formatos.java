package Util;

import java.util.Date;

public class Formatos {
    private final String[] mesesNames = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Set", "Oct", "Nov", "Div"};
    
    // Obtener el nombre de mes.
    public String mesNombre(int mes){
        return mesesNames[mes-1];
    }
    
    // Obtener el numero del mes.
    public int numeroMes(String nombreMes) {
        for (int i = 0; i < mesesNames.length; i++) {
            if (mesesNames[i].equalsIgnoreCase(nombreMes)) {
                return i + 1;
            }
        }
        return -1;
    }
    
    // Para fechas: Date - Sun Jan 01 19:32:34 PET 2024
    public java.sql.Date fechaSql(Date fecha){
        if(fecha != null){
            java.sql.Date fechaSql = new java.sql.Date(fecha.getTime());
            return fechaSql; // SQL - 2024-01-01
        }else{
            return null;
        }
    }
    
    
}












// Para fechas: Date - Sun Jan 01 19:32:34 PET 2024
    /*public void fecha(Date fecha){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Formatear la fecha al formato 'YYYY-MM-DD'
        String fechaFormateada  = sdf.format(fecha); // 2024-01-01
        System.out.println("fec form: "+ fechaFormateada);
        Date parsedDate = null;
        try {
            parsedDate = sdf.parse(fechaFormateada);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("fec date: "+ parsedDate);
        java.sql.Date nacimiento = new java.sql.Date(parsedDate.getTime());
        System.out.println("fec sql: "+ nacimiento);
        java.sql.Date nacimiento2 = new java.sql.Date(fecha.getTime());
        System.out.println("fec sql2: "+ nacimiento2);
    }*/
