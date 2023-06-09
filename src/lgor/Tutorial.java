/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lgor;

import control.BackFrameBefore;
import control.PlayGroundCon;
import model.Problem;
import source.ElementId;

/**
 *
 * @author supaschai
 */
public class Tutorial implements Runnable {

    private PlayGroundCon playGround;
    private int Ep = 1;
    private static int countEp = 6;

    public Tutorial() {
        playGround = new PlayGroundCon(this);

    }

    public Problem returnStory() {
        Problem result;
        if (this.Ep == 1) {
            result = t1();
        } else if (this.Ep == 2) {
            result = t2();
        } else if (this.Ep == 3) {
            result = t3();
        } else if (this.Ep == 4) {
            result = t4();
        } else if (this.Ep == 5) {
            result = t5();
        } else if (this.Ep == 6) {
            result = t6();
        } else {
            result = null;
        }
        this.Ep += 1;
        return result;
    }

    public Problem t1() {
        String name = "Ep 1 : จอนนี่จะเดินอย่างไร";
        String description = "จอนนี่เป็นสิ่งมีชีวิตอะไรก็ไม่รู้ผมดูไม่ออก วันหนึ่งจอนนี่เห็นแม่วัวเล็มหญ้าอยู่ข้างขอบรั้ว "
                + "จอนนี่เกิดตกหลุมรักแม่วัวขึ้น คุณจะต้องช่วยพาจอนนี่ไปหาแม่วัวให้สำเร็จ"
                + "\nคำแนะนำ : ให้ใช้คำสั่ง goUp() เพื่อพาจอนนี่เดินขึ้นไปด้านบน";
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
                + "\nคำแนะนำ : ให้ใช้คำสั่ง goDown() เพื่อพาจอนนี่เดินลงไปด้านล่าง";
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
                + "\nคำแนะนำ : ให้ใช้คำสั่ง goLeft() เพื่อพาจอนนี่เดินไปด้านซ้าย";
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
                + "\nคำแนะนำ : ให้ใช้คำสั่ง goRight() เพื่อพาจอนนี่เดินไปด้านขวา";
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

    public Problem t5() {
        String name = "Ep 5 : จอนนี่กับกล่องสมบัติ";
        String description = "ระหว่างทางไปหาแม่วัว มีกล่องสมบัติใบหนึ่งอยู่ข้างหน้าจอนนี่ จอนนี่จึงไม่พลาดที่จะเก็บขึ้นมา"
                + "\nคำแนะนำ : ให้ใช้คำสั่ง keep() เพื่อทำให้จอนนี่เก็บกล่องสมบัติได้";
        int rank = 0;
        int[][] map = {
            {0, 1, 0, 1, 0},
            {1, 1, 1, 1, 1},
            {0, 0, ElementId.Item, 0, 3},
            {1, 1, 1, 1, 1},
            {0, 1, 0, 1, 0},};
        int charaterStatrPosition[] = {2, 0};
        int stackCodeSize = 5;
        String author = "Enfant";
        String anctionStartOfChar = "waitR";
        int countMustKeepItem = 1;
        return new Problem(name, description, rank, map, charaterStatrPosition, anctionStartOfChar, stackCodeSize, countMustKeepItem, author);
    }

    public Problem t6() {
        String name = "Ep 6 : จอนนี่จะ Loop";
        String description = "จอนนี่อยากใช้ loop บ้าง เดินธรรมดามันไม่เท่!!"
                + "\nคำแนะนำการใช้ loop :"
                + "\n1.ให้กดสร้างตัวแปรที่ 'กำหนดเพิ่ม' จากนั้นกด'เพิ่มตัวแปร' เพื่อสร้างตัวแปรขึ้นมา"
                + "\n2.กดที่ 'กำหนดเพิ่ม' กด 'ดูคำสั่งที่กำหนดเอง' จะปรากฎหน้าต่าง customControl"
                + "\n3.จากนั้นเลือก 'set <ชื่อตัวแปรที่ตั้ง> to [int]' เพื่อกำหนดค่าเริ่มต้นของตัวแปร"
                + "\n4.ใช้คำสั่ง for ในการวน loop พร้อมกำหนดเงื่อนไขของ loop ด้วย"
                + "\n5.กำหนดทิศทางการเดินของจอนนี่"
                + "\n6.ใช้การคำสั่ง '<ชื่อตัวแปรที่ตั้ง>+=[int]' หรือ '<ชื่อตัวแปรที่ตั้ง>-=[int]' ในการเพิ่มหรือลดค่าตัวแปร"
                + "\n7.จากนั้นให้ใช้คำสั่ง end for เพื่อเสร็จสิ้นคำสั่งภายใน loop นั้น";
        int rank = 0;
        int[][] map = {
            {0, 1, 0, 1, 0},
            {1, 1, 0, 1, 1},
            {1, 1, 0, 1, 0},
            {0, 1, 0, 1, 0},
            {1, 1, 0, 1, 1},
            {0, 1, 0, 1, 0},
            {1, 1, 0, 1, 1},
            {0, 1, 0, 1, 0},
            {1, 1, 3, 1, 1},};
        int charaterStatrPosition[] = {0, 2};
        int stackCodeSize = 5;
        String author = "Enfant";
        String anctionStartOfChar = "waitB";
        int countMustKeepItem = 0;
        return new Problem(name, description, rank, map, charaterStatrPosition, anctionStartOfChar, stackCodeSize, countMustKeepItem, author);
    }

    @Override
    public void run() {
        boolean loop = true;
        while (loop) {
            try {
                Thread.sleep(1);

                if (playGround.getView().getFrame() == null || !playGround.getView().getFrame().isVisible()) {
                    Thread.sleep(1000);
                    if (this.Ep > Tutorial.countEp + 1 && (playGround.getView().getFrame() == null || !playGround.getView().getFrame().isVisible())) {
                        javax.swing.JOptionPane.showMessageDialog(null, "End Tutorial");
                        loop = false;
                    } else if (playGround.getView().getFrame() == null || !playGround.getView().getFrame().isVisible()) {
                        loop = false;
                    }

                }

            } catch (Exception ex) {
                System.out.println(ex);
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
