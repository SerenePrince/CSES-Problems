import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MissingNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int num = 0;
		for (int i = 0; i < input.length; i++) {
			num ^= input[i];
		}
		for (int i = 1; i <= n; i++) {
			num ^= i;
		}
		System.out.println(num);
	}
}