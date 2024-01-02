import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bit_Strings {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		long modulo = 1000000007;
		long result = 1;
		long base = 2;
		while (n > 0) {
			if (n % 2 == 1) {
				result = (result * base) % modulo;
			}
			base = (base * base) % modulo;
			n /= 2;
		}
		System.out.println(result);
		br.close();
	}
}