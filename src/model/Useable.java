/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author supaschai
 */
public interface Useable {

    public abstract String getUserId();

    public abstract void setUserId(String id);


    public abstract ArrayList getPassedList();
    
    public abstract int getPassedList(int index);

    public abstract int getCountPassed();

    public abstract void setPassedList(ArrayList passedList);

    public abstract void setCountPassed(int countPassed);

    public abstract void addPassed(int problemIndex);
    
    public abstract boolean isPassed(int problemIndex);

}
