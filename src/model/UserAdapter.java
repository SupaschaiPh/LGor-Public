/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author supaschai
 */
public abstract class UserAdapter implements Useable {

    

    @Override
    public ArrayList getPassedList() {
        System.out.println("Disable Now");
        return null;
    }

    @Override
    public int getCountPassed() {
        System.out.println("Disable Now");
        return 0;
    }

    @Override
    public void setPassedList(ArrayList passedList) {
        System.out.println("Disable Now");
    }

    @Override
    public void setCountPassed(int countPassed) {
        System.out.println("Disable Now");
    }

    @Override
    public void addPassed(int problemIndex) {
        System.out.println("Disable Now");
    }

    @Override
    public String getUserId() {
        System.out.println("Disable Now");
        return null;
    }

    @Override
    public void setUserId(String id) {
        System.out.println("Disable Now");
    }

    
    @Override
    public boolean isPassed(int problemIndex) {
        System.out.println("Disable Now");
        return false;

    }

    @Override
    public int getPassedList(int index) {
        System.out.println("Disable Now");
        return 0;
    }
}
