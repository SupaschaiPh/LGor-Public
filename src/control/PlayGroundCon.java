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
import lgor.Tutorial;
import model.*;
import source.Sound;

/**
 *
 * @author supaschai
 */
public class PlayGroundCon implements ActionListener, WindowListener {

    private PlayGroundView view;
    private LinkedList<String> code = new LinkedList();
    private Problem pb;
    private int problemIndex;
    private Tutorial tutorial;
    private User user;
    private boolean run = false;
    private Thread tCompiler;
    private Sound sound = new Sound();

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

    public PlayGroundCon(Tutorial tutorial) {
        this.tutorial = tutorial;
        this.pb = this.tutorial.returnStory();
        this.reset();

    }

    public PlayGroundCon(int problemIndex, UseWithPlayGroundAble pb, UserAdapter user) {
        this.setPlayGroundCon(problemIndex, pb, user);
        this.reset();
    }

    public void reset() {
        this.run = false;
        if (this.view != null) {
            view.getFrame().dispose();
        }
        //เจตนาให้Thread die
        this.view = null;
        if (tCompiler != null) {
            while (tCompiler.isAlive()) {
            }
        }

        view = new PlayGroundView(pb);
        this.view.getFrame().addWindowListener(this);
        this.view.getMenuItem1().addActionListener(this);
        this.view.getMenuItem2().addActionListener(this);
    }

    public void justReset() {
        this.run = false;
        if (this.view != null) {
            view.getFrame().dispose();
        }
        this.view = null;
        view = new PlayGroundView(pb);
        this.view.getFrame().addWindowListener(this);
        this.view.getMenuItem1().addActionListener(this);
        this.view.getMenuItem2().addActionListener(this);
    }

    public void finished(boolean meetCow, int countMeetItem) {
        if (this.user != null) {
            if (meetCow && countMeetItem >= pb.getCountMustKeepItem()) {
                if (this.user.getPassedList() == null) {
                    this.user.setPassedList(new ArrayList());
                }
                this.user.addPassed(problemIndex);
            }
            this.view.getFrame().dispose();
        }
        if (this.tutorial != null) {
            if (meetCow && countMeetItem >= pb.getCountMustKeepItem()) {
                this.pb = this.tutorial.returnStory();
                if (this.pb != null) {
                    this.justReset();
                } else {
                    this.view.getFrame().dispose();
                }
            } else {
                this.view.getFrame().dispose();

            }
        }
    }

    public void setPlayGroundCon(int problemIndex, UseWithPlayGroundAble pb, UserAdapter user) {
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

    @Override
    public void actionPerformed(ActionEvent e) {
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

            model.Compiler com = new model.Compiler(this);
            LinkedList<String> commandList = (LinkedList) this.code.clone();
            com.setCommandList(commandList);
            tCompiler = new Thread(com);
            tCompiler.start();

            this.code.clear();

        } else if (e.getSource().equals(this.view.getMenuItem2())) {
            this.reset();
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        sound.playSound("sound/close.wav");

        if (this.view.getCb().getCodeBlockSub1Con() != null && this.view.getCb().getCodeBlockSub1Con().getView() != null
                && this.view.getCb().getCodeBlockSub1Con().getView().getSubFrame1() != null) {
            this.view.getCb().getCodeBlockSub1Con().getView().getSubFrame1().dispose();
        }

        if (this.view.getCb().getCodeBlockSub2Con() != null && this.view.getCb().getCodeBlockSub2Con().getView() != null
                && this.view.getCb().getCodeBlockSub2Con().getView().getSubFrame2() != null) {
            this.view.getCb().getCodeBlockSub2Con().getView().getSubFrame2().dispose();
        }

        if (this.view.getCb().getCodeBlockSub2Con() != null && this.view.getCb().getCodeBlockSub2Con().getSub3() != null
                && this.view.getCb().getCodeBlockSub2Con().getSub3().getView() != null
                && this.view.getCb().getCodeBlockSub2Con().getSub3().getView().getSubFrame3() != null) {
            this.view.getCb().getCodeBlockSub2Con().getSub3().getView().getSubFrame3().dispose();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
