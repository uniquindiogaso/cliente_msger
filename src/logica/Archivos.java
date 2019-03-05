package logica;

import java.util.Base64;

/**
 *
 * @author gusta
 */
public class Archivos {

    public static String encodeArchivo(byte[] archivoByteArray) {
        return Base64.getEncoder().encodeToString(archivoByteArray);
    }

    public static byte[] decodeArchivo(String archivoDataString) {
        return Base64.getDecoder().decode(archivoDataString);
    }

    public static String encodeMensaje(String msj) {
        return Base64.getEncoder().encodeToString(msj.getBytes());
    }

    public static byte[] decodeMensaje(String msj) {
        return Base64.getDecoder().decode(msj.getBytes());
    }

    public static String rutaAlmacenamiento(String nombreArchivo, Tipos tipo) {
        System.out.println("[home] Ruta de Almacenamiento ..." + System.getProperty("user.home"));
        System.out.println("[dir] Ruta de Almacenamiento ..." + System.getProperty("user.dir"));
        String s = System.getProperty("file.separator");
        String ruta = System.getProperty("user.home");
        String recurso = "recibidos";

        if (tipo.equals(Tipos.ARCHIVO)) {
            ruta = ruta + s + "recibidos" + s + nombreArchivo;
        }

        if (tipo.equals(Tipos.MEME)) {
            recurso = "memes";
        }

        ruta = ruta + s + recurso + s + nombreArchivo;

        return ruta;
    }

    public enum Tipos {
        ARCHIVO, MEME;
    }
}
