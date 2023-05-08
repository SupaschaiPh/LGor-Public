/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.*;
import java.util.ArrayList;
import view.PlayGroundView;
import java.util.LinkedList;
import javax.swing.*;
import model.*;

/**
 *
 * @author supaschai
 */
public class PlayGroundCon implements ActionListener {

    private PlayGroundView view;
    private LinkedList<String> code = new LinkedList();
    private Problem pb;
    private int problemIndex;
    private User user;
    private boolean run = false;

    public void reset() {
        if (this.view != null) {
            view.frame.dispose();
        }
        this.view = null;
        view = new PlayGroundView(pb);
        this.view.getMenuItem1().addActionListener(this);
        this.view.getMenuItem2().addActionListener(this);
        this.run = false;
    }

    public PlayGroundCon() {
        int map[][] = {{1, 2, 2, 3, 2, 1, 2, 0, 0, 0},
        {2, 2, 1, 0, 1, 1, 0, 0, 0, 2},
        {0, 0, 2, 0, 0, 1, 2, 0, 1, 2},
        {1, 0, 1, 1, 2, 0, 1, 2, 0, 1},
        {0, 2, 0, 0, 2, 1, 1, 0, 2, 0},
        {1, 0, 1, 2, 2, 2, 2, 0, 2, 0},
        {1, 1, 0, 0, 2, 0, 0, 0, 2, 1},
        {2, 2, 0, 0, 0, 1, 2, 1, 0, 1},
        {1, 2, 1, 0, 2, 0, 0, 0, 1, 2},
        {0, 2, 0, 0, 1, 0, 1, 0, 1, 1}};
        int charaterPosition[] = {0, 9};

        pb = new Problem("เริ่มต้นจอนนี่", "จงพาจอนนี่ไปหาวัว", 0,
                map, charaterPosition, "waitB", 20, 1, "ฺBozz");
        this.reset();

    }

    public PlayGroundCon(int problemIndex, UseWithPlayGroundAble pb, UserAdapter user) {
        this.setPlayGroundCon(problemIndex, pb, user);
        this.reset();

    }
    
    public void setPlayGroundCon(int problemIndex, UseWithPlayGroundAble pb, UserAdapter user){
        this.problemIndex = problemIndex;
        this.pb = (Problem) pb;
        this.user = (User) user;
    }

    public PlayGroundView getView() {
        return view;
    }

    public void setView(PlayGroundView view) {
        this.view = view;
    }

    public LinkedList<String> getCode() {
        return code;
    }

    public void setCode(LinkedList<String> code) {
        this.code = code;
    }

    public Problem getPb() {
        return pb;
    }

    public void setPb(UseWithPlayGroundAble pb) {
        this.pb = (Problem) pb;
    }

    public void finished(boolean meetCow) {
        if (this.user != null && meetCow) {
            if (this.user.getPassedList() == null) {
                this.user.setPassedList(new ArrayList());
            }
            this.user.addPassed(problemIndex);
        }
        this.view.getFrame().dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println(e);
        if (this.run && e.getSource().equals(this.view.getMenuItem1())) {

        } else if (e.getSource().equals(this.view.getMenuItem1())) {
            this.run = true;
            if (this.view.getCb().getCodeBlockSub2Con() != null) {
                this.view.getCb().getCodeBlockSub2Con().getView().getSubFrame2().dispose();
            }
            JTable codeTb = this.view.getCb().getView().getStackCode();
            for (int i = 0; i < codeTb.getRowCount(); i++) {
                if (codeTb.getValueAt(i, 0) == null || codeTb.getValueAt(i, 0) == "") {
                    continue;
                }
                this.code.add((codeTb.getValueAt(i, 0) + "" + codeTb.getValueAt(i, 1)).strip());
            }
            //this.getview().getFrame().setEnabled(false);

            model.Compiler com = new model.Compiler(this);
            LinkedList<String> commandList = (LinkedList) this.code.clone();
            com.setCommandList(commandList);
            Thread t = new Thread(com);
            t.start();

            this.code.clear();

        } else if (e.getSource().equals(this.view.getMenuItem2())) {
            this.reset();
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getProblemIndex() {
        return problemIndex;
    }

    public void setProblemIndex(int problemIndex) {
        this.problemIndex = problemIndex;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

}
