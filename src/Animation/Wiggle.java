/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Animation;

/**
 *
 * @author supaschai
 */
import java.lang.Thread;
import javax.swing.*;

public class Wiggle implements Runnable {

    private static JTable stackCode;
    private static int pointerPosition;

    public static JTable getStackCode() {
        return stackCode;
    }

    public static void setStackCode(JTable stackCode) {
        Wiggle.stackCode = stackCode;
    }

    public static int getPointerPosition() {
        return pointerPosition;
    }

    public static void setPointerPosition(int pointerPosition) {
        Wiggle.pointerPosition = pointerPosition;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(500);
                //System.out.println(0);
                //System.out.println(stackCode.getValueAt(pointerPosition, 2));
                stackCode.setValueAt("<--", pointerPosition, 2);
                Thread.sleep(600);
                //System.out.println(1);
                stackCode.setValueAt("", pointerPosition, 2);
                
                //System.out.println(pointerPosition);
                
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
