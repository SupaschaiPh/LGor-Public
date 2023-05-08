/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author supaschai
 */
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.LinkedList;
import source.*;
import control.*;

public class CodeBlockView implements BeAbleWorkInMDI {

    private CodeBlockCon control;
    private static Dimension dimension = new Dimension(700, 500);
    private JPanel container = new SuComponent().getPanel(),
            lPanel = new SuComponent().getPanel(),
            rPanel = new SuComponent().getBorderPanel();

    private JPanel previewBox = new SuComponent().getPanel(),
            pointerControl = new SuComponent().getPanel(),
            pointerControlBtGroup = new SuComponent().getPanel(),
            commandControl = new SuComponent().getPanel(),
            commandControlBtGroup = new SuComponent().getPanel(),
            conditionControl = new SuComponent().getPanel(),
            conditionControlBtGroup = new SuComponent().getPanel();
    private JButton pointUp = new SuComponent().getArrowButton(),
            pointDown = new SuComponent().getArrowButton();
    private JMenuBar menuBar = new SuComponent().getMenuBar();
    private JMenu menu[] = {
        new SuComponent().getMenu(AllTitle.title.get("Custom"))
    };
    private JMenuItem menuItem[] = {
        new SuComponent().getMenu(AllTitle.title.get("Clear All")),
        new SuComponent().getMenuItem(AllTitle.title.get("Add Variable")),
        new SuComponent().getMenuItem(AllTitle.title.get("View Custom"))
    };
    private JLabel lb[] = new JLabel[3];
    private String lableList[] = AllTitle.lableList;
    private String commandList[] = AllTitle.commandList;
    private String conditionList[] = AllTitle.conditionList;
    private int stackCodeSize = 0;
    private JTable stackCode;
    private String[] stackCode_head = AllTitle.stackCode_head;
    private String[] condition = {};
    private int pointerPosition = 0;
    private LinkedList<String> varableList = new LinkedList();

    public CodeBlockView(int stackCodeSize, Object control) {
        this.control = (CodeBlockCon) control;
        this.stackCodeSize = stackCodeSize;

        menu[0].add(menuItem[1]);
        menu[0].add(menuItem[2]);

        menuBar.add(menu[0]);

        pointUp.setText("C");
        pointDown.setText("G");

        for (int i = 0; i < this.lableList.length; i++) {
            lb[i] = new SuComponent().getLabel(lableList[i]);
            lb[i].setHorizontalAlignment(JLabel.CENTER);
        }

        this.container.setLayout(new GridLayout(1, 2));

        /**
         * Left Panel Container Control button
         */
        this.lPanel.setLayout(new GridLayout(3, 1));

        this.pointerControl.setLayout(new BorderLayout());
        this.pointerControlBtGroup.setLayout(new GridLayout(1, 2));
        this.pointerControl.setBorder(Theme.Border);
        this.pointerControlBtGroup.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.pointerControl.setBackground(Color.WHITE);
        this.pointerControlBtGroup.setBackground(Color.WHITE);
        this.pointUp.setMargin(new Insets(20, 10, 20, 10));
        this.pointDown.setMargin(new Insets(20, 10, 20, 10));
        this.pointerControlBtGroup.add(new SuComponent().getBorderPanel(pointUp));
        this.pointerControlBtGroup.add(new SuComponent().getBorderPanel(pointDown));
        this.pointerControl.add(lb[0], BorderLayout.NORTH);
        this.pointerControl.add(pointerControlBtGroup, BorderLayout.CENTER);

        this.commandControlBtGroup.setLayout(new GridLayout(3, 4));
        for (int i = 0; i < this.commandList.length; i++) {
            JPanel p = new SuComponent().getPanel();
            p.setLayout(new java.awt.BorderLayout());
            p.setBorder(Theme.EEmptyBorder);
            JButton jbt = new SuComponent().getButton();
            jbt.setText(commandList[i]);
            jbt.setBackground(Theme.Info);
            jbt.setBorder(new RoundedBorder(Theme.InfoBorder));
            p.add(jbt);
            this.commandControlBtGroup.add(p);
            jbt.addActionListener(this.control);
        }
        this.commandControl.setBorder(Theme.Border);
        this.commandControl.setLayout(new BorderLayout());
        this.commandControl.add(lb[1], BorderLayout.NORTH);
        this.commandControl.add(commandControlBtGroup);

        this.conditionControlBtGroup.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < this.conditionList.length; i++) {
            JPanel p = new SuComponent().getPanel();
            p.setLayout(new java.awt.BorderLayout());
            p.setBorder(Theme.EEmptyBorder);
            JButton jbt = new SuComponent().getButton();
            jbt.setText(conditionList[i]);
            jbt.setBackground(Theme.Warning);
            jbt.setBorder(new RoundedBorder(Theme.WarningBorder));
            jbt.addActionListener(this.control);
            p.add(jbt);
            this.conditionControlBtGroup.add(p);
        }
        this.conditionControlBtGroup.add(new SuComponent().getPanel());
        this.conditionControlBtGroup.add(new SuComponent().getPanel());
        this.conditionControlBtGroup.add(new SuComponent().getPanel());
        this.conditionControlBtGroup.add(new SuComponent().getPanel());
        this.conditionControlBtGroup.add(new SuComponent().getPanel());
        this.conditionControlBtGroup.add(new SuComponent().getPanel());

        this.conditionControl.setBorder(Theme.Border);
        this.conditionControl.setLayout(new BorderLayout());
        this.conditionControl.add(lb[2], BorderLayout.NORTH);
        this.conditionControl.add(this.conditionControlBtGroup);

        this.lPanel.add(this.pointerControl);
        this.lPanel.add(this.commandControl);
        this.lPanel.add(this.conditionControl);

        /**
         * Right Panel Container Stackcode
         */
        String data[][] = new String[this.stackCodeSize][3];
        this.stackCode = new SuComponent().getTable(data, stackCode_head);
        this.stackCode.setValueAt("<--", this.pointerPosition, 2);
        this.rPanel.add(new SuComponent().getScrollPane(stackCode));

        container.add(this.rPanel);
        container.add(this.lPanel);

        Animation.Wiggle w = new Animation.Wiggle();
        Animation.Wiggle.setStackCode(this.stackCode);
        java.lang.Thread t = new Thread(w);
        t.start();
        Animation.Wiggle.setPointerPosition(this.pointerPosition);
    }

    @Override
    public JPanel getContainer() {
        return this.container;
    }

    public static Dimension getDimension() {
        return dimension;
    }

    public CodeBlockCon getControl() {
        return control;
    }

    public void setControl(CodeBlockCon control) {
        this.control = control;
    }

    public JPanel getlPanel() {
        return lPanel;
    }

    public void setlPanel(JPanel lPanel) {
        this.lPanel = lPanel;
    }

    public JPanel getrPanel() {
        return rPanel;
    }

    public void setrPanel(JPanel rPanel) {
        this.rPanel = rPanel;
    }

    public JPanel getPreviewBox() {
        return previewBox;
    }

    public void setPreviewBox(JPanel previewBox) {
        this.previewBox = previewBox;
    }

    public JPanel getPointerControl() {
        return pointerControl;
    }

    public void setPointerControl(JPanel pointerControl) {
        this.pointerControl = pointerControl;
    }

    public JPanel getPointerControlBtGroup() {
        return pointerControlBtGroup;
    }

    public void setPointerControlBtGroup(JPanel pointerControlBtGroup) {
        this.pointerControlBtGroup = pointerControlBtGroup;
    }

    public JPanel getCommandControl() {
        return commandControl;
    }

    public void setCommandControl(JPanel commandControl) {
        this.commandControl = commandControl;
    }

    public JPanel getCommandControlBtGroup() {
        return commandControlBtGroup;
    }

    public void setCommandControlBtGroup(JPanel commandControlBtGroup) {
        this.commandControlBtGroup = commandControlBtGroup;
    }

    public JPanel getConditionControl() {
        return conditionControl;
    }

    public void setConditionControl(JPanel conditionControl) {
        this.conditionControl = conditionControl;
    }

    public JPanel getConditionControlBtGroup() {
        return conditionControlBtGroup;
    }

    public void setConditionControlBtGroup(JPanel conditionControlBtGroup) {
        this.conditionControlBtGroup = conditionControlBtGroup;
    }

    public JButton getPointUp() {
        return pointUp;
    }

    public void setPointUp(JButton pointUp) {
        this.pointUp = pointUp;
    }

    public JButton getPointDown() {
        return pointDown;
    }

    public void setPointDown(JButton pointDown) {
        this.pointDown = pointDown;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public JMenu[] getMenu() {
        return menu;
    }

    public void setMenu(JMenu[] menu) {
        this.menu = menu;
    }

    public JMenuItem[] getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(JMenuItem[] menuItem) {
        this.menuItem = menuItem;
    }

    public JLabel[] getLb() {
        return lb;
    }

    public void setLb(JLabel[] lb) {
        this.lb = lb;
    }

    public String[] getLableList() {
        return lableList;
    }

    public void setLableList(String[] lableList) {
        this.lableList = lableList;
    }

    public String[] getCommandList() {
        return commandList;
    }

    public void setCommandList(String[] commandList) {
        this.commandList = commandList;
    }

    public String[] getConditionList() {
        return conditionList;
    }

    public void setConditionList(String[] conditionList) {
        this.conditionList = conditionList;
    }

    public int getStackCodeSize() {
        return stackCodeSize;
    }

    public void setStackCodeSize(int stackCodeSize) {
        this.stackCodeSize = stackCodeSize;
    }

    public JTable getStackCode() {
        return stackCode;
    }

    public void setStackCode(JTable stackCode) {
        this.stackCode = stackCode;
    }

    public String[] getStackCode_head() {
        return stackCode_head;
    }

    public void setStackCode_head(String[] stackCode_head) {
        this.stackCode_head = stackCode_head;
    }

    public String[] getCondition() {
        return condition;
    }

    public void setCondition(String[] condition) {
        this.condition = condition;
    }

    public int getPointerPosition() {
        return pointerPosition;
    }

    public void setPointerPosition(int pointerPosition) {
        this.pointerPosition = pointerPosition;
    }

    public LinkedList<String> getVarableList() {
        return varableList;
    }

    public void setVarableList(LinkedList<String> varableList) {
        this.varableList = varableList;
    }

    

    

}
