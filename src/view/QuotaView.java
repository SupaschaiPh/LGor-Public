/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import source.*;

/**
 *
 * @author supaschai
 */
public class QuotaView implements BeAbleWorkInMDI {

    private JPanel container = new SuComponent().getPanel(),
            container1 = new SuComponent().getPanel(),
            container2 = new SuComponent().getPanel(),
            container3 = new SuComponent().getPanel(),
            container4 = new SuComponent().getPanel(),
            container5 = new SuComponent().getPanel(),
            container6 = new SuComponent().getPanel();
    private JLabel lb1 = new SuComponent().getLabel(),
            lb2 = new SuComponent().getLabel();

    public QuotaView() {
        container.setLayout(new BorderLayout());
        container1.setLayout(new BorderLayout());
        container2.setLayout(new GridLayout(1, 2));
        container3.setLayout(new BorderLayout());
        container4.setLayout(new BorderLayout());

        lb1.setBackground(Grass.color);
        lb2.setBackground(Grass.color);
        container5.setBackground(Grass.color);
        container6.setBackground(Grass.color);
        container5.setAlignmentX(JLabel.LEFT_ALIGNMENT);

        source.Character c = new source.Character();
        Thread t = new Thread(c);
        c.setAction("waitB");
        t.start();
        c.setPreferredSize(new Dimension(50, 50));
        lb1.setText("x1");
        container5.add(c);
        container5.add(lb1);

        Cow c2 = new Cow();
        Thread t2 = new Thread(c2);
        c2.setPreferredSize(new Dimension(50, 50));
        t2.start();
        lb2.setText("x1");
        container6.add(c2);
        container6.add(lb2);

        container3.add(container5);
        container4.add(container6);
        container3.setBackground(Color.BLUE);

        container2.add(container3);
        container2.add(container4);
        container1.add(container2);
        container1.setBackground(Grass.color);
        container1.setBorder(new EmptyBorder(10, 10, 10, 10));

        container.add(container1);


    }
    
    public void setCountChar(int cc){
        this.lb1.setText("x"+cc);
    }
    public void setCountCow(int cc){
        this.lb2.setText("x"+cc);
    }

    @Override
    public JPanel getContainer() {
        return container;
    }

    public void setContainer(JPanel container) {
        this.container = container;
    }

    public JPanel getContainer1() {
        return container1;
    }

    public void setContainer1(JPanel container1) {
        this.container1 = container1;
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

    public JPanel getContainer4() {
        return container4;
    }

    public void setContainer4(JPanel container4) {
        this.container4 = container4;
    }

    public JPanel getContainer5() {
        return container5;
    }

    public void setContainer5(JPanel container5) {
        this.container5 = container5;
    }

    public JPanel getContainer6() {
        return container6;
    }

    public void setContainer6(JPanel container6) {
        this.container6 = container6;
    }

    public JLabel getLb1() {
        return lb1;
    }

    public void setLb1(JLabel lb1) {
        this.lb1 = lb1;
    }

    public JLabel getLb2() {
        return lb2;
    }

    public void setLb2(JLabel lb2) {
        this.lb2 = lb2;
    }


}
