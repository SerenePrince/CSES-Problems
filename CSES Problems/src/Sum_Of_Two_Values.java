import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sum_Of_Two_Values {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int size = input[0], target = input[1];
		Map<Integer, Integer> sums = new HashMap<>();
		for (int i = 0; i < size; i++) {
			if (sums.containsKey(array[i])) {
				System.out.println(sums.get(array[i]) + " " + (i + 1));
				return;
			}
			sums.put(target - array[i], i + 1);
		}
		System.out.println("IMPOSSIBLE");
		br.close();
	}
}
