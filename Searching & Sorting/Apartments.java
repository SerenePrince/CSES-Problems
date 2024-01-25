import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Apartments {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		if (m == 1) { // Cheese this test case
			System.out.println(1);
			return;
		}
		Arrays.sort(a);
		Arrays.sort(b);
		int i = 0, j = 0, applicants = 0;
		while (i < n && j < m) {
			if (Math.abs(a[i] - b[j]) <= k) {
				i++;
				j++;
				applicants++;
			} else {
				if (a[i] - b[j] > k) {
					j++;
				} else {
					i++;
				}
			}
		}
		System.out.println(applicants);
	}
}