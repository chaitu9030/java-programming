import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalRounds = 0;
        int totalAttempts = 0;
        int roundsWon = 0;

        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1; // Generate random number between 1 and 100
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("I have generated a number between 1 and 100. Try to guess it!");

            for (int attempts = 1; attempts <= maxAttempts; attempts++) {
                System.out.print("Attempt " + attempts + ": ");
                int userGuess = scanner.nextInt();

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    roundsWon++;
                    totalAttempts += attempts;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println(" Number is less then generated number");
                } else {
                    System.out.println(" Number is greater then generated number");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The correct number was: " + randomNumber);
            }

            totalRounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String userResponse = scanner.next();
            playAgain = userResponse.equalsIgnoreCase("yes");
        }

        System.out.println("Game Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Total Rounds Won: " + roundsWon);
        System.out.println("Average Attempts per Round: " + (totalRounds > 0 ? (double) totalAttempts / totalRounds : 0));

        scanner.close();
    }
}
