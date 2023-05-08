/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import view.MepSelectView;
import lgor.LGor;
import model.Problem;
import source.SuComponent;
import source.Theme;
import view.AllTitle;

/**
 *
 * @author supaschai
 */
public class MapSelectCon implements ActionListener, WindowListener {

    private MepSelectView view;
    private int index = 0;
    private Problem curProblem;

    public MapSelectCon(int posx, int posy, int w, int h) {
        view = new MepSelectView(posx, posy, w, h);
        if (!LGor.LGorProblemData.isEmpty()) {
            renderProblemData();
        }
        view.getFrame().addWindowListener(this);
        view.getLeft().addActionListener(this);
        view.getRight().addActionListener(this);
        view.getSolve().addActionListener(this);
        view.getMitem1().addActionListener(this);
        view.getMitem2().addActionListener(this);

    }

    public void renderProblemData() {
        view.getProblemIndex().setText(index + 1 + "");
        curProblem = LGor.LGorProblemData.get(index);
        view.getSolve().setText(AllTitle.title.get("Slove"));
        view.getProblemName().setText(curProblem.getName());
        view.getRank().removeAll();
        String pass = "Not Passed";
        view.getStatus().setForeground(Theme.NotPassed);
        if (LGor.user.isPassed(index)) {
            pass = "Passed";
            view.getStatus().setForeground(Theme.Passed);
        }
        view.getStatus().setText(AllTitle.title.get("Status") + " : " + AllTitle.title.get(pass));
        view.getRank().repaint();
        view.getRank().add(new SuComponent().renderBadgeRank(curProblem.getRank()));
        view.getRank().validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ((index + 1) < LGor.LGorProblemData.size() && e.getSource().equals(view.getRight())) {
            index += 1;
            renderProblemData();

        } else if ((index - 1) >= 0 && e.getSource().equals(view.getLeft())) {
            index -= 1;
            renderProblemData();
        } else if (e.getSource().equals(this.view.getSolve())) {
            if (curProblem != null) {
                new PlayGroundCon(index, curProblem, LGor.user);
            }
        } else if (e.getSource().equals(this.view.getMitem2())) {
            new CreateProblemCon();
        } else if (e.getSource().equals(this.view.getMitem1())) {

            this.view.getFrame().dispose();
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowClosing(WindowEvent e) {

        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowClosed(WindowEvent e) {
        BackFrameBefore.back();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowIconified(WindowEvent e) {

        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeactivated(WindowEvent e) {

        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public MepSelectView getView() {
        return view;
    }

    public void setView(MepSelectView view) {
        this.view = view;
    }

}
