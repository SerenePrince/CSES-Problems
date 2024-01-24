import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WeirdAlgorithm {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Integer.parseInt(br.readLine());
		while (n != 1) {
			System.out.print(n + " ");
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n = n * 3 + 1;
			}
		}
		System.out.print(n);
	}
}