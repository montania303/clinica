
package Vista;

import Datos.ReservaDAO;
import Modelo.Reserva;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;


public class FrmExpediente extends javax.swing.JFrame {
    ArrayList lista = new ArrayList();
    ReservaDAO reserva = new ReservaDAO();
    Reserva reservaObj = null;
    public FrmExpediente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    public void buscar(){
        Date Inicio = jdDesde.getDate();
        Date Fin =  jdHasta.getDate();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Paciente");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Sexo");
        modelo.addColumn("Telefono");
        modelo.addColumn("CI");
        modelo.addColumn("Fecha Nacimiento");
        modelo.addColumn("Nacionalidad");
        modelo.addColumn("Ciudad de Origen");
        modelo.addColumn("Ciudad Actual");
        modelo.addColumn("Estado Civil");
        modelo.addColumn("Edad");
        modelo.addColumn("Conyugue");
        modelo.addColumn("Tipo de Sangre");
        modelo.addColumn("ID Medico");
        modelo.addColumn("Medico");
        modelo.addColumn("Especialidad");
        modelo.addColumn("Fecha Reserva");
        modelo.addColumn("Turno");
        lista = reserva.Filtro(Inicio,Fin);
        Object[] fila = new Object[20];
        for (int i = 0; i < lista.size(); i++) {
            reservaObj= (Reserva) lista.get(i);
            fila[0] = reservaObj.getId();
            fila[1] = reservaObj.getNombres();
            fila[2] = reservaObj.getApellidos();
            fila[3] = reservaObj.getSexo();
            fila[4] = reservaObj.getTelefono();
            fila[5] = reservaObj.getCi();
            fila[6] = reservaObj.getFecha_nacimiento();
            fila[7] = reservaObj.getNacionalidad();
            fila[8] = reservaObj.getCiudad_de_origen();
            fila[9] = reservaObj.getCiudad_actual();
            fila[10] = reservaObj.getEstado_civil();
            fila[11] = reservaObj.getEdad();
            fila[12] = reservaObj.getConyugue();
            fila[13] = reservaObj.getTipo_sangre();
            fila[14] = reservaObj.getIdmedico();
            fila[15] = reservaObj.getMedico();
            fila[16] = reservaObj.getEspecialidad();
            fila[17] = reservaObj.getFecha_reserva();
            fila[18] = reservaObj.getTurno();
            fila[19] = reservaObj.getNro_ingreso();
            modelo.addRow(fila);
        }
        tblExpediente.setModel(modelo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jdDesde = new com.toedter.calendar.JDateChooser();
        jdHasta = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExpediente = new javax.swing.JTable();
        btnFiltrar = new javax.swing.JButton();
        tbnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Reservas hechas"));

        jLabel1.setText("Hasta:");

        jLabel2.setText("Desde:");

        tblExpediente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblExpediente);

        btnFiltrar.setBackground(java.awt.Color.white);
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        tbnAtras.setBackground(java.awt.Color.white);
        tbnAtras.setText("<Atras");
        tbnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(286, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(239, 239, 239))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jdHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jdDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        buscar();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void tbnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnAtrasActionPerformed
        this.dispose();
        new FrmMenu().setVisible(true);
    }//GEN-LAST:event_tbnAtrasActionPerformed

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
            java.util.logging.Logger.getLogger(FrmExpediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmExpediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmExpediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmExpediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmExpediente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdDesde;
    private com.toedter.calendar.JDateChooser jdHasta;
    private javax.swing.JTable tblExpediente;
    private javax.swing.JButton tbnAtras;
    // End of variables declaration//GEN-END:variables
}
