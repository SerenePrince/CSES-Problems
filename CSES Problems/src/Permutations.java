import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Permutations {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		StringBuilder permutations = new StringBuilder();
		if (n == 1) {
			System.out.println(1);
		} else if (n == 2 || n == 3) {
			System.out.println("NO SOLUTION");
		} else {
			for (int i = 2; i <= n; i += 2) {
				permutations.append(i + " ");
			}
			for (int i = 1; i <= n; i += 2) {
				permutations.append(i + " ");
			}
		}
		System.out.println(permutations);
		br.close();
	}
}