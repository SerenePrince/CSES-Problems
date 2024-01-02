import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Missing_Number {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		String[] input = br.readLine().split(" ");
		int[] numbers = new int[n + 1];
		for (int i = 0; i < n - 1; i++) {
			int num = Integer.parseInt(input[i]);
			numbers[num] = 1;
		}
		for (int i = 1; i < n + 1; i++) {
			if (numbers[i] == 0) {
				System.out.println(i);
				break;
			}
		}
		br.close();
	}
}