import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
	int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Point o) {
		return this.x - o.x;
	}
	public String toString() {
		return "{"+this.x+","+this.y+"}";
	}
}

public class FbHackerCupQBoomerang {
	
	public static void main(String[] args) {
		int T = in.nextInt();
		for(int t = 1; t <= T; t++) {
			long ans = 0;
			int n = in.nextInt();
			List<Point> stars = new ArrayList<>(n);
			for(int i = 0; i < n; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				stars.add(new Point(x, y));
			}
			for(int i = 0; i < n; i++) {
				HashMap<Long, Integer> map = new HashMap<>();
				for(int j = 0; j < n; j++) {
					if(i != j) {
						Long dist = Long.valueOf(getDistance(stars.get(i), stars.get(j)));
						if(map.containsKey(dist)) {
							map.put(dist, map.get(dist)+1);
						} else map.put(dist, 1);
					}
				}
				for(long k: map.keySet()) {
					int v = map.get(k);
					if(v >= 2) {
						ans += nC2(v);
					}
				}
			}
			printAns(t, ans);
		}
		out.close();
	}

	static void printAns(int t, long ans) {
		out.println("Case #"+t+": " +ans);
	}
	static long getDistance(Point p1, Point p2) {
		long x = Math.abs(p1.x - p2.x);
		long y = Math.abs(p1.y - p2.y);
		return x*x + y*y;
	}
	static long nC2(int n) {
		return ((long)n*(n-1))/2;
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
