import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Question
{
    String text;
    String options [];
    String answer;
    public Question(String startText, String [] startOptions, int startAnswer ) { //construct a questoin
        answer = startOptions [startAnswer];  
        text = startText;
        options = startOptions;

    }
}