/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author supaschai
 */
import control.PlayGroundCon;
import java.util.*;
import javax.swing.*;
import source.*;
import view.*;
import java.io.File;
import javax.sound.sampled.*;

public class Compiler extends SyntaxChecking implements Runnable {

    private int map[][];
    private LinkedList<String> commandList = new LinkedList();
    private HashMap<String, String> variable = new HashMap();
    private PlayGroundCon playGroundCon;
    private int[] charPosition;
    private source.Character charr;
    private int limitCompileCode = 10000;
    private int countCompileCode = 0;
    
    

    public Compiler() {

    }

    public Compiler(PlayGroundCon playGroundCon) {
        this.playGroundCon = playGroundCon;
        this.map = this.playGroundCon.getView().getMapV().getMap();
        this.charPosition = this.playGroundCon.getView().getMapV().getCharaterPosition();
        this.charr = this.playGroundCon.getView().getMapV().getCharacter();
    }

    private void setTo(String name, String value) {
        this.variable.put(name.strip(), value.strip());
    }

    private boolean checkCondition(String command) {
        boolean result = false;
        if (countCompileCode >= limitCompileCode) {
            return false;
        }
        String action = this.charr.getAction();
        if (command.equals("meetBarrier")) {

            if (action.equals("waitG") && map[charPosition[0] - 1][charPosition[1]] == ElementId.Barrier) {
                return true;
            } else if (action.equals("waitB") && map[charPosition[0] + 1][charPosition[1]] == ElementId.Barrier) {
                return true;
            } else if (action.equals("waitL") && map[charPosition[0]][charPosition[1] - 1] == ElementId.Barrier) {
                return true;
            } else if (action.equals("waitR") && map[charPosition[0]][charPosition[1] + 1] == ElementId.Barrier) {
                return true;
            }
        } else if (command.equals("meetItem") && map[charPosition[0]][charPosition[1]] == ElementId.Item) {
            return true;

        } else if (command.indexOf("<=") != -1) {
            String hold[] = command.split("<=");
            result = Integer.parseInt(variable.get(hold[0])) <= Integer.parseInt(hold[1]);

        } else if (command.indexOf("<") != -1) {
            String hold[] = command.split("<");
            result = Integer.parseInt(variable.get(hold[0])) < Integer.parseInt(hold[1]);

        } else if (command.indexOf(">=") != -1) {
            String hold[] = command.split(">=");
            result = Integer.parseInt(variable.get(hold[0])) >= Integer.parseInt(hold[1]);

        } else if (command.indexOf(">") != -1) {
            String hold[] = command.split(">");
            result = Integer.parseInt(variable.get(hold[0])) > Integer.parseInt(hold[1]);

        } else if (command.indexOf("==") != -1) {
            String hold[] = command.split("==");
            result = Integer.parseInt(variable.get(hold[0])) == Integer.parseInt(hold[1]);

        }
        return result;

    }

    public void delay() {
        try {
            while (this.charr.isStillWalking()) {
                Thread.sleep(1);
            }
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

    public synchronized void delay(int mills) {
        try {
            Thread.sleep(200);

        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

    public synchronized void setCharrAction(String cAction, boolean alive) {
        this.charr.walk(cAction + "2");
        delay();
        if (map[charPosition[0]][charPosition[1]] == ElementId.Item) {
            this.charr.setMeetItem(true);
        } else {
            this.charr.setMeetItem(false);
        }
        this.charr.setAlive(alive);
        this.playGroundCon.getView().getMapV().renderMap(charPosition);
        this.playGroundCon.getView().getMapV().getContainer().revalidate();
        this.charr.walk(cAction);
        delay();
        this.playGroundCon.getView().getMapV().changealiveLable();

    }

    public void setCharrAction(String cAction) {
        this.charr.repaint();
        this.setCharrAction(cAction, true);

    }

    public void compile(LinkedList<String> commandList) {
        this.compile(commandList, 0);
    }

    public synchronized void compile(LinkedList<String> commandList, int pointer) {
        try {
            if(!this.playGroundCon.isRun()){
                throw new Exception("Running Stoped");
            }
            if (this.Err) {
                throw new Exception(this.CheckingErrorRes);
            }
            this.charr.setMeetCow(false);
            if (this.countCompileCode >= this.limitCompileCode + 1) {
                throw new Exception("Compiler Over Limit");
            }
            LinkedList<String> qFor = new LinkedList(),
                    qIf = new LinkedList(),
                    qElse = new LinkedList();
            String conditionOfFor = "",
                    conditionOfIf = "";
            int countFor = 0,
                    countIf = 0,
                    countElse = 0;
            System.out.println("Compile List : " + commandList);
            if (commandList.isEmpty()) {
                return;
            }
            Object commandArray[] = commandList.toArray();

            for (int i = 0; i < commandArray.length; i++) {
                if (this.countCompileCode < this.limitCompileCode) {
                    this.countCompileCode += 1;
                }

                if (this.playGroundCon.getView() != null) {
                    this.playGroundCon.getView().getCb().movePointerTo(pointer);
                }
                if (this.playGroundCon != null && this.playGroundCon.getView() != null
                        && !this.charr.isAlive()) {
                    return;
                }
                pointer += 1;
                String runningCommand = ((String) commandArray[i]);
                System.out.println("Running At " + pointer + " : " + runningCommand);
                if (countFor >= 1 || countIf >= 1 || countElse >= 1) {
                    //pass
                } else if (runningCommand.indexOf("set") == 0) {
                    runningCommand = runningCommand.replace("set", "").strip();
                    this.setTo(runningCommand.split(" to ")[0], runningCommand.split(" to ")[1]);
                } else if (runningCommand.indexOf("+=") != -1) {
                    runningCommand = runningCommand.replace("+=", " to ").strip();
                    this.setTo(runningCommand.split(" to ")[0],
                            "" + (Integer.parseInt(this.variable.get(runningCommand.split(" to ")[0]))
                            + Integer.parseInt(runningCommand.split(" to ")[1])));
                } else if (runningCommand.indexOf("-=") != -1) {
                    runningCommand = runningCommand.replace("-=", " to ").strip();
                    this.setTo(runningCommand.split(" to ")[0],
                            "" + (Integer.parseInt(this.variable.get(runningCommand.split(" to ")[0]))
                            - Integer.parseInt(runningCommand.split(" to ")[1])));
                } else if (runningCommand.equals(AllTitle.commandList[0])) {
                    if (charPosition[0] - 1 >= 0 && map[charPosition[0] - 1][charPosition[1]] != ElementId.Barrier) {
                        charPosition[0] -= 1;
                        this.setCharrAction(runningCommand.replace("()", ""));
                        delay();
                    } else if (charPosition[0] - 1 < 0) {
                        this.charr.die();
                        return;
                    } else {
                        charPosition[0] -= 1;
                        this.setCharrAction(runningCommand.replace("()", ""), false);
                        this.charr.die();
                        return;
                    }
                } else if (runningCommand.equals(AllTitle.commandList[1])) {
                    if (charPosition[0] + 1 < map.length && map[charPosition[0] + 1][charPosition[1]] != ElementId.Barrier) {
                        charPosition[0] += 1;
                        this.setCharrAction(runningCommand.replace("()", ""));
                    } else if (charPosition[0] + 1 >= map.length) {
                        this.charr.die();
                        return;
                    } else {
                        charPosition[0] += 1;
                        this.setCharrAction(runningCommand.replace("()", ""), false);

                        this.charr.die();
                        return;
                    }

                } else if (runningCommand.equals(AllTitle.commandList[3])) {
                    if (charPosition[1] + 1 < map[0].length && map[charPosition[0]][charPosition[1] + 1] != ElementId.Barrier) {
                        charPosition[1] += 1;
                        this.setCharrAction(runningCommand.replace("()", ""));
                    } else if (charPosition[1] + 1 >= map[0].length) {
                        this.charr.die();
                        return;
                    } else {
                        charPosition[1] += 1;
                        this.setCharrAction(runningCommand.replace("()", ""), false);
                        this.charr.die();
                        return;
                    }
                } else if (runningCommand.equals(AllTitle.commandList[2])) {
                    if (charPosition[1] - 1 >= 0 && map[charPosition[0]][charPosition[1] - 1] != ElementId.Barrier) {
                        charPosition[1] -= 1;
                        this.setCharrAction(runningCommand.replace("()", ""));
                    } else if (charPosition[1] - 1 < 0) {
                        this.charr.die();
                        return;
                    } else {
                        charPosition[1] -= 1;
                        this.setCharrAction(runningCommand.replace("()", ""), false);
                        this.charr.die();
                        return;
                    }

                } else if (runningCommand.equals(AllTitle.commandList[10])) {
                    this.charr.keep();

                }

                if (countFor >= 1) {
                } else if (runningCommand.indexOf("if") == 0) {
                    countIf += 1;
                } else if (runningCommand.equals("end if")) {
                    countIf -= 1;
                }

                if (countIf > 1 || (countIf == 1 && !(runningCommand.indexOf("if") == 0))) {
                    qIf.add(runningCommand);
                } else if (countIf == 1 && (runningCommand.indexOf("if") == 0)) {
                    conditionOfIf = runningCommand.split("->")[1].strip();
                } else if (runningCommand.equals("end else")) {
                    countElse -= 1;
                } else if (countElse >= 1 && !runningCommand.equals("else")) {
                    qElse.add(runningCommand);
                }
                if (countIf == 0 && !qIf.isEmpty() && runningCommand.equals("end if")) {
                    if (commandArray.length > i + 1 && commandArray[i + 1].equals("else")) {
                        countElse += 1;
                    } else if (checkCondition(conditionOfIf)) {
                        compile(qIf, pointer - qIf.size() - 1);
                        qIf.clear();
                    } else {
                        qIf.clear();

                    }
                } else if (countElse == 0 && !qIf.isEmpty() && !qElse.isEmpty() && runningCommand.equals("end else")) {
                    if (checkCondition(conditionOfIf)) {
                        //System.out.println("Yes if");
                        compile(qIf, pointer - qIf.size() - qElse.size() - 3);
                        qIf.clear();
                        qElse.clear();
                    } else {
                        //System.out.println("Yes else");
                        compile(qElse, pointer - qElse.size() - 1);
                        qIf.clear();
                        qElse.clear();
                    }
                }

                if (countIf >= 1) {
                } else if (runningCommand.indexOf("for") == 0) {
                    countFor += 1;
                } else if (runningCommand.equals("end for")) {
                    countFor -= 1;
                }
                if (countFor > 1 || (countFor == 1 && !(runningCommand.indexOf("for") == 0))) {
                    qFor.add(runningCommand);
                } else if (countFor == 1 && (runningCommand.indexOf("for") == 0)) {
                    conditionOfFor = runningCommand.split("->")[1].strip();
                }
                if (countFor == 0 && !qFor.isEmpty() && runningCommand.equals("end for")) {
                    while (true) {
                        if (checkCondition(conditionOfFor)) {
                            compile(qFor, pointer - qFor.size() - 1);
                            if (this.playGroundCon != null && this.playGroundCon.getView() != null
                                    && !this.charr.isAlive()) {
                                return;
                            }
                        } else {
                            qFor.clear();
                            break;
                        }
                    }
                }
            }
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
    
    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public LinkedList<String> getCommandList() {
        return commandList;
    }

    public void setCommandList(LinkedList<String> commandList) {
        this.commandList = commandList;
    }

    public HashMap<String, String> getVariable() {
        return variable;
    }

    public void setVariable(HashMap<String, String> variable) {
        this.variable = variable;
    }

    public PlayGroundCon getPlayGroundCon() {
        return playGroundCon;
    }

    public void setPlayGroundCon(PlayGroundCon playGroundCon) {
        this.playGroundCon = playGroundCon;
    }

    public int[] getCharPosition() {
        return charPosition;
    }

    public void setCharPosition(int[] charPosition) {
        this.charPosition = charPosition;
    }

    public source.Character getCharr() {
        return charr;
    }

    public void setCharr(source.Character charr) {
        this.charr = charr;
    }

    public int getLimitCompileCode() {
        return limitCompileCode;
    }

    public void setLimitCompileCode(int limitCompileCode) {
        this.limitCompileCode = limitCompileCode;
    }

    public int getCountCompileCode() {
        return countCompileCode;
    }

    public void setCountCompileCode(int countCompileCode) {
        this.countCompileCode = countCompileCode;
    }


    @Override
    public void run() {
        System.out.println("Compiling....");
        this.playGroundCon.getView().getIntFrame1().setEnabled(false);
        this.checkingSyntax(this.commandList);
        compile(this.commandList);
        delay(200);
        this.playGroundCon.getView().getIntFrame1().setEnabled(true);
        this.charr.meetCow();
        System.out.println(this.charr.isMeetCow() + " < meetCow");
        JLabel lb = new SuComponent().getLabel();
        lb.setBackground(Theme.Transparent);
        int iii = 1;
        if (this.Err) {
            lb.setText("Error : " + this.CheckingErrorRes + AllTitle.title.get("Want to restart?"));
            this.charr.setMeetCow(false);
            iii = JOptionPane.showConfirmDialog(this.playGroundCon.getView().getFrame(), lb, "Compiler", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
        } else if (!this.charr.isAlive()) {
            String filepath = "sound/fail1.wav";
            playSound(filepath);
            this.charr.die();
            this.charr.setMeetCow(false);
            lb.setText(AllTitle.title.get("You Die")+ "!!, "+AllTitle.title.get("Want to restart?"));
            iii = JOptionPane.showConfirmDialog(this.playGroundCon.getView().getFrame(), lb, "Compiler", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, Theme.notPassedIcon);
            
            
        } else if (!this.charr.isMeetCow()) {
            String filepath = "sound/fail1.wav"; 
            playSound(filepath);
            lb.setText(AllTitle.title.get("Don't Met Cow")+ ", "+AllTitle.title.get("Want to restart?"));
            iii = JOptionPane.showConfirmDialog(this.playGroundCon.getView().getFrame(), lb, "Compiler", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, Theme.notPassedIcon);

        } else if (this.playGroundCon.getPb().getCountMustKeepItem() > this.charr.getCountItem()) {
            String filepath = "sound/fail1.wav";
            playSound(filepath);
            lb.setText(AllTitle.title.get("Item not equal request, You got") + this.charr.getCountItem() + "/" + this.playGroundCon.getPb().getCountMustKeepItem() + ", "+AllTitle.title.get("Want to restart?"));
            iii = JOptionPane.showConfirmDialog(this.playGroundCon.getView().getFrame(), lb, "Compiler", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, Theme.notPassedIcon);

        } else if (this.charr.isMeetCow()) {
            String filepath = "sound/pass4.wav";
            playSound(filepath);
            lb.setText(AllTitle.title.get("Met Cow, You passed"));
            JOptionPane.showMessageDialog(this.playGroundCon.getView().getFrame(), lb, "Compiler", JOptionPane.PLAIN_MESSAGE, Theme.startIcon);
        }

        if (iii == 0) {
            this.playGroundCon.reset();
        } else {
            this.playGroundCon.finished(this.charr.isMeetCow(),this.charr.getCountItem());
            //System.exit(0);
        }
        //this.playGroundCon.getView().getMapV().getContainer().repaint();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public static void playSound(String location){
        try{
            File musicPath = new File(location);
            if(musicPath.exists()){
                AudioInputStream ai = AudioSystem.getAudioInputStream(musicPath);
                Clip c = AudioSystem.getClip();
                c.open(ai);
                c.start();
            }
            else{
                System.out.println("Can't found soundfile");
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

}
