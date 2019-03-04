package logica;

// Java implementation for multithreaded chat client 
// Save file as Client.java 
import java.io.*;
import java.net.*;
import java.util.HashMap;

public class Client {

    final static int IPSERVER = 2300;

    public void emitir(String mensaje) throws UnknownHostException, IOException {
        
        // Establecer Conexion por Socket 
        Socket s = new Socket( "ceam-csp.me", IPSERVER);
        System.out.println("s = " + s);

        // Obtener flujos de entrada y salida
        DataInputStream flujoEntrada = new DataInputStream(s.getInputStream());
        DataOutputStream flujoSalida = new DataOutputStream(s.getOutputStream());

        // sendMessage thread 
        Thread sendMessage = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        // write on the output stream 
                        flujoSalida.writeUTF(mensaje);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // readMessage thread 
        Thread readMessage = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    try {
                        // read the message sent to this client 
                        String mensaje = flujoEntrada.readUTF();

                        HashMap<String, String> p = Utilidades.parametros(mensaje);

                        String accion = p.get("tipo");

                        if (null != accion) //si accion es Enviar Mensaje:
                        {
                            switch (accion) {
                                case Acciones._MSJ:
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

                    } catch (IOException e) {

                        e.printStackTrace();
                    }
                }
            }
        });

        sendMessage.start();
        readMessage.start();
    }
}
