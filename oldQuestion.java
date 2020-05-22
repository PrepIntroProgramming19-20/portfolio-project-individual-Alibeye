import java.util.*;
public class oldQuestion
{
    String text;
    String answer;
    public oldQuestion() {
        text = "";
        answer = "";
    }

    public void setText(String prompt) {
        text=prompt;    
    }

    public void setAnswer(String solution) {
        answer=solution;
    }

    public oldQuestion(String t, String a ) {   
        text = t;
        answer =a;
    }

    public boolean checkAnswer(String userGuess) {
        /*if (userGuess.equalsIgnoreCase(answer)) {
        return true;
        }
        else {
        return false;    
        }*/
        return userGuess.equalsIgnoreCase(answer);
    }

    public void display() {
        System.out.println(text); 
    }
}
