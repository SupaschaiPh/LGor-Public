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
public class CodeBlockSub3View{

    private JFrame subFrame3 = new JFrame();
    private JButton submit = new SuComponent().getButton();
    private JPanel jpn = new SuComponent().getPanel(),
            jpn2 = new SuComponent().getPanel();
    private JTextField input = new SuComponent().getInput(10, -1);
    private JLabel warnningText = new SuComponent().getLabel(12);
    private String command;
    

    public CodeBlockSub3View(String command) {
        JFrame jf = new JFrame();
        subFrame3.setAlwaysOnTop(true);

        jpn.setLayout(new GridLayout(2, 1));
        this.command = command.replace("[int]", "");
        jpn2.add(new SuComponent().getBorderPanel(new SuComponent().getLabel(this.command)));
        jpn2.add(new SuComponent().getBorderPanel(input));

        submit.setText("Ok");
        submit.setBackground(Theme.FG);
        submit.setForeground(Theme.BG);

        warnningText.setForeground(Color.RED);
        warnningText.setText("");

        jpn.add(jpn2);
        jpn.add(new SuComponent().getBorderPanel(submit));

        subFrame3.add(new SuComponent().getPanel(warnningText), BorderLayout.NORTH);
        subFrame3.add(jpn);
        subFrame3.setAlwaysOnTop(true);
        subFrame3.setLocationByPlatform(true);
        subFrame3.pack();
        subFrame3.setVisible(true);
    }

    public JFrame getSubFrame3() {
        return subFrame3;
    }

    public void setSubFrame3(JFrame subFrame3) {
        this.subFrame3 = subFrame3;
    }

    public JButton getSubmit() {
        return submit;
    }

    public void setSubmit(JButton submit) {
        this.submit = submit;
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

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    

    
}
