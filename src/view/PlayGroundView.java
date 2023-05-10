/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import control.CodeBlockCon;
import java.awt.*;
import javax.swing.*;
import model.Problem;
import source.*;

/**
 *
 * @author supaschai
 */
public class PlayGroundView {

    private JFrame frame = new JFrame();
    private JDesktopPane mdiConatainer;
    private JInternalFrame intFrame1, intFrame2, intFrame3;
    private JMenuBar menuBar = new SuComponent().getMenuBar();
    private JMenu menu1 = new SuComponent().getMenu("|"),
            menu2 = new SuComponent().getMenu(">Restart");
    
        private JMenuItem menuItem1 = new SuComponent().getMenuItem(">Run"),
            menuItem2 = new SuComponent().getMenuItem(">Restart");

    private int charaterPosition[];
    private int stackCodeSize;
    private String charaterAction;
    private CodeBlockCon cb;
    private MapView mapV ;
    private ProblemView problemView;
    private int topsep = 10;

    public PlayGroundView(Problem pb) {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.stackCodeSize = pb.getStackCodeSize();
        this.charaterAction = pb.getAnctionStartOfChar(); 
        JPanel tem = new JPanel();

        mdiConatainer = new JDesktopPane();
        intFrame1 = new JInternalFrame("Code Block", true, false, true, true);
        intFrame2 = new JInternalFrame("Map", true, false, true, true);
        intFrame3 = new JInternalFrame("Problem", true, false, true, true);

        menuBar.add(menuItem1);
        menuBar.add(menuItem2);
        menuBar.add(menu1);

        frame.setJMenuBar(menuBar);
        
        frame.setIconImage(Theme.appIcon.getImage());
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.cb = new CodeBlockCon(this.stackCodeSize);
        intFrame1.add(cb.getView().getContainer());
        intFrame1.setMinimumSize(CodeBlockView.getDimension());
        intFrame1.setSize(CodeBlockView.getDimension());
        intFrame1.setJMenuBar(cb.getView().getMenuBar());
        intFrame1.setVisible(true);

        this.mapV = new MapView(pb.getMap(), pb.getCharaterStatrPosition(), charaterAction);
        intFrame2.add(mapV.getContainer());
        intFrame2.pack();
        intFrame2.setVisible(true);
        intFrame2.setSize(mapV.getDimension());
        
        if(intFrame2.getSize().height>600){
                int divv = (int) Math.ceil(Double.parseDouble("" + intFrame2.getSize().width) / 600);
            intFrame2.setSize(intFrame1.getSize().width / divv, intFrame2.getSize().height / divv);
        }

        this.problemView = new ProblemView(pb);
        intFrame3.add(problemView.getContainer());
        intFrame3.pack();
        intFrame3.setVisible(true);
        intFrame3.setSize(intFrame1.getSize().width, intFrame3.getSize().height);

        mdiConatainer.add(intFrame1);
        mdiConatainer.add(intFrame2);
        mdiConatainer.add(intFrame3);

        int xCenter = (1920-(intFrame1.getSize().width+intFrame2.getSize().width))/4;
        
        intFrame2.setLocation(xCenter, topsep);
        intFrame1.setLocation(intFrame2.getLocation().x+intFrame2.getSize().width, intFrame3.getSize().height+topsep);
        intFrame3.setLocation(intFrame2.getLocation().x+intFrame2.getSize().width, topsep);
        this.cb.setperfecLocationForSubV(intFrame1.getLocation().x, intFrame1.getLocation().y);

        mdiConatainer.setVisible(true);
        frame.add(new Grass());

        mdiConatainer.setBackground(Theme.Success);

        frame.add(mdiConatainer);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JDesktopPane getMdiConatainer() {
        return mdiConatainer;
    }

    public void setMdiConatainer(JDesktopPane mdiConatainer) {
        this.mdiConatainer = mdiConatainer;
    }

    public JInternalFrame getIntFrame1() {
        return intFrame1;
    }

    public void setIntFrame1(JInternalFrame intFrame1) {
        this.intFrame1 = intFrame1;
    }

    public JInternalFrame getIntFrame2() {
        return intFrame2;
    }

    public void setIntFrame2(JInternalFrame intFrame2) {
        this.intFrame2 = intFrame2;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public JMenu getMenu1() {
        return menu1;
    }

    public void setMenu1(JMenu menu1) {
        this.menu1 = menu1;
    }

    public JMenu getMenu2() {
        return menu2;
    }

    public void setMenu2(JMenu menu2) {
        this.menu2 = menu2;
    }


    public int[] getCharaterPosition() {
        return charaterPosition;
    }

    public void setCharaterPosition(int[] charaterPosition) {
        this.charaterPosition = charaterPosition;
    }

    public int getStackCodeSize() {
        return stackCodeSize;
    }

    public void setStackCodeSize(int stackCodeSize) {
        this.stackCodeSize = stackCodeSize;
    }

    public String getCharaterAction() {
        return charaterAction;
    }

    public void setCharaterAction(String charaterAction) {
        this.charaterAction = charaterAction;
    }

    public CodeBlockCon getCb() {
        return cb;
    }

    public void setCb(CodeBlockCon cb) {
        this.cb = cb;
    }

    public MapView getMapV() {
        return mapV;
    }

    public void setMapV(MapView mapV) {
        this.mapV = mapV;
    }

    public JMenuItem getMenuItem1() {
        return menuItem1;
    }

    public void setMenuItem1(JMenuItem menuItem1) {
        this.menuItem1 = menuItem1;
    }

    public JMenuItem getMenuItem2() {
        return menuItem2;
    }

    public void setMenuItem2(JMenuItem menuItem2) {
        this.menuItem2 = menuItem2;
    }

}
