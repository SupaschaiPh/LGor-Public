/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;
import java.awt.*;
import source.*;
import control.*;

/**
 *
 * @author supaschai
 */
public class MapEditorView implements BeAbleWorkInMDI {

    private JPanel container = new SuComponent().getPanel();
    private JPanel girdTableCt = new JPanel();
    private JButton map[][];

    public MapEditorView(int rows, int cols, MapEditorCon control) {
        container.setLayout(new BorderLayout());
        girdTableCt.setLayout(new GridLayout(rows, cols));
        map = new JButton[rows][];
        for (int iRow = 0; iRow < rows; iRow++) {
            map[iRow] = new JButton[cols];
            for (int iCol = 0; iCol < cols; iCol++) {
                map[iRow][iCol] = new SuComponent().getButton();
                map[iRow][iCol].setIcon(Grass.icon);
                map[iRow][iCol].setToolTipText(0 + "");
                map[iRow][iCol].addActionListener(control);
                girdTableCt.add(map[iRow][iCol]);
            }
        }
        container.add(new SuComponent().getPanel(new SuComponent().getLabel("MapEditor")), BorderLayout.NORTH);
        container.add(new SuComponent().getBorderPanel(girdTableCt));

    }

    public MapEditorView(int[][] map, int[] charPos, String charStartAction, MapEditorCon control) {
        container.setLayout(new BorderLayout());
        girdTableCt.setLayout(new GridLayout(map.length, map[0].length));
        control.setHaveChar(true);
        control.setHaveCow(true);

        this.map = new JButton[map.length][];
        for (int iRow = 0; iRow < map.length; iRow++) {
            this.map[iRow] = new JButton[map[iRow].length];
            for (int iCol = 0; iCol < map[iRow].length; iCol++) {
                this.map[iRow][iCol] = new SuComponent().getButton();
                if (map[iRow][iCol] == ElementId.Barrier) {
                    this.map[iRow][iCol].setIcon(Barrier.iconWithGrass);
                    this.map[iRow][iCol].setToolTipText(ElementId.Barrier + "");
                } else if (map[iRow][iCol] == ElementId.Item) {
                    this.map[iRow][iCol].setIcon(Item.iconWithGrass);
                    this.map[iRow][iCol].setToolTipText(ElementId.Item + "");
                } else if (map[iRow][iCol] == ElementId.Cow) {
                    this.map[iRow][iCol].setIcon(Cow.iconWithGrass);
                    this.map[iRow][iCol].setToolTipText(ElementId.Cow + "");
                } else if (iRow == charPos[0] && iCol == charPos[1]) {
                    if (charStartAction.equals("waitB")) {
                        this.map[iRow][iCol].setIcon(source.Character.icon1WithGrass);
                        this.map[iRow][iCol].setToolTipText("4");
                    } else if (charStartAction.equals("waitG")) {
                        this.map[iRow][iCol].setIcon(source.Character.icon3WithGrass);
                        this.map[iRow][iCol].setToolTipText("5");
                    } else if (charStartAction.equals("waitL")) {
                        this.map[iRow][iCol].setIcon(source.Character.icon3WithGrass);
                        this.map[iRow][iCol].setToolTipText("6");
                    } else {
                        this.map[iRow][iCol].setIcon(source.Character.icon4WithGrass);
                        this.map[iRow][iCol].setToolTipText("7");
                    }
                } else {
                    this.map[iRow][iCol].setIcon(Grass.icon);
                    this.map[iRow][iCol].setToolTipText(0 + "");

                }
                this.map[iRow][iCol].addActionListener(control);
                girdTableCt.add(this.map[iRow][iCol]);
            }
        }
        container.add(new SuComponent().getPanel(new SuComponent().getLabel("MapEditor")), BorderLayout.NORTH);
        container.add(new SuComponent().getBorderPanel(girdTableCt));
    }

    public JPanel getGirdTableCt() {
        return girdTableCt;
    }

    public void setGirdTableCt(JPanel girdTableCt) {
        this.girdTableCt = girdTableCt;
    }

    public JButton[][] getMap() {
        return map;
    }

    public void setMap(JButton[][] map) {
        this.map = map;
    }

    @Override
    public JPanel getContainer() {
        return this.container;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
