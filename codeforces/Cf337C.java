import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Cf337C {
	public static void main(String[] args) {
		int n = in.nextInt();
		int[] ar = new int[n];
		for(int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		
		int min = getMin(ar, n);
		
		long ans = (long)n * min;
		//System.out.println(ans);
		int maxBlock = 0;
		int [] visited = new int[n];
		int currentIndex = 0;
		int count = -1;
		while(visited[currentIndex] == 0) {
			if(ar[currentIndex] == min) {
				visited[currentIndex] = 1;
				maxBlock = Math.max(maxBlock, count);
				count = 0;
			} 
			if(count != -1) {
				if(ar[currentIndex] != min) count++;
			}
			currentIndex++;
			currentIndex %= n;
		}
		if(count != -1) {
			maxBlock = Math.max(maxBlock, count);
		}
		
		out.println(ans + maxBlock);
		out.close();
	}
	
	static int getMin(int[] ar, int n) {
		int ret = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) ret = Math.min(ret, ar[i]);
		return ret;
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
