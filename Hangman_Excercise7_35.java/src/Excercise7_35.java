import java.util.Scanner;
public class Excercise7_35 {

	
		/*********************************************************************************
		* (Game: hangman) Write a hangman game that randomly generates a word and        *
		* prompts the user to guess one letter at a time, as shown in the sample run.    *
		* Each letter in the word is displayed as an asterisk. When the user makes a     *
		* correct guess, the actual letter is then displayed. When the user finishes a   *
		* word, display the number of misses and ask the user whether to continue to     *
		* play with another word. Declare an array to store words, as follows:           *
		*********************************************************************************/

		public static void main(String[] args) {
			Scanner input = new Scanner	(System.in);
			System.out.print("Hello World!");
			input.nextLine();
			String play; //'y' or 'n'
			
			do {
				//Generate a random word
				char [] word = getWord();
				//Display each letter in the word as an asterisk 
				char [] asterisks = new char [word.length];
				fillAsterisks(asterisks);
				
				//number of wrong guesses
				int missed = 0;
				do {
					//Prompt the user to guess one letter
					char guess = getGuess(asterisks);
					//check if is letter is correct
					if (!isCorrectGuess(word,asterisks,guess));
					missed++;
				} while (!isWordFinish(asterisks));
				//Print results
				print(word, missed);
				
				//Ask the user whether to continue to play with another word
				System.out.println("Do you want to guess another word? Enter y or n>");
				play = input.next();
				} while ( play.charAt(0) == 'y' );
			}
	/**print overloaded*/
		private static void print(char[] word, int missed ) {
			System.out.print(" The word is ") ;
			System.out.print(word);
			System.out.print(" You missed " + missed + " time ");
		}
	/**isWordFinish*/
		private static boolean isWordFinish(char[] blanks) {
			for(char e : blanks){
				if (e == 'x')
					return false;
			}
			return true;
		}

		
	/** checkGuesss test if the user guess was correct*/
		private static boolean isCorrectGuess(char[] word, char[] blanks, char guess) {
			boolean correct = false;
			int message = 2;
			
			for(int i = 0; i < word.length; i++){
				if (word[i] == guess){
					correct = true;
					if(blanks[i] == guess)
						message = 1;
					else {
						//the actual letter is then displayed
						blanks [i] = guess;
						message = 0;
					}
				}
			}
			if(message > 0)
				print(message, guess);
			return correct;
			
		}
	/** Print overloaded*/
		private static void print(int message, char guess) {
		System.out.print("\t" + guess);
		
		switch (message){
		case 1 : System.out.print(" is already in the word "); break;
		case 2 : System.out.print(" is not in the word, ");
		}
		
	}
	/** getGuess Prompts the user to guess one letter at a time */
		private static char getGuess(char[] asterisks) {
			Scanner input = new Scanner(System.in);
			System.out.print("Let's play a Guessing game called Hangman***"
					+ " (Guess) Enter a letter in word " );
			System.out.print(asterisks);
			System.out.print(" > ");
			String g = input.next();
			return g.charAt(0);
		}
	/* fillAsterisks initializes a list with asterisks*/
		private static void fillAsterisks(char[] list) {
			for(int i = 0; i < list.length; i++){
				list[i] = '*';
			}
			
			
		}
		/* getword randomly generates a word from a list */
		private static char[] getWord() {
			String [] words = { "Write", "that", "Program", "Trump", "Hillary", "Clinton", "Obama", "Vote"};
			String pick = words[(int) (Math.random()* words.length)];
			char [] word = new char[pick.length ()];
			for(int i =0; i < word.length; i++) {
				word [i] = pick.charAt(i);
			}
			
			return word;
		}

	}


