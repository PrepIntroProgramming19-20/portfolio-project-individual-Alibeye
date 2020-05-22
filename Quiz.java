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
    String incorrect = "Wrong.wav"; //got a question wrong
    AudioInputStream audioStream;
    Clip clip;

    String lose = "lose.wav"; //got a score of less than six
    AudioInputStream audioStream2;
    Clip clip2;

    String win = "Win.wav"; //got a score greater than six
    AudioInputStream audioStream3;
    Clip clip3;

    JFrame frame;
    JFrame frame2;
    JFrame frame3;
    JFrame frame4;
    JFrame frame5;

    ImageIcon Center = new ImageIcon("Who.jpg");
    ImageIcon Center2 = new ImageIcon("Nick2.jpg");
    ImageIcon Center3 = new ImageIcon("Nathan2.jpg");
    ImageIcon Center4 = new ImageIcon("Republic2.jpg");
    ImageIcon Center5 = new ImageIcon("Neko.jpg");
    ImageIcon Center6 = new ImageIcon("Pretzel.jpg");
    ImageIcon Center7 = new ImageIcon("Who.jpg");
    ImageIcon Center8 = new ImageIcon("Bernardi2.jpg");
    ImageIcon Center9 = new ImageIcon("NoAnime2.jpg");
    ImageIcon Center10 = new ImageIcon("Weezer2.jpg"); //sorry if you like Weezer I just hate them with a burning passion
    ImageIcon Center11 = new ImageIcon("Incorrect.jpg");
    ImageIcon Center12 = new ImageIcon("Failure.jpg");
    ImageIcon Center13 = new ImageIcon("Champion.jpg");

    Question q1 = new Question( "How many students were originally in the class?", new String [] {"12" , "9" , "15" , "18"}, 0 , Center ); 
    Question q2 = new Question( "What was Nick's favorite part of the class?", new String [] {"working with GUIs", "Scratch", "lessons with Dr. Delin", "complaining about art history" }, 1, Center2);
    Question q3 = new Question( "What is Nathan's go to don't focus in class game?", new String [] {"Minecraft", "Slay the Spire", "Cuphead" , "Nathan never played games in class"}, 3 , Center3);
    Question q4 = new Question( "What points did the Banana Republic clicker use?", new String [] {"capitalist cash", "banana bucks", "lives ruined", "socialists arrested"}, 2 , Center4);
    Question q5 = new Question( "What was Alec's Scratch final assignment about? ", new String [] {"choose your own adventure game" , "Dating Michael Cera" , "Rythem pinball" , "Kanye pong"}, 1 , Center5 ); 
    Question q6 = new Question( "How many times has Alec brought pretzels to class?", new String [] {"6", "3", "11", "13" }, 2 , Center6);
    Question q7 = new Question( "Which of the following teachers has sat in on our lectures?", new String [] {"Mr. Fritz", "Mrs. Gi", "Dr. Wahi" , "Dr.Williams"}, 1 , Center7);
    Question q8 = new Question( "Who is this?", new String [] {"Alec front", "Bernie", "Alec back", "I don't know"}, 2, Center8);
    Question q9 = new Question( "Which anime is the poster in the lab from?", new String [] {"Cowboy Beebop" , "Fooly Cooly" , "Trigun" , "Samurai Champloon"}, 0 , Center9); 
    Question q10 = new Question( "What is the worst band ever created", new String [] {"It's Weezer", "Weezer", "See image", "Click Weezer" }, 1, Center10);
    Question array [] = {q1,q2,q3,q4,q5,q6,q7,q8,q9,q10};

    int i= 0;  //instances used throughout the quiz
    int questionsAsked = 0;
    int score = 0;
    int value = 1;    
    Question shown = array[i];

    JButton nComponent; //all the JButton answer options
    JButton sComponent;
    JButton eComponent;
    JButton wComponent;

    JPanel cComponent;  //the center panel which houses the question and an image

    JLabel nComponent2;  //label componenets within other frames or within cComponent
    JLabel cComponent2;
    JLabel cComponent3;
    JLabel cComponent4;
    JLabel cComponent5; 

    JRadioButton goback; //click this if you got an answer wrong

    public Quiz()
    {
        frame = new JFrame();
        frame2 = new JFrame();
        frame3 = new JFrame();
        frame4 = new JFrame();

        nComponent = new JButton(shown.options[0]);
        sComponent = new JButton(shown.options[1]);
        eComponent = new JButton(shown.options[2]);
        wComponent = new JButton(shown.options[3]);
        
        cComponent = new JPanel();
        
        nComponent2 = new JLabel(shown.text); 
        cComponent2 = new JLabel(shown.icon);
        cComponent3 = new JLabel(Center11);
        cComponent4 = new JLabel(Center12);
        cComponent5 = new JLabel(Center13);

        JRadioButton goback = new JRadioButton("try again");
        
        //try catches for all threee sound files
        try {
            clip = AudioSystem.getClip();    
            audioStream = AudioSystem.getAudioInputStream(new File(incorrect).getAbsoluteFile());
            clip.open(audioStream);
        } catch (javax.sound.sampled.LineUnavailableException k){System.out.println("Line unavailable exception");}

        catch (javax.sound.sampled.UnsupportedAudioFileException z) { System.out.println(z.getMessage());} 

        catch(java.io.IOException w) {System.out.println(w.getCause());
            System.out.println(w.getMessage());}

        try {
            clip2 = AudioSystem.getClip();    
            audioStream2 = AudioSystem.getAudioInputStream(new File(lose).getAbsoluteFile());
            clip2.open(audioStream2);
        } catch (javax.sound.sampled.LineUnavailableException w){System.out.println("Line unavailable exception");}

        catch (javax.sound.sampled.UnsupportedAudioFileException e) { System.out.println("Unsupported Audio");} 

        catch(java.io.IOException q) {System.out.println("IOE");}

        try {
            clip3 = AudioSystem.getClip();    
            audioStream3 = AudioSystem.getAudioInputStream(new File(win).getAbsoluteFile());
            clip3.open(audioStream3);
        } catch (javax.sound.sampled.LineUnavailableException o){System.out.println("Line unavailable exception");}

        catch (javax.sound.sampled.UnsupportedAudioFileException p) { System.out.println("Unsupported Audio");} 

        catch(java.io.IOException m) {System.out.println("IOE");}

        //setting border layout
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

        frame3.add(BorderLayout.CENTER, cComponent4);

        frame4.add(BorderLayout.CENTER, cComponent5);

        nComponent.addActionListener(this); //implementing actionListener and setting frame sizes and visibility
        sComponent.addActionListener(this);
        eComponent.addActionListener(this);
        wComponent.addActionListener(this);
        goback.addActionListener(new rewind()); 
        frame.setSize(800,800);
        frame.setVisible(true);
        frame2.setVisible(false);
        frame2.setSize(800,800);
        frame3.setVisible(false);
        frame3.setSize(800,800);
        frame4.setVisible(false);
        frame4.setSize(800,800);
    }

    public void nextQuestion() { //resets the frame with content from a new instance of array[i] which just increased by 1
        i++;
        shown = array[i]; 
        update();
        cComponent.repaint();
        frame.revalidate();
        frame.repaint();
    }

    public void update() { //sets the components of the frame to display the content previously mentioned in nextQuestion()
        nComponent.setText(shown.options[0]);
        sComponent.setText(shown.options[1]);
        eComponent.setText(shown.options[2]);
        wComponent.setText(shown.options[3]);
        nComponent2.setText(shown.text); 
        cComponent2.setIcon(shown.icon);
    }

    @Override
    public void actionPerformed(ActionEvent event) {  //simplifyed action listener which works for all four answer choices
        String guess = event.getActionCommand();
        if (shown.check(guess)) { //if you are correct
            score = score + value;
            System.out.println(score);
            questionsAsked++;
            value = 1;
            if (questionsAsked < 10) { //if you still have questions remaining
                nextQuestion();   
            }else 
            if (questionsAsked == 10) { //once you are done with the quiz
                finale();
            }
        }
        else { //if you get a question wrong
            value = 0;
            clip.setFramePosition(0);
            clip.start();
            frame.setVisible(false);
            frame2.setVisible(true);           
        } 
    }

    public void finale() { //the end of the quiz which shows how you did
        if (score<= 6)  { // if you failed
            clip2.setFramePosition(0);
            clip2.start();
            frame.setVisible(false);
            frame2.setVisible(false);
            frame3.setVisible(true);

        }
        else  { //if you passed
            clip3.setFramePosition(0);
            clip3.start();
            frame.setVisible(false);
            frame2.setVisible(false);
            frame3.setVisible(false);
            frame4.setVisible(true);

        } 
    }

    public static void main(String [] args) { //main method
        Quiz q1 = new Quiz();    
    }

    class rewind implements ActionListener { //action listener for the "try again" button 
        public void actionPerformed(ActionEvent event) {
            frame.setVisible(true);
            frame2.setVisible(false);
        }
    }
}
