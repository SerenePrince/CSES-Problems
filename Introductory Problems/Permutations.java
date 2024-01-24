import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Permutations {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		if (n == 1) {
			System.out.println(1);
			return;
		}
		if (n <= 3) {
			System.out.println("NO SOLUTION");
			return;
		}
		for (int i = 2; i <= n; i += 2) {
			sb.append(i + " ");
		}
		for (int i = 1; i <= n; i += 2) {
			sb.append(i + " ");
		}
		System.out.println(sb);
	}
}