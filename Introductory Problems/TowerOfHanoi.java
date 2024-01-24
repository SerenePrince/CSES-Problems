import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TowerOfHanoi {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println((int) Math.pow(2, n) - 1);
		towerOfHanoi(n, 1, 3, 2);
	}

	private static void towerOfHanoi(int n, int from, int to, int help) {
		if (n == 1) {
			System.out.println(from + " " + to);
			return;
		}
		towerOfHanoi(n - 1, from, help, to);
		System.out.println(from + " " + to);
		towerOfHanoi(n - 1, help, to, from);
	}
}