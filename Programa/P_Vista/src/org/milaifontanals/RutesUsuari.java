/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.milaifontanals;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    private static List<Ruta> ruteList = null;
    private static List<Punts> puntsList = null;
    private static String usuString;
    
   public RutesUsuari() {
        initComponents();
    }
    
    private static BDGeneral BD;
    
    public RutesUsuari(String usuari , BDGeneral BD) {
        this.BD = BD;
        this.usuString  = usuari;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("WikiLoc - Rutes de l'usuari " + usuari);    
        OmpleInfoUsuari(usuari);
        try {
            puntsList = BD.getTotsPunts();
        } catch (GestorBDExceptionTOT | ExceptionTOT e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public static void OmpleInfoUsuari(String usuari) {
        
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

        btnC_Punt.setEnabled(false);
        btnB_punt.setEnabled(false);
        btnA_punt.setEnabled(false);


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
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnC_Punt = new javax.swing.JButton();
        btnA_punt = new javax.swing.JButton();
        btnB_punt = new javax.swing.JButton();

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
        tablepunts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablepuntsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablepunts);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Busqueda"));

        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nom / Titol");

        jLabel2.setText("Data de Creacio");

        jLabel3.setText("Entre:");

        jButton1.setText("Eliminar Filtre");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnBuscar)
                    .addComponent(jButton1))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Crud-Punt"));

        btnC_Punt.setText("Crear Punt");
        btnC_Punt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnC_PuntActionPerformed(evt);
            }
        });

        btnA_punt.setText("Actualitzar Punt");
        btnA_punt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnA_puntActionPerformed(evt);
            }
        });

        btnB_punt.setText("Borrar Punt");
        btnB_punt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB_puntActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnA_punt)
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnB_punt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnC_Punt, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(45, 45, 45))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnC_Punt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnA_punt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnB_punt)
                .addContainerGap(30, Short.MAX_VALUE))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCrearActionPerformed
        Creacio_Actualitzar_Ruta r = new Creacio_Actualitzar_Ruta(BD,LbelUsuario.getText(),tablaRutes);
        r.setVisible(true);
        r.btnActualitzar.setEnabled(false);
        r.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        r.setTitle("Creacio");


    }//GEN-LAST:event_BtnCrearActionPerformed

    private void BntActualitzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BntActualitzarActionPerformed

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

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
        Date date1 = jDateChooser1.getDate();
        Date date2 = jDateChooser2.getDate();
        String dateS1 = null;
        String dateS2 = null;
        if(date1 != null)
            dateS1 = sdf.format(date1);
            
        if(date2 != null)
            dateS2 = sdf.format(date2);

        String nom = lbBusqueda.getText();

        try {
            List<Ruta> RutesFiltrades = BD.getRutesFiltrades(nom , dateS1 , dateS2 , usuString );

            String[] columnes = {"Titol", "Descripcio", "Distancia", "Temps", "Data Creacio ", "Dificultat", "Valoracio Mitjana"};
            String[][] dades = new String[RutesFiltrades.size()][columnes.length];
            int i = 0;

            for (Ruta ruta : RutesFiltrades) {
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

            tablaRutes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            

        } catch (GestorBDExceptionTOT | ExceptionTOT e) {
            JOptionPane.showMessageDialog(this, "Error al filtra");
            e.printStackTrace();
        }



        System.out.println(dateS1 + " ----- "+ dateS2);


    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        lbBusqueda.setText("");
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        OmpleInfoUsuari(LbelUsuario.getText());
        


    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnB_puntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB_puntActionPerformed

        int id_ruta = 0;
        int fila = tablaRutes.getSelectedRow();
        String nomruta = tablaRutes.getValueAt(fila, 0).toString();

        for (Ruta ruta : ruteList) {
            if (ruta.getTitol().equals(nomruta)){
                id_ruta = ruta.getId_Ruta();
            }
        }

        int num_punt = tablepunts.getSelectedRow();
        String nom_punt = tablepunts.getValueAt(num_punt, 0).toString();

        for (Punts punt : puntsList) {
            if (punt.getNom().equals(nom_punt)){
                int respuesta = JOptionPane.showConfirmDialog(null, "¿ Vols eliminar aquest Punt ?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if(respuesta == JOptionPane.YES_OPTION){
                    try {
                        boolean fet = BD.borraPunt(punt.getNumPunt(), id_ruta);
                        if (fet) {
                            JOptionPane.showMessageDialog(this, "Punt borrat correctament");
                            BD.validarCanvis();
                            getPunts();
                        }
                        else{
                            JOptionPane.showMessageDialog(this, "No s'ha pogut borrar el punt");
                        }
                    } catch (GestorBDExceptionTOT | ExceptionTOT e) {
                        e.printStackTrace();
                    }
                }
            }
        }



    }//GEN-LAST:event_btnB_puntActionPerformed

    private void btnA_puntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnA_puntActionPerformed
        // TODO add your handling code here:

        //crear una pantalla de creacio de punt
        
        int id_ruta = 0;
        int fila = tablaRutes.getSelectedRow();
        String nomruta = tablaRutes.getValueAt(fila, 0).toString();
        
        for (Ruta ruta : ruteList) {
            if (ruta.getTitol().equals(nomruta)){
                id_ruta = ruta.getId_Ruta();
            }
        }
        int num_punt = tablepunts.getSelectedRow();
        String nom_punt = tablepunts.getValueAt(num_punt, 0).toString();
        for (Punts punt : puntsList) {
            if (punt.getNom().equals(nom_punt)){
                Crear_Actualitzar_punts p = new Crear_Actualitzar_punts(punt , BD , id_ruta , tablepunts);
                p.setVisible(true);
                p.btnCrear.setEnabled(false);
                p.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                p.setTitle("Actualitzar");
            }
        }

    }//GEN-LAST:event_btnA_puntActionPerformed

    private void btnC_PuntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnC_PuntActionPerformed
        // TODO add your handling code here:

        int id_ruta = 0;
        int fila = tablaRutes.getSelectedRow();
        String nomruta = tablaRutes.getValueAt(fila, 0).toString();

        for (Ruta ruta : ruteList) {
            if (ruta.getTitol().equals(nomruta)){
                id_ruta = ruta.getId_Ruta();
            }
        }

        //crear una pantalla de creacio de punt
        Crear_Actualitzar_punts p = new Crear_Actualitzar_punts(BD , id_ruta , tablepunts);
        p.setVisible(true);
        p.btnActualitar.setEnabled(false);
        p.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        p.setTitle("Creacio");

    }//GEN-LAST:event_btnC_PuntActionPerformed

    private void tablepuntsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablepuntsMouseClicked
        // TODO add your handling code here:

        if (tablepunts.getSelectedRow() == -1) {
            btnB_punt.setEnabled(false);
            btnA_punt.setEnabled(false);
        }
        else{
            btnB_punt.setEnabled(true);
            btnA_punt.setEnabled(true);
        }



    }//GEN-LAST:event_tablepuntsMouseClicked

    
    

    private void tablaRutesMouseClicked(java.awt.event.MouseEvent evt) {                                            
        getPunts();
    }
    
    public static void getPunts() {
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
            btnC_Punt.setEnabled(false);
            
              btnB_punt.setEnabled(true);
            btnA_punt.setEnabled(true);

        }
        else{
            BtnBorra.setEnabled(true);
            BntActualitzar.setEnabled(true);
            btnC_Punt.setEnabled(true);
            
             btnB_punt.setEnabled(false);
            btnA_punt.setEnabled(false);
          
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
    private static javax.swing.JButton BntActualitzar;
    private static javax.swing.JButton BtnBorra;
    private javax.swing.JButton BtnBuscar;
    private static javax.swing.JButton BtnCrear;
    private static javax.swing.JLabel LbelUsuario;
    private static javax.swing.JButton btnA_punt;
    private static javax.swing.JButton btnB_punt;
    private static javax.swing.JButton btnC_Punt;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lbBusqueda;
    private static javax.swing.JTable tablaRutes;
    private static javax.swing.JTable tablepunts;
    // End of variables declaration//GEN-END:variables
}
