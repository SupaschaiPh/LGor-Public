/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import java.io.File;
import javax.sound.sampled.*;
/**
 *
 * @author Lenovo
 */
public class Sound {
    public void playSound(String location){
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
