
package Vista;

import Controlador.PacienteController;
import Modelo.Paciente;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class FrmNuevoPaciente extends javax.swing.JFrame {
    PacienteController paciente = new PacienteController();
    Paciente pacienteObj = null;
    ArrayList lista = new ArrayList();
    
    public FrmNuevoPaciente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        refresh();
    }
    
    public void refresh() {
        Integer mayor = 0;
        DefaultTableModel modelo = new DefaultTableModel();
        lista = paciente.listar("order by idpaciente ASC");
        Object[] fila = new Object[1];
        for (int i = 0; i < lista.size(); i++) {
            pacienteObj = (Paciente) lista.get(i);
            fila[0] = pacienteObj.getId();
            modelo.addRow(fila);
        }
        mayor = (Integer) fila[0] + 1;
        txtCod.setText(String.valueOf(mayor));
        txtCod.enable(false);
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText(null);
        txtTelefono.setText("");
        txtCI.setText("");
        txtNacionalidad.setText("");
        txtConyugue.setText("");
        txtLugar_Nacimiento.setText("");
        txtCiudad_Actual.setText("");
        Calendar c2 = new GregorianCalendar();
        ((JTextField) this.jdFecha.getDateEditor()).setEditable(false);  
        jdFecha.setCalendar(c2);
    }
    
    public void calcula_edad(){
        LocalDate hoy = LocalDate.now();   
        LocalDate nacimiento = jdFeNac.getCalendar().toInstant().
           atZone(ZoneId.systemDefault()).toLocalDate(); 
        long edad = ChronoUnit.YEARS.between(nacimiento, hoy); 
        String edadN = Long.toString(edad);
        txtEdad.setText(edadN);
    }
    
    public static String Mayuscula(String str) {
        if (str.isEmpty()) {
            return str;            
        } else {
            return Character.toUpperCase(str.charAt(0)) + str.substring(1); 
        }
    }
    
    public void registrar(){
        Integer id = Integer.parseInt(txtCod.getText());      
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String sexo = cbxSexo.getSelectedItem().toString();
        String telefono = txtTelefono.getText();
        String ci = txtCI.getText();
        Date fNac = jdFeNac.getDate();
        String nacionalidad = txtNacionalidad.getText();
        String ciudad_origen = txtLugar_Nacimiento.getText();
        String ciudad_actual = txtCiudad_Actual.getText();
        String estado_civil = cbxEstado_Civil.getSelectedItem().toString();
        Integer edad;
        if(txtEdad.getText().equals("")){
            edad= 0;
        }else{
            edad = Integer.parseInt(txtEdad.getText());
        }      
        String conyugue = txtConyugue.getText();
        String tipo_sangre = cbxTipo_Sangre.getSelectedItem().toString();
        Date fingresada = jdFecha.getDate();
        
        pacienteObj = new Paciente(id, nombre, apellido, sexo,telefono, 
                                       ci, fNac, nacionalidad, ciudad_origen, 
                                       ciudad_actual,estado_civil, edad, 
                                       conyugue, tipo_sangre, fingresada );
        
        if (txtNombre.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            txtNombre.requestFocus();
        } else if (apellido.equals("")){
            JOptionPane.showMessageDialog(null, "Favor complete todos los campos!"); 
            txtApellido.requestFocus();
        } else if (fNac.equals("")){
            JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            jdFeNac.requestFocus();
        } else if (nacionalidad.equals("")){
            JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            txtNacionalidad.requestFocus();
        } else if (ciudad_origen.equals("")) {
            JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            txtLugar_Nacimiento.requestFocus();
        }else if (ciudad_actual.equals("")){
            JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
        } else if (edad.equals(0)){
            JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            txtEdad.requestFocus();
        } else if (conyugue.equals("")) {
            JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            txtConyugue.requestFocus();
        } else if (fingresada.equals("")) {
            JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            jdFecha.requestFocus();
        } else if (telefono.equals("")){
            JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            txtTelefono.requestFocus();
        } else if (ci.equals("")) {
            JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            txtCI.requestFocus();
        }else{
            paciente.insertar(pacienteObj);
            refresh();
            this.dispose();
            new FrmMenu().setVisible(true);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpDatos = new javax.swing.JPanel();
        lblCod = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        lblNombres = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        lblFeNac = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        cbxSexo = new javax.swing.JComboBox();
        txtTelefono = new javax.swing.JTextField();
        lblN_CI = new javax.swing.JLabel();
        txtCI = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblConyugue = new javax.swing.JLabel();
        txtConyugue = new javax.swing.JTextField();
        lblNacionalidad = new javax.swing.JLabel();
        txtNacionalidad = new javax.swing.JTextField();
        lblEstado_Civil = new javax.swing.JLabel();
        cbxEstado_Civil = new javax.swing.JComboBox();
        lblCiudad_Actual = new javax.swing.JLabel();
        txtCiudad_Actual = new javax.swing.JTextField();
        lblTipo_Sangre = new javax.swing.JLabel();
        txtLugar_Nacimiento = new javax.swing.JTextField();
        lblLugar_Nacimiento = new javax.swing.JLabel();
        cbxTipo_Sangre = new javax.swing.JComboBox();
        btnAtras = new javax.swing.JButton();
        jdFecha = new com.toedter.calendar.JDateChooser();
        jdFeNac = new com.toedter.calendar.JDateChooser();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nuevo Paciente");
        setBackground(new java.awt.Color(255, 255, 255));

        jpDatos.setBackground(new java.awt.Color(255, 255, 255));
        jpDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Rellenar Campos"));

        lblCod.setText("Codigo:");

        lblNombres.setText("Nombre(s):");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        lblApellido.setText("Apellido(s):");

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidoKeyReleased(evt);
            }
        });

        lblSexo.setText("Sexo:");

        lblFeNac.setText("FeNac:");

        lblEdad.setText("Edad:");

        txtEdad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEdadMouseClicked(evt);
            }
        });

        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));
        cbxSexo.setBorder(null);
        cbxSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSexoActionPerformed(evt);
            }
        });

        lblN_CI.setText("Nº C.I:");

        txtCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCIActionPerformed(evt);
            }
        });

        lblFecha.setText("Fecha:");

        lblTelefono.setText("Telefono:");

        lblConyugue.setText("Conyugue:");

        txtConyugue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtConyugueMouseClicked(evt);
            }
        });
        txtConyugue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConyugueActionPerformed(evt);
            }
        });
        txtConyugue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConyugueKeyReleased(evt);
            }
        });

        lblNacionalidad.setText("Nacionalidad:");

        txtNacionalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNacionalidadKeyReleased(evt);
            }
        });

        lblEstado_Civil.setText("Estado Civil:");

        cbxEstado_Civil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Casado/a", "Soltero/a" }));
        cbxEstado_Civil.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cbxEstado_CivilMouseMoved(evt);
            }
        });
        cbxEstado_Civil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbxEstado_CivilMouseEntered(evt);
            }
        });
        cbxEstado_Civil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstado_CivilActionPerformed(evt);
            }
        });

        lblCiudad_Actual.setText("Ciudad Actual:");

        txtCiudad_Actual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCiudad_ActualKeyReleased(evt);
            }
        });

        lblTipo_Sangre.setText("Tipo de Sangre:");

        txtLugar_Nacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLugar_NacimientoActionPerformed(evt);
            }
        });
        txtLugar_Nacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLugar_NacimientoKeyReleased(evt);
            }
        });

        lblLugar_Nacimiento.setText("Lugar de Nacimiento:");

        cbxTipo_Sangre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RH+", "RH-", "A+", "A-", "B+", "B-" }));
        cbxTipo_Sangre.setBorder(null);

        btnAtras.setBackground(new java.awt.Color(255, 255, 255));
        btnAtras.setText("<Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        jdFecha.setEnabled(false);

        jdFeNac.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jdFeNacComponentAdded(evt);
            }
        });
        jdFeNac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jdFeNacMouseEntered(evt);
            }
        });
        jdFeNac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jdFeNacKeyReleased(evt);
            }
        });

        btnRegistrar.setBackground(java.awt.Color.white);
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpDatosLayout = new javax.swing.GroupLayout(jpDatos);
        jpDatos.setLayout(jpDatosLayout);
        jpDatosLayout.setHorizontalGroup(
            jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpDatosLayout.createSequentialGroup()
                                .addComponent(lblFeNac)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jdFeNac, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDatosLayout.createSequentialGroup()
                                .addComponent(lblEdad)
                                .addGap(12, 12, 12)
                                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDatosLayout.createSequentialGroup()
                                .addComponent(lblSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addComponent(lblApellido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombres)
                            .addComponent(lblCod))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpDatosLayout.createSequentialGroup()
                                .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblFecha)
                                .addGap(18, 18, 18)
                                .addComponent(jdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpDatosLayout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpDatosLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jpDatosLayout.createSequentialGroup()
                                                .addComponent(lblEstado_Civil)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbxEstado_Civil, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jpDatosLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(lblConyugue)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtConyugue, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpDatosLayout.createSequentialGroup()
                                            .addComponent(lblNacionalidad)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtNacionalidad))
                                        .addGroup(jpDatosLayout.createSequentialGroup()
                                            .addGap(0, 19, Short.MAX_VALUE)
                                            .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jpDatosLayout.createSequentialGroup()
                                                    .addComponent(lblN_CI)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtCI, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jpDatosLayout.createSequentialGroup()
                                                    .addComponent(lblTelefono)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAtras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDatosLayout.createSequentialGroup()
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCiudad_Actual)
                            .addComponent(lblLugar_Nacimiento)
                            .addComponent(lblTipo_Sangre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(txtCiudad_Actual)
                            .addComponent(txtLugar_Nacimiento)
                            .addComponent(cbxTipo_Sangre, 0, 101, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jpDatosLayout.setVerticalGroup(
            jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCod)
                                .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblFecha))
                            .addComponent(jdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpDatosLayout.createSequentialGroup()
                                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNombres)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblApellido)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSexo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFeNac)
                                    .addComponent(jdFeNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblEdad)
                                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpDatosLayout.createSequentialGroup()
                                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTelefono)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblN_CI)
                                    .addComponent(txtCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNacionalidad)
                                    .addComponent(txtNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblEstado_Civil)
                                    .addComponent(cbxEstado_Civil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblConyugue)
                                    .addComponent(txtConyugue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpDatosLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblLugar_Nacimiento)
                                    .addComponent(txtLugar_Nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpDatosLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCiudad_Actual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCiudad_Actual)))
                            .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTipo_Sangre)
                                .addComponent(cbxTipo_Sangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCIActionPerformed

    private void cbxSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSexoActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.dispose();
        new FrmMenu().setVisible(true);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void txtConyugueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConyugueActionPerformed

    }//GEN-LAST:event_txtConyugueActionPerformed

    private void cbxEstado_CivilMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxEstado_CivilMouseMoved

    }//GEN-LAST:event_cbxEstado_CivilMouseMoved

    private void cbxEstado_CivilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxEstado_CivilMouseEntered

    }//GEN-LAST:event_cbxEstado_CivilMouseEntered

    private void cbxEstado_CivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstado_CivilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEstado_CivilActionPerformed

    private void txtConyugueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtConyugueMouseClicked
        if(cbxEstado_Civil.getSelectedItem()== "Soltero/a"){
            txtConyugue.setText("Sin Conyugue");
        }else{
            txtConyugue.setText("");
        }
    }//GEN-LAST:event_txtConyugueMouseClicked

    private void txtEdadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEdadMouseClicked
        calcula_edad();
        txtEdad.setEditable(false);       
    }//GEN-LAST:event_txtEdadMouseClicked

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        registrar();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        String str = txtNombre.getText();
        txtNombre.setText(Mayuscula(str));
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyReleased
        String str = txtApellido.getText();
        txtApellido.setText(Mayuscula(str));
    }//GEN-LAST:event_txtApellidoKeyReleased

    private void txtLugar_NacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLugar_NacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLugar_NacimientoActionPerformed

    private void txtLugar_NacimientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLugar_NacimientoKeyReleased
        String str = txtLugar_Nacimiento.getText();
        txtLugar_Nacimiento.setText(Mayuscula(str));
    }//GEN-LAST:event_txtLugar_NacimientoKeyReleased

    private void txtCiudad_ActualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiudad_ActualKeyReleased
        String str = txtCiudad_Actual.getText();
        txtCiudad_Actual.setText(Mayuscula(str));
    }//GEN-LAST:event_txtCiudad_ActualKeyReleased

    private void txtConyugueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConyugueKeyReleased
        String str = txtConyugue.getText();
        txtConyugue.setText(Mayuscula(str));
    }//GEN-LAST:event_txtConyugueKeyReleased

    private void txtNacionalidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNacionalidadKeyReleased
        String str = txtNacionalidad.getText();
        txtNacionalidad.setText(Mayuscula(str));
    }//GEN-LAST:event_txtNacionalidadKeyReleased

    private void jdFeNacMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdFeNacMouseEntered

    }//GEN-LAST:event_jdFeNacMouseEntered

    private void jdFeNacComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jdFeNacComponentAdded

    }//GEN-LAST:event_jdFeNacComponentAdded

    private void jdFeNacKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdFeNacKeyReleased
        
    }//GEN-LAST:event_jdFeNacKeyReleased

    
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
            java.util.logging.Logger.getLogger(FrmNuevoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmNuevoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmNuevoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmNuevoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmNuevoPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox cbxEstado_Civil;
    private javax.swing.JComboBox cbxSexo;
    private javax.swing.JComboBox cbxTipo_Sangre;
    private com.toedter.calendar.JDateChooser jdFeNac;
    private com.toedter.calendar.JDateChooser jdFecha;
    private javax.swing.JPanel jpDatos;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCiudad_Actual;
    private javax.swing.JLabel lblCod;
    private javax.swing.JLabel lblConyugue;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEstado_Civil;
    private javax.swing.JLabel lblFeNac;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblLugar_Nacimiento;
    private javax.swing.JLabel lblN_CI;
    private javax.swing.JLabel lblNacionalidad;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipo_Sangre;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCI;
    private javax.swing.JTextField txtCiudad_Actual;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtConyugue;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtLugar_Nacimiento;
    private javax.swing.JTextField txtNacionalidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
