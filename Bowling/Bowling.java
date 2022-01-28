package Bowling;

import java.util.Scanner;

public class Bowling {

    Bowler player1;
    Bowler player2;
    Bowler currentPlayer;
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Bowling();
    }

    Bowling() {
        CreatePlayers();
        InputScores();
    }

    public void CreatePlayers() {
        String name;
        System.out.println("Enter name for Bowler 1");
        name = scanner.nextLine();
        player1 = new Bowler(name);
        System.out.println("Enter name for Bowler 2");
        name = scanner.nextLine();
        player2 = new Bowler(name);

    }

    public void InputScores() {
        int ball1 = 0;
        int ball2 = 0;
        int ball3 = 0;
        for (int i = 0; i < 9; i++) {
            System.out.printf("Enter frame %d, ball 1 score for %s\n", i + 1, player1.name);
            ball1 = scanner.nextInt();
            if (ball1 == 10) {
                player1.frames.add(new Frame(ball1, 0));
                System.out.println("Strike!");
            } else {
                System.out.printf("Enter frame %d, ball 2 score for %s\n", i + 1, player1.name);
                ball2 = scanner.nextInt();
                player1.frames.add(new Frame(ball1, ball2));
                if (ball1 + ball2 == 10) {
                    System.out.println("Spare!");
                }
            }
            System.out.printf("Enter frame %d, ball 1 score for %s\n", i + 1, player2.name);
            ball1 = scanner.nextInt();
            if (ball1 == 10) {
                player2.frames.add(new Frame(ball1, 0));
                System.out.println("Strike!");
            } else {
                System.out.printf("Enter frame %d, ball 2 score for %s\n", i + 1, player2.name);
                ball2 = scanner.nextInt();
                player2.frames.add(new Frame(ball1, ball2));
                if (ball1 + ball2 == 10) {
                    System.out.println("Spare!");
                }
            }
            System.out.println("Current Score:");
            System.out.printf("%s: %d\n", player1.name, player1.CurrentScore());
            System.out.printf("%s: %d\n", player2.name, player2.CurrentScore());
        }
        System.out.printf("Enter frame 10, ball 1 score for %s\n", player1.name);
        ball2 = 0;
        ball3 = 0;
        ball1 = scanner.nextInt();
        if (ball1 == 10) {
            System.out.printf("Strike! Enter bonus ball score for %s\n", player1.name);
            ball2 = scanner.nextInt();
            if (ball2 == 10) {
                System.out.printf("Strike! Enter second bonus ball score for %s\n", player1.name);
                ball3 = scanner.nextInt();
            } else {
                System.out.printf("Enter second bonus ball score for %s\n", player1.name);
                ball3 = scanner.nextInt();
            }
        } else {
            System.out.printf("Enter frame 10, ball 2 score for %s\n", player1.name);
            ball2 = scanner.nextInt();        
        }
        if (ball1 + ball2 == 10 && ball1 != 10) {
            System.out.printf("Spare! Enter bonus ball score for %s\n", player1.name);
        }
        player1.frames.add(new FinalFrame(ball1, ball2, ball3));

        System.out.printf("Enter frame 10, ball 1 score for %s\n", player2.name);
        ball2 = 0;
        ball3 = 0;
        ball1 = scanner.nextInt();
        if (ball1 == 10) {
            System.out.printf("Strike! Enter bonus ball score for %s\n", player2.name);
            ball2 = scanner.nextInt();
            if (ball2 == 10) {
                System.out.printf("Strike! Enter second bonus ball score for %s\n", player2.name);
                ball3 = scanner.nextInt();
            } else {
                System.out.printf("Enter second bonus ball score for %s\n", player2.name);
                ball3 = scanner.nextInt();
            }
        } else {
            System.out.printf("Enter frame 10, ball 2 score for %s\n", player2.name);
            ball2 = scanner.nextInt();        
        }
        if (ball1 + ball2 == 10 && ball1 != 10) {
            System.out.printf("Spare! Enter bonus ball score for %s\n", player2.name);
            ball3 = scanner.nextInt();
        }
        player2.frames.add(new FinalFrame(ball1, ball2, ball3));

        System.out.println("Final Score:");
            System.out.printf("%s: %d\n", player1.name, player1.CurrentScore());
            System.out.printf("%s: %d\n", player2.name, player2.CurrentScore()); 
    }

}
