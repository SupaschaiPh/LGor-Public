/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import source.*;

/**
 *
 * @author supaschai
 */
public class CreateProblemViewSub1View {

    private JFrame subFrame1 = new JFrame();
    private JPanel jpn = new SuComponent().getPanel(),
            jpn2 = new SuComponent().getPanel(),
            jpn3 = new SuComponent().getPanel(),
            jpn4 = new SuComponent().getPanel();
    private JTextField rows = new SuComponent().getInput(5, Theme.Normal),
            col = new SuComponent().getInput(5, Theme.Normal);
    private JButton ok = new SuComponent().getButton("Ok");
    private JLabel warningText = new SuComponent().getLabel(9);

    public CreateProblemViewSub1View() {
        warningText.setForeground(Color.red);
        
        ok.setBackground(Theme.FG);
        ok.setForeground(Theme.BG);

        jpn3.add(new SuComponent().getLabel("Row"));
        jpn3.add(rows);

        jpn4.add(new SuComponent().getLabel("Col"));
        jpn4.add(col);

        jpn2.setLayout(new GridLayout(1, 2));
        jpn2.add(jpn3);
        jpn2.add(jpn4);

        jpn.setLayout(new GridLayout(2, 1));
        jpn.add(jpn2);
        jpn.add(new SuComponent().getBorderPanel(ok));

        subFrame1.add(new SuComponent().getPanel(warningText),BorderLayout.NORTH);
        subFrame1.add(jpn);
        subFrame1.setResizable(false);
        subFrame1.pack();
        subFrame1.setLocation(300, 250);
        subFrame1.setVisible(true);
    }

    public JFrame getSubFrame1() {
        return subFrame1;
    }

    public void setSubFrame1(JFrame subFrame1) {
        this.subFrame1 = subFrame1;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }

    public JPanel getJpn2() {
        return jpn2;
    }

    public void setJpn2(JPanel jpn2) {
        this.jpn2 = jpn2;
    }

    public JPanel getJpn3() {
        return jpn3;
    }

    public void setJpn3(JPanel jpn3) {
        this.jpn3 = jpn3;
    }

    public JPanel getJpn4() {
        return jpn4;
    }

    public void setJpn4(JPanel jpn4) {
        this.jpn4 = jpn4;
    }

    public JTextField getRows() {
        return rows;
    }

    public void setRows(JTextField rows) {
        this.rows = rows;
    }

    public JTextField getCol() {
        return col;
    }

    public void setCol(JTextField col) {
        this.col = col;
    }

    public JButton getOk() {
        return ok;
    }

    public void setOk(JButton ok) {
        this.ok = ok;
    }

    public JLabel getWarningText() {
        return warningText;
    }

    public void setWarningText(JLabel warningText) {
        this.warningText = warningText;
    }

    
}
