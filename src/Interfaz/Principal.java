/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Estructuras.ArbolAVL;
import Estructuras.ListaEnlazada;
import Estructuras.MatrizAdy;
import Estructuras.Nodos.AVLNode;
import Estructuras.Nodos.NodoLista;
import Estructuras.Nodos.Vertice;
import Estructuras.TablaHash;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import proyecto2.Objetos.ArchivoObj;
import proyecto2.Objetos.CarpetaObj;
import proyecto2.Objetos.Usuario;

/**
 *
 * @author brest12
 */
public class Principal extends javax.swing.JFrame {

    
    int contx, conty;
    GridBagConstraints c;
    TablaHash users;
    MatrizAdy carpetas;
    ArbolAVL files;
    Usuario currentUser;
    int foldersCount;
    String currentFolder;
    public Principal(Usuario username, Boolean admin, TablaHash users, MatrizAdy carpetas) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.users = users;
        this.carpetas = carpetas;
        files = new ArbolAVL();
        this.currentUser = username;
        contx = 0;
        conty = 0;
        foldersCount = 0;
        currentFolder = "/";
        c = new GridBagConstraints();
        panelPrincipal.setLayout(new GridBagLayout());
        labelUsername.setText(username.getUsername());
        panelAdmin.setVisible(false);
        if(admin){
            panelAdmin.setVisible(true);
        }
        
        addFolderstoPanel(currentFolder);
        
    }
    
    public void addFolderstoPanel(String nombreCarpeta){
        Vertice aux = carpetas.getRoot().getDown();
        CarpetaObj folder;
        while (aux != null) {
            folder = (CarpetaObj) aux.getDato();

            if (nombreCarpeta.equals(folder.getNombre())) {
                aux = aux.getRight();
                if (aux != null) {
                    String nombre = ((CarpetaObj) aux.getUp().getDato()).getNombre();
                    Carpeta folderButton = new Carpeta(nombre);
                    c.gridx = contx;
                    c.gridy = conty;
                    contx++;
                    if (contx > 7) {
                        conty++;
                        contx = 0;
                    }
                    panelPrincipal.add(folderButton, c);
                } else {
                    break;
                }
            }
            aux = aux.getDown();
        }
    }
    
    public void addFilestoPanel(String nombreCarpeta){
        Vertice aux = carpetas.getRoot().getDown();
        CarpetaObj folder;
        while (aux != null) {
            folder = (CarpetaObj) aux.getDato();

            if (nombreCarpeta.equals(folder.getNombre())) {
                ListaEnlazada temp = folder.getArchivos().convertirALista();
                NodoLista h = temp.getHead();
                while (h != null) {
                    Archivo file = new Archivo(((ArchivoObj)h.getData()).getNombre());
                    c.gridx = contx;
                    c.gridy = conty;
                    contx++;
                    if (contx > 7) {
                        conty++;
                        contx = 0;
                    }
                    panelPrincipal.add(file, c);
                    h = h.getNext();
                }
                break;
            }
            aux = aux.getDown();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btMenu = new javax.swing.JButton();
        panelMenu = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelUsername = new javax.swing.JLabel();
        logOutBt = new javax.swing.JButton();
        folderCreateBt = new rsbuttom.RSButtonMetro();
        folderModifyBt = new rsbuttom.RSButtonMetro();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        folderDelBt = new rsbuttom.RSButtonMetro();
        fileCreateBt = new rsbuttom.RSButtonMetro();
        FileDelBt = new rsbuttom.RSButtonMetro();
        fileModifyBt = new rsbuttom.RSButtonMetro();
        panelAdmin = new javax.swing.JPanel();
        UsersBulkLoad = new rsbuttom.RSButtonMetro();
        jLabel6 = new javax.swing.JLabel();
        filesBulkload = new rsbuttom.RSButtonMetro();
        panelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(51, 57, 59));

        jPanel2.setBackground(new java.awt.Color(0, 33, 206));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Icons/menu.png"))); // NOI18N
        btMenu.setBorder(null);
        btMenu.setContentAreaFilled(false);
        btMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenuActionPerformed(evt);
            }
        });
        jPanel2.add(btMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panelMenu.setBackground(new java.awt.Color(183, 183, 183));
        panelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(183, 183, 183));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(58, 58, 58));
        jLabel1.setText("CARPETAS");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Icons/Workspace.png"))); // NOI18N

        labelUsername.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        labelUsername.setForeground(new java.awt.Color(255, 255, 255));
        labelUsername.setText("UsuarioName");

        logOutBt.setBackground(new java.awt.Color(183, 183, 183));
        logOutBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Icons/logout.png"))); // NOI18N
        logOutBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(labelUsername)
                        .addGap(0, 40, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(logOutBt))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(labelUsername)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(logOutBt)
                        .addGap(13, 13, 13)))
                .addComponent(jLabel1))
        );

        panelMenu.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, -1));

        folderCreateBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Icons/AddFolder.png"))); // NOI18N
        folderCreateBt.setText("CREAR");
        folderCreateBt.setColorNormal(new java.awt.Color(183, 183, 183));
        folderCreateBt.setColorTextHover(new java.awt.Color(58, 58, 58));
        folderCreateBt.setColorTextNormal(new java.awt.Color(58, 58, 58));
        folderCreateBt.setColorTextPressed(new java.awt.Color(58, 58, 58));
        folderCreateBt.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        folderCreateBt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        folderCreateBt.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        folderCreateBt.setIconTextGap(25);
        folderCreateBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                folderCreateBtActionPerformed(evt);
            }
        });
        panelMenu.add(folderCreateBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 174, 50));

        folderModifyBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Icons/ModifyFolder.png"))); // NOI18N
        folderModifyBt.setText("MODIFICAR");
        folderModifyBt.setColorNormal(new java.awt.Color(183, 183, 183));
        folderModifyBt.setColorTextHover(new java.awt.Color(58, 58, 58));
        folderModifyBt.setColorTextNormal(new java.awt.Color(58, 58, 58));
        folderModifyBt.setColorTextPressed(new java.awt.Color(58, 58, 58));
        folderModifyBt.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        folderModifyBt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        folderModifyBt.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        folderModifyBt.setIconTextGap(25);
        folderModifyBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                folderModifyBtActionPerformed(evt);
            }
        });
        panelMenu.add(folderModifyBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 174, 50));

        jPanel5.setBackground(new java.awt.Color(183, 183, 183));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(58, 58, 58));
        jLabel2.setText("ARCHIVOS");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        panelMenu.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 174, 50));

        folderDelBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Icons/DeleteFolder.png"))); // NOI18N
        folderDelBt.setText("ELIMINAR");
        folderDelBt.setColorNormal(new java.awt.Color(183, 183, 183));
        folderDelBt.setColorTextHover(new java.awt.Color(58, 58, 58));
        folderDelBt.setColorTextNormal(new java.awt.Color(58, 58, 58));
        folderDelBt.setColorTextPressed(new java.awt.Color(58, 58, 58));
        folderDelBt.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        folderDelBt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        folderDelBt.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        folderDelBt.setIconTextGap(25);
        folderDelBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                folderDelBtActionPerformed(evt);
            }
        });
        panelMenu.add(folderDelBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 174, 50));

        fileCreateBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Icons/NewFile.png"))); // NOI18N
        fileCreateBt.setText("CREAR");
        fileCreateBt.setColorNormal(new java.awt.Color(183, 183, 183));
        fileCreateBt.setColorTextHover(new java.awt.Color(58, 58, 58));
        fileCreateBt.setColorTextNormal(new java.awt.Color(58, 58, 58));
        fileCreateBt.setColorTextPressed(new java.awt.Color(58, 58, 58));
        fileCreateBt.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        fileCreateBt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fileCreateBt.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        fileCreateBt.setIconTextGap(25);
        fileCreateBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileCreateBtActionPerformed(evt);
            }
        });
        panelMenu.add(fileCreateBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 174, 50));

        FileDelBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Icons/DeleteFile.png"))); // NOI18N
        FileDelBt.setText("ELIMINAR");
        FileDelBt.setColorNormal(new java.awt.Color(183, 183, 183));
        FileDelBt.setColorTextHover(new java.awt.Color(58, 58, 58));
        FileDelBt.setColorTextNormal(new java.awt.Color(58, 58, 58));
        FileDelBt.setColorTextPressed(new java.awt.Color(58, 58, 58));
        FileDelBt.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        FileDelBt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        FileDelBt.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        FileDelBt.setIconTextGap(25);
        FileDelBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileDelBtActionPerformed(evt);
            }
        });
        panelMenu.add(FileDelBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 174, 50));

        fileModifyBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Icons/ModifyFile.png"))); // NOI18N
        fileModifyBt.setText("MODIFICAR");
        fileModifyBt.setColorNormal(new java.awt.Color(183, 183, 183));
        fileModifyBt.setColorTextHover(new java.awt.Color(58, 58, 58));
        fileModifyBt.setColorTextNormal(new java.awt.Color(58, 58, 58));
        fileModifyBt.setColorTextPressed(new java.awt.Color(58, 58, 58));
        fileModifyBt.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        fileModifyBt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fileModifyBt.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        fileModifyBt.setIconTextGap(25);
        fileModifyBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileModifyBtActionPerformed(evt);
            }
        });
        panelMenu.add(fileModifyBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 174, 50));

        panelAdmin.setBackground(new java.awt.Color(183, 183, 183));

        UsersBulkLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Icons/importcsv.png"))); // NOI18N
        UsersBulkLoad.setText("USERS LOAD");
        UsersBulkLoad.setColorNormal(new java.awt.Color(183, 183, 183));
        UsersBulkLoad.setColorTextHover(new java.awt.Color(58, 58, 58));
        UsersBulkLoad.setColorTextNormal(new java.awt.Color(58, 58, 58));
        UsersBulkLoad.setColorTextPressed(new java.awt.Color(58, 58, 58));
        UsersBulkLoad.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        UsersBulkLoad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsersBulkLoad.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        UsersBulkLoad.setIconTextGap(25);
        UsersBulkLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsersBulkLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAdminLayout = new javax.swing.GroupLayout(panelAdmin);
        panelAdmin.setLayout(panelAdminLayout);
        panelAdminLayout.setHorizontalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addComponent(UsersBulkLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAdminLayout.setVerticalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UsersBulkLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMenu.add(panelAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 190, 90));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(58, 58, 58));
        jLabel6.setText("BULK LOAD");
        panelMenu.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, 33));

        filesBulkload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Icons/importcsv.png"))); // NOI18N
        filesBulkload.setText("FILES LOAD");
        filesBulkload.setColorNormal(new java.awt.Color(183, 183, 183));
        filesBulkload.setColorTextHover(new java.awt.Color(58, 58, 58));
        filesBulkload.setColorTextNormal(new java.awt.Color(58, 58, 58));
        filesBulkload.setColorTextPressed(new java.awt.Color(58, 58, 58));
        filesBulkload.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        filesBulkload.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        filesBulkload.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        filesBulkload.setIconTextGap(25);
        filesBulkload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filesBulkloadActionPerformed(evt);
            }
        });
        panelMenu.add(filesBulkload, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 174, 50));

        panelPrincipal.setForeground(new java.awt.Color(51, 57, 59));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(514, 514));
        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void folderDelBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_folderDelBtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_folderDelBtActionPerformed

    private void fileCreateBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileCreateBtActionPerformed
        String nombre = JOptionPane.showInputDialog("Nombre de Archivo: ");
        Archivo file = new Archivo(nombre);
        //folder.setLayout(new BorderLayout());
        
        c.gridx = contx;
        c.gridy = conty;
        contx++;
        if(contx>7){
            conty++;
            contx = 0;
        }
        panelPrincipal.add(file,c);
    }//GEN-LAST:event_fileCreateBtActionPerformed

    private void FileDelBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileDelBtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FileDelBtActionPerformed

    private void fileModifyBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileModifyBtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileModifyBtActionPerformed

    private void btMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuActionPerformed
        int pos = panelMenu.getX();
        if(pos > -1){
            Animacion.Animacion.mover_izquierda(0, -174, 2, 2, panelMenu);
        }else{
            Animacion.Animacion.mover_derecha(-174, 0, 2, 2, panelMenu);
        }
    }//GEN-LAST:event_btMenuActionPerformed

    private void folderCreateBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_folderCreateBtActionPerformed
        String nombre = JOptionPane.showInputDialog("Nombre de carpeta: ");
        Carpeta folderButton = new Carpeta(nombre);
        CarpetaObj carpeta = new CarpetaObj(nombre, new ArbolAVL());
        //folder.setLayout(new BorderLayout());
        
        c.gridx = contx;
        c.gridy = conty;
        contx++;
        if(contx>7){
            conty++;
            contx = 0;
        }
        panelPrincipal.add(folderButton,c);
        currentUser.addCarpeta(currentFolder, nombre);
        carpetas.graficar();
    }//GEN-LAST:event_folderCreateBtActionPerformed

    private void folderModifyBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_folderModifyBtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_folderModifyBtActionPerformed

    private void UsersBulkLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsersBulkLoadActionPerformed
        JFileChooser choose = new JFileChooser(".");
        BufferedReader br = null;
        int f = choose.showOpenDialog(null);
        if(f == JFileChooser.APPROVE_OPTION){
            System.out.println("Insert: "+choose.getSelectedFile().getAbsolutePath());
            //labelUsername.setText(choose.getSelectedFile());
            String line = "";
            int n = 0;
            boolean userIsFirst = false;
            String csvFile = choose.getSelectedFile().getAbsolutePath();
            try {
                br = new BufferedReader(new FileReader(csvFile));
                String name = "";
                String pass = "";
                String usuario[] = null;
                while((line = br.readLine()) != null){
                    usuario = line.split(",");
                    if(n == 0){
                        
                        if("usuario".equals(usuario[0].toLowerCase())){
                            userIsFirst = true;                           
                        }else if("password".equals(usuario[0].toLowerCase())){
                            userIsFirst = false;
                        }else{
                            break;
                        }
                    }else if(n > 0){
                        if(userIsFirst){
                            name = usuario[0];
                            pass = usuario[1];
                            System.out.println(name);;
                        }else{
                            name = usuario[1];
                            pass = usuario[0];
                            
                        }
                        if(!users.contains(name)){
                            if(isLongEnough(pass)){
                                Timestamp time = new Timestamp(System.currentTimeMillis());
                                users.insertar(new Usuario(name, pass, time, false));
                            }else{
                                System.out.println("User: "+name+" has a "
                                        + "password < 8");
                            }
                        }else{
                            System.out.println("User "+name+" already exists!");
                        }
                        
                    }
                    n++;
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        users.imprimir();
        users.graficar();
    }//GEN-LAST:event_UsersBulkLoadActionPerformed

    private boolean isLongEnough(String pass){
        return pass.length() >= 8;
    }
    private void logOutBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtActionPerformed
        int opt = JOptionPane.showConfirmDialog(this, "Log out?");
        if(opt == 0){
            this.dispose();
            LoginFrame lg = new LoginFrame(users);
            lg.setVisible(true);
        }
    }//GEN-LAST:event_logOutBtActionPerformed

    private void filesBulkloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filesBulkloadActionPerformed
        JFileChooser choose = new JFileChooser(".");
        BufferedReader br = null;
        Timestamp time;
        int f = choose.showOpenDialog(null);
        if(f == JFileChooser.APPROVE_OPTION){
            System.out.println("Insert: "+choose.getSelectedFile().getAbsolutePath());
            //labelUsername.setText(choose.getSelectedFile());
            String line = "";
            int n = 0;
            boolean fileIsFirst = false;
            String csvFile = choose.getSelectedFile().getAbsolutePath();
            try {
                br = new BufferedReader(new FileReader(csvFile));
                String name = "";
                String content = "";
                String file[] = null;
                while((line = br.readLine()) != null){
                    file = line.split(",");
                    if(n == 0){
                        System.out.println(file[0].toLowerCase());
                        if("archivo".equals(file[0].toLowerCase())){
                            System.out.println("Yes");
                            fileIsFirst = true;                           
                        }else if("contenido".equals(file[0].toLowerCase())){
                            fileIsFirst = false;
                        }else{
                            System.out.println("Breaking up :'(");
                            break;
                        }
                    }else if(n > 0){
                        if(fileIsFirst){
                            name = file[0];
                            content = file[1];
                            System.out.println(name);;
                        }else{
                            name = file[1];
                            content = file[0];
                            
                        }
                        time = new Timestamp(System.currentTimeMillis());
                        AVLNode node = new AVLNode(new ArchivoObj(name, content, time.toString(), currentUser.getUsername()));
                        if(!files.contains(node)){
                            if(isContentString(content)){
                                files.insert(new ArchivoObj(name, content, time.toString(), currentUser.getUsername()));
                                System.out.println("inserted: "+name);
                            }else{
                                System.out.println("File: "+name+" has a "
                                        + "content that is not a String!");
                            }
                        }else{
                            System.out.println("file "+name+" already exists!");
                        }
                        
                    }
                    n++;
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        files.generateGraph();
    }//GEN-LAST:event_filesBulkloadActionPerformed

    private boolean isContentString(String content){
        return content.contains("");
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal(null,false, null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttom.RSButtonMetro FileDelBt;
    private rsbuttom.RSButtonMetro UsersBulkLoad;
    private javax.swing.JButton btMenu;
    private rsbuttom.RSButtonMetro fileCreateBt;
    private rsbuttom.RSButtonMetro fileModifyBt;
    private rsbuttom.RSButtonMetro filesBulkload;
    private rsbuttom.RSButtonMetro folderCreateBt;
    private rsbuttom.RSButtonMetro folderDelBt;
    private rsbuttom.RSButtonMetro folderModifyBt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JButton logOutBt;
    private javax.swing.JPanel panelAdmin;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
