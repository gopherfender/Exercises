import java.util.Random;
import java.util.Scanner;

public class RoShamBo {

    public String[] choices = {"rock", "paper", "scissors"};
    public int playerscore = 0;
    public int compscore = 0;
    
    RoShamBo() {
        NewRound();
    }

    public void NewRound() {
        String player = PlayerChoice();
        String comp = CompChoice();
        CheckResult(player, comp);
        NewRound();
    }

    public static void main(String[] args) {
        new RoShamBo();
        

    }

    

    public String CompChoice() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(choices.length);
        return choices[randomNumber];
    }

    public String PlayerChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Make Your Choice!");
        System.out.println("1 for Rock\n2 for Paper\n3 for Scissors");       
        while(!scanner.hasNextInt()) {
            System.out.println("Invalid Choice, pick again");
            System.out.println("Make Your Choice!");
            System.out.println("1 for Rock\n2 for Paper\n3 for Scissors");
            scanner.next();
        }
        int choice = scanner.nextInt();
        while (choice <1 || choice >3) {
            System.out.println("Invalid Choice, pick again");
            System.out.println("Make Your Choice!");
            System.out.println("1 for Rock\n2 for Paper\n3 for Scissors");
            choice = scanner.nextInt();
        }
        //scanner.close();
        return choices[choice-1];
        
    }

    public void CheckResult(String player, String comp) {
        if (player.equals("rock")) {
            if (comp.equals("rock")) {
                System.out.println("Draw!\n");
            } else if (comp.equals("paper")) {
                System.out.println("Paper beats Rock! You Lose!");
                compscore +=1;
                System.out.printf("Player: %d, Java: %d\n", playerscore, compscore);
            } else {
                System.out.println("Rock beats Scissors! You Win!");
                playerscore +=1;
                System.out.printf("Player: %d, Java: %d\n", playerscore, compscore);
            }
        } else if (player.equals("paper")) {
            if (comp.equals("paper")) {
                System.out.println("Draw!\n");
            } else if (comp.equals("scissors")) {
                System.out.println("Scissors beats Paper! You Lose!");
                compscore +=1;
                System.out.printf("Player: %d, Java: %d\n", playerscore, compscore);
            } else {
                System.out.println("Paper beats Rock! You Win!");
                playerscore +=1;
                System.out.printf("Player: %d, Java: %d\n", playerscore, compscore);
            }

        } else {
            if (comp.equals("scissors")) {
                System.out.println("Draw!\n");
            } else if (comp.equals("rock")) {
                System.out.println("Rock beats Scissors! You Lose!");
                compscore +=1;
                System.out.printf("Player: %d, Java: %d\n", playerscore, compscore);
            } else {
                System.out.println("Scissors beats Paper! You Win!");
                playerscore +=1;
                System.out.printf("Player: %d, Java: %d\n", playerscore, compscore);
            }
        }
    
    }
}
