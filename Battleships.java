import java.util.Scanner;

public class Battleships {

    int[][] grid1 = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                      { 0, 0, 2, 2, 0, 0, 0, 0, 0, 0 },
                      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                      { 0, 0, 4, 4, 4, 4, 0, 0, 0, 0 },
                      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                      { 0, 5, 0, 0, 1, 0, 0, 3, 0, 0 },
                      { 0, 5, 0, 0, 0, 0, 0, 3, 0, 0 },
                      { 0, 5, 0, 0, 0, 0, 0, 3, 0, 0 },
                      { 0, 5, 0, 0, 0, 0, 0, 0, 0, 0 },
                      { 0, 5, 0, 0, 0, 0, 0, 0, 0, 0 } };

    int[][] grid2 = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                      { 0, 0, 5, 5, 5, 5, 5, 0, 0, 0 },
                      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                      { 0, 0, 3, 3, 3, 0, 0, 0, 0, 0 },
                      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                      { 0, 4, 0, 0, 0, 0, 0, 2, 0, 0 },
                      { 0, 4, 0, 0, 0, 0, 0, 2, 0, 0 },
                      { 0, 4, 0, 0, 1, 0, 0, 0, 0, 0 },
                      { 0, 4, 0, 0, 0, 0, 0, 0, 0, 0 },
                      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

    int[][] p1ShotGrid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

    int[][] p2ShotGrid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

    int p1 = 1;
    int p2 = 2;
    int currentplayer = 1;
    String[] shipNames = { "Patrol Boat", "Submarine", "Cruiser", "Battleship", "Carrier" };
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Battleships();
    }

    Battleships() {
        GameTurn();

    }

    public void GameTurn() {
        PrintShotGrid();
        CheckShot(PickShot());
        if (CheckWin()) {
            System.out.printf("Game Over! Player %d wins!", currentplayer);
            scanner.close();
        } else {
        togglePlayer();
        GameTurn();
        }
    }

    public void PrintShotGrid() {
        int[][] currentGrid;
        if (currentplayer == 1) {
            currentGrid = p1ShotGrid;
        } else {
            currentGrid = p2ShotGrid;
        }
        System.out.printf("    0|1|2|3|4|5|6|7|8|9\n");
        for (int i = 0; i < currentGrid.length; ++i) {
            System.out.printf("%d -", i);
            for (int j = 0; j < currentGrid[i].length; ++j) {
                System.out.printf("|" + currentGrid[i][j]);
            }
            System.out.println("");
        }

    }

    public int[] PickShot() {
        int row;
        int column;
        System.out.printf("Player %d's turn", currentplayer);
        System.out.println("Choose row(0-9)");
        row = scanner.nextInt();
        System.out.println("Choose column(0-9)");
        column = scanner.nextInt();
        int[] coords = { row, column };
        return coords;
    }

    public void CheckShot(int[] coords) {
        int[][] currentGrid;
        int[][] currentShotGrid;
        if (currentplayer == 1) {
            currentGrid = grid2;
            currentShotGrid = p1ShotGrid;
        } else {
            currentGrid = grid1;
            currentShotGrid = p2ShotGrid;
        }
        int shotValue = currentGrid[coords[0]][coords[1]];
        if (shotValue == 0 || shotValue == 8) {
            System.out.println("Shot missed!");
            currentShotGrid[coords[0]][coords[1]] = 8;
            return;
        } else if (shotValue > 0 && shotValue < 6) {
            System.out.println("You hit one!");
            currentShotGrid[coords[0]][coords[1]] = 7;
            currentGrid[coords[0]][coords[1]] = 0;
        }
        if (CheckSunk(shotValue, currentGrid)) {
            String sunkShip = shipNames[shotValue - 1];System.out.printf("You sunk a %s!",sunkShip);
           }
        
    }

    public boolean CheckSunk(int shotValue, int[][] currentGrid) {
        boolean isSunk = true;
        for (int i = 0; i < currentGrid.length - 1; i++) {
            if (!isSunk) {
                break;
            }
            for (int j = 0; j < currentGrid[i].length; j++) {
                if (currentGrid[i][j] == shotValue) {
                    isSunk = false;
                    break;
                }
            }  
        }
        return isSunk;
    }

    public boolean CheckWin() {
        boolean hasWon = true;
        int[][] currentGrid;
        if (currentplayer == 1) {
            currentGrid = grid2;
        } else {
            currentGrid = grid1;
        }
        for (int i = 0; i < currentGrid.length; i++) {
            for (int j = 0; j < currentGrid[i].length; j++) {
                if (currentGrid[i][j] != 0) {
                    hasWon = false;
                    return hasWon;
                }
            }
        }

        return hasWon;
        //if grid is all 0, game over, return true
    }

    public void togglePlayer() {
        if (currentplayer == 1) {
            currentplayer = 2;
        } else {
            currentplayer = 1;
        }
    }

}
