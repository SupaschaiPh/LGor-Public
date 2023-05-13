/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import lgor.*;
import source.*;

/**
 *
 * @author supaschai
 */
public class MyScoreView {

    private JFrame frame = new JFrame();
    private JPanel container = new SuComponent().getPanel(),
            container2 = new SuComponent().getPanel(),
            container3 = new SuComponent().getPanel(),
            containerStar = new SuComponent().getPanel();
    private JLabel label1 = new SuComponent().getLabel("", 25);

    public int clacPercent(int myScore, int fullScore) {
        double result = (double)myScore/(double)fullScore;
        return (int) (Math.round(result*100));
    }

    public void genStar(int full, int half) {
        for (int i = 0; i < 5; i++) {
            Star star = new Star(Star.empty);
            if (full > 0) {
                full -= 1;
                star = new Star(Star.full);
            } else if (half > 0) {
                half -= 1;
                star = new Star(Star.half);
            }
            star.setPreferredSize(new Dimension(50,50));
            containerStar.add(star);
        }
    }

    public void renderStart(int percent) {
        if (percent >= 100) {
            genStar(5, 0);
        } else if (percent >= 90) {
            genStar(4, 1);
        } else if (percent >= 80) {
            genStar(4, 0);
        } else if (percent >= 70) {
            genStar(3, 1);
        } else if (percent >= 60) {
            genStar(3, 0);
        } else if (percent >= 50) {
            genStar(2, 1);
        } else if (percent >= 40) {
            genStar(2, 0);
        } else if (percent >= 30) {
            genStar(1, 1);
        } else if (percent >= 20) {
            genStar(1, 0);
        } else if (percent >= 10) {
            genStar(0, 1);
        } else {
            genStar(0, 0);

        }
    }

    public void renderScore() {
        String text = AllTitle.title.get("MyScore");
        text += " : " + LGor.user.getCountPassed() + "/" + LGor.LGorProblemData.size();
        label1.setText(text);

    }

    public MyScoreView(int x, int y, int w, int h) {
        container.setLayout(new GridLayout(3, 1));
        container2.setLayout(new GridLayout(2, 1));

        this.renderScore();
        this.renderStart(clacPercent(LGor.user.getCountPassed(),LGor.LGorProblemData.size()));

        container2.add(new SuComponent().getPanel(containerStar));
        container2.add(new SuComponent().getPanel(label1));

        container.add(new SuComponent().getPanel());
        container.add(container2);
        container.add(new SuComponent().getPanel());
        
        frame.setTitle(Theme.appName);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocation(x, y);
        frame.setSize(w, h);
        frame.add(container);
        frame.setIconImage(Theme.favIcon.getImage());
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getContainer() {
        return container;
    }

    public void setContainer(JPanel container) {
        this.container = container;
    }

    public JPanel getContainer2() {
        return container2;
    }

    public void setContainer2(JPanel container2) {
        this.container2 = container2;
    }

    public JPanel getContainer3() {
        return container3;
    }

    public void setContainer3(JPanel container3) {
        this.container3 = container3;
    }

    public JPanel getContainerStar() {
        return containerStar;
    }

    public void setContainerStar(JPanel containerStar) {
        this.containerStar = containerStar;
    }

    public JLabel getLabel1() {
        return label1;
    }

    public void setLabel1(JLabel label1) {
        this.label1 = label1;
    }

}
