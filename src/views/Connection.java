/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author Juan
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Connection {

    private static Connection conexion;

    public Connection() {
    }

    public void prueba() {
        System.out.println("Ejecutando conexion ....");
        try {

            String data = URLEncoder.encode("usr", "UTF-8") + "=" + URLEncoder.encode("juan", "UTF-8");
            data += "&" + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode("juan", "UTF-8");
            Socket socket = new Socket("localhost", 8000);

            String path = "/status";
            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF8"));
            wr.write("POST " + path + " HTTP/1.0\r\n");
            wr.write("Content-Length: " + data.length() + "\r\n");
            wr.write("Content-Type: application/x-www-form-urlencoded\r\n");
            wr.write("\r\n");

            wr.write(data);
            wr.flush();

            BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }
            wr.close();
            rd.close();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No logramos conectarte con un servidor, inténtalo más tarde.", "Oops! algo va mal", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    public Connection(String conexion) {

    }

    public static Connection getSingletonInstance(String nombre) {
        if (conexion == null) {
            new Connection(nombre);
        } else {
            System.out.println("No se puede crear el objeto, ya existe una instancia");
        }
        return conexion;
    }

}
