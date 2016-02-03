import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cf341A {
	public static void main(String[] args) {
		int n;
		long ans = 0;
		n = in.nextInt();
		int minOdd = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int x = in.nextInt();
			ans += x;
			if(x%2 == 1) {
				minOdd = Math.min(minOdd, x);
			}
		}
		if (ans % 2 != 0) {
			ans -= minOdd;
		}
		out.println(ans);
		out.close();
	}

	// --------------- ------fast input/ouput---------------------------///

	public static Object returnFirst(Object x, Object y) {
		return x;
	}

	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	public static FastScanner in = new FastScanner();

	public static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	// -----------------------------fast i/o ends
	// here-------------------------//
}
