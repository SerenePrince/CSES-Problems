import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ConcertTickets {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] h = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] t = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(h);
		int index = 0;
		boolean ticketSold;
		StringBuilder sb = new StringBuilder();
		while (index < m) {
			ticketSold = false;
			for (int i = n - 1; i >= 0; i--) {
				if (h[i] != -1 && h[i] <= t[index]) {
					sb.append(h[i] + "\n");
					h[i] = -1;
					ticketSold = true;
					break;
				}
			}
			index++;
			if (!ticketSold) {
				sb.append(-1 + "\n");
			}
		}
		System.out.println(sb);
	}
}