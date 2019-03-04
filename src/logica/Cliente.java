/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import views.Chat;

public class Cliente {

    public static final int PORT = 1234;
    public static final String SERVER_LOCATION = "localhost";

    private Socket clientSocket;
    private DataOutputStream salidaDatos;
    private DataInputStream entradaDatos;

    private Usuario u;
    private Chat ventana;

    private String msj = ""; //TODO .. ¿SIRVE PARA ALGO?

    public Cliente(Usuario u, Chat ventana) {
        try {
            this.u = u;
            this.ventana = ventana;

            InetAddress ip = InetAddress.getByName(SERVER_LOCATION);
            clientSocket = new Socket(ip, PORT);

            salidaDatos = new DataOutputStream(clientSocket.getOutputStream());
            entradaDatos = new DataInputStream(clientSocket.getInputStream());

            System.out.println("... Definiendo flujos de I/O");

            Thread sendMessage = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        // read the message to deliver. 
                        String entrada = msj;
                        try {
                            // write on the output stream 
                            salidaDatos.writeUTF(entrada);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            Thread escuchador = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {

                            // if (!clientSocket.isClosed() && entradaDatos.ready()) {
                            String mensaje = entradaDatos.readUTF();
                            System.out.println("Mensaje :\n" + mensaje);

                            HashMap<String, String> p = Utilidades.parametros(mensaje);

                            String accion = p.get("tipo");

                            if (null != accion) //si accion es Enviar Mensaje:
                            {
                                switch (accion) {
                                    case Acciones._MSJ:
                                        //aqui enviamos a gui
                                        TareasCliente.mensaje(p);
                                        break;
                                    case Acciones._ARCHIVO:
                                        TareasCliente.archivo(p);
                                        break;
                                    case Acciones._LISTAUSUARIOS:
                                        TareasCliente.listadoAmigos(p);
                                        break;
                                    case Acciones._SOLICITUDES:
                                        TareasCliente.solicitudes(p);
                                        break;
                                    default:
                                        break;
                                }
                            }

                            //}
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("Comunicación finalizada!!!!");
                            // break;
                        }
                    }
                }
            });

            sendMessage.start();
            escuchador.start();
//           

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    /**
     * Permite enviar el mensaje a todos los demas
     *
     * @param msj
     */
    public void enviar(String msj) {

        //String t = "#MSJ||FQLSHP||c0||c1||Hola :)";//String.format("%s|%s|%s", nombre, color.getRGB(), msj);
        //salidaDatos.writeBytes(t + "\n");
        System.out.println("msj??? " + msj);
        this.msj = msj;

    }

}
