import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitQueries {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (q-- > 0) {
			sb.append(processQuerie(Long.parseLong(br.readLine())) + "\n");
		}
		System.out.println(sb);
	}

	private static long processQuerie(long num) {
		long digits = 1, totalDigits = 9, startDigit = 1;
		while (num > totalDigits) {
			num -= totalDigits;
			digits++;
			startDigit *= 10;
			totalDigits = 9 * digits * startDigit;
		}
		long actualDigit = startDigit + (num - 1) / digits;
		long digitPosition = (num - 1) % digits;
		while (digitPosition < digits - 1) {
			actualDigit /= 10;
			digitPosition++;
		}
		return actualDigit % 10;
	}
}