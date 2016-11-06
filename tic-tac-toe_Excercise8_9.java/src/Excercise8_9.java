

	import java.util.Scanner;
	public class Excercise8_9 {
		/*********************************************************************************
		* (Game: play a tic-tac-toe game) In a game of tic-tac-toe, two players take     *
		* turns marking an available cell in a 3 * 3 grid with their respective tokens   *
		* (either X or O). When one player has placed three tokens in a horizontal,      *
		* vertical, or diagonal row on the grid, the game is over and that player has    *
		* won. A draw (no winner) occurs when all the cells on the grid have been filled *
		* with tokens and neither player has achieved a win. Create a program for        *
		* playing tic-tac-toe. The program prompts two players to enter an X token       *
		* and O token alternately. Whenever a token is entered, the program redisplays   *
		* the board on the console and determines the status of the game (win, draw, or  *
		* continue).                                                                     *
		*********************************************************************************/
		public static void main(String[] args) {
			//Create a empty board
			String [] [] board = getBoard ();
			
			//create two players token
			String [] tokens = { "x", "o"};
	//gain status result
			int result;
			//Repeat while result is continue
			do{
				//Display Board
				print(board);
				//Get available all to mark
				int [] all = getCell(board, tokens[0]);
			//Mark available all with player's token
				placeToken(board, all , tokens[0]);
				//Determine game status
				result = gameStatus(board, tokens[0]);
				//If status 9s continue make next player takes turn
				if(result == 2){
					swap(tokens);
				}
				
			}while (result == 2);
		//Display game result
			if(result == 0)
				System.out.println(tokens[0] + " Player won ");
			else
				System.out.println("Players draw ");
		}
		/** swap swaps the elements in an arrray */
		private static void swap(String[] p) {
			String temp = p[0];
			p[0] = p[1];
			p[1] = temp;
		}
			
		
		/** gameStatus determines the status of the game 
		 * (win,draw,or continue)
		 * @param board
		 * @param string
		 */
		private static int gameStatus(String[][] m, String e ) {
			if (isWin(m, e))
				return 0; //win
			else if (isDraw(m))
				return 1; //Draw
			else
				
			return 2; //continue
		}

		/** isDraw returns true if all the cells on the grid have been  
			 filled with tokens and neither player has achieved a win */
		private static boolean isDraw(String[][] m) {
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					if (m[i][j] == "   ")
						return false;
				}
			}
			return true;
			
		}
		/** isWin returns true if player has placed three tokens in, 
	    a horizontal vertical, or diagonal row on the grid */
		private static boolean isWin(String[][] m, String t) {
			return isHorizontalWin(m, t) || isVerticalWin(m, t) || isDiagonalWin(m, t);
			
		}
		/** isDiagonalWin returns true if player has 
	    placed three tokens in a diagonal row */
		private static boolean isDiagonalWin(String[][] m, String t) {
			int count = 0;
			for (int i = 0; i < m.length; i++) {
				if (m[i][i] == t)
					count++;
				if (count == 3)
					return true;
			}

			count = 0;
			for (int i = 0, j = m[i].length - 1; j >= 0 ; j--, i++) {
				if (m[i][j] == t)
					count++;
				if (count == 3)
					return true;
			}
			return false;
		}
		/** isVerticalWin returns true if player has 
	    placed three tokens in a vertical row */
		private static boolean isVerticalWin(String[][] m, String t) {
			for (int i = 0; i < m.length; i++) {
				int count = 0;
				for (int j = 0; j < m[i].length; j++) {
					if (m[j][i] == t)
						count++;
				}
				if (count == 3)
					return true;
			}
			return false;
		}

		/** isHorizontalWin returns true if player has 
		    placed three tokens in a horizontal row */
		private static boolean isHorizontalWin(String[][] m, String t) {
			for (int i = 0; i < m.length; i++) {
				int count = 0;
				for (int j = 0; j < m[i].length; j++) {
					if (m[i][j] == t)
						count++;
				}
				if (count == 3)
					return true;
			}
			
			return false;
		}

		/** placeToken fills the matrix cell with the player's token */
		private static void placeToken(String[][] m, int[] e, String t) {
			m[e[0]][e[1]] = t;
		}
		/** getCell returns a valid cell input by user */
		private static int[] getCell(String[][] m, String t) {
			// Create a Scanner
			Scanner input = new Scanner(System.in);
			int[] cell = new int[2]; // Cell row and column

			// Prompt player to enter a token
			do {
				System.out.print("Enter a row(0, 1, or 2) for player " + t + ": ");
				cell[0] = input.nextInt();
				System.out.print("Enter a column(0, 1, or 2) for player " + t + ": ");
				cell[1] = input.nextInt();

			} while (!isValidCell(m, cell));
			return cell;
			
		}


		/** isValidCell returns true is cell is empty and is in a 3 x 3 array */
		private static boolean isValidCell(String[][] m, int[] cell) {
			for (int i = 0; i < cell.length; i++) {
				if (cell[i] < 0 || cell[i] >= 3) {
					System.out.println("Invalid cell");
					return false;
				}
			}
			if (m[cell[0]][cell[1]] != "   ") {
				System.out.println(
					"\nRow " + cell[0] + " column " + cell[1] + " is filled");
				return false;
			}
			return true;	
			
		}

		/** print displays the board */
		private static void print(String[][] m) {
			System.out.println("\n-------------");
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					System.out.print("|" + m[i][j]);
				}
				System.out.println("|\n-------------");
			
			}
		}

		/** getBoard returns a 3 x 3 array filled with blank spaces */
		private static String[][] getBoard() {
			String[][] m = new String[3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					m[i][j] = "   ";
				}
			}
			return m;
			
		}

	}

