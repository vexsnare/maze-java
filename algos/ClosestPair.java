import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public long dist(Point p) {
		return (this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y);
	}
}

class CompareByX implements Comparator<Point> {
	@Override
	public int compare(Point o1, Point o2) {
		// TODO Auto-generated method stub
		return o1.x - o2.x;
	}
}

class CompareByY implements Comparator<Point> {
	@Override
	public int compare(Point o1, Point o2) {
		// TODO Auto-generated method stub
		return o1.y - o2.y;
	}
}

public class ClosestPair {

	static Point[] Px;
	static Point[] Py;

	public static void main(String[] args) {
		int n = in.nextInt();
		int x, y;
		Px = new Point[n];
		Py = new Point[n];
		for (int i = 0; i < n; i++) {
			x = in.nextInt();
			y = in.nextInt();
			Point p = new Point(x, y);
			Px[i] = p;
			Py[i] = p;
		}
		Arrays.sort(Px, new CompareByX());
		Arrays.sort(Py, new CompareByY());
		long shortestDist = getClosestPairDistance(0, n-1, Py);
		System.out.println(Math.sqrt(shortestDist));
	}

	static long getClosestPairDistance(int ri, int rj, Point[] Py) {
		if (rj - ri <= 2) {
			long dist = Long.MAX_VALUE;
			for (int i = ri; i <= rj; i++) {
				for (int j = i + 1; j <= rj; j++) {
					dist = Math.min(dist, Px[i].dist(Px[j]));
				}
			}
			return dist;
		}
		int m = (ri + rj) / 2;
		Point midPoint = Px[m];
		Point[] Pyl = new Point[m + 1];
		int l = 0, r = 0;
		Point[] Pyr = new Point[rj - m];
		for (int i = ri; i <= rj; i++) {
			if (Py[i].x <= midPoint.x)
				Pyl[l++] = Py[i];
			else
				Pyr[r++] = Py[i];
		}
		long dl = getClosestPairDistance(ri, m, Pyl);
		long dr = getClosestPairDistance(m + 1, rj, Pyr);
		long d = Math.min(dl, dr);
		ArrayList<Point> strip = new ArrayList<>();
		for(int i = ri; i <= rj; i++) {
			if(Math.abs(Py[i].x - midPoint.x) <= d) {
				strip.add(Py[i]);
			}
		}
		for(int i = 0; i < strip.size(); i++) {
			for(int j = i+1; j < strip.size() ; j++) {
				if(strip.get(i).dist(strip.get(j)) < d) {
					d = strip.get(i).dist(strip.get(j));
				}
			}
		}
		return d;
	}
	// --------------- ------fast input/ouput---------------------------///

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

	// -----------------------------fast i/o ends
	// here-------------------------//
}
