import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Question
{
    //instances for the required parameters
    String text;
    String options [];
    String answer;
    ImageIcon icon;
    //constructor which sets the instances equal to the parameter versions of each object type
    public Question(String startText, String [] startOptions, int startAnswer, ImageIcon image ) { //construct a questoin
        answer = startOptions [startAnswer];  
        text = startText;
        options = startOptions;
        icon = image;

    }

    public boolean check(String guess) { //check to see if the answer the user chose matches the parameter 
        if (guess.equals(answer)) {
            return true;
        }
        else {
            return false;
        }
    }
}