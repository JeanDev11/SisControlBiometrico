package Gui;

import Services.AsistenciaDao;
import Services.DataStorage;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author JeanSL
 */
public class Main extends javax.swing.JFrame {

//    Historial venH;
    
    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        loading();
        Home venH = new Home();
        paneles(venH);
        
    }
    
    private void paneles(JPanel panel){
        panel.setSize(1080, 700);
        panel.setLocation(0, 0);
        panelC.removeAll();
        panelC.add(panel);
        panelC.revalidate();
        panelC.repaint();
    }
    
    private void loading(){
        // Guarda los datos en DataStorage
        AsistenciaDao ad = new AsistenciaDao();
        ArrayList<String> listaAño = ad.getAños();
        DataStorage.getInstance().saveData("listaAños", listaAño);
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelW = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panelN = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelC = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 800));
        setSize(new java.awt.Dimension(1080, 700));

        panelW.setBackground(new java.awt.Color(178, 200, 186));
        panelW.setPreferredSize(new java.awt.Dimension(200, 700));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Registrar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setPreferredSize(new java.awt.Dimension(110, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Reporte");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.setPreferredSize(new java.awt.Dimension(110, 40));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelWLayout = new javax.swing.GroupLayout(panelW);
        panelW.setLayout(panelWLayout);
        panelWLayout.setHorizontalGroup(
            panelWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panelWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        panelWLayout.setVerticalGroup(
            panelWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(293, Short.MAX_VALUE))
        );

        getContentPane().add(panelW, java.awt.BorderLayout.WEST);

        panelN.setBackground(new java.awt.Color(134, 167, 137));
        panelN.setPreferredSize(new java.awt.Dimension(1280, 100));
        panelN.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Candara Light", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DigiGuard");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        panelN.add(jLabel1, gridBagConstraints);

        getContentPane().add(panelN, java.awt.BorderLayout.NORTH);

        panelC.setMinimumSize(new java.awt.Dimension(1080, 700));
        panelC.setPreferredSize(new java.awt.Dimension(1080, 700));
        panelC.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(panelC, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        NuevoUsuario venN = new NuevoUsuario();
        paneles(venN);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Historial venH = new Historial();
        paneles(venH);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelC;
    private javax.swing.JPanel panelN;
    private javax.swing.JPanel panelW;
    // End of variables declaration//GEN-END:variables
}
