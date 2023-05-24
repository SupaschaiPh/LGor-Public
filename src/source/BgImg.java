/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author supaschai
 */
public class BgImg extends JPanel {

    Image img = new ImageIcon("image/LGorBG.png").getImage();
    Image img2 = new ImageIcon("image/LGorBGNight.png").getImage();
    Image img3 = new ImageIcon("image/LGorBGDay.png").getImage();

    private int bgType = 0;

    public BgImg(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public BgImg(LayoutManager layout) {
        super(layout);
    }

    public BgImg(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public BgImg(int bgType) {
        this.bgType = bgType;
        this.setLayout(new BorderLayout());
        this.setOpaque(true);

    }

    public BgImg() {
        this.setLayout(new BorderLayout());
        this.setOpaque(true);

    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (this.bgType == 0) {
            g2d.drawImage(img, 0, 0, this.getSize().width, this.getSize().height, this);
        } else if (this.bgType == 1) {
            g2d.drawImage(img2, 0, 0, this.getSize().width, this.getSize().height, this);
        } else if (this.bgType == 2) {
            g2d.drawImage(img3, 0, 0, this.getSize().width, this.getSize().height, this);
        }
    }

    public Image getImg() {
        return img;
    }

    public Image getImg2() {
        return img2;
    }

    public void setImg2(Image img2) {
        this.img2 = img2;
    }

    public int getBgType() {
        return bgType;
    }

    public void setBgType(int bgType) {
        this.bgType = bgType;
    }

}
