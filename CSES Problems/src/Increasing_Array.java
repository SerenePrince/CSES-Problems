import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Increasing_Array {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		String[] input = br.readLine().split(" ");
		long[] numbers = new long[n];
		for (int i = 0; i < input.length; i++) {
			numbers[i] = Integer.valueOf(input[i]);
		}
		long previous = numbers[0], current, moves = 0;
		for (int i = 1; i < n; i++) {
			current = numbers[i];
			moves += ((previous - current) > 0 ? (previous - current) : 0);
			previous = Math.max(previous, current);
		}
		System.out.println(moves);
		br.close();
	}
}