/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.*;
import javax.swing.*;
import source.*;

/**
 *
 * @author supaschai
 */
public class MapView implements BeAbleWorkInMDI {
    private JPanel container = new JPanel();//new SuComponent().getPanel();
    //girdTableCt = new  SuComponent().getPanel() ;
    private static Dimension dimensionperGridBox = new Dimension(40, 40);
    private Dimension dimension;
    private int charaterPosition[] = {0, 0};
    //private String charaterAction;
    private int map[][];
    private Dimension maximumDimension = new Dimension(500, 500);
    private source.Character character = new source.Character(this);
    private JPanel girdTableCt = new JPanel(),
            statusPanel = new SuComponent().getPanel();
    private JLabel countItem = new SuComponent().getLabel(AllTitle.title.get("CountItem") + " : 0", 11),
            aliveLable = new SuComponent().getLabel(AllTitle.title.get("Alive") + " : " + AllTitle.title.get("Alivetrue"), 11);
    public MapView(int[][] map, int[] charaterPosition, String charAction) {
        Thread tChar = new Thread(character);
        tChar.start();
        this.map = null;
        this.map = map;
        this.charaterPosition = charaterPosition;
        this.character.setOpaque(true);
        container.setLayout(new BorderLayout());
        statusPanel.add(new Item());
        statusPanel.add(countItem);
        statusPanel.add(new source.Character());
        statusPanel.add(aliveLable);
        character.setAction(charAction);

        renderMap(charaterPosition);
        //int size = (map.length*map[0].length)*dimensionperGridBox.height;
        this.dimension = new Dimension(map[0].length * dimensionperGridBox.width, map.length * dimensionperGridBox.height + 50);
    }
    public synchronized void renderMap(int[] charaterPosition) {
        this.charaterPosition = charaterPosition;
        //if(this.girdTableCt!=null)
        this.container.removeAll();
        this.girdTableCt.removeAll();
        this.girdTableCt.setOpaque(true);
        //JPanel girdTableCt = new JPanel();
        girdTableCt.setLayout(new GridLayout(this.map.length, this.map[0].length));
        
        for (int row = 0; row < this.map.length; row++) {
            for (int col = 0; col < this.map[row].length; col++) {
                JPanel jp = new Grass();
                JPanel topJp = jp;
                jp.setBorder(Theme.Border);
                if (this.charaterPosition[0] == row && this.charaterPosition[1] == col) {
                    topJp.add(character);
                }
                if (this.map[row][col] == ElementId.Barrier) {
                    JPanel b = new Barrier();
                    topJp.add(b);
                    topJp = b;

                } else if (this.map[row][col] == ElementId.Item) {
                    JPanel item = new Item();
                    topJp.add(item);
                    topJp = item;
                } else if (this.map[row][col] == ElementId.Cow) {
                    Cow c = new Cow();
                    Thread t = new Thread(c);
                    topJp.add(c);
                    t.start();
                }
                girdTableCt.add(jp);
            }
            container.add(new SuComponent().getBorderPanel(girdTableCt));
            container.add(statusPanel, BorderLayout.NORTH);
        }
    }
    public void changeCountItem() {
        countItem.setText(AllTitle.title.get("CountItem") + " : " + this.character.getCountItem());
    }

    public void changealiveLable() {
        aliveLable.setText(AllTitle.title.get("Alive") + " : " + AllTitle.title.get("Alive"+this.character.isAlive()));
    }

    @Override
    public JPanel getContainer() {
        return this.container;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public static Dimension getDimensionperGridBox() {
        return dimensionperGridBox;
    }

    public static void setDimensionperGridBox(Dimension dimensionperGridBox) {
        MapView.dimensionperGridBox = dimensionperGridBox;
    }

    public int[] getCharaterPosition() {
        return charaterPosition;
    }

    public void setCharaterPosition(int[] charaterPosition) {
        this.charaterPosition = charaterPosition;
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public void setMapAt(int row, int col, int val) {
        this.map[row][col] = val;
    }

    public Dimension getMaximumDimension() {
        return maximumDimension;
    }

    public void setMaximumDimension(Dimension maximumDimension) {
        this.maximumDimension = maximumDimension;
    }

    public source.Character getCharacter() {
        return character;
    }

    public void setCharacter(source.Character character) {
        this.character = character;
    }

    public JPanel getGirdTableCt() {
        return girdTableCt;
    }

    public void setGirdTableCt(JPanel girdTableCt) {
        this.girdTableCt = girdTableCt;
    }

    public JPanel getStatusPanel() {
        return statusPanel;
    }

    public void setStatusPanel(JPanel statusPanel) {
        this.statusPanel = statusPanel;
    }

    public JLabel getCountItem() {
        return countItem;
    }

    public void setCountItem(JLabel countItem) {
        this.countItem = countItem;
    }

    public JLabel getAliveLable() {
        return aliveLable;
    }

    public void setAliveLable(JLabel aliveLable) {
        this.aliveLable = aliveLable;
    }
}
