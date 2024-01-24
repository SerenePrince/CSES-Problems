import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeReorder {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] letters = br.readLine().toCharArray();
		int[] count = new int[26];
		for (char c : letters) {
			if (Character.isLetter(c)) {
				count[Character.toUpperCase(c) - 'A']++;
			}
		}
		int numOdds = 0;
		for (int i = 0; i < 26; i++) {
			if (count[i] % 2 != 0) {
				numOdds++;
				if (numOdds > 1) {
					System.out.println("NO SOLUTION");
					return;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < count[i] / 2; j++) {
				sb.append((char) (i + 'A'));
			}
		}
		for (int i = 0; i < 26; i++) {
			if (count[i] % 2 != 0) {
				sb.append((char) (i + 'A'));
			}
		}
		for (int i = 25; i >= 0; i--) {
			for (int j = 0; j < count[i] / 2; j++) {
				sb.append((char) (i + 'A'));
			}
		}
		System.out.println(sb);
	}
}