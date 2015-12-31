import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HeapSort {
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		int[] ar = new int[100];
		int n = fs.nextInt();
		for(int i = 0; i < n; i++) {
			ar[i] = fs.nextInt();
		}
		for(int i = n-1; i >= 0; i--) maxHeap(i,ar,n);
		for(int last = n-1; last>0; last--) {
			ar[0] = (int)returnFirst(ar[last], ar[last]=ar[0]);
			maxHeap(0, ar, last);
		}
		for(int i = 0; i<n; i++) {
			out.print(ar[i]+ " ");
		}
		out.close();
	}
	
	public static boolean inRange(int index, int n) { return index >= 0 && index < n; }
	
	public static void maxHeap(int rootIndex, int[] ar, int n) {
		int leftIndex = 2*rootIndex + 1;
		int rightIndex = 2*rootIndex + 2;
		int maxValueIndex = rootIndex;
		if(inRange(leftIndex, n) && ar[maxValueIndex] < ar[leftIndex]) maxValueIndex = leftIndex;
		if(inRange(rightIndex, n) && ar[maxValueIndex] < ar[rightIndex]) maxValueIndex = rightIndex;
		if(maxValueIndex != rootIndex) {
			ar[maxValueIndex] = (int)returnFirst(ar[rootIndex], ar[rootIndex] = ar[maxValueIndex]);
			maxHeap(maxValueIndex, ar, n);
		}
	}

	// --------------- pre-written class for fast input/ouput---------------------------///
	public static Object returnFirst(Object x, Object y) {
		return x;
	}
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

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
	//-----------------------------fast i/o ends here-------------------------//
}