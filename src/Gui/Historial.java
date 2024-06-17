package Gui;

import Model.HistorialAsistencia;
import Services.AsistenciaDao;
import Services.DataStorage;
import Util.EstiloEncabezado;
import Util.EstiloTabla;
import Util.Formatos;
import Util.SVGIcon;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Historial extends javax.swing.JPanel {

    private final DefaultTableModel modelo;
    private String añoSeleccionado;
    private String mesSeleccionado;
    private int mesNumeroSeleccionado;
    
    public Historial() {
        initComponents();
        initializeSVGIcon();
        modelo = (DefaultTableModel) tablaHistorial.getModel();
        modeloTabla();
        listarAño();
    }
    
    private void initializeSVGIcon() {
        // Crea una instancia de SVGIcon con la ruta al archivo SVG
        SVGIcon svgIcon = new SVGIcon("/Picture/magnifying-glass-solid.svg");
        // Asigna el SVGIcon al JLabel
        Buscar.setIcon(svgIcon);
    }
    
    private void modeloTabla() {
        tablaHistorial.getColumnModel().getColumn(0).setPreferredWidth(40);
        tablaHistorial.setModel(new EstiloTabla().estilo(tablaHistorial));
        tablaHistorial.getTableHeader().setDefaultRenderer(new EstiloEncabezado());
    }
    
    private void listarAño(){
        ArrayList<String> listaAño = (ArrayList<String>) DataStorage.getInstance().getData("listaAños");
        for (String año : listaAño) {
            cmbAnio.addItem(año);
        }
    }
    
    private void listarMes(){
        Formatos fm = new Formatos();
        cmbMes.removeAllItems();
        añoSeleccionado = cmbAnio.getSelectedItem().toString();
        AsistenciaDao ad = new AsistenciaDao();
        ArrayList<String> listaMes = ad.getMeses(añoSeleccionado);
        for (String mesNum : listaMes) {
            cmbMes.addItem(fm.mesNombre(Integer.parseInt(mesNum)));
        }
    }

    private void listarHistorial() {
        int año = Integer.parseInt(añoSeleccionado);
        modelo.setRowCount(0);
        AsistenciaDao ad = new AsistenciaDao();
        ArrayList<HistorialAsistencia> listHA = ad.getHistorial(año, mesNumeroSeleccionado);
        Object[] datos = new Object[6];
        for (HistorialAsistencia h : listHA) {
            datos[0] = h.getCodigo();
            datos[1] = h.getNombre();
            datos[2] = h.getApellidos();
            datos[3] = h.getCargo();
            datos[4] = h.getHora();
            datos[5] = h.getFecha();
            modelo.addRow(datos);
        }
        guardarHistorial(listHA);
    }
    
    private void guardarHistorial(ArrayList<HistorialAsistencia> listHA){
        String key = añoSeleccionado + mesSeleccionado; // Key de tipo 20241
        System.out.println("key: "+key);
        if(DataStorage.getInstance().containsKey(key)){
            System.out.println("si hay");
        }else{
            System.out.println("no hay");
            DataStorage.getInstance().saveData(key, listHA);
        }
    }
    
    private void buscarEnHistorial(){
        String valorBuscar = inputBuscar.getText().toLowerCase();
        String opcionBuscar = cmbOpcionBuscar.getSelectedItem().toString();
        String key = añoSeleccionado + mesSeleccionado;
        System.out.println("Req: "+valorBuscar+" "+opcionBuscar+" "+key);
        ArrayList<HistorialAsistencia> listHA = (ArrayList<HistorialAsistencia>) DataStorage.getInstance().getData(key);
        modelo.setRowCount(0);
        for (HistorialAsistencia ha : listHA) {
            boolean match = false;
            if (opcionBuscar.equals("Codigo")) {
                match = ha.getCodigo().toLowerCase().contains(valorBuscar);
            } else if (opcionBuscar.equals("Nombre")) {
                match = ha.getNombre().toLowerCase().contains(valorBuscar);
            }

            if (match) {
                agregarFila(ha);
            }
        }
        
    }
    
    private void agregarFila(HistorialAsistencia ha) {
        Object[] datos = new Object[6];
        datos[0] = ha.getCodigo();
        datos[1] = ha.getNombre();
        datos[2] = ha.getApellidos();
        datos[3] = ha.getCargo();
        datos[4] = ha.getHora();
        datos[5] = ha.getFecha();
        modelo.addRow(datos);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitulo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelCuerpo = new javax.swing.JPanel();
        cmbAnio = new javax.swing.JComboBox<>();
        cmbMes = new javax.swing.JComboBox<>();
        cmbOpcionBuscar = new javax.swing.JComboBox<>();
        inputBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHistorial = new javax.swing.JTable();
        Buscar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(210, 227, 200));
        setMinimumSize(new java.awt.Dimension(1080, 700));
        setLayout(new java.awt.BorderLayout());

        panelTitulo.setMinimumSize(new java.awt.Dimension(1080, 80));
        panelTitulo.setPreferredSize(new java.awt.Dimension(1080, 80));
        panelTitulo.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Reporte de Asistencia");
        panelTitulo.add(jLabel2, new java.awt.GridBagConstraints());

        add(panelTitulo, java.awt.BorderLayout.NORTH);

        cmbAnio.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmbAnio.setFocusable(false);
        cmbAnio.setMinimumSize(new java.awt.Dimension(130, 40));
        cmbAnio.setPreferredSize(new java.awt.Dimension(130, 40));
        cmbAnio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbAnioItemStateChanged(evt);
            }
        });

        cmbMes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmbMes.setFocusable(false);
        cmbMes.setMinimumSize(new java.awt.Dimension(130, 40));
        cmbMes.setPreferredSize(new java.awt.Dimension(130, 40));
        cmbMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMesItemStateChanged(evt);
            }
        });

        cmbOpcionBuscar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmbOpcionBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre", "Apellido", "Cargo" }));
        cmbOpcionBuscar.setFocusable(false);
        cmbOpcionBuscar.setMinimumSize(new java.awt.Dimension(130, 40));
        cmbOpcionBuscar.setPreferredSize(new java.awt.Dimension(130, 40));

        inputBuscar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        inputBuscar.setMinimumSize(new java.awt.Dimension(170, 40));
        inputBuscar.setPreferredSize(new java.awt.Dimension(170, 40));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(940, 500));

        tablaHistorial.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tablaHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Apellidos", "Cargo", "Hora", "Fecha"
            }
        ));
        tablaHistorial.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaHistorial);

        Buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Buscar.setPreferredSize(new java.awt.Dimension(30, 40));
        Buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelCuerpoLayout = new javax.swing.GroupLayout(panelCuerpo);
        panelCuerpo.setLayout(panelCuerpoLayout);
        panelCuerpoLayout.setHorizontalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addComponent(cmbAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbOpcionBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        panelCuerpoLayout.setVerticalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpoLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbOpcionBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        add(panelCuerpo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbAnioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbAnioItemStateChanged
        // Verifica si el evento es de selección
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            listarMes();
        }
    }//GEN-LAST:event_cmbAnioItemStateChanged

    private void cmbMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMesItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            inputBuscar.setText("");
            Formatos fm = new Formatos();
            mesNumeroSeleccionado = fm.numeroMes(String.valueOf(evt.getItem()));
            mesSeleccionado = String.valueOf(mesNumeroSeleccionado);
            System.out.println("mesNumeroSeleccionado "+ mesNumeroSeleccionado);
            System.out.println("mesSeleccionado "+ mesSeleccionado);
            
//            int año = Integer.parseInt(añoSeleccionado);
//            int mes = fm.numeroMes(String.valueOf(evt.getItem()));
            listarHistorial();
        }
    }//GEN-LAST:event_cmbMesItemStateChanged

    private void BuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseClicked
        buscarEnHistorial();
    }//GEN-LAST:event_BuscarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Buscar;
    private javax.swing.JComboBox<String> cmbAnio;
    private javax.swing.JComboBox<String> cmbMes;
    private javax.swing.JComboBox<String> cmbOpcionBuscar;
    private javax.swing.JTextField inputBuscar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelCuerpo;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTable tablaHistorial;
    // End of variables declaration//GEN-END:variables
}
