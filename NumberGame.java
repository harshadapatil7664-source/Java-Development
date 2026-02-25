//Number Game.
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        char playAgain;

        do {
            int number = random.nextInt(100) + 1;
            int attempts = 7; 
            int guess;
            boolean won = false;

            System.out.println("\n--- Number Guessing Game ---");
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have 7 attempts.");

            while (attempts > 0) {

                System.out.print("Enter your guess: ");
                guess = sc.nextInt();

                if (guess == number) {
                    System.out.println("Correct! You Won.");
                    totalScore++;
                    won = true;
                    break;
                } 
                else if (guess > number) {
                    System.out.println("Too high!");
                } 
                 else if((guess ==number+1)||(guess==number-1)){
                System.out.println("To Close!");
            }
                else {
                    System.out.println("Too low!");
                }
                attempts--;
                System.out.println("Attempts left: " + attempts);
            }

            if (!won) {
                System.out.println("You lost! The number was: " + number);
            }
             System.out.println("Your score: " + totalScore);

            System.out.print("Play again? (y/n): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("Thanks for playing!");
        sc.close();
    }
}

