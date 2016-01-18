import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class cf338B {
	public static void main(String[] args) {
		int n = in.nextInt();
		int m = in.nextInt();
		int [] ln = new int[n];
		int [] ou = new int[n];
		int u, v;
		ArrayList<ArrayList<Integer>> ar = new ArrayList<ArrayList<Integer>>(n);
		for(int i = 0; i < n; i++) ar.add(new ArrayList<>());
		for(int i = 0; i < m; i++) {
			u = in.nextInt();
			v = in.nextInt();
			ar.get(u-1).add(v-1);
			ar.get(v-1).add(u-1);
			ou[u-1]++;
			ou[v-1]++;
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < ar.get(i).size(); j++) {
				int x = ar.get(i).get(j);
				if(x < i) {
					ln[i] = Math.max(ln[x] + 1, ln[i]);
				}
			}
		}
		long ans = -1;
		for(int i = 0; i < n; i++) {
			ans = Math.max(ans, (long)ou[i]*(ln[i]+1));
		}
		out.println(ans);
		out.close();
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
