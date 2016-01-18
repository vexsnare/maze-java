import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FbHackerCupQThePrice {

	public static void main(String[] args) {
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			long ans = 0;
			int n = in.nextInt();
			int p = in.nextInt();
			int[] ar = new int[n];
			for (int i = 0; i < n; i++) {
				ar[i] = in.nextInt();
			}
			long[] sum = new long[n];
			for (int i = 0; i < n; i++) {
				long currentSum = (i == 0 ? ar[i] : sum[i - 1] + ar[i]);
				if (ar[i] <= p) {
					//int required = p - ar[i];
					if (i > 0) {
						int index = getIndex(sum, 0, i - 1, p, currentSum);
						ans += i - index + 1;
					} else {
						ans += (p >= ar[i] ? 1 : 0);
					}
				}
				sum[i] = currentSum;
			}
			printAns(t, ans);
		}
		out.close();
	}

	static void printAns(int t, long ans) {
		out.println("Case #" + t + ": " + ans);
	}

	static int getIndex(long[] sum, int i, int j, int required, long currentSum) {
		if(currentSum <= required) return 0;
		while (i <= j) {
			int m = (i + j) / 2;
			long value = sum[m];
			if (currentSum - value <= required) {
				if(j == m) return j+1;
				j = m;
			} else
				i = m + 1;
		}
		return i;
	}
	// ------------ fast input/ouput--------//

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
	} // --fast i/o ends here----//

}
