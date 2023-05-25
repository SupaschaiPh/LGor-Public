/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.LinkedList;

/**
 *
 * @author supaschai
 */
public abstract class SyntaxChecking {

    protected String CheckingErrorRes = "No Error";
    protected boolean Err = false;

    protected void checkingSyntax(LinkedList commandlist) {
        //check for - end for , if - end if, else - end else
        //check set var before used?
        LinkedList StackFor = new LinkedList();
        LinkedList StackIf = new LinkedList();
        LinkedList StackElse = new LinkedList();
        LinkedList varList = new LinkedList();
        Object commandlistArray[] = commandlist.toArray();
        for (int i = 0; i < commandlistArray.length; i++) {
            String curCommand = (String) commandlistArray[i];
            if (curCommand.startsWith("if")) {
                StackIf.add(1);
            } else if (curCommand.equals("end if")) {
                if (StackIf.isEmpty()) {
                    Err = true;
                    CheckingErrorRes = "Do not have if before end if";
                    return;
                }
                StackIf.pop();
            }
            if (curCommand.startsWith("else")) {
                if(i>1 && !commandlistArray[i-1].equals("end if")){
                    CheckingErrorRes = "Do not have if before else";
                    Err = true;
                    return;
                }
                StackElse.add(1);
            } else if (curCommand.equals("end else")) {
                if (StackElse.isEmpty()) {
                    CheckingErrorRes = "Do not have else before end else";
                    Err = true;
                    return;
                }
                StackElse.pop();
            }
            if (curCommand.startsWith("for")) {
                StackFor.add(1);
            } else if (curCommand.equals("end for")) {
                if (StackFor.isEmpty()) {
                    Err = true;
                    CheckingErrorRes = "Do not have for before end for";
                    return;
                }
                StackFor.pop();
            }
            
            if(curCommand.indexOf("->")!=-1){
                if(curCommand.split("->")[1].strip().equals("null")){
                    Err = true;
                    CheckingErrorRes = "If / For must have condition";
                    return;
                }
            }
            
            if (curCommand.startsWith("set")) {
                varList.add(curCommand.replace("set ", "").split("to")[0].strip());
            } else if (curCommand.indexOf("->") == -1 && (curCommand.indexOf("=") != -1
                    || curCommand.indexOf("<") != -1 || curCommand.indexOf(">") != -1)) {
                
                String varName = curCommand.replace("<", "");
                String splitKey = "";
                varName = varName.replace("==", "=");
                varName = varName.replace("-", "");
                varName = varName.replace("+", "");
                varName = varName.replace("if->", "");
                varName = varName.replace("for->", "");

                System.out.println(varName);
                
                if(curCommand.indexOf("<") != -1){
                    splitKey +="<";
                }else if(curCommand.indexOf(">") != -1){
                    splitKey +=">";
                }
                if(curCommand.indexOf("=") != -1){
                    splitKey +="=";
                }
                
                varName = varName.split(splitKey)[0];
                varName = varName.strip();
                 
                if (varList.indexOf(varName) == -1) {
                    Err = true;
                    CheckingErrorRes = "Undefine variable name";
                    return;
                }
            }
        }
        if (!StackFor.isEmpty()) {
            Err = true;
            CheckingErrorRes = "For must have end for";
            return;
        } else if (!StackIf.isEmpty()) {
            Err = true;
            CheckingErrorRes = "If must have end if";
            return;
        } else if (!StackElse.isEmpty()) {
            Err = true;
            CheckingErrorRes = "Else must have end else";
            return;
        }
    }
}
