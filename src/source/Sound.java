/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;
import java.io.File;
import javax.sound.sampled.*;
/**
 *
 * @author Enfant
 */
public class Sound {
    private int max=3, s;
    public Sound(){
        s = (int)Math.floor(Math.random() * (max+1));
    }
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
    public String randomFailSound(){
        System.out.println(s);
        if(s == 0){
            return "sound/fail.wav";
        }
        else if(s == 1){
            return "sound/fail1.wav";
        }
        else if(s == 2){
            return "sound/fail2.wav";
        }
        else if(s == 3){
            return "sound/fail3.wav";
        }
        else{
            return "sound not found";
        }
    } 
    public String randomSucessSound(){
         System.out.println(s);
        if(s == 0){
            return "sound/pass.wav";
        }
        else if(s == 1){
            return "sound/pass1.wav";
        }
        else if(s == 2){
            return "sound/pass2.wav";
        }
        else if(s == 3){
            return "sound/pass3.wav";
        }
        else{
            return "sound not found";
        }
    } 
}
