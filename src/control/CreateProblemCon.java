/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.*;
import javax.swing.*;
import lgor.LGor;
import model.Problem;
import view.*;
import source.*;

/**
 *
 * @author supaschai
 */
public class CreateProblemCon implements ActionListener {

    private CreateProblemView view;
    private CreateProblemViewSub1View subView1;
    private int problemIndex = -1;
    public CreateProblemCon() {
        subView1 = new CreateProblemViewSub1View();
        subView1.getOk().addActionListener(this);
    }
    public CreateProblemCon(Problem pb, int problemIndex) {
        view = new CreateProblemView(pb);
        this.problemIndex = problemIndex;
        this.view.getMapEditor().renderQuoataView();
        this.view.getProblemEditorView().getButton().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (subView1 != null && e.getSource().equals(subView1.getOk())) {
            try {
                Integer.parseInt(subView1.getRows().getText());
                Integer.parseInt(subView1.getCol().getText());
                this.subView1.getSubFrame1().dispose();
                view = new CreateProblemView(Integer.parseInt(subView1.getRows().getText()),
                        Integer.parseInt(subView1.getCol().getText()));
                this.view.getProblemEditorView().getButton().addActionListener(this);
                
            } catch (Exception ex) {
                this.subView1.getWarningText().setText("Row กับ Col ต้องเป็นตัวเลขเท่านั้น");
                this.subView1.getSubFrame1().pack();
            }
        } else if (e.getSource().equals(this.view.getProblemEditorView().getButton())) {
            if (!this.view.getMapEditor().isHaveChar()) {
                JOptionPane.showMessageDialog(this.view.getFrame(), "Map must have character", "ProblemEdtior", JOptionPane.WARNING_MESSAGE);
                return;

            } else if (!this.view.getMapEditor().isHaveCow()) {
                JOptionPane.showMessageDialog(this.view.getFrame(), "Map must have cow", "ProblemEdtior", JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                String name = this.view.getProblemEditorView().getName().getText().strip();
                String desc = this.view.getProblemEditorView().getDesc().getText().strip();
                String author = this.view.getProblemEditorView().getAuthor().getText().strip();
                int countMustKeepItem = Integer.parseInt(this.view.getProblemEditorView().getMustKeepItem().getText().strip());
                int rank = this.view.getProblemEditorView().getRank().getValue();
                JButton preGenMap[][] = this.view.getMapEditor().getView().getMap();
                int renderedMap[][] = new int[preGenMap.length][preGenMap[0].length];
                int limitCommand = Integer.parseInt(this.view.getProblemEditorView().getLimitComand().getText());
                String anctionStartOfChar = "waitB";
                int charaterStatrPosition[] = new int[2];

                for (int r = 0; r < preGenMap.length; r++) {
                    for (int c = 0; c < preGenMap[r].length; c++) {
                        int elId = Integer.parseInt(preGenMap[r][c].getToolTipText());;
                        if (elId > ElementId.Cow) {
                            renderedMap[r][c] = 0;
                            charaterStatrPosition[0] = r;
                            charaterStatrPosition[1] = c;
                            if ((elId - 3) == source.Character.actionIdwaitG) {
                                anctionStartOfChar = "waitB";
                            } else if ((elId - 3) == source.Character.actionIdwaitB) {
                                anctionStartOfChar = "waitG";
                            } else if ((elId - 3) == source.Character.actionIdwaitL) {
                                anctionStartOfChar = "waitL";
                            } else if ((elId - 3) == source.Character.actionIdwaitR) {
                                anctionStartOfChar = "waitR";
                            }
                        } else {
                            renderedMap[r][c] = elId;
                        }
                    }
                }

                Problem pb = new Problem(name, desc, rank, renderedMap, charaterStatrPosition,
                        anctionStartOfChar, limitCommand,
                        countMustKeepItem, author);
                if (problemIndex == -1) {
                    LGor.LGorProblemData.add(pb);
                } else {
                    LGor.LGorProblemData.remove(problemIndex);
                    LGor.LGorProblemData.add(problemIndex, pb);
                }

                LGor.save();
                this.view.getFrame().dispose();
            } catch (Exception ex) {
                JLabel lb = new SuComponent().getLabel(ex + "");
                lb.setBackground(Theme.Transparent);
                JOptionPane.showMessageDialog(this.view.getFrame(), lb, "ProblemEdtior", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public CreateProblemView getView() {
        return view;
    }

    public void setView(CreateProblemView view) {
        this.view = view;
    }

    public CreateProblemViewSub1View getSubView1() {
        return subView1;
    }

    public void setSubView1(CreateProblemViewSub1View subView1) {
        this.subView1 = subView1;
    }

    public int getProblemIndex() {
        return problemIndex;
    }

    public void setProblemIndex(int problemIndex) {
        this.problemIndex = problemIndex;
    }

}
