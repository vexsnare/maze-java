import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class cf336c {
	
	static int max = 1000005;
	public static void main(String[] args) {
		int ar[] = new int[max];
		int dp[] = new int[max];
		int n = in.nextInt();
		for(int i = 0; i < n; i++) {
			int x = in.nextInt();
			int p = in.nextInt();
			ar[x] = p;
		}
		for(int i = 0; i < max; i++) {
			if(ar[i] > 0)
				dp[i] = 1 + (i-ar[i]-1 < 0 ? 0: dp[i-ar[i]-1]);
			else dp[i] = i-1 < 0 ? 0: dp[i-1];
		}
		int ans = Integer.MIN_VALUE;
		for(int i = 0; i < max; i++) ans = Math.max(ans, dp[i]);
		System.out.println(n-ans);
	}
	
	// --------------- pre-written class for fast input/ouput---------------------------///
	public static Object returnFirst(Object x, Object y) {
		return x;
	}
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	public static FastScanner in  = new FastScanner();

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
	//-----------------------------fast i/o ends here-------------------------//
}