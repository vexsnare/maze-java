import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;




public class cf338c {

	public static void main(String[] args) {
		String a = in.next();
		String b = in.next();
		ArrayList<Pair> ar = solve(a, b);
		if (ar.isEmpty()) {
			out.println(-1);
		} else {
			out.println(ar.size());
			for (Pair p : ar) {
				out.println(p.x + " " + p.y);
			}
		}
		out.close();
	}

	static ArrayList<Pair> solve(String a, String b) {
		ArrayList<Pair> result = new ArrayList<>();
		int current_i = 0;
		while (current_i < b.length()) {
			int start_i = current_i;
			int end_i = current_i + 1;
			// search normal substring
			while (end_i <= b.length()) {
				String s = b.substring(start_i, end_i);
				if (a.contains(s)) {
					end_i++;
				} else
					break;
			}
			int end_i_for_reverse = start_i+1;
			// search reverse of substring
			while (end_i_for_reverse <= b.length()) {
				String s = b.substring(start_i, end_i_for_reverse);
				String reverse = new StringBuilder(s).reverse().toString();
				if (a.contains(reverse)) {
					end_i_for_reverse++;
				} else
					break;
			}
			end_i --;
			end_i_for_reverse--;
			if (end_i - start_i == 0 && end_i_for_reverse - start_i == 0) {
				return new ArrayList<>();
			} else {
				if (end_i - start_i > end_i_for_reverse - start_i) {
					int index = a.indexOf(b.substring(start_i, end_i));
					result.add(new Pair(index + 1, index+end_i-start_i));
					current_i = end_i;
				} else {
					int index = a.indexOf(new StringBuilder(b.substring(start_i, end_i_for_reverse)).reverse().toString());
					result.add(new Pair(index+end_i_for_reverse-start_i ,index + 1));
					current_i = end_i_for_reverse;
				}
			}
		}
		return result;
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
	} // --fast i/o ends here----//

}
class Pair implements Comparable<Pair> {
	int x, y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Pair o) {
		return this.x - o.x;
	}

	public String toString() {
		return "{" + this.x + "," + this.y + "}";
	}
}