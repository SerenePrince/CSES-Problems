import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		list.add("");
		for (int i = 0; i < n; i++) {
			int size = list.size();
			for (int j = size - 1; j >= 0; j--) {
				list.add(list.get(j));
			}
			size *= 2;
			for (int j = 0; j < size; j++) {
				if (j < list.size() / 2) {
					list.set(j, list.get(j) + "0");
				} else {
					list.set(j, list.get(j) + "1");
				}
			}
		}
		for (String str : list) {
			System.out.println(str);
		}
	}
}