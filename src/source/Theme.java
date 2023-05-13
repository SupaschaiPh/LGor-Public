/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

/**
 *
 * @author supaschai Theme By Bozzi Supaschai Ph.
 *
 */
import java.awt.*;
import java.io.FileInputStream;
import javax.swing.*;
import javax.swing.border.*;

public class Theme {
    
    public static Color BG = new Color(255, 255, 255),
            FG = new Color(0, 0, 0),
            Primary = new Color(243, 244, 246),//(243 244 246)
            Success = new Color(240, 253, 244),
            Danger = new Color(254, 226, 226),
            Warning = new Color(254, 252, 232),
            WarningBorder = new Color(254, 249, 195),
            Info = new Color(236, 254, 255),
            InfoBorder = new Color(224, 242, 254),
            Transparent = new Color(255, 255, 255, 0),
            BorderC = new Color(229, 231, 235),//new Color(107, 114, 128),
            GridC = new Color(243, 244, 246);//Color(229, 231, 235);//new Color(75, 85, 99);//new Color(243, 244 ,246);

    public static Color Easy = new Color(134, 239, 172),
            Med = new Color(252, 211, 77),
            Hard = new Color(252, 165, 165); //red 300

    public static Color Passed = new Color(22, 163, 74),
            NotPassed = new Color(220, 38, 38);
    
    //Font Size
    
    public static String appName = "Lกอ";
    
    public static int Heading = 21,
            SubHeading = 18,
            Normal = 16;
    public static int roundedPx = 6;
    public static LineBorder Border = new LineBorder(Theme.BorderC, 1, true);
    public static LineBorder GridBorder = new LineBorder(Theme.GridC, 1, true);
    ;
    public static RoundedBorder RoundedBorder = new RoundedBorder(Theme.BorderC, Theme.roundedPx);

    //public static RoundedBorder RoundedBorder = new RoundedBorder(50,50);
    public static EmptyBorder EEmptyBorder = new EmptyBorder(5, 5, 5, 5);

    public static FileInputStream fontFile, iconFile;

    private Font font;
    
    public static ImageIcon appIcon = new ImageIcon("image/logo.png"),
            startIcon =  new ImageIcon("image/icon/image1x3.png"),
            notPassedIcon =  new ImageIcon("image/icon/image3x3.png"),
            favIcon = new ImageIcon("image/favIcon.png");

    public Font setAndGetFont() {
        return this.setAndGetFont(Theme.Normal);
    }

    public Font setAndGetFont(int size) {
        try ( FileInputStream fontFile = new FileInputStream("font/Anuphan/Anuphan-VariableFont_wght.ttf")) {
            this.font = Font.createFont(Font.PLAIN, fontFile).deriveFont(0, size);
        } catch (Exception e) {
            this.font = new Font("Tahoma", 0, size);
            System.out.println(e);
        } finally {
            return font;
        }
    }

    public Font setAndGetIcon() {
        return this.setAndGetIcon(Theme.Normal);
    }

    public Font setAndGetIcon(int size) {
        /**
         *
         * **https://www.1001fonts.com/pizzadude-pointers-font.html**
         *
         */
        try ( FileInputStream fontFile = new FileInputStream("font/Icon/pizzadude-pointers.regular.ttf")) {
            this.font = Font.createFont(Font.PLAIN, fontFile).deriveFont(0, size);
        } catch (Exception e) {
            this.font = new Font("Tahoma", 0, size);
            System.out.println(e);
        } finally {
            return font;
        }
    }

    public static void lightMode() {
        BG = new Color(255, 255, 255);
        FG = new Color(0, 0, 0);
        Success = new Color(0, 0, 0);
        Danger = new Color(185, 28, 27);
        Warning = new Color(251, 191, 36);
        Info = new Color(224, 242, 254);
    }

}
