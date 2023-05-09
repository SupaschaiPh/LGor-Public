/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lgor;

import control.BackFrameBefore;
import control.PlayGroundCon;
import javax.swing.JFrame;
import model.Problem;

/**
 *
 * @author supaschai
 */
public class Tutorial implements Runnable {

    private PlayGroundCon playGround;
    private int Ep = 1;

    public Tutorial() {
        playGround = new PlayGroundCon(1, this.t1(), null);

    }

    public Problem returnStory() {
        if (this.Ep == 1) {
            return t1();
        } else if (this.Ep == 2) {
            return t2();
        } else if (this.Ep == 3) {
            return t3();
        } else if (this.Ep == 4) {
            return t4();
        } else {
            return null;
        }
    }

    public Problem t1() {
        String name = "Ep 1 : จอนนี่จะเดินอย่างไร";
        String description = "จอนนี่เป็นสิ่งมีชีวิตอะไรก็ไม่ผมดูไม่ออก วันหนึ่งจอนนี่เห็นแม่วัวเล็มหญ้าอยู่ข้างขอบรั่ว "
                + "จอนเกิดตกหลุมรักแม่วัวขึ้น คุณจะต้องช่วยพาจอนนี่เป็นหาแม่วัวให้สำเร็จ"
                + "\nคำแนะนำ : ให้ใช้คำสั้ง goUp() เพื่อพาจอนนี่เดินขึ้นไปด้านบน";
        int rank = 0;
        int[][] map = {
            {0, 1, 1, 1, 0},
            {0, 1, 3, 1, 0},
            {0, 1, 0, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},};
        int charaterStatrPosition[] = {2, 2};
        int stackCodeSize = 1;
        String author = "Bozz";
        String anctionStartOfChar = "waitG";
        int countMustKeepItem = 0;
        return new Problem(name, description, rank, map, charaterStatrPosition, anctionStartOfChar, stackCodeSize, countMustKeepItem, author);
    }

    public Problem t2() {
        String name = "Ep 2 : จอนนี่จะเดินลง";
        String description = "แม่วัวตกใจเดินหนีจอนนี่ไปแล้ว"
                + "\nคำแนะนำ : ให้ใช้คำสั้ง goDown() เพื่อพาจอนนี่เดินลงไปด้านล่าง'";
        int rank = 0;
        int[][] map = {
            {0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0},
            {0, 1, 3, 1, 0},};
        int charaterStatrPosition[] = {0, 2};
        int stackCodeSize = 4;
        String author = "Bozz";
        String anctionStartOfChar = "waitB";
        int countMustKeepItem = 0;
        return new Problem(name, description, rank, map, charaterStatrPosition, anctionStartOfChar, stackCodeSize, countMustKeepItem, author);
    }

    public Problem t3() {
        String name = "Ep 3 : จอนนี่จะเดินซ้าย";
        String description = "จอนนี่อยากไปซ้ายบ้าง"
                + "\nคำแนะนำ : ให้ใช้คำสั้ง goLeft() เพื่อพาจอนนี่เดินลงไปด้านล่าง'";
        int rank = 0;
        int[][] map = {
            {0, 1, 0, 1, 0},
            {1, 1, 1, 1, 1},
            {3, 0, 0, 0, 0},
            {1, 1, 1, 1, 1},
            {0, 1, 0, 1, 0},};
        int charaterStatrPosition[] = {2, 4};
        int stackCodeSize = 4;
        String author = "Bozz";
        String anctionStartOfChar = "waitL";
        int countMustKeepItem = 0;
        return new Problem(name, description, rank, map, charaterStatrPosition, anctionStartOfChar, stackCodeSize, countMustKeepItem, author);
    }

    public Problem t4() {
        String name = "Ep 4 : จอนนี่จะเดินขวา";
        String description = "จอนนี่อยากไปขวาบ้าง"
                + "\nคำแนะนำ : ให้ใช้คำสั้ง goRight() เพื่อพาจอนนี่เดินลงไปด้านล่าง'";
        int rank = 0;
        int[][] map = {
            {0, 1, 0, 1, 0},
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 3},
            {1, 1, 1, 1, 1},
            {0, 1, 0, 1, 0},};
        int charaterStatrPosition[] = {2, 0};
        int stackCodeSize = 4;
        String author = "Bozz";
        String anctionStartOfChar = "waitR";
        int countMustKeepItem = 0;
        return new Problem(name, description, rank, map, charaterStatrPosition, anctionStartOfChar, stackCodeSize, countMustKeepItem, author);
    }


    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        boolean loop = true;
        while (loop) {
            try {
                Thread.sleep(1000);
                if (this.Ep >= 4 && !playGround.getView().getFrame().isVisible()) {
                    loop = false;
                    javax.swing.JOptionPane.showMessageDialog(null, "End Tutorial");
                } else if ((playGround == null || playGround.getView().getMapV().getCharacter().isMeetCow()) && !playGround.getView().getFrame().isVisible()) {
                    //Thread.sleep(2000);
                    this.playGround.getView().getFrame().dispose();
                    this.Ep += 1;
                    this.playGround = new PlayGroundCon(Ep, this.returnStory(), null);
                } else if (playGround == null || (!playGround.getView().getMapV().getCharacter().isMeetCow() && !playGround.getView().getFrame().isVisible())) {
                    //System.out.println("Outt");
                    loop = false;
                }
            } catch (Exception ex) {
                loop = false;
            }

        }
        BackFrameBefore.stop = false;
        BackFrameBefore.justBack();

    }

    public PlayGroundCon getPlay() {
        return playGround;
    }

    public void setPlay(PlayGroundCon playGround) {
        this.playGround = playGround;
    }

    public int getEp() {
        return Ep;
    }

    public void setEp(int Ep) {
        this.Ep = Ep;
    }
}
