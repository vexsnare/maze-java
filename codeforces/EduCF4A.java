import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class EduCF4A {
	static int max = 101;
	public static void main(String[] args) {
		int n = in.nextInt();
		int p = in.nextInt();
		int q = in.nextInt();
		String s = in.next();
		int n1 = -1;
		int n2 = -1;
		for(int i = 0; i < n+1; i++) {
			for(int j = 0; j < n+1; j++) {
				if(i*p + j*q == n) {
					n1 = i;
					n2 = j;
				}
			}
		}
		if(n1 != -1) {
			out.println(n1+n2);
			for(int i = 0; i < n1; i++) {
				out.println(s.substring(0+p*i, p+p*i));
			}
			for(int i = 0; i < n2; i++) {
				out.println(s.substring(n1*p+q*i, n1*p+q*i+q));
			}
		}
		else out.println(-1);
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
