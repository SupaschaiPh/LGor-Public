
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import control.*;
import javax.swing.*;
import source.Theme;

/**
 *
 * @author supaschai
 */
public class CreateProblemView {

    private JFrame frame = new JFrame();
    private JDesktopPane MDI = new JDesktopPane();
    private JInternalFrame intFrame1 = new JInternalFrame("MapEditor", true, false, true, true),
            intFrame2 = new JInternalFrame("ProblemEditor", true, false, true, true),
            intFrame3 = new JInternalFrame("QuotaView", false, false, true, true);
    private MapEditorCon mapEditor;
    private ProblemEditorView problemEditorView = new ProblemEditorView();
    private QuotaView quotaView = new QuotaView();
    private int topsep = 10;

    private int rows, cols;

    public CreateProblemView(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        mapEditor = new MapEditorCon(rows, cols);
        mapEditor.setQuotaView(quotaView);

        intFrame1.add(mapEditor.getView().getContainer());
        intFrame2.add(problemEditorView.getContainer());
        intFrame3.add(quotaView.getContainer());
        intFrame1.pack();
        intFrame2.pack();
        intFrame3.pack();
        intFrame3.setSize(intFrame2.getSize().width, intFrame3.getSize().height);

        //(intFrame1.getSize().width+intFrame2.getSize().width)/3 //250
        if (intFrame1.getSize().width > 500) {
            int divv = (int) Math.ceil(Double.parseDouble("" + intFrame1.getSize().width) / 500);
            System.out.println(divv);
            intFrame1.setSize(intFrame1.getSize().width / divv, intFrame1.getSize().height / divv);
        }

        intFrame1.setLocation((1920 - (intFrame1.getSize().width + intFrame2.getSize().width)) / 4, intFrame1.getSize().height / 10);
        intFrame2.setLocation(intFrame1.getSize().width + intFrame1.getLocation().x, intFrame3.getHeight()+topsep);
        intFrame3.setLocation(intFrame2.getLocation().x, topsep);

        MDI.setBackground(Theme.Primary);

        intFrame1.setVisible(true);
        intFrame2.setVisible(true);
        intFrame3.setVisible(true);

        MDI.add(intFrame1);
        MDI.add(intFrame2);
        MDI.add(intFrame3);

        
        frame.add(MDI);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public CreateProblemView() {
        this(10, 10);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JDesktopPane getMDI() {
        return MDI;
    }

    public void setMDI(JDesktopPane MDI) {
        this.MDI = MDI;
    }

    public JInternalFrame getIntFrame1() {
        return intFrame1;
    }

    public void setIntFrame1(JInternalFrame intFrame1) {
        this.intFrame1 = intFrame1;
    }

    public JInternalFrame getIntFrame2() {
        return intFrame2;
    }

    public void setIntFrame2(JInternalFrame intFrame2) {
        this.intFrame2 = intFrame2;
    }

    public MapEditorCon getMapEditor() {
        return mapEditor;
    }

    public void setMapEditor(MapEditorCon mapEditor) {
        this.mapEditor = mapEditor;
    }

    public ProblemEditorView getProblemEditorView() {
        return problemEditorView;
    }

    public void setProblemEditorView(ProblemEditorView problemEditorView) {
        this.problemEditorView = problemEditorView;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

}
