import java.util.*;
public class oldTestQuestion extends oldQuestion
{
    public static void main(String[] args) {
        oldQuestion qui = new oldQuestion();
        qui.setText("Hello");
        qui.setAnswer("Hi");
        qui.display();
        Scanner keybeeInput= new Scanner(System.in);
        String userGuess= keybeeInput.nextLine();
        qui.checkAnswer(userGuess); 
    }
}
