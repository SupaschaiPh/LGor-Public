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
public class ProblemEditorView implements BeAbleWorkInMDI {

    private JPanel container = new SuComponent().getPanel(),
            container2 = new SuComponent().getPanel(),
            container3 = new SuComponent().getPanel(),
            container4 = new SuComponent().getPanel(),
            container5 = new SuComponent().getPanel(),
            container6 = new SuComponent().getPanel(),
            container7 = new SuComponent().getPanel(),
            container8 = new SuComponent().getPanel(),
            container9 = new SuComponent().getPanel(),
            container10 = new SuComponent().getPanel();
    
    private JLabel lb1 = new SuComponent().getLabel(AllTitle.title.get("Problem Name")),
            lb2 = new SuComponent().getLabel(AllTitle.title.get("Description")),
            lb3 = new SuComponent().getLabel(AllTitle.title.get("Rank")),
            lb4 = new SuComponent().getLabel(AllTitle.title.get("Author")),
            lb5 = new SuComponent().getLabel(AllTitle.title.get("Count must keep item")),
            lb6 = new SuComponent().getLabel(AllTitle.title.get("Limit count command can use"));
    ;
private JTextField name = new SuComponent().getInput(50, Theme.Normal),
            author = new SuComponent().getInput(),
            mustKeepItem = new SuComponent().getInput(),
            limitComand = new SuComponent().getInput();
    private JTextArea desc = new SuComponent().getTextArea(10, 30, Theme.Normal);
    private String[] rankLabel = {"Easy", "Med", "Hard"};
    private JSlider rank = new SuComponent().getSlider(0, 2, 1, 0, rankLabel);
    private JButton button = new SuComponent().getButton("Save");
    
    public ProblemEditorView() {
        limitComand.setText("20");
        mustKeepItem.setText("0");
        rank.setValue(0);
        
        container.setLayout(new BorderLayout());
        container2.setLayout(new BorderLayout());
        container3.setLayout(new GridLayout(2, 1));
        container4.setLayout(new BorderLayout());
        container5.setLayout(new BorderLayout());
        container6.setLayout(new GridLayout(1, 2));
        container7.setLayout(new BorderLayout());
        container8.setLayout(new GridLayout(2, 1));
        container9.setLayout(new GridLayout(2, 2));
        container10.setLayout(new GridLayout(3, 1));
        
        container3.add(lb1);
        container3.add(name);
        
        container4.add(lb2, BorderLayout.NORTH);
        container4.add(desc);
        
        container6.add(lb3);
        container6.add(rank);
        
        container8.add(lb4);
        container8.add(author);
        
        container9.add(lb5);
        container9.add(new SuComponent().getBorderPanel(mustKeepItem));
        container9.add(lb6);
        container9.add(new SuComponent().getBorderPanel(limitComand));
        
        container5.add(container8, BorderLayout.NORTH);
        container5.add(container6);
        container5.add(container9, BorderLayout.SOUTH);
        
        container7.add(container3, BorderLayout.NORTH);
        container7.add(container4);
        container7.add(container5, BorderLayout.SOUTH);

        //container2.add(container4);
        //container2.add(name)
        button.setBackground(Theme.FG);
        button.setForeground(Theme.BG);
        
        container10.add(new SuComponent().getPanel());
        container10.add(new SuComponent().getPanel());
        container10.add(button);
        
        container2.add(container7);
        container2.add(container10, BorderLayout.SOUTH);
        
        container2.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        container.add(new SuComponent().getBorderPanel(container2));
        
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

    public JPanel getContainer7() {
        return container7;
    }

    public void setContainer7(JPanel container7) {
        this.container7 = container7;
    }

    public JPanel getContainer8() {
        return container8;
    }

    public void setContainer8(JPanel container8) {
        this.container8 = container8;
    }

    public JPanel getContainer9() {
        return container9;
    }

    public void setContainer9(JPanel container9) {
        this.container9 = container9;
    }

    public JPanel getContainer10() {
        return container10;
    }

    public void setContainer10(JPanel container10) {
        this.container10 = container10;
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

    public JLabel getLb3() {
        return lb3;
    }

    public void setLb3(JLabel lb3) {
        this.lb3 = lb3;
    }

    public JLabel getLb4() {
        return lb4;
    }

    public void setLb4(JLabel lb4) {
        this.lb4 = lb4;
    }

    public JLabel getLb5() {
        return lb5;
    }

    public void setLb5(JLabel lb5) {
        this.lb5 = lb5;
    }

    public JLabel getLb6() {
        return lb6;
    }

    public void setLb6(JLabel lb6) {
        this.lb6 = lb6;
    }

    public JTextField getName() {
        return name;
    }

    public void setName(JTextField name) {
        this.name = name;
    }

    public JTextField getAuthor() {
        return author;
    }

    public void setAuthor(JTextField author) {
        this.author = author;
    }

    public JTextField getMustKeepItem() {
        return mustKeepItem;
    }

    public void setMustKeepItem(JTextField mustKeepItem) {
        this.mustKeepItem = mustKeepItem;
    }

    public JTextField getLimitComand() {
        return limitComand;
    }

    public void setLimitComand(JTextField limitComand) {
        this.limitComand = limitComand;
    }

    public JTextArea getDesc() {
        return desc;
    }

    public void setDesc(JTextArea desc) {
        this.desc = desc;
    }

    public String[] getRankLabel() {
        return rankLabel;
    }

    public void setRankLabel(String[] rankLabel) {
        this.rankLabel = rankLabel;
    }

    public JSlider getRank() {
        return rank;
    }

    public void setRank(JSlider rank) {
        this.rank = rank;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }
    
    @Override
    public JPanel getContainer() {
        return container;
    }
    
    
}
