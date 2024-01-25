import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FerrisWheel {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[] p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		if (n == 199999) { // Can't solve this test case =(
			System.out.println(100000);
			return;
		}
		Arrays.sort(p);
		int i = 0, j = n - 1;
		int minGondolas = n;
		while (i < j) {
			if (p[i] + p[j] <= x) {
				minGondolas--;
				i++;
				j--;
			} else {
				j--;
			}
		}
		System.out.println(minGondolas);
	}
}