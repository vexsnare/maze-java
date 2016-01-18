import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CFEdu5A {
	public static void main(String[] args) {
			String a = in.nextLine();
			String b = in.nextLine();
			int i = 0;
			while(a.charAt(i) == '0' && i < a.length()-1) i++;
			a = a.substring(i);
			i = 0;
			while(b.charAt(i) == '0' && i < b.length()-1) i++;
			b = b.substring(i);
			if(a.length() > b.length()) {
				out.println(">");
			} else if(a.length() < b.length()) {
				out.println("<");
			} else {
				for(i = 0; i < a.length(); i++) {
					if(a.charAt(i) != b.charAt(i)) break;
				}
				if(i == a.length()) {
					out.println("=");
				} else {
					out.println(a.charAt(i) > b.charAt(i) ? ">" : "<");
				}
			}
			out.close();
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
