/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author supaschai
 */
import java.awt.event.*;
import javax.swing.JButton;
import source.Theme;
import view.*;
public class CodeBlockSub2Con implements ActionListener {
    private CodeBlockSub2View view;
    private CodeBlockSub3Con sub3;

    public CodeBlockSub2Con(CodeBlockCon codeBlockCon) {
        view = new CodeBlockSub2View(codeBlockCon,this);
    }
     @Override
    public void actionPerformed(ActionEvent e) {
        if (((JButton) e.getSource()).getBackground().equals(Theme.Info)) {
           sub3 = new CodeBlockSub3Con(view.getCbCon(), e.getActionCommand(), 'a');
           sub3.getView().getSubFrame3().setLocation(this.view.getSubFrame2().getLocation().x, this.view.getSubFrame2().getLocation().y);
        } else if (((JButton) e.getSource()).getBackground().equals(Theme.Warning)) {
           sub3 = new CodeBlockSub3Con(view.getCbCon(), e.getActionCommand(), 'b');
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public CodeBlockSub2View getView() {
        return view;
    }

    public void setView(CodeBlockSub2View view) {
        this.view = view;
    }

    public CodeBlockSub3Con getSub3() {
        return sub3;
    }

    public void setSub3(CodeBlockSub3Con sub3) {
        this.sub3 = sub3;
    }
    
}
