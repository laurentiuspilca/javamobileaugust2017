/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author student
 */
public class Demo {

    private static MainFrame frame;
    
    public static void main(String[] args) throws Exception {
        frame = new MainFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        ServerSocket ss = new ServerSocket(4444);
        while (true) {
            try {
                Socket socket = ss.accept();
                BufferedReader in = 
                    new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));
                
                String message = in.readLine();
                if ("1234".equalsIgnoreCase(message)) {
                    frame.open();
                } else {
                    frame.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
