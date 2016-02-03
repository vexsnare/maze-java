import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cf341B {
	static int max = 1000;
	public static void main(String[] args) {
		int n;
		n = in.nextInt();
		boolean [][]ar = new boolean[1000][1000];
		long ans = 0;
		for(int i = 0; i < n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			ar[x-1][y-1] = true;
		}
		int [][] A = new int[max][max];
		int [][] B = new int[max][max];
		for(int i = max-1; i >= 0; i--) {
			for(int j = max-1; j >= 0; j--) {
				if(inRange(i+1, j+1)) {
					A[i][j] = A[i+1][j+1] + (ar[i][j] ? 1 : 0);
				} else A[i][j] = (ar[i][j] ? 1 : 0);
				if(inRange(i+1, j-1)) {
					B[i][j] = B[i+1][j-1] + (ar[i][j] ? 1 : 0);
				} else B[i][j] = (ar[i][j] ? 1 : 0);
			}
		}
		for(int i = 0; i < max; i++) {
			for(int j = 0; j < max; j++) {
				if(ar[i][j]) {
					ans += A[i][j] + B[i][j] -2;
				}
			}
		}
		out.println(ans);
		out.close();
	}
	
	static boolean inRange(int i, int j) {
		return i >= 0 && j >= 0 && i < max && j < max;
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
