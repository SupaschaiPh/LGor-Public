/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author supaschai
 */
import java.io.Serializable;
import java.util.ArrayList;

public class User extends UserAdapter implements Serializable {

    private ArrayList passedList;
    
    public User() {
        this.passedList = new ArrayList();
    }

    @Override
    public ArrayList getPassedList() {
        return this.passedList;
    }

    @Override
    public int getCountPassed() {
        return this.passedList.size();
    }

    @Override
    public void setPassedList(ArrayList passedList) {
        this.passedList = passedList;
    }

    @Override
    public void addPassed(int problemIndex) {
        this.passedList.add(problemIndex);
        
    }
     @Override
    public boolean isPassed(int problemIndex) {
        
        return this.passedList.indexOf(problemIndex) != -1;

    }
    
}
