import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class EduCF4B {
	//static int [] ar = new int[200005];
	public static void main(String[] args) {
		int n = in.nextInt();
		int [] ar = new int[n];
		for(int i = 0; i < n; i++) {
			int segment = in.nextInt();
			ar[segment-1] = i;
		}
		long ans = 0;
		for(int i = 1; i < n; i++) {
			ans += Math.abs(ar[i]-ar[i-1]);
		}
		out.println(ans);
		out.close();
	}
	
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
}
