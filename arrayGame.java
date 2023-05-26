import java.util.Scanner;

public class arrayGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         int wordLength = 5;
         int attempts = 0;

         while (attempts < 10) { 
            System.out.println("Enter your guess");
            String guess = in.nextLine();
            if (guess.length() != wordLength) {
                System.out.println("invaild guess! please input a word with " + wordLength + " characters");
            }

         }

    }
    public static String generateSecretWord(int wordLength) {
        String[] words = {"apple", "pears", "peach", "lemon", "grape" };
        int randomPicker = (int) (Math.random()*words.length);
        return words[randomPicker];
    }
}