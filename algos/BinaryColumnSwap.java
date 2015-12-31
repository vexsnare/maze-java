import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * Find max size of 1's sub-matrix in a given binary matrix - you are allowed to swap columns
 */
public class BinaryColumnSwap {
	static int r, c;
	
	public static void main(String[] args) {
		r = in.nextInt();
		c = in.nextInt();
		String [] ar = new String[r];
		for(int i = 0; i < r; i++) ar[i] = in.next();
		
		int[][] count = new int[r][c];
		for(int j = 0; j < c; j++) {
			for(int i = 0; i < r; i++) {
				count[i][j] = i > 0 ? (ar[i].charAt(j) == '1' ? count[i-1][j]+1 : 0) : (ar[i].charAt(j) == '1' ? 1 : 0);
			}
		}
		for(int i = 0; i < r; i++) {
			Arrays.sort(count[i]);
			reverseArray(count[i], c);
		}
		
		int ans = -1;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				ans = Math.max(ans, count[i][j]*(j+1));
			}
		}
		out.println(ans);
		out.close();
	}
	
	public static void reverseArray(int[] ar, int n) {
		for(int i = 0; i <n/2; i++) {
			ar[i] = (int)returnFirst(ar[n-i-1], ar[n-i-1] = ar[i]);
		}
	}
	
	//------------ fast input/ouput--------//
	
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
	} //--fast i/o ends here----//
	

}
