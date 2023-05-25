/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.*;
import javax.swing.*;
import view.*;
import lgor.LGor;
import model.Problem;
import source.*;
import java.io.*;
import java.util.ArrayList;
import source.Sound;

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
    private Sound sound = new Sound();

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
        view.getMitem5().addActionListener(this);

    }

    public void renderProblemData() {
        if (LGor.LGorProblemData.size() == 0) {
            index = -1;
        }
        if (LGor.LGorProblemData != null && !LGor.LGorProblemData.isEmpty()) {
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
        if (!(LGor.LGorProblemData == null || LGor.LGorProblemData.isEmpty())) {
            if ((index + 1) < LGor.LGorProblemData.size() && e.getSource().equals(view.getRight())) {
                sound.playSound("sound/arrow.wav");
                index += 1;
                renderProblemData();

            } else if ((index - 1) >= 0 && e.getSource().equals(view.getLeft())) {
                sound.playSound("sound/arrow.wav");
                index -= 1;
                renderProblemData();
            } else if (e.getSource().equals(this.view.getSolve())) {
                if (curProblem != null) {
                    sound.playSound("sound/click.wav");
                    pgc = new PlayGroundCon(index, curProblem, LGor.user);
                    Thread t = new Thread(this);
                    t.start();
                }
            }
        }

        if (e.getSource().equals(this.view.getMitem2())) {
            cpc = new CreateProblemCon();
            if (LGor.LGorProblemData.size() > 0) {
                index = LGor.LGorProblemData.size() - 1;
            }
            Thread t = new Thread(this);
            t.start();
        } else if (e.getSource().equals(this.view.getMitem1())) {
            this.view.getFrame().dispose();
        } else if (e.getSource().equals(this.view.getMitem3())) {
            if (!LGor.LGorProblemData.isEmpty()) {
                LGor.LGorProblemData.remove(index);
                if (index < LGor.LGorProblemData.size()) {
                    for (int i = index; i <= LGor.LGorProblemData.size(); i++) {
                        if (LGor.user.isPassed(i) && i != index) {
                            LGor.user.delPassed(i);
                            LGor.user.addPassed(i - 1);
                        } else if (i == index) {
                            LGor.user.delPassed(i);

                        }

                    }
                } else {
                    LGor.user.delPassed(index);

                }
                if (LGor.LGorProblemData.size() - 1 < index) {
                    index -= 1;
                }
                renderProblemData();
            }

        } else if (e.getSource().equals(this.view.getMitem4())) {
            if (!LGor.LGorProblemData.isEmpty()) {
                cpc = new CreateProblemCon(LGor.LGorProblemData.get(index), index);
                Thread t = new Thread(this);
                t.start();
            }
        } else if (e.getSource().equals(this.view.getMitem5())) {
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(this.view.getFrame());
            if (file.getSelectedFile() != null && file.getSelectedFile().exists()) {
                if (file.getSelectedFile().getPath().endsWith(".lgor")) {
                    try ( FileInputStream fin = new FileInputStream(file.getSelectedFile());  ObjectInputStream oin = new ObjectInputStream(fin);) {
                        LGor.LGorProblemData.addAll((ArrayList) oin.readObject());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(file, "Error : " + ex, "JFileChooser", JOptionPane.ERROR_MESSAGE);

                    }
                } else {
                    JOptionPane.showMessageDialog(file, ".lgor only", "JFileChooser", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        sound.playSound("sound/close.wav");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        BackFrameBefore.back();
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

    public ProblemSelectView getView() {
        return view;
    }

    public void setView(ProblemSelectView view) {
        this.view = view;
    }

    @Override
    public void run() {
        while ((this.pgc != null && this.pgc.getView() != null && this.pgc.getView().getFrame() != null && this.pgc.getView().getFrame().isVisible())
                || (this.cpc != null && this.cpc.getView() != null && this.cpc.getView().getFrame() != null && this.cpc.getView().getFrame().isVisible())
                || (this.cpc != null && this.cpc.getSubView1() != null && this.cpc.getSubView1().getSubFrame1() != null && this.cpc.getSubView1().getSubFrame1().isVisible())) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        renderProblemData();

    }

}
