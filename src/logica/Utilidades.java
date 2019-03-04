/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * @author gusta
 */
public class Utilidades {

    public static HashMap<String, String> parametros(String mensaje) {
        HashMap<String, String> res = new HashMap<>();

        //System.out.println("[Parametros] str " + mensaje);
        StringTokenizer st = new StringTokenizer(mensaje, "||");
        String accion = st.nextToken();
        res.put("tipo", accion);
        res.put("token", st.nextToken());
        res.put("origen", st.nextToken());
        res.put("destino", st.nextToken());

        if (Acciones._MSJ.equals(accion)) {
            res.put("msj", st.nextToken());
        } else if (Acciones._ARCHIVO.equals(accion)) {
            res.put("n_archivo", st.nextToken());
            res.put("base64", st.nextToken());
        } else if (Acciones._LISTAUSUARIOS.equals(accion)) {
            res.put("listado", st.nextToken());
        } else if (Acciones._SOLICITUDES.equals(accion)) {
            res.put("listado", st.nextToken());
        }

        System.out.println("Parametros Recibidos " + res.size());

        return res;
    }

}
