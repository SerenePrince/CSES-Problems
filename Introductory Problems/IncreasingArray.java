import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IncreasingArray {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] x = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		long previous = x[0], current, moves = 0;
		for (int i = 1; i < n; i++) {
			current = x[i];
			moves += ((previous - current) > 0 ? (previous - current) : 0);
			previous = Math.max(previous, current);
		}
		System.out.println(moves);
	}
}