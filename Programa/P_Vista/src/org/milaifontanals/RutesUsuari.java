/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.milaifontanals;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import p_interficiepersistencia.GestorBDExceptionTOT;

/**
 *
 * @author jordi
 */
public class RutesUsuari extends javax.swing.JFrame {

    /**
     * Creates new form Rutesusuari
     */

    private List<Ruta> ruteList = null;
    
   public RutesUsuari() {
        initComponents();
    }
    
    private BDGeneral BD;
    
    public RutesUsuari(String usuari , BDGeneral BD) {
        this.BD = BD;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("WikiLoc - Rutes de l'usuari " + usuari);    
        OmpleInfoUsuari(usuari); 
    }


    private void OmpleInfoUsuari(String usuari) {
        
        try {
            ruteList = BD.getRutesDelUsuari(usuari);
        
            String[] columnes = {"Titol", "Descripcio", "Distancia", "Temps", "Data Creacio ", "Dificultat", "Valoracio Mitjana"};
            String[][] dades = new String[ruteList.size()][columnes.length];
            int i = 0;
            for (Ruta ruta : ruteList) {
                dades[i][0] = ruta.getTitol();
                dades[i][1] = ruta.getDescripcio();
                dades[i][2] = String.valueOf(ruta.getDistancia());
                dades[i][3] = String.valueOf(ruta.getTemps());
                dades[i][4] = String.valueOf(ruta.getDataCreacio());
                dades[i][5] = String.valueOf(ruta.getDificultat());
                dades[i][6] = String.valueOf(ruta.getValoracioMitjana());
                i++;
            }
            tablaRutes.setModel(new javax.swing.table.DefaultTableModel(dades, columnes));
            
            tablaRutes.setDefaultEditor(Object.class, null);
            //que solo se pueda seleccionar una fila
            tablaRutes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        
        } catch (GestorBDExceptionTOT | ExceptionTOT e) {
            
            e.printStackTrace();
        }
        
        
        
        LbelUsuario.setText(usuari);

        BtnBorra.setEnabled(false);
        BntActualitzar.setEnabled(false);


    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LbelUsuario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRutes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        BtnCrear = new javax.swing.JButton();
        BntActualitzar = new javax.swing.JButton();
        BtnBorra = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablepunts = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        BtnBuscar = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        lbBusqueda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LbelUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LbelUsuario.setText("jLabel1");

        tablaRutes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaRutes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRutesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaRutes);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Crud-Ruta"));

        BtnCrear.setText("Crear Ruta");
        BtnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCrearActionPerformed(evt);
            }
        });

        BntActualitzar.setText("Actualitzar Ruta");
        BntActualitzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BntActualitzarActionPerformed(evt);
            }
        });

        BtnBorra.setText("Borrar Ruta");
        BtnBorra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBorraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(BtnBorra))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(BtnCrear)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addComponent(BntActualitzar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(BtnCrear)
                .addGap(45, 45, 45)
                .addComponent(BntActualitzar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(BtnBorra)
                .addGap(27, 27, 27))
        );

        tablepunts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablepunts);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Busqueda"));

        BtnBuscar.setText("Buscar");

        jLabel1.setText("Nom / Titol");

        jLabel2.setText("Data de Creacio");

        jLabel3.setText("Entre");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnBuscar)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(42, 42, 42)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(311, 311, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LbelUsuario)
                .addGap(8, 8, 8)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCrearActionPerformed
        // TODO add your handling code here:

     

        



    }//GEN-LAST:event_BtnCrearActionPerformed

    private void BntActualitzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BntActualitzarActionPerformed
        // TODO add your handling code here:



        int fila = tablaRutes.getSelectedRow();

        String nomruta = tablaRutes.getValueAt(fila, 0).toString();
        
        for (Ruta ruta : ruteList) {
            if (ruta.getTitol().equals(nomruta)){
                Creacio_Actualitzar_Ruta r = new Creacio_Actualitzar_Ruta(ruta,BD,tablaRutes);
                r.setVisible(true);
                r.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                r.btnCrear.setEnabled(false);
                r.setTitle("Actualitzador");
            }
        }

    }//GEN-LAST:event_BntActualitzarActionPerformed

    private void BtnBorraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBorraActionPerformed
        
        int fila = tablaRutes.getSelectedRow();
        int id = ruteList.get(fila).getId_Ruta();
        String nom = ruteList.get(fila).getTitol();

        System.out.println( fila+"-"+id+"-"+nom);
    
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea borrar este elemento?", "Confirmación", JOptionPane.YES_NO_OPTION);

        try {
            if(respuesta == JOptionPane.YES_OPTION){
                boolean fet = BD.borraRuta(id, LbelUsuario.getText());
                if (fet) {
                    JOptionPane.showMessageDialog(this, "Ruta borrada correctament");
                    BD.validarCanvis();
                    tablaRutes.clearSelection();
                    OmpleInfoUsuari(LbelUsuario.getText());
                    //borrar el contingut de la tabla dels punt 
                    
                    DefaultTableModel tableModel = (DefaultTableModel) tablepunts.getModel();
                    tableModel.setRowCount(0);

                    tablepunts.revalidate();
                    tablepunts.repaint();
                }
                else{
                    JOptionPane.showMessageDialog(this, "No s'ha pogut borrar la ruta");
                }
            }
        } catch (GestorBDExceptionTOT | ExceptionTOT e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BtnBorraActionPerformed

    
    private void tablaRutesMouseClicked(java.awt.event.MouseEvent evt) {                                            
        int fila = tablaRutes.getSelectedRow();

        String nomruta = tablaRutes.getValueAt(fila, 0).toString();
        
        for (Ruta ruta : ruteList) {
            if (ruta.getTitol().equals(nomruta)){
                fila = ruta.getId_Ruta();
            }
        }

        try {
            List<Punts> punts =  BD.getPuntsDeLaRutaDelUsuari(fila);

            String[] columnes = {"Nom", "Descripcio    ", "Latitud", "Longitud", "Altitud"};

            String[][] dades = new String[punts.size()][columnes.length];
            int i = 0;
            for (Punts punt : punts) {
                dades[i][0] = punt.getNom();
                dades[i][1] = punt.getDescripcio();
                dades[i][2] = String.valueOf(punt.getLatitud());
                dades[i][3] = String.valueOf(punt.getLongitud());
                dades[i][4] = String.valueOf(punt.getAltitud());
                i++;
            }
            
            tablepunts.setModel(new javax.swing.table.DefaultTableModel(dades, columnes));
            tablepunts.setDefaultEditor(Object.class, null);
            tablepunts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        } catch (GestorBDExceptionTOT | ExceptionTOT e) {
            
            e.printStackTrace();
        }
        if (fila == -1) {
            BtnBorra.setEnabled(false);
            BntActualitzar.setEnabled(false);
        }
        else{
            BtnBorra.setEnabled(true);
            BntActualitzar.setEnabled(true);
        }
        
        
    }                                       

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
            java.util.logging.Logger.getLogger(RutesUsuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RutesUsuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RutesUsuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RutesUsuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RutesUsuari().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BntActualitzar;
    private javax.swing.JButton BtnBorra;
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnCrear;
    private javax.swing.JLabel LbelUsuario;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lbBusqueda;
    private javax.swing.JTable tablaRutes;
    private javax.swing.JTable tablepunts;
    // End of variables declaration//GEN-END:variables
}
