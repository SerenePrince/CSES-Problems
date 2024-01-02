import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Two_Knights {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		System.out.println(0);
		for (long i = 2; i <= n; i++) {
			System.out.println((i * i) * (i * i - 1) / 2 - (4 * (i - 2) * (i - 1)));
		}
		br.close();
	}
}