import java.util.InputMismatchException;
import java.util.Scanner;

public class Connect4 {

    String[][] board = {{"O", "O", "O", "O", "O", "O", "O"},{"O", "O", "O", "O", "O", "O", "O"},{"O", "O", "O", "O", "O", "O", "O"},{"O", "O", "O", "O", "O", "O", "O"},{"O", "O", "O", "O", "O", "O", "O"},{"O", "O", "O", "O", "O", "O", "O"}};
    String red = "R";
    String yellow = "Y";
    String currentPlayer = red;
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Connect4();
    }

    Connect4() {
        GameTurn();
    }

    public void GameTurn() {
        PrintBoard();
        PickColumn();
        if (CheckWin() || CheckWinVert() || CheckWinForSlash() || CheckWinBackSlash()) {
            System.exit(0);
        } else {
        ChangePlayer();
        GameTurn();
        }
        
    }

    public void PrintBoard() {
        System.out.printf("|1|2|3|4|5|6|7\n______________\n");
        for (int i = 0; i < board.length; ++i) {
            //System.out.printf("%d -", i + 1);
            for (int j = 0; j < board[i].length; ++j) {
                System.out.printf("|" + board[i][j]);
            }
            System.out.println("");
        }
    }

    public void PickColumn() {
        int pick = 0;

        while (pick < 1) {
            try {
                System.out.println("Pick a column");
                pick = scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Invalid choice, please choose between 1-7");
                scanner.next();
            }
        }

        pick -= 1;
        if (pick > 6) {
            System.out.println("Invalid choice, please choose between 1-7");
            PickColumn();
        } else if (!board[0][pick].equals("O")) {
            System.out.println("No room left in that column, pick again");
            PickColumn();
        } else {
            for (int i = board.length - 1; i >= 0; --i) {
                if (board[i][pick].equals("O")) {
                    board[i][pick] = currentPlayer;
                    break;
                }
            }
        }
    }

    public void ChangePlayer() {
        if (currentPlayer == red) {
            currentPlayer = yellow;
        } else {
            currentPlayer = red;
        }
    }

    public boolean CheckWin() {
        //Check horizontal
        String winner = null;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (currentPlayer.equals(board[i][j]) && currentPlayer.equals(board[i][j+1]) && currentPlayer.equals(board[i][j+2]) && currentPlayer.equals(board[i][j+3])) {
                    winner = currentPlayer;
                    PrintBoard();
                    System.out.printf("%s player wins! Game Over", winner);
                    scanner.close();
                    return true;
                }
            }
        }
        return false;
        
    }

    public boolean CheckWinVert() {
        //Check Vertical
        String winner = null;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (currentPlayer.equals(board[i][j]) && currentPlayer.equals(board[i+1][j]) && currentPlayer.equals(board[i+2][j]) && currentPlayer.equals(board[i+3][j])) {
                    winner = currentPlayer;
                    PrintBoard();
                    System.out.printf("%s player wins! Game Over", winner);
                    scanner.close();
                    return true;
                }
            }
        }
        return false;
        
    }

    public boolean CheckWinForSlash() {
        //Check Vertical
        String winner = null;
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (currentPlayer.equals(board[i][j]) && currentPlayer.equals(board[i-1][j+1]) && currentPlayer.equals(board[i-2][j+2]) && currentPlayer.equals(board[i-3][j+3])) {
                    winner = currentPlayer;
                    PrintBoard();
                    System.out.printf("%s player wins! Game Over", winner);
                    scanner.close();
                    return true;
                }
            }
        }
        return false;
        
    }
    
    public boolean CheckWinBackSlash() {
        //Check Vertical
        String winner = null;
        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < board[0].length; j++) {
                if (currentPlayer.equals(board[i][j]) && currentPlayer.equals(board[i-1][j-1]) && currentPlayer.equals(board[i-2][j-2]) && currentPlayer.equals(board[i-3][j-3])) {
                    winner = currentPlayer;
                    PrintBoard();
                    System.out.printf("%s player wins! Game Over", winner);
                    scanner.close();
                    return true;
                }
            }
        }
        return false;
        
    }

}
