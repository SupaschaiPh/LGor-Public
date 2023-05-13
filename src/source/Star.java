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
public class Star extends JPanel{
    private Image fullStar = new ImageIcon("image/icon/image1x3.png").getImage(),
            halfStar = new ImageIcon("image/icon/image2x3.png").getImage(),
            emptyStar = new ImageIcon("image/icon/image3x3.png").getImage();
    public static ImageIcon icon = new ImageIcon("image/icon/image1x3.png");
    public static Color color = new Color(222,212,000);
    public static int full = 1,half = 2,empty = 3;
    private int starType;
    public Star(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public Star(LayoutManager layout) {
        super(layout);
        this.setOpaque(true);
    }

    public Star(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public Star() {
        this.setLayout(new BorderLayout());
    }
    
    public Star(int starType){
        this.starType = starType;
    }
    
    @Override
    public void paintComponent(Graphics g){
        Image img = null;
        if(this.starType == 1){
            img = fullStar;
        }else if(this.starType == 2){
            img = halfStar;
        }else if(this.starType == 3){
            img = emptyStar;
        }
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(img, 0, 0,this.getSize().width, this.getSize().height ,this);
        
        
    }

    public Image getImg() {
        return fullStar;
    }

    public static ImageIcon getIcon() {
        return icon;
    }

    public static void setIcon(ImageIcon icon) {
        Star.icon = icon;
    }
    
}
