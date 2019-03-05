/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import java.awt.Font;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import logica.Cliente;
import logica.Usuario;
//import logica.Cliente;
//import logica.Usuario;

/**
 *
 * @author German
 */
public class Chat extends javax.swing.JFrame {

    Connection c;
    Login login;
    UserUpdate update = new UserUpdate();
    private static PanelEmoticons panelEmoticons;
    Document document;
    private String styleFont = "plain";
    private StyledDocument styledDocument;
    private StyleContext context;
    private boolean blockEmotes = false;
    private Usuario u;
    private int idamigo;
    Cliente clienteSocket;

    private String listadoSolicitudes;

    /**
     * Creates new form Chat
     *
     * @param login
     * @param u
     */
    public Chat(Login login, Usuario u) {
        //public Chat() {
        initComponents();
        idamigo = 0;
        txtAreaChat.setEditable(false);
        DesactivarPaneles(true); 
        c = new Connection();
        this.login = login;
        this.u = u;
        clienteSocket = new Cliente(u, this);
        setLocationRelativeTo(null);
         context = new StyleContext();
         styledDocument = new DefaultStyledDocument(context);
        //jLabel2.setText(login.getUsuario());        
        panelEmoticons = new PanelEmoticons(this);
        panelEmoticons.setSize(700, 200);
        PanelEmot.add(panelEmoticons);
        document = txtChat.getDocument();

        LabelNombreUsuario.setText("Hola ¡" + u.getUsr() + "!");
        //"#MSJ||FQLSHP||c0||c2||Hola :)"
        clienteSocket.enviar("#HOLA||FQLSHP||" + u.getId() + "||s3rv1d0r||" + u.getId() + "\n");
    }

    public void insertString(String string) {
        try {
            document.insertString(txtChat.getText().length(), string, null);
        } catch (BadLocationException e) {

            e.printStackTrace();
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
        PanelMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LabelNombreUsuario = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaUsuariosUI = new javax.swing.JList<>();
        PanelNotificaciones = new javax.swing.JPanel();
        lbCerrar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bSolicitudes = new javax.swing.JLabel();
        PanelChat = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtChat = new javax.swing.JTextArea();
        lbEnviar = new javax.swing.JLabel();
        lbArchivos = new javax.swing.JLabel();
        PanelEmot = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAreaChat = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(36, 47, 65));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelMain.setBackground(new java.awt.Color(97, 212, 195));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Captura2.JPG"))); // NOI18N
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        LabelNombreUsuario.setText("Hola pepito!");

        jTextField1.setText("Nick....");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Captura3.JPG"))); // NOI18N
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        listaUsuariosUI.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        listaUsuariosUI.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Sin Amigos :(" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaUsuariosUI.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaUsuariosUI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaUsuariosUIMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaUsuariosUI);

        javax.swing.GroupLayout PanelMainLayout = new javax.swing.GroupLayout(PanelMain);
        PanelMain.setLayout(PanelMainLayout);
        PanelMainLayout.setHorizontalGroup(
            PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(PanelMainLayout.createSequentialGroup()
                        .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelMainLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LabelNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PanelMainLayout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        PanelMainLayout.setVerticalGroup(
            PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMainLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(LabelNombreUsuario))
                .addGap(18, 18, 18)
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(PanelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 600));

        PanelNotificaciones.setBackground(new java.awt.Color(255, 255, 204));

        lbCerrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbCerrar.setText("X");
        lbCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCerrarMouseClicked(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Eventos Aplicacion");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        bSolicitudes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Captura.JPG"))); // NOI18N
        bSolicitudes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bSolicitudesMousePressed(evt);
            }
        });

        javax.swing.GroupLayout PanelNotificacionesLayout = new javax.swing.GroupLayout(PanelNotificaciones);
        PanelNotificaciones.setLayout(PanelNotificacionesLayout);
        PanelNotificacionesLayout.setHorizontalGroup(
            PanelNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNotificacionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelNotificacionesLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bSolicitudes)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelNotificacionesLayout.createSequentialGroup()
                        .addComponent(lbCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        PanelNotificacionesLayout.setVerticalGroup(
            PanelNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNotificacionesLayout.createSequentialGroup()
                .addComponent(lbCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(PanelNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel1.add(PanelNotificaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 670, 160));

        PanelChat.setBackground(new java.awt.Color(36, 47, 65));

        txtChat.setColumns(20);
        txtChat.setRows(5);
        jScrollPane3.setViewportView(txtChat);

        lbEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Captura4.JPG"))); // NOI18N
        lbEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEnviarMouseClicked(evt);
            }
        });

        lbArchivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Captura5.JPG"))); // NOI18N

        javax.swing.GroupLayout PanelEmotLayout = new javax.swing.GroupLayout(PanelEmot);
        PanelEmot.setLayout(PanelEmotLayout);
        PanelEmotLayout.setHorizontalGroup(
            PanelEmotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelEmotLayout.setVerticalGroup(
            PanelEmotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(txtAreaChat);

        javax.swing.GroupLayout PanelChatLayout = new javax.swing.GroupLayout(PanelChat);
        PanelChat.setLayout(PanelChatLayout);
        PanelChatLayout.setHorizontalGroup(
            PanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelChatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(PanelChatLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEnviar))
                        .addGap(0, 120, Short.MAX_VALUE))
                    .addComponent(PanelEmot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelChatLayout.setVerticalGroup(
            PanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelChatLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelEmot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelChatLayout.createSequentialGroup()
                        .addComponent(lbArchivos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbEnviar)))
                .addContainerGap())
        );

        jPanel1.add(PanelChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 670, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseClicked
        cerrarSesion();

    }//GEN-LAST:event_lbCerrarMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        update.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void bSolicitudesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSolicitudesMousePressed
        if (listadoSolicitudes != null && !listadoSolicitudes.isEmpty()) {
            ControlSolicitud control = new ControlSolicitud(listadoSolicitudes);
            control.setVisible(true);
        }
    }//GEN-LAST:event_bSolicitudesMousePressed

    private void lbEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEnviarMouseClicked
        try {
            
            enviarChat(txtChat.getText());
            
           
            showMessage("[" + u.getId() + "]" + txtChat.getText()+"\n", "", 0, 000);
            txtChat.setText("");
        } catch (IOException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_lbEnviarMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        try {
            String peticion = c.pedirUsuarios("/obtenerusuarios", URLEncoder.encode("usuario_id", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(u.getId()), "UTF-8"));
            System.out.println("peticion = " + peticion);

            if (!peticion.isEmpty()) {
                construirListadoUsuarios(peticion);
            }

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jLabel3MouseClicked

    private void listaUsuariosUIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaUsuariosUIMouseClicked
        this.idamigo = Integer.parseInt(listaUsuariosUI.getSelectedValue());
        System.out.println("amigo = " + idamigo);
        DesactivarPaneles(false);
    }//GEN-LAST:event_listaUsuariosUIMouseClicked

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
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Chat().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelNombreUsuario;
    private javax.swing.JPanel PanelChat;
    private static javax.swing.JPanel PanelEmot;
    private javax.swing.JPanel PanelMain;
    private javax.swing.JPanel PanelNotificaciones;
    private javax.swing.JLabel bSolicitudes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbArchivos;
    private javax.swing.JLabel lbCerrar;
    private javax.swing.JLabel lbEnviar;
    private javax.swing.JList<String> listaUsuariosUI;
    public javax.swing.JTextPane txtAreaChat;
    public javax.swing.JTextArea txtChat;
    // End of variables declaration//GEN-END:variables

    public void setListadoSolicitudes(String listadoSolicitudes) {
        this.listadoSolicitudes = listadoSolicitudes;
    }

    void datosUser(String usr, String pass, String estado, String bloqueado, Connection c) {
        update.cargarDatos(usr, pass, estado, bloqueado, c);
    }

    private void enviarChat(String mensaje) throws IOException {
        

        //Archivos.
        String estructura = "#MSJ||FQLSHP||" +u.getId()+"||"+idamigo+"||"+mensaje+"\n";
        System.out.println("estructura = " + estructura);
        clienteSocket.enviar(estructura);

    }

    /*
    Metodos para Cargar Emoticons
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     */
    public String getStyleFont() {
        return styleFont;
    }

    public void insertEmoticon(ImageIcon ic, String atajo) {
        Style labelStyle = context.getStyle(StyleContext.DEFAULT_STYLE);
        Icon icon = ic;
        JLabel label = new JLabel(icon);
        StyleConstants.setComponent(labelStyle, label);
        try {
            styledDocument.insertString(styledDocument.getLength(), atajo, labelStyle);
            txtAreaChat.setStyledDocument(styledDocument);
        } catch (BadLocationException badLocationException) {
            System.err.println("Oops");
        }
    }

    public void showMessage(String text, Object styleConstants, int b, int color) {

//        final String newline = "\n";
//        final StringTokenizer tokenizer = new StringTokenizer(text, ":");
//        final String username = tokenizer.nextToken();
//        final String message = tokenizer.nextToken();
        LexicoAnalyzer anLex = new LexicoAnalyzer(text);
        SimpleAttributeSet attributes = new SimpleAttributeSet();
        SimpleAttributeSet attributesU = new SimpleAttributeSet();
        SimpleAttributeSet attributeSetB = new SimpleAttributeSet();
        StyleConstants.setFontFamily(attributesU, "Tahoma");
        StyleConstants.setFontFamily(attributes, styleConstants.toString());
        attributes.addAttribute(StyleConstants.CharacterConstants.Foreground, new Color(color));
        if (b == 1) {
            attributeSetB = new SimpleAttributeSet();
            attributes.addAttribute(StyleConstants.CharacterConstants.Bold, Boolean.TRUE);
            txtAreaChat.setFont(new Font(getStyleFont(), 1, 14));
        }
        if (b == 0) {
            attributeSetB = new SimpleAttributeSet();
            attributeSetB.addAttribute("Plain", Boolean.TRUE);
            txtAreaChat.setFont(new Font(getStyleFont(), 0, 14));
        }
        try {
            styledDocument.insertString(styledDocument.getLength(), "" + "", attributesU);
            String token;
            String ruta;
            ImageIcon img;
            while (anLex.hasToken()) {
                token = anLex.nextToken();
                if (Emoticons.esEmoticon(token)) {
                    ruta = Emoticons.emoticonos.get(token);
                    img = new ImageIcon(getClass().getResource(ruta));
                    insertEmoticon(img, token);
                } else {
                    styledDocument.insertString(styledDocument.getLength(), token, attributes);
                }
            }
            styledDocument.insertString(styledDocument.getLength(), "" + "", attributeSetB);
        } catch (BadLocationException ble) {
            System.err.println("Couldn't insert" + text);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "OK", "::", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

    private void construirListadoUsuarios(String peticion) {

        String[] usuarios = peticion.split("\n");

        ArrayList<Object> us = new ArrayList<>();

        for (String u : usuarios) {
            String[] data = u.split("\\|\\|");
            us.add(new Usuario(Integer.valueOf(data[0]), data[1]));
        }

        Object opcion = JOptionPane.showInputDialog(null, "Selecciona un color", "Elegir", JOptionPane.QUESTION_MESSAGE, null, us.toArray(), null);
        if (opcion != null) {
            try {
                Usuario seleccionado = (Usuario) opcion;

                System.out.println("ID " + seleccionado.getId());

                String parametros = URLEncoder.encode("de", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(u.getId()), "UTF-8") + "&"
                        + URLEncoder.encode("para", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(seleccionado.getId()), "UTF-8");

                System.out.println("Parametros " + parametros);

                //enviar solicitud de amistad
                String resSolicitud = c.enviarInfoEndPoint("/enviarsolicitud", parametros);

                if (resSolicitud.equals("704")) {
                    JOptionPane.showMessageDialog(this, "Solicitud de Amistad Enviada!");
                }

                System.out.println("REspuesta Soliucitud amistad " + resSolicitud);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void actualiarUIAmigosActivos(String listadoAmigos) {

        DefaultListModel modelo = new DefaultListModel();

        String[] amigos = listadoAmigos.split("&&");

        for (String u : amigos) {
            modelo.addElement(u);
        }

        listaUsuariosUI.setModel(modelo);
    }

    private void cerrarSesion() {
        clienteSocket.enviar("#DESCONECTAR||FQLSHP||" + u.getId() + "||s3rv1d0r||" + u.getId() + "\n");
        System.exit(0);
    }

    private void DesactivarPaneles(boolean parametro) {
        if (parametro) {
            txtChat.setEnabled(false);
            PanelEmot.setEnabled(false);
            lbArchivos.setEnabled(false);
            lbEnviar.setEnabled(false);
        } else {
            txtChat.setEnabled(true);
            PanelEmot.setEnabled(true);
            lbArchivos.setEnabled(true);
            lbEnviar.setEnabled(true);
        }

    }

}
