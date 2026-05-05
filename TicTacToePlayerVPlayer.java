import java.util.Arrays;
import java.util.Scanner;

public class TicTacToePlayerVPlayer {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		//Player X
		String token1 = "X";
		//Player O
		String token2 = "O";
		System.out.println("Play Tic Tac Toe!");
		String[][] board = new String[3][3];
		//Empty strings
		valueReplace(board);
		displayBoard(board);
		boolean stopGame = false;
		do {
			//X makes move
			makeMove(board, token1);
			displayBoard(board);
			if (win(token1, board)) {
				System.out.println("Player X wins!");
				stopGame = true;
			} else if (draw(board)) {
				System.out.println("Draw!");
				stopGame = true;
			}
			// O makes move
			if (stopGame == false) {
				makeMove(board, token2);
				displayBoard(board);
				if (win(token2, board)) {
					System.out.println("Player O wins!");
					stopGame = true;
				} else if (draw(board)) {
					System.out.println("Draw!");
					stopGame = true;
				}
			}

		} while (stopGame == false);

	}

	// method to display the board
	public static void displayBoard(String[][] b) {
		for (int r = 0; r < b.length; r++) {
			System.out.println("-------------");
			System.out.print("| ");
			for (int c = 0; c < b[r].length; c++) {
				System.out.print(b[r][c] + " | ");
			}
			System.out.println();
		}
		System.out.println("-------------");
		System.out.println();
	}
	
	// method to make move
	public static void makeMove(String[][] b, String p) {
		int row;
		int col;
		boolean valid = false;
		do {
			System.out.println("Player " + p + " - Enter Row: ");
			row = input.nextInt();
			System.out.println("Column: ");
			col = input.nextInt();

			if (row < 3 && row >= 0 && col < 3 && col >= 0) {
				valid = true;
				if (b[row][col].length() > 0) {
					System.out.println("Cell is already occupied.");
					valid = false;
				}
			} else {
				System.out.println("Row and/or Column not valid.");
			}

		} while (valid == false);
		b[row][col] = p;
	}

	// method to replace array elements with empty string
	public static void valueReplace(String[][] b) {
		for (int r = 0; r < b.length; r++) {
			for (int c = 0; c < b[r].length; c++) {
				b[r][c] = "";
			}
		}
	}

	// method to see if Player X or O won
	public static boolean win(String p, String[][] b) {
		boolean win = false;
		String checkValueRow = "";
		String checkValueCol = "";
		String checkValueDia = "";
		String checkValueDia2 = "";
		String testValueRow = "";
		String testValueCol = "";
		testValueCol = p + p + p;
		String testValueDiagonal = "";
		testValueDiagonal = p + p + p;
		String checkValue2 = "";
		for (int r = 0; r < b.length; r++) {

			//System.out.println("b" + r + ":" + Arrays.toString(b[r]));
			checkValueRow = Arrays.toString(b[r]);
			//System.out.println("checkValue=" + checkValueRow);
			testValueRow = "[" + p + ", " + p + ", " + p + "]";
			//System.out.println("testValue=" + testValueRow);
			if (checkValueRow.equals(testValueRow)) {
				win = true;

			}

			//System.out.println("Win" + win);
		}
		//System.out.println("testValueCol=" + testValueCol);
		for (int c = 0; c < b[0].length; c++) {
			checkValueCol = "";
			//System.out.print("Column" + c);
			for (int r = 0; r < b.length; r++) {
				checkValueCol = checkValueCol + b[r][c];
			}

			//System.out.println("MC:" + checkValueCol);
			if (checkValueCol.equals(testValueCol)) {
				win = true;
			}
		}

		checkValueDia = b[0][2] + b[1][1] + b[2][0];
		checkValueDia2 = b[0][0] + b[1][1] + b[2][2];
		//System.out.println("checkValueDia=" + checkValueDia);
		if (checkValueDia.equals(testValueDiagonal)) {
			win = true;
		} else if (checkValueDia2.equals(testValueDiagonal)) {
			win = true;
		}
		//System.out.println(win);
		return win;
	}
	
	// method to see if game is draw
	public static boolean draw(String[][] b) {
		boolean noEmptySpace = true;
		for (int r = 0; r < b.length; r++) {
			for (int c = 0; c < b[r].length; c++) {
				if (b[r][c].equals("")) {
					noEmptySpace = false;
				}
			}
		}
		//System.out.println("Draw" + noEmptySpace);
		return noEmptySpace;
	}

}
