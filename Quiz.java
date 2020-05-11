import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math; 
import java.util.*;
import java.io.File;
import javax.sound.sampled.*;
import java.lang.Exception;
public class Quiz
{
    String radar = "Wrong.mp3";
    AudioInputStream audioStream;
    Clip clip;
    JFrame frame;
    Question q1 = new Question( "How many students were originally in the class?", new String [] {"12" , "9" , "15"}, 0 ); 
    Question q2 = new Question( "What was Nick's favorite part of the class?", new String [] {"working with GUIs", "Scratch", "lessons with Dr. Delin"}, 1);
    Question q3 = new Question( "What is Nathan's go to don't focus in class game?", new String [] {"Minecraft", "Slay the Spire", "Cuphead"}, 1);
    Question q4 = new Question( "What points did the Banana Republic clicker use?", new String [] {"capitalist", "banana bucks", "lives ruined"}, 2);
    Question array [] = {q1,q2,q3,q4};

    JButton nComponent;
    JPanel cComponent;
    JButton sComponent;
    JButton eComponent;
    public Quiz()
    {
        frame = new JFrame();

        try {
            clip = AudioSystem.getClip();    
        } catch (javax.sound.sampled.LineUnavailableException k){}
        try  {
            audioStream = AudioSystem.getAudioInputStream(new File(radar).getAbsoluteFile());
        } catch (javax.sound.sampled.UnsupportedAudioFileException z) {

        } catch(java.io.IOException w) {}
        try {
            clip.open(audioStream);
        } catch(LineUnavailableException e){

        } catch(java.io.IOException x){}
    }
}