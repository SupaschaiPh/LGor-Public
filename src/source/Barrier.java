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
public class Barrier extends JPanel {

    Image img = new ImageIcon("image/barrier.png").getImage();
    public static ImageIcon icon = new ImageIcon("image/barrier.png");
    public static ImageIcon iconWithGrass = new ImageIcon("image/withGrass/barrier.png");

    public Barrier(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public Barrier(LayoutManager layout) {
        super(layout);
    }

    public Barrier(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public Barrier() {
        this.setLayout(new BorderLayout());
        this.setOpaque(true);

    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, 5, 5, this.getSize().width - 10, this.getSize().height - 10, this);

    }

    public Image getImg() {
        return img;
    }

}
