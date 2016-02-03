import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CoinChange {

	static int[] coins;

	public static void main(String[] args) {
		int amount = in.nextInt();
		int n = in.nextInt();
		coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = in.nextInt();
		}
		System.out.println(solve(amount, 0));
		System.out.println(solve2(amount));
	}

	static int solve(int amount, int i) {
		if (amount == 0)
			return 1;
		int count = 0;
		if (coins[i] <= amount) {
			count += solve(amount - coins[i], i);
		}
		if (i + 1 < coins.length)
			count += solve(amount, i + 1);
		return count;
	}

	static int solve2(int amount) {
		int n = coins.length;
	
		int[][] ar = new int[n][amount + 1];
		for(int i = 0; i < n; i++) ar[i][0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= amount; j++) {
				if (i - 1 >= 0)
					ar[i][j] += ar[i-1][j];
				if (j >= coins[i])
					ar[i][j] += ar[i][j - coins[i]];
			}
		}
		return ar[n-1][amount];
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
