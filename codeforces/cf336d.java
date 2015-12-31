import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cf336d {
	
	static int max = 501;
	public static void main(String[] args) {
		int n = in.nextInt();
		int dp[][] = new int[max][max];
		for(int i = 0; i < max; i++) Arrays.fill(dp[i], -1);
		int[] ar = new int[n];
		for(int i = 0; i < n; i++) ar[i] = in.nextInt();
		System.out.println(solve(0,n-1, ar, dp));
	}
	static int solve(int i, int j, int ar[], int dp[][]) {
		if(j < i) return 0;
		if(j == i) return 1;
		if(dp[i][j] != -1) return dp[i][j];
		int case1 = 1 + solve(i+1, j, ar, dp);
		int case2 = Integer.MAX_VALUE;
		for(int k = i+1; k <= j; k++) {
			if(ar[i] == ar[k]) {
				int palinPart = solve(i+1,k-1,ar,dp);
				palinPart = k == i+1 ? 1: palinPart;
				int otherPart = solve(k+1,j,ar,dp);
				case2 = Math.min(case2, palinPart+otherPart);
			}
		}
		return dp[i][j] = Math.min(case1, case2);
		
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