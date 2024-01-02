import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Two_Sets {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		StringBuilder set = new StringBuilder();
		if (n % 4 == 1 || n % 4 == 2) {
			System.out.println("NO");
		} else if (n % 4 == 3) {
			set.append("YES\n" + n / 2 + "\n");
			for (int i = 2; i <= n / 2; i += 2) {
				set.append(i + " " + (n - i) + " ");
			}
			set.append(n + "\n" + (n / 2 + 1) + "\n");
			for (int i = 1; i <= n / 2; i += 2) {
				set.append(i + " " + (n - i) + " ");
			}
			System.out.println(set);
		} else {
			set.append("YES\n" + n / 2 + "\n");
			for (int i = 2; i <= n / 2; i += 2) {
				set.append(i + " " + (n - i + 1) + " ");
			}
			set.append("\n" + n / 2 + "\n");
			for (int i = 1; i <= n / 2; i += 2) {
				set.append(i + " " + (n - i + 1) + " ");
			}
			System.out.println(set);
		}
		br.close();
	}
}