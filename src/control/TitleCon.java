/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import lgor.LGor;
import lgor.Tutorial;
import view.*;
import source.Sound;
/**
 *
 * @author supaschai
 */
public class TitleCon implements ActionListener,WindowListener{
    private TitleView view = new TitleView();
    private Sound sound = new Sound();
    

    public TitleCon() {
        view.getJf().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.getStart().addActionListener(this);
        view.getTutorial().addActionListener(this);
        view.getmyScore().addActionListener(this);
        view.getJf().addWindowListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        sound.playSound("sound/click.wav");
        if(e.getSource().equals(view.getTutorial())){
            Tutorial tt = new Tutorial();
            view.getJf().setVisible(false);
            BackFrameBefore.frameBefore = this.view.getJf();
            BackFrameBefore.stop = true;
            Thread ttt = new Thread(tt);
            ttt.start();
        }else if(e.getSource().equals(view.getStart())){
            ProblemSelectCon problemSelectCon = new ProblemSelectCon(view.getJf().getLocation().x,view.getJf().getLocation().y,
            view.getJf().getWidth(),view.getJf().getHeight());
            BackFrameBefore.frameBefore = this.view.getJf();
            BackFrameBefore.curFrame = problemSelectCon.getView().getFrame();
            view.getJf().setVisible(false);
        }else if(e.getSource().equals(view.getmyScore())){
            MyScoreCon myScoreCon = new MyScoreCon(view.getJf().getLocation().x,view.getJf().getLocation().y,
            view.getJf().getWidth(),view.getJf().getHeight());
            BackFrameBefore.frameBefore = this.view.getJf();
            BackFrameBefore.curFrame = myScoreCon.getView().getFrame();
            view.getJf().setVisible(false);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        sound.playSound("sound/close.wav");
        LGor.save();
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
}
