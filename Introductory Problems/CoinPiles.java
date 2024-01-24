import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinPiles {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(canArrangeCoins(a, b) ? "YES\n" : "NO\n");
		}
		System.out.print(sb);
	}

	private static boolean canArrangeCoins(int a, int b) {
		return (a + b) % 3 == 0 && 2 * Math.min(a, b) >= Math.max(a, b);
	}
}