/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

/**
 *
 * @author supaschai Component.
 *
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.*;
import view.AllTitle;

public class SuComponent {

    private JDesktopPane MDI = new JDesktopPane();
    private JInternalFrame internalFrame = new JInternalFrame();
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private JButton button = new JButton();
    private JTextField input = new JTextField();
    private JTextArea textArea = new JTextArea();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu();
    private JMenuItem menuItem = new JMenuItem();
    private JScrollPane scrollPane = new JScrollPane();
    private JTable table = new JTable();
    private JSlider slider = new JSlider();

    public String trans(String str){
        if(AllTitle.title.get(str)!=null){
            str = AllTitle.title.get(str);
        }
        return str;
    }
    
    public JDesktopPane getMDI() {
        MDI.setBackground(Theme.BG);
        MDI.setForeground(Theme.FG);
        return MDI;
    }

    public JInternalFrame getInternalFrame() {
        return this.getInternalFrame("");
    }

    public JInternalFrame getInternalFrame(String title) {
        
        internalFrame.setTitle(this.trans(title));
        internalFrame.setClosable(false);
        internalFrame.setResizable(true);
        internalFrame.setIconifiable(true);
        internalFrame.setMaximizable(true);
        internalFrame.setBackground(Theme.BG);
        internalFrame.setForeground(Theme.FG);
        return internalFrame;
    }

    public JFrame getFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Theme.BG);
        frame.setForeground(Theme.FG);
        return frame;
    }

    public JPanel getBorderPanel(Object obj) {
        panel.setBackground(Theme.BG);
        panel.setForeground(Theme.FG);
        panel.setOpaque(true);
        panel.setBorder(Theme.EEmptyBorder);
        panel.setLayout(new BorderLayout());
        panel.add((Component) obj);
        return panel;
    }
    
    public JPanel getBorderPanel(Object obj,int margin) {
        panel.setBackground(Theme.BG);
        panel.setForeground(Theme.FG);
        panel.setOpaque(true);
        panel.setBorder(Theme.EEmptyBorder);
        panel.setLayout(new BorderLayout());
        panel.add((Component) obj);
        panel.setBorder(new EmptyBorder(margin,margin,margin,margin));
        return panel;
    }

    public JPanel getBorderPanel(int margin) {
        panel.setBackground(Theme.BG);
        panel.setForeground(Theme.FG);
        panel.setOpaque(true);
        panel.setBorder(Theme.EEmptyBorder);
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(margin,margin,margin,margin));
        return panel;
    }

    public JPanel getBorderPanel() {
        panel.setBackground(Theme.BG);
        panel.setForeground(Theme.FG);
        panel.setOpaque(true);
        panel.setLayout(new BorderLayout());
        return panel;
    }

    public JPanel getPanel() {
        panel.setBackground(Theme.BG);
        panel.setForeground(Theme.FG);
        panel.setOpaque(true);
        panel.setAutoscrolls(true);
        return panel;
    }

    public JPanel getPanel(Object obj) {
        panel.setBackground(Theme.BG);
        panel.setForeground(Theme.FG);
        panel.setOpaque(true);
        panel.setAutoscrolls(true);
        panel.add((Component) obj);
        return panel;
    }

    public JLabel getLabel() {
        return this.getLabel(Theme.Normal);
    }

    public JLabel getLabel(String text) {
        JLabel lb = this.getLabel(Theme.Normal);
        lb.setText(text);
        return lb;
    }

    public JLabel getLabel(String text, int fontsize) {
        label.setFont(new Theme().setAndGetFont(fontsize));
        label.setBackground(Theme.BG);
        label.setForeground(Theme.FG);
        label.setVerticalAlignment(JLabel.TOP);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setOpaque(true);
        label.setText(this.trans(text));
        return label;
    }

    public JLabel getLabel(int fontsize) {
        this.getLabel("", fontsize);
        return label;
    }

    public JButton getButton() {
        return this.getButton(Theme.Normal, "");
    }

    public JButton getButton(String text) {
        return this.getButton(Theme.Normal, text);
    }

    public JButton getButton(int fontsize, String text) {
        button.setFont(new Theme().setAndGetFont(fontsize));
        button.setText(this.trans(text));
        button.setBackground(Theme.Primary);
        button.setForeground(Theme.FG);
        button.setBorder(Theme.RoundedBorder);
        button.setContentAreaFilled(false);
        button.setBorderPainted(true);
        button.setOpaque(true);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.repaint();
        return button;
    }

    public JButton getArrowButton() {
        return this.getArrowButton(Theme.Normal);
    }

    public JButton getArrowButton(int fontsize) {
        return this.getArrowButton(fontsize, "");
    }

    public JButton getArrowButton(int fontsize, String text) {
        JButton arrowBt = new SuComponent().getButton();
        arrowBt.setText(text);
        arrowBt.setFont(new Theme().setAndGetIcon(fontsize));
        return arrowBt;
    }

    public JTable getTable(int fontsize) {
        table.setFont(new Theme().setAndGetFont(fontsize));
        table.setBackground(Theme.BG);
        table.setForeground(Theme.FG);
        table.setShowGrid(true);
        table.setBorder(Theme.GridBorder);
        table.setGridColor(Theme.GridC);
        table.setRowHeight(fontsize + 5);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setOpaque(true);
        return table;
    }

    public JTable getTable() {
        return this.getTable(Theme.Normal);
    }

    public JTable getTable(Object data[][], Object heading[], int fontsize) {
        this.table = new JTable(data, heading);
        table.setFont(new Theme().setAndGetFont(fontsize));
        table.setBackground(Theme.BG);
        table.setForeground(Theme.FG);
        table.setShowGrid(true);
        table.setBorder(Theme.GridBorder);
        table.setGridColor(Theme.GridC);
        //table.setAlignmentX(JTable.CENTER_ALIGNMENT);
        table.setRowHeight(fontsize + 5);
        table.setOpaque(true);
        table.setEnabled(false);

        return table;
    }

    public JTable getTable(Object data[][], Object heading[]) {
        return this.getTable(data, heading, Theme.Normal);
    }

    public JMenuBar getMenuBar() {
        menuBar.setFont(new Theme().setAndGetFont());
        menuBar.setBackground(Theme.BG);
        menuBar.setForeground(Theme.FG);
        menuBar.setBorder(Theme.Border);
        menuBar.setAlignmentX(JMenuBar.LEFT_ALIGNMENT);
        return menuBar;
    }

    public JMenu getMenu() {
        return this.getMenu("");
    }

    public JMenu getMenu(String text) {
        menu.setText(text);
        menu.setFont(new Theme().setAndGetFont(12));
        menu.setBackground(Theme.BG);
        menu.setForeground(Theme.FG);
        menu.setSize(10, 10);

        return menu;
    }

    public JMenuItem getMenuItem() {
        return menuItem;
    }

    public JMenuItem getMenuItem(String text) {
        menuItem.setText(text);
        menuItem.setFont(new Theme().setAndGetFont(12));
        menuItem.setBackground(Theme.BG);
        menuItem.setForeground(Theme.FG);

        return menuItem;
    }

    public JTextField getInput() {
        return this.getInput(Theme.Normal);
    }

    public JTextField getInput(int fontsize) {
        input.setFont(new Theme().setAndGetFont(fontsize));
        input.setBackground(Theme.Primary);
        input.setForeground(Theme.FG);
        input.setBorder(Theme.RoundedBorder);
        return input;
    }

    public JTextField getInput(int cols, int fontsize) {
        input = new JTextField(cols);
        if (fontsize == -1) {
            return this.getInput(Theme.Normal);
        }
        return this.getInput(fontsize);

    }

    public JTextArea getTextArea() {
        this.getTextArea(0, 0, Theme.Normal);
        return textArea;
    }

    public JTextArea getTextArea(int row, int col, int fontsize) {
        textArea = new JTextArea(row, col);
        textArea.setFont(new Theme().setAndGetFont(fontsize));
        textArea.setBackground(Theme.Primary);
        textArea.setForeground(Theme.FG);
        textArea.setBorder(Theme.RoundedBorder);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        return textArea;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JSlider getSlider(int minimum, int maximum, int step, int fontsize, String label[]) {
        Hashtable labelTable = new Hashtable();
        if (label != null) {
            for (int i = minimum; i < label.length; i++) {
                JLabel lb = new SuComponent().getLabel(label[i]);
                lb.setBackground(Theme.Transparent);
                if (AllTitle.title.get(label[i]) != null) {
                    lb.setText(AllTitle.title.get(label[i]));
                }
                labelTable.put(i, lb);

            }
            slider.setLabelTable(labelTable);
        }
        slider.setMaximum(maximum);
        slider.setMinimum(minimum);
        slider.setExtent(step);
        slider.setFont(new Theme().setAndGetFont(fontsize));
        slider.setBackground(Theme.BG);
        slider.setForeground(Theme.FG);
        slider.setOpaque(true);
        slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        return slider;
    }

    public void setSlider(JSlider slider) {
        this.slider = slider;
    }

    public JScrollPane getScrollPane(Component view) {
        scrollPane = new JScrollPane(view);
        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        return scrollPane;
    }

    public JLabel renderBadgeRank(int rank) {
        JLabel jl = new SuComponent().getLabel(8);
        String text = "  ";
        if (rank < 0) {
            text += AllTitle.title.get("Easy") + rank;
            jl.setBackground(Theme.Easy);
            jl.setBorder(new RoundedBorder(Theme.Easy, 1));
        } else if (rank == 0) {
            text += AllTitle.title.get("Easy");
            jl.setBackground(Theme.Easy);
            jl.setBorder(new RoundedBorder(Theme.Easy, 1));
        } else if (rank == 1) {
            text += AllTitle.title.get("Med");
            jl.setBackground(Theme.Med);
            jl.setBorder(new RoundedBorder(Theme.Med, 1));
        } else if (rank == 2) {
            text += AllTitle.title.get("Hard");
            jl.setBackground(Theme.Hard);
            jl.setBorder(new RoundedBorder(Theme.Hard, 1));
        } else {
            text += AllTitle.title.get("Hard") + (rank - 2);
            jl.setBackground(Theme.Hard);
            jl.setBorder(new RoundedBorder(Theme.Hard, 1));
        }
        jl.setText(text + "  ");
        return jl;
    }

}
