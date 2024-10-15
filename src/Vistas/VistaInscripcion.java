/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import Persistencia.alumnoData;
import Persistencia.inscripcionData;
import Persistencia.materiaData;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joaco
 */
public class VistaInscripcion extends javax.swing.JInternalFrame {

    private List<Materia> listaM;
    private List<Alumno> listaAl;
    
    private inscripcionData insData;
    private materiaData mtData;
    private alumnoData alData;

    private DefaultTableModel modelo;
    /**
     * Creates new form FormularioInscripcion
     */
    public VistaInscripcion(Alumno a, Materia m, int par) {
        initComponents();
        alData = new alumnoData();
        listaAl = alData.listarAlumnos();
        modelo = new DefaultTableModel();
        insData = new inscripcionData();
        mtData = new materiaData();
        cargarAlumnos();
        armarTabla();
        
    }
    
      private boolean validarEntero(String num){
        Pattern patron = Pattern.compile("^[0-9]+$");
        Matcher match = patron.matcher(num);
        return match.matches();
    }
    
    private boolean validarTexto(String text){
        Pattern patron = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚ]+$");
        Matcher match = patron.matcher(text);
        return match.matches();
    }
    
    private void cargarAlumnos(){
        for(Alumno item: listaAl){
            jcbAlumno.addItem(title);
        }
    }
    
    private void armarTabla(){
        ArrayList<Object> filaCab = new ArrayList<>();
        filaCab.add("ID");
        filaCab.add("Nombre");
        filaCab.add("Año");
        
        for(Object it: filaCab){
            modelo.addColumn(it);
        }
        jTablaMat.setModel(modelo);
    }
    
    private void removerFilaTabla(){
        int indice = modelo.getRowCount() -1;
        
        for(int i = indice; i>=0; i--){
            modelo.removeRow(i);
        }
    }
    
    private void cargaNoInscriptas(){
        Alumno selt = (Alumno)jcbAlumno.getSelectedItem();
        listaM = insData.obtenerMateriasNoCursadas(selt.getIdAlumno());
        for(Materia m:listaM){
            modelo.addRow(new Object[]{m.getIdMateria(), m.getNombre(), m.getAnio()});
        }
    }
    
    private void cargaInscriptas(){
        Alumno selt = (Alumno) jcbAlumno.getSelectedItem();
        listaM = insData.obtenerMateriasCursadas(selt.getIdAlumno());
        for(Materia m:listaM){
            modelo.addRow(new Object[]{m.getIdMateria(), m.getNombre(), m.getAnio()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbAlumno = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jrbMatInscripta = new javax.swing.JRadioButton();
        jrbMatNo = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablaMat = new javax.swing.JTable();
        jbIns = new javax.swing.JButton();
        jbAins = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        jLabel1.setText("FORMULARIO DE INSCRIPCIÓN");

        jLabel2.setText("Alumno:");

        jcbAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAlumnoActionPerformed(evt);
            }
        });

        jLabel3.setText("Listado de Materias");

        jrbMatInscripta.setText("Inscriptas");
        jrbMatInscripta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMatInscriptaActionPerformed(evt);
            }
        });

        jrbMatNo.setText("No inscriptas");
        jrbMatNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMatNoActionPerformed(evt);
            }
        });

        jTablaMat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Año"
            }
        ));
        jScrollPane2.setViewportView(jTablaMat);

        jbIns.setText("Inscribir");
        jbIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInsActionPerformed(evt);
            }
        });

        jbAins.setText("Anular Inscripción");
        jbAins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAinsActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbIns, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(jbAins, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(jbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jrbMatInscripta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jrbMatNo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
                        .addGap(104, 104, 104))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbMatInscripta)
                    .addComponent(jrbMatNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbIns)
                    .addComponent(jbAins)
                    .addComponent(jbSalir))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlumnoActionPerformed
        removerFilaTabla();
        jrbMatInscripta.setSelected(false);
        jrbMatNo.setSelected(false);
    }//GEN-LAST:event_jcbAlumnoActionPerformed

    private void jrbMatInscriptaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMatInscriptaActionPerformed
        removerFilaTabla();
        jrbMatNo.setSelected(false);
        cargaInscriptas();
        jbIns.setEnabled(false);
        jbAins.setEnabled(true);
    }//GEN-LAST:event_jrbMatInscriptaActionPerformed

    private void jrbMatNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMatNoActionPerformed
        removerFilaTabla();
        jrbMatInscripta.setSelected(false);
        cargaNoInscriptas();
        jbIns.setEnabled(true);
        jbAins.setEnabled(false);
    }//GEN-LAST:event_jrbMatNoActionPerformed

    private void jbInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInsActionPerformed
        int fSelec = jTablaMat.getSelectedRow();
        if(fSelec != -1){
            Alumno a = (Alumno)jcbAlumno.getSelectedItem();
            
            int idMateria = (Integer)modelo.getValueAt(fSelec, 0);
            String nombre = (String)modelo.getValueAt(fSelec, 1);
            int anio = (Integer)modelo.getValueAt(fSelec, 2);
            Materia m = new Materia(idMateria,nombre, anio,true);
            
            Inscripcion ins = new Inscripcion(a,m,0);
            insData.guardarInscripcion(ins);
            removerFilaTabla();
            if(jrbMatInscripta.isSelected()){
                cargaInscriptas();
            }else if(jrbMatNo.isSelected()){
                cargaNoInscriptas();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione una fila");
        }
    }//GEN-LAST:event_jbInsActionPerformed

    private void jbAinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAinsActionPerformed
         int fSelec = jTablaMat.getSelectedRow();
        if(fSelec != -1){
            Alumno a = (Alumno) jcbAlumno.getSelectedItem();
            int idMateria = (Integer) modelo.getValueAt(fSelec, 0);
            insData.eliminarInscripcionMateriaAlumno(a.getIdAlumno(), idMateria);
            
            removerFilaTabla();
            if(jrbMatInscripta.isSelected()){
                cargaInscriptas();
            }else if(jrbMatNo.isSelected()){
                cargaNoInscriptas();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un fila");
        }
    }//GEN-LAST:event_jbAinsActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablaMat;
    private javax.swing.JButton jbAins;
    private javax.swing.JButton jbIns;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcbAlumno;
    private javax.swing.JRadioButton jrbMatInscripta;
    private javax.swing.JRadioButton jrbMatNo;
    // End of variables declaration//GEN-END:variables

    
}
