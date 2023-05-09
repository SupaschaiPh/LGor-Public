/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

import java.awt.*;
import java.util.HashMap;
import javax.swing.*;

/**
 *
 * @author supaschai
 */
public class Cow extends JPanel implements Runnable {

    private static HashMap<String, Image> charTile = new HashMap();
    private static Image cow1 = new ImageIcon("image/cow/image1x1.png").getImage(),
            cow2 = new ImageIcon("image/cow/image2x1.png").getImage(),
            cow3 = new ImageIcon("image/cow/image3x1.png").getImage();
    public static ImageIcon icon = new ImageIcon("mage/cow/image1x1.png");
    public static ImageIcon iconWithGrass = new ImageIcon("image/withGrass/cow.png");
    static {
        charTile.put("cow1", cow1);
        charTile.put("cow2", cow2);
        charTile.put("cow3", cow3);
    }
    private static int speed = 500;
    private String curTile = "cow1";

    public Cow(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public Cow(LayoutManager layout) {
        super(layout);
    }

    public Cow(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public Cow() {
        this.setLayout(new BorderLayout());
        this.setOpaque(true);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(255, 255, 0, 50));

        //g2d.fillRect(0, 0, this.getSize().width, this.getSize().height);
        g2d.drawImage(new Grass().getImg(),0,0,this.getSize().width, this.getSize().height, this);
        g2d.drawImage(charTile.get(curTile), 0, 0, this.getSize().width, this.getSize().height, this);

    }

    @Override
    public void run() {
        try {
            while (true) {
                this.curTile = "cow1";
                this.repaint();
                Thread.sleep(speed);
                this.curTile = "cow2";
                this.repaint();
                Thread.sleep(speed/2);
                this.curTile = "cow3";
                this.repaint();
                Thread.sleep(speed);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static HashMap<String, Image> getCharTile() {
        return charTile;
    }

    public static Image getCow1() {
        return cow1;
    }

    public static Image getCow2() {
        return cow2;
    }

    public static Image getCow3() {
        return cow3;
    }

    public static int getSpeed() {
        return speed;
    }

    public String getCurTile() {
        return curTile;
    }


}
