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
public class ProblemSelectView {

    private JFrame frame = new JFrame();
    private JPanel container = new SuComponent().getPanel(),
            problemData = new SuComponent().getPanel(),
            container2 = new SuComponent().getPanel(),
            container3 = new SuComponent().getPanel(),
            container4 = new SuComponent().getPanel(),
            buttonContainer = new SuComponent().getPanel(),
            rank = new SuComponent().getPanel(new SuComponent().renderBadgeRank(0));
    private JLabel title = new SuComponent().getLabel(AllTitle.title.get("Problem")),
            problemIndex = new SuComponent().getLabel("1", 67),
            problemName = new SuComponent().getLabel(AllTitle.title.get("Not found"), Theme.Heading),
            status = new SuComponent().getLabel(AllTitle.title.get("Not found"), Theme.Normal);
    private JButton left = new SuComponent().getArrowButton(20, "A"),
            right = new SuComponent().getArrowButton(20, "E"),
            solve = new SuComponent().getButton(20, AllTitle.title.get("Not found"));
    private JMenuBar mbar = new SuComponent().getMenuBar();
    private JMenu m = new SuComponent().getMenu("Problem");
    private JMenuItem mitem1 = new SuComponent().getMenuItem("Back"),
            mitem2 = new SuComponent().getMenuItem("AddProblem"),
            mitem3 = new SuComponent().getMenuItem("DeleteProblem"),
            mitem4 = new SuComponent().getMenuItem("EditProblem");

    public ProblemSelectView() {
        this(300, 300, 200, 150);
    }

    public ProblemSelectView(int posx, int posy, int w, int h) {

        m.add(mitem2);
        m.add(mitem4);
        m.add(mitem3);

        mbar.add(mitem1);
        mbar.add(m);

        container.setLayout(new BorderLayout());
        problemData.setLayout(new BorderLayout());
        container2.setLayout(new GridLayout(3, 1));
        container3.setLayout(new BorderLayout());
        container4.setLayout(new BorderLayout());

        problemData.setBorder(Theme.RoundedBorder);
        problemData.setBackground(Theme.BorderC);
        problemIndex.setVerticalAlignment(JLabel.CENTER);
        problemIndex.setHorizontalTextPosition(JLabel.CENTER);
        problemIndex.setHorizontalAlignment(JLabel.CENTER);
        container2.add(new SuComponent().getPanel(problemName));
        container2.add(new SuComponent().getPanel(status));
        container2.add(rank);
        problemData.add(new SuComponent().getPanel(title), BorderLayout.NORTH);
        problemData.add(problemIndex);
        problemData.add(container2, BorderLayout.SOUTH);

        container3.add(new SuComponent().getBorderPanel(40), BorderLayout.WEST);
        container3.add(problemData);
        container3.add(new SuComponent().getBorderPanel(40), BorderLayout.EAST);

        left.setPreferredSize(new Dimension(50, 30));
        right.setPreferredSize(new Dimension(50, 30));
        solve.setPreferredSize(new Dimension(250, 30));
        solve.setBackground(Theme.FG);
        solve.setForeground(Theme.BG);
        buttonContainer.add(new SuComponent().getPanel(left));
        buttonContainer.add(solve);
        buttonContainer.add(new SuComponent().getPanel(right));

        container4.add(new SuComponent().getBorderPanel(container3));
        container4.add(buttonContainer, BorderLayout.SOUTH);

        container.add(new SuComponent().getBorderPanel(container4, 30));

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocation(posx, posy);
        frame.setJMenuBar(mbar);
        frame.add(container);
        frame.setSize(w, h);
        frame.setVisible(true);
    }

    public JPanel getContainer() {
        return container;
    }

    public void setContainer(JPanel container) {
        this.container = container;
    }

    public JPanel getProblemData() {
        return problemData;
    }

    public void setProblemData(JPanel problemData) {
        this.problemData = problemData;
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

    public JPanel getButtonContainer() {
        return buttonContainer;
    }

    public void setButtonContainer(JPanel buttonContainer) {
        this.buttonContainer = buttonContainer;
    }

    public JLabel getTitle() {
        return title;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    public JLabel getProblemIndex() {
        return problemIndex;
    }

    public void setProblemIndex(JLabel problemIndex) {
        this.problemIndex = problemIndex;
    }

    public JLabel getProblemName() {
        return problemName;
    }

    public void setProblemName(JLabel problemName) {
        this.problemName = problemName;
    }

    public JLabel getStatus() {
        return status;
    }

    public void setStatus(JLabel status) {
        this.status = status;
    }

    public JButton getLeft() {
        return left;
    }

    public void setLeft(JButton left) {
        this.left = left;
    }

    public JButton getRight() {
        return right;
    }

    public void setRight(JButton right) {
        this.right = right;
    }

    public JButton getSolve() {
        return solve;
    }

    public void setSolve(JButton solve) {
        this.solve = solve;
    }

    public JMenuBar getMbar() {
        return mbar;
    }

    public void setMbar(JMenuBar mbar) {
        this.mbar = mbar;
    }

    public JMenu getM() {
        return m;
    }

    public void setM(JMenu m) {
        this.m = m;
    }

    public JMenuItem getMitem1() {
        return mitem1;
    }

    public void setMitem1(JMenuItem mitem1) {
        this.mitem1 = mitem1;
    }

    public JMenuItem getMitem2() {
        return mitem2;
    }

    public void setMitem2(JMenuItem mitem2) {
        this.mitem2 = mitem2;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getRank() {
        return rank;
    }

    public void setRank(JPanel rank) {
        this.rank = rank;
    }

    public JMenuItem getMitem3() {
        return mitem3;
    }

    public void setMitem3(JMenuItem mitem3) {
        this.mitem3 = mitem3;
    }

    public JMenuItem getMitem4() {
        return mitem4;
    }

    public void setMitem4(JMenuItem mitem4) {
        this.mitem4 = mitem4;
    }

}
