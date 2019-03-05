/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author German
 */
public class ControlSolicitud extends javax.swing.JFrame {

    /**
     * Creates new form UserUpdate
     */
    private Connection c;

    public ControlSolicitud(String listadoSolicitudes) {
        initComponents();
        setLocationRelativeTo(null);
        c = new Connection();
        configurarSolicitudes(listadoSolicitudes);
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
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListSolicitudes = new javax.swing.JList<>();
        bAceptarSolicitud = new javax.swing.JButton();
        bRechazarSolicutud = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(97, 212, 195));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Solicitudes de amistad");

        jPanel2.setBackground(new java.awt.Color(36, 47, 65));

        jListSolicitudes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jListSolicitudes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Usuario 1", "Usuario 2", "Usuario 3", "Usuario 4", "Usuario 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListSolicitudes);

        bAceptarSolicitud.setText("Agregar");
        bAceptarSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarSolicitudActionPerformed(evt);
            }
        });

        bRechazarSolicutud.setText("Rechazar");
        bRechazarSolicutud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRechazarSolicutudActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(bRechazarSolicutud)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(bAceptarSolicitud)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAceptarSolicitud)
                    .addComponent(bRechazarSolicutud))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void bRechazarSolicutudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRechazarSolicutudActionPerformed
        rechazarSolicitud();
    }//GEN-LAST:event_bRechazarSolicutudActionPerformed

    private void bAceptarSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarSolicitudActionPerformed
        aceptarSolicitud();
    }//GEN-LAST:event_bAceptarSolicitudActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ControlSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ControlSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ControlSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ControlSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ControlSolicitud().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptarSolicitud;
    private javax.swing.JButton bRechazarSolicutud;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jListSolicitudes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void configurarSolicitudes(String listadoSolicitudes) {
        System.out.println("Esperando por formatear solicitudes de amistad");

        DefaultListModel modelo = new DefaultListModel();

        String[] solicitudes = listadoSolicitudes.split("&&");

        for (String s : solicitudes) {
            modelo.addElement(s);
        }

        jListSolicitudes.setModel(modelo);
    }

    private void aceptarSolicitud() {
        String seleccionado = jListSolicitudes.getSelectedValue();
        if (seleccionado != null && !seleccionado.isEmpty()) {
            String parametros;
            try {
                parametros = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(seleccionado), "UTF-8");
                String res = c.enviarInfoEndPoint("/aceptarsolicitud", parametros);
                System.out.println("Respuesta de aceptacion solicitud " + res);

                if ("602".equals(res)) {
                    JOptionPane.showMessageDialog(this, "Solicitud Aceptada");
                    this.setVisible(false);
                }
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(ControlSolicitud.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void rechazarSolicitud() {
        String seleccionado = jListSolicitudes.getSelectedValue();
        if (seleccionado != null && !seleccionado.isEmpty()) {
            String parametros;
            try {
                parametros = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(seleccionado), "UTF-8");
                String res = c.enviarInfoEndPoint("/rechazarsolicitud", parametros);
                System.out.println("Respuesta de aceptacion solicitud " + res);
                if ("603".equals(res)) {
                    JOptionPane.showMessageDialog(this, "Solicitud Rechazada!");
                    this.setVisible(false);
                }
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(ControlSolicitud.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
