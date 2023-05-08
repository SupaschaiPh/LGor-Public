
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.*;
import javax.swing.*;
import model.Problem;
import view.MapEditorView;
import source.*;
import view.QuotaView;

/**
 *
 * @author supaschai
 */
public class MapEditorCon implements ActionListener {

    private int rows, cols;
    private MapEditorView view;
    private boolean haveCow = false,
            haveChar = false;
    private QuotaView quotaView;

    public MapEditorCon(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        view = new MapEditorView(rows, cols, this);
    }

    public MapEditorCon(Problem pb) {
        view = new MapEditorView(pb.getMap(), pb.getCharaterStatrPosition(),pb.getAnctionStartOfChar(), this);

    }

    public void renderQuoataView(){
        if (this.haveChar) {
            this.quotaView.setCountChar(0);
        } else {
            this.quotaView.setCountChar(1);

        }
        if (this.haveCow) {
            this.quotaView.setCountCow(0);
        } else {
            this.quotaView.setCountCow(1);

        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        JButton jbt = (JButton) e.getSource();
        int keyInput = Integer.parseInt(jbt.getToolTipText());
        final int fixKeyInput = keyInput;

        if (keyInput == 0) {
            jbt.setIcon(Barrier.iconWithGrass);
            jbt.setToolTipText("1");
            return;

        } else if (keyInput == 1) {
            jbt.setIcon(Item.iconWithGrass);
            jbt.setToolTipText("2");
            return;
        }
        if (haveCow && !haveChar) {
            keyInput = 3;
        } else if (keyInput == 2) {
            jbt.setIcon(Cow.iconWithGrass);
            jbt.setToolTipText("3");
        }
        if (haveChar && fixKeyInput < 4) {
            //ข้าม
        } else if (keyInput == 3) {
            jbt.setIcon(source.Character.icon1WithGrass);
            jbt.setToolTipText("4");
        } else if (keyInput == 4) {
            jbt.setIcon(source.Character.icon2WithGrass);
            jbt.setToolTipText("5");
        } else if (keyInput == 5) {
            jbt.setIcon(source.Character.icon3WithGrass);
            jbt.setToolTipText("6");
        } else if (keyInput == 6) {
            jbt.setIcon(source.Character.icon4WithGrass);
            jbt.setToolTipText("7");
        }

        if (keyInput >= 7 || (haveChar && fixKeyInput == 7) || (haveCow && keyInput == 2) || (haveChar && haveCow && keyInput == 3)) {
            jbt.setIcon(Grass.icon);
            jbt.setToolTipText("0");
        }

        if (keyInput == 3) {
            this.haveChar = true;
        } else if (fixKeyInput == 7) {
            this.haveChar = false;
        }
        if (fixKeyInput == 2) {
            this.haveCow = true;
        } else if (fixKeyInput == 3) {
            this.haveCow = false;
        }
        this.renderQuoataView();
        
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

    public MapEditorView getView() {
        return view;
    }

    public void setView(MapEditorView view) {
        this.view = view;
    }

    public boolean isHaveCow() {
        return haveCow;
    }

    public void setHaveCow(boolean haveCow) {
        this.haveCow = haveCow;
    }

    public boolean isHaveChar() {
        return haveChar;
    }

    public void setHaveChar(boolean haveChar) {
        this.haveChar = haveChar;
    }

    public QuotaView getQuotaView() {
        return quotaView;
    }

    public void setQuotaView(QuotaView quotaView) {
        this.quotaView = quotaView;
    }

}
