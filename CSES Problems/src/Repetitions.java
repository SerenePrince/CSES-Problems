import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Repetitions {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().trim();
		int count = 0, answer = 1;
		char dna = 'A';
		for (char c : s.toCharArray()) {
			if (c == dna) {
				count++;
				answer = Math.max(count, answer);
			} else {
				dna = c;
				count = 1;
			}
		}
		System.out.println(answer);
		br.close();
	}
}