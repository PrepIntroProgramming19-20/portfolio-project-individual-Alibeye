import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math; 
import java.util.*;
import java.io.File;
import javax.sound.sampled.*;
import java.lang.Exception;
public class Quiz implements ActionListener 
{
    String incorrect = "Wrong.mp3";
    AudioInputStream audioStream;
    Clip clip;

    String lose = "lose.mp3";
    AudioInputStream audioStream2;
    Clip clip2;

    JFrame frame;
    JFrame frame2;
    JFrame frame3;
    JFrame frame4;

    ImageIcon Center = new ImageIcon("test.jpg");
    ImageIcon Center2 = new ImageIcon("Worm.jpg");
    ImageIcon Center3 = new ImageIcon("Yeti.jpg");
    ImageIcon Center4 = new ImageIcon("Yeti.jpg");
    ImageIcon Center5 = new ImageIcon("Yeti.jpg");
    ImageIcon Center6 = new ImageIcon("Yeti.jpg");
    ImageIcon Center7 = new ImageIcon("Yeti.jpg");
    ImageIcon Center8 = new ImageIcon("Yeti.jpg");
    ImageIcon Center9 = new ImageIcon("Yeti.jpg");
    ImageIcon Center10 = new ImageIcon("Yeti.jpg");

    Question q1 = new Question( "How many students were originally in the class?", new String [] {"12" , "9" , "15" , "18"}, 0 , Center ); 
    Question q2 = new Question( "What was Nick's favorite part of the class?", new String [] {"working with GUIs", "Scratch", "lessons with Dr. Delin", "complaining about art history" }, 1, Center2);
    Question q3 = new Question( "What is Nathan's go to don't focus in class game?", new String [] {"Minecraft", "Slay the Spire", "Cuphead" , "Nathan never played games in class"}, 3 , Center3);
    Question q4 = new Question( "What points did the Banana Republic clicker use?", new String [] {"capitalist cash", "banana bucks", "lives ruined", "socialists arrested"}, 2 , Center4);
    Question q5 = new Question( "What was Alec's Scratch final assignment about? ", new String [] {"choose your own adventure game" , "Dating Michael Cera" , "Ryhtem pinball" , "Kanye pong"}, 1 , Center5 ); 
    Question q6 = new Question( "How many times has Alec brought pretzels to class?", new String [] {"6", "3", "11", "13" }, 2 , Center6);
    Question q7 = new Question( "Which of the following teachers has sat in on our lectures?", new String [] {"Mr. Fritz", "Mrs. Gi", "Dr. Wahi" , "Dr.Williams"}, 1 , Center7);
    Question q8 = new Question( "Who is this?", new String [] {"Alec front", "Bernie", "Alec back", "I've never seen this person in my life"}, 2, Center8);
    Question q9 = new Question( "Which anime is the poster in the lab from?", new String [] {"Cowboy Beebop" , "Fooly Cooly" , "Trigun" , "Samurai Champloon"}, 0 , Center9); 
    Question q10 = new Question( "What was the first algorithm our class worked on", new String [] {"How to get ready in the morning", "How to make a sandwhich", "How to do your homework", "How to commit tax fraud" }, 1, Center10);
    Question array [] = {q1,q2,q3,q4,q5,q6,q7,q8,q9,q10};

    int i= 0;  
    int questionsAsked = 0;
    int score = 0;
    int value = 1;    
    Question shown = array[i];

    JButton nComponent;
    JButton sComponent;
    JButton eComponent;
    JButton wComponent;
    JPanel cComponent;
    JLabel nComponent2;
    JLabel cComponent2;


    JRadioButton goback;
    JLabel cComponent3;

    JLabel cComponent4;

    public Quiz()
    {
        frame = new JFrame();
        frame2 = new JFrame();

        nComponent = new JButton(shown.options[0]);
        sComponent = new JButton(shown.options[1]);
        eComponent = new JButton(shown.options[2]);
        wComponent = new JButton(shown.options[3]);
        cComponent = new JPanel();

        JLabel nComponent2 = new JLabel(shown.text);
        JRadioButton goback = new JRadioButton("try again");
        cComponent2 = new JLabel(Center);

        cComponent3 = new JLabel(Center2);
        cComponent4 = new JLabel();

        try {
            clip = AudioSystem.getClip();    
            audioStream = AudioSystem.getAudioInputStream(new File(incorrect).getAbsoluteFile());
            clip.open(audioStream);
        } catch (javax.sound.sampled.LineUnavailableException k){System.out.println("Line unavailable exception");}

        catch (javax.sound.sampled.UnsupportedAudioFileException z) { System.out.println("Unsupported Audio");} 

        catch(java.io.IOException w) {System.out.println("IOE");}

        try {
            clip2 = AudioSystem.getClip();    
            audioStream2 = AudioSystem.getAudioInputStream(new File(incorrect).getAbsoluteFile());
            clip2.open(audioStream2);
        } catch (javax.sound.sampled.LineUnavailableException k){System.out.println("Line unavailable exception");}

        catch (javax.sound.sampled.UnsupportedAudioFileException z) { System.out.println("Unsupported Audio");} 

        catch(java.io.IOException w) {System.out.println("IOE");}

        frame.setLayout(new BorderLayout());
        cComponent.setLayout(new BorderLayout());
        frame.add(BorderLayout.NORTH, nComponent);
        frame.add(BorderLayout.SOUTH, sComponent);
        frame.add(BorderLayout.EAST, eComponent);
        frame.add(BorderLayout.WEST, wComponent);
        frame.add(BorderLayout.CENTER, cComponent);
        cComponent.add(BorderLayout.NORTH, nComponent2);
        cComponent.add(BorderLayout.CENTER, cComponent2);

        frame2.add(BorderLayout.SOUTH, goback);
        frame2.add(BorderLayout.CENTER,cComponent3);

        nComponent.addActionListener(this);
        sComponent.addActionListener(this);
        eComponent.addActionListener(this);
        wComponent.addActionListener(this);
        goback.addActionListener(new rewind());
        frame.setSize(650,650);
        frame.setVisible(true);
        frame2.setVisible(false);
        frame2.setSize(650,650);
    }

    public void nextQuestion() {
        i++;
        shown = array[i]; 
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String guess = event.getActionCommand();
        if (shown.check(guess)) {
            score = score + value;
            System.out.println(score);
            questionsAsked++;
            value = 1;
            if (questionsAsked<10){
                nextQuestion();
            }
            else {
                finale();
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

    public void finale() {
        if (score<= 6)  {
            frame.setVisible(false);
            frame2.setVisible(false);
            frame3.setVisible(true);
            clip2.setFramePosition(0);
            clip2.start();
        }
        else {
            frame.setVisible(false);
            frame2.setVisible(false);
            frame3.setVisible(false);
            frame4.setVisible(true);
        }
    }

    public static void main(String [] args) {
        Quiz q1 = new Quiz();    
    }

    class rewind implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            frame.setVisible(true);
            frame2.setVisible(false);
        }
    }
}
