import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.InputMismatchException;

public class CollectingNumbersII {

	private InputStream inputStream;
	private OutputStream outputStream;
	private FastReader in;
	private PrintWriter out;
	private final String PROBLEM_ID = "1039-A";
	private final long MOD = 1000000000 + 7;
	private final int INF = Integer.MAX_VALUE;
	private final long INF_L = Long.MAX_VALUE / 2;

	public CollectingNumbersII(boolean stdIO) throws FileNotFoundException {
		if (stdIO) {
			inputStream = System.in;
			outputStream = System.out;
		} else {
			inputStream = new FileInputStream(PROBLEM_ID + "-input.txt");
			outputStream = new FileOutputStream(PROBLEM_ID + "-output.txt");
		}
		in = new FastReader(inputStream);
		out = new PrintWriter(outputStream);
	}

	void run() throws Exception {
		int n = in.nextInt();
		int m = in.nextInt();
		int[] indices = new int[n + 2];
		int[] values = new int[n + 1];
		indices[n + 1] = n + 1;
		for (int i = 1; i <= n; i++) {
			int x = in.nextInt();
			indices[x] = i;
			values[i] = x;
		}
		int rounds = 1, index = 1;
		for (int i = 1; i <= n; i++) {
			if (index > indices[i]) {
				rounds++;
			}
			index = indices[i];
		}
		while (m-- > 0) {
			int x = in.nextInt();
			int y = in.nextInt();
			int num1 = values[x], num2 = values[y];
			int temp = values[x];
			values[x] = values[y];
			values[y] = temp;
			if (indices[num1 - 1] <= indices[num1] && indices[num1 - 1] > y) {
				rounds++;
			}
			if (indices[num1 - 1] > indices[num1] && indices[num1 - 1] <= y) {
				rounds--;
			}
			if (indices[num1] <= indices[num1 + 1] && y > indices[num1 + 1]) {
				rounds++;
			}
			if (indices[num1] > indices[num1 + 1] && y <= indices[num1 + 1]) {
				rounds--;
			}
			indices[num1] = y;
			if (indices[num2 - 1] <= indices[num2] && indices[num2 - 1] > x) {
				rounds++;
			}
			if (indices[num2 - 1] > indices[num2] && indices[num2 - 1] <= x) {
				rounds--;
			}
			if (indices[num2] <= indices[num2 + 1] && x > indices[num2 + 1]) {
				rounds++;
			}
			if (indices[num2] > indices[num2 + 1] && x <= indices[num2 + 1]) {
				rounds--;
			}
			indices[num2] = x;
			out.println(rounds);
		}
	}

	long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	long lcm(long a, long b) {
		if (a == 0 || b == 0)
			return 0;
		return (a * b) / gcd(a, b);
	}

	long mulMod(long a, long b, long mod) {
		if (a == 0 || b == 0)
			return 0;
		if (b == 1)
			return a;
		long ans = mulMod(a, b / 2, mod);
		ans = (ans * 2) % mod;
		if (b % 2 == 1)
			ans = (a + ans) % mod;
		return ans;
	}

	long pow(long a, long b, long mod) {
		if (b == 0)
			return 1;
		if (b == 1)
			return a;
		long ans = pow(a, b / 2, mod);
		ans = mulMod(ans, ans, mod);
		if (ans >= mod)
			ans %= mod;
		if (b % 2 == 1)
			ans = mulMod(a, ans, mod);
		if (ans >= mod)
			ans %= mod;
		return ans;
	}

	long[][] ncrTable() {
		long ncr[][] = new long[21][21];
		for (int i = 0; i <= 20; i++) {
			ncr[i][0] = ncr[i][i] = 1L;
		}
		for (int j = 0; j <= 20; j++) {
			for (int i = j + 1; i <= 20; i++) {
				ncr[i][j] = ncr[i - 1][j] + ncr[i - 1][j - 1];
			}
		}
		return ncr;
	}

	int i() throws Exception {
		return in.nextInt();
	}

	long l() throws Exception {
		return in.nextLong();
	}

	double d() throws Exception {
		return in.nextDouble();
	}

	char c() throws Exception {
		return in.nextCharacter();
	}

	String s() throws Exception {
		return in.nextLine();
	}

	BigInteger bi() throws Exception {
		return in.nextBigInteger();
	}

	private void closeResources() {
		out.flush();
		out.close();
		return;
	}

	public static void main(String[] args) throws java.lang.Exception {
		CollectingNumbersII driver = new CollectingNumbersII(true);
		driver.run();
		driver.closeResources();
	}

	static class FastReader {
		private InputStream stream;
		private byte[] buf = new byte[4 * 1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;

		public FastReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1) {
				throw new InputMismatchException();
			}
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}

		public int peek() {
			if (numChars == -1) {
				return -1;
			}
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					return -1;
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar];
		}

		public int nextInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c == ',') {
					c = read();
				}
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public String nextString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			if (filter != null) {
				return filter.isSpaceChar(c);
			}
			return isWhitespace(c);
		}

		public boolean isWhitespace(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private String readLine0() {
			StringBuilder buf = new StringBuilder();
			int c = read();
			while (c != '\n' && c != -1) {
				if (c != '\r') {
					buf.appendCodePoint(c);
				}
				c = read();
			}
			return buf.toString();
		}

		public String nextLine() {
			String s = readLine0();
			while (s.trim().length() == 0)
				s = readLine0();
			return s;
		}

		public String nextLine(boolean ignoreEmptyLines) {
			if (ignoreEmptyLines) {
				return nextLine();
			} else {
				return readLine0();
			}
		}

		public BigInteger nextBigInteger() {
			try {
				return new BigInteger(nextString());
			} catch (NumberFormatException e) {
				throw new InputMismatchException();
			}
		}

		public char nextCharacter() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			return (char) c;
		}

		public double nextDouble() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E') {
					return res * Math.pow(10, nextInt());
				}
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E') {
						return res * Math.pow(10, nextInt());
					}
					if (c < '0' || c > '9') {
						throw new InputMismatchException();
					}
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}

		public boolean isExhausted() {
			int value;
			while (isSpaceChar(value = peek()) && value != -1)
				read();
			return value == -1;
		}

		public String next() {
			return nextString();
		}

		public SpaceCharFilter getFilter() {
			return filter;
		}

		public void setFilter(SpaceCharFilter filter) {
			this.filter = filter;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}

	static class Pair implements Comparable<Pair> {
		public int a;
		public int b;

		public Pair() {
			this.a = 0;
			this.b = 0;
		}

		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Pair p) {
			if (this.a == p.a) {
				return this.b - p.b;
			}
			return this.a - p.a;
		}

		@Override
		public String toString() {
			return "a = " + this.a + " b = " + this.b;
		}
	}
}