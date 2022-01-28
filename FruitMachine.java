import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class FruitMachine {

    int[] fruits = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 5, 5, 5, 5, 5, 10, 10, 10, 20 };
    HashMap<Integer, String> fruitNames = new HashMap<>();
    int cookies = 0;
    int credits = 100;
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new FruitMachine();
    }

    FruitMachine() {
        fruitNames.put(1, "Apple");
        fruitNames.put(3, "Banana");
        fruitNames.put(5, "Orange");
        fruitNames.put(10, "Cherry");
        fruitNames.put(20, "Pineapple");
        PullArm();
    }

    public void PullArm() {
        System.out.println("Would you like another pull? Y/N");
        char ch = scanner.next().charAt(0);
        if (ch == 'y') {
            if (credits > 0) {
                Random random = new Random();
                int randomFruit1 = fruits[random.nextInt(fruits.length)];
                int randomFruit2 = fruits[random.nextInt(fruits.length)];
                int randomFruit3 = fruits[random.nextInt(fruits.length)];
                String fruit1 = fruitNames.get(randomFruit1);
                String fruit2 = fruitNames.get(randomFruit2);
                String fruit3 = fruitNames.get(randomFruit3);

                System.out.println("Result: " + fruit1 + " " + fruit2 + " " + fruit3);
                if (randomFruit1 == randomFruit2 && randomFruit1 == randomFruit3) {
                    int newCookies = (randomFruit1 + randomFruit2 + randomFruit3);
                    cookies += newCookies;
                    System.out.printf("You Win %d cookies! You now have %d cookies!", newCookies, cookies);
                    credits -= 1;
                } else {
                    System.out.println("Bad luck, try again!");
                    credits -= 1;
                }
                PullArm();
            } else {
                System.out.println("No credits left, game over");
                System.out.printf("Final Score: %d Cookies", cookies);
                scanner.close();
            }

        } else {
            System.out.printf("Game over.  Final score: %d", cookies);
            scanner.close();
        }
    }
}
