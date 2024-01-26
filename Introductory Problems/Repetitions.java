import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Repetitions {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		int count = 1, result = 1;
		char previous = n.charAt(0);
		for (int i = 1; i < n.length(); i++) {
			if (n.charAt(i) == previous) {
				count++;
			} else {
				count = 1;
				previous = n.charAt(i);
			}
			if (count > result) {
				result = count;
			}
		}
		System.out.println(result);
	}
}