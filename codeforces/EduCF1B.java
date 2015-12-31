import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;


public class EduCF1B {
	public static void main(String[] args) {
		String s = in.next();
		int n = in.nextInt();
		for(int i = 0; i < n; i++) {
			int l, r, k;
			l = in.nextInt();
			r = in.nextInt();
			k = in.nextInt();
			s = s.substring(0, l-1) + (rotate(k, s.substring(l-1,r))) + (s.substring(r));
			//out.println(rotate(k, s.substring(l-1,r)));
		}
		out.println(s);
		out.close();
		
	}
	static String rotate(int kTimes, String s) {
		int k = kTimes%s.length();
		String last = s.substring(s.length()-k);
		String first = s.substring(0, s.length()-k);
		return last.concat(first);
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
