/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.*;
import javax.swing.*;
import source.*;

/**
 *
 * @author supaschai
 */
public class CodeBlockSub1View{
    private JFrame subFrame1 = new JFrame();
    private JButton submit = new SuComponent().getButton();
    private CodeBlockView cb;
    private JPanel jpn = new SuComponent().getPanel(),
            jpn2 = new SuComponent().getPanel();
    private JTextField input = new SuComponent().getInput(10, -1);
    private JLabel warnningText = new SuComponent().getLabel(12);

    public CodeBlockSub1View(CodeBlockView cb) {
        this.cb = cb;
        JFrame jf = new JFrame();
        subFrame1.setAlwaysOnTop(true);

        jpn.setLayout(new GridLayout(2, 1));

        //jpn2.setLayout(new GridLayout(1, 2));
        jpn2.add(new SuComponent().getBorderPanel(new SuComponent().getLabel(AllTitle.title.get("VariableName")+" : ")));
        jpn2.add(new SuComponent().getBorderPanel(input));

        submit.setText((String)AllTitle.title.get("Add"));
        submit.setBackground(Theme.FG);
        submit.setForeground(Theme.BG);
        
        warnningText.setForeground(Color.RED);
        warnningText.setText("");

        jpn.add(jpn2);
        jpn.add(new SuComponent().getBorderPanel(submit));

        subFrame1.add(new SuComponent().getPanel(warnningText), BorderLayout.NORTH);
        subFrame1.add(jpn);
        subFrame1.pack();
        subFrame1.setVisible(true);
    }


    public JFrame getSubFrame1() {
        return subFrame1;
    }

    public void setSubFrame1(JFrame subFrame1) {
        this.subFrame1 = subFrame1;
    }

    public JButton getSubmit() {
        return submit;
    }

    public void setSubmit(JButton submit) {
        this.submit = submit;
    }

    public CodeBlockView getCb() {
        return cb;
    }

    public void setCb(CodeBlockView cb) {
        this.cb = cb;
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

    public JTextField getInput() {
        return input;
    }

    public void setInput(JTextField input) {
        this.input = input;
    }

    public JLabel getWarnningText() {
        return warnningText;
    }

    public void setWarnningText(JLabel warnningText) {
        this.warnningText = warnningText;
    }


}
