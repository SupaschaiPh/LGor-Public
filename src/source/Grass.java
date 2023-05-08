/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

import java.awt.*;
import javax.swing.*;


/**
 *
 * @author supaschai
 */
public class Grass extends JPanel{
    private Image img = new ImageIcon("image/grass.png").getImage();
    public static ImageIcon icon = new ImageIcon("image/grass.png");
    public static Color color = new Color(192,212,112);
    public Grass(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public Grass(LayoutManager layout) {
        super(layout);
    }

    public Grass(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public Grass() {
        this.setLayout(new BorderLayout());
        this.setOpaque(true);
    }
    
    @Override
    public void paintComponent(Graphics g){
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Grass.color);
        g2d.fillRect(0, 0, this.getSize().width, this.getSize().height);
        g2d.drawImage(img, 0, 0,this.getSize().width, this.getSize().height ,this);
        
        
    }

    public Image getImg() {
        return img;
    }

    public static ImageIcon getIcon() {
        return icon;
    }

    public static void setIcon(ImageIcon icon) {
        Grass.icon = icon;
    }
    
}
