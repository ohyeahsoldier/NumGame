import java.util.Scanner;
import java.util.regex.*;

public class other2
{
    private static Scanner in = new Scanner(System.in);
	private static boolean isX = false;
	private static int turnCount = 0;

	public static void main(String[] args)
	{
		char[][] board = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
		
		do { //Run this code once, THEN check conditionals
			//Switches the player's turn
			isX = !isX;

			print(board);
			board = playerTurn(board);
			turnCount++;
		} while( !checkWin(board) && turnCount<9);

		System.out.println((turnCount<9) ? "\033[1;30mYou won!" : "\033[1;30ma cat's game eh?"); //\033[1;30m for ANSI black bold
		print(board);
		System.out.print("\033[0m"); //Turn off ANSI black bold color
	}
	
	/**
	 * Prints out the @param board but only X & O. The placeholder numbers are replaced with ‒ which is a full length '-' https://symbl.cc/en/2012/
	 */
	public static void print(char[][] board)
	{
		for (char[] row : board) {
			for (char c : row)
				if (c=='X'||c=='O') System.out.printf("%c ",c);
				else System.out.print("‒ ");
			System.out.println();
		}
	}
	
	/**
	 * Asks player where they want to play. Uses the static var isX to know which player is playing
	 * @param board the board to modify and to check
	 * @return board after player plays valid move
	 */
	public static char[][] playerTurn(char[][] board)
	{
		//set player to the person's turn
		char player = isX ? 'X' : 'O';
		
		boolean validSpot = false;
		while (!validSpot) {
			char spot = '-'; //temp unused value
			while (true) {
				System.out.print("Player " + player + ", where would you like to go? > ");
				String INPUT = in.nextLine();
				if (Pattern.matches("^[1-9]$",INPUT)) {//if matchFound
					spot = INPUT.charAt(0);
					break;
				}else
					System.out.println("Must be between 1 & 9\n");
			}
			//set that spot to the player's letter (char player) //Check validity too
			for (int row = 0; row<board.length; row++)
				for (int col = 0; col<board[0].length; col++)
					if (board[row][col]==spot) {
						board[row][col] = player;
						validSpot = true;
						System.out.printf("Put a %c on spot %c\n\n",player,spot);
					}
			if (!validSpot) System.out.printf("You can't put a %c on spot %c!\n\n",player,spot);
		}
		return board;
	}
	
	/**
	 * Check @param board for verticle, horizontal, and diagonal wins (Hardcoded for 3x3)
	 * @return true if win is found, false if no wins yet
	 */
	public static boolean checkWin(char[][] board)
	{
		//check for horizontal wins
		for (char[] row : board)
			if (row[0]==row[1] && row[1]==row[2]) return true;
		
		//check for vertical wins
		String str = String.valueOf(board[0])+String.valueOf(board[1])+String.valueOf(board[2]);
		for (int i=0; i<3; i++) //repeat 3 times, i=0,1,2
			if (str.charAt(i)==str.charAt(i+3) && str.charAt(i)==str.charAt(i+6)) return true;

		//check for diagonal wins
		if (board[0][0]==board[1][1] && board[1][1] == board[2][2]) return true;
		if (board[0][2]==board[1][1] && board[1][1] == board[2][0]) return true;

		//else
		return false;
	}
}
