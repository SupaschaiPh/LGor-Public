/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author supaschai
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;
public class CodeBlockSub1Con implements ActionListener{
    private CodeBlockSub1View view ;
    private CodeBlockView cb;
    private String resitWord[] = AllTitle.resitWord;
    public CodeBlockSub1Con(CodeBlockCon codeBlockCon) {
        this.cb = (CodeBlockView)codeBlockCon.getView();
        view = new CodeBlockSub1View(cb);
        view.getInput().addActionListener(this);
        view.getSubmit().addActionListener(this);
    }

    public CodeBlockSub1View getView() {
        return view;
    }

    public void setView(CodeBlockSub1View view) {
        this.view = view;
    }

    public CodeBlockView getCb() {
        return cb;
    }

    public void setCb(CodeBlockView cb) {
        this.cb = cb;
    }

    public String[] getResitWord() {
        return resitWord;
    }

    public void setResitWord(String[] resitWord) {
        this.resitWord = resitWord;
    }
    
    
    
     @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        System.out.println();
        if (cb.getVarableList().indexOf(view.getInput().getText()) >= 0) {
            view.getWarnningText().setText(AllTitle.title.get("This variable was existed")+"!!");
            view.getSubFrame1().pack();

        } else if (view.getInput().getText().strip().equals("")) {
            view.getWarnningText().setText(AllTitle.title.get("This variable name must not null")+"!!");
            view.getSubFrame1().pack();

        } else if (view.getInput().getText().indexOf(" ") >= 0) {
            view.getWarnningText().setText(AllTitle.title.get("Variable name can not cosits of \" \"")+"!!");
            view.getSubFrame1().pack();
            
        } else {
            for (int i = 0; i < view.getInput().getText().length(); i++) {
                int startChar = view.getInput().getText().charAt(i);
                if (!((startChar >= 65 && startChar <= 90) || (startChar >= 97 && startChar <= 122) || startChar == 95)) {
                    view.getWarnningText().setText(AllTitle.title.get("Variable name must be A-Z , a-z or _ only")+"!!");
                    view.getSubFrame1().pack();
                    return;

                }
            }
            for (int i = 0; i < this.resitWord.length; i++) {
                if (view.getInput().getText().strip().toLowerCase().indexOf(this.resitWord[i]) == 0) {
                    view.getWarnningText().setText(AllTitle.title.get("Variable name can not be or start with")+" {" + this.resitWord[i] + "}!!");
                    view.getSubFrame1().pack();
                    return;
                }

            }
            cb.getVarableList().add(view.getInput().getText());
            view.getInput().setText("");
            view.getSubFrame1().dispose();
        }

    }
    
}
