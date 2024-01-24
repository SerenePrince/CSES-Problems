import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrailingZeros {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if (n < 5) {
			System.out.println(0);
			return;
		}
		int zeros = 0;
		for (long i = 5; i <= n; i *= 5) {
			zeros += n / i;
		}
		System.out.println(zeros);
	}
}