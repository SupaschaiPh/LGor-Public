/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.*;
import javax.swing.*;
import source.*;
import control.*;

/**
 *
 * @author supaschai
 */
public class CodeBlockSub2View {

    private CodeBlockView cb;
    private CodeBlockCon cbCon;
    private CodeBlockSub2Con control;
    private JFrame subFrame2 = new JFrame();
    private JPanel customControl = new SuComponent().getPanel(),
            customControlBtGroup = new SuComponent().getPanel();
    private String customCList[] = AllTitle.customCList;

    // set .. to ... , ..++ , ..--
    // ..>=.... ..>... 
    public CodeBlockSub2View(CodeBlockCon cbCon,CodeBlockSub2Con control) {
        this.cbCon = cbCon;
        this.control = control;
        this.cb = (CodeBlockView) cbCon.getView();
        if (this.cb.getVarableList().size() == 0) {
            JLabel lb = new SuComponent().getLabel(AllTitle.title.get("New Coutsome Var Please add before"));
            lb.setBackground(Theme.Transparent);
            JOptionPane.showMessageDialog(subFrame2, lb, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        this.customControlBtGroup.setLayout(new GridLayout(this.cb.getVarableList().size() * 2, 4));
        for (int i = 0; i < this.cb.getVarableList().size(); i++) {
            for (int x = 0; x < customCList.length; x++) {
                JButton jbt = new SuComponent().getButton(String.format(customCList[x], this.cb.getVarableList().get(i)));
                if (x < 3) {
                    jbt.setBackground(Theme.Info);
                } else {
                    jbt.setBackground(Theme.Warning);
                }
                jbt.addActionListener(this.control);
                this.customControlBtGroup.add(new SuComponent().getBorderPanel(jbt));
            }
        }
        this.subFrame2.add(new SuComponent().getPanel(new SuComponent().getLabel("customControl")), BorderLayout.NORTH);
        this.subFrame2.add(this.customControlBtGroup);
        this.subFrame2.setAlwaysOnTop(true);
        this.subFrame2.setLocationByPlatform(true);
        this.subFrame2.pack();
        this.subFrame2.setVisible(true);
    }

    public CodeBlockView getCb() {
        return cb;
    }

    public void setCb(CodeBlockView cb) {
        this.cb = cb;
    }

    public CodeBlockCon getCbCon() {
        return cbCon;
    }

    public void setCbCon(CodeBlockCon cbCon) {
        this.cbCon = cbCon;
    }

    public JFrame getSubFrame2() {
        return subFrame2;
    }

    public void setSubFrame2(JFrame subFrame2) {
        this.subFrame2 = subFrame2;
    }

    public JPanel getCustomControl() {
        return customControl;
    }

    public void setCustomControl(JPanel customControl) {
        this.customControl = customControl;
    }

    public JPanel getCustomControlBtGroup() {
        return customControlBtGroup;
    }

    public void setCustomControlBtGroup(JPanel customControlBtGroup) {
        this.customControlBtGroup = customControlBtGroup;
    }

    public String[] getCustomCList() {
        return customCList;
    }

    public void setCustomCList(String[] customCList) {
        this.customCList = customCList;
    }

}
