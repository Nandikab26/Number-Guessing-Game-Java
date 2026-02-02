import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        char playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int numberToGuess = random.nextInt(100) + 1;
            int guess = 0;
            int attempts = 0;
            int maxAttempts = 10;
            int score = 0;

            System.out.println("\nGuess a number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (guess != numberToGuess && attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                guess = sc.nextInt();
                attempts++;

                if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Correct! You guessed it in " + attempts + " attempts.");
                }
            }

            if (guess == numberToGuess) {
                if (attempts <= 3) {
                    score = 10;
                } else if (attempts <= 6) {
                    score = 7;
                } else {
                    score = 5;
                }
            } else {
                System.out.println("Out of attempts! The number was: " + numberToGuess);
                score = 0;
            }

            totalScore += score;

            System.out.println("Score this round: " + score);
            System.out.println("Total Score: " + totalScore);

            System.out.print("Do you want to play another round? (y/n): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("\nThanks for playing! Final Score: " + totalScore);
        sc.close();
    }
}
