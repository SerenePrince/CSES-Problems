import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class CreatingStrings {

	private static Set<String> permutations = new LinkedHashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		permutations("", s);
		System.out.println(permutations.size());
		for (String str : permutations) {
			System.out.println(str);
		}
	}

	private static void permutations(String prefix, String suffix) {
		if (suffix.length() == 0) {
			permutations.add(prefix);
		}
		for (int i = 0; i < suffix.length(); i++) {
			permutations(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1));
		}
	}
}