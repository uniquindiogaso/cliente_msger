/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gusta
 */
public class TareasCliente {

    public static void mensaje(HashMap<String, String> p) {        
        System.out.println(p.get("origen") + " : " + p.get("msj"));
    }

    public static void archivo(HashMap<String, String> p) {
        try {
            System.out.println("Recibiendo Archivo ....");
            String nombreArchivo = p.get("n_archivo");
            byte[] archivoRecibido = Archivos.decodeArchivo(p.get("base64"));
            FileOutputStream imageOutFile = new FileOutputStream(nombreArchivo);
            imageOutFile.write(archivoRecibido);
            imageOutFile.close();
            System.out.println("Archivo Recibido ....");

            //TODO: Ruta de trabajo archivos
            String ruta = Archivos.rutaAlmacenamiento(nombreArchivo, Archivos.Tipos.ARCHIVO);
            System.out.println("Ruta: " + ruta);
        } catch (IOException ex) {
            Logger.getLogger(TareasCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void listadoAmigos(HashMap<String, String> p) {
        System.out.println(p.get("destino") + ") : usuarios conectados " + p.get("listado"));
    }

    public static void solicitudes(HashMap<String, String> p) {
        System.out.println(p.get("destino") + ") : solicitudes " + p.get("listado"));
    }

}
