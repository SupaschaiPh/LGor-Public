/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author supaschai
 */
interface RenderMapable {
    public abstract int[][] getMap() ;

    public  abstract void setMap(int[][] map);
    
    public abstract int[] getCharaterStatrPosition();

    public abstract void setCharaterStatrPosition(int[] charaterStatrPosition);

}
