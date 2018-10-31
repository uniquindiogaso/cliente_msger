/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4;

/**
 *
 * @author Juan
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;

/**
 *
 *
 */
public class Connection
{

  public static void main(String[] args)
  {
    new Connection();
  }
  
  public Connection()
  {
    String testServerName = "localhost";
    int port = 6969;
    try
    {
      // Abre un socketGET /\n\n"
      Socket socket = openSocket(testServerName, port);
      
      // write-to, and read-from the socket.
      // Escribiendo un comando simple al servidor web
      String result = writeToAndReadFromSocket(socket, "hola :D");
      
      // Pintando el resultado de la respuesta del server
      System.out.println(result);

      // Cerrando el socket
      socket.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  private String writeToAndReadFromSocket(Socket socket, String writeTo) throws Exception
  {
    try 
    {
      // write text to the socket
      BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      bufferedWriter.write(writeTo);
      bufferedWriter.flush();
      
      // read text from the socket
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      StringBuilder sb = new StringBuilder();
      String str;
      while ((str = bufferedReader.readLine()) != null)
      {
        sb.append(str + "\n");
      }
      
      // close the reader, and return the results as a String
      bufferedReader.close();
      return sb.toString();
    } 
    catch (IOException e) 
    {
      e.printStackTrace();
      throw e;
    }
  }
  
  /**
   * Open a socket connection to the given server on the given port.
   * This method currently sets the socket timeout value to 10 seconds.
   * (A second version of this method could allow the user to specify this timeout.)
   */
  private Socket openSocket(String server, int port) throws Exception
  {
    Socket socket;
    
    // creando un socket con tiempo máximo de espera
    try
    {
      InetAddress inteAddress = InetAddress.getByName(server);
      SocketAddress socketAddress = new InetSocketAddress(inteAddress, port);
  
      // Creando un socket
      socket = new Socket();
  
      // Tiempo máximo permitido 10 segundos
      int timeoutInMs = 10*1000;  
      socket.connect(socketAddress, timeoutInMs);
      
      return socket;
    } 
    catch (SocketTimeoutException ste) 
    {
      System.err.println("Tiempo agotado esperando respuesta del socket.");
      ste.printStackTrace();
      throw ste;
    }
  }

}