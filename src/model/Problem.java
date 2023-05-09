/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author supaschai
 */
public class Problem implements RenderMapable, UseWithPlayGroundAble, Serializable {

    private String name;
    private String description;//คำอธิบายโจทย์
    private int rank; //ระดับความยาก0-inf
    private int[][] map;
    private int charaterStatrPosition[];
    private int stackCodeSize; //ลิมิตจำนวนโค้ดที่ใช้ได้
    private String author;//ชื่อ ผู้สร้างโจทย์
    private String anctionStartOfChar = "waitB";//สิ่งเริ่มต้นที่ตัวละครทำ
    private int countMustKeepItem = 0;

    public Problem(String name, String description, int rank, int[][] map,
            int[] charaterStatrPosition, String anctionStartOfChar, int stackCodeSize, int mustKeepItem, String author) {
        this.name = name;
        this.description = description;
        this.rank = rank;
        this.map = map;
        this.charaterStatrPosition = charaterStatrPosition;
        this.stackCodeSize = stackCodeSize;
        this.author = author;
        this.anctionStartOfChar = anctionStartOfChar;
        this.countMustKeepItem = mustKeepItem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     *
     * @return
     */
    @Override
    public int[][] getMap() {
        int tem[][] = new int[this.map.length][];
        for (int row = 0; row < this.map.length; row++) {
            tem[row] = new int[this.map[row].length];
            System.arraycopy(this.map[row], 0, tem[row], 0, this.map[row].length);
        }
        return tem;
    }

    @Override
    public void setMap(int[][] map) {
        this.map = map;
    }

    @Override
    public int[] getCharaterStatrPosition() {
        return charaterStatrPosition.clone();
    }

    @Override
    public void setCharaterStatrPosition(int[] charaterStatrPosition) {
        this.charaterStatrPosition = charaterStatrPosition;
    }

    @Override
    public int getStackCodeSize() {
        return stackCodeSize;
    }

    @Override
    public void setStackCodeSize(int stackCodeSize) {
        this.stackCodeSize = stackCodeSize;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getAnctionStartOfChar() {
        return anctionStartOfChar;
    }

    @Override
    public void setAnctionStartOfChar(String anctionStartOfChar) {
        this.anctionStartOfChar = anctionStartOfChar;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getCountMustKeepItem() {
        return countMustKeepItem;
    }

    @Override
    public void setCountMustKeepItem(int countMustKeepItem) {
        this.countMustKeepItem = countMustKeepItem;
    }

    @Override
    public String toString() {
        String res = "";
        res += "\nName : " + this.name;
        res += "\nDescrption : " + this.description;
        res += "\nAuthor : " + this.author;
        res += "\nRank : " + this.rank;
        res += "\ncountMustKeepItem : " + this.countMustKeepItem;
        res += "\nMap : {";
        for(int r=0;r<map.length;r++){
            res += "\n\t{";
            for(int c=0;c<map[r].length;c++){
                res += map[r][c];
                if(c<map[r].length-1)
                res += ",";
            }
            res += "}";
        }
        res += "\n}";
        res += "\nCharPos : {"+this.charaterStatrPosition[0]+","+this.charaterStatrPosition[1]+"}";
        res += "\nanctionStartOfChar : "+this.anctionStartOfChar;
        return res;

    }

}
