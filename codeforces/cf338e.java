import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * CodeForces : 338
 * 
 * @author vinaysaini E. Hexagons
 */
public class cf338e {

	static int dx[] = { 1, -1, -2, -1, 1, 2, 1 };
	static int dy[] = { 2, 2, 0, -2, -2, 0, 2 };

	public static void main(String[] args) {
		long x = 0, y = 0;

		long n = in.nextLong();
		long ringNumber = getRing(n);
		long stepsUpTo = 3 * ringNumber * ringNumber + 3 * ringNumber;
		x = 2 * ringNumber;
		long remainingSteps = n - stepsUpTo;
		if (remainingSteps > 0) {
			x = x + dx[0];
			y = y + dy[0];
			remainingSteps--;
		}
		for(int i = 1; i <= 6 && remainingSteps > 0; i++) {
			long r = (i == 1 || i == 6 ? ringNumber: ringNumber+1);
			long move = r > remainingSteps ? remainingSteps: r;
			x += dx[i]*move;
			y += dy[i]*move;
			remainingSteps -= move;
		}

		out.println(x + " " + y);
		out.close();
	}

	static long getRing(long n) {
		long l = 0;
		long r = (long) 1e9;
		while (l < r) {
			long m = (l + r) / 2;
			long sum = 3 * m * m + 3 * m;
			if (n < sum) {
				r = m;
			} else
				l = m + 1;
		}
		return l - 1;
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
