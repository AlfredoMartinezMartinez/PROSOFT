/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import dominio.GestorReproductorMusica;

/**
 *
 * @author Alfredo
 */
public class IU_USUARIO extends javax.swing.JFrame {

    /**
     * Creates new form IU_Administrativo
     */
    public IU_USUARIO() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSalir = new javax.swing.JButton();
        jButtonPausa = new javax.swing.JButton();
        jButtonPlay = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();
        lblMensaje = new javax.swing.JLabel();
        jButtonStop = new javax.swing.JButton();
        jlabelfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonSalir.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, 70, -1));

        jButtonPausa.setBackground(new java.awt.Color(255, 255, 255));
        jButtonPausa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonPausa.setText("Pausa");
        jButtonPausa.setToolTipText("");
        jButtonPausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPausaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPausa, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 430, 120, -1));

        jButtonPlay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonPlay.setText("Play");
        jButtonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 130, -1));

        jButtonBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonBuscar.setText("Buscar");
        getContentPane().add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 100, -1));

        jTextFieldBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jTextFieldBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 370, 30));
        getContentPane().add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, 310, 20));

        jButtonStop.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonStop.setText("Stop");
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonStop, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 430, 140, -1));

        jlabelfondo.setBackground(new java.awt.Color(255, 255, 255));
        jlabelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoAzul.png"))); // NOI18N
        getContentPane().add(jlabelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonPausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPausaActionPerformed
        // TODO add your handling code here:
        
        try{
                jButtonPlay.setEnabled(true);
                gestor_reproductor.pausa();
                jButtonPausa.setEnabled(false);
		//btnPausa.setEnabled(b);
                               
					
		}catch (Exception e){
		     e.printStackTrace();						
		    }//fin catch
    }//GEN-LAST:event_jButtonPausaActionPerformed

    private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayActionPerformed
        // TODO add your handling code here:
        	try {
                    if(jButtonPausa.isEnabled()==false){
			gestor_reproductor.continuar();
			jButtonPausa.setEnabled(true);}
                    else{
			gestor_reproductor.abrirFichero();
			gestor_reproductor.reproducirMusica();
			jButtonPausa.setEnabled(true);
			jButtonPlay.setEnabled(false);}
				
					
			}catch (Exception e) {
				lblMensaje.setText(e.getMessage());
			}
        
    }//GEN-LAST:event_jButtonPlayActionPerformed

    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        // TODO add your handling code here:
        try {
				
				gestor_reproductor.stop();
				jButtonPausa.setEnabled(true);
				jButtonPlay.setEnabled(true);				
			} catch (Exception e) {
				lblMensaje.setText(e.getMessage());
			}
    }//GEN-LAST:event_jButtonStopActionPerformed

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
            java.util.logging.Logger.getLogger(IU_USUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IU_USUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IU_USUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IU_USUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IU_USUARIO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonPausa;
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JLabel jlabelfondo;
    private javax.swing.JLabel lblMensaje;
    private GestorReproductorMusica gestor_reproductor = new GestorReproductorMusica();
    // End of variables declaration//GEN-END:variables
}
