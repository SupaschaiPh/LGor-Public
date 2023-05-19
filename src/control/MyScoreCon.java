/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import view.MyScoreView;
import source.Sound;
/**
 *
 * @author supaschai
 */
public class MyScoreCon implements WindowListener {

    private MyScoreView view;
    private Sound sound = new Sound();

    public MyScoreCon(int x, int y, int w, int h) {
        view = new MyScoreView(x, y, w, h);
        view.getFrame().addWindowListener(this);
    }

    public MyScoreView getView() {
        return view;
    }

    public void setView(MyScoreView view) {
        this.view = view;
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        sound.playSound("sound/close.wav");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        BackFrameBefore.back();
    }

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}

}
