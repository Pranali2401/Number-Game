import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class NumberGuessingGameWithRounds {

    public static void main(String[] args) {
        final int MAX_ATTEMPTS = 5; // Maximum number of attempts allowed
        int totalRounds = 0;
        int totalAttempts = 0;
        int totalWins = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                int randomNumber = ThreadLocalRandom.current().nextInt(1, 101);
                int userGuess = 0; // Initialize with a default value
                int attempts = 0;
                totalRounds++;

                System.out.println("Round " + totalRounds + ":");
                System.out.println("Guess a number between 1 and 100.");

                while (attempts < MAX_ATTEMPTS) {
                    System.out.print("Enter your guess: ");

                    // Check if the input is an integer
                    if (scanner.hasNextInt()) {
                        userGuess = scanner.nextInt();
                        attempts++;
                        totalAttempts++;

                        if (userGuess == randomNumber) {
                            System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
                            System.out.println("Number of attempts in this round: " + attempts);
                            totalWins++;
                            break;
                        } else if (userGuess < randomNumber) {
                            System.out.println("Too low. Try again!");
                        } else {
                            System.out.println("Too high. Try again!");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter an integer.");
                        scanner.next(); // Consume the invalid input
                    }
                }

                if (attempts == MAX_ATTEMPTS && userGuess != randomNumber) {
                    System.out.println("Out of attempts. The correct number was: " + randomNumber);
                }

                System.out.print("Do you want to play another round? (yes/no): ");
                String playAgain = scanner.next();

                if (!playAgain.equalsIgnoreCase("yes")) {
                    break;
                }
            }
        }

        System.out.println("Game over!");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Total attempts made: " + totalAttempts);
        System.out.println("Total wins: " + totalWins);
    }
}