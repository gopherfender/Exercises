package Tennis;
import java.util.Scanner;

public class Tennis {


    Scanner scanner = new Scanner(System.in);
    Player player1;
    Player player2;
    Match match;
    
    public static void main(String[] args) {
        new Tennis();
    }

    Tennis() {
        CreatePlayers();
        CreateMatch();
        SetScores();
        PrintResults();
    }

    public void CreatePlayers() {
        System.out.println("Please enter name for Player 1");
        String p1Name = scanner.nextLine();
        player1 = new Player(p1Name);
        System.out.println("Please enter name for Player 2");
        String p2Name = scanner.nextLine();
        player2 = new Player(p2Name);
    }

    public void CreateMatch() {
        match = new Match(player1, player2);
    }

    public void SetScores() {
        for (int set = 0; set <= player1.sets.length-1; set++) {
            int game = 0;
            while (player1.sets[set] < 6 && player2.sets[set] < 6) {
                game++;
                System.out.printf("Who won set %d, game %d? ", set+1, game);
                System.out.printf("%s (1), or %s (2)?", player1.name, player2.name);
                int choice = scanner.nextInt();
                if (choice == 1) {
                    player1.sets[set]++;
                } else {
                    player2.sets[set]++;
                }

            }
        }
    }

    public void PrintResults() {

        System.out.println("|Player     |set 1|set 2|set 3|");
        System.out.println("|-----------|-----|-----|-----|");
        System.out.printf("|%-11s|  %d  |  %d  |  %d  |\n", player1.name, player1.sets[0], player1.sets[1], player1.sets[2]);
        System.out.printf("|%-11s|  %d  |  %d  |  %d  |\n", player2.name, player2.sets[0], player2.sets[1], player2.sets[2]);
        System.out.printf("%s wins game, set and match!", match.CheckWinner());
    }
    
}
