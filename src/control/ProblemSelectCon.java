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
import java.util.logging.Level;
import java.util.logging.Logger;
import view.ProblemSelectView;
import lgor.LGor;
import model.Problem;
import source.SuComponent;
import source.Theme;
import view.AllTitle;

/**
 *
 * @author supaschai
 */
public class ProblemSelectCon implements ActionListener, WindowListener, Runnable {

    private ProblemSelectView view;
    private int index = 0;
    private Problem curProblem;
    private PlayGroundCon pgc;
    private CreateProblemCon cpc;

    public ProblemSelectCon(int posx, int posy, int w, int h) {
        view = new ProblemSelectView(posx, posy, w, h);

        renderProblemData();

        view.getFrame().addWindowListener(this);
        view.getLeft().addActionListener(this);
        view.getRight().addActionListener(this);
        view.getSolve().addActionListener(this);
        view.getMitem1().addActionListener(this);
        view.getMitem2().addActionListener(this);
        view.getMitem3().addActionListener(this);
        view.getMitem4().addActionListener(this);

    }

    public void renderProblemData() {
        if (LGor.LGorProblemData!=null && !LGor.LGorProblemData.isEmpty()) {
            view.getProblemIndex().setText(index + 1 + "");
            curProblem = LGor.LGorProblemData.get(index);
            view.getSolve().setText(AllTitle.title.get("SolveProblem"));
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
        } else {
            view.getSolve().setText(AllTitle.title.get("Not Found"));
            view.getProblemName().setText(AllTitle.title.get("Not Found"));
            view.getStatus().setText(AllTitle.title.get("Not Found"));
            view.getRank().removeAll();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (LGor.LGorProblemData==null || LGor.LGorProblemData.isEmpty()) {
            return ;
        }
        if ((index + 1) < LGor.LGorProblemData.size() && e.getSource().equals(view.getRight())) {
            index += 1;
            renderProblemData();

        } else if ((index - 1) >= 0 && e.getSource().equals(view.getLeft())) {
            index -= 1;
            renderProblemData();
        } else if (e.getSource().equals(this.view.getSolve())) {
            if (curProblem != null) {
                pgc = new PlayGroundCon(index, curProblem, LGor.user);
                Thread t = new Thread(this);
                t.start();
            }
        } else if (e.getSource().equals(this.view.getMitem2())) {
            cpc = new CreateProblemCon();
            
            index = LGor.LGorProblemData.size() - 1;
            Thread t = new Thread(this);
            t.start();
        } else if (e.getSource().equals(this.view.getMitem1())) {
            this.view.getFrame().dispose();
        } else if (e.getSource().equals(this.view.getMitem3())) {
            if (!LGor.LGorProblemData.isEmpty()) {
                LGor.LGorProblemData.remove(index);
                LGor.user.getPassedList().remove(index + "");
                index -= 1;
                renderProblemData();
            }
        } else if (e.getSource().equals(this.view.getMitem4())) {
            if (!LGor.LGorProblemData.isEmpty()) {
                cpc = new CreateProblemCon(LGor.LGorProblemData.get(index), index);
                Thread t = new Thread(this);
                t.start();
            }
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

    public ProblemSelectView getView() {
        return view;
    }

    public void setView(ProblemSelectView view) {
        this.view = view;
    }

    @Override
    public void run() {
        while ((this.pgc != null && this.pgc.getView() != null && this.pgc.getView().getFrame() != null && this.pgc.getView().getFrame().isVisible()) || 
                (this.cpc != null && this.cpc.getView() != null && this.cpc.getView().getFrame() != null && this.cpc.getView().getFrame().isVisible())||
                (this.cpc != null && this.cpc.getSubView1() != null && this.cpc.getSubView1().getSubFrame1() != null && this.cpc.getSubView1().getSubFrame1().isVisible())) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                System.out.println(ex);
                //Logger.getLogger(ProblemSelectCon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        renderProblemData();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
