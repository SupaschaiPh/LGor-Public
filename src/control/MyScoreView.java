/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.*;
import javax.swing.*;
import source.*;

/**
 *
 * @author supaschai
 */
public class MyScoreView {

    private JFrame frame = new JFrame();
    private JPanel p1 = new SuComponent().getBorderPanel(),
            p2 = new SuComponent().getPanel(),
            elem = new Logo();
    private JLabel lb = new SuComponent().getLabel("Passed 0/10", 36);

    public MyScoreView() {
        p1.setLayout(new GridLayout(3,1));
        p1.add(new SuComponent().getPanel());
        p1.add(p2);

        p2.add(elem);
        p2.add(lb);
        
        elem.setPreferredSize(new Dimension(150,100));
        //lb.setVerticalTextPosition(JLabel.CENTER);
        //lb.setVerticalAlignment(JLabel.CENTER);
        //lb.setHorizontalTextPosition(JLabel.CENTER);

        frame.add(p1);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MyScoreView();
    }
}
