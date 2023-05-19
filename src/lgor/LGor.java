/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lgor;

/**
 *
 * @author supaschai
 */
import java.util.ArrayList;
import javax.swing.UIManager;
import model.*;
import java.io.*;
import control.*;

public class LGor {

    public static ArrayList<Problem> LGorProblemData;
    public static User user;
    public static String curPath = "";
    private TitleCon titleCon;

    public LGor() {
        this.open();
        titleCon = new TitleCon();
    }

    public static void open(){
        try ( FileInputStream f = new FileInputStream("data/user.lgor");  ObjectInputStream oin = new ObjectInputStream(f)) {
            user = (User) oin.readObject();
            //System.out.println(user.getPassedList());

        } catch (Exception e) {
            user = new User();
            System.out.println(e);
        }
        try ( FileInputStream f = new FileInputStream("data/map.lgor");  ObjectInputStream oin = new ObjectInputStream(f)) {
            LGorProblemData = (ArrayList) oin.readObject();
            //System.out.println(LGorProblemData);
        } catch (Exception e) {
            LGorProblemData = new ArrayList();
            System.out.println(e);
        }

    }
    
    public static void save(){
        File ff = new File("data");
        ff.mkdir();
        try ( FileOutputStream f = new FileOutputStream("data/user.lgor");  ObjectOutputStream o = new ObjectOutputStream(f)) {
            o.writeObject(LGor.user);
            o.flush();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        try ( FileOutputStream f = new FileOutputStream("data/map.lgor");  ObjectOutputStream o = new ObjectOutputStream(f)) {
            o.writeObject(LGor.LGorProblemData);
            o.flush();
        } catch (Exception ex) {
            System.out.println(ex);

        }
    }

    public static ArrayList<Problem> getLGorProblemData() {
        return LGorProblemData;
    }

    public static void setLGorProblemData(ArrayList<Problem> LGorProblemData) {
        LGor.LGorProblemData = LGorProblemData;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        LGor.user = user;
    }

    public TitleCon getTitleCon() {
        return titleCon;
    }

    public void setTitleCon(TitleCon titleCon) {
        this.titleCon = titleCon;
    }
    
   

    public static void main(String[] args) {
        try {
            //"javax.swing.plaf.synth.SynthLookAndFeel" โล้งไป
            //javax.swing.plaf.multi.MultiLookAndFeel //err
            //"javax.swing.plaf.metal.MetalLookAndFeel" win vis
            //"javax.swing.plaf.nimbus.NimbusLookAndFeel" ยังกะwinamp
            //javax.swing.plaf.basic.BasicLookAndFeel //ไม่เปลี่ยน
            //com.sun.java.swing.plaf.motif.MotifLookAndFeel //หิน
            /**
             * 
             * Name      = Metal
                ClassName = javax.swing.plaf.metal.MetalLookAndFeel
                Name      = Nimbus
                ClassName = javax.swing.plaf.nimbus.NimbusLookAndFeel
                Name      = CDE/Motif
                ClassName = com.sun.java.swing.plaf.motif.MotifLookAndFeel
                Name      = Mac OS X
                ClassName = com.apple.laf.AquaLookAndFeel
                * 
                * 
                * 
             */
            //UIManager.setLookAndFeel("javax.swing.plaf.multi.MultiLookAndFeel");
       
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        new LGor();
    }

}
