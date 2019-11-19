
package Vista;

import Controlador.PacienteController;
import Controlador.ReservaController;
import Datos.ReservaDAO;
import Modelo.Ingreso;
import Modelo.Paciente;
import Modelo.Reserva;
import static Vista.FrmNuevoPaciente.Mayuscula;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FrmReserva extends javax.swing.JFrame {
    PacienteController paciente = new PacienteController();
    ReservaController reserva = new ReservaController();
    Paciente pacienteObj = null;
    Ingreso ingresoObj = null;
    Reserva reservaObj = null;
    ReservaDAO reservado = new ReservaDAO();
    ArrayList lista = new ArrayList(); 
    
    public FrmReserva() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        refresh();
        bloqueo();
    }
    
    public void bloqueo(){
        txtNroIngreso.setEditable(false);
        txtNombre.setEditable(false);
        txtApellido.setEditable(false);
        cbxSexo.setEditable(false);
        ((JTextField) this.jdFeNac.getDateEditor()).setEditable(false); 
        ((JTextField) this.jdfecha.getDateEditor()).setEditable(false);  
        txtTelefono.setEditable(false);
        txtNroCedula.setEditable(false);
        txtNacionalidad.setEditable(false);
        txtEdad.setEditable(false);
        cbxEstado.setEditable(false);
        txtConyugue.setEditable(false);
        cbxTipoSangre.setEditable(false);
        txtLugarNac.setEditable(false);
        txtCiudadAct.setEditable(false);
        txtIdMedico.setEditable(false);
        txtCama.setEditable(false);
        txtHabitacion.setEditable(false);
    }

    public void buscar() {
        Integer codigo;
        try {
            if(txtCod.getText().equals("")){
                codigo = 0;
                refresh();
            }else{
                codigo = Integer.parseInt(txtCod.getText());  
                lista = paciente.buscar(codigo);
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
                    txtNombre.setText((String) fila[1]);
                    txtApellido.setText((String) fila[2]);
                    cbxSexo.addItem((String) fila[3]);
                    txtTelefono.setText((String) fila[4]);
                    txtNroCedula.setText((String) fila[5]);
                    jdFeNac.setDate((Date) fila[6]);
                    txtNacionalidad.setText((String) fila[7]);
                    txtLugarNac.setText((String) fila[8]);
                    txtCiudadAct.setText((String) fila[9]);
                    cbxEstado.addItem((String) fila[10]);
                    txtEdad.setText((String) fila[11].toString());
                    txtConyugue.setText((String) fila[12]);
                    cbxTipoSangre.addItem((String) fila[13]);
                }
            }
        } catch (Exception e) {
              
        }
    }
    
    public void refresh() {
        try {
            Integer mayor = 0;
            lista = reserva.listar("order by nro_ingreso ASC");
            Object[] fila = new Object[1];
            for (int i = 0; i < lista.size(); i++) {
                ingresoObj = (Ingreso) lista.get(i);
                fila[0] = ingresoObj.getNro_ingreso();
            }
            mayor = (Integer) fila[0] + 1;
            txtNroIngreso.setText(String.valueOf(mayor));
            txtNombre.setText("");
            txtApellido.setText("");
            txtEdad.setText("");
            txtTelefono.setText("");
            txtNroCedula.setText("");
            txtNacionalidad.setText("");
            txtConyugue.setText("");
            txtCiudadAct.setText("");
            txtLugarNac.setText("");
            cbxEstado.removeAllItems();
            cbxTipoSangre.removeAllItems();
            cbxSexo.removeAllItems();
            jdFeNac.setDate(null);
            java.util.Date fecha = new Date();
            jdfecha.setDate(fecha);
        } catch (Exception e) {
        }
    }
    
    public void buscar_Datos() {
        String nombre;
        try {
            nombre = cbxEspecialidad.getSelectedItem().toString();
            lista = reserva.buscar(nombre);
            Object[] fila = new Object[6];
            for (int i = 0; i < lista.size(); i++) {
                ingresoObj = (Ingreso) lista.get(i);
                fila[0] = ingresoObj.getNro_ingreso();
                fila[1] = ingresoObj.getHabitacion();
                fila[2] = ingresoObj.getCama();
                fila[3] = ingresoObj.getFecha_ingreso();
                fila[4] = ingresoObj.getCodigo_paciente();
                fila[5] = ingresoObj.getCodigo_medico();
                txtIdMedico.setText(fila[5].toString());
                txtHabitacion.setText(fila[1].toString());
                txtCama.setText(fila[2].toString());
            }

        } catch (Exception e){
        }

    }
    public void reservar(){
 
            Integer id = Integer.parseInt(txtCod.getText());      
            String nombres = txtNombre.getText();
            String apellidos = txtApellido.getText();
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
            Integer idmedico = Integer.parseInt(txtIdMedico.getText());
            String medico = cbxMedico.getSelectedItem().toString();
            String especialidad = cbxEspecialidad.getSelectedItem().toString();
            Date fecha_reserva = jdfecha.getDate();
            String turno = cbxTurno.getSelectedItem().toString();
            Integer nro_ingreso = Integer.parseInt(txtNroIngreso.getText());
            Integer habitacion = Integer.parseInt(txtHabitacion.getText());
            String cama = txtCama.getText();

            reservaObj = new Reserva (id, nombres, apellidos, sexo,telefono, ci, 
            fNac, nacionalidad, ciudad_origen, ciudad_actual,estado_civil, edad, 
            conyugue, tipo_sangre, idmedico,medico, especialidad,fecha_reserva, 
            turno, nro_ingreso);
            
            ingresoObj = new Ingreso(nro_ingreso,habitacion,cama,fecha_reserva,id,idmedico);

            if (id.equals("")){
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            } else if (nombres.equals("")){
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            } else if (apellidos.equals("")){
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos!"); 
            } else if (sexo.equals("")){
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            } else if (telefono.equals("")){
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            } else if (ci.equals("")) {
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            }else if (fNac.equals(null)){
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            } else if (nacionalidad.equals("")){
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            } else if (ciudad_origen.equals("")) {
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            } else if (ciudad_actual.equals("")) {
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            } else if (estado_civil.equals("")){
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            } else if (edad.equals("")) {
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            } else if (conyugue.equals("")) {
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            } else if (tipo_sangre.equals("")) {
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            } else if (idmedico.equals("")) {
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            } else if (medico.equals("")) {
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            } else if (especialidad.equals("")) {
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            } else if (fecha_reserva.equals(null)) {
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            } else if (turno.equals("")) {
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            } else if (nro_ingreso.equals("")) {
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos!");
            }else{
                reserva.insertar(reservaObj);
                reservado.insertar_ingreso(ingresoObj);
                refresh();
                this.dispose();
                new FrmMenu().setVisible(true);
            }
            refresh(); 

    }
    
    public void selecionar() {
        try {  
            String espe = cbxEspecialidad.getSelectedItem().toString();
            String turno = cbxTurno.getSelectedItem().toString();
            if(espe == "Pediatría" && turno == "Mañana"){ 
                cbxMedico.removeAllItems();
                cbxMedico.addItem("Ricardo");
            }else if(espe == "Pediatría" && turno == "Tarde"){
                cbxMedico.removeAllItems();
                cbxMedico.addItem("Eva");
            }else if(espe == "Radiología" && turno == "Mañana"){
                cbxMedico.removeAllItems();
                cbxMedico.addItem("Fernanda");
            }else if(espe == "Radiología" && turno == "Tarde"){
                cbxMedico.removeAllItems();
                cbxMedico.addItem("Silvio");
            }else if(espe == "Cardiologia" && turno == "Mañana"){
                cbxMedico.removeAllItems();
                cbxMedico.addItem("Sonia");
            }else if(espe == "Cardiologia" && turno == "Tarde"){
                cbxMedico.removeAllItems();
                cbxMedico.addItem("Alberto");
            }else if(espe == "Cirugía" && turno == "Mañana"){
                cbxMedico.removeAllItems();
                cbxMedico.addItem("Pedro");
            }else if(espe == "Cirugía" && turno == "Tarde"){
                cbxMedico.removeAllItems();
                cbxMedico.addItem("Mauricio");
            }else if(espe == "Clinico" && turno == "Mañana"){
                cbxMedico.removeAllItems();
                cbxMedico.addItem("Daniel");
            }else if(espe == "Clinico" && turno == "Tarde"){
                cbxMedico.removeAllItems();
                cbxMedico.addItem("Mathias");
            }else if(espe == "General" && turno == "Mañana"){
                cbxMedico.removeAllItems();
                cbxMedico.addItem("Maria");
            }else if(espe == "General" && turno == "Tarde"){
                cbxMedico.removeAllItems();
                cbxMedico.addItem("Raul");
            }else if(espe == "Ginecologia" && turno == "Mañana"){
                cbxMedico.removeAllItems();
                cbxMedico.addItem("Blanca");
            }else if(espe == "Ginecologia" && turno == "Tarde"){
                cbxMedico.removeAllItems();
                cbxMedico.addItem("Camila");
            }else if(espe == "Intensivos" && turno == "Mañana"){
                cbxMedico.removeAllItems();
                cbxMedico.setSelectedItem("Olga");
            }else if(espe == "Intensivos" && turno == "Tarde"){
                cbxMedico.removeAllItems();
                cbxMedico.setSelectedItem("Juana");
            }else if(espe == "Odontologia" && turno == "Mañana"){
                cbxMedico.removeAllItems();
                cbxMedico.setSelectedItem("Carmen");
            }else if(espe == "Odontologia" && turno == "Tarde"){
                cbxMedico.removeAllItems();
                cbxMedico.setSelectedItem("Marta");
            }else if(espe == "Oftalmologia" && turno == "Mañana"){
                cbxMedico.removeAllItems();
                cbxMedico.setSelectedItem("Marcelo");
            }else if(espe == "Oftalmologia" && turno == "Tarde"){
                cbxMedico.removeAllItems();
                cbxMedico.setSelectedItem("Matilde");
            }else if(espe == "Análisis" && turno == "Mañana"){
                cbxMedico.removeAllItems();
                cbxMedico.setSelectedItem("Cecilia");
            }else if(espe == "Análisis" && turno == "Tarde"){
                cbxMedico.removeAllItems();
                cbxMedico.setSelectedItem("Federico");
            }
        } catch (Exception e){
        }
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
        jdFeNac = new com.toedter.calendar.JDateChooser();
        jdfecha = new com.toedter.calendar.JDateChooser();
        lblNroIngreso = new javax.swing.JLabel();
        txtNroIngreso = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        lblHabitacion = new javax.swing.JLabel();
        txtHabitacion = new javax.swing.JTextField();
        lblCama = new javax.swing.JLabel();
        txtCama = new javax.swing.JTextField();
        lblEspecialidad = new javax.swing.JLabel();
        cbxEspecialidad = new javax.swing.JComboBox();
        lblTurno = new javax.swing.JLabel();
        cbxTurno = new javax.swing.JComboBox();
        lblMedico = new javax.swing.JLabel();
        cbxMedico = new javax.swing.JComboBox();
        btnReservar = new javax.swing.JButton();
        txtIdMedico = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.white);

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

        txtCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodKeyReleased(evt);
            }
        });

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

        jdFeNac.setEnabled(false);

        jdfecha.setDateFormatString("dd-MM-yyyy");
        jdfecha.setEnabled(false);

        lblNroIngreso.setText("Nro Ingreso");

        jLabel16.setText("<Atras");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jLabel16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLabel16KeyReleased(evt);
            }
        });

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
                .addGap(18, 18, 18)
                .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre)
                    .addComponent(txtApellido)
                    .addComponent(cbxSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdFeNac, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDatos_ClienteLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNacionalidad)
                    .addComponent(txtEdad)
                    .addComponent(txtNroCedula)
                    .addComponent(txtTelefono)
                    .addComponent(jdfecha, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDatos_ClienteLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCiudadAct, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDatos_ClienteLayout.createSequentialGroup()
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtConyugue, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDatos_ClienteLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxTipoSangre, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDatos_ClienteLayout.createSequentialGroup()
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNroIngreso)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNroIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLugarNac, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
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
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8)
                                .addComponent(jdfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNroIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpDatos_ClienteLayout.createSequentialGroup()
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtConyugue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(cbxTipoSangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(txtCiudadAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(lblNroIngreso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatos_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtLugarNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Medico"));

        lblID.setText("ID:");

        lblHabitacion.setText("Habitación:");

        lblCama.setText("Cama:");

        lblEspecialidad.setText("Especialidad:");

        cbxEspecialidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Ginecologia", "Cardiologia", "Intensivos", "Odontologia", "Cirugía", "Análisis", "General", "Oftalmologia", "Radiología", "Pediatría", "Clinico", " " }));
        cbxEspecialidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxEspecialidadItemStateChanged(evt);
            }
        });
        cbxEspecialidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxEspecialidadMouseClicked(evt);
            }
        });

        lblTurno.setText("Turno:");

        cbxTurno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Mañana", "Tarde" }));
        cbxTurno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTurnoItemStateChanged(evt);
            }
        });

        lblMedico.setText("Medico:");

        btnReservar.setText("Reservar");
        btnReservar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReservarMouseClicked(evt);
            }
        });
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCama)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCama, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblHabitacion)
                                    .addComponent(lblID, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtHabitacion, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(txtIdMedico))))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblMedico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTurno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblEspecialidad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btnReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(lblEspecialidad)
                    .addComponent(cbxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHabitacion)
                    .addComponent(txtHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTurno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCama)
                    .addComponent(txtCama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMedico)
                    .addComponent(cbxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpDatos_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpDatos_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReservarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservarMouseClicked
            
    }//GEN-LAST:event_btnReservarMouseClicked

    private void txtCodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodKeyReleased
        buscar();
    }//GEN-LAST:event_txtCodKeyReleased

    private void jLabel16KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel16KeyReleased

    }//GEN-LAST:event_jLabel16KeyReleased

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        this.dispose();
        new FrmMenu().setVisible(true);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void cbxEspecialidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxEspecialidadItemStateChanged
        buscar_Datos();
    }//GEN-LAST:event_cbxEspecialidadItemStateChanged

    private void cbxEspecialidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxEspecialidadMouseClicked
        
    }//GEN-LAST:event_cbxEspecialidadMouseClicked

    private void cbxTurnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTurnoItemStateChanged
        selecionar();
    }//GEN-LAST:event_cbxTurnoItemStateChanged

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        reservar();
    }//GEN-LAST:event_btnReservarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReservar;
    private javax.swing.JComboBox cbxEspecialidad;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox cbxMedico;
    private javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JComboBox<String> cbxTipoSangre;
    private javax.swing.JComboBox cbxTurno;
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
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jdFeNac;
    private com.toedter.calendar.JDateChooser jdfecha;
    private javax.swing.JPanel jpDatos_Cliente;
    private javax.swing.JLabel lblCama;
    private javax.swing.JLabel lblEspecialidad;
    private javax.swing.JLabel lblHabitacion;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblMedico;
    private javax.swing.JLabel lblNroIngreso;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCama;
    private javax.swing.JTextField txtCiudadAct;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtConyugue;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtHabitacion;
    private javax.swing.JTextField txtIdMedico;
    private javax.swing.JTextField txtLugarNac;
    private javax.swing.JTextField txtNacionalidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNroCedula;
    private javax.swing.JTextField txtNroIngreso;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
