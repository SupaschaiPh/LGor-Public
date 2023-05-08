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
    public MapEditorView(int rows, int cols,MapEditorCon control) {
        container.setLayout(new BorderLayout());
        girdTableCt.setLayout(new GridLayout(rows, cols));
        map = new JButton[rows][];
        for (int iRow = 0; iRow < rows; iRow++) {
             map[iRow] = new JButton[cols];
            for (int iCol = 0; iCol < cols; iCol++) {
                map[iRow][iCol] = new SuComponent().getButton();
                map[iRow][iCol].setIcon(Grass.icon);
                map[iRow][iCol].setToolTipText(0+"");
                map[iRow][iCol].addActionListener(control);
                girdTableCt.add(map[iRow][iCol]);
            }
        }
        container.add(new SuComponent() .getPanel(new SuComponent().getLabel("MapEditor")),BorderLayout.NORTH);
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
