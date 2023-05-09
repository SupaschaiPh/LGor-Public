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

    private JFrame jf = new JFrame();
    private JPanel jp = new SuComponent().getPanel(),
            jp2 = new SuComponent().getPanel(),
            jp3 = new SuComponent().getPanel();
    private JButton start = new SuComponent().getButton("Start"),
            tutorial = new SuComponent().getButton("Tutorial"),
            setting = new SuComponent().getButton("Setting");
    private Logo logo = new Logo();

    public TitleView() {
        jp.add(logo);
        logo.setPreferredSize(new Dimension(200,150));

        jp2.setLayout(new GridLayout(5, 1));
        jp2.add(new SuComponent().getPanel(start));
        jp2.add(new SuComponent().getPanel(tutorial));
        //jp2.add(new SuComponent().getPanel(setting));
        start.setPreferredSize(new Dimension(300,25));
        tutorial.setPreferredSize(new Dimension(300,25));
        setting.setPreferredSize(new Dimension(300,25));
        start.setBackground(Theme.FG);
        start.setForeground(Theme.BG);
        
        jp3.setLayout(new BorderLayout());
        jp3.add(jp);
        jp3.add(jp2,BorderLayout.SOUTH);
       
        jf.add(jp3);
        jf.setSize(600, 400);
        jf.setLocation(300, 300);
        jf.setVisible(true);

    }

    public JFrame getJf() {
        return jf;
    }

    public void setJf(JFrame jf) {
        this.jf = jf;
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

    public JButton getSetting() {
        return setting;
    }

    public void setSetting(JButton setting) {
        this.setting = setting;
    }

    public Logo getLogo() {
        return logo;
    }

    public void setLogo(Logo logo) {
        this.logo = logo;
    }
    
    
}
