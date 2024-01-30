import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiceCombinations {

	private static final int MOD = 1000000007;
	private static long table[] = new long[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Arrays.fill(table, 0);
		table[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= 6 && i - j >= 0; j++) {
				table[i] += table[i - j];
				table[i] %= MOD;
			}
		}
		System.out.println(table[n]);
	}
}