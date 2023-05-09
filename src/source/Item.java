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
public class Item extends JPanel {

    Image img = new ImageIcon("image/item1/image1x1.png").getImage();
    public static ImageIcon icon = new ImageIcon("mage/item1/image1x1.png");
    public static ImageIcon iconWithGrass = new ImageIcon("image/withGrass/item.png");

    public Item(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public Item(LayoutManager layout) {
        super(layout);
    }

    public Item(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public Item() {
    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, -10, -10, this.getSize().width + 20, this.getSize().height + 20, this);

    }

    public Image getImg() {
        return img;
    }

}
