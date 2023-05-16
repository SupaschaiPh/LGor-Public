/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import view.AllTitle;
import view.MapView;

/**
 *
 * @author supaschai
 */
public class Character extends JPanel implements Runnable {

    private static HashMap<String, Image> charTile = new HashMap();
    private static Image go1 = new ImageIcon("image/character/row-1-column-1.png").getImage(),
            go2 = new ImageIcon("image/character/row-1-column-2.png").getImage(),
            go3 = new ImageIcon("image/character/row-1-column-3.png").getImage(),
            go4 = new ImageIcon("image/character/row-1-column-4.png").getImage(),
            back1 = new ImageIcon("image/character/row-2-column-1.png").getImage(),
            back2 = new ImageIcon("image/character/row-2-column-2.png").getImage(),
            back3 = new ImageIcon("image/character/row-2-column-3.png").getImage(),
            back4 = new ImageIcon("image/character/row-2-column-4.png").getImage(),
            left1 = new ImageIcon("image/character/row-3-column-1.png").getImage(),
            left2 = new ImageIcon("image/character/row-3-column-2.png").getImage(),
            left3 = new ImageIcon("image/character/row-3-column-3.png").getImage(),
            left4 = new ImageIcon("image/character/row-3-column-4.png").getImage(),
            right1 = new ImageIcon("image/character/row-4-column-1.png").getImage(),
            right2 = new ImageIcon("image/character/row-4-column-2.png").getImage(),
            right3 = new ImageIcon("image/character/row-4-column-3.png").getImage(),
            right4 = new ImageIcon("image/character/row-4-column-4.png").getImage();
    public static ImageIcon icon = new ImageIcon("image/character/row-1-column-1.png");
    public static ImageIcon icon1WithGrass = new ImageIcon("image/withGrass/charFront.png"),
            icon2WithGrass = new ImageIcon("image/withGrass/charBack.png"),
            icon3WithGrass = new ImageIcon("image/withGrass/charLeft.png"),
            icon4WithGrass = new ImageIcon("image/withGrass/charRight.png");
    public static int actionIdwaitG = 1,actionIdwaitB = 2, actionIdwaitL = 3,actionIdwaitR = 4;
    static {
        charTile.put("go1", go1);
        charTile.put("go2", go2);
        charTile.put("go3", go3);
        charTile.put("go4", go4);
        charTile.put("back1", back1);
        charTile.put("back2", back2);
        charTile.put("back3", back3);
        charTile.put("back4", back4);
        charTile.put("left1", left1);
        charTile.put("left2", left2);
        charTile.put("left3", left3);
        charTile.put("left4", left4);
        charTile.put("right1", right1);
        charTile.put("right2", right2);
        charTile.put("right3", right3);
        charTile.put("right4", right4);
    }
    private static int speed = 200;
    private int x = 0, y = 0, xi = 0, yi = 0;
    private boolean stillWalking = false;
    private MapView mv;
    private int countItem = 0;
    private String curTile = "go1";
    private String action = "waitG";
    private String curAction = "walk"; //walk or wait
    private boolean meetCow = false;
    private boolean alive = true, meetItem = false;
    private int step = 10;
    private int sep = 20;
    private int divForCalculateMapBolck = 3;

    public Character() {
        //this.setBackground(Theme.Transparent);
    }

    public Character(MapView mv) {
        this.mv = mv;
        this.setLayout(new BorderLayout());
        this.setOpaque(true);

    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(new Grass().getImg(), 0, 0, this.getSize().width, this.getSize().height, this);

        if (!this.alive && mv != null && mv.getMap()[mv.getCharaterPosition()[0]][mv.getCharaterPosition()[1]] == ElementId.Barrier) {
            g2d.drawImage(new Grass().getImg(), 0, 0, this.getSize().width, this.getSize().height, this);
            g2d.drawImage(new Barrier().getImg(), 5, 5, this.getSize().width - 10, this.getSize().height - 10, this);

        } else if (meetItem) {
            g2d.drawImage(new Item().getImg(), -10, -10, this.getSize().width + 20, this.getSize().height + 20, this);
        }

        g2d.drawImage(charTile.get(curTile), x - 10, y - 10, this.getSize().width + 20, this.getSize().height + 20, this);

        if (this.alive) {
            g2d.setColor(new Color(0, 255, 0, 0));
        } else {
            g2d.setColor(new Color(255, 0, 0, 50));

        }
        if (this.mv != null && this.isMeetCow()) {

            g2d.drawImage(new Cow().getCow1(), 0, 0, this.getSize().width, this.getSize().height, this);
            g2d.setColor(new Color(0, 255, 0, 50));
        }

        g2d.fillRect(0, 0, this.getSize().width, this.getSize().height);

    }

    public static HashMap<String, Image> getCharTile() {
        return charTile;
    }

    public static void setCharTile(HashMap<String, Image> charTile) {
        Character.charTile = charTile;
    }

    public String getCurTile() {
        return curTile;
    }

    public void setCurTile(String curTile) {
        this.curTile = curTile;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        if (action.indexOf("go") != -1) {
            this.walk(action);
        } else {
            this.action = action;
        }
    }

    public boolean isMeetItem() {
        return meetItem;
    }

    public void setMeetItem(boolean meetItem) {
        this.meetItem = meetItem;
    }

    public boolean isStillWalking() {
        return stillWalking;
    }

    public void setStillWalking(boolean stillWalking) {
        this.stillWalking = stillWalking;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        Character.speed = speed;
    }

    public int getCountItem() {
        return countItem;
    }

    public void setCountItem(int countItem) {
        this.countItem = countItem;
    }

    public String getCurAction() {
        return curAction;
    }

    public void setCurAction(String curAction) {
        this.curAction = curAction;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }


    public void walk(String action) {
        stillWalking = true;
        if (action.equals(AllTitle.commandList[0].replace("()", ""))) {
            //this.action = "waitG";
            this.action = "go";
            this.y = this.getSize().height / divForCalculateMapBolck;
        } else if (action.equals(AllTitle.commandList[1].replace("()", ""))) {
            //this.action = "waitB";
            this.action = "goDown";
            this.y = -this.getSize().height / divForCalculateMapBolck;
        } else if (action.equals(AllTitle.commandList[2].replace("()", ""))) {
            //this.action = "waitL";
            this.action = "goLeft";
            this.x = this.getSize().width / divForCalculateMapBolck;
        } else if (action.equals(AllTitle.commandList[3].replace("()", ""))) {
            //this.action = "waitR";
            this.action = "goRight";
            this.x = -this.getSize().width / divForCalculateMapBolck;
        } else if (action.equals(AllTitle.commandList[0].replace("()", "2"))) {
            this.action = "go2";
            this.y = 0;
        } else if (action.equals(AllTitle.commandList[1].replace("()", "2"))) {
            this.action = "goDown2";
            this.y = 0;
        } else if (action.equals(AllTitle.commandList[2].replace("()", "2"))) {
            this.action = "goLeft2";
            this.x = 0;
        } else if (action.equals(AllTitle.commandList[3].replace("()", "2"))) {
            this.action = "goRight2";
            this.x = 0;
        }
    }

    public void keep() {
        if (mv.getMap()[mv.getCharaterPosition()[0]][mv.getCharaterPosition()[1]] == ElementId.Item) {
            this.countItem += 1;
            mv.setMapAt(mv.getCharaterPosition()[0], mv.getCharaterPosition()[1], 0);
            mv.changeCountItem();
            this.setMeetItem(false);
            this.repaint();
        }
    }

    public boolean isMeetCow() {
        return meetCow;
    }

    public void setMeetCow(boolean meetCow) {
        this.meetCow = meetCow;
    }

    public void meetCow() {
        this.meetCow = meetCow;
        if (mv.getMap()[mv.getCharaterPosition()[0]][mv.getCharaterPosition()[1]] == ElementId.Cow) {
            this.setMeetCow(true);
        } else {
            this.setMeetCow(false);
        }
    }

    public void die() {
        this.setMeetCow(false);
        this.setAlive(false);
        this.mv.changealiveLable();
    }

    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        this.setOpaque(true);
        try {
            while (true) {
                if (this.action.equals("waitG")) {
                    stillWalking = false;
                    this.y = 0;
                    this.x = 0;
                    Thread.sleep(speed);
                    this.setCurTile("back1");
                    this.repaint();
                    Thread.sleep(speed);
                    this.setCurTile("back2");
                    this.repaint();
                } else if (this.action.equals("waitB")) {
                    stillWalking = false;
                    this.y = 0;
                    this.x = 0;
                    Thread.sleep(speed);
                    this.setCurTile("go1");
                    this.repaint();
                    Thread.sleep(speed);
                    this.setCurTile("go2");
                    this.repaint();
                } else if (this.action.equals("waitL")) {
                    stillWalking = false;
                    this.y = 0;
                    this.x = 0;
                    Thread.sleep(speed);
                    this.setCurTile("left1");
                    this.repaint();
                    Thread.sleep(speed);
                    this.setCurTile("left2");
                    this.repaint();
                } else if (this.action.equals("waitR")) {
                    stillWalking = false;
                    this.y = 0;
                    this.x = 0;
                    Thread.sleep(speed);
                    this.setCurTile("right1");
                    this.repaint();
                    Thread.sleep(speed);
                    this.setCurTile("right2");
                    this.repaint();
                } else if (this.action.equals("go")) {
                    if (this.y <= this.sep) {
                        this.y = 0;
                        this.action = "waitG";
                    } else {
                        this.y -= this.step;
                    }
                    System.out.println(y);
                    Thread.sleep(speed);
                    this.setCurTile("back3");
                    this.repaint();
                    Thread.sleep(speed);
                    this.setCurTile("back4");
                    this.repaint();
                } else if (this.action.equals("goDown")) {
                    if (this.y >= -this.sep) {
                        this.y = 0;
                        this.action = "waitB";
                    } else {
                        this.y += this.step;
                    }
                    Thread.sleep(speed);
                    this.setCurTile("go3");
                    this.repaint();
                    Thread.sleep(speed);
                    this.setCurTile("go4");
                    this.repaint();
                } else if (this.action.equals("goLeft")) {
                    if (this.x <= this.sep) {
                        this.x = 0;
                        this.action = "waitL";
                    } else {
                        this.x -= this.step;
                    }
                    Thread.sleep(speed);
                    this.setCurTile("left3");
                    this.repaint();
                    Thread.sleep(speed);
                    this.setCurTile("left4");
                    this.repaint();
                } else if (this.action.equals("goRight")) {
                    if (this.x >= -this.sep) {
                        this.x = 0;
                        this.action = "waitR";
                    } else {
                        this.x += this.step;
                    }
                    Thread.sleep(speed);
                    this.setCurTile("right1");
                    this.repaint();
                    Thread.sleep(speed);
                    this.setCurTile("right2");
                    this.repaint();
                } else if (this.action.equals("go2")) {
                    if (this.y <= -this.getSize().height/divForCalculateMapBolck) {
                        this.action = "waitG";
                    } else {
                        this.y -= this.step;
                    }
                    Thread.sleep(speed);
                    this.setCurTile("back3");
                    this.repaint();
                    Thread.sleep(speed);
                    this.setCurTile("back4");
                    this.repaint();
                } else if (this.action.equals("goDown2")) {
                    if (this.y >= this.getSize().height/divForCalculateMapBolck) {
                        this.action = "waitB";
                    } else {
                        this.y += this.step;
                    }
                    Thread.sleep(speed);
                    this.setCurTile("go3");
                    this.repaint();
                    Thread.sleep(speed);
                    this.setCurTile("go4");
                    this.repaint();
                } else if (this.action.equals("goLeft2")) {
                    if (this.x <= -this.getSize().width/divForCalculateMapBolck) {
                        this.action = "waitL";
                    } else {
                        this.x -= this.step;
                    }
                    Thread.sleep(speed);
                    this.setCurTile("left3");
                    this.repaint();
                    Thread.sleep(speed);
                    this.setCurTile("left4");
                    this.repaint();
                } else if (this.action.equals("goRight2")) {
                    if (this.x >= this.getSize().width/divForCalculateMapBolck) {
                        this.action = "waitR";
                    } else {
                        this.x += this.step;
                    }
                    Thread.sleep(speed);
                    this.setCurTile("right1");
                    this.repaint();
                    Thread.sleep(speed);
                    this.setCurTile("right2");
                    this.repaint();
                }

            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
}
