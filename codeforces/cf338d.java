import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 * Product of devisors
 * d(a*b) = d(a) * d(b)
 * x = a * b
 * f(a*b) = f(a)^d(b)*f(b)^d(a)
 */
public class cf338d {

	static int mod = (int)1e9+7;
	public static void main(String[] args) {
		int n = in.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			int key = in.nextInt();
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+1);
			} else {
				map.put(key, 1);
			}
		}
		long ans = 1;
		long da = 1;
		for(int key: map.keySet()) {
			int x = key;
			int p = map.get(key);
			long fb = pow(x,((long)p*(p+1))/2, mod);
			ans = (pow(ans,p+1,mod) * pow(fb,da,mod))%mod;
			da = (da * (p+1))%(mod -1);
		}
		out.println(ans);
		out.close();
	}

	static long pow(long n, long p, int mod) {
		if(p == 0) return 1;
		long ans = pow(n, p/2, mod);
		ans = ((long)ans * ans)%mod;
		if(p % 2 != 0) {
			ans = (ans * n)%mod;
		}
		return ans;
	}
	static long gcd(long a, long b ) {
		if(a == 0) return b;
		return gcd(b%a,a);
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
