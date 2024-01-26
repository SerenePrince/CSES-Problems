import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChessboardAndQueens {

	private static final int SIZE = 8;
	private static char[][] board = new char[SIZE][];
	private static boolean[] takenCols = new boolean[8];
	private static boolean[] takenDiag1 = new boolean[16];
	private static boolean[] takenDiag2 = new boolean[16];
	private static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 8; i++) {
			board[i] = br.readLine().toCharArray();
		}
		placeQueens(0);
		System.out.println(result);
	}

	private static void placeQueens(int row) {
		if (row == SIZE) {
			result++;
			return;
		}
		for (int col = 0; col < SIZE; col++) {
			if (board[row][col] == '.' && !takenCols[col] && !takenDiag1[row - col + 8 - 1] && !takenDiag2[row + col]) {
				takenCols[col] = takenDiag1[row - col + 8 - 1] = takenDiag2[row + col] = true;
				placeQueens(row + 1);
				takenCols[col] = takenDiag1[row - col + 8 - 1] = takenDiag2[row + col] = false;
			}
		}
	}
}