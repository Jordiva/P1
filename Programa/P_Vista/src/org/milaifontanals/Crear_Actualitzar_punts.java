/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package org.milaifontanals;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import java.awt.Color;

import p_interficiepersistencia.GestorBDExceptionTOT;

/**
 *
 * @author jordi
 */
public class Crear_Actualitzar_punts extends javax.swing.JFrame {



    BDGeneral BD;
    JTable JTablePunts;
    int ID_ruta;
    int num_punt;

    public Crear_Actualitzar_punts() {
        initComponents();
        setLocationRelativeTo(null);

    }

    public Crear_Actualitzar_punts(Punts punt , BDGeneral bd , int id_ruta,JTable JTablePunts) {
        initComponents();
        BD = bd;
        ID_ruta = id_ruta;
        this.JTablePunts = JTablePunts;
        OmplirCmbTipus();
        num_punt = punt.getNumPunt();
        OmplaInfodePunt(punt);
        setLocationRelativeTo(null);

    }


    public void OmplaInfodePunt(Punts punt) {
        txtNom.setText(punt.getNom());
        txtDescripcio.setText(punt.getDescripcio());
        txtLat.setText(Float.toString(punt.getLatitud()));
        txtLong.setText(Float.toString(punt.getLongitud()));
        txtAlti.setText(Float.toString(punt.getAltitud()));
        cmbTipus.setSelectedIndex(punt.getId_tipus() - 1);
    }


    /** Creates new form Crear_Actualitzar_punts */
    public Crear_Actualitzar_punts(BDGeneral bd , int id_ruta,JTable JTablePunts) {
        initComponents();
        BD = bd;
        ID_ruta = id_ruta;
        this.JTablePunts = JTablePunts;
        OmplirCmbTipus();
        setLocationRelativeTo(null);

    }



    private void OmplirCmbTipus() {
        cmbTipus.removeAllItems();
        try {
            List<Tipus> llistaTipus = BD.geTipusllista();
            for (Tipus tipus : llistaTipus) {
                cmbTipus.addItem(tipus.getNom());
            }
        } catch (GestorBDExceptionTOT | ExceptionTOT e) {
            e.printStackTrace();
            System.out.println("Error al omplir el cmbTipus");
        }
    }



    private Boolean FetNom = true;
    private Boolean FetDescripcio = true;
    private Boolean FetLat = true;
    private Boolean FetLong = true;
    private Boolean FetAlti = true;


    boolean isInteger(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    boolean isFloat(String text) {
        try {
            Float.parseFloat(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        btnActualitar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        cmbTipus = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcio = new javax.swing.JTextPane();
        txtLat = new javax.swing.JTextField();
        txtLong = new javax.swing.JTextField();
        txtAlti = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnActualitar.setText("Actualitzar");
        btnActualitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualitarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        cmbTipus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Nom:");

        jLabel2.setText("Descripcio:");

        jLabel3.setText("Latitud:");

        jLabel4.setText("Longitud:");

        jLabel5.setText("Altitud:");

        txtNom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomKeyReleased(evt);
            }
        });

        txtDescripcio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcioKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcio);

        txtLat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLatKeyReleased(evt);
            }
        });

        txtLong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLongKeyReleased(evt);
            }
        });

        txtAlti.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAltiKeyReleased(evt);
            }
        });

        jLabel6.setText("Tipus");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(54, 54, 54))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCrear)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(66, 66, 66)
                        .addComponent(btnActualitar)
                        .addGap(59, 59, 59))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLat, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLong, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAlti, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTipus, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cmbTipus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txtAlti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualitar)
                    .addComponent(btnCancelar)
                    .addComponent(btnCrear))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualitarActionPerformed


        JOptionPane.showConfirmDialog(null, "Estas segur que vols actualitzar el punt?");

        if(JOptionPane.YES_OPTION == 0){
            if(FetNom && FetDescripcio && FetLat && FetLong && FetAlti){
            try {
                String nom = txtNom.getText();
                String descripcio = txtDescripcio.getText();
                int latitud = Integer.parseInt(txtLat.getText());
                int longitud = Integer.parseInt(txtLong.getText());
                int altitud = Integer.parseInt(txtAlti.getText());
                int tipus = cmbTipus.getSelectedIndex()+1;

                Punts punt = new Punts( num_punt , ID_ruta, tipus, nom, descripcio, null, latitud, longitud, altitud);

                Boolean fet = BD.modificarPunt(punt);

                if(fet){
                    JOptionPane.showMessageDialog(null, "Punt actualitzat correctament");
                    this.setVisible(false);
                    //JTablePunts.setModel());
                    RutesUsuari.getPunts();

                    BD.validarCanvis();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Error al actualitzar el punt");
                }

            } catch (GestorBDExceptionTOT | ExceptionTOT e) {
                e.printStackTrace();
                System.out.println("Error al actualitzar el punt");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Falten camps per omplir");
        }
        }
        
        
    }//GEN-LAST:event_btnActualitarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        this.setVisible(false);

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed

        JOptionPane.showConfirmDialog(null, "Estas segur que vols crear el punt?");

        if(JOptionPane.YES_OPTION == 0){
            if(FetNom && FetDescripcio && FetLat && FetLong && FetAlti){
            try {
                String nom = txtNom.getText();
                String descripcio = txtDescripcio.getText();
                int latitud = Integer.parseInt(txtLat.getText());
                int longitud = Integer.parseInt(txtLong.getText());
                int altitud = Integer.parseInt(txtAlti.getText());
                int tipus = cmbTipus.getSelectedIndex()+1;

                Punts punt = new Punts( num_punt ,ID_ruta, tipus, nom, descripcio, null, latitud, longitud, altitud);

                Boolean fet = BD.afagirPunt(punt);

                if(fet){
                    JOptionPane.showMessageDialog(null, "Punt creat correctament");
                    this.setVisible(false);
                    //JTablePunts.setModel());
                    RutesUsuari.getPunts();

                    BD.validarCanvis();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Error al crear el punt");
                }

            } catch (GestorBDExceptionTOT | ExceptionTOT e) {
                e.printStackTrace();
                System.out.println("Error al crear el punt");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Falten camps per omplir");
        }
        }

    }//GEN-LAST:event_btnCrearActionPerformed

    private void txtNomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomKeyReleased
        // TODO add your handling code here:
        
        FetNom = txtNom.getText().length() > 0;
        if(!FetNom)
            txtNom.setBackground(Color.RED);
        else
            txtNom.setBackground(Color.WHITE);
        

    }//GEN-LAST:event_txtNomKeyReleased

    private void txtDescripcioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcioKeyReleased
        // TODO add your handling code here:


        FetDescripcio= txtDescripcio.getText().length() > 0;
        if(!FetDescripcio)
            txtDescripcio.setBackground(Color.RED);
        else
            txtDescripcio.setBackground(Color.WHITE);
        

    }//GEN-LAST:event_txtDescripcioKeyReleased

    private void txtLatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLatKeyReleased
        // TODO add your handling code here:
    
        FetLat = isFloat(txtLat.getText());
        if(!FetLat)
            txtLat.setBackground(Color.RED);
        else
            txtLat.setBackground(Color.WHITE);


    }//GEN-LAST:event_txtLatKeyReleased

    private void txtLongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLongKeyReleased
        // TODO add your handling code here:

        FetLong = isFloat(txtLong.getText());
        if(!FetLong)
            txtLong.setBackground(Color.RED);
        else
            txtLong.setBackground(Color.WHITE);


    }//GEN-LAST:event_txtLongKeyReleased

    private void txtAltiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAltiKeyReleased
        // TODO add your handling code here:

        FetAlti = isFloat(txtAlti.getText());
        if(!FetAlti)
            txtAlti.setBackground(Color.RED);
        else
            txtAlti.setBackground(Color.WHITE);


    }//GEN-LAST:event_txtAltiKeyReleased

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
            java.util.logging.Logger.getLogger(Crear_Actualitzar_punts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crear_Actualitzar_punts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crear_Actualitzar_punts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crear_Actualitzar_punts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crear_Actualitzar_punts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualitar;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnCrear;
    private javax.swing.JComboBox<String> cmbTipus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtAlti;
    private javax.swing.JTextPane txtDescripcio;
    private javax.swing.JTextField txtLat;
    private javax.swing.JTextField txtLong;
    private javax.swing.JTextField txtNom;
    // End of variables declaration//GEN-END:variables

}
