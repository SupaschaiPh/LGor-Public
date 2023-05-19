/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.*;
import view.*;

/**
 *
 * @author supaschai
 */
public class CodeBlockSub3Con implements ActionListener {

    private CodeBlockSub3View view;
    private CodeBlockCon cb;
    private char type; //a = command , b = condition

    public CodeBlockSub3Con(CodeBlockCon cb, String command, char type) {
        this.cb = cb;
        this.type = type;
        this.view = new CodeBlockSub3View(command);
        this.view.getInput().addActionListener(this);
        this.view.getSubmit().addActionListener(this);

    }

    private void render(String ic) {
        if (this.type == 'a') {
            this.cb.renderCodeBox(ic);
        } else if (this.type == 'b') {
            this.cb.renderConditionBox(ic);
        }
    }

    public CodeBlockSub3View getView() {
        return view;
    }

    public void setView(CodeBlockSub3View view) {
        this.view = view;
    }

    public CodeBlockCon getCb() {
        return cb;
    }

    public void setCb(CodeBlockCon cb) {
        this.cb = cb;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int inputData = Integer.parseInt(this.view.getInput().getText());
            this.view.getWarnningText().setText("");
            this.view.getSubFrame3().pack();
            this.view.getSubFrame3().dispose();
            this.render(this.view.getCommand() + inputData);

        } catch (Exception ex) {
            this.view.getWarnningText().setText((String) AllTitle.title.get("Accept Integer Only"));
            this.view.getSubFrame3().pack();

        }
    }
}
