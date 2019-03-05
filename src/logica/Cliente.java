/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
    private BufferedReader entradaDatos;

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
            entradaDatos = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("entradaDatos = " + entradaDatos);
            System.out.println("... Definiendo flujos de I/O");


        // readMessage thread 
        Thread readMessage = new Thread(new Runnable() {
            @Override
            public void run() {
                
                while (true) {
                    try {
                        // read the message sent to this client 
                        String mensaje = entradaDatos.readLine()+"\n";
                        
                        HashMap<String, String> p = Utilidades.parametros(mensaje);
                        
                        String accion = p.get("tipo");

                        if (null != accion) //si accion es Enviar Mensaje:
                        switch (accion) {
                            case Acciones._MSJ:
                                TareasCliente.mensaje(p);
                                //ventana.txtAreaChat.setText(p.get("msj"));
                                ventana.showMessage("[" + p.get("origen") + "]" + p.get("msj")+"\n"+ "", ventana, 0, 000);
                                break;
                            case Acciones._ARCHIVO:
                                TareasCliente.archivo(p);                                
                                break;
                            case Acciones._LISTAUSUARIOS:
                                //TareasCliente.listadoAmigos(p);
                                ventana.actualiarUIAmigosActivos(p.get("listado"));
                                break;
                            case Acciones._SOLICITUDES:
                                //TareasCliente.solicitudes(p);                               
                                ventana.setListadoSolicitudes(p.get("listado"));
                                break;
                            default:
                                break;
                        }
                        
                    } catch (IOException e) {
                        
                        e.printStackTrace();
                    }
                }
            }
        });
        
        
        readMessage.start();


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

        try {
            //String t = "#MSJ||FQLSHP||c0||c1||Hola :)";//String.format("%s|%s|%s", nombre, color.getRGB(), msj);
            //salidaDatos.writeBytes(t + "\n");
            //System.out.println("msj??? " + msj);
            //this.msj = msj;
            salidaDatos.writeBytes(msj + "\n");
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
