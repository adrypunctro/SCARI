/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gui.GUIJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;

/**
 *
 * @author ASimionescu
 */
public class Main {

    static boolean appConnected = false;
    static BufferedWriter outBuff = null;
    static GUIJFrame gui = new GUIJFrame();
    static String InputText = "";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        gui.setManager(new Manager());
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               gui.setVisible(true);
            }
        });
        
        gui.getContinueBtn().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                InputText = gui.getInputText();
                System.out.println("Input text: "+InputText);
                gui.setPhrase(InputText);
                gui.hideStep1();
                gui.showStep2();
            }
        });
        
        gui.getBackBtn().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                gui.hideStep2();
                gui.showStep1();
            }
        });
        
    }
    
}
