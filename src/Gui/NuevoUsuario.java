package Gui;

import Model.Empleado;
import Services.EmpleadoDao;
import Util.Formatos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class NuevoUsuario extends javax.swing.JPanel {

    public NuevoUsuario() {
        initComponents();
        // Establecer la fecha predeterminada
        Date fechaPredeterminada = null;
        try {
            fechaPredeterminada = new SimpleDateFormat("yyyy-MM-dd").parse("1900-01-01");
        } catch (ParseException ex) {
            
        }
        inputNacimiento.setDate(fechaPredeterminada);
    }
    
    private void habilitarBoton(){
        if(!inputDni.getText().isEmpty() && !inputNombre.getText().isEmpty() && !inputApellido.getText().isEmpty() && 
                !inputCargo.getText().isEmpty() && !inputCodigo.getText().isEmpty() && inputNacimiento.getDate() != null)
            btnguardar.setEnabled(true);
        else
            btnguardar.setEnabled(false);
    }
    
    private void infoUsuario(){
        Formatos fm = new Formatos();
        String nombre = inputNombre.getText();
        String apellidos = inputApellido.getText();
        String codigo = inputCodigo.getText();
        String dni = inputDni.getText();
        String cargo = inputCargo.getText();
        
        // Obtener la fecha seleccionada del JCalendar
        Date fechaSeleccionada = inputNacimiento.getDate();
        java.sql.Date nacimiento = fm.fechaSql(fechaSeleccionada);
        
        Empleado empleado = new Empleado(nombre, apellidos, codigo, dni, nacimiento, cargo);
        String mensaje = "Nombre: " + empleado.getNombre() + 
                "\nApellido: " + empleado.getApellidos() + 
                "\nCodigo: " + empleado.getCodigo() + 
                "\nDNI: " + empleado.getDni() +
                "\nNacimiento: " + empleado.getNacimiento() +
                "\nCargo: " + empleado.getCargo();
        
        //JOptionPane.showConfirmDialog(null, mensaje, "Confirme nuevo usuario", JOptionPane.OK_CANCEL_OPTION);
        Object[] options = {"Aceptar", "Cancelar"};
        int n = JOptionPane.showOptionDialog(null, mensaje, "Confirme nuevo usuario",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
        
        if (n == JOptionPane.YES_OPTION) {
            //System.out.println("Aceptar presionado");
            EmpleadoDao ed = new EmpleadoDao();
            ed.insertarEmpleado(empleado);
            limipiarInputs();
        } else {
            System.out.println("Cancelar presionado");
        }
    }
    
    private void limipiarInputs(){
        inputNombre.setText("");
        inputApellido.setText("");
        inputDni.setText("");
        inputCodigo.setText("");
        inputCargo.setText("");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelCuerpo = new javax.swing.JPanel();
        form1 = new javax.swing.JPanel();
        jlNombre = new javax.swing.JLabel();
        inputNombre = new javax.swing.JTextField();
        jlApellido = new javax.swing.JLabel();
        inputApellido = new javax.swing.JTextField();
        jlDni = new javax.swing.JLabel();
        inputDni = new javax.swing.JTextField();
        jlNacimiento = new javax.swing.JLabel();
        jlCodigo = new javax.swing.JLabel();
        inputCodigo = new javax.swing.JTextField();
        jlCargo = new javax.swing.JLabel();
        inputCargo = new javax.swing.JTextField();
        inputNacimiento = new com.toedter.calendar.JDateChooser();
        form2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1080, 700));
        setLayout(new java.awt.BorderLayout());

        panelTitulo.setMinimumSize(new java.awt.Dimension(1080, 80));
        panelTitulo.setPreferredSize(new java.awt.Dimension(1080, 80));
        panelTitulo.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registrar Usuario");
        panelTitulo.add(jLabel1);

        add(panelTitulo, java.awt.BorderLayout.NORTH);

        form1.setForeground(new java.awt.Color(0, 0, 0));
        java.awt.GridBagLayout form1Layout = new java.awt.GridBagLayout();
        form1Layout.columnWidths = new int[] {0, 15, 0, 15, 0};
        form1Layout.rowHeights = new int[] {0, 40, 0, 40, 0, 40, 0, 40, 0, 40, 0};
        form1.setLayout(form1Layout);

        jlNombre.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlNombre.setForeground(new java.awt.Color(0, 0, 0));
        jlNombre.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        form1.add(jlNombre, gridBagConstraints);

        inputNombre.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        inputNombre.setPreferredSize(new java.awt.Dimension(165, 40));
        inputNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNombreActionPerformed(evt);
            }
        });
        inputNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputNombreKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        form1.add(inputNombre, gridBagConstraints);

        jlApellido.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlApellido.setForeground(new java.awt.Color(0, 0, 0));
        jlApellido.setText("Apellidos:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        form1.add(jlApellido, gridBagConstraints);

        inputApellido.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        inputApellido.setPreferredSize(new java.awt.Dimension(165, 40));
        inputApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputApellidoActionPerformed(evt);
            }
        });
        inputApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputApellidoKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        form1.add(inputApellido, gridBagConstraints);

        jlDni.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlDni.setForeground(new java.awt.Color(0, 0, 0));
        jlDni.setText("DNI:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        form1.add(jlDni, gridBagConstraints);

        inputDni.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        inputDni.setPreferredSize(new java.awt.Dimension(165, 40));
        inputDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDniActionPerformed(evt);
            }
        });
        inputDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputDniKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        form1.add(inputDni, gridBagConstraints);

        jlNacimiento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlNacimiento.setForeground(new java.awt.Color(0, 0, 0));
        jlNacimiento.setText("Nacimiento (A/M/D):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        form1.add(jlNacimiento, gridBagConstraints);

        jlCodigo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlCodigo.setForeground(new java.awt.Color(0, 0, 0));
        jlCodigo.setText("Codigo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        form1.add(jlCodigo, gridBagConstraints);

        inputCodigo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        inputCodigo.setMinimumSize(new java.awt.Dimension(165, 40));
        inputCodigo.setPreferredSize(new java.awt.Dimension(165, 40));
        inputCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCodigoActionPerformed(evt);
            }
        });
        inputCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputCodigoKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        form1.add(inputCodigo, gridBagConstraints);

        jlCargo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlCargo.setForeground(new java.awt.Color(0, 0, 0));
        jlCargo.setText("Cargo:");
        jlCargo.setMaximumSize(new java.awt.Dimension(126, 22));
        jlCargo.setMinimumSize(new java.awt.Dimension(126, 22));
        jlCargo.setPreferredSize(new java.awt.Dimension(126, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        form1.add(jlCargo, gridBagConstraints);

        inputCargo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        inputCargo.setPreferredSize(new java.awt.Dimension(165, 40));
        inputCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputCargoKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        form1.add(inputCargo, gridBagConstraints);

        inputNacimiento.setDateFormatString("yyyy-MM-dd");
        inputNacimiento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        inputNacimiento.setMaxSelectableDate(new java.util.Date(1704088877000L));
        inputNacimiento.setMinSelectableDate(new java.util.Date(-2208966607000L));
        inputNacimiento.setMinimumSize(new java.awt.Dimension(165, 40));
        inputNacimiento.setPreferredSize(new java.awt.Dimension(165, 40));
        inputNacimiento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                inputNacimientoPropertyChange(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        form1.add(inputNacimiento, gridBagConstraints);

        form2.setMinimumSize(new java.awt.Dimension(494, 186));
        form2.setPreferredSize(new java.awt.Dimension(494, 222));
        java.awt.GridBagLayout form2Layout = new java.awt.GridBagLayout();
        form2Layout.columnWidths = new int[] {0, 15, 0};
        form2Layout.rowHeights = new int[] {0, 40, 0};
        form2.setLayout(form2Layout);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setMinimumSize(new java.awt.Dimension(200, 250));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 194, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        form2.add(jPanel1, gridBagConstraints);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Capturar");
        jButton1.setPreferredSize(new java.awt.Dimension(120, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        form2.add(jButton1, gridBagConstraints);

        btnguardar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.setEnabled(false);
        btnguardar.setMaximumSize(new java.awt.Dimension(120, 40));
        btnguardar.setMinimumSize(new java.awt.Dimension(120, 40));
        btnguardar.setPreferredSize(new java.awt.Dimension(120, 40));
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCuerpoLayout = new javax.swing.GroupLayout(panelCuerpo);
        panelCuerpo.setLayout(panelCuerpoLayout);
        panelCuerpoLayout.setHorizontalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(480, 480, 480)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(form1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(form2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        panelCuerpoLayout.setVerticalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(form2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(form1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        add(panelCuerpo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        infoUsuario();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void inputNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNombreKeyReleased
        habilitarBoton();
    }//GEN-LAST:event_inputNombreKeyReleased

    private void inputApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputApellidoKeyReleased
        habilitarBoton();
    }//GEN-LAST:event_inputApellidoKeyReleased

    private void inputDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputDniKeyReleased
        habilitarBoton();
    }//GEN-LAST:event_inputDniKeyReleased

    private void inputCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputCodigoKeyReleased
        habilitarBoton();
    }//GEN-LAST:event_inputCodigoKeyReleased

    private void inputCargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputCargoKeyReleased
        habilitarBoton();
    }//GEN-LAST:event_inputCargoKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void inputNacimientoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_inputNacimientoPropertyChange
        if("date".equals(evt.getPropertyName())){
            habilitarBoton();
            inputCodigo.requestFocusInWindow();
            
        }
    }//GEN-LAST:event_inputNacimientoPropertyChange

    private void inputNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNombreActionPerformed
        inputApellido.requestFocusInWindow();
    }//GEN-LAST:event_inputNombreActionPerformed

    private void inputApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputApellidoActionPerformed
        inputDni.requestFocusInWindow();
    }//GEN-LAST:event_inputApellidoActionPerformed

    private void inputDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDniActionPerformed
        inputNacimiento.requestFocusInWindow();
    }//GEN-LAST:event_inputDniActionPerformed

    private void inputCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCodigoActionPerformed
        inputCargo.requestFocusInWindow();
    }//GEN-LAST:event_inputCodigoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private javax.swing.JPanel form1;
    private javax.swing.JPanel form2;
    private javax.swing.JTextField inputApellido;
    private javax.swing.JTextField inputCargo;
    private javax.swing.JTextField inputCodigo;
    private javax.swing.JTextField inputDni;
    private com.toedter.calendar.JDateChooser inputNacimiento;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlApellido;
    private javax.swing.JLabel jlCargo;
    private javax.swing.JLabel jlCodigo;
    private javax.swing.JLabel jlDni;
    private javax.swing.JLabel jlNacimiento;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JPanel panelCuerpo;
    private javax.swing.JPanel panelTitulo;
    // End of variables declaration//GEN-END:variables
}
