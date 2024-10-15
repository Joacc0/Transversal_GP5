package Vistas;

import Entidades.Alumno;
import java.util.ArrayList;

public class Menu extends javax.swing.JFrame {
    
    private ArrayList<Alumno> listaAlumnos;
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiFAlumno = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiFMateria = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        jMenu1.setText("Alumno");

        jmiFAlumno.setText("Formulario Alumno");
        jmiFAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiFAlumnoActionPerformed(evt);
            }
        });
        jMenu1.add(jmiFAlumno);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Materia");

        jmiFMateria.setText("Formulario Materia");
        jmiFMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiFMateriaActionPerformed(evt);
            }
        });
        jMenu2.add(jmiFMateria);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiFAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiFAlumnoActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaAlumno fAlum = new VistaAlumno();
        fAlum.setVisible(true);
        escritorio.add(fAlum);
    }//GEN-LAST:event_jmiFAlumnoActionPerformed

    private void jmiFMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiFMateriaActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        FormularioMateria fMat = new FormularioMateria();
        fMat.setVisible(true);
        escritorio.add(fMat);
    }//GEN-LAST:event_jmiFMateriaActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jmiFAlumno;
    private javax.swing.JMenuItem jmiFMateria;
    // End of variables declaration//GEN-END:variables
}
