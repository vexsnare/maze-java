import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

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

public class FbHackerCupQHighSecurity {

	static int r = 2;
	static int c = 0;
	static String[] ar = new String[2];
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			ans = Integer.MAX_VALUE;
			count = 0;
			c = in.nextInt();
			boolean[][] visited = new boolean[2][c];
			ar[0] = in.nextLine();
			ar[1] = in.nextLine();
			dfs(visited);
			printAns(t, ans);
		}
		out.close();
	}

	static int count = 0;

	static void dfs(boolean[][] visited) {
		boolean found = false;
		for (int ii = 0; ii < 2; ii++) {
			for (int jj = 0; jj < c; jj++) {
				if (visited[ii][jj] == false && ar[ii].charAt(jj) == '.') {
					found = true;
					count++;
					ArrayList<Pair> trek = new ArrayList<>();
					int i = ii;
					int j = jj;
					while (j < c) {
						if (ar[i].charAt(j) == '.') {
							if (visited[i][j] == false) {
								visited[i][j] = true;
								trek.add(new Pair(i, j));
							}
						} else
							break;
						j++;
					}
					i = ii;
					j = jj;
					while (j >= 0) {
						if (ar[i].charAt(j) == '.') {
							if (visited[i][j] == false) {
								visited[i][j] = true;
								trek.add(new Pair(i, j));
							}
						} else
							break;
						j--;
					}
					i = ii;
					j = jj;
					while (i < 2) {
						if (ar[i].charAt(j) == '.') {
							if (visited[i][j] == false) {
								visited[i][j] = true;
								trek.add(new Pair(i, j));
							}
						} else
							break;
						i++;
					}
					i = ii;
					j = jj;
					while (i >= 0) {
						if (ar[i].charAt(j) == '.') {
							if (visited[i][j] == false) {
								visited[i][j] = true;
								trek.add(new Pair(i, j));
							}
						} else 
							break;
						i--;
					}
					dfs(visited);
//					while (!trek.isEmpty()) {
//						Pair p = trek.removeLast();
//						visited[p.x][p.y] = false;
//					}
					for(int kk = 0; kk < trek.size(); kk++) {
						Pair p = trek.get(kk);
						visited[p.x][p.y] = false;
					}
					count--;
				}
			}
		}
		if (found == false) {
			ans = Math.min(ans, count);
		}
	}

	static void printAns(int t, long ans) {
		out.println("Case #" + t + ": " + ans);
	}

	// ------------ fast input/ouput--------//

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
	} // --fast i/o ends here----//

}
