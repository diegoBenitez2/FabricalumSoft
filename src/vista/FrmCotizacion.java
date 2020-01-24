/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ClsConexionReporte;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException; 
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;



/**
 *
 * @author DiegoB
 */
public class FrmCotizacion extends javax.swing.JFrame  {
controlador.ClsConexion conn = new controlador.ClsConexion();
modelo.ClsCliente cli = new modelo.ClsCliente();
modelo.ClsCotizacion cot = new modelo.ClsCotizacion();
modelo.ClsCotizacion coti = new modelo.ClsCotizacion();
modelo.ClsProducto pro = new modelo.ClsProducto();
modelo.ClsInsumos insu = new modelo.ClsInsumos();
modelo.ClsTipoProducto tip = new modelo.ClsTipoProducto();
modelo.ClsDespiece dpc = new modelo.ClsDespiece(); 
public vista.Login lg = new vista.Login();

DefaultTableModel tablainsu;
DefaultTableModel tablaproCot;
DefaultTableModel tablaPro;
DefaultTableModel tablaCli;
DefaultTableModel tabladatosinsu;
DefaultTableModel tablaTipPro;
DefaultTableModel tablaDpc;
DefaultTableModel tablaCot;
DefaultTableModel dp;
String ficcli ="";
String ficpro ="";
String ficinsu = "" ;
String fictip = "";
File fichero;


    /**
     * Creates new form FrmCotizacion
     */
    public FrmCotizacion() {
        initComponents();
        setBounds(500, 0, 1201, 720);
      JCrearTablaProductoCotizacion();
      JCrearTablaInsumosCotizacion();
      JCrearTablaInsumos();
      JLlenarTablaInsumos();
      JCrearTablaCliente();
      JLlenartablaCliente();
      JCrearTablaProducto();
      JCargarComboTipoPorducto();
      JCreartablaTipProducto();
      JLlenarTablaTipProducto();
      JCrearTablaDespiece();
      JLlenartablaDespiece();
      JCrearTablaCotizacion();
      JLlenarTablaCotizacion();
      
     
      
      //Agregar nombre al formulario.
      this.setTitle("Formulario Cotizacion");
      Cliente.setTitle("Cliente");
      Producto.setTitle("Producto");
      Despiece.setTitle("Despiece");
      TipoProducto.setTitle("Tipo de Producto");
      Insumos.setTitle("Insumos");
      Cotizaciones.setTitle("Cotizacion");
      MostrarCotizacion.setTitle("Salida Cotizacion");
      MostrarDespiece.setTitle("Salida Despiece");
      this.setLocationRelativeTo(null);
      //agregar logo a la barra de navegacion de cada formulario y Jdialog
      this.setIconImage(new ImageIcon(getClass().getResource("logo2acces.fw.png")).getImage()) ;
      Producto.setIconImage(new ImageIcon(getClass().getResource("logo2acces.fw.png")).getImage()) ;
      Cliente.setIconImage(new ImageIcon(getClass().getResource("logo2acces.fw.png")).getImage()) ;
      Insumos.setIconImage(new ImageIcon(getClass().getResource("logo2acces.fw.png")).getImage()) ;
      Despiece.setIconImage(new ImageIcon(getClass().getResource("logo2acces.fw.png")).getImage()) ;
      Cotizaciones.setIconImage(new ImageIcon(getClass().getResource("logo2acces.fw.png")).getImage()) ;
      TipoProducto.setIconImage(new ImageIcon(getClass().getResource("logo2acces.fw.png")).getImage()) ;
      MostrarCotizacion.setIconImage(new ImageIcon(getClass().getResource("logo2acces.fw.png")).getImage());
      MostrarDespiece.setIconImage(new ImageIcon(getClass().getResource("logo2acces.fw.png")).getImage());
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Insumos = new javax.swing.JDialog();
        jScrollPane3 = new javax.swing.JScrollPane();
        TblInsumos = new javax.swing.JTable();
        btnUpdateInsu = new javax.swing.JButton();
        btnDeleteInsu = new javax.swing.JButton();
        btnAgreInsu = new javax.swing.JButton();
        btnSaveInsu1 = new javax.swing.JButton();
        btnMostrarInsumo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        PnlInsumos = new javax.swing.JPanel();
        txtUsoInsu = new javax.swing.JTextField();
        txtCodInsu = new javax.swing.JTextField();
        txtDesInsu = new javax.swing.JTextField();
        txtReftInsu = new javax.swing.JTextField();
        txtColInsu = new javax.swing.JTextField();
        txtCantInsu = new javax.swing.JTextField();
        txtFabInsu = new javax.swing.JTextField();
        txtTipInsu = new javax.swing.JTextField();
        lblCodInsu = new javax.swing.JLabel();
        lblDesInsu1 = new javax.swing.JLabel();
        lblTipInsu = new javax.swing.JLabel();
        lblUsoInsu1 = new javax.swing.JLabel();
        lblRefInsu = new javax.swing.JLabel();
        lblColInsu = new javax.swing.JLabel();
        lblFabInsu1 = new javax.swing.JLabel();
        lblCanInsu1 = new javax.swing.JLabel();
        lblCanInsu2 = new javax.swing.JLabel();
        txtPreInsu1 = new javax.swing.JTextField();
        txtCod_Dpc_mat = new javax.swing.JTextField();
        lblColInsu1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Cliente = new javax.swing.JDialog();
        PnlCliente1 = new javax.swing.JPanel();
        txtIdCli1 = new javax.swing.JTextField();
        txtEmaCli1 = new javax.swing.JTextField();
        txtDirCli1 = new javax.swing.JTextField();
        lblEmaCli1 = new javax.swing.JLabel();
        lblNomCli1 = new javax.swing.JLabel();
        lblIdCli1 = new javax.swing.JLabel();
        lblApeCli1 = new javax.swing.JLabel();
        lblDirCli1 = new javax.swing.JLabel();
        txtFijoCli1 = new javax.swing.JTextField();
        lblMovCli1 = new javax.swing.JLabel();
        txtMovCli1 = new javax.swing.JTextField();
        lblFijoCli1 = new javax.swing.JLabel();
        txtNomCli1 = new javax.swing.JTextField();
        txtApeCli1 = new javax.swing.JTextField();
        btnSaveCli = new javax.swing.JButton();
        btnDeleteCli = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        btnAgreCli = new javax.swing.JButton();
        btnUpdateCli = new javax.swing.JButton();
        btnMostrarCliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Producto = new javax.swing.JDialog();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        btnSavePro = new javax.swing.JButton();
        btnDeletePro = new javax.swing.JButton();
        btnAgrePro = new javax.swing.JButton();
        btnUpdatePro = new javax.swing.JButton();
        PnlProducto = new javax.swing.JPanel();
        btntipPro = new javax.swing.JButton();
        lblAltPro = new javax.swing.JLabel();
        lblTipPro = new javax.swing.JLabel();
        lblCodPro = new javax.swing.JLabel();
        cboColorPro = new javax.swing.JComboBox<>();
        lbAncPro = new javax.swing.JLabel();
        cboTipPro = new javax.swing.JComboBox<>();
        txtCanPro = new javax.swing.JTextField();
        txtAncPro = new javax.swing.JTextField();
        lblColorPro = new javax.swing.JLabel();
        txtCodPro = new javax.swing.JTextField();
        lblCanPro = new javax.swing.JLabel();
        txtAltPro = new javax.swing.JTextField();
        btnMostrarPro1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        TipoProducto = new javax.swing.JDialog();
        btnSaveTipPro = new javax.swing.JButton();
        btnUpdateTipPro = new javax.swing.JButton();
        btnDeleteTipPro = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblTipPro = new javax.swing.JTable();
        btnMosTipPro = new javax.swing.JButton();
        PnlTipoProducto = new javax.swing.JPanel();
        txtRefTipPro = new javax.swing.JTextField();
        txtDesTipPro = new javax.swing.JTextField();
        txtSisTipPro = new javax.swing.JTextField();
        lbRefTipPro = new javax.swing.JLabel();
        lbDesTipPro = new javax.swing.JLabel();
        lbSisTipPro = new javax.swing.JLabel();
        lbDesTipPro1 = new javax.swing.JLabel();
        txtCodTipPro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Despiece = new javax.swing.JDialog();
        btnSaveDpc = new javax.swing.JButton();
        btnUpdateDpc = new javax.swing.JButton();
        btnDeleteDpc = new javax.swing.JButton();
        btnMostrarDespiece = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbDespiece = new javax.swing.JTable();
        PnlDespiece = new javax.swing.JPanel();
        txtDescDpc = new javax.swing.JTextField();
        txtSisDpc = new javax.swing.JTextField();
        txtRefDpc = new javax.swing.JTextField();
        txtForDpc = new javax.swing.JTextField();
        txtCanDpc = new javax.swing.JTextField();
        txtCodDpc = new javax.swing.JTextField();
        jlbDescDpc = new javax.swing.JLabel();
        LbSisDpc = new javax.swing.JLabel();
        lbRefDpc = new javax.swing.JLabel();
        lbForDpc = new javax.swing.JLabel();
        lbCanDpc = new javax.swing.JLabel();
        lbCodDpc_mat = new javax.swing.JLabel();
        lbcod_dpc = new javax.swing.JLabel();
        txtCodDpc1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        MostrarCotizacion = new javax.swing.JDialog();
        PnlMostrarCot = new javax.swing.JPanel();
        lbFec_cot = new javax.swing.JLabel();
        lbFec_cot1 = new javax.swing.JLabel();
        lbDes_cot1 = new javax.swing.JLabel();
        lbDes_cot = new javax.swing.JLabel();
        lbCod_cot1 = new javax.swing.JLabel();
        lbCod_cot = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblPro_cot = new javax.swing.JTable();
        lbSub_tot_cot1 = new javax.swing.JLabel();
        lbSub_tot_cot = new javax.swing.JLabel();
        lbIva_cot = new javax.swing.JLabel();
        lbIva_cot1 = new javax.swing.JLabel();
        lbTot_cot1 = new javax.swing.JLabel();
        lbTot_cot = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        PnlCli_cot = new javax.swing.JPanel();
        lbId_cli = new javax.swing.JLabel();
        lbId_cli1 = new javax.swing.JLabel();
        lbTel_cli1 = new javax.swing.JLabel();
        lbTel_cli = new javax.swing.JLabel();
        lbApe_cli1 = new javax.swing.JLabel();
        lbNom_cli = new javax.swing.JLabel();
        lbApe_cli = new javax.swing.JLabel();
        lbNom_cli1 = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();
        MostrarDespiece = new javax.swing.JDialog();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblMostrarDespiece = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblPro_Despiece = new javax.swing.JTable();
        btnMostrar_Desp = new javax.swing.JButton();
        btnImprimirDpc = new javax.swing.JButton();
        Cotizaciones = new javax.swing.JDialog();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblCotizaciones = new javax.swing.JTable();
        btnVerCot = new javax.swing.JButton();
        btnActuaCot = new javax.swing.JButton();
        btnVerDes = new javax.swing.JButton();
        lbCotizaciones = new javax.swing.JLabel();
        btnCliente = new javax.swing.JButton();
        btnProducto = new javax.swing.JButton();
        btnIsumos = new javax.swing.JButton();
        btnCotizacion = new javax.swing.JButton();
        PnlCliente = new javax.swing.JPanel();
        txtNomCli = new javax.swing.JTextField();
        txtEmaCli = new javax.swing.JTextField();
        lblEmaCli = new javax.swing.JLabel();
        lblNomCli = new javax.swing.JLabel();
        lblNomCli2 = new javax.swing.JLabel();
        lblNomCli5 = new javax.swing.JLabel();
        txtApeCli = new javax.swing.JTextField();
        lblNomCli10 = new javax.swing.JLabel();
        lblNomCli11 = new javax.swing.JLabel();
        txtFijoCli = new javax.swing.JTextField();
        lblNomCli4 = new javax.swing.JLabel();
        txtIdCli = new javax.swing.JTextField();
        txtDirCli = new javax.swing.JTextField();
        txtMovCli = new javax.swing.JTextField();
        PnlCotizacion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblProductoCotizacion = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblInsumosCotizacion = new javax.swing.JTable();
        lblDesCot = new javax.swing.JLabel();
        txtDesCot = new javax.swing.JTextField();
        btnMostrarInsumos = new javax.swing.JButton();
        BtnQuitarPro = new javax.swing.JButton();
        btnAgregarInsumos = new javax.swing.JButton();
        btnEliminarInsumo1 = new javax.swing.JButton();
        JchIva = new javax.swing.JCheckBox();
        lbicoIva = new javax.swing.JLabel();
        btnCotizar = new javax.swing.JButton();
        btnDespiezar = new javax.swing.JButton();
        btnDespiece = new javax.swing.JButton();
        lbtituloCot = new javax.swing.JLabel();
        lbtituloCli = new javax.swing.JLabel();
        bntAdmi = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        Insumos.setBackground(new java.awt.Color(253, 247, 247));
        Insumos.getContentPane().setLayout(null);

        TblInsumos.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        TblInsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(TblInsumos);

        Insumos.getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(30, 290, 880, 210);

        btnUpdateInsu.setBackground(new java.awt.Color(146, 165, 194));
        btnUpdateInsu.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnUpdateInsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizar.png"))); // NOI18N
        btnUpdateInsu.setText("Actualizar");
        btnUpdateInsu.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnUpdateInsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateInsuActionPerformed(evt);
            }
        });
        Insumos.getContentPane().add(btnUpdateInsu);
        btnUpdateInsu.setBounds(480, 240, 190, 40);

        btnDeleteInsu.setBackground(new java.awt.Color(146, 165, 194));
        btnDeleteInsu.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnDeleteInsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N
        btnDeleteInsu.setText("Eliminar");
        btnDeleteInsu.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnDeleteInsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteInsuActionPerformed(evt);
            }
        });
        Insumos.getContentPane().add(btnDeleteInsu);
        btnDeleteInsu.setBounds(720, 240, 190, 40);

        btnAgreInsu.setBackground(new java.awt.Color(146, 165, 194));
        btnAgreInsu.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnAgreInsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow.png"))); // NOI18N
        btnAgreInsu.setText("Agregar");
        btnAgreInsu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgreInsu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgreInsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgreInsuActionPerformed(evt);
            }
        });
        Insumos.getContentPane().add(btnAgreInsu);
        btnAgreInsu.setBounds(940, 320, 90, 150);

        btnSaveInsu1.setBackground(new java.awt.Color(146, 165, 194));
        btnSaveInsu1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnSaveInsu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar.png"))); // NOI18N
        btnSaveInsu1.setText("Guardar");
        btnSaveInsu1.setDisplayedMnemonicIndex(1);
        btnSaveInsu1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnSaveInsu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveInsu1ActionPerformed(evt);
            }
        });
        Insumos.getContentPane().add(btnSaveInsu1);
        btnSaveInsu1.setBounds(250, 240, 190, 40);

        btnMostrarInsumo.setBackground(new java.awt.Color(146, 165, 194));
        btnMostrarInsumo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnMostrarInsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/caja.png"))); // NOI18N
        btnMostrarInsumo.setText("Mostrar Insumo");
        btnMostrarInsumo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnMostrarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarInsumoActionPerformed(evt);
            }
        });
        Insumos.getContentPane().add(btnMostrarInsumo);
        btnMostrarInsumo.setBounds(30, 240, 180, 40);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));
        Insumos.getContentPane().add(jPanel1);
        jPanel1.setBounds(550, 0, 0, 0);

        PnlInsumos.setBackground(new java.awt.Color(165, 177, 204));
        PnlInsumos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PnlInsumos.setLayout(null);

        txtUsoInsu.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtUsoInsu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsoInsu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        PnlInsumos.add(txtUsoInsu);
        txtUsoInsu.setBounds(82, 62, 120, 30);

        txtCodInsu.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtCodInsu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodInsu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtCodInsu.setEnabled(false);
        PnlInsumos.add(txtCodInsu);
        txtCodInsu.setBounds(82, 22, 80, 30);

        txtDesInsu.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtDesInsu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDesInsu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        PnlInsumos.add(txtDesInsu);
        txtDesInsu.setBounds(262, 22, 290, 30);

        txtReftInsu.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtReftInsu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtReftInsu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        PnlInsumos.add(txtReftInsu);
        txtReftInsu.setBounds(302, 62, 100, 30);

        txtColInsu.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtColInsu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtColInsu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        PnlInsumos.add(txtColInsu);
        txtColInsu.setBounds(452, 62, 100, 30);

        txtCantInsu.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtCantInsu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantInsu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtCantInsu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantInsuKeyTyped(evt);
            }
        });
        PnlInsumos.add(txtCantInsu);
        txtCantInsu.setBounds(82, 102, 80, 30);

        txtFabInsu.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtFabInsu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFabInsu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        PnlInsumos.add(txtFabInsu);
        txtFabInsu.setBounds(642, 62, 210, 30);

        txtTipInsu.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtTipInsu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTipInsu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        PnlInsumos.add(txtTipInsu);
        txtTipInsu.setBounds(642, 22, 210, 30);

        lblCodInsu.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblCodInsu.setText("Codigo:");
        PnlInsumos.add(lblCodInsu);
        lblCodInsu.setBounds(32, 22, 50, 20);

        lblDesInsu1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblDesInsu1.setText("Descripcion:");
        PnlInsumos.add(lblDesInsu1);
        lblDesInsu1.setBounds(172, 22, 100, 20);

        lblTipInsu.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblTipInsu.setText("Tipo:");
        PnlInsumos.add(lblTipInsu);
        lblTipInsu.setBounds(592, 22, 40, 20);

        lblUsoInsu1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblUsoInsu1.setText("Uso:");
        PnlInsumos.add(lblUsoInsu1);
        lblUsoInsu1.setBounds(42, 62, 40, 20);

        lblRefInsu.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblRefInsu.setText("Referencia:");
        PnlInsumos.add(lblRefInsu);
        lblRefInsu.setBounds(222, 62, 70, 20);

        lblColInsu.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblColInsu.setText("Codigo despiece: ");
        PnlInsumos.add(lblColInsu);
        lblColInsu.setBounds(332, 102, 120, 20);

        lblFabInsu1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblFabInsu1.setText("Fabricante:");
        PnlInsumos.add(lblFabInsu1);
        lblFabInsu1.setBounds(562, 62, 70, 20);

        lblCanInsu1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblCanInsu1.setText("Cantidad:");
        PnlInsumos.add(lblCanInsu1);
        lblCanInsu1.setBounds(12, 102, 70, 20);

        lblCanInsu2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblCanInsu2.setText("Precio:");
        PnlInsumos.add(lblCanInsu2);
        lblCanInsu2.setBounds(172, 102, 50, 20);

        txtPreInsu1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtPreInsu1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPreInsu1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtPreInsu1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPreInsu1KeyTyped(evt);
            }
        });
        PnlInsumos.add(txtPreInsu1);
        txtPreInsu1.setBounds(222, 102, 100, 30);

        txtCod_Dpc_mat.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtCod_Dpc_mat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCod_Dpc_mat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCod_Dpc_matKeyTyped(evt);
            }
        });
        PnlInsumos.add(txtCod_Dpc_mat);
        txtCod_Dpc_mat.setBounds(452, 102, 100, 30);

        lblColInsu1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblColInsu1.setText("Color:");
        PnlInsumos.add(lblColInsu1);
        lblColInsu1.setBounds(412, 62, 40, 20);

        Insumos.getContentPane().add(PnlInsumos);
        PnlInsumos.setBounds(30, 50, 880, 180);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel2.setText("Datos de Insumos");
        Insumos.getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 20, 170, 25);

        Cliente.setBackground(new java.awt.Color(253, 247, 247));
        Cliente.getContentPane().setLayout(null);

        PnlCliente1.setBackground(new java.awt.Color(165, 177, 204));
        PnlCliente1.setLayout(null);

        txtIdCli1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtIdCli1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdCli1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtIdCli1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdCli1KeyTyped(evt);
            }
        });
        PnlCliente1.add(txtIdCli1);
        txtIdCli1.setBounds(160, 30, 110, 30);

        txtEmaCli1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtEmaCli1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmaCli1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        PnlCliente1.add(txtEmaCli1);
        txtEmaCli1.setBounds(440, 70, 250, 30);

        txtDirCli1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtDirCli1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDirCli1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        PnlCliente1.add(txtDirCli1);
        txtDirCli1.setBounds(380, 30, 312, 30);

        lblEmaCli1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblEmaCli1.setText("Email:");
        PnlCliente1.add(lblEmaCli1);
        lblEmaCli1.setBounds(390, 80, 50, 20);

        lblNomCli1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblNomCli1.setText("Nombres:");
        PnlCliente1.add(lblNomCli1);
        lblNomCli1.setBounds(80, 80, 60, 20);

        lblIdCli1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblIdCli1.setText("Indentificacion:");
        PnlCliente1.add(lblIdCli1);
        lblIdCli1.setBounds(50, 30, 100, 20);

        lblApeCli1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblApeCli1.setText("Apellidos:");
        PnlCliente1.add(lblApeCli1);
        lblApeCli1.setBounds(80, 120, 90, 20);

        lblDirCli1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblDirCli1.setText("Direccion:");
        PnlCliente1.add(lblDirCli1);
        lblDirCli1.setBounds(300, 40, 70, 20);

        txtFijoCli1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtFijoCli1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFijoCli1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        PnlCliente1.add(txtFijoCli1);
        txtFijoCli1.setBounds(440, 150, 134, 30);

        lblMovCli1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblMovCli1.setText("Movil:");
        PnlCliente1.add(lblMovCli1);
        lblMovCli1.setBounds(390, 120, 45, 20);

        txtMovCli1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtMovCli1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMovCli1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        PnlCliente1.add(txtMovCli1);
        txtMovCli1.setBounds(440, 110, 134, 30);

        lblFijoCli1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblFijoCli1.setText("Fijo:");
        PnlCliente1.add(lblFijoCli1);
        lblFijoCli1.setBounds(390, 150, 26, 20);

        txtNomCli1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        txtNomCli1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PnlCliente1.add(txtNomCli1);
        txtNomCli1.setBounds(160, 70, 210, 30);

        txtApeCli1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        txtApeCli1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PnlCliente1.add(txtApeCli1);
        txtApeCli1.setBounds(160, 110, 210, 30);

        Cliente.getContentPane().add(PnlCliente1);
        PnlCliente1.setBounds(40, 40, 760, 210);

        btnSaveCli.setBackground(new java.awt.Color(146, 165, 194));
        btnSaveCli.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        btnSaveCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar.png"))); // NOI18N
        btnSaveCli.setText("Guardar");
        btnSaveCli.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnSaveCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveCliActionPerformed(evt);
            }
        });
        Cliente.getContentPane().add(btnSaveCli);
        btnSaveCli.setBounds(270, 260, 130, 40);

        btnDeleteCli.setBackground(new java.awt.Color(146, 165, 194));
        btnDeleteCli.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnDeleteCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N
        btnDeleteCli.setText("Eliminar");
        btnDeleteCli.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnDeleteCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCliActionPerformed(evt);
            }
        });
        Cliente.getContentPane().add(btnDeleteCli);
        btnDeleteCli.setBounds(560, 260, 140, 40);

        tblCliente.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tblCliente);

        Cliente.getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(40, 310, 760, 220);

        btnAgreCli.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        btnAgreCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow.png"))); // NOI18N
        btnAgreCli.setText("Agregar");
        btnAgreCli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgreCli.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgreCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgreCliActionPerformed(evt);
            }
        });
        Cliente.getContentPane().add(btnAgreCli);
        btnAgreCli.setBounds(820, 340, 90, 140);

        btnUpdateCli.setBackground(new java.awt.Color(146, 165, 194));
        btnUpdateCli.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnUpdateCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizar.png"))); // NOI18N
        btnUpdateCli.setText("Actualizar");
        btnUpdateCli.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnUpdateCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCliActionPerformed(evt);
            }
        });
        Cliente.getContentPane().add(btnUpdateCli);
        btnUpdateCli.setBounds(410, 260, 140, 40);

        btnMostrarCliente.setBackground(new java.awt.Color(146, 165, 194));
        btnMostrarCliente.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        btnMostrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/caja.png"))); // NOI18N
        btnMostrarCliente.setText("Mostrar Cliente");
        btnMostrarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnMostrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarClienteActionPerformed(evt);
            }
        });
        Cliente.getContentPane().add(btnMostrarCliente);
        btnMostrarCliente.setBounds(100, 260, 160, 40);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel1.setText("Datos del cliente");
        Cliente.getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 10, 150, 25);

        Producto.setBackground(new java.awt.Color(253, 247, 247));
        Producto.setFocusCycleRoot(false);
        Producto.setPreferredSize(new java.awt.Dimension(1011, 522));
        Producto.setResizable(false);
        Producto.getContentPane().setLayout(null);

        tblProducto.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tblProducto);

        Producto.getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(20, 300, 820, 190);

        btnSavePro.setBackground(new java.awt.Color(146, 165, 194));
        btnSavePro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnSavePro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar.png"))); // NOI18N
        btnSavePro.setText("Guardar");
        btnSavePro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnSavePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProActionPerformed(evt);
            }
        });
        Producto.getContentPane().add(btnSavePro);
        btnSavePro.setBounds(250, 250, 170, 40);

        btnDeletePro.setBackground(new java.awt.Color(146, 165, 194));
        btnDeletePro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnDeletePro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N
        btnDeletePro.setText("Eliminar");
        btnDeletePro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnDeletePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProActionPerformed(evt);
            }
        });
        Producto.getContentPane().add(btnDeletePro);
        btnDeletePro.setBounds(680, 250, 160, 40);

        btnAgrePro.setBackground(new java.awt.Color(146, 165, 194));
        btnAgrePro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnAgrePro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow.png"))); // NOI18N
        btnAgrePro.setText("Agregar");
        btnAgrePro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgrePro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgrePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgreProActionPerformed(evt);
            }
        });
        Producto.getContentPane().add(btnAgrePro);
        btnAgrePro.setBounds(890, 300, 120, 190);

        btnUpdatePro.setBackground(new java.awt.Color(146, 165, 194));
        btnUpdatePro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnUpdatePro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizar.png"))); // NOI18N
        btnUpdatePro.setText("Actualizar");
        btnUpdatePro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnUpdatePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProActionPerformed(evt);
            }
        });
        Producto.getContentPane().add(btnUpdatePro);
        btnUpdatePro.setBounds(460, 250, 170, 40);

        PnlProducto.setBackground(new java.awt.Color(165, 177, 204));
        PnlProducto.setLayout(null);

        btntipPro.setBackground(new java.awt.Color(146, 165, 194));
        btntipPro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        btntipPro.setText("Ir a tipo producto");
        btntipPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntipProActionPerformed(evt);
            }
        });
        PnlProducto.add(btntipPro);
        btntipPro.setBounds(530, 120, 180, 40);

        lblAltPro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblAltPro.setText("Alto:");
        PnlProducto.add(lblAltPro);
        lblAltPro.setBounds(340, 80, 40, 20);

        lblTipPro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblTipPro.setText("Tipo:");
        PnlProducto.add(lblTipPro);
        lblTipPro.setBounds(110, 120, 40, 20);

        lblCodPro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblCodPro.setText("Codigo:");
        PnlProducto.add(lblCodPro);
        lblCodPro.setBounds(90, 40, 50, 20);

        cboColorPro.setBackground(new java.awt.Color(146, 165, 194));
        cboColorPro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        cboColorPro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "blanco", "abm", "anoloc" }));
        PnlProducto.add(cboColorPro);
        cboColorPro.setBounds(390, 40, 160, 30);

        lbAncPro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbAncPro.setText("Ancho:");
        PnlProducto.add(lbAncPro);
        lbAncPro.setBounds(100, 80, 50, 20);

        cboTipPro.setBackground(new java.awt.Color(146, 165, 194));
        cboTipPro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        cboTipPro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        PnlProducto.add(cboTipPro);
        cboTipPro.setBounds(150, 120, 330, 30);

        txtCanPro.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtCanPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCanProKeyTyped(evt);
            }
        });
        PnlProducto.add(txtCanPro);
        txtCanPro.setBounds(630, 40, 70, 30);

        txtAncPro.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtAncPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAncProKeyTyped(evt);
            }
        });
        PnlProducto.add(txtAncPro);
        txtAncPro.setBounds(150, 80, 150, 30);

        lblColorPro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblColorPro.setText("Color:");
        PnlProducto.add(lblColorPro);
        lblColorPro.setBounds(340, 40, 50, 20);

        txtCodPro.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtCodPro.setEnabled(false);
        PnlProducto.add(txtCodPro);
        txtCodPro.setBounds(150, 40, 150, 30);

        lblCanPro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblCanPro.setText("Cantidad:");
        PnlProducto.add(lblCanPro);
        lblCanPro.setBounds(560, 40, 60, 20);

        txtAltPro.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtAltPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAltProKeyTyped(evt);
            }
        });
        PnlProducto.add(txtAltPro);
        txtAltPro.setBounds(390, 80, 160, 30);

        Producto.getContentPane().add(PnlProducto);
        PnlProducto.setBounds(20, 50, 820, 190);

        btnMostrarPro1.setBackground(new java.awt.Color(146, 165, 194));
        btnMostrarPro1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        btnMostrarPro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/caja.png"))); // NOI18N
        btnMostrarPro1.setText("Mostrar Producto");
        btnMostrarPro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarPro1ActionPerformed(evt);
            }
        });
        Producto.getContentPane().add(btnMostrarPro1);
        btnMostrarPro1.setBounds(20, 250, 180, 40);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel3.setText("Datos del Producto");
        Producto.getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 10, 180, 30);

        TipoProducto.setBackground(new java.awt.Color(253, 247, 247));
        TipoProducto.setResizable(false);
        TipoProducto.getContentPane().setLayout(null);

        btnSaveTipPro.setBackground(new java.awt.Color(146, 165, 194));
        btnSaveTipPro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnSaveTipPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar.png"))); // NOI18N
        btnSaveTipPro.setText("Guardar");
        btnSaveTipPro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnSaveTipPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveTipProActionPerformed(evt);
            }
        });
        TipoProducto.getContentPane().add(btnSaveTipPro);
        btnSaveTipPro.setBounds(20, 260, 130, 40);

        btnUpdateTipPro.setBackground(new java.awt.Color(146, 165, 194));
        btnUpdateTipPro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnUpdateTipPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizar.png"))); // NOI18N
        btnUpdateTipPro.setText("Actualizar");
        btnUpdateTipPro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnUpdateTipPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTipProActionPerformed(evt);
            }
        });
        TipoProducto.getContentPane().add(btnUpdateTipPro);
        btnUpdateTipPro.setBounds(160, 260, 150, 40);

        btnDeleteTipPro.setBackground(new java.awt.Color(146, 165, 194));
        btnDeleteTipPro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnDeleteTipPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N
        btnDeleteTipPro.setText("Eliminar");
        btnDeleteTipPro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnDeleteTipPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTipProActionPerformed(evt);
            }
        });
        TipoProducto.getContentPane().add(btnDeleteTipPro);
        btnDeleteTipPro.setBounds(320, 260, 150, 40);

        tblTipPro.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        tblTipPro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tblTipPro);

        TipoProducto.getContentPane().add(jScrollPane6);
        jScrollPane6.setBounds(20, 310, 670, 200);

        btnMosTipPro.setBackground(new java.awt.Color(146, 165, 194));
        btnMosTipPro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnMosTipPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/caja.png"))); // NOI18N
        btnMosTipPro.setText("Mostrar Tipo Producto");
        btnMosTipPro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnMosTipPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMosTipProActionPerformed(evt);
            }
        });
        TipoProducto.getContentPane().add(btnMosTipPro);
        btnMosTipPro.setBounds(480, 260, 210, 40);

        PnlTipoProducto.setBackground(new java.awt.Color(165, 177, 204));
        PnlTipoProducto.setLayout(null);

        txtRefTipPro.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        PnlTipoProducto.add(txtRefTipPro);
        txtRefTipPro.setBounds(100, 160, 220, 30);

        txtDesTipPro.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        PnlTipoProducto.add(txtDesTipPro);
        txtDesTipPro.setBounds(100, 60, 280, 30);

        txtSisTipPro.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        PnlTipoProducto.add(txtSisTipPro);
        txtSisTipPro.setBounds(100, 110, 220, 30);

        lbRefTipPro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbRefTipPro.setText("Referencia:");
        PnlTipoProducto.add(lbRefTipPro);
        lbRefTipPro.setBounds(10, 160, 70, 30);

        lbDesTipPro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbDesTipPro.setText("Descripcion:");
        PnlTipoProducto.add(lbDesTipPro);
        lbDesTipPro.setBounds(10, 60, 90, 30);

        lbSisTipPro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbSisTipPro.setText("Sistema:");
        PnlTipoProducto.add(lbSisTipPro);
        lbSisTipPro.setBounds(20, 110, 70, 30);

        lbDesTipPro1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbDesTipPro1.setText("Codigo:");
        PnlTipoProducto.add(lbDesTipPro1);
        lbDesTipPro1.setBounds(30, 10, 70, 30);

        txtCodTipPro.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtCodTipPro.setEnabled(false);
        txtCodTipPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodTipProKeyTyped(evt);
            }
        });
        PnlTipoProducto.add(txtCodTipPro);
        txtCodTipPro.setBounds(100, 10, 220, 30);

        TipoProducto.getContentPane().add(PnlTipoProducto);
        PnlTipoProducto.setBounds(20, 40, 670, 200);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel4.setText("Datos del tipo de producto");
        TipoProducto.getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 0, 250, 30);

        Despiece.setBackground(new java.awt.Color(253, 247, 247));
        Despiece.getContentPane().setLayout(null);

        btnSaveDpc.setBackground(new java.awt.Color(146, 165, 194));
        btnSaveDpc.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnSaveDpc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar.png"))); // NOI18N
        btnSaveDpc.setText("Guardar");
        btnSaveDpc.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnSaveDpc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDpcActionPerformed(evt);
            }
        });
        Despiece.getContentPane().add(btnSaveDpc);
        btnSaveDpc.setBounds(40, 260, 160, 40);

        btnUpdateDpc.setBackground(new java.awt.Color(146, 165, 194));
        btnUpdateDpc.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnUpdateDpc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizar.png"))); // NOI18N
        btnUpdateDpc.setText("Actualizar");
        btnUpdateDpc.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnUpdateDpc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDpcActionPerformed(evt);
            }
        });
        Despiece.getContentPane().add(btnUpdateDpc);
        btnUpdateDpc.setBounds(240, 260, 170, 40);

        btnDeleteDpc.setBackground(new java.awt.Color(146, 165, 194));
        btnDeleteDpc.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnDeleteDpc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N
        btnDeleteDpc.setText("Eliminar");
        btnDeleteDpc.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnDeleteDpc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDpcActionPerformed(evt);
            }
        });
        Despiece.getContentPane().add(btnDeleteDpc);
        btnDeleteDpc.setBounds(440, 260, 180, 40);

        btnMostrarDespiece.setBackground(new java.awt.Color(146, 165, 194));
        btnMostrarDespiece.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnMostrarDespiece.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/caja.png"))); // NOI18N
        btnMostrarDespiece.setText("Mostrar Despiece");
        btnMostrarDespiece.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnMostrarDespiece.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarDespieceActionPerformed(evt);
            }
        });
        Despiece.getContentPane().add(btnMostrarDespiece);
        btnMostrarDespiece.setBounds(650, 260, 180, 40);

        jScrollPane7.setPreferredSize(new java.awt.Dimension(696, 562));

        tbDespiece.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        tbDespiece.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tbDespiece);

        Despiece.getContentPane().add(jScrollPane7);
        jScrollPane7.setBounds(40, 320, 790, 300);

        PnlDespiece.setBackground(new java.awt.Color(165, 177, 204));
        PnlDespiece.setLayout(null);

        txtDescDpc.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        PnlDespiece.add(txtDescDpc);
        txtDescDpc.setBounds(140, 60, 250, 30);

        txtSisDpc.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        PnlDespiece.add(txtSisDpc);
        txtSisDpc.setBounds(140, 100, 210, 30);

        txtRefDpc.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        PnlDespiece.add(txtRefDpc);
        txtRefDpc.setBounds(140, 140, 210, 30);

        txtForDpc.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        PnlDespiece.add(txtForDpc);
        txtForDpc.setBounds(540, 20, 210, 30);

        txtCanDpc.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtCanDpc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCanDpcKeyTyped(evt);
            }
        });
        PnlDespiece.add(txtCanDpc);
        txtCanDpc.setBounds(540, 60, 210, 30);

        txtCodDpc.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtCodDpc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodDpcKeyTyped(evt);
            }
        });
        PnlDespiece.add(txtCodDpc);
        txtCodDpc.setBounds(540, 100, 210, 30);

        jlbDescDpc.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jlbDescDpc.setText("Descripcion:");
        PnlDespiece.add(jlbDescDpc);
        jlbDescDpc.setBounds(30, 60, 100, 30);

        LbSisDpc.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        LbSisDpc.setText("Sistema:");
        PnlDespiece.add(LbSisDpc);
        LbSisDpc.setBounds(50, 100, 80, 30);

        lbRefDpc.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbRefDpc.setText("Referencia:");
        PnlDespiece.add(lbRefDpc);
        lbRefDpc.setBounds(40, 140, 100, 30);

        lbForDpc.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbForDpc.setText("Formula:");
        PnlDespiece.add(lbForDpc);
        lbForDpc.setBounds(450, 20, 80, 30);

        lbCanDpc.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbCanDpc.setText("Cantidad:");
        PnlDespiece.add(lbCanDpc);
        lbCanDpc.setBounds(440, 60, 90, 30);

        lbCodDpc_mat.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbCodDpc_mat.setText("Codigo despizar:");
        PnlDespiece.add(lbCodDpc_mat);
        lbCodDpc_mat.setBounds(420, 100, 110, 30);

        lbcod_dpc.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbcod_dpc.setText("Codigo: ");
        PnlDespiece.add(lbcod_dpc);
        lbcod_dpc.setBounds(50, 20, 80, 30);

        txtCodDpc1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtCodDpc1.setEnabled(false);
        PnlDespiece.add(txtCodDpc1);
        txtCodDpc1.setBounds(140, 20, 250, 30);

        Despiece.getContentPane().add(PnlDespiece);
        PnlDespiece.setBounds(40, 50, 790, 200);

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel5.setText("Datos del Despiece");
        Despiece.getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 15, 190, 30);

        MostrarCotizacion.setBackground(new java.awt.Color(253, 247, 247));
        MostrarCotizacion.getContentPane().setLayout(null);

        PnlMostrarCot.setBackground(new java.awt.Color(165, 177, 204));
        PnlMostrarCot.setLayout(null);

        lbFec_cot.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbFec_cot.setText("Fecha:");
        PnlMostrarCot.add(lbFec_cot);
        lbFec_cot.setBounds(400, 20, 60, 30);

        lbFec_cot1.setBackground(new java.awt.Color(255, 255, 255));
        lbFec_cot1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbFec_cot1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbFec_cot1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PnlMostrarCot.add(lbFec_cot1);
        lbFec_cot1.setBounds(470, 20, 210, 30);

        lbDes_cot1.setBackground(new java.awt.Color(255, 255, 255));
        lbDes_cot1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbDes_cot1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbDes_cot1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PnlMostrarCot.add(lbDes_cot1);
        lbDes_cot1.setBounds(360, 70, 320, 30);

        lbDes_cot.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbDes_cot.setText("Descripcion");
        PnlMostrarCot.add(lbDes_cot);
        lbDes_cot.setBounds(270, 70, 80, 30);

        lbCod_cot1.setBackground(new java.awt.Color(255, 255, 255));
        lbCod_cot1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbCod_cot1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbCod_cot1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PnlMostrarCot.add(lbCod_cot1);
        lbCod_cot1.setBounds(80, 70, 170, 30);

        lbCod_cot.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbCod_cot.setText("Codigo");
        PnlMostrarCot.add(lbCod_cot);
        lbCod_cot.setBounds(30, 70, 60, 30);

        tblPro_cot.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(tblPro_cot);

        PnlMostrarCot.add(jScrollPane9);
        jScrollPane9.setBounds(30, 320, 650, 160);

        lbSub_tot_cot1.setBackground(new java.awt.Color(255, 255, 255));
        lbSub_tot_cot1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lbSub_tot_cot1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSub_tot_cot1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PnlMostrarCot.add(lbSub_tot_cot1);
        lbSub_tot_cot1.setBounds(130, 500, 190, 30);

        lbSub_tot_cot.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lbSub_tot_cot.setText("Subtotal:");
        PnlMostrarCot.add(lbSub_tot_cot);
        lbSub_tot_cot.setBounds(40, 500, 100, 30);

        lbIva_cot.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 22)); // NOI18N
        lbIva_cot.setText("Iva:");
        lbIva_cot.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        PnlMostrarCot.add(lbIva_cot);
        lbIva_cot.setBounds(80, 540, 40, 30);

        lbIva_cot1.setBackground(new java.awt.Color(255, 255, 255));
        lbIva_cot1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lbIva_cot1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbIva_cot1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PnlMostrarCot.add(lbIva_cot1);
        lbIva_cot1.setBounds(130, 540, 190, 30);

        lbTot_cot1.setBackground(new java.awt.Color(255, 255, 255));
        lbTot_cot1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lbTot_cot1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTot_cot1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PnlMostrarCot.add(lbTot_cot1);
        lbTot_cot1.setBounds(130, 580, 190, 30);

        lbTot_cot.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        lbTot_cot.setText("Total:");
        PnlMostrarCot.add(lbTot_cot);
        lbTot_cot.setBounds(50, 580, 70, 30);

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel13.setText("Productos:");
        PnlMostrarCot.add(jLabel13);
        jLabel13.setBounds(30, 290, 100, 20);

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel24.setText("Cliente: ");
        PnlMostrarCot.add(jLabel24);
        jLabel24.setBounds(30, 110, 70, 30);

        PnlCli_cot.setBackground(new java.awt.Color(253, 247, 247));
        PnlCli_cot.setLayout(null);

        lbId_cli.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbId_cli.setText("Identificacion:");
        PnlCli_cot.add(lbId_cli);
        lbId_cli.setBounds(20, 20, 90, 30);

        lbId_cli1.setBackground(new java.awt.Color(255, 255, 255));
        lbId_cli1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbId_cli1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbId_cli1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PnlCli_cot.add(lbId_cli1);
        lbId_cli1.setBounds(120, 20, 500, 30);

        lbTel_cli1.setBackground(new java.awt.Color(255, 255, 255));
        lbTel_cli1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbTel_cli1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTel_cli1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PnlCli_cot.add(lbTel_cli1);
        lbTel_cli1.setBounds(120, 100, 250, 30);

        lbTel_cli.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbTel_cli.setText("Telefono:");
        PnlCli_cot.add(lbTel_cli);
        lbTel_cli.setBounds(50, 100, 60, 30);

        lbApe_cli1.setBackground(new java.awt.Color(255, 255, 255));
        lbApe_cli1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbApe_cli1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbApe_cli1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PnlCli_cot.add(lbApe_cli1);
        lbApe_cli1.setBounds(420, 60, 200, 30);

        lbNom_cli.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbNom_cli.setText("Nombre: ");
        PnlCli_cot.add(lbNom_cli);
        lbNom_cli.setBounds(50, 60, 60, 30);

        lbApe_cli.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbApe_cli.setText("Apellido:");
        PnlCli_cot.add(lbApe_cli);
        lbApe_cli.setBounds(350, 60, 55, 30);

        lbNom_cli1.setBackground(new java.awt.Color(255, 255, 255));
        lbNom_cli1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbNom_cli1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNom_cli1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PnlCli_cot.add(lbNom_cli1);
        lbNom_cli1.setBounds(120, 60, 220, 30);

        PnlMostrarCot.add(PnlCli_cot);
        PnlCli_cot.setBounds(30, 140, 650, 150);

        btnImprimir.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imprimir.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setIconTextGap(6);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        PnlMostrarCot.add(btnImprimir);
        btnImprimir.setBounds(530, 550, 140, 50);

        MostrarCotizacion.getContentPane().add(PnlMostrarCot);
        PnlMostrarCot.setBounds(30, 20, 720, 630);

        MostrarDespiece.setBackground(new java.awt.Color(253, 247, 247));
        MostrarDespiece.setPreferredSize(new java.awt.Dimension(912, 610));
        MostrarDespiece.setResizable(false);
        MostrarDespiece.getContentPane().setLayout(null);

        tblMostrarDespiece.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblMostrarDespiece.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane10.setViewportView(tblMostrarDespiece);

        MostrarDespiece.getContentPane().add(jScrollPane10);
        jScrollPane10.setBounds(140, 240, 720, 240);

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel22.setText("Productos");
        MostrarDespiece.getContentPane().add(jLabel22);
        jLabel22.setBounds(40, 20, 90, 25);

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel23.setText("Despieces");
        MostrarDespiece.getContentPane().add(jLabel23);
        jLabel23.setBounds(40, 190, 90, 25);

        tblPro_Despiece.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblPro_Despiece.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane11.setViewportView(tblPro_Despiece);

        MostrarDespiece.getContentPane().add(jScrollPane11);
        jScrollPane11.setBounds(140, 20, 720, 160);

        btnMostrar_Desp.setBackground(new java.awt.Color(146, 165, 194));
        btnMostrar_Desp.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnMostrar_Desp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/caja.png"))); // NOI18N
        btnMostrar_Desp.setText("Mostrar");
        btnMostrar_Desp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrar_DespActionPerformed(evt);
            }
        });
        MostrarDespiece.getContentPane().add(btnMostrar_Desp);
        btnMostrar_Desp.setBounds(650, 190, 210, 40);

        btnImprimirDpc.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnImprimirDpc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imprimir.png"))); // NOI18N
        btnImprimirDpc.setText("Imprimir");
        btnImprimirDpc.setIconTextGap(6);
        btnImprimirDpc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirDpcActionPerformed(evt);
            }
        });
        MostrarDespiece.getContentPane().add(btnImprimirDpc);
        btnImprimirDpc.setBounds(690, 500, 170, 60);

        Cotizaciones.setBackground(new java.awt.Color(253, 247, 247));
        Cotizaciones.setResizable(false);
        Cotizaciones.getContentPane().setLayout(null);

        tblCotizaciones.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        tblCotizaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(tblCotizaciones);

        Cotizaciones.getContentPane().add(jScrollPane8);
        jScrollPane8.setBounds(50, 70, 1050, 410);

        btnVerCot.setBackground(new java.awt.Color(146, 165, 194));
        btnVerCot.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnVerCot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/caja.png"))); // NOI18N
        btnVerCot.setText("Ver cotizacion");
        btnVerCot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerCotActionPerformed(evt);
            }
        });
        Cotizaciones.getContentPane().add(btnVerCot);
        btnVerCot.setBounds(430, 530, 160, 40);

        btnActuaCot.setBackground(new java.awt.Color(146, 165, 194));
        btnActuaCot.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnActuaCot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizar.png"))); // NOI18N
        btnActuaCot.setText("Actualizar");
        btnActuaCot.setIconTextGap(5);
        btnActuaCot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActuaCotActionPerformed(evt);
            }
        });
        Cotizaciones.getContentPane().add(btnActuaCot);
        btnActuaCot.setBounds(50, 530, 160, 40);

        btnVerDes.setBackground(new java.awt.Color(146, 165, 194));
        btnVerDes.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnVerDes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/binoculares.png"))); // NOI18N
        btnVerDes.setText("Despiezar");
        btnVerDes.setIconTextGap(6);
        btnVerDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDesActionPerformed(evt);
            }
        });
        Cotizaciones.getContentPane().add(btnVerDes);
        btnVerDes.setBounds(240, 530, 150, 40);

        lbCotizaciones.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lbCotizaciones.setText("Cotizaciones");
        Cotizaciones.getContentPane().add(lbCotizaciones);
        lbCotizaciones.setBounds(50, 30, 120, 30);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(253, 247, 247));
        setPreferredSize(new java.awt.Dimension(1201, 720));
        getContentPane().setLayout(null);

        btnCliente.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cliente1.png"))); // NOI18N
        btnCliente.setText("Cliente");
        btnCliente.setBorder(null);
        btnCliente.setBorderPainted(false);
        btnCliente.setContentAreaFilled(false);
        btnCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCliente.setIconTextGap(-3);
        btnCliente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cliente2.png"))); // NOI18N
        btnCliente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cliente3.png"))); // NOI18N
        btnCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnCliente);
        btnCliente.setBounds(670, 40, 90, 90);

        btnProducto.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/producto1.png"))); // NOI18N
        btnProducto.setText("Producto");
        btnProducto.setBorder(null);
        btnProducto.setBorderPainted(false);
        btnProducto.setContentAreaFilled(false);
        btnProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProducto.setIconTextGap(-3);
        btnProducto.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/producto2.png"))); // NOI18N
        btnProducto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/producto3.png"))); // NOI18N
        btnProducto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoActionPerformed(evt);
            }
        });
        getContentPane().add(btnProducto);
        btnProducto.setBounds(800, 40, 100, 90);

        btnIsumos.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnIsumos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/insumo1.png"))); // NOI18N
        btnIsumos.setText("Insumo");
        btnIsumos.setBorder(null);
        btnIsumos.setBorderPainted(false);
        btnIsumos.setContentAreaFilled(false);
        btnIsumos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIsumos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIsumos.setIconTextGap(-3);
        btnIsumos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/insumo2.png"))); // NOI18N
        btnIsumos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/insumo3.png"))); // NOI18N
        btnIsumos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnIsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIsumosActionPerformed(evt);
            }
        });
        getContentPane().add(btnIsumos);
        btnIsumos.setBounds(940, 40, 100, 90);

        btnCotizacion.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnCotizacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cotizacion1.png"))); // NOI18N
        btnCotizacion.setText("Cotizacion");
        btnCotizacion.setBorder(null);
        btnCotizacion.setBorderPainted(false);
        btnCotizacion.setContentAreaFilled(false);
        btnCotizacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCotizacion.setIconTextGap(-3);
        btnCotizacion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cotizacion2.png"))); // NOI18N
        btnCotizacion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cotizacion3.png"))); // NOI18N
        btnCotizacion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCotizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCotizacionActionPerformed(evt);
            }
        });
        getContentPane().add(btnCotizacion);
        btnCotizacion.setBounds(800, 140, 100, 90);

        PnlCliente.setBackground(new java.awt.Color(165, 177, 204));
        PnlCliente.setLayout(null);

        txtNomCli.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtNomCli.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNomCli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        PnlCliente.add(txtNomCli);
        txtNomCli.setBounds(110, 60, 210, 30);

        txtEmaCli.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtEmaCli.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmaCli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        PnlCliente.add(txtEmaCli);
        txtEmaCli.setBounds(390, 60, 222, 30);

        lblEmaCli.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        lblEmaCli.setText("Email:");
        PnlCliente.add(lblEmaCli);
        lblEmaCli.setBounds(330, 60, 35, 20);

        lblNomCli.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        lblNomCli.setText("Nombre:");
        PnlCliente.add(lblNomCli);
        lblNomCli.setBounds(40, 60, 60, 20);

        lblNomCli2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        lblNomCli2.setText("Indentificacion:");
        PnlCliente.add(lblNomCli2);
        lblNomCli2.setBounds(10, 20, 100, 20);

        lblNomCli5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        lblNomCli5.setText("Movil:");
        PnlCliente.add(lblNomCli5);
        lblNomCli5.setBounds(330, 110, 38, 20);

        txtApeCli.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtApeCli.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApeCli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        PnlCliente.add(txtApeCli);
        txtApeCli.setBounds(110, 100, 210, 30);

        lblNomCli10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        lblNomCli10.setText("Direccion:");
        PnlCliente.add(lblNomCli10);
        lblNomCli10.setBounds(240, 20, 70, 20);

        lblNomCli11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        lblNomCli11.setText("Fijo:");
        PnlCliente.add(lblNomCli11);
        lblNomCli11.setBounds(70, 140, 35, 20);

        txtFijoCli.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtFijoCli.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFijoCli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        PnlCliente.add(txtFijoCli);
        txtFijoCli.setBounds(110, 140, 143, 30);

        lblNomCli4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        lblNomCli4.setText("Apellidos:");
        PnlCliente.add(lblNomCli4);
        lblNomCli4.setBounds(40, 103, 68, 20);

        txtIdCli.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtIdCli.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdCli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        PnlCliente.add(txtIdCli);
        txtIdCli.setBounds(110, 20, 120, 30);

        txtDirCli.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtDirCli.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDirCli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        PnlCliente.add(txtDirCli);
        txtDirCli.setBounds(320, 20, 300, 30);

        txtMovCli.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtMovCli.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMovCli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        PnlCliente.add(txtMovCli);
        txtMovCli.setBounds(390, 100, 143, 30);

        getContentPane().add(PnlCliente);
        PnlCliente.setBounds(20, 40, 640, 180);

        PnlCotizacion.setBackground(new java.awt.Color(165, 177, 204));
        PnlCotizacion.setLayout(null);

        TblProductoCotizacion.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        TblProductoCotizacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TblProductoCotizacion);

        PnlCotizacion.add(jScrollPane1);
        jScrollPane1.setBounds(30, 70, 780, 120);

        tblInsumosCotizacion.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        tblInsumosCotizacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblInsumosCotizacion);

        PnlCotizacion.add(jScrollPane2);
        jScrollPane2.setBounds(30, 210, 780, 190);

        lblDesCot.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        lblDesCot.setText("Descripcion:");
        PnlCotizacion.add(lblDesCot);
        lblDesCot.setBounds(40, 20, 90, 30);

        txtDesCot.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        txtDesCot.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDesCot.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        PnlCotizacion.add(txtDesCot);
        txtDesCot.setBounds(120, 20, 395, 30);

        btnMostrarInsumos.setBackground(new java.awt.Color(146, 165, 194));
        btnMostrarInsumos.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnMostrarInsumos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/caja.png"))); // NOI18N
        btnMostrarInsumos.setText("Mostrar Insumos");
        btnMostrarInsumos.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnMostrarInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarInsumosActionPerformed(evt);
            }
        });
        PnlCotizacion.add(btnMostrarInsumos);
        btnMostrarInsumos.setBounds(850, 350, 210, 50);

        BtnQuitarPro.setBackground(new java.awt.Color(146, 165, 194));
        BtnQuitarPro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        BtnQuitarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/quitar.png"))); // NOI18N
        BtnQuitarPro.setText("Quitar Producto");
        BtnQuitarPro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        BtnQuitarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnQuitarProActionPerformed(evt);
            }
        });
        PnlCotizacion.add(BtnQuitarPro);
        BtnQuitarPro.setBounds(660, 20, 150, 40);

        btnAgregarInsumos.setBackground(new java.awt.Color(146, 165, 194));
        btnAgregarInsumos.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnAgregarInsumos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar.png"))); // NOI18N
        btnAgregarInsumos.setText("Agregar Insumo Adicional");
        btnAgregarInsumos.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnAgregarInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarInsumosActionPerformed(evt);
            }
        });
        PnlCotizacion.add(btnAgregarInsumos);
        btnAgregarInsumos.setBounds(850, 280, 210, 50);

        btnEliminarInsumo1.setBackground(new java.awt.Color(146, 165, 194));
        btnEliminarInsumo1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnEliminarInsumo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/quitar.png"))); // NOI18N
        btnEliminarInsumo1.setText("Quitar Insumos");
        btnEliminarInsumo1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnEliminarInsumo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarInsumo1ActionPerformed(evt);
            }
        });
        PnlCotizacion.add(btnEliminarInsumo1);
        btnEliminarInsumo1.setBounds(850, 210, 210, 50);

        JchIva.setBackground(new java.awt.Color(204, 204, 204));
        JchIva.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        JchIva.setText("Agregar iva");
        JchIva.setContentAreaFilled(false);
        JchIva.setFocusPainted(false);
        JchIva.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        JchIva.setPreferredSize(new java.awt.Dimension(100, 100));
        PnlCotizacion.add(JchIva);
        JchIva.setBounds(520, 20, 110, 30);

        lbicoIva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbicoIva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iva.png"))); // NOI18N
        PnlCotizacion.add(lbicoIva);
        lbicoIva.setBounds(620, 20, 30, 30);

        btnCotizar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        btnCotizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cotizar.png"))); // NOI18N
        btnCotizar.setText("Cotizar");
        btnCotizar.setBorder(null);
        btnCotizar.setBorderPainted(false);
        btnCotizar.setContentAreaFilled(false);
        btnCotizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCotizar.setIconTextGap(-2);
        btnCotizar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cotizar2.png"))); // NOI18N
        btnCotizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCotizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCotizarActionPerformed(evt);
            }
        });
        PnlCotizacion.add(btnCotizar);
        btnCotizar.setBounds(830, 20, 140, 160);

        btnDespiezar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        btnDespiezar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/despiezar.png"))); // NOI18N
        btnDespiezar.setText("Despiezar");
        btnDespiezar.setBorder(null);
        btnDespiezar.setBorderPainted(false);
        btnDespiezar.setContentAreaFilled(false);
        btnDespiezar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDespiezar.setIconTextGap(-2);
        btnDespiezar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/despiezar2.png"))); // NOI18N
        btnDespiezar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDespiezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDespiezarActionPerformed(evt);
            }
        });
        PnlCotizacion.add(btnDespiezar);
        btnDespiezar.setBounds(960, 20, 130, 160);

        getContentPane().add(PnlCotizacion);
        PnlCotizacion.setBounds(20, 250, 1120, 420);

        btnDespiece.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnDespiece.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/despiece1.png"))); // NOI18N
        btnDespiece.setText("Despiece");
        btnDespiece.setBorder(null);
        btnDespiece.setBorderPainted(false);
        btnDespiece.setContentAreaFilled(false);
        btnDespiece.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDespiece.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDespiece.setIconTextGap(-3);
        btnDespiece.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/despiece2.png"))); // NOI18N
        btnDespiece.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/despiece3.png"))); // NOI18N
        btnDespiece.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDespiece.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDespieceActionPerformed(evt);
            }
        });
        getContentPane().add(btnDespiece);
        btnDespiece.setBounds(670, 140, 100, 90);

        lbtituloCot.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lbtituloCot.setText("Datos de la Cotizacion");
        getContentPane().add(lbtituloCot);
        lbtituloCot.setBounds(20, 220, 200, 25);

        lbtituloCli.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lbtituloCli.setText("Datos del cliente");
        getContentPane().add(lbtituloCli);
        lbtituloCli.setBounds(20, 10, 140, 25);

        bntAdmi.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        bntAdmi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/administrador-web2.png"))); // NOI18N
        bntAdmi.setText("Administrador");
        bntAdmi.setBorderPainted(false);
        bntAdmi.setContentAreaFilled(false);
        bntAdmi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bntAdmi.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/administrador-web3.png"))); // NOI18N
        bntAdmi.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/administrador-web1.png"))); // NOI18N
        bntAdmi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bntAdmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAdmiActionPerformed(evt);
            }
        });
        getContentPane().add(bntAdmi);
        bntAdmi.setBounds(930, 140, 130, 80);

        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar-sesion2.png"))); // NOI18N
        jButton1.setText("cerrar sesion");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setIconTextGap(-3);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar-sesion3.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar-sesion1.png"))); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1070, 20, 120, 90);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnQuitarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnQuitarProActionPerformed
        JEliminarfilaProductoCot();
    }//GEN-LAST:event_BtnQuitarProActionPerformed

    private void btnMostrarInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarInsumosActionPerformed
        JCrearTablaInsumosCotizacion();
        JLlenarTablaInsumosCotizacion();
    }//GEN-LAST:event_btnMostrarInsumosActionPerformed

    private void btnIsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIsumosActionPerformed
      Insumos.setBounds(0, 0, 1077, 580);
        Insumos.setVisible(true);
    }//GEN-LAST:event_btnIsumosActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        Cliente.setBounds(0, 0, 963, 591);
        Cliente.setVisible(true);
    
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed
        Producto.setBounds(0, 0, 1033, 542);
        Producto.setVisible(true);
    }//GEN-LAST:event_btnProductoActionPerformed

    private void btnAgreInsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgreInsuActionPerformed
        JAgregarInsumo();
        Insumos.dispose();
    }//GEN-LAST:event_btnAgreInsuActionPerformed

    private void btnAgreCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgreCliActionPerformed
        JAgregarCliente();
        Cliente.dispose();
    }//GEN-LAST:event_btnAgreCliActionPerformed

    private void btnAgreProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgreProActionPerformed
        JAgregarProducto();
        JCrearTablaProducto();
        Producto.dispose();
    }//GEN-LAST:event_btnAgreProActionPerformed

    private void btnSaveCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveCliActionPerformed
       JGuardarCliente();
       JCrearTablaCliente();
       JLlenartablaCliente();
       JLimpiarFormulario(PnlCliente1);
    }//GEN-LAST:event_btnSaveCliActionPerformed

    private void btnDeleteCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCliActionPerformed
      JEliminarCliente();
      JCrearTablaCliente();
      JLlenartablaCliente();
      JLimpiarFormulario(PnlCliente1);
    }//GEN-LAST:event_btnDeleteCliActionPerformed

    private void btnUpdateInsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateInsuActionPerformed
       JActualizarInsumos();
       JLimpiarFormulario(PnlInsumos);
       JCrearTablaInsumos();
       JLlenarTablaInsumos();
    }//GEN-LAST:event_btnUpdateInsuActionPerformed

    private void btnDeleteInsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteInsuActionPerformed
        JEliminarInsumos();
        JLimpiarFormulario(PnlInsumos);
        JCrearTablaInsumos();
        JLlenarTablaInsumos();
    }//GEN-LAST:event_btnDeleteInsuActionPerformed

    private void btnSaveInsu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveInsu1ActionPerformed
        JGuardarInsumos();
        JLimpiarFormulario(PnlInsumos);
       JCrearTablaInsumos();
       JLlenarTablaInsumos();
    }//GEN-LAST:event_btnSaveInsu1ActionPerformed

    private void btnUpdateCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCliActionPerformed
        JActualizarCliente();
        JCrearTablaCliente();
        JLlenartablaCliente();
        JLimpiarFormulario(PnlCliente1);
    }//GEN-LAST:event_btnUpdateCliActionPerformed

    private void btnSaveProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProActionPerformed
        JGuardarproducto();
        JLimpiarFormulario(PnlProducto);
       
       
    }//GEN-LAST:event_btnSaveProActionPerformed

    private void btnUpdateProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProActionPerformed
        JActualizarProducto();
        JLimpiarFormulario(PnlProducto);
       
    }//GEN-LAST:event_btnUpdateProActionPerformed

    private void btnDeleteProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProActionPerformed
       JEliminarProducto();
       JLimpiarFormulario(PnlProducto);
       
    }//GEN-LAST:event_btnDeleteProActionPerformed

    private void btntipProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntipProActionPerformed
        TipoProducto.setBounds(0,0,714, 555);
        TipoProducto.setVisible(true);
    }//GEN-LAST:event_btntipProActionPerformed

    private void btnMostrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarClienteActionPerformed
        JMostrarCliente();
    }//GEN-LAST:event_btnMostrarClienteActionPerformed

    private void btnMostrarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarInsumoActionPerformed
        JMostrarInsumo();
    }//GEN-LAST:event_btnMostrarInsumoActionPerformed

    private void txtCantInsuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantInsuKeyTyped
        soloDigitos(evt);
    }//GEN-LAST:event_txtCantInsuKeyTyped

    private void txtPreInsu1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPreInsu1KeyTyped
        soloDigitos(evt);
    }//GEN-LAST:event_txtPreInsu1KeyTyped

    private void txtAncProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAncProKeyTyped
        soloDigitos(evt);
    }//GEN-LAST:event_txtAncProKeyTyped

    private void txtAltProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAltProKeyTyped
        soloDigitos(evt);
    }//GEN-LAST:event_txtAltProKeyTyped

    private void txtCanProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCanProKeyTyped
        soloDigitos(evt);
    }//GEN-LAST:event_txtCanProKeyTyped

    private void btnAgregarInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarInsumosActionPerformed
        Insumos.setBounds(0, 0, 1077, 580);
        Insumos.setVisible(true);
    }//GEN-LAST:event_btnAgregarInsumosActionPerformed

    private void btnSaveTipProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveTipProActionPerformed
        JGuardarTipProducto();
        JCargarComboTipoPorducto();
        JLimpiarFormulario(PnlTipoProducto);
        JCreartablaTipProducto();
        JLlenarTablaTipProducto();
    }//GEN-LAST:event_btnSaveTipProActionPerformed

    private void btnUpdateTipProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTipProActionPerformed
        JActualizarTipProducto();
        JCargarComboTipoPorducto();
        JLimpiarFormulario(PnlTipoProducto);
        JCreartablaTipProducto();
        JLlenarTablaTipProducto();
    }//GEN-LAST:event_btnUpdateTipProActionPerformed

    private void btnDeleteTipProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTipProActionPerformed
        JEliminarTipProducto();
        JCargarComboTipoPorducto();
        JLimpiarFormulario(PnlTipoProducto);
        JCreartablaTipProducto();
        JLlenarTablaTipProducto();
    }//GEN-LAST:event_btnDeleteTipProActionPerformed

    private void btnMostrarPro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarPro1ActionPerformed
     JMostrarProducto();
    }//GEN-LAST:event_btnMostrarPro1ActionPerformed

    private void btnMosTipProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMosTipProActionPerformed
        JMostrarTipProducto();
    }//GEN-LAST:event_btnMosTipProActionPerformed

    private void btnEliminarInsumo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarInsumo1ActionPerformed
       JEliminarfilaInsumos();
    }//GEN-LAST:event_btnEliminarInsumo1ActionPerformed

    private void btnDespiezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDespiezarActionPerformed
       Cotizaciones.setBounds(0, 0, 1167, 648);
       Cotizaciones.setVisible(true);
      
    }//GEN-LAST:event_btnDespiezarActionPerformed

    private void btnCotizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCotizarActionPerformed
    JCrearCotizacion();
    
   
    }//GEN-LAST:event_btnCotizarActionPerformed

    private void btnSaveDpcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDpcActionPerformed
       JGuardarDespiece();
        JLimpiarFormulario(PnlDespiece);
        JCrearTablaDespiece();
        JLlenartablaDespiece();
    }//GEN-LAST:event_btnSaveDpcActionPerformed

    private void btnUpdateDpcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDpcActionPerformed
  JActualizarDespiece();
   JLimpiarFormulario(PnlDespiece);
   JCrearTablaDespiece();
   JLlenartablaDespiece();
    }//GEN-LAST:event_btnUpdateDpcActionPerformed

    private void btnDeleteDpcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDpcActionPerformed
        JEliminarDespiece();
        JLimpiarFormulario(PnlDespiece);
        JCrearTablaDespiece();
         JLlenartablaDespiece();
    }//GEN-LAST:event_btnDeleteDpcActionPerformed

    private void btnDespieceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDespieceActionPerformed
       Despiece.setBounds(0,0, 896, 700);
        Despiece.setVisible(true);
    }//GEN-LAST:event_btnDespieceActionPerformed

    private void btnMostrarDespieceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarDespieceActionPerformed
        JVerDespiece();
    }//GEN-LAST:event_btnMostrarDespieceActionPerformed

    private void txtCanDpcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCanDpcKeyTyped
        soloDigitos(evt);
    }//GEN-LAST:event_txtCanDpcKeyTyped

    private void txtCodDpcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodDpcKeyTyped
        soloDigitos(evt);
        
    }//GEN-LAST:event_txtCodDpcKeyTyped

    private void txtIdCli1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdCli1KeyTyped
        soloDigitos(evt);
    }//GEN-LAST:event_txtIdCli1KeyTyped

    private void txtCod_Dpc_matKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_Dpc_matKeyTyped
        soloDigitos(evt);
    }//GEN-LAST:event_txtCod_Dpc_matKeyTyped

    private void txtCodTipProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodTipProKeyTyped
        soloDigitos(evt);
    }//GEN-LAST:event_txtCodTipProKeyTyped

    private void btnCotizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCotizacionActionPerformed
        Cotizaciones.setBounds(0, 0, 1167, 648);
        Cotizaciones.setVisible(true);
       
    }//GEN-LAST:event_btnCotizacionActionPerformed

    private void btnMostrar_DespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrar_DespActionPerformed
        try {
            int fila;
             fila = tblPro_Despiece.getSelectedRow();
          if(fila ==-1){
              JOptionPane.showMessageDialog(null, "Seleccione un producto de la tabla");
          }
          else{
          JCrearTablaDespieces();
          //Llenar Tabla despiece en JDialog MostrarDespiece
          String cod_pro = tblPro_Despiece.getValueAt(fila,0).toString();
          cot.MtdConsultarProducto_despiece(Integer.parseInt(cod_pro));
          String [] datos2 = new String[4];
          while(cot.datoscot.next()){
              for(int i = 0; i<4;i++){
                  datos2[i] = cot.datoscot.getString(i+1);
              }
              dp.addRow(datos2);
          }
          
          }
        } catch (Exception e) {
            System.out.println("Error al llenar tabla despiece  en JDialog Cotizacion: " +e.getLocalizedMessage());
        }
 
        
    }//GEN-LAST:event_btnMostrar_DespActionPerformed

    private void btnActuaCotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActuaCotActionPerformed
        JCrearTablaCotizacion();
        JLlenarTablaCotizacion();
    }//GEN-LAST:event_btnActuaCotActionPerformed

    private void btnVerDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDesActionPerformed
        JDespiezar();
    }//GEN-LAST:event_btnVerDesActionPerformed

    private void btnVerCotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerCotActionPerformed
        JVisualizarCotizacion();
    }//GEN-LAST:event_btnVerCotActionPerformed

    private void bntAdmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAdmiActionPerformed
       lg.JAbrirAdministrador();
    }//GEN-LAST:event_bntAdmiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    JLimpiarFormulario(PnlCliente);
    JLimpiarFormulario(PnlCotizacion);
    JCrearTablaProductoCotizacion();
    JCrearTablaInsumosCotizacion();
        this.dispose();
        lg.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
      JGenerarReporte();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnImprimirDpcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirDpcActionPerformed
    JGenerarReporteDespiece();
    }//GEN-LAST:event_btnImprimirDpcActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCotizacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnQuitarPro;
    private javax.swing.JDialog Cliente;
    private javax.swing.JDialog Cotizaciones;
    private javax.swing.JDialog Despiece;
    private javax.swing.JDialog Insumos;
    private javax.swing.JCheckBox JchIva;
    private javax.swing.JLabel LbSisDpc;
    private javax.swing.JDialog MostrarCotizacion;
    private javax.swing.JDialog MostrarDespiece;
    private javax.swing.JPanel PnlCli_cot;
    private javax.swing.JPanel PnlCliente;
    private javax.swing.JPanel PnlCliente1;
    private javax.swing.JPanel PnlCotizacion;
    private javax.swing.JPanel PnlDespiece;
    private javax.swing.JPanel PnlInsumos;
    private javax.swing.JPanel PnlMostrarCot;
    private javax.swing.JPanel PnlProducto;
    private javax.swing.JPanel PnlTipoProducto;
    private javax.swing.JDialog Producto;
    private javax.swing.JTable TblInsumos;
    private javax.swing.JTable TblProductoCotizacion;
    private javax.swing.JDialog TipoProducto;
    private javax.swing.JButton bntAdmi;
    private javax.swing.JButton btnActuaCot;
    private javax.swing.JButton btnAgreCli;
    private javax.swing.JButton btnAgreInsu;
    private javax.swing.JButton btnAgrePro;
    private javax.swing.JButton btnAgregarInsumos;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnCotizacion;
    private javax.swing.JButton btnCotizar;
    private javax.swing.JButton btnDeleteCli;
    private javax.swing.JButton btnDeleteDpc;
    private javax.swing.JButton btnDeleteInsu;
    private javax.swing.JButton btnDeletePro;
    private javax.swing.JButton btnDeleteTipPro;
    private javax.swing.JButton btnDespiece;
    private javax.swing.JButton btnDespiezar;
    private javax.swing.JButton btnEliminarInsumo1;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnImprimirDpc;
    private javax.swing.JButton btnIsumos;
    private javax.swing.JButton btnMosTipPro;
    private javax.swing.JButton btnMostrarCliente;
    private javax.swing.JButton btnMostrarDespiece;
    private javax.swing.JButton btnMostrarInsumo;
    private javax.swing.JButton btnMostrarInsumos;
    private javax.swing.JButton btnMostrarPro1;
    private javax.swing.JButton btnMostrar_Desp;
    private javax.swing.JButton btnProducto;
    private javax.swing.JButton btnSaveCli;
    private javax.swing.JButton btnSaveDpc;
    private javax.swing.JButton btnSaveInsu1;
    private javax.swing.JButton btnSavePro;
    private javax.swing.JButton btnSaveTipPro;
    private javax.swing.JButton btnUpdateCli;
    private javax.swing.JButton btnUpdateDpc;
    private javax.swing.JButton btnUpdateInsu;
    private javax.swing.JButton btnUpdatePro;
    private javax.swing.JButton btnUpdateTipPro;
    private javax.swing.JButton btnVerCot;
    private javax.swing.JButton btnVerDes;
    private javax.swing.JButton btntipPro;
    private javax.swing.JComboBox<String> cboColorPro;
    private javax.swing.JComboBox<String> cboTipPro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel jlbDescDpc;
    private javax.swing.JLabel lbAncPro;
    private javax.swing.JLabel lbApe_cli;
    private javax.swing.JLabel lbApe_cli1;
    private javax.swing.JLabel lbCanDpc;
    private javax.swing.JLabel lbCodDpc_mat;
    private javax.swing.JLabel lbCod_cot;
    private javax.swing.JLabel lbCod_cot1;
    private javax.swing.JLabel lbCotizaciones;
    private javax.swing.JLabel lbDesTipPro;
    private javax.swing.JLabel lbDesTipPro1;
    private javax.swing.JLabel lbDes_cot;
    private javax.swing.JLabel lbDes_cot1;
    private javax.swing.JLabel lbFec_cot;
    private javax.swing.JLabel lbFec_cot1;
    private javax.swing.JLabel lbForDpc;
    private javax.swing.JLabel lbId_cli;
    private javax.swing.JLabel lbId_cli1;
    private javax.swing.JLabel lbIva_cot;
    private javax.swing.JLabel lbIva_cot1;
    private javax.swing.JLabel lbNom_cli;
    private javax.swing.JLabel lbNom_cli1;
    private javax.swing.JLabel lbRefDpc;
    private javax.swing.JLabel lbRefTipPro;
    private javax.swing.JLabel lbSisTipPro;
    private javax.swing.JLabel lbSub_tot_cot;
    private javax.swing.JLabel lbSub_tot_cot1;
    private javax.swing.JLabel lbTel_cli;
    private javax.swing.JLabel lbTel_cli1;
    private javax.swing.JLabel lbTot_cot;
    private javax.swing.JLabel lbTot_cot1;
    private javax.swing.JLabel lbcod_dpc;
    private javax.swing.JLabel lbicoIva;
    private javax.swing.JLabel lblAltPro;
    private javax.swing.JLabel lblApeCli1;
    private javax.swing.JLabel lblCanInsu1;
    private javax.swing.JLabel lblCanInsu2;
    private javax.swing.JLabel lblCanPro;
    private javax.swing.JLabel lblCodInsu;
    private javax.swing.JLabel lblCodPro;
    private javax.swing.JLabel lblColInsu;
    private javax.swing.JLabel lblColInsu1;
    private javax.swing.JLabel lblColorPro;
    private javax.swing.JLabel lblDesCot;
    private javax.swing.JLabel lblDesInsu1;
    private javax.swing.JLabel lblDirCli1;
    private javax.swing.JLabel lblEmaCli;
    private javax.swing.JLabel lblEmaCli1;
    private javax.swing.JLabel lblFabInsu1;
    private javax.swing.JLabel lblFijoCli1;
    private javax.swing.JLabel lblIdCli1;
    private javax.swing.JLabel lblMovCli1;
    private javax.swing.JLabel lblNomCli;
    private javax.swing.JLabel lblNomCli1;
    private javax.swing.JLabel lblNomCli10;
    private javax.swing.JLabel lblNomCli11;
    private javax.swing.JLabel lblNomCli2;
    private javax.swing.JLabel lblNomCli4;
    private javax.swing.JLabel lblNomCli5;
    private javax.swing.JLabel lblRefInsu;
    private javax.swing.JLabel lblTipInsu;
    private javax.swing.JLabel lblTipPro;
    private javax.swing.JLabel lblUsoInsu1;
    private javax.swing.JLabel lbtituloCli;
    private javax.swing.JLabel lbtituloCot;
    private javax.swing.JTable tbDespiece;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTable tblCotizaciones;
    private javax.swing.JTable tblInsumosCotizacion;
    private javax.swing.JTable tblMostrarDespiece;
    private javax.swing.JTable tblPro_Despiece;
    private javax.swing.JTable tblPro_cot;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTable tblTipPro;
    private javax.swing.JTextField txtAltPro;
    private javax.swing.JTextField txtAncPro;
    private javax.swing.JTextField txtApeCli;
    private javax.swing.JTextField txtApeCli1;
    private javax.swing.JTextField txtCanDpc;
    private javax.swing.JTextField txtCanPro;
    private javax.swing.JTextField txtCantInsu;
    private javax.swing.JTextField txtCodDpc;
    private javax.swing.JTextField txtCodDpc1;
    private javax.swing.JTextField txtCodInsu;
    private javax.swing.JTextField txtCodPro;
    private javax.swing.JTextField txtCodTipPro;
    private javax.swing.JTextField txtCod_Dpc_mat;
    private javax.swing.JTextField txtColInsu;
    private javax.swing.JTextField txtDesCot;
    private javax.swing.JTextField txtDesInsu;
    private javax.swing.JTextField txtDesTipPro;
    private javax.swing.JTextField txtDescDpc;
    private javax.swing.JTextField txtDirCli;
    private javax.swing.JTextField txtDirCli1;
    private javax.swing.JTextField txtEmaCli;
    private javax.swing.JTextField txtEmaCli1;
    private javax.swing.JTextField txtFabInsu;
    private javax.swing.JTextField txtFijoCli;
    private javax.swing.JTextField txtFijoCli1;
    private javax.swing.JTextField txtForDpc;
    private javax.swing.JTextField txtIdCli;
    private javax.swing.JTextField txtIdCli1;
    private javax.swing.JTextField txtMovCli;
    private javax.swing.JTextField txtMovCli1;
    private javax.swing.JTextField txtNomCli;
    private javax.swing.JTextField txtNomCli1;
    private javax.swing.JTextField txtPreInsu1;
    private javax.swing.JTextField txtRefDpc;
    private javax.swing.JTextField txtRefTipPro;
    private javax.swing.JTextField txtReftInsu;
    private javax.swing.JTextField txtSisDpc;
    private javax.swing.JTextField txtSisTipPro;
    private javax.swing.JTextField txtTipInsu;
    private javax.swing.JTextField txtUsoInsu;
    // End of variables declaration//GEN-END:variables
    


  //Metodo para crear la tabla de productos  
 public void JCrearTablaProductoCotizacion(){
Object modelodatos[][]= new Object[0][0];
Object []modelotitulos={"Codigo","Descripcion","Tipo","Color","Ancho","Alto","Cantidad"};
tablaproCot= new DefaultTableModel();
tablaproCot=new DefaultTableModel(modelodatos,modelotitulos);
TblProductoCotizacion.setModel(tablaproCot);
}
 
 //Metodo para crear la tabla de insumos
 public void JCrearTablaInsumosCotizacion(){
Object datos[][]= new Object[0][0];
Object []titulos={"Codigo","nombre","tipo","uso","referencia","color","fabricante","cantidad","precio"};
tabladatosinsu= new DefaultTableModel();
tabladatosinsu=new DefaultTableModel(datos,titulos);
tblInsumosCotizacion.setModel(tabladatosinsu);
}
 
 
//Metodo para eliminar fila de la tabla Productos
public void JEliminarfilaProductoCot(){
        DefaultTableModel m = (DefaultTableModel)TblProductoCotizacion.getModel();
        int fila, resp;
        
        try {
            
            fila = TblProductoCotizacion.getSelectedRow();
            
            if(fila==-1){
                JOptionPane.showMessageDialog(null,"Debe seleccionar un producto de la tabla que desee eliminar","Advertencia",JOptionPane.WARNING_MESSAGE);
                
            }else{
                resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este producto","Eliminar",JOptionPane.YES_NO_OPTION);
                if(resp==JOptionPane.YES_OPTION){
                    //Remueve filas dela tabla
                    m.removeRow(fila);
                }
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"No se realizo la eliminación del producto","Error",JOptionPane.ERROR_MESSAGE);
            System.out.println("Error el metodo elimnar fila --formulario cotizacion" +e.getLocalizedMessage());
            
    }
   }



//Metodo para llenar la tabla de insumos con filas de la tabla producto   
public void JLlenarTablaInsumosCotizacion(){
    int fila, cod;
     
        
         try {
         fila = TblProductoCotizacion.getSelectedRow();
        
            if(fila ==-1){
                JOptionPane.showMessageDialog(null, "Seleccione o ingrese un producto de la tabla para ver insumos","Advertencia",JOptionPane.WARNING_MESSAGE);
             }
            else{
               cod = Integer.parseInt(TblProductoCotizacion.getValueAt(fila, 0).toString());
             
              
              cot.listarTablaInsumoCotizacion(cod);
               if(cot.datoscot.next()==false){
               JOptionPane.showMessageDialog(null,"no hay registro en la tabla", "Cotizacion",JOptionPane.WARNING_MESSAGE);
              }
               else if(cot.datoscot.next()==true){
              Object[] filas = new Object[9];
              cot.datoscot.beforeFirst();
              while(cot.datoscot.next()){

                for(int i =0; i<9; i++){
                    filas[i] = cot.datoscot.getObject(i+1);
                }
                tabladatosinsu.addRow(filas);
            }
           
             }
            }}
            catch(Exception e){
                     System.out.println("Error al llenar tabla insumo-cotizacion en formulario cotizacion: " +e.getLocalizedMessage());
                     
                    }
}
 //Metodo para agregar insumos a los productos a cotizar            
public int  JAgregarInsumoCotizacion(){
 
 String [] cod = new String[500];
 String [] tipo = new String [500];
  String [] color = new String [500];
  int val = 0;
    try {
        
        //se recorre la tabla registro por registro
        for(int i = 0; i<TblProductoCotizacion.getRowCount();i++){
        //se guarda el codigo y la referencia o tipo y el color  del  producto de la tabla
        cod[i] = TblProductoCotizacion.getValueAt(i,0).toString();
        
        tipo[i] = TblProductoCotizacion.getValueAt(i,2).toString();
        color[i] = TblProductoCotizacion.getValueAt(i,3).toString();

         cot.listarTablaInsumoCotizacion(Integer.parseInt(cod[i]));
                if(cot.datoscot.next()==false){
                    //Trae los insumos segun la referencia y color  del producto.
                   cot.MtdBuscarTablaInsumoCotizacion(tipo[i], color[i]);
                   //Verifica si hay registros en la tabla
                    if(cot.datoscot.next()==false){
                    JOptionPane.showMessageDialog(null, "No existen insumos para el producto: "+cod[i]+"\nIngrese los insumos para realizar la cotizacion","Cotizacion",JOptionPane.WARNING_MESSAGE);
                    }
                    else if (cot.datoscot.next()==true){
                     val = 1;
                    //Mueve el cursor al inicio de la primera fila de los datos obtenidos por la consulta
                    cot.datoscot.beforeFirst();
                   //Se insertan los datos de los insumos en la bd.
                    while(cot.datoscot.next()){
                        //Se agregan los insumos del producto
                    cot.MtdInsertarInsumoCotizacion(Integer.parseInt(cod[i]),Integer.parseInt(cot.datoscot.getString(1)));}
                    
                    }
                    }
                    }
     
                    
    } catch (Exception e) {
        System.out.println("Error al agregar insumo en formulario cotizacion: " +e.getLocalizedMessage());
    }
return val;
}     

//valida si los productos tienen asociados los insumos para poder cotizar
public int JValidarInsumoCotizacion(){
 
 String [] cod = new String[500];
 int validar = 0;
    try {
        //se recorre la tabla registro por registro
        for(int i = 0; i<TblProductoCotizacion.getRowCount();i++){
        //se guarda el codigo y la referncia o tipo de cada producto de la tabla
        cod[i] = TblProductoCotizacion.getValueAt(i,0).toString();
        //se consulta si hay insumos sociados al producto
        cot.listarTablaInsumoCotizacion(Integer.parseInt(cod[i]));
                if(cot.datoscot.next()==false){
                    validar = 1;
                    }}

    } catch (Exception e) {
        System.out.println("Error al agregar insumo en formulario cotizacion: " +e.getLocalizedMessage());
    }
return validar;
}   
        
       
           
            
    
   

//Metodo para eliminar insumos en tabla en el formulario cotizacion
public void JEliminarfilaInsumos(){
       DefaultTableModel m = (DefaultTableModel)tblInsumosCotizacion.getModel();
        int fila,fila1, resp,cod_pro,cod_mat;
        
        try {
            
            fila = tblInsumosCotizacion.getSelectedRow();
            fila1 = TblProductoCotizacion.getSelectedRow();
            if(fila==-1||fila1==-1){
                JOptionPane.showMessageDialog(null,"Debe seleccionar el insumo a eliminar con su producto","Advertencia",JOptionPane.WARNING_MESSAGE);
                 //m.removeRow(fila);
            }else{
                cod_pro = Integer.parseInt(TblProductoCotizacion.getValueAt(fila1,0).toString());
                cod_mat = Integer.parseInt(tblInsumosCotizacion.getValueAt(fila, 0).toString());
                resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este insumo","Eliminar",JOptionPane.YES_NO_OPTION);
                if(resp==JOptionPane.YES_OPTION){
                    cot.EliminarInsumoProducto(cod_pro,cod_mat);
                    m.removeRow(fila);
                    
                     
                
                }
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"No se realizo la eliminación del producto","Error",JOptionPane.ERROR_MESSAGE);
            System.out.println("Error el metodo elimnar fila --formulario cotizacion" +e.getLocalizedMessage());
            
    }
   }

 //Metodo para crear la tabla insumos en JDialiog insumos
 public void JCrearTablaInsumos(){
Object datos[][]= new Object[0][0];
Object []titulos={"Codigo","nombre","tipo","uso","referencia","color","fabricante","cantidad","precio","Codigo para despiece"};
tablainsu= new DefaultTableModel();
tablainsu=new DefaultTableModel(datos,titulos);
TblInsumos.setModel(tablainsu);
}

 //Metodo para llenar la tabla insumos en JDialiog insumos
 public void JLlenarTablaInsumos(){
    try{

  coti.listarTablaInsumo();
    Object[] filas = new Object[10];
    while(coti.datoscot.next()){

      for(int i =0; i<10; i++){
          filas[i] = coti.datoscot.getObject(i+1);
      }
      tablainsu.addRow(filas);  }}

 catch(SQLException exTblActufa){
 System.out.println("Error al llenar tabla actualizaciones clase materiales: "+exTblActufa.getMessage());}
}
 
 //Metodo para agregar Insumos Jdialog Insumos a Formulario cotizacion
 public void JAgregarInsumo(){
    int fila = TblInsumos.getSelectedRow();
    int fila1 = TblProductoCotizacion.getSelectedRow();
    String cod, nom, tip, uso, ref, col,fab,can ,pre ;
    int cod_pro;
    try {
        if( fila1==-1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto de la tabla,\n Agregar insumos con el boton (Agregar insumos) y \n Mostrar sus insumos con el boton (mostrar insumos)\n en el formulario principal","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
        else if(fila==-1){
         JOptionPane.showMessageDialog(null, "Debe seleccionar un insumo de la tabla","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
        else{
            cod = TblInsumos.getValueAt(fila, 0).toString();
            nom = TblInsumos.getValueAt(fila, 1).toString();
            tip = TblInsumos.getValueAt(fila, 2).toString();
            uso = TblInsumos.getValueAt(fila, 3).toString();
            ref = TblInsumos.getValueAt(fila, 4).toString();
            col = TblInsumos.getValueAt(fila, 5).toString();
            fab = TblInsumos.getValueAt(fila, 6).toString();
            can = TblInsumos.getValueAt(fila, 7).toString();
            pre = TblInsumos.getValueAt(fila, 8).toString();
            cod_pro= Integer.parseInt(TblProductoCotizacion.getValueAt(fila1, 0).toString());
            DefaultTableModel m = (DefaultTableModel) tblInsumosCotizacion.getModel(); 
            String  filas [] = {cod ,nom, tip, uso, ref, col, fab, can, pre };
            m.addRow(filas);
            cot.AgregarInsumoCotizacion(cod_pro, Integer.parseInt(cod));
            
        }
    } catch (Exception e) {
         System.out.println("Error al agregar insumo en  tabla insumo-cotizacion en formulario cotizacion: "+e.getMessage());}

    }
    

 
 //Metodo para agregar Cliente Jdialog Cliente a Formulario cotizacion
 public void JAgregarCliente(){
     int fila = tblCliente.getSelectedRow();
     String id, nom, ape, dir, ema, fij_tel,mov_tel;
    
      try {
         if(fila == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente","Advertencia",JOptionPane.WARNING_MESSAGE);
         }
         else{
             
            id = tblCliente.getValueAt(fila, 0).toString();
             nom = tblCliente.getValueAt(fila, 1).toString();
             ape = tblCliente.getValueAt(fila, 2).toString();
             dir = tblCliente.getValueAt(fila, 3).toString();
             ema = tblCliente.getValueAt(fila, 4).toString();
             fij_tel = tblCliente.getValueAt(fila, 5).toString();
             mov_tel = tblCliente.getValueAt(fila, 6).toString();
             
          
           txtIdCli.setText(id);
           txtNomCli.setText(nom);
           txtApeCli.setText(ape);
           txtDirCli.setText(dir);
           txtEmaCli.setText(ema);
           txtFijoCli.setText(fij_tel);
           txtMovCli.setText(mov_tel);
           
           
          }
     } catch (NullPointerException e) {
       System.out.println("Error al agregar cliente a la Panel cliente  en formulario cotizacion: "+e.getMessage());

     }
 }
 
 //Metodo para agregar producto del JDialog producto a la tabal producto del formulario cotizacion.
 public void JAgregarProducto(){
    
     String cod, des, tip, col, anc, alt, can;
     DefaultTableModel f = (DefaultTableModel) TblProductoCotizacion.getModel();
     try {
          if(tblProducto.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Producto","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
          else{
              for(int i = 0; i<tblProducto.getRowCount();i++){
                  
              cod = tblProducto.getValueAt( i, 0).toString();
              des = tblProducto.getValueAt( i, 1).toString();
              tip = tblProducto.getValueAt(i, 2).toString();
              col = tblProducto.getValueAt( i, 3).toString();
              anc = tblProducto.getValueAt( i, 4).toString();
              alt = tblProducto.getValueAt( i, 5).toString();
              can = tblProducto.getValueAt( i, 6).toString();
              String [] filas ={cod, des, tip, col, anc, alt, can};
              f.addRow(filas);
              }
            
              
             
          }
     } catch (Exception e) {
         System.out.println("Error al agregar producto a la tabla insumo-cotizacion en formulario cotizacion: "+e.getLocalizedMessage());
     }
    
     
 }
 
 //Metodo para crear la tabla cliente en JDialog Cliente
 public void JCrearTablaCliente(){
     Object datos[][] = new Object [0][0];
     Object [] titulos ={"Identificacion","Nombre","Apellido","Direccion","Email","Telefono fijo"," telefono movil"};
     tablaCli = new DefaultTableModel(datos,titulos);
     tblCliente.setModel(tablaCli);
     }
 
 //Metodo para llenar la tabla cliente en JDialog Cliente
 public void JLlenartablaCliente(){
     cli.MtdListarTablaCliente();
     Object [] datos = new Object[7];
     try {
         while(cli.datosCli.next()){
             for(int i = 0; i<7; i++){
                 datos[i] = cli.datosCli.getObject(i+1);
                 }
             tablaCli.addRow(datos);
         }
     } catch (Exception e) {
         System.out.println("Error al llenar tabla cliente en Jdialog Cliente: "+ e.getLocalizedMessage());
     }
 }
 
 //Metodo para crear la tabla Producto en JDialog Producto
 public void JCrearTablaProducto(){
    Object [][] datos = new Object[0][0];
    Object []titulos={"Codigo","Descripcion","Referencia","Color","Ancho","Alto","Cantidad"};
    tablaPro=new DefaultTableModel(datos,titulos);
    tblProducto.setModel(tablaPro);
 }
 
  //Metodo para llenar la tabla Producto en JDialog Producto
 public void JLlenarTablaProducto(){
     String [] datos =  new String [7];
      pro.MtdListarTablaProducto();
     try {
       while(pro.datosPro.next()){
        for(int i=0; i<7; i++){
             datos[i] = pro.datosPro.getString(i+1);
              }
       tablaPro.addRow(datos);
     }
     } catch (Exception e) {
         System.out.println("Error al llenar tabla Producto en jDialog producto: " +e.getLocalizedMessage());
     }
     
 }
 
 //Metodo para guardar datos del cliente en JDialog Cliente
 public  void JGuardarCliente(){
    try{
    //valido cajas de text vacias
 if(txtIdCli1.getText().length()==0){
        JOptionPane.showMessageDialog(null, "Ingrese la identificacion del cliente","CLIENTE",JOptionPane.INFORMATION_MESSAGE);
        txtIdCli1.grabFocus();}
  else if(txtNomCli1.getText().length()==0){
    JOptionPane.showMessageDialog(null, "Ingrese el nombre del cliente","CLIENTE",JOptionPane.INFORMATION_MESSAGE);
        txtNomCli1.grabFocus();}
  else if(txtApeCli1.getText().length()==0){
    JOptionPane.showMessageDialog(null, "Ingrese el apellido del cliente","CLIENTE",JOptionPane.INFORMATION_MESSAGE);
        txtNomCli1.grabFocus();}
  else{
      //validar ingresar identificacion duplicada
      int val = 0;
        cli.MtdListarTablaCliente();
        while(cli.datosCli.next() ){
     if((Integer.parseInt(cli.datosCli.getString(1)) == Integer.parseInt(txtIdCli1.getText())))
     {
        JOptionPane.showMessageDialog(null, "Ya existe esta identificacion", "CLIENTE", JOptionPane.WARNING_MESSAGE);
        val = 1;
        txtIdCli1.grabFocus();
     } 
        }
        
       if (val != 1){
        
   cli.MtdGuardarCliente(Integer.parseInt(txtIdCli1.getText()), txtNomCli1.getText(),txtApeCli1.getText(),txtDirCli1.getText(),txtEmaCli1.getText(), ficcli);
   cli.MtdGuardarTelefono_cliente(txtFijoCli1.getText(), txtMovCli1.getText(),Integer.parseInt(txtIdCli1.getText()));
   
    JOptionPane.showMessageDialog(null, "Datos guardados satisfactoriamente","CLIENTE",JOptionPane.INFORMATION_MESSAGE);
     
    }
        
        
   }
    
     
     
   
  
    }
    catch(Exception exJGuaCli){
    System.out.println("Error al guardar en el formulario cliente: "+exJGuaCli.getMessage());
        JOptionPane.showMessageDialog(null, "Error al guardar en el formulario cliente:"+exJGuaCli.getLocalizedMessage(),"CLIENTE",JOptionPane.ERROR_MESSAGE);

    }
}
 
 
//Metodo para actualizar datos del cliente en JDialog Cliente
 public void JActualizarCliente(){
try{
    
    if(txtIdCli1.getText().length()==0){
    JOptionPane.showMessageDialog(null, "Ingrese la identificacion del cliente","CLIENTE",JOptionPane.INFORMATION_MESSAGE);
       txtIdCli1.grabFocus();}
    
    else if(txtNomCli1.getText().length()==0){
    JOptionPane.showMessageDialog(null, "Ingrese el nombre del cliente","CLIENTE",JOptionPane.INFORMATION_MESSAGE);
        txtNomCli1.grabFocus();}
    else if(txtApeCli1.getText().length()==0){
    JOptionPane.showMessageDialog(null, "Ingrese el apellido del cliente","CLIENTE",JOptionPane.INFORMATION_MESSAGE);
        txtApeCli1.grabFocus();}
    else if(txtMovCli1.getText().length()==0 && txtFijoCli1.getText().length()==0){
    JOptionPane.showMessageDialog(null, "Ingrese el telefono movil o telefono fijo del cliente","CLIENTE",JOptionPane.INFORMATION_MESSAGE);}
    else if(txtDirCli1.getText().length()==0){
    JOptionPane.showMessageDialog(null, "Ingrese la direccion del cliente","CLIENTE",JOptionPane.INFORMATION_MESSAGE);
        txtDirCli1.grabFocus();}
    else if(txtEmaCli1.getText().length()==0){
    JOptionPane.showMessageDialog(null, "Ingrese el correo electrónico del cliente","CLIENTE",JOptionPane.INFORMATION_MESSAGE);
        txtEmaCli1.grabFocus();}
    else{
       
   cli.MtdActualizarCliente(txtNomCli1.getText(),txtApeCli1.getText(), txtDirCli1.getText(),txtEmaCli1.getText(),ficcli,Integer.parseInt(txtIdCli1.getText()));
   cli.MtdActualizarTelefonoCliente(txtFijoCli1.getText(), txtMovCli1.getText(),Integer.parseInt(txtIdCli1.getText()));
   
            
        
    
       }}

     catch(Exception exJActCli){
    JOptionPane.showMessageDialog(null, "Los datos no se Actualizaron","CLIENTE",JOptionPane.ERROR_MESSAGE);
    System.out.println("Error al actualizar los datos del  cliente: "+exJActCli.getMessage());
    }
}

 //Metodo para eliminar datos del cliente en JDialog cliente
 public void JEliminarCliente(){
     int fila = tblCliente.getSelectedRow();
     String id;
try{
    if(fila == -1){
    JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla cliente","Cliente",JOptionPane.INFORMATION_MESSAGE);
    }
    else{
    int EliCli=JOptionPane.showConfirmDialog(null, "Desea eliminar los datos de este cliente?","CLIENTE",0,JOptionPane.QUESTION_MESSAGE);
    if(EliCli==0){
        id = tblCliente.getValueAt(fila,0).toString();
       cli.MtdEliminarTelefonoCliente(Integer.parseInt(id));
       cli.MtdEliminarCliente(Integer.parseInt(id));
      
    }
    else if (EliCli == 1){
     JOptionPane.showMessageDialog(null, "Operacion cancelada","CLIENTE",JOptionPane.INFORMATION_MESSAGE);
    }
    else{JOptionPane.showMessageDialog(null, "Operacion cancelada","CLIENTE",JOptionPane.INFORMATION_MESSAGE);}

    }}
catch(Exception exJEliCli){
System.out.println("Error al eliminar datos del formulario cliente: "+exJEliCli.getMessage());}
}
 
//Metodo para guardar los  datos de los insumos en JDialog insumos
 public void JGuardarInsumos(){
try{
    if(txtTipInsu.getText().length()==0){
 JOptionPane.showMessageDialog(null,"Ingrese el tipo de material","Insumos",JOptionPane.INFORMATION_MESSAGE);
    txtTipInsu.grabFocus();}
    else if(txtDesInsu.getText().length()==0){
 JOptionPane.showMessageDialog(null,"Ingrese la descripcion del material","Insumos",JOptionPane.INFORMATION_MESSAGE);
    txtDesInsu.grabFocus();} 
   
    else if(txtFabInsu.getText().length()==0){
JOptionPane.showMessageDialog(null,"Ingrese el Fabricante del material","Insumos",JOptionPane.INFORMATION_MESSAGE);
    txtFabInsu.grabFocus();} 
    else if(txtCantInsu.getText().length()==0){JOptionPane.showMessageDialog(null,"Ingrese la cantidad de material","Insumos",JOptionPane.INFORMATION_MESSAGE);
    txtCantInsu.grabFocus();}
    else if(txtUsoInsu.getText().length()==0){JOptionPane.showMessageDialog(null,"Ingrese el uso del material","Insumos",JOptionPane.INFORMATION_MESSAGE);
    txtUsoInsu.grabFocus();}
    else if(txtPreInsu1.getText().length()==0){JOptionPane.showMessageDialog(null,"Ingrese el precio del material","Insumos",JOptionPane.INFORMATION_MESSAGE);
   txtPreInsu1.grabFocus();}
    else if(txtReftInsu.getText().length()==0){
    JOptionPane.showMessageDialog(null,"Ingrese la referencia de la perfileria","Insumos",JOptionPane.INFORMATION_MESSAGE);
    txtReftInsu.grabFocus();}
    else if(txtCod_Dpc_mat.getText().length()==0){
    JOptionPane.showMessageDialog(null,"Ingrese el codigo para despiezar con insumos","Insumos",JOptionPane.INFORMATION_MESSAGE);
    txtReftInsu.grabFocus();}

else {insu.MtdGuardarMateriales(txtDesInsu.getText(), txtTipInsu.getText(), txtUsoInsu.getText(), txtReftInsu.getText(), txtColInsu.getText(), txtFabInsu.getText(), Integer.parseInt(txtCantInsu.getText()), Integer.parseInt(txtPreInsu1.getText()),ficinsu, Integer.parseInt(txtCod_Dpc_mat.getText()));
    }
    
}

catch(HeadlessException exgmgt){
JOptionPane.showMessageDialog(null, "No es posible guardar el registro: "+exgmgt.getMessage());
        JOptionPane.showMessageDialog(null,"Error al guardar Insumos: "+exgmgt.getLocalizedMessage(),"Insumos",JOptionPane.ERROR_MESSAGE);

}
}
 
 //Metodo para actualizar los  datos de los insumos en JDialog insumos
 public void JActualizarInsumos(){
     try {
         if(txtTipInsu.getText().length()==0){
    JOptionPane.showMessageDialog(null,"Ingrese el tipo de material","Insumos",JOptionPane.INFORMATION_MESSAGE);
       txtTipInsu.grabFocus();}
    else if(txtDesInsu.getText().length()==0){
    JOptionPane.showMessageDialog(null,"Ingrese la descripcion del material","Insumos",JOptionPane.INFORMATION_MESSAGE);
       txtDesInsu.grabFocus();} 
    else if(txtFabInsu.getText().length()==0){JOptionPane.showMessageDialog(null,"Ingrese el fabricante del material","Insumos",JOptionPane.INFORMATION_MESSAGE);
    txtFabInsu.grabFocus();}
    else if(txtCantInsu.getText().length()==0){
   JOptionPane.showMessageDialog(null,"Ingrese la cantidad del material","Insumos",JOptionPane.INFORMATION_MESSAGE);
      txtCantInsu.grabFocus();} 
    else if(txtUsoInsu.getText().length()==0){JOptionPane.showMessageDialog(null,"Ingrese el uso del material","Insumos",JOptionPane.INFORMATION_MESSAGE);
      txtUsoInsu.grabFocus();}
    else if(txtPreInsu1.getText().length()==0){JOptionPane.showMessageDialog(null,"Ingrese el precio del material","Insumos",JOptionPane.INFORMATION_MESSAGE);
   txtPreInsu1.grabFocus();}
    
    else if(txtReftInsu.getText().length()==0){
    JOptionPane.showMessageDialog(null,"Ingrese la referencia de la perfileria","Insumos",JOptionPane.INFORMATION_MESSAGE);
    txtReftInsu.grabFocus();}
    
     else if(txtCod_Dpc_mat.getText().length()==0){
    JOptionPane.showMessageDialog(null,"Ingrese el codigo para despiezar con insumos","Insumos",JOptionPane.INFORMATION_MESSAGE);
    txtReftInsu.grabFocus();}


else{
    insu.MtdActualizarMateriales(txtDesInsu.getText(), txtTipInsu.getText(), txtUsoInsu.getText(), txtReftInsu.getText(), txtColInsu.getText(), txtFabInsu.getText(), Integer.parseInt(txtCantInsu.getText()), Integer.parseInt(txtPreInsu1.getText()), ficinsu,Integer.parseInt(txtCod_Dpc_mat.getText()), Integer.parseInt(txtCodInsu.getText()));
    }
     } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error al actualizar insumos","Insumos"+e.getLocalizedMessage(),JOptionPane.INFORMATION_MESSAGE);

     }
     
}
 
 //Metodo para eliminar los  datos de los  insumos
 public void JEliminarInsumos(){
     
         int fila = TblInsumos.getSelectedRow();
         String id;
         try {
         if(fila ==-1){
        JOptionPane.showMessageDialog(null,"Seleccione un registro de la tabla insumos","Insumos",JOptionPane.INFORMATION_MESSAGE);
        TblInsumos.grabFocus();}
     else{
        int EliMaterial= JOptionPane.showConfirmDialog(null, "Desea borrar el registro de este material por completo? "," Insumos",0,JOptionPane.QUESTION_MESSAGE);
        if(EliMaterial==0){
        id = TblInsumos.getValueAt(fila,0).toString();
        insu.MtdEliminarMateriales(id);
        
        }
 }
     } catch (Exception e) {
                 JOptionPane.showMessageDialog(null,"Error al eliminar Insumos: "+e.getLocalizedMessage(),"Insumos",JOptionPane.ERROR_MESSAGE);

     }
     
 }
 
 //Metodo para llenar el combo tipo producto en JDialog producto
 public void JCargarComboTipoPorducto(){
     cboTipPro.removeAllItems();
     cboTipPro.addItem("Seleccione");
     try {
        pro.MtdLLenarComboTipo();
        while(pro.datosPro.next()){
        cboTipPro.addItem(pro.datosPro.getString(1));
     } 
     }
     catch (Exception e) {
         System.out.println("Error al cargar caombo en formulario cotizacion: "+e.getLocalizedMessage());
     }
 }
 
 //Metodo para guardar datos el producto en JDialog producto
 public void JGuardarproducto(){
    try{

    if(cboColorPro.getSelectedItem().equals("Seleccione")){
    JOptionPane.showMessageDialog(null, "Ingrese el color del producto","PRODUCTO",JOptionPane.INFORMATION_MESSAGE);
    cboColorPro.grabFocus();}
    
    else if(cboTipPro.getSelectedItem().equals("Seleccione")){
    JOptionPane.showMessageDialog(null, "Ingrese el tipo del producto","PRODUCTO",JOptionPane.INFORMATION_MESSAGE);
    cboTipPro.grabFocus();}
    
    else if(txtAncPro.getText().length()==0){
    JOptionPane.showMessageDialog(null, "Ingrese el ancho del producto","PRODUCTO",JOptionPane.INFORMATION_MESSAGE);
    txtAncPro.grabFocus();}

    else if(txtAltPro.getText().length()==0){
    JOptionPane.showMessageDialog(null, "Ingrese la altura del producto","PRODUCTO",JOptionPane.INFORMATION_MESSAGE);
     txtAltPro.grabFocus();
    }
    else if(txtCanPro.getText().length()==0){
    JOptionPane.showMessageDialog(null, "Ingrese la cantidad del producto","PRODUCTO",JOptionPane.INFORMATION_MESSAGE);
     txtCanPro.grabFocus();
}
    


else {
String tipo = cboTipPro.getSelectedItem().toString();
String [] tipos = tipo.split("--");

pro.MtdguardarProducto(cboColorPro.getSelectedItem().toString(), Double.valueOf(txtAncPro.getText()), Double.valueOf(txtAltPro.getText()), Integer.parseInt(txtCanPro.getText()),Integer.parseInt(tipos[0]));
pro.MtdListarProducto();
JInsertarProducto(pro.datosPro);

{
  
}
}
}

catch(Exception eJGuapro){
      System.out.println("Error al guardar producto en el formulario cotizacion: "+eJGuapro.getMessage());
      JOptionPane.showMessageDialog(null, "Error al guardar producto en el formulario cotizacion: "+eJGuapro.getMessage(),"Cotizacion",JOptionPane.ERROR_MESSAGE);


}

}
 
 //Metodo para actualizar datos el producto en JDialog producto
 public void JActualizarProducto(){
    try{

        if(cboColorPro.getSelectedItem().equals("Seleccione")){
        JOptionPane.showMessageDialog(null, "Ingrese el color del producto","PRODUCTO",JOptionPane.INFORMATION_MESSAGE);
        cboColorPro.grabFocus();}
        
        else if(cboTipPro.getSelectedItem().equals("Seleccione")){
        JOptionPane.showMessageDialog(null, "Ingrese el tipo del producto","PRODUCTO",JOptionPane.INFORMATION_MESSAGE);
        cboTipPro.grabFocus();}
        
        else if(txtAncPro.getText().length()==0){
        JOptionPane.showMessageDialog(null, "Ingrese el ancho del producto","PRODUCTO",JOptionPane.INFORMATION_MESSAGE);
        txtAncPro.grabFocus();}

        else if(txtAltPro.getText().length()==0){
        JOptionPane.showMessageDialog(null, "Ingrese la altura del producto","PRODUCTO",JOptionPane.INFORMATION_MESSAGE);
        txtAltPro.grabFocus();}
        else if(txtCanPro.getText().length()==0){
        JOptionPane.showMessageDialog(null, "Ingrese la cantidad del producto","PRODUCTO",JOptionPane.INFORMATION_MESSAGE);
        txtCanPro.grabFocus();}

else {
 String tipo = cboTipPro.getSelectedItem().toString();
 String []tipopro = tipo.split("--");
 pro.MtdActualizarProducto(cboColorPro.getSelectedItem().toString(), Double.valueOf(txtAncPro.getText()),Double.valueOf(txtAltPro.getText()),Integer.parseInt(txtCanPro.getText()),Integer.parseInt(tipopro[0]),Integer.parseInt(txtCodPro.getText()));
int fila = tblProducto.getSelectedRow();
tablaPro.removeRow(fila);
pro.MtdTraerProducto(Integer.parseInt(txtCodPro.getText()));
JInsertarProducto(pro.datosPro);

 



}}catch(Exception eJGuapro){
      System.out.println("Error al Actualizar producto el formulario cotizacion: "+eJGuapro.getMessage());
      JOptionPane.showMessageDialog(null, "Error al Actualizar producto el formulario cotizacion: "+eJGuapro.getMessage(),"Producto",JOptionPane.ERROR_MESSAGE);
}

}
 
 //Metodo para eliminar datos el producto en JDialog producto
 public void JEliminarProducto(){
     DefaultTableModel m = (DefaultTableModel)tblProducto.getModel();
     int fila = tblProducto.getSelectedRow();
   
     if(fila == -1){
         JOptionPane.showMessageDialog(null,"Seleccione una registro de la tabla producto","PRODUCTOS",JOptionPane.WARNING_MESSAGE); 
         tblProducto.grabFocus();
     }
     else{
     
int Eliminar=JOptionPane.showConfirmDialog(null,"Desea eliminar los datos","Producto",0,JOptionPane.QUESTION_MESSAGE);
if (Eliminar==0){
pro.MtdEliminarProducto(Integer.parseInt(tblProducto.getValueAt(fila,0).toString()));
 m.removeRow(fila);
   
   JOptionPane.showMessageDialog(null,"Datos eliminados correctamente","Producto",JOptionPane.INFORMATION_MESSAGE);
}
else if (Eliminar != 0){
JOptionPane.showMessageDialog(null,"Operacion cancelada","Producto",JOptionPane.INFORMATION_MESSAGE);
}}
}
 
 public void JMostrarProducto(){
  
  int fila = tblProducto.getSelectedRow();   
  String cod, tipo, color, ancho , alto , cantidad;
  
     try {
         if(fila ==-1){
      JOptionPane.showMessageDialog(null, "Debe seleccionar un producto de la tabla","Producto",JOptionPane.WARNING_MESSAGE);
  }
  else{
  cod = tblProducto.getValueAt(fila, 0).toString();
  pro.MtdMostrarTablaProducto(Integer.parseInt(cod));
  if(pro.datosPro.next()){
  txtCodPro.setText(cod);
  cboTipPro.setSelectedItem(pro.datosPro.getString(2));
  cboColorPro.setSelectedItem(pro.datosPro.getString(3));
  txtAncPro.setText(pro.datosPro.getString(4));
  txtAltPro.setText(pro.datosPro.getString(5));
  txtCanPro.setText(pro.datosPro.getString(6));
  }
  else{
      JOptionPane.showMessageDialog(null, "No existe el  producto","Producto",JOptionPane.WARNING_MESSAGE);
  }
  }
     } catch (Exception e) {
         System.out.println("Error al mostrar el producto en formulario cotizacion: "+e.getLocalizedMessage());
     }
  
 }
 
 public void JMostrarCliente(){
  
  int fila = tblCliente.getSelectedRow();   
  String cod;
  
     try {
         if(fila ==-1){
      JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente","Cliente",JOptionPane.WARNING_MESSAGE);
  }
  else{
  cod = tblCliente.getValueAt(fila, 0).toString();
  cli.MtdMostrarTablaCliente(Integer.parseInt(cod));
  if(cli.datosCli.next()){
  txtIdCli1.setText(cod);
  txtNomCli1.setText(cli.datosCli.getString(2));
  txtApeCli1.setText(cli.datosCli.getString(3));
  txtDirCli1.setText(cli.datosCli.getString(4));
  txtEmaCli1.setText(cli.datosCli.getString(5));
  txtFijoCli1.setText(cli.datosCli.getString(6));
  txtMovCli1.setText(cli.datosCli.getString(7));
  }
  else{
      JOptionPane.showMessageDialog(null, "No existe el  cliente","Cliente",JOptionPane.WARNING_MESSAGE);
  }
  }
     } catch (Exception e) {
         System.out.println("Error al mostrar el cliente en formulario cotizacion: "+e.getLocalizedMessage());
     }
  
 }
 
 public void JMostrarInsumo(){
  
  int fila = TblInsumos.getSelectedRow();   
  String cod;
  
     try {
         if(fila ==-1){
      JOptionPane.showMessageDialog(null, "Debe seleccionar un insumo","Insumo",JOptionPane.WARNING_MESSAGE);
  }
  else{
  cod = TblInsumos.getValueAt(fila, 0).toString();
  insu.MtMostrarTablaInsumo(Integer.parseInt(cod));
  if(insu.datosinsu.next()){
  txtCodInsu.setText(cod);
  txtDesInsu.setText(insu.datosinsu.getString(2));
  txtTipInsu.setText(insu.datosinsu.getString(3));
  txtUsoInsu.setText(insu.datosinsu.getString(4));
  txtReftInsu.setText(insu.datosinsu.getString(5));
  txtColInsu.setText(insu.datosinsu.getString(6));
  txtFabInsu.setText(insu.datosinsu.getString(7));
  txtCantInsu.setText(insu.datosinsu.getString(8));
  txtPreInsu1.setText(insu.datosinsu.getString(9));
  
  }
  else{
      JOptionPane.showMessageDialog(null, "No existe el  insumo","Insumo",JOptionPane.WARNING_MESSAGE);
  }
  }
     } catch (Exception e) {
         System.out.println("Error al mostrar el insumo en formulario cotizacion: "+e.getLocalizedMessage());
     }
  
 }
 
 public void JGuardarTipProducto(){
     if(txtDesTipPro.getText().length()==0){
         JOptionPane.showMessageDialog(null, "Ingrese la descripcion del tipo producto","Tipo Producto",JOptionPane.WARNING_MESSAGE);
     }
     else if(txtSisTipPro.getText().length()==0){
         JOptionPane.showMessageDialog(null, "Ingrese el sistema del tipo producto","Tipo Producto",JOptionPane.WARNING_MESSAGE);
     }
     else if(txtRefTipPro.getText().length()==0){
         JOptionPane.showMessageDialog(null, "Ingrese la referencia del tipo producto","Tipo Producto",JOptionPane.WARNING_MESSAGE);
     }
     else{
     tip.MtdGuardarTipoProducto(txtDesTipPro.getText(), txtSisTipPro.getText(), txtRefTipPro.getText(), fictip);
     JOptionPane.showMessageDialog(null, "Datos guardados con exito","Tipo producto",JOptionPane.INFORMATION_MESSAGE);
     }
 }
 
 public void JActualizarTipProducto(){
     if(txtDesTipPro.getText().length()==0){
         JOptionPane.showMessageDialog(null, "Ingrese la descripcion del tipo producto","Tipo Producto",JOptionPane.WARNING_MESSAGE);
     }
     else if(txtSisTipPro.getText().length()==0){
         JOptionPane.showMessageDialog(null, "Ingrese el sistema del tipo producto","Tipo Producto",JOptionPane.WARNING_MESSAGE);
     }
     else if(txtRefTipPro.getText().length()==0){
         JOptionPane.showMessageDialog(null, "Ingrese la referencia del tipo producto","Tipo Producto",JOptionPane.WARNING_MESSAGE);
     }
     else{
     tip.MtdActualizarTipoproducto(Integer.parseInt(txtCodTipPro.getText()),txtDesTipPro.getText(), txtSisTipPro.getText(), txtRefTipPro.getText(), fictip);
     JOptionPane.showMessageDialog(null, "Datos actualizados con exito","Tipo producto",JOptionPane.INFORMATION_MESSAGE);
     }
 
 }
 
 public void JEliminarTipProducto(){
      int fila = tblTipPro.getSelectedRow();
     if(fila == -1){
         JOptionPane.showMessageDialog(null, "Seleccione registro de la tabla ","Tipo Producto",JOptionPane.WARNING_MESSAGE);
     }
      else{
          int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el tipo de producto?","Tipo Producto",0,JOptionPane.QUESTION_MESSAGE);
          if(resp==0)
        tip.MtdEliminarTipoProducto(Integer.parseInt(tblTipPro.getValueAt(fila,0).toString()));
          JOptionPane.showMessageDialog(null, "Datos eliminados con exito","Tipo producto",JOptionPane.INFORMATION_MESSAGE);
      }
 }
 public void JCreartablaTipProducto(){
     Object[][] modelodatos = new Object[0][0];
     Object [] modelotitulos ={"codigo","descripcion","sistema","referencia"};
     tablaTipPro =  new DefaultTableModel(modelodatos,modelotitulos);
     tblTipPro.setModel(tablaTipPro);
 }
 
 public void JLlenarTablaTipProducto(){
     Object  [] datos = new Object[4];
     try {
         tip.MtdListarTipPro();
         while(tip.datosTip.next()){
             for(int i = 0; i<4; i++){
             datos[i] = tip.datosTip.getObject(i+1);
             }
             tablaTipPro.addRow(datos);
         }
     } catch (Exception e) {
        System.out.println("Error al llenar tabla de tipo producto en formulario cotizacion: "+e.getLocalizedMessage());

     }
 
 }
 
 public void JMostrarTipProducto(){
     int fila = tblTipPro.getSelectedRow();
     String cod, des, sis, ref;
     if(fila ==-1){
         JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de producto","Tipo Producto",JOptionPane.WARNING_MESSAGE);
     }
     else{
         cod = tblTipPro.getValueAt(fila,0).toString();
         des = tblTipPro.getValueAt(fila,1).toString();
         sis = tblTipPro.getValueAt(fila,2).toString();
         ref = tblTipPro.getValueAt(fila,3).toString();
         
         txtCodTipPro.setText(cod);;
         txtDesTipPro.setText(des);
         txtSisTipPro.setText(sis);
         txtRefTipPro.setText(ref);
     }
 }
 
 //Agregar productos a la tabla de productos del JDialog Producto trayecto los datos de una consulta.
 
 public void JInsertarProducto( ResultSet datos){
    String cod,can,color,anc,alt,tipo, desc;
   
    //Se consulta el producto guardado
    
   try {
     if(datos.next()){
    cod = datos.getString(1);
    color = datos.getString(4); 
    can = datos.getString(7);
    anc = datos.getString(5); 
    alt = datos.getString(6);
    tipo = datos.getString(3);
    desc =  datos.getString(2);
    String [] fila = {cod,desc,tipo,color,anc,alt,can};
    //tablaPro = (DefaultTableModel) tblProducto.getModel();
    tablaPro.addRow(fila);
    

     }
     } catch (Exception e) {
         System.out.println("Error al insertar producto en tabla de JDialog Producto: "+e.getLocalizedMessage());
     }
     }
   
 
 public void JCrearCotizacion(){
     //valido cajas de texto vacias
 if(txtIdCli.getText().length()==0){
        JOptionPane.showMessageDialog(null, "Ingrese la identificacion del cliente","CLIENTE",JOptionPane.INFORMATION_MESSAGE);
        txtIdCli.grabFocus();}
  else if(txtNomCli.getText().length()==0){
    JOptionPane.showMessageDialog(null, "Ingrese el nombre del cliente","CLIENTE",JOptionPane.INFORMATION_MESSAGE);
        txtNomCli.grabFocus();}
  else if(txtApeCli.getText().length()==0){
    JOptionPane.showMessageDialog(null, "Ingrese el apellido del cliente","CLIENTE",JOptionPane.INFORMATION_MESSAGE);
        txtApeCli.grabFocus();}
  //Valida campos vacios en la cotizacion 
    else if(txtDesCot.getText().length()==0){
        JOptionPane.showMessageDialog(null, "Ingrese la descripcion de la cotizacion","Cotizacion",JOptionPane.WARNING_MESSAGE);
         txtDesCot.grabFocus();}
        
       else if(TblProductoCotizacion.getRowCount()==0){
       JOptionPane.showMessageDialog(null,"Ingrese los productos a cotizar","Cotizacion",JOptionPane.WARNING_MESSAGE);
       Producto.setBounds(0, 0, 1033, 542);
       Producto.setVisible(true);
       }
  else{
      //validar identificacion duplicada
      int val = 0;
        cli.MtdListarTablaCliente();
        try {
         
          while(cli.datosCli.next() ){
              //Valida si se ingresa datos diferentes de un cliente ya registrado.
               if((Integer.parseInt(cli.datosCli.getString(1)) == Integer.parseInt(txtIdCli.getText())) && (!(cli.datosCli.getString(2).equals(txtNomCli.getText())))){
                val = 2;
                //Valida los datos del cliente y en dado caso los actualiza para cotizar.
                JOptionPane.showMessageDialog(null,"Esta identificacion ya existe\n,pero los datos ingresados no concuerdan con los del cliente","Cotizacion",JOptionPane.WARNING_MESSAGE);
                    int p = JOptionPane.showConfirmDialog(null,"Desea actualizar los datos del cliente para realizar la cotizacion?","Cotizacion",JOptionPane.YES_NO_OPTION);
                    if(p == JOptionPane.YES_OPTION){
                        //Se actualiza los datos del cliente segun lo ingresado en el panel de cliente en formulario principal.
                        val = 3;
                        cli.MtdActualizarCliente(txtNomCli.getText(),txtApeCli.getText(), txtDirCli.getText(),txtEmaCli.getText(),ficcli,Integer.parseInt(txtIdCli.getText()));
                        cli.MtdActualizarTelefonoCliente(txtFijoCli.getText(), txtMovCli.getText(),Integer.parseInt(txtIdCli.getText()));
         }
     }          //Se valida si el cliente existe 
               else if((Integer.parseInt(cli.datosCli.getString(1)) == Integer.parseInt(txtIdCli.getText())))
                    {
                        val = 1;
                    } 
    
        }
          ///////////////////////////////////////////
         /* VALIDA LOS DATOS DEL CLIENTE:
            val == 0 -->Si el cliente no existe: lo agrega a la bd y realiza la cotizacion;
            val == 1 -->si el cliente existe: solo realiza la cotizacion.
            val == 3 --> el cliente se actualiza: realiza la cotizacion.
          */
          if (val ==1 || val ==3){
              JRealizarCotizacion();
            }
          else if(val == 0){
          cli.MtdGuardarCliente(Integer.parseInt(txtIdCli.getText()), txtNomCli.getText(),txtApeCli.getText(),txtDirCli.getText(),txtEmaCli.getText(), ficcli);
          cli.MtdGuardarTelefono_cliente(txtFijoCli.getText(), txtMovCli.getText(),Integer.parseInt(txtIdCli.getText()));
          JCrearTablaCliente();
          JLlenartablaCliente();
           JRealizarCotizacion();
          }
         
      
     } catch (Exception e) {
         System.out.println("Error al listar clientes para verificar id en FrmCotizacion: "+e.getLocalizedMessage());
     }
       
        
       
     }
    
       
 }
 public void JCotizar(){
ScriptEngineManager manager = new ScriptEngineManager(); 
ScriptEngine engine = manager.getEngineByName("js"); 
String [] nom_despiece = new String[50];
String [] cod_despiece_mate = new String[50];
String[] funcion = new String[50];
Object [] resultado = new Object[50];
String[] can_dpc = new String[1000];
//String sis_dpc;
String []cod = new String[1000];
String [] alto = new String[1000];
String []ancho = new String[1000];
String []can_pro = new String[1000];




     try {
       double valor_sub_cot =0;
       if(TblProductoCotizacion.getRowCount()==0){
       JOptionPane.showMessageDialog(null,"Ingrese los productos a cotizar","Cotizacion",JOptionPane.WARNING_MESSAGE);
       TblProductoCotizacion.grabFocus();
       }
       else{
      for(int i =0; i<TblProductoCotizacion.getRowCount();i++){
        //Se obtiene el valor de cada fila de la tabla  
        cod[i] = TblProductoCotizacion.getValueAt(i,0).toString();
        ancho[i] = TblProductoCotizacion.getValueAt(i,4).toString();
        alto[i] = TblProductoCotizacion.getValueAt(i,5).toString();
        can_pro[i] = TblProductoCotizacion.getValueAt(i,6).toString();
        //GENERAR DESPIECE
        //Se traen los datos del despice ligado al producto
       
        // sis_dpc = cot.datoscot.getString(3);
         
         int j=0;
         cot.MtdDespiecesCotizacion(Integer.parseInt(cod[i]));
         while(cot.datoscot.next()){
         nom_despiece[j] = cot.datoscot.getString(2);
         funcion[j] = cot.datoscot.getString(5);
         can_dpc[j] = cot.datoscot.getString(6);
         cod_despiece_mate[j] = cot.datoscot.getString(7);
         //se valida la formula reemplazando valores
         if(funcion[j].contains("alto")){
         funcion[j] = funcion[j].replaceAll("alto", alto[i]);
         }
         else if(funcion[j].contains("ancho")){
         funcion[j] = funcion[j].replaceAll("ancho", ancho[i]);
         }
         else{
         JOptionPane.showMessageDialog(null, "NO HAY NADA");
         }
         //se guarda el resultado de la cada formula del despiece
         resultado[j] = engine.eval(funcion[j]);
           
           //System.out.println(nom_despiece[j]+": "+funcion[j]+"   "+resultado[j]+"   "+j);
            j= j+1;
            //Se guarda el valor de cada despiece del producto con su respectivo producto
        }
         //CALCULAR COTIZACION
         //Se trae los insumos y se realiza los calculos para obtener el precio del producto 
         
          double valor_pro = 0;
          double valor_tot_pro = 0;
         
          double med_vidrio_fijo = 1;
          double med_vidrio_corre = 1;
          double valor_vidrio_fijo = 0;
          double valor_vidrio_corre = 0;
          
          cot.MtdTraerInsumosCotizacion(Integer.parseInt(cod[i]));
          while(cot.datoscot.next()){
          int k=0;
          for( k = 0;k<j; k++){
          //se compara cada despice de insumo con su insumo para obtener el valor de cada despiece del insumo
            if(cot.datoscot.getString(4).equals(cod_despiece_mate[k])&& nom_despiece[k].contains("vidrio")&& nom_despiece[k].contains("corredera")){
              //se guarda el resultado de cada lado del vidrio y se multiplica para obtener su valor final
             med_vidrio_corre*=Double.parseDouble(resultado[k].toString());
              //System.out.println("medida de vidrio corredera: "+i+"---"+med_vidrio_corre);
             //Se realiza el calculo del precio del vidrio
             valor_vidrio_corre =((med_vidrio_corre/100) * cot.datoscot.getInt(3))*cot.datoscot.getInt(2);
              //System.out.println("valor de vidrio corredera: "+i+"---"+valor_vidrio_corre);
          }
          else if (cot.datoscot.getString(4).equals(cod_despiece_mate[k])&& nom_despiece[k].contains("vidrio")&& nom_despiece[k].contains("fijo")){
              //se guarda el resultado de cada lado del vidrio y se multiplica para obtener su valor final
              med_vidrio_fijo *=
                      Double.parseDouble(resultado[k].toString());
               // System.out.println("medida vidrio fijo: "+i+"---"+med_vidrio_fijo);
              //Se realiza el calculo del precio del vidrio
              valor_vidrio_fijo = ((med_vidrio_corre/100) * cot.datoscot.getInt(3))*cot.datoscot.getInt(2);
               //System.out.println("valor de vidrio fijo: "+i+"---"+valor_vidrio_fijo);
          }
          else if(cot.datoscot.getString(4).equals(cod_despiece_mate[k])){
          //Se suma el valor de cada despiece del insumo
            valor_pro+= (Double.parseDouble(resultado[k].toString())*cot.datoscot.getInt(3))/cot.datoscot.getInt(2);
          }
          else if(cot.datoscot.getString(4).equals("0")){
          valor_pro+= cot.datoscot.getInt(3);
          }
        
          }
          
          }
          //Se suma el valor de los vidrios
          valor_pro+= valor_vidrio_corre + valor_vidrio_fijo ;
          System.out.println("valor del producto= "+ i +" == "+ valor_pro);
          
          //Se suma cada valor de producto al precio de la cotizacion
          valor_tot_pro = (valor_pro * Integer.parseInt(can_pro[i]));
          System.out.println("valor total del producto= "+ i +" == "+ valor_tot_pro);
          valor_sub_cot += valor_tot_pro;
          //Se trae el codigo de la cotizacion actual
          cot.MtdTraerCodCotizacion();
             if(cot.datoscot.next()){
          //Se inserta la cotizacion con el producto seleccionado
         cot.MtdInsertarCotizacionProducto(Integer.parseInt(cot.datoscot.getString(1)),Integer.parseInt(cod[i]),valor_pro,valor_tot_pro);
             }
     }
      double valor_tot_cot = 0;
      double iva  = 0;
      //Validar si el checkbox iva esta seleccionado
       if(JchIva.isSelected()){
           //se calcula el iva de la cotizacion
           iva = valor_sub_cot * 0.19;
           valor_tot_cot = valor_sub_cot + iva;
           System.out.println("valor iva: "+ iva);
           System.out.println("subtotal de la cotizacion: "+valor_sub_cot);
           System.out.println("total de la cotizacion: "+valor_tot_cot);
           
           //traer el codigo de la cotizacion para actualizar la el registro de la cotizacin
            cot.MtdTraerCodCotizacion();
             if(cot.datoscot.next()){
             cot.MtdActualizarPrecioCotizacion(cot.datoscot.getInt(1),iva, valor_sub_cot, valor_tot_cot);
       }}
             else{
                 valor_tot_cot  = valor_sub_cot;
                 System.out.println("subtotal de la cotizacion: "+valor_sub_cot);
                 System.out.println("total de la cotizacion: "+valor_tot_cot);
                  cot.MtdTraerCodCotizacion();
                if(cot.datoscot.next()){
                cot.MtdActualizarPrecioCotizacion(cot.datoscot.getInt(1),iva, valor_sub_cot, valor_tot_cot);
             }
             }
     
       JOptionPane.showMessageDialog(null, "Se realizo la cotizacion con exito","Cotizacion",JOptionPane.INFORMATION_MESSAGE);
       
     } }catch (Exception e) {
         System.out.println("Error al cotizar producto en formulario cotizacion: "+e.getMessage());
     }
 }
 
 public void JDespiezar(){
 
 ScriptEngineManager manager = new ScriptEngineManager(); 
ScriptEngine engine = manager.getEngineByName("js"); 
String [] nom_despiece = new String[50];
String [] cod_despiece_mate = new String[50];
String[] funcion = new String[50];
Object [] resultado = new Object[50];
String[] can_dpc = new String[1000];
//String sis_dpc;
String []cod = new String[1000];
String [] alto = new String[1000];
String []ancho = new String[1000];






     try {
         //Captura una fila de la tabla 
     int fila = tblCotizaciones.getSelectedRow();
     String codi ="";
     //Valida la seleccion de la tabla
     if(fila == -1){
     JOptionPane.showMessageDialog(null, "Por favor seleccione un registro de la tabla","Cotizacion",JOptionPane.WARNING_MESSAGE);
     }
     else{
       codi = tblCotizaciones.getValueAt(fila,0).toString();
      //Consulta los productos de la cotizacion. 
      cot.MtdBuscarProductoCotizacion(Integer.parseInt(codi));
     int i = 0;
     int val = 0;
      while(cot.datoscot.next() == true){
      //Se obtiene el valor de cada registro de la consulta
        cod[i] = cot.datoscot.getString(1);
        ancho[i] = cot.datoscot.getString(2);
        alto[i] =cot.datoscot.getString(3);
        i = i+1;
        //Se consulta si ya hay productos despiezados
        cot.MtdConsultarProducto_despiece(Integer.parseInt(cot.datoscot.getString(1)));
        if(cot.datoscot.next()){
            val = 1;
        }

      }
      //valida que no hay productos despiezados.
      if(val == 0){
        //GENERAR DESPIECE
        //Se traen los datos del despice ligado al producto
       for (int k = 0; k<i; k++){
        int j=0;
         cot.MtdDespiecesCotizacion(Integer.parseInt(cod[k]));
         while(cot.datoscot.next()){
         nom_despiece[j] = cot.datoscot.getString(2);
         funcion[j] = cot.datoscot.getString(5);
         can_dpc[j] = cot.datoscot.getString(6);
         cod_despiece_mate[j] = cot.datoscot.getString(7);
         //se valida la formula reemplazando valores
         if(funcion[j].contains("alto")){
         funcion[j] = funcion[j].replaceAll("alto", alto[k]);
         }
         else if(funcion[j].contains("ancho")){
         funcion[j] = funcion[j].replaceAll("ancho", ancho[k]);
         }
         else{
         JOptionPane.showMessageDialog(null, "NO HAY NADA");
         }
         //se guarda el resultado de la cada formula del despiece
         resultado[j] = engine.eval(funcion[j]);
           
           System.out.println("Producto numero: "+k+"  "+nom_despiece[j]+": "+funcion[j]+"   "+resultado[j]+"---"+can_dpc[j]+"---"+ j);
           cot.MtdAgregarDespieceProducto(Integer.parseInt(cot.datoscot.getString(1)),Integer.parseInt(cod[k]),String.valueOf(resultado[j]),can_dpc[j]);

            j= j+1;
            //Se guarda el valor de cada despiece del producto con su respectivo producto
        }
      
       }
       //Se trae el metodo para visualizar el despiece
         JMostrarDespieces(Integer.parseInt(codi));}
      //Valida si hay productos despiezados y visualiza los despieces.
      else if (val ==1){
          
      JMostrarDespieces(Integer.parseInt(codi));
      }

     }
     }
     catch (Exception e) {
         System.out.println("Error al despiezar producto en formulario cotizacion: "+e.getLocalizedMessage());
     }
 
 
 }
 public String JObtenerfecha(){
    Date objDate = new Date();
    String strDateFormat = "  dd-MMM-yyyy hh: mm: ss a";
    SimpleDateFormat objDSF = new SimpleDateFormat(strDateFormat);
    String fecha = objDSF.format(objDate);
     
    return fecha;
 
    }
 
 
 
     
   
 
 
 //Validacion de campos sin numeros
 public void soloDigitos(KeyEvent evt){
        Character n;
        n= evt.getKeyChar();
        if(!Character.isDigit(n) && (int)evt.getKeyChar()!=46){
            evt.consume();}
        }
 //validacion de campos con numeros
 public void JSoloLetras(KeyEvent evt){
    Character n;
    n = evt.getKeyChar();
    if(!Character.isAlphabetic(n)){
    evt.consume();
    }
 
 
 }
 
 //FORMULARIO DESPIECE
 
 public void JGuardarDespiece(){
 if(txtDescDpc.getText().length()==0){
 JOptionPane.showMessageDialog(null, "ingrese la descripcion del despiece","Despiece",JOptionPane.WARNING_MESSAGE);
 }
 else if(txtSisDpc.getText().length()==0){
  JOptionPane.showMessageDialog(null, "ingrese el sistema del despiece","Despiece",JOptionPane.WARNING_MESSAGE);
 }
 else if(txtRefDpc.getText().length()==0){
  JOptionPane.showMessageDialog(null, "ingrese la referencia del despiece","Despiece",JOptionPane.WARNING_MESSAGE);
 }
 else if(txtForDpc.getText().length()==0){
  JOptionPane.showMessageDialog(null, "ingrese la formula del despiece","Despiece",JOptionPane.WARNING_MESSAGE);
 }
 else if(txtCanDpc.getText().length()==0){
  JOptionPane.showMessageDialog(null, "ingrese la cantidad del despiece","Despiece",JOptionPane.WARNING_MESSAGE);
 }
 else if(txtCodDpc.getText().length()==0){
  JOptionPane.showMessageDialog(null, "ingrese el codigo para despiezar","Despiece",JOptionPane.WARNING_MESSAGE);
 }
 else{
     try {
       dpc.MtdGuatdarDespiece(txtDescDpc.getText(), txtSisDpc.getText(), txtRefDpc.getText(), JObtenerfecha(),txtForDpc.getText(), txtCanDpc.getText(), txtCodDpc.getText());
      JOptionPane.showMessageDialog(null, "Se a guardado con exito","Despiece",JOptionPane.WARNING_MESSAGE);
     } catch (Exception e) {
         System.out.println("Error al guardar despice el formulario cotizacion: "+e.getLocalizedMessage());
     }
 
 }
 }
 
  public void JActualizarDespiece(){
 if(txtDescDpc.getText().length()==0){
 JOptionPane.showMessageDialog(null, "ingrese la descripcion del despiece","Despiece",JOptionPane.WARNING_MESSAGE);
 }
 else if(txtSisDpc.getText().length()==0){
  JOptionPane.showMessageDialog(null, "ingrese el sistema del despiece","Despiece",JOptionPane.WARNING_MESSAGE);
 }
 else if(txtRefDpc.getText().length()==0){
  JOptionPane.showMessageDialog(null, "ingrese la referencia del despiece","Despiece",JOptionPane.WARNING_MESSAGE);
 }
 
 else if(txtForDpc.getText().length()==0){
  JOptionPane.showMessageDialog(null, "ingrese la formula del despiece","Despiece",JOptionPane.WARNING_MESSAGE);
 }
 else if(txtCanDpc.getText().length()==0){
  JOptionPane.showMessageDialog(null, "ingrese la cantidad del despiece","Despiece",JOptionPane.WARNING_MESSAGE);
 }
 else if(txtCodDpc.getText().length()==0){
  JOptionPane.showMessageDialog(null, "ingrese el codigo para despiezar","Despiece",JOptionPane.WARNING_MESSAGE);
 }
 else{
     try {
         dpc.MtdActualizarDespiece(txtDescDpc.getText(), txtSisDpc.getText(), txtRefDpc.getText(), JObtenerfecha(),txtForDpc.getText(), txtCanDpc.getText(), txtCodDpc.getText(),Integer.parseInt(txtCodDpc1.getText()));
           JOptionPane.showMessageDialog(null, "Se a actualizado con exito","Despiece",JOptionPane.WARNING_MESSAGE);

     } catch (Exception e) {
         System.out.println("Error al actualizar despice el formulario cotizacion: "+e.getLocalizedMessage());
     }
 
 }
 }
  
  public void JEliminarDespiece(){
      int fila = tbDespiece.getSelectedRow();
      String id;
 if(fila ==-1){
 JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla despiece","Despiece",JOptionPane.WARNING_MESSAGE);
 }
 else{
      try {
          int eli = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar este despiece? ", "Despiece",0, JOptionPane.WARNING_MESSAGE);
          if(eli == 0){
              id = tbDespiece.getValueAt(fila,0).toString();
              dpc.MtdEliminarDespiece(Integer.parseInt(id));
                JOptionPane.showMessageDialog(null, "Se a eliminado con exito","Despiece",JOptionPane.WARNING_MESSAGE);}
          else if(eli == 1){
              JOptionPane.showMessageDialog(null, "Operacion cancelada ","Despiece",JOptionPane.INFORMATION_MESSAGE);
          }
          else{JOptionPane.showMessageDialog(null, "Operacion cancelada","CLIENTE",JOptionPane.INFORMATION_MESSAGE);}
         

      } catch (Exception e) {
          System.out.println("Error al eliminar despice el formulario cotizacion: "+e.getLocalizedMessage());
      }}
}
   public void JCrearTablaDespiece(){
Object datos[][]= new Object[0][0];
Object []titulos={"Codigo","Descripcion","Sistema","Referencia","Fecha","Formula","Cantidad","Codigo_despiece_material",};
tablaDpc= new DefaultTableModel();
tablaDpc=new DefaultTableModel(datos,titulos);
tbDespiece.setModel(tablaDpc);
}
   public void JLlenartablaDespiece(){
     dpc.MtdListarDespiece();
   Object [] datos = new Object[8];
     try {
         while(dpc.datosdpc.next()){
             for(int i = 0; i<8; i++){
                 datos[i] = dpc.datosdpc.getObject(i+1);
                 }
             tablaDpc.addRow(datos);
             
         }
     } catch (Exception e) {
         System.out.println("Error al llenar tabla cliente en Jdialog Cliente"+ e.getLocalizedMessage());
     }
 }
   public void JVerDespiece(){
  
  int fila = tbDespiece.getSelectedRow();   
  String cod, des, sis, ref, form,can,cod_dpc;
  DefaultTableModel f = (DefaultTableModel) tbDespiece.getModel();
  
     try {
         if(fila ==-1){
      JOptionPane.showMessageDialog(null, "Debe seleccionar un despiece","Despiece",JOptionPane.WARNING_MESSAGE);
  }
  
  cod = tbDespiece.getValueAt(fila, 0).toString();
  des = tbDespiece.getValueAt(fila, 1).toString();
  sis = tbDespiece.getValueAt(fila, 2).toString();
  ref = tbDespiece.getValueAt(fila, 3).toString();
  form = tbDespiece.getValueAt(fila, 5).toString();
  can = tbDespiece.getValueAt(fila, 6).toString();
  cod_dpc = tbDespiece.getValueAt(fila, 7).toString();
  txtCodDpc1.setText(cod);
  txtDescDpc.setText(des); 
  txtSisDpc.setText(sis);
  txtRefDpc.setText(ref);
  txtForDpc.setText(form);
  txtCanDpc.setText(can);
  txtCodDpc.setText(cod_dpc);
  
     } catch (Exception e) {
         System.out.println("Error al mostrar el despiece en formulario cotizacion: "+e.getLocalizedMessage());
     }
  
 }
   public void JLimpiarFormulario(JPanel panel){
       for(int i = 0; panel.getComponents().length>i;i++){
           if( panel.getComponents()[i]instanceof JComboBox ){
               ((JComboBox)panel.getComponents()[i]).setSelectedItem("Seleccione");
               
           }
             /*else if(panel.getComponents()[i]instanceof JLabel){
               ((JLabel)panel.getComponents()[i]).setText("");
           }*/
             else if(panel.getComponents()[i]instanceof JCheckBox){
                boolean state = false;
               ((JCheckBox)panel.getComponents()[i]).setSelected(state);
           }
             else if( panel.getComponents()[i] instanceof JPasswordField){
                  ((JPasswordField)panel.getComponents()[i]).setText("");
       }
             else if(panel.getComponents()[i]instanceof JTextField){
                  ((JTextField)panel.getComponents()[i]).setText("");
                  
       }
       }
       
   }
   public void JCrearTablaCotizacion(){
       Object [][] datos = new Object[0][0];
       Object [] titulos = {"Codigo","Descripcion","Fecha","id Cliente","Nombre Cliente","SubTotal","IVA","Total"};
       tablaCot = new DefaultTableModel(datos,titulos);
       tblCotizaciones.setModel(tablaCot);
   }
   public void JLlenarTablaCotizacion(){
   Object [] fila = new Object[8];
   
       try {
           cot.MtdListarCotizacion();
        
           while(cot.datoscot.next()){
               for(int i = 0; i<8;i++){
               fila[i] = cot.datoscot.getObject(i+1);
            }
           tablaCot.addRow(fila);
           }
          
       } catch (Exception e) {
           System.out.println("Error al llenar tabla cotizacion en formulario cotizacion: "+e.getLocalizedMessage());
       }
   
   
   }
   
   //mostrar el reporte de la cotizacion
   public void JMostrarReporteCotizacion(int cod_cot){
   try{
    //Establecer la conexion
    ClsConexionReporte con = new ClsConexionReporte(); 
    Connection conx = con.getConnection();
    //obtener la ruta del reporte
    String path =System.getProperty("user.dir")+ "/src/Reportes/cotizacion.jasper"; 
   
     //JasperReport reporte = JasperCompileManager.compileReport(path);
     //Establecer el parametro para filtrar el reporte
     Map parametro  = new HashMap();
     parametro.put("cod_cot",cod_cot);
     //castear la ruta a tipo jasperReport
     JasperReport reporte =  (JasperReport) JRLoader.loadObjectFromFile(path);
      //llenar el reporte pasando el parametro y la conexion con la BD    

      JasperPrint jprint = JasperFillManager.fillReport(reporte,parametro,conx);
     //abrir el visor para mostrar el reporte
     JasperViewer view = new JasperViewer(jprint,false);
     view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
     view.setVisible(true);
   }
            
        catch (HeadlessException|JRException e) {
          JOptionPane.showMessageDialog(null,"Error al cargar reporte","Cotizacion",JOptionPane.ERROR_MESSAGE);

            Logger.getLogger(FrmCotizacion.class.getName()).log(Level.SEVERE,null,e);
        }
    
   
    }
   //Mostrar el reporte de despiece
   public void JMostrarReporteDespiece(int cod_cot){
       try{
    //Establecer la conexion
    ClsConexionReporte con = new ClsConexionReporte(); 
    Connection conx = con.getConnection();
    //obtener la ruta del reporte
    String path =System.getProperty("user.dir")+ "/src/Reportes/despiece.jasper"; 
   
     //JasperReport reporte = JasperCompileManager.compileReport(path);
     //Establecer el parametro para filtrar el reporte
     Map parametro  = new HashMap();
     parametro.put("cod_cot",cod_cot);
     //castear la ruta a tipo jasperReport
     JasperReport reporte =  (JasperReport) JRLoader.loadObjectFromFile(path);
      //llenar el reporte pasando el parametro y la conexion con la BD    
     JasperPrint jprint = JasperFillManager.fillReport(reporte,parametro,conx);
     //abrir el visor para mostrar el reporte
     JasperViewer view = new JasperViewer(jprint,false);
     view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
     view.setVisible(true);
   }
            
        catch (JRException e) {
           
            Logger.getLogger(FrmCotizacion.class.getName()).log(Level.SEVERE,null,e);
        }
    

   
   }

   public void JMostrarCotizacion(int cod_cot){
       try {
           cot.MtdConsultarCotizacion(cod_cot);
           if(cot.datoscot.next()){
               lbCod_cot1.setText(cot.datoscot.getString(1));
               lbFec_cot1.setText(cot.datoscot.getString(3));
               lbDes_cot1.setText(cot.datoscot.getString(2));
               lbSub_tot_cot1.setText("$ "+cot.datoscot.getString(5));
               lbIva_cot1.setText("$ "+cot.datoscot.getString(4));
               lbTot_cot1.setText("$ "+cot.datoscot.getString(6));
               lbId_cli1.setText(cot.datoscot.getString(7));
               lbNom_cli1.setText(cot.datoscot.getString(8));
               lbApe_cli1.setText(cot.datoscot.getString(9));
               lbTel_cli1.setText(cot.datoscot.getString(10)+" - "+cot.datoscot.getString(11));
           } 
           else{
           JOptionPane.showMessageDialog(null,"la consulta esta vacia" ,"Cotizacion",JOptionPane.WARNING_MESSAGE);
           }
           //Se crea el modelo de la tabla cotizacion
           Object [][] datos = new Object [0][0];
           String [] titulos = {"codigo","Descripcion","Cantidad","Valor unitario","Precio Total"};
           DefaultTableModel mc = new DefaultTableModel(datos,titulos);
           tblPro_cot.setModel(mc);
           //Se Traen los datos de la consulta
           cot.MtdConsultarProducto_cotizacion(cod_cot);
           //Se llena la tabla con los datos
           String [] dato = new String[5];
           while(cot.datoscot.next()){
            for(int i=0; i<5;i++){
               dato[i] = cot.datoscot.getString(i+1); 
            }
            mc.addRow(dato);
           }
           MostrarCotizacion.setBounds(500, 0, 805, 700);
           MostrarCotizacion.setVisible(true);
       } catch (Exception e) {
            System.out.println("Error al llenar tabla de productos en JDialog MostrarCotizacion: "+e.getLocalizedMessage());
       }
   
   }
   
   public void JMostrarDespieces(int cod_cot){
       try {
           //Se crea el modelo de la tabla cotizacion
           Object [][] datos = new Object [0][0];
           String [] titulos = {"codigo","Descripcion","Cantidad","Valor unitario","Precio Total"};
           DefaultTableModel mc = new DefaultTableModel(datos,titulos);
           tblPro_Despiece.setModel(mc);
           //Se Traen los datos de la consulta
           cot.MtdConsultarProducto_cotizacion(cod_cot);
           //Se llena la tabla con los datos
           String [] dato = new String[5];
           while(cot.datoscot.next()){
            for(int i=0; i<5;i++){
               dato[i] = cot.datoscot.getString(i+1); 
            }
            mc.addRow(dato);
           }
           //Se llama al metodo que crea el modelo de la tabla.
           JCrearTablaDespieces();
        
          //Se abre el JDialog MostrarDespiece
          MostrarDespiece.setBounds(400,0,912, 610);
          MostrarDespiece.setVisible(true);
       } catch (Exception e) {
            System.out.println("Error en despiece en JDialog MostrarDespiece: "+e.getLocalizedMessage());
       }
   
   }
   public void JCrearTablaDespieces(){
    //Se crea el modelo de la tabla
          Object [][] datos1 = new Object [0][0];
          String [] titulos1 = {"Codigo","Descripcion","Cantidad","Medida"};
          dp = new DefaultTableModel(datos1,titulos1);
          tblMostrarDespiece.setModel(dp);
   }
   public void JVisualizarDespiece(){
   int fila = tblCotizaciones.getSelectedRow();
        if(fila == -1){
        JOptionPane.showMessageDialog(null, "Seleccione una cotizacion de la tabla","Cotizacion",JOptionPane.WARNING_MESSAGE);
        }
        else{
        int cod = Integer.parseInt(tblCotizaciones.getValueAt(fila,0).toString());
            JMostrarDespieces(cod);
            Cotizaciones.setVisible(false);
            
        }
   }
   public void JVisualizarCotizacion(){
       
       
         int reg = tblCotizaciones.getSelectedRow();
        if(reg ==-1){
        JOptionPane.showMessageDialog(null, "Seleccione una cotizacion de la tabla","Cotizacion",JOptionPane.WARNING_MESSAGE);
        }
        else{
        int cod = Integer.parseInt(tblCotizaciones.getValueAt(reg,0).toString());
            JMostrarCotizacion(cod);
            Cotizaciones.setVisible(false);
            }
       
        }
   
   public void JRealizarCotizacion(){
   //Cotizar y mostrar cotizacion
       try {
        
        //valida que hay insumos para cotizar los productos
        if (JAgregarInsumoCotizacion()==1){
        
       JObtenerfecha();
        cot.MtdInsertarCotizacion(txtDesCot.getText(), JObtenerfecha(), txtIdCli.getText());
        //realiza la cotizacion de los productos
        JCotizar();
        JCrearTablaProductoCotizacion();
        JCrearTablaInsumosCotizacion();
        // visualiza la cotizacion
         try {
        //Se trae el codigo de la ultima cotizacion        
        cot.MtdTraerCodCotizacion();
        //se valida si hay datos en la BD
        if(cot.datoscot.next()){
        int codi = cot.datoscot.getInt(1);
        //Se ingresa como parametro el codigo de la cotizacion 
        //Se llama el metodo para mostrar la cotizacion
        JMostrarCotizacion(codi);
        }

            } catch (Exception e) {
                System.out.println("Error al mostrar reporte cotizacion"+e.getLocalizedMessage());
            }
         JLimpiarFormulario(PnlCliente);
          JLimpiarFormulario(PnlCotizacion);
         }
        
           
        } catch (Exception e) {
            System.out.println("Error al agregar insumo en formulario cotizacion: " +e.getLocalizedMessage());
        }
   
   }

   
  ///IMPRIMIR COTIZACIONES
    public void JGenerarReporte(){

try{ 
FileWriter archivo = new FileWriter("reporte_cotizacion.html"); 

PrintWriter escritura = new PrintWriter(archivo);
System.out.println(lbCod_cot1.getText());

//escribimos un archivo de texto con la estructura de html

escritura.println("<html>");
escritura.println("<title>Reporte Cotizacion</title>");
escritura.println(" <body onload='window.print()'><div style='margin:0 auto;border:1px solid #000;width:900px;padding:20px;box-sizing:border-box;'>");

escritura.println(" <h1><center>COTIZACIÓN </center></h1>");
//Consultamos los datos de la cotizacion
 cot.MtdDatosCotizacion(Integer.parseInt(lbCod_cot1.getText()));
 if(cot.datoscot.next()){
escritura.println("<p align = 'right'><b>Fecha: </b>&nbsp"+this.JObtenerfecha()+"</p>");     
escritura.println("<p><b>Codigo:</b>&nbsp;"+cot.datoscot.getString(1)+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Descripcion:</b>&nbsp;"+cot.datoscot.getString(2)+"</p>");
escritura.println("<h3><b>CLIENTE</b></h3>");
escritura.println("<p><b>Identificacion:</b>&nbsp;"+cot.datoscot.getString(7)+"</p>");
escritura.println("<p><b>Nombre:</b>&nbsp;&nbsp;"+cot.datoscot.getString(8)+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Apellido:</b>&nbsp;&nbsp;"+cot.datoscot.getString(9)+" </p>");
escritura.println("<p><b>Telefonos:</b>&nbsp"+cot.datoscot.getString(12)+" - "+cot.datoscot.getString(13)+" </p>");
escritura.println("<h3><b>PRODUCTOS</b></h3>");
escritura.println("<table width='100%' style='border:1px solid #000'>"+
                  "<tr><td  ><h3><b>CODIGO</b></h3></td><td ><h3><b>DESCRIPCION</b></h3></td><td ><h3><b>CANTIDAD</b></h3></td><td  ><h3><b>VALOR UNITARIO</b></h3></td><td  ><h3><b>PRECIO TOTAL</b></h3></td></tr>");

escritura.println(JDatosProducto());}
escritura.println("</table>");

cot.datoscot.beforeFirst();
if(cot.datoscot.next()){

escritura.println("<p><FONT SIZE = 5><b>SUBTOTAL $</b>&nbsp;&nbsp;"+cot.datoscot.getString(4)+"</font></p><p><FONT SIZE = 5><b>IVA $</b>&nbsp;&nbsp;"+cot.datoscot.getString(5)+"</font></p><p><FONT SIZE = 5><b>TOTAL $&nbsp;&nbsp;</b>"+cot.datoscot.getString(6)+"</font></p>");}

escritura.println("</div></body>");
escritura.println("</html>");
 
//nos aseguramos de cerrar el archivo
archivo.close();
 Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+System.getProperty("user.dir")+ "\\reporte_cotizacion.html");

} catch(Exception e){
JOptionPane.showMessageDialog(null,"error al generar reporte: " +e.getLocalizedMessage());
}}
        
   public String JDatosProducto(){
       String datos = "";
       try {
            cot.MtdDatosCotizacion(Integer.parseInt(lbCod_cot1.getText()));
           while(cot.datoscot.next()){
             datos+="<tr><td><FONT SIZE = 4>"+cot.datoscot.getString(14)+"</font></td><td ><FONT SIZE = 4>"+cot.datoscot.getString(15)+"</font></td><td ><FONT SIZE = 4><center>"+cot.datoscot.getString(16)+"</center></font></td><td  ><FONT SIZE = 4>"+cot.datoscot.getString(17)+"</font></td><td  ><FONT SIZE = 4>"+cot.datoscot.getString(18)+"</font></td></tr>";
            }   
       } catch (Exception e) {
           System.out.println("Error al mostrar datos de los productos: "+e.getLocalizedMessage());
       }
    
       return datos;
   }
   public String JDatosDespiece( int fila){
   String datos = "";
       try {
          
          String cod_pro = tblPro_Despiece.getValueAt(fila ,0).toString();
          cot.MtdConsultarProducto_despiece(Integer.parseInt(cod_pro));
          while(cot.datoscot.next()){
             datos+="<tr><td><FONT SIZE = 4>"+cot.datoscot.getString(1)+"</font></td><td ><FONT SIZE = 4>"+cot.datoscot.getString(2)+"</font></td><td ><center><FONT SIZE = 4>"+cot.datoscot.getString(3)+"</font></center></td><td  ><FONT SIZE = 4>"+cot.datoscot.getString(4)+"</font></td></tr>";
            }  
        
       } catch (Exception e) {
       }
   
   return datos;
   }
   
    public void JGenerarReporteDespiece(){

try{ 
FileWriter archivo = new FileWriter("reporte_despiece.html"); 

PrintWriter escritura = new PrintWriter(archivo);
int filaPro = tblPro_Despiece.getSelectedRow();
if(filaPro == -1){
JOptionPane.showMessageDialog(null, "Seleccione un producto de la tabla de productos","Despiece",JOptionPane.WARNING_MESSAGE);
}
else{


//escribimos un archivo de texto con la estructura de html

escritura.println("<html>");
escritura.println("<title>Reporte Despiece</title>");
escritura.println(" <body onload='window.print()'><div style='margin:0 auto;border:1px solid #000;width:900px;padding:20px;box-sizing:border-box;'>");

escritura.println(" <h1><center>DESPIECE</center></h1>");
//Consultamos los datos de la cotizacion
 //cot.MtdDatosCotizacion(Integer.parseInt(lbCod_cot1.getText()));
 //if(cot.datoscot.next()){
escritura.println("<p align = 'right'><b>Fecha: </b>&nbsp"+this.JObtenerfecha()+"</p>");     
escritura.println("<h2><u><b>PRODUCTO</b></u></h3>");
escritura.println("<p><FONT SIZE = 5><b>Codigo:</b>&nbsp;&nbsp;"+tblPro_Despiece.getValueAt(filaPro,0).toString()+"</font> </p>");
escritura.println("<p><FONT SIZE = 5><b>Descripcion:</b>&nbsp;&nbsp;"+tblPro_Despiece.getValueAt(filaPro,1).toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Cantidad:</b>&nbsp;&nbsp;"+tblPro_Despiece.getValueAt(filaPro,2).toString()+" </font></p>");
escritura.println("<h2><u><b>DESPIECE</b></u></h3>");
escritura.println("<table width='100%' style='border:1px solid #000'>"+
                  "<tr><td  ><h3><b>CODIGO</b></h3></td><td ><h3><b>DESCRIPCION</b></h3></td><td ><h3><b>CANTIDAD</b></h3></td><td  ><h3><b>MEDIDA</b></h3></td></tr>");

escritura.println(JDatosDespiece(filaPro));
escritura.println("</table></div></body>");
escritura.println("</html>");
 
//nos aseguramos de cerrar el archivo
archivo.close();
 Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+System.getProperty("user.dir")+ "\\reporte_despiece.html");
}
} catch(Exception e){
JOptionPane.showMessageDialog(null,"error al generar reporte: " +e.getLocalizedMessage());
}}

   }
   




   
