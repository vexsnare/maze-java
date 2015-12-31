import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class BinaryIndexTree {
	public static void main(String[] args) {
		String[] s = in.nextLine().split(" ");
		int n = Integer.parseInt(s[0]);
		String t = s[2];
		int ans = 0;
		if(t.equals("week")) ans = 52 + (n <= 2 ? 1 : 0);
		else if(t.equals("month")) {
			if(n <= 29) ans = 12;
			else if(n == 30) ans = 11;
			else ans = 6;
		}
		out.println(ans);
		out.close();
		
		
	}
	// --------------- ------fast input/ouput---------------------------///
	
	
	
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
