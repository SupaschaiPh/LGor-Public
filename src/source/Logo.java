/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author supaschai
 */
public class Logo extends JPanel{
    public static ImageIcon img = new ImageIcon("image/logo.png");

    @Override
    public void paint(Graphics g) {
        //super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        g.drawImage(img.getImage(), 0, 0,this.getWidth(),this.getHeight(),this);
    }
    
}
