import java.util.Scanner;

public class arrayGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int wordLength = 5;
        int attempts = 0;

        String secretWord = generateSecretWord(5); // pulls a random word from the array to be used for the current round
        System.out.println(
                "welcome to foodle, a food based wordle game, you have 5 attempts to guess the word. misplaced letters are printed as * and incorrect letters are -, every secret word only has 5 letters! good luck!");

        while (attempts < 5) {
            System.out.println("Enter your guess");
            String guess = in.nextLine();
            if (guess.length() != wordLength) {
                System.out.println("invaild guess! please input a word with " + wordLength + " characters");

            }
            if (guess.equals(secretWord)) {
                System.out.println("You guessed the correct word! it only took you " + attempts + " attempts!");
                break;

            } else {
                String feedback = provideFeedback(guess, secretWord);
                System.out.println(feedback);
                attempts++;

            }
            if (attempts == 5) {
                System.out.println("You couldn't guess the word. The secret word was: " + secretWord);
                break;
            }

        }
    }
    public static final String YellowText = "\u001B[33m";

    public static final String ResetText = "\u001B[0m";
    
    public static final String RedText = "\u001B[31m";

    public static String generateSecretWord(int wordLength) { //array of words used in game
        String[] words = { "apple", "pears", "peach", "lemon", "grape", "melon", "kiwis", "mango", "pecan", "onion" };
        int randomPicker = (int) (Math.random() * words.length);
        return words[randomPicker];
    }

    public static String provideFeedback(String guess, String secretWord) {
        String feedback = "";

        for (int i = 0; i < guess.length(); i++) {
            char guessChar = guess.charAt(i);

            if (guessChar == secretWord.charAt(i)) { //swaps letters out for symbols
                feedback += guessChar;
            } else if (secretWord.contains(String.valueOf(guessChar))) {
                feedback += YellowText + "*" + ResetText;
            } else {
                feedback += RedText + "-" + ResetText;
            }
        }

        return feedback;
    }
}