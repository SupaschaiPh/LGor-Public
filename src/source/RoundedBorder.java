/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.*;

public class RoundedBorder extends LineBorder {

    private int offs;
    public RoundedBorder(Color color) {
       this(color, Theme.roundedPx);

    }
    
    public RoundedBorder(Color color, int offs) {
        this(color, 1, offs);
        
    }

    public RoundedBorder(Color color, int thickness, int offs) {
        super(color, thickness, true);
        this.offs = offs;
    }

    public void paintBorder(java.awt.Component c, Graphics g, int x, int y, int width, int height) {
        if ((this.thickness > 0) && (g instanceof Graphics2D)) {
            Graphics2D g2d = (Graphics2D) g;

            Color oldColor = g2d.getColor();
            g2d.setColor(this.lineColor);

            Shape outer;
            Shape inner;

            int size = this.thickness + this.thickness;

            outer = new RoundRectangle2D.Float(x, y, width, height, offs, offs);
            inner = new RoundRectangle2D.Float(x + this.thickness, y + this.thickness, width - size, height - size, offs, offs);

            Shape outer2 = new Rectangle2D.Float(x, y, width, height),
                    inner2 = new RoundRectangle2D.Float(x + this.thickness , y + this.thickness , width - size , height - size , 0, 0);

            Path2D path = new Path2D.Float(Path2D.WIND_EVEN_ODD);
            path.append(outer, false);
            path.append(inner, false);

            Path2D path2 = new Path2D.Float(Path2D.WIND_EVEN_ODD);
            path2.append(outer2, false);
            path2.append(inner2, false);

            g2d.setColor(Theme.BG);

            g2d.fill(path2);

            //g2d.drawRect(0, 0, width+20, height+20);
            g2d.setColor(this.getLineColor());
            //g2d.drawRoundRect(x, y, width, height, offs, offs);
            g2d.fill(path);

            //g2d.fill(path2);
        }

    }

}
