/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.*;
import javax.swing.*;
import source.*;
import view.*;

/**
 *
 * @author supaschai
 */
public class CodeBlockCon implements ActionListener {

    private CodeBlockView view;
    private CodeBlockSub1Con codeBlockSub1Con;
    private CodeBlockSub2Con codeBlockSub2Con;
    private int perfecLocationForSubVX = 100, perfecLocationForSubVY = 100;

    public CodeBlockCon(int stackCodeSize) {
        view = new CodeBlockView(stackCodeSize, this);
        view.getMenuItem()[1].addActionListener(this);
        view.getMenuItem()[2].addActionListener(this);

        view.getPointUp().addActionListener(this);
        view.getPointDown().addActionListener(this);

    }

    public void renderCodeBox(String inputCommand) {
        if (inputCommand.equals("Del")) {
            view.getStackCode().setValueAt("", view.getPointerPosition(), 0);
            view.getStackCode().setValueAt("", view.getPointerPosition(), 1);

        } else {
            view.getStackCode().setValueAt(inputCommand, view.getPointerPosition(), 0);
            int indent = 0;
            for (int i = 0; i < view.getStackCode().getRowCount(); i++) {
                String command = (String) view.getStackCode().getValueAt(i, 0);
                if (command == null) {
                    continue;
                }
                command = command.strip();
                for (int x = 0; x < indent; x++) {
                    command = "  " + command;
                }
                if (command.strip().equals("if->")
                        || command.strip().equals("else")
                        || command.strip().equals("for->")) {
                    indent += 1;
                } else if (command.strip().equals("end if")
                        || command.strip().equals("end else")
                        || command.strip().equals("end for")) {
                    indent -= 1;
                    command = command.strip();
                    for (int x = 0; x < indent; x++) {
                        command = "  " + command;
                    }
                }
                view.getStackCode().setValueAt(command, i, 0);
                if (!((command != null) && (command.strip().equals("if->") || command.strip().equals("for->")))) {
                    view.getStackCode().setValueAt("", i, 1);

                }
            }
            indent = 0;
        }
    }

    public void renderConditionBox(String inputCondition) {
        if (inputCondition.equals("Del")) {
            view.getStackCode().setValueAt("", view.getPointerPosition(), 1);

        } else {
            if (view.getStackCode().getValueAt(view.getPointerPosition(), 0) == null) {
                JLabel lb = new SuComponent().getLabel((String) AllTitle.title.get("Condition Only Use with [if, for]"));
                lb.setBackground(Theme.Transparent);
                JOptionPane.showMessageDialog(null, lb, "Warnning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String command = (String) view.getStackCode().getValueAt(view.getPointerPosition(), 0);
            command = command.strip();
            if (command.indexOf("->")!=-1) {
                view.getStackCode().setValueAt(inputCondition, view.getPointerPosition(), 1);
            } else {
                JLabel lb = new SuComponent().getLabel((String) AllTitle.title.get("Condition Only Use with [if, for]"));
                lb.setBackground(Theme.Transparent);
                JOptionPane.showMessageDialog(null, lb, "Warnning", JOptionPane.WARNING_MESSAGE);

            }

        }
    }

    public void movePointer(int move) {
        view.getStackCode().setValueAt("", view.getPointerPosition(), 2);
        if (view.getPointerPosition() + move >= view.getStackCodeSize()) {
            view.setPointerPosition(0);
        } else if (view.getPointerPosition() + move < 0) {
            view.setPointerPosition(view.getStackCodeSize() - 1);
        } else {
            view.setPointerPosition(view.getPointerPosition() + move);
        }
        view.getStackCode().setValueAt("<--", view.getPointerPosition(), 2);
        //Animation.Wiggle.setStackCode( view.getStackCode());
        Animation.Wiggle.setPointerPosition(view.getPointerPosition());
    }

    public void movePointerTo(int move) {
        view.getStackCode().setValueAt("", view.getPointerPosition(), 2);
        if (move >= view.getStackCodeSize()) {
            view.setPointerPosition(move);
        } else if (move < 0) {
            view.setPointerPosition(move);
        } else {
            view.setPointerPosition(move);
        }
        view.getStackCode().setValueAt("<--", view.getPointerPosition(), 2);
        //Animation.Wiggle.setStackCode( view.getStackCode());
        Animation.Wiggle.setPointerPosition(view.getPointerPosition());
    }

    public void setperfecLocationForSubV(int x, int y) {
        this.perfecLocationForSubVX = x;
        this.perfecLocationForSubVY = y;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(view.getMenuItem()[1])) {
            this.codeBlockSub1Con = new CodeBlockSub1Con(this);
            this.codeBlockSub1Con.getView().getSubFrame1().setLocation(perfecLocationForSubVX, perfecLocationForSubVY);

        } else if (e.getSource().equals(view.getMenuItem()[2])) {
            this.codeBlockSub2Con = new CodeBlockSub2Con(this);
            this.codeBlockSub2Con.getView().getSubFrame2().setLocation(perfecLocationForSubVX, perfecLocationForSubVY);

        } else if (e.getSource().equals(view.getMenuItem()[0])) {
            for (int i = 0; i <= view.getStackCode().getRowCount(); i++) {
                view.getStackCode().setValueAt("", i, 0);
                view.getStackCode().setValueAt("", i, 1);

            }
        } else if (e.getSource().equals(view.getPointDown())) {

            //ทำให้pointer เลื่อนขึ้นไปด้านบน
            this.movePointer(1);

        } else if (e.getSource().equals(view.getPointUp())) {

            //ทำให้pointer เลื่อนลงไปด้านล่าง
            this.movePointer(-1);

        } else {
            String inputCommand = e.getActionCommand();
            if (((JButton) e.getSource()).getBackground().equals(Theme.Info)) {
                this.renderCodeBox(inputCommand);
            } else if (((JButton) e.getSource()).getBackground().equals(Theme.Warning)) {
                this.renderConditionBox(inputCommand);
            }

        }

    }

    public CodeBlockView getView() {
        return view;
    }

    public void setView(CodeBlockView view) {
        this.view = view;
    }

    public CodeBlockSub1Con getCodeBlockSub1Con() {
        return codeBlockSub1Con;
    }

    public void setCodeBlockSub1Con(CodeBlockSub1Con codeBlockSub1Con) {
        this.codeBlockSub1Con = codeBlockSub1Con;
    }

    public CodeBlockSub2Con getCodeBlockSub2Con() {
        return codeBlockSub2Con;
    }

    public void setCodeBlockSub2Con(CodeBlockSub2Con codeBlockSub2Con) {
        this.codeBlockSub2Con = codeBlockSub2Con;
    }

}
