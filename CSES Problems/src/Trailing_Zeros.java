import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Trailing_Zeros {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		if (n < 5) {
			System.out.println(0);
		} else {
			int zeros = 0;
			for (long i = 5; i <= n; i *= 5) {
				zeros += n / i;
			}
			System.out.println(zeros);
		}
		br.close();
	}
}