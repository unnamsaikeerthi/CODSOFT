import java.util.Scanner;
import java.util.Random;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 7;
        int score = 0;
        int round = 1;

        System.out.println("🎮 Welcome to the Number Guessing Game!");

        boolean playAgain = true;

        while (playAgain) {
            System.out.println("\n--- Round " + round + " ---");
            int secretNumber = random.nextInt(100) + 1; 
            int attemptsLeft = maxAttempts;

            boolean guessedCorrectly = false;

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess (1 to 100), Attempts left: " + attemptsLeft + ": ");
                int guess;

                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("⚠ Please enter a valid number!");
                    continue;
                }

                if (guess == secretNumber) {
                    System.out.println("🎉 Correct! You guessed the number!");
                    guessedCorrectly = true;
                    score++;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low 📉");
                } else {
                    System.out.println("Too high 📈");
                }

                attemptsLeft--;
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You're out of attempts. The correct number was: " + secretNumber);
            }

            System.out.println("Current score: " + score);

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");

            round++;
        }

        System.out.println("\n🏁 Game Over! You won " + score + " round(s). Thanks for playing!");
        scanner.close();
    }
}