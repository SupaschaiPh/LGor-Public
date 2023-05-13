/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import source.*;

/**
 *
 * @author supaschai
 */
public class TitleView {

    private JFrame frame = new JFrame();
    private JPanel jp = new SuComponent().getPanel(),
            jp2 = new SuComponent().getPanel(),
            jp3 = new SuComponent().getPanel();
    private JButton start = new SuComponent().getButton(AllTitle.title.get("Start")),
            tutorial = new SuComponent().getButton(AllTitle.title.get("Tutorial")),
            myScore = new SuComponent().getButton(AllTitle.title.get("MyScore"));
    private Logo logo = new Logo();

    public TitleView() {
        jp.add(logo);
        logo.setPreferredSize(new Dimension(257, 147));

        jp2.setLayout(new GridLayout(5, 1));
        start.setPreferredSize(new Dimension(300, 25));
        tutorial.setPreferredSize(new Dimension(300, 25));
        myScore.setPreferredSize(new Dimension(300, 25));
        jp2.add(new SuComponent().getPanel(start));
        jp2.add(new SuComponent().getPanel(tutorial));
        jp2.add(new SuComponent().getPanel(myScore));
        start.setBackground(Theme.FG);
        start.setForeground(Theme.BG);

        jp3.setLayout(new BorderLayout());
        jp3.add(jp);
        jp3.add(jp2, BorderLayout.SOUTH);

        frame.setTitle(Theme.appName);
        frame.add(jp3);
        frame.setIconImage(Theme.favIcon.getImage());
        frame.setSize(600, 400);
        frame.setLocation(300, 300);
        frame.setVisible(true);

    }

    public JFrame getJf() {
        return frame;
    }

    public void setJf(JFrame jf) {
        this.frame = jf;
    }

    public JPanel getJp() {
        return jp;
    }

    public void setJp(JPanel jp) {
        this.jp = jp;
    }

    public JPanel getJp2() {
        return jp2;
    }

    public void setJp2(JPanel jp2) {
        this.jp2 = jp2;
    }

    public JPanel getJp3() {
        return jp3;
    }

    public void setJp3(JPanel jp3) {
        this.jp3 = jp3;
    }

    public JButton getStart() {
        return start;
    }

    public void setStart(JButton start) {
        this.start = start;
    }

    public JButton getTutorial() {
        return tutorial;
    }

    public void setTutorial(JButton tutorial) {
        this.tutorial = tutorial;
    }

    public JButton getmyScore() {
        return myScore;
    }

    public void setmyScore(JButton myScore) {
        this.myScore = myScore;
    }

    public Logo getLogo() {
        return logo;
    }

    public void setLogo(Logo logo) {
        this.logo = logo;
    }

}
