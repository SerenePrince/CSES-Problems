import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoSets {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		if (n % 4 == 1 || n % 4 == 2) {
			System.out.println("NO");
			return;
		}
		if (n % 4 == 3) {
			sb.append("YES\n" + n / 2 + "\n");
			for (int i = 2; i <= n / 2; i += 2) {
				sb.append(i + " " + (n - i) + " ");
			}
			sb.append(n + "\n" + (n / 2 + 1) + "\n");
			for (int i = 1; i <= n / 2; i += 2) {
				sb.append(i + " " + (n - i) + " ");
			}
			System.out.println(sb);
			return;
		}
		sb.append("YES\n" + n / 2 + "\n");
		for (int i = 2; i <= n / 2; i += 2) {
			sb.append(i + " " + (n - i + 1) + " ");
		}
		sb.append("\n" + n / 2 + "\n");
		for (int i = 1; i <= n / 2; i += 2) {
			sb.append(i + " " + (n - i + 1) + " ");
		}
		System.out.println(sb);
	}
}