/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import javax.swing.JFrame;

/**
 *
 * @author supaschai
 */
public class BackFrameBefore {
    public static JFrame frameBefore;
    public static JFrame curFrame;
    public static boolean stop = false;
    public static void back(){
        if (frameBefore != null && !stop) {
            frameBefore.setLocation(curFrame.getLocation().x, curFrame.getLocation().y);
            frameBefore.setSize(curFrame.getWidth(), curFrame.getHeight());
            frameBefore.setVisible(true);
        }
    }
    public static void justBack(){
        if (frameBefore != null) {
            frameBefore.setVisible(true);
        }
    }
}
