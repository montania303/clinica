
package Vista;

import Modelo.Usuarios;
import javax.swing.JOptionPane;


public class FrmMenu extends javax.swing.JFrame {
        static Usuarios usuariOnline;
        //usuarioOnline te ba servir para instanciar el usuario q este en linea y al ser statico podes instanciarle 
        // en culaquier parte del sistema
        // 
    /**
     * Creates new form FrmMenu
     */
    public FrmMenu() {
       initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
    }
    public FrmMenu(Usuarios usuarios){
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        usuariOnline = usuarios;
        //aqui podes limiar los accesos que tendran tu usuario en el sistema
        //tipo si es 
        if(usuariOnline.getTipo().equals("Usuario")){
            Administrar.setEnabled(false);
            Expediente.setEnabled(false);
        }else if(usuariOnline.getTipo().equals("Medico")){
            NuevoPaciente.setEnabled(false);
            ActualizarPaciente.setEnabled(false);
            Reserva.setEnabled(false);
            Administrar.setEnabled(false);
        }
        JOptionPane.showMessageDialog(null, "Bienvenido: "+usuariOnline.getNombre());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Registro = new javax.swing.JMenu();
        NuevoPaciente = new javax.swing.JMenuItem();
        ActualizarPaciente = new javax.swing.JMenuItem();
        CerrarSesion = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
        Clinica = new javax.swing.JMenu();
        Reserva = new javax.swing.JMenuItem();
        Expediente = new javax.swing.JMenuItem();
        Administrar = new javax.swing.JMenu();
        Usuarios = new javax.swing.JMenuItem();
        Medicos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu.PNG"))); // NOI18N

        Registro.setText("Registro");

        NuevoPaciente.setText("Nuevo Paciente");
        NuevoPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoPacienteActionPerformed(evt);
            }
        });
        Registro.add(NuevoPaciente);

        ActualizarPaciente.setText("Actualizar Paciente");
        ActualizarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarPacienteActionPerformed(evt);
            }
        });
        Registro.add(ActualizarPaciente);

        CerrarSesion.setText("Cerrar Sesion");
        CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionActionPerformed(evt);
            }
        });
        Registro.add(CerrarSesion);

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        Registro.add(Salir);

        jMenuBar1.add(Registro);

        Clinica.setText("Clinica");

        Reserva.setText("Reserva");
        Reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReservaActionPerformed(evt);
            }
        });
        Clinica.add(Reserva);

        Expediente.setText("Expediente");
        Expediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpedienteActionPerformed(evt);
            }
        });
        Clinica.add(Expediente);

        jMenuBar1.add(Clinica);

        Administrar.setText("Admistrar");

        Usuarios.setText("Usuarios");
        Usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuariosActionPerformed(evt);
            }
        });
        Administrar.add(Usuarios);

        Medicos.setText("Medicos");
        Medicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MedicosActionPerformed(evt);
            }
        });
        Administrar.add(Medicos);

        jMenuBar1.add(Administrar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 813, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NuevoPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoPacienteActionPerformed
        this.dispose();
        new FrmNuevoPaciente().setVisible(true);
    }//GEN-LAST:event_NuevoPacienteActionPerformed

    private void ActualizarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarPacienteActionPerformed
        this.dispose();
        new FrmActualizar_Paciente().setVisible(true);
    }//GEN-LAST:event_ActualizarPacienteActionPerformed

    private void MedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedicosActionPerformed
        this.dispose();
        new FrmMedico().setVisible(true);
    }//GEN-LAST:event_MedicosActionPerformed

    private void UsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuariosActionPerformed
        this.dispose();
        new FrmUsuarios().setVisible(true);
    }//GEN-LAST:event_UsuariosActionPerformed

    private void CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionActionPerformed
        this.dispose();
        new FrmLogin().setVisible(true);
    }//GEN-LAST:event_CerrarSesionActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_SalirActionPerformed

    private void ReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReservaActionPerformed
        this.dispose();
        new FrmReserva().setVisible(true);
    }//GEN-LAST:event_ReservaActionPerformed

    private void ExpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpedienteActionPerformed
        this.dispose();
        new FrmExpediente().setVisible(true);
    }//GEN-LAST:event_ExpedienteActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ActualizarPaciente;
    private javax.swing.JMenu Administrar;
    private javax.swing.JMenuItem CerrarSesion;
    private javax.swing.JMenu Clinica;
    private javax.swing.JMenuItem Expediente;
    private javax.swing.JMenuItem Medicos;
    private javax.swing.JMenuItem NuevoPaciente;
    private javax.swing.JMenu Registro;
    private javax.swing.JMenuItem Reserva;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenuItem Usuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
