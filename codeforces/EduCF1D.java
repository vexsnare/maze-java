import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class EduCF1D {
	static int r, c;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int count = 0;

	static boolean inRange(int x, int y, int r, int c) {
		return x >= 0 && x < r && y >= 0 && y < c;
	}

	public static void main(String[] args) {
		r = in.nextInt();
		c = in.nextInt();
		int k = in.nextInt();
		String[] ar = new String[r];
		for (int i = 0; i < r; i++) {
			ar[i] = in.next();
		}

		int[][] visited = new int[r][c];
		int dp[][] = new int[r][c];

		for (int i = 0; i < r; i++)
			Arrays.fill(dp[i], -1);

		for (int i = 0; i < k; i++) {
			int x, y;
			x = in.nextInt();
			y = in.nextInt();
			if (dp[x - 1][y - 1] == -1) {
				count = 0;
				solve(ar, x - 1, y - 1, visited);
				dfs(dp, count, x - 1, y - 1, ar, visited);
			} else
				count = dp[x - 1][y - 1];
			out.println(count);
		}
		out.close();
	}

	static void solve(String[] ar, int xx, int yy, int[][] visited) {
		LinkedList<Point> stack = new LinkedList<>();
		stack.add(new Point(xx, yy));
		while (!stack.isEmpty()) {
			Point p = stack.removeLast();
			int x = p.x;
			int y = p.y;
			if (ar[x].charAt(y) == '*') {
				count++;
				continue;
			}
			if(visited[x][y] == 1) continue;
			visited[x][y] = 1;
			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				if (inRange(nextX, nextY, r, c) && visited[nextX][nextY] != 1) {
					stack.add(new Point(nextX, nextY));
				}
			}
		}
	}

	static void dfs(int[][] dp, int ans, int xx, int yy, String[] ar, int[][] visited) {
		LinkedList<Point> stack = new LinkedList<>();
		stack.add(new Point(xx, yy));
		while (!stack.isEmpty()) {
			Point p = stack.removeLast();
			int x = p.x;
			int y = p.y;
			if (ar[x].charAt(y) == '*') {
				continue;
			}
			dp[x][y] = ans;
			visited[x][y] = 2;
			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				if (inRange(nextX, nextY, r, c) && visited[nextX][nextY] != 2) {
					stack.add(new Point(nextX, nextY));
				}
			}
		}
	}
	
	

	// --------------- ------- fast input/ouput---------------------------///
	
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
	// -----------------------------fast i/o ends here-------------------------//
}

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
