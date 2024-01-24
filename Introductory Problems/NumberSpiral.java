import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberSpiral {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int y = input[0], x = input[1];
			long max = Math.max(y, x);
			long square = (max - 1) * (max - 1);
			if (max % 2 == 0) {
				if (x > y) {
					sb.append(square + y).append("\n");
				} else {
					sb.append(max * max - x + 1).append("\n");
				}
			} else {
				if (x > y) {
					sb.append(max * max - y + 1).append("\n");
				} else {
					sb.append(square + x).append("\n");
				}
			}
		}
		System.out.print(sb);
	}
}