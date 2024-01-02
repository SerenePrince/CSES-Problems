import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number_Spiral {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			String[] input = br.readLine().split(" ");
			long x = Long.parseLong(input[0]);
			long y = Long.parseLong(input[1]);
			long number;
			if (y > x) {
				number = y % 2 == 0 ? ((y - 1) * (y - 1)) + 1 + (x - 1) : (y * y) - (x - 1);
			} else {
				number = x % 2 == 0 ? ((x - 1) * (x - 1)) + 1 + (x - 1) + (x - y) : (x * x) - (x - 1) - (x - y);
			}
			System.out.println(number);
		}
		br.close();
	}
}