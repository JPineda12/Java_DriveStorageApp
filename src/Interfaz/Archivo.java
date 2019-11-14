/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Component;
import proyecto2.Objetos.ArchivoObj;

/**
 *
 * @author brest12
 */
public class Archivo extends javax.swing.JPanel {

    private ArchivoObj archivo;
    public Archivo() {
        initComponents();
    }
    public Archivo(ArchivoObj archivo){
        this.archivo = archivo;
        initComponents();
        jButton1.setText(archivo.getNombre());
    }
    
    
    public ArchivoObj getArchivo(){
        return archivo;
    }
    
    public void setText(String text){
        jButton1.setText(text);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setForeground(new java.awt.Color(51, 57, 59));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Icons/File.png"))); // NOI18N
        jButton1.setText("Archivo");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setBorderPainted(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jButton1FocusLost(evt);
            }
        });
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if(evt.getClickCount() == 2){
            ContentViewer c = new ContentViewer(archivo);
            c.setVisible(true);
        }else{
            this.getParent().requestFocus();
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton1FocusLost

    }//GEN-LAST:event_jButton1FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
