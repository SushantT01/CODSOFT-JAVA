package Sushant;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int totalScore = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            int roundScore = maxAttempts; // Initialize score for the current round.

            System.out.println("Round " + (rounds + 1));
            System.out.println("I've selected a random number between " + minRange + " and " + maxRange + ". Try to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                if (scanner.hasNextInt()) {
                    int userGuess = scanner.nextInt();
                    
                    if (userGuess < minRange || userGuess > maxRange) {
                        System.out.println("Your guess is out of the specified range.");
                    } else if (userGuess < targetNumber) {
                        System.out.println("Too low! Try again.");
                    } else if (userGuess > targetNumber) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + (attempts + 1) + " attempts.");
                        roundScore = maxAttempts - attempts; // Calculate score for this round.
                        totalScore += roundScore; // Update the total score.
                        break;
                    }
                    
                    attempts++;
                } else {
                    System.out.println("Please enter a valid integer guess.");
                    scanner.next(); // Clear the invalid input from the scanner.
                }
            }

            if (attempts >= maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + targetNumber);
            }

            rounds++;

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Your total score is: " + totalScore);
                break;
            }
        }

        scanner.close();
    }
}

