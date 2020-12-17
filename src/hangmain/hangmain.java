// HANGMAN @Pontus93
package hangmain;


import java.util.Scanner;

public class hangmain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// An Array with words, Math.random function.
		String[] words = new String[] { "svenne", "banan", "falafel", "kebab", "bmw", "audi" };
		String randomWord = words[(int) (Math.random() * words.length)];
		char[] letters = new char[randomWord.length()];
		int lives = 6;

		System.out.println("FACIT: " + randomWord);
		System.out.println();

		// Showing the less funny swing + the amount of letters in the word.
		System.out.println("HANGMAN THE GAME!");
		System.out.print("" + " ______\n" + " |    |\n" + " |    \n" + " |    \n" + " |    \n" + " |    \n" + "/|\\ ");
		System.out.println();
		System.out.println();
		System.out.println("THE WORD HAS " + randomWord.length() + " LETTERS.");

		// The less funny swing & (counter + if statements)
		for (int i = 0; i < letters.length; i++) {
			letters[i] = '.';
		}

		while (lives > 0) {

			if (lives == 5) {
				System.out.print(
						"" + " ______\n" + " |    |\n" + " |    O\n" + " |    \n" + " |    \n" + " |    \n" + "/|\\ ");
				System.out.println();
				System.out.println();
			}
			if (lives == 4) {
				System.out.print(
						"" + " ______\n" + " |    |\n" + " |    O\n" + " |   /\n" + " |  \n" + " |    \n" + "/|\\ ");
				System.out.println();
				System.out.println();
			}
			if (lives == 3) {
				System.out.print(
						"" + " ______\n" + " |    |\n" + " |    O\n" + " |   /|\n" + " | \n" + " |    \n" + "/|\\ ");
				System.out.println();
				System.out.println();
			}
			if (lives == 2) {
				System.out.print("" + " ______\n" + " |    |\n" + " |    O\n" + " |   /|\\\n" + "/|\\ ");
				System.out.println();
				System.out.println();
			}
			if (lives == 1) {
				System.out.print("" + " ______\n" + " |    |\n" + " |    O\n" + " |   /|\\\n" + " |   / \n" + " |    \n"
						+ "/|\\ ");
				System.out.println();
			}

			boolean isGuessCorrect = false;
			boolean isGameFinished = true;
			
			System.out.println();
			System.out.print("word: ");
			System.out.println();

			for (int i = 0; i < letters.length; i++) {
				if (letters[i] == '.') {
					isGameFinished = false;
				}
				System.out.print(letters[i]);
			}
			
			// You win!
			if (isGameFinished) {
				System.out.println();
				System.out.println("CONGRATZ, YOU WON!");
				System.out.println("THE WORD WAS: " + randomWord);
				break;
			}
			System.out.println();
			System.out.println();
			System.out.println("#MENU");
			System.out.println("CLICK #1 to see your lifes.");
			System.out.println("CLICK #2 to guess the correct word.");
			System.out.println("CLICK #3 to guess 1 letter.");
			System.out.println();
			String input = scanner.nextLine().toLowerCase();
			System.out.println();

			// Check current lives.
			if ("1".equals(input)) {
				System.out.println();
				System.out.println("*************** YOU HAVE " + lives + " LIVES LEFT! ***************");
			}

			// Guess the right word and win directly!
			if ("2".equals(input)) {
				System.out.println("GUESS FULL WORD:");
				input = scanner.nextLine().toLowerCase();
				if (randomWord.equals(input)) {
					System.out.println();
					System.out.println("CONGRATZ, YOU WON BY GUESSING THE WORD!");
					System.out.println("THE WORD WAS: " + randomWord);
					break;
				}
				lives = lives - 1;

			}

			if ("3".equals(input)) {
				System.out.println("Guess with 1 letter");
				input = scanner.nextLine().toLowerCase();
				char letter = input.charAt(0);
				for (int i = 0; i < randomWord.length(); i++) {
					char l = randomWord.charAt(i);
					if (l == letter) {
						letters[i] = l;
						isGuessCorrect = true;
					}
				}

				if (!isGuessCorrect) {
					lives = lives - 1;
				}
			}

			// Shows the magic word you couldn't figure out.
			if (lives == 0) {
				System.out.println();
				System.out.print("" + " ______\n" + " |    |\n" + " |    O\n" + " |   /|\\\n" + " |   / \\\n"
						+ " |    \n" + "/|\\ ");
				System.out.println();
				System.out.println("YOU LOST! THE WORD WAS: " + randomWord);
			}

			// Shows if you try to enter empty scanner
			if (input.isEmpty()) {
				System.out.println("******* SCANNER CAN NOT BE EMPTY, TRY AGAIN *******");
			}
		}

	}

}