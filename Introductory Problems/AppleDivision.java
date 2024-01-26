import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AppleDivision {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] p = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		long total = 0, result = Integer.MAX_VALUE;
		for (long num : p) {
			total += num;
		}
		for (int i = 0; i < (1 << n); i++) {
			long sum = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					sum += p[j];
				}
			}
			long current = Math.abs(total - 2 * sum);
			result = Math.min(result, current);
		}
		System.out.println(result);
	}
}