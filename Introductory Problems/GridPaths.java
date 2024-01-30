import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GridPaths {

	private static boolean[][] onPath = new boolean[9][9];
	private static final int[] DR = { -1, 0, 1, 0 };
	private static final int[] DC = { 0, 1, 0, -1 };
	private static int[] p = new int[48];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		for (int i = 0; i < p.length; i++) {
			char current = line.charAt(i);
			if (current == 'U') {
				p[i] = 0;
			} else if (current == 'R') {
				p[i] = 1;
			} else if (current == 'D') {
				p[i] = 2;
			} else if (current == 'L') {
				p[i] = 3;
			} else {
				p[i] = 4;
			}
		}
		for (int i = 0; i < 9; i++) {
			onPath[0][i] = true;
			onPath[8][i] = true;
			onPath[i][0] = true;
			onPath[i][8] = true;
		}
		int paths = tryPath(0, 1, 1);
		System.out.println(paths);
	}

	public static int tryPath(int pathIndex, int currentRow, int currentColumn) {
		if ((onPath[currentRow][currentColumn - 1] && onPath[currentRow][currentColumn + 1])
				&& (!onPath[currentRow - 1][currentColumn] && !onPath[currentRow + 1][currentColumn])) {
			return 0;
		}
		if ((onPath[currentRow - 1][currentColumn] && onPath[currentRow + 1][currentColumn])
				&& (!onPath[currentRow][currentColumn - 1] && !onPath[currentRow][currentColumn + 1])) {
			return 0;
		}
		if (currentRow == 7 && currentColumn == 1) {
			if (pathIndex == p.length) {
				return 1;
			}
			return 0;
		}
		if (pathIndex == p.length) {
			return 0;
		}
		int ret = 0;
		onPath[currentRow][currentColumn] = true;
		if (p[pathIndex] < 4) {
			int nxtR = currentRow + DR[p[pathIndex]];
			int nxtC = currentColumn + DC[p[pathIndex]];
			if (!onPath[nxtR][nxtC]) {
				ret += tryPath(pathIndex + 1, nxtR, nxtC);
			}
		} else if ((currentColumn > 2) && onPath[currentRow][currentColumn - 2]
				&& (onPath[currentRow - 1][currentColumn - 1] || onPath[currentRow + 1][currentColumn - 1])
				&& (!onPath[currentRow][currentColumn - 1])) {
			int nxtR = currentRow;
			int nxtC = currentColumn - 1;
			ret += tryPath(pathIndex + 1, nxtR, nxtC);
		} else if ((currentColumn < 6) && onPath[currentRow][currentColumn + 2]
				&& (onPath[currentRow - 1][currentColumn + 1] || onPath[currentRow + 1][currentColumn + 1])
				&& (!onPath[currentRow][currentColumn + 1])) {
			int nxtR = currentRow;
			int nxtC = currentColumn + 1;
			ret += tryPath(pathIndex + 1, nxtR, nxtC);
		} else if ((currentRow > 2) && onPath[currentRow - 2][currentColumn]
				&& onPath[currentRow - 1][currentColumn - 1] && (!onPath[currentRow - 1][currentColumn])) {
			int nxtR = currentRow - 1;
			int nxtC = currentColumn;
			ret += tryPath(pathIndex + 1, nxtR, nxtC);
		} else {
			for (int i = 0; i < 4; i++) {
				int nxtR = currentRow + DR[i];
				int nxtC = currentColumn + DC[i];
				if (onPath[nxtR][nxtC]) {
					continue;
				}
				ret += tryPath(pathIndex + 1, nxtR, nxtC);
			}
		}
		onPath[currentRow][currentColumn] = false;
		return ret;
	}
}