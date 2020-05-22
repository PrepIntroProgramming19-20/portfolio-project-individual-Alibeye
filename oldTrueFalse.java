import java.util.*;
public class oldTrueFalse extends oldQuestion
{
    public oldTrueFalse(String t, String a) {   
        super(t,a);
    }

    
    public void printQuestion(){
        System.out.println("(True or False)" + text );  
    }

    
    public void getInput()
    {
        Scanner keybee = new Scanner(System.in);
        String userinput=keybee.nextLine();
        while( userinput.equalsIgnoreCase("true")&&userinput.equalsIgnoreCase("false")) {
            System.out.println("Please capitalize");
            userinput = keybee.nextLine();

        }
        while( !userinput.equalsIgnoreCase("true")&&!userinput.equalsIgnoreCase("false")) {
            System.out.println("Please choose between true and false");
            userinput = keybee.nextLine();

        }
        keybee.close();
    }
}