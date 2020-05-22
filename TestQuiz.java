import java.util.*;
public class TestQuiz  
{
    int score = 0;
    ArrayList<oldQuestion> Quizerino1 = new ArrayList<oldQuestion>();
    ArrayList<oldQuestion> Quizerino2= new ArrayList<oldQuestion>();
    public void ArrayListFiller() {
        oldQuestion Q1 = new oldQuestion();
        Q1.setText("Who was the first supreme court chief Justice?");
        Q1.setAnswer("John Jay");
        oldQuestion Q2 = new oldQuestion();
        Q2.setText("Fred Korematsu's argument about internment was...?");
        Q2.setAnswer("dismissed");
        oldQuestion Q3 = new oldQuestion();
        Q3.setText("Which Justice created the precident for judicial review?");
        Q3.setAnswer("John Marshal");
        oldQuestion Q4 = new oldQuestion();
        Q4.setText("What organization was Clarence Brandenburg a member of?");
        Q4.setAnswer("the KKK");   
        oldQuestion Q5 = new oldQuestion();
        Q5.setText("Who is the Chief Justice of the Supreme Court?");
        Q5.setAnswer("John Roberts");
        Quizerino1.add(Q1);
        Quizerino1.add(Q2);
        Quizerino1.add(Q3);
        Quizerino1.add(Q4);   
        Quizerino1.add(Q5);
    }

    public void ArrayListFiller2() {
        oldQuestion Q6 = new oldQuestion();
        Q6.setText("Anti-war pamphlets and protests were deemed constitutional during Schenck vs. United States (True or False)");
        Q6.setAnswer("False");
        oldQuestion Q7 = new oldQuestion();
        Q7.setText("There are nine justices sitting on the Supreme Court right now (True or False)");
        Q7.setAnswer("True");
        oldQuestion Q8 = new oldQuestion();
        Q8.setText("Ruth Bader Ginsburg is the most recent addition to the court (True or False)");
        Q8.setAnswer("False");
        oldQuestion Q9= new oldQuestion();
        Q9.setText("Brett Kavanaugh deserves to be on the Supreme Court (False or False)");
        Q9.setAnswer("False");
        oldQuestion Q10 = new oldQuestion();
        Q10.setText("The Supreme Court is planning to take over the world in a coup (True or False)");
        Q10.setAnswer("True");
        Quizerino2.add(Q6);
        Quizerino2.add(Q7);
        Quizerino2.add(Q8);
        Quizerino2.add(Q9);
        Quizerino2.add(Q10);
    }

    public void Testerino() {
        Scanner keybeeInput= new Scanner(System.in);
        for (int i=0; i<Quizerino1.size(); i++) {
            Quizerino1.get(i).display();
            String userGuess= keybeeInput.nextLine();

            if (userGuess.equalsIgnoreCase(Quizerino1.get(i).answer)) {
                score++;  
            }
        }
        System.out.println("You got " + score + " out of five on the short responce");
    }

    public void Testerino2() {
        int score2 =0;
        Scanner keybeeInput2= new Scanner(System.in);
        for (int b=0; b<Quizerino2.size(); b++) {
            Quizerino2.get(b).display();
            String userGuess2=keybeeInput2.nextLine();

            if (userGuess2.equalsIgnoreCase(Quizerino2.get(b).answer)) {
                score2++;
            }
        }
        //while( !userGuess2.equalsIgnoreCase("True")&&!userGuess2.equalsIgnoreCase("False")) {
        //    System.out.println("Please choose between true and false");
        //   userGuess2 = keybeeInput2.nextLine();

        //}
        System.out.println("you got " + score2 + " out of 5 on the true or false section");  
    }

    public static void main (String []args) {
        TestQuiz T1= new TestQuiz();
        T1.ArrayListFiller();
        T1.ArrayListFiller2();
        T1.Testerino();
        T1.Testerino2();
        System.out.println("Your final score was....... Carry the two.....add the seven......take the reimans sum.........Aha! YOU FIGURE IT OUT IF YOURE SO SMART"); 
    }

}