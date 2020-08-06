package my.dico.gui.GUI;

import java.util.ArrayList;
import my.dico.gui.Modelo.Examen;
import my.dico.gui.Modelo.Pregunta;

/**
 *
 * @author Pablo Jj
 */
public class Informe extends javax.swing.JFrame {
    
    private Examen e;

    public Informe(Examen e) {
        initComponents();
        this.e = e;
        jTextArea1.setText("Has fallado\n");
        jTextArea1.append("============\n");
        this.mostrarFalladas();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jButton2.setText("salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, java.awt.BorderLayout.PAGE_END);

        jButton3.setText("hacer examen con estas palabras");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.modificarExamen();
        new Test(e);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    private void mostrarFalladas() {
        e.getPreguntas().entrySet().stream().filter(i -> (!i.getValue())).forEachOrdered(i -> {
            jTextArea1.append(i.getKey().getPregunta() + "\n");
        });
    }

    /**
     * Ponemos solo las preguntas que estan a false
     */
    private void modificarExamen() {
        ArrayList a = new ArrayList<Pregunta>();
        for(var e : e.getErroneas()) {
            a.add(e);
        }
        
     
    }
}
