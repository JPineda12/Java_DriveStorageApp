/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.miginfocom.swing.MigLayout;
import proyecto2.Objetos.ArchivoObj;

/**
 *
 * @author brest12
 */
public class Archivo extends javax.swing.JPanel {

    private ArchivoObj archivo;
    String realNombre, shownNombre;
    public Archivo() {
        initComponents();
    }
    public Archivo(ArchivoObj archivo){
        this.archivo = archivo;
        initComponents();
        realNombre = archivo.getNombre();
        shownNombre = generateSNombre(realNombre);
        jToggleButton2.setText(shownNombre);

    }
    
    private void mLayout(){
        MigLayout m = new MigLayout("","80:80:80","80:80:80");
        this.removeAll();
        this.setLayout(m);
        this.add(jToggleButton2);
    }
    
    private String generateSNombre(String nombre){
        if(nombre.length() > 12){
            nombre = archivo.getNombre().substring(0,8)+"...";
        }
        return nombre;
    }
    
    public ArchivoObj getArchivo(){
        return archivo;
    }
    
    public void setText(String text){
        this.realNombre = text;
        shownNombre = generateSNombre(realNombre);
        jToggleButton2.setText(shownNombre);
    }
    
    public String getNombre(){
        return realNombre;
    }
    
    public boolean estaSeleccionado(){
        return jToggleButton2.isSelected();
    }
    
    public void setSeleccionado(boolean seleccion){
        jToggleButton2.setSelected(seleccion);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton2 = new javax.swing.JToggleButton();

        setBackground(new java.awt.Color(59, 52, 51));
        setForeground(new java.awt.Color(36, 40, 41));
        setPreferredSize(new java.awt.Dimension(70, 73));

        jToggleButton2.setBackground(new java.awt.Color(59, 52, 51));
        jToggleButton2.setForeground(new java.awt.Color(255, 255, 242));
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Icons/File.png"))); // NOI18N
        jToggleButton2.setText("Archivo");
        jToggleButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToggleButton2.setBorderPainted(false);
        jToggleButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jToggleButton2MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToggleButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToggleButton2)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton2MouseReleased
        if(evt.getClickCount() == 2){
            ContentViewer c = new ContentViewer(archivo);
            c.setVisible(true);
        }else{
            System.out.println(jToggleButton2.isSelected());
            this.getParent().requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2MouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}
