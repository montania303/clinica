
package Vista;

import Controlador.PacienteController;
import Modelo.Paciente;
import static Vista.FrmNuevoPaciente.Mayuscula;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FrmActualizar_Paciente extends javax.swing.JFrame {
    PacienteController paciente = new PacienteController();
    Paciente pacienteObj = null;
    ArrayList lista = new ArrayList(); 
    ArrayList lista2 = new ArrayList();
    DefaultListModel modelo2 = new DefaultListModel();
    public FrmActualizar_Paciente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        refresh();
        bloqueo();
        limpiar();
    }
    
    public void bloqueo(){
        txtCod.setEditable(false);
        txtNombre.setEditable(false);
        txtApellido.setEditable(false);
        cbxSexo.setEnabled(false);
        ((JTextField) this.jdFeNac.getDateEditor()).setEditable(false); 
        ((JTextField) this.jdFeNac.getDateEditor()).setEditable(false);  
        txtTelefono.setEditable(false);
        txtNroCedula.setEditable(false);
        txtNacionalidad.setEditable(false);
        txtEdad.setEditable(false);
        cbxEstado.setEditable(false);
        txtConyugue.setEditable(false);
        cbxTipoSangre.setEditable(false);
        txtLugarNac.setEditable(false);
        txtCiudadAct.setEditable(false);
        btnActualizar.setEnabled(false);
        btnModificar.setEnabled(false);
    }
    
    public void Desbloqueo(){
        txtNombre.setEditable(true);
        txtApellido.setEditable(true);
        txtTelefono.setEditable(true);
        txtEdad.setEditable(true);
        cbxEstado.setEditable(true);
        txtConyugue.setEditable(true);
        txtCiudadAct.setEditable(true);
        tblPacientes.setEnabled(false);
        txtBuscar.setEditable(false);
        btnModificar.setEnabled(false);
        btnAtras.setEnabled(false);
        btnActualizar.setEnabled(true);
    }
    
    public void refresh() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");     
        modelo.addColumn("Nombres"); 
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
        modelo.addColumn("Tipo Sangre"); 
        modelo.addColumn("Fecha Ingresada");
        lista = paciente.listar("order by idpaciente ASC");
        Object[] fila = new Object[15];
        for (int i = 0; i < lista.size(); i++) {
            pacienteObj = (Paciente) lista.get(i);
            fila[0] = pacienteObj.getId();
            fila[1] = pacienteObj.getNombres();
            fila[2] = pacienteObj.getApellidos();
            fila[3] = pacienteObj.getSexo();
            fila[4] = pacienteObj.getTelefono();
            fila[5] = pacienteObj.getCI();
            fila[6] = pacienteObj.getFecha_nacimiento();
            fila[7] = pacienteObj.getNacionalidad();
            fila[8] = pacienteObj.getCiudad_de_origen();
            fila[9] = pacienteObj.getCiudad_actual();
            fila[10] = pacienteObj.getEstado_civil();
            fila[11] = pacienteObj.getEdad();
            fila[12] = pacienteObj.getConyugue();
            fila[13] = pacienteObj.getTipo_sangre();
            fila[14] = pacienteObj.getFecha_ingresada();
            modelo.addRow(fila);
         }
        tblPacientes.setModel(modelo);
    }
    public void limpiar(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        txtNroCedula.setText("");
        txtNacionalidad.setText("");
        txtConyugue.setText("");
        txtCod.setText("");
        txtCiudadAct.setText("");
        txtLugarNac.setText("");
        jdfecha.setDate(null);
        cbxSexo.removeAllItems();
        jdFeNac.setDate(null);
    }

    public void buscar() {
        String nombre = txtBuscar.getText();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");     
        modelo.addColumn("Nombres"); 
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
        modelo.addColumn("Tipo Sangre"); 
        modelo.addColumn("Fecha Ingresada");
        lista2 = paciente.buscar(nombre);
        Object[] fila = new Object[15];
        for (int i = 0; i < lista2.size(); i++) {
            pacienteObj = (Paciente) lista2.get(i);
            fila[0] = pacienteObj.getId();
            fila[1] = pacienteObj.getNombres();
            fila[2] = pacienteObj.getApellidos();
            fila[3] = pacienteObj.getSexo();
            fila[4] = pacienteObj.getTelefono();
            fila[5] = pacienteObj.getCI();
            fila[6] = pacienteObj.getFecha_nacimiento();
            fila[7] = pacienteObj.getNacionalidad();
            fila[8] = pacienteObj.getCiudad_de_origen();
            fila[9] = pacienteObj.getCiudad_actual();
            fila[10] = pacienteObj.getEstado_civil();
            fila[11] = pacienteObj.getEdad();
            fila[12] = pacienteObj.getConyugue();
            fila[13] = pacienteObj.getTipo_sangre();
            fila[14] = pacienteObj.getFecha_ingresada();
            modelo.addRow(fila);
        }
        tblPacientes.setModel(modelo);   
    }
    
    public void enviar_datos(){
        Integer filaNum = tblPacientes.getSelectedRow();
        if (filaNum < 0) {
            JOptionPane.showMessageDialog(null,"Debes seleccionar un registro!");
        } else {
            DefaultTableModel modelo = (DefaultTableModel) tblPacientes.getModel();
            Integer id = (Integer) modelo.getValueAt(filaNum, 0);
            String whereTmp = " where idpaciente='" + id + "'";
            pacienteObj = (Paciente) new PacienteController().listar(whereTmp).get(0);
            txtCod.setText(String.valueOf(pacienteObj.getId()));
            txtNombre.setText(pacienteObj.getNombres());
            txtApellido.setText(pacienteObj.getApellidos());
            cbxSexo.addItem(pacienteObj.getSexo());
            jdFeNac.setDate(pacienteObj.getFecha_nacimiento());         
            jdfecha.setDate(pacienteObj.getFecha_ingresada());
            txtTelefono.setText(pacienteObj.getTelefono());
            txtNroCedula.setText(pacienteObj.getCI());
            txtNacionalidad.setText(pacienteObj.getNacionalidad());
            txtEdad.setText(Integer.toString(pacienteObj.getEdad()));
            cbxEstado.addItem(pacienteObj.getEstado_civil());
            txtConyugue.setText(pacienteObj.getConyugue());
            cbxTipoSangre.addItem(pacienteObj.getTipo_sangre());
            txtLugarNac.setText(pacienteObj.getCiudad_de_origen());
            txtCiudadAct.setText(pacienteObj.getCiudad_actual());
            btnModificar.setEnabled(true);
            btnActualizar.setEnabled(false);
        }  
    }
    
    public void actualizar(){
        Integer id = Integer.parseInt(txtCod.getText());      
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String sexo = cbxSexo.getSelectedItem().toString();
        String telefono = txtTelefono.getText();
        String ci = txtNroCedula.getText();
        Date fNac = jdFeNac.getDate();
        String nacionalidad = txtNacionalidad.getText();
        String ciudad_origen = txtLugarNac.getText();
        String ciudad_actual = txtCiudadAct.getText();
        String estado_civil = cbxEstado.getSelectedItem().toString();
        Integer edad = Integer.parseInt(txtEdad.getText());
        String conyugue = txtConyugue.getText();
        String tipo_sangre = cbxTipoSangre.getSelectedItem().toString();
        Date fingresada = jdfecha.getDate();
        
        pacienteObj = new Paciente(id, nombre, apellido, sexo,
        telefono, ci, fNac, nacionalidad, ciudad_origen, ciudad_actual,
        estado_civil, edad, conyugue, tipo_sangre, fingresada );
        
        paciente.modificar( pacienteObj );
        bloqueo();
        refresh();
        limpiar();
        txtBuscar.setEditable(true);
        btnAtras.setEnabled(true);
        tblPacientes.setEnabled(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpDatos_Cliente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtNacionalidad = new javax.swing.JTextField();
        txtLugarNac = new javax.swing.JTextField();
        cbxSexo = new javax.swing.JComboBox<String>();
        txtNroCedula = new javax.swing.JTextField();
        cbxTipoSangre = new javax.swing.JComboBox<String>();
        txtConyugue = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<String>();
        txtCiudadAct = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jdFeNac = new com.toedter.calendar.JDateChooser();
        jdfecha = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPacientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Actualizar Pacientes");
        setBackground(new java.awt.Color(255, 255, 255));

        jpDatos_Cliente.setBackground(new java.awt.Color(255, 255, 255));
        jpDatos_Cliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Paciente"));

        jLabel1.setText("Cod");

        jLabel2.setText("Nombre(s)");

        jLabel3.setText("Apellido(s)");

        jLabel4.setText("Nro. Cedula");

        jLabel5.setText("Edad");

        jLabel6.setText("Sexo");

        jLabel7.setText("Telefono");

        jLabel8.setText("Fecha Ingreso");

        jLabel9.setText("Nacionalidad");

        jLabel10.setText("FeNac ");

        jLabel11.setText("Lugar de nacimiento ");

        jLabel12.setText("Ciudad actual ");

        jLabel13.setText("Conyugue ");

        jLabel14.setText("Estado civil ");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidoKeyReleased(evt);
            }
        });

        txtNacionalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNacionalidadKeyReleased(evt);
            }
        });

        txtLugarNac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLugarNacKeyReleased(evt);
            }
        });

        txtConyugue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConyugueKeyReleased(evt);
            }
        });

        jLabel15.setText("Tipo de Sangre");

        txtCiudadAct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCiudadActKeyReleased(evt);
            }
        });

        jLabel16.setText("Buscar");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Busqueda.jpg"))); // NOI18N

        btnAtras.setText("<Atras");
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
        });

        jdFeNac.setEnabled(false);

        jdfecha.setEnabled(false);

        javax.swing.GroupLayout jpDatos_ClienteLayout = new javax.swing.GroupLayout(jpDatos_Cliente);
        jpDatos_Cliente.setLayout(jpDatos_ClienteLayout);
        jpDatos_ClienteLayout.setHorizontalGroup(
            jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDatos_ClienteLayout.createSequentialGroup()
                .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel10))
                .addGap(35, 35, 35)
                .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre)
                    .addComponent(txtApellido)
                    .addComponent(cbxSexo, 0, 126, Short.MAX_VALUE)
                    .addComponent(txtCod)
                    .addComponent(jdFeNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDatos_ClienteLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jpDatos_ClienteLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNacionalidad, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(txtEdad, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(txtNroCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(jdfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDatos_ClienteLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpDatos_ClienteLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtLugarNac, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpDatos_ClienteLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbxTipoSangre, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpDatos_ClienteLayout.createSequentialGroup()
                                .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13))
                                .addGap(43, 43, 43)
                                .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtConyugue, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jpDatos_ClienteLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCiudadAct, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDatos_ClienteLayout.createSequentialGroup()
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDatos_ClienteLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDatos_ClienteLayout.createSequentialGroup()
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))))
        );
        jpDatos_ClienteLayout.setVerticalGroup(
            jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatos_ClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDatos_ClienteLayout.createSequentialGroup()
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(4, 4, 4)
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(10, 10, 10)
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jdFeNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpDatos_ClienteLayout.createSequentialGroup()
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jdfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(4, 4, 4)
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNroCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jpDatos_ClienteLayout.createSequentialGroup()
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtConyugue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(cbxTipoSangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpDatos_ClienteLayout.createSequentialGroup()
                                .addComponent(txtLugarNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCiudadAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)))
                            .addComponent(jLabel12)))
                    .addGroup(jpDatos_ClienteLayout.createSequentialGroup()
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpDatos_ClienteLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)))
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        tblPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPacientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpDatos_Cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jpDatos_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed

    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String str = txtBuscar.getText();
        txtBuscar.setText(Mayuscula(str));
        buscar();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        Desbloqueo();
    }//GEN-LAST:event_btnModificarMouseClicked

    private void tblPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPacientesMouseClicked
        enviar_datos();
    }//GEN-LAST:event_tblPacientesMouseClicked

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        actualizar();
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        this.dispose();
        new FrmMenu().setVisible(true);
    }//GEN-LAST:event_btnAtrasMouseClicked

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        String str = txtNombre.getText();
        txtNombre.setText(Mayuscula(str));
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyReleased
        String str = txtApellido.getText();
        txtApellido.setText(Mayuscula(str));
    }//GEN-LAST:event_txtApellidoKeyReleased

    private void txtNacionalidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNacionalidadKeyReleased
        String str = txtNacionalidad.getText();
        txtNacionalidad.setText(Mayuscula(str));
    }//GEN-LAST:event_txtNacionalidadKeyReleased

    private void txtConyugueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConyugueKeyReleased
        String str = txtConyugue.getText();
        txtConyugue.setText(Mayuscula(str));
    }//GEN-LAST:event_txtConyugueKeyReleased

    private void txtLugarNacKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLugarNacKeyReleased
        String str = txtLugarNac.getText();
        txtLugarNac.setText(Mayuscula(str));
    }//GEN-LAST:event_txtLugarNacKeyReleased

    private void txtCiudadActKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiudadActKeyReleased
        String str = txtCiudadAct.getText();
        txtCiudadAct.setText(Mayuscula(str));
    }//GEN-LAST:event_txtCiudadActKeyReleased

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
            java.util.logging.Logger.getLogger(FrmActualizar_Paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmActualizar_Paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmActualizar_Paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmActualizar_Paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmActualizar_Paciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JComboBox<String> cbxTipoSangre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdFeNac;
    private com.toedter.calendar.JDateChooser jdfecha;
    private javax.swing.JPanel jpDatos_Cliente;
    private javax.swing.JTable tblPacientes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCiudadAct;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtConyugue;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtLugarNac;
    private javax.swing.JTextField txtNacionalidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNroCedula;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
