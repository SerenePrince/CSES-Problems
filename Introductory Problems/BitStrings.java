import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitStrings {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long result = 1, base = 2, modulus = 1000000007;
		while (n > 0) {
			if ((n & 1) == 1) {
				result = (result * base) % modulus;
			}
			n = n >> 1;
			base = (base * base) % modulus;
		}
		System.out.println(result);
	}
}