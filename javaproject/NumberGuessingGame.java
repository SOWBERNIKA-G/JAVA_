
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int EASY_DIFFICULTY = 10;
    private static final int MEDIUM_DIFFICULTY = 50;
    private static final int HARD_DIFFICULTY = 100;

    private static int highScore = 0;
    private static int gamesPlayed = 0;
    private static int wins = 0;
    private static int losses = 0;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Select a difficulty level:");
            System.out.println("1. Easy (1-10)");
            System.out.println("2. Medium (1-50)");
            System.out.println("3. Hard (1-100)");
            System.out.println("4. Quit");

            int difficultyLevel = scanner.nextInt();

            if (difficultyLevel == 4) {
                break;
            }

            int randomNumber = getRandomNumber(difficultyLevel, random);
            int attempts = getAttempts(scanner);

            int userGuess = 0;
            int count = 0;

            while (count < attempts) {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();

                if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                    provideHint(randomNumber, userGuess);
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                    provideHint(randomNumber, userGuess);
                } else {
                    System.out.println("Congratulations! You guessed the number in " + (count + 1) + " attempts.");
                    updateGameStatistics(true);
                    break;
                }

                count++;
            }

            if (count == attempts) {
                System.out.println("Sorry, you didn't guess the number. The number was " + randomNumber + ".");
                updateGameStatistics(false);
            }

            displayGameStatistics();
        }

        scanner.close();
    }

    private static int getRandomNumber(int difficultyLevel, Random random) {
        switch (difficultyLevel) {
            case 1:
                return random.nextInt(EASY_DIFFICULTY) + 1;
            case 2:
                return random.nextInt(MEDIUM_DIFFICULTY) + 1;
            case 3:
                return random.nextInt(HARD_DIFFICULTY) + 1;
            default:
                return 0;
        }
    }

    private static int getAttempts(Scanner scanner) {
        while (true) {
            System.out.print("Enter the number of attempts (1-5): ");
            int attempts = scanner.nextInt();

            if (attempts >= 1 && attempts <= 5) {
                return attempts;
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void provideHint(int randomNumber, int userGuess) {
        if (Math.abs(randomNumber - userGuess) <= 5) {
            System.out.println("You're getting close! Try again.");
        } else {
            System.out.println("Keep trying!");
        }
    }

    private static void updateGameStatistics(boolean isWin) {
        gamesPlayed++;
        if (isWin) {
            wins++;
            if (highScore == 0 || gamesPlayed - wins < highScore) {
                highScore = gamesPlayed - wins;
            }
        } else {
            losses++;
        }
    }

    private static void displayGameStatistics() {
        System.out.println("\nGame Statistics:");
        System.out.println("Games Played: " + gamesPlayed);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("High Score: " + highScore);
    }
}

