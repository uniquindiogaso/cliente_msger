/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author proxc
 */
public class StartApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    new views.Login().setVisible(true);
                } catch (InterruptedException | UnsupportedEncodingException ex) {
                    Logger.getLogger(StartApp.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        runnable.run();
    }

}
