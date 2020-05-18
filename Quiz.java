import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math; 
import java.util.*;
import java.io.File;
import javax.sound.sampled.*;
import java.lang.Exception;
public class Quiz extends JPanel implements ActionListener 
{
    String radar = "Wrong.mp3";
    AudioInputStream audioStream;
    Clip clip;
    JFrame frame;
    JFrame frame2;

    Question q1 = new Question( "How many students were originally in the class?", new String [] {"12" , "9" , "15" , "18"}, 0 ); 
    Question q2 = new Question( "What was Nick's favorite part of the class?", new String [] {"working with GUIs", "Scratch", "lessons with Dr. Delin", "complaining about art history" }, 1);
    Question q3 = new Question( "What is Nathan's go to don't focus in class game?", new String [] {"Minecraft", "Slay the Spire", "Cuphead" , "Nathan never played games in class"}, 3);
    Question q4 = new Question( "What points did the Banana Republic clicker use?", new String [] {"capitalist cash", "banana bucks", "lives ruined", "socialists arrested"}, 2);
    Question q5 = new Question( "What was Alec's Scratch final assignment about? ", new String [] {"choose your own adventure game" , "Dating Michael Cera" , "Ryhtem pinball" , "Kanye pong"}, 1 ); 
    Question q6 = new Question( "How many times has Alec brought pretzels to class?", new String [] {"6", "3", "11", "13" }, 2);
    Question q7 = new Question( "Which of the following teachers has sat in on our lectures?", new String [] {"Mr. Fritz", "Mrs. Gi", "Dr. Wahi" , "Dr.Williams"}, 1);
    Question q8 = new Question( "What points did the Banana Republic clicker use?", new String [] {"capitalist cash", "banana bucks", "lives ruined", "socialists arrested"}, 2);
    Question q9 = new Question( "How many students were originally in the class?", new String [] {"12" , "9" , "15" , "18"}, 0 ); 
    Question q10 = new Question( "What was Nick's favorite part of the class?", new String [] {"working with GUIs", "Scratch", "lessons with Dr. Delin", "complaining about art history" }, 1);
    Question array [] = {q1,q2,q3,q4,q5,q6,q7,q8,q9,q10};

    int i= 0;  
    int questionsAsked = 0;
    int score = 0;
    int value = 1;    
    Question shown = array[i];

    JButton nComponent;
    JPanel cComponent;
    JButton sComponent;
    JButton eComponent;
    JLabel nComponent2;
    JPanel cComponent2;
    public Quiz()
    {
        frame = new JFrame();
        frame2 = new JFrame();
        JButton nComponent = new JButton(shown.options[0]);
        JButton sComponent = new JButton(shown.options[1]);
        JButton eComponent = new JButton(shown.options[2]);
        JButton wComponent = new JButton(shown.options[3]);
        JPanel cComponent = new JPanel();
        JLabel nComponent2 = new JLabel(shown.text);
        //JPanel cComponent2 = new JPanel(//some dumb image); //
        /*try {
        clip = AudioSystem.getClip();    
        } catch (javax.sound.sampled.LineUnavailableException k){}
        try  {
        audioStream = AudioSystem.getAudioInputStream(new File(radar).getAbsoluteFile());
        } catch (javax.sound.sampled.UnsupportedAudioFileException z) {

        } catch(java.io.IOException w) {}
        try {
        clip.open(audioStream);
        } catch(LineUnavailableException e){

        } catch(java.io.IOException x){} */
        frame.setLayout(new BorderLayout());
        cComponent.setLayout(new BorderLayout());
        frame.add(BorderLayout.NORTH, nComponent);
        frame.add(BorderLayout.SOUTH, sComponent);
        frame.add(BorderLayout.EAST, eComponent);
        frame.add(BorderLayout.WEST, wComponent);
        //frame2.add()//
        cComponent.add(BorderLayout.NORTH, nComponent2);
        //cComponent.add(BorderLayout.CENTER, cComponent2);
        nComponent.addActionListener(this);
        sComponent.addActionListener(new choiceB());
        eComponent.addActionListener(new choiceC());
        wComponent.addActionListener(new choiceD());
        frame.setSize(1000,1000);
        frame.setVisible(true);
        frame2.setVisible(false);
    }

    public void nextQuestion() {
        i++;
        shown = array[i];     
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String guess =event.getActionCommand();
        if (shown.check(guess)) {
            score = score + value;
            questionsAsked++;
            value = 1;
            if (questionsAsked<10){
                nextQuestion();
            }
        }
        else {
            value = 0;
            frame.setVisible(false);
            frame2.setVisible(true);
            clip.setFramePosition(0);
            clip.start();
        } 
    }

    class choiceC implements ActionListener{   //action listener
        @Override
        public void actionPerformed(ActionEvent event) {
            String guess = shown.options [2] ;

            if (shown.check(guess)) {
                score = score + value;
                questionsAsked++;
                value = 1;
                if (questionsAsked<10){
                    nextQuestion();
                }
            }
            else {
                value = 0;
                frame.setVisible(false);
                frame2.setVisible(true);
                clip.setFramePosition(0);
                clip.start();
            }
        }
    }

    class choiceB implements ActionListener{   //action listener
        public void actionPerformed(ActionEvent event) {
            String guess = shown.options [1] ;
            if (shown.check(guess)) {
                score = score + value;
                questionsAsked++;
                value = 1;
                if (questionsAsked<10){
                    nextQuestion();
                }
            }
            else {
                value = 0;
                frame.setVisible(false);
                frame2.setVisible(true);
                clip.setFramePosition(0);
                clip.start();
            }
        }
    }

    class choiceD implements ActionListener{   //action listener
        public void actionPerformed(ActionEvent event) {
            String guess = shown.options [3];
            if (shown.check(guess)) {
                score = score + value;
                questionsAsked++;
                value = 1;
                if (questionsAsked<10){
                    nextQuestion();
                }
            }
            else {
                value = 0;
                frame.setVisible(false);
                frame2.setVisible(true);
                clip.setFramePosition(0);
                clip.start();
            }
        }
    }
}