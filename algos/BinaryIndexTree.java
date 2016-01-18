import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class BIT {
	int[] bit;
	int getNextIndex(int n) {
		return n + (n & -n);
	}
	int getParentIndex(int n) {
		return n - (n & -n);
	}
	void updateBit(int pos, int value) {
		while(pos < bit.length) {
			bit[pos] += value;
			pos = getNextIndex(pos);
		}
	}
	// constructor to create Binary Indexed tree - an array of size+1
	BIT(int[] ar) {
		bit = new int[ar.length+1];
		for(int i = 0; i < ar.length; i++) {
			updateBit(i+1, ar[i]);
		}
	}
	public int getSumUpToIndex(int index) {
		index += 1;
		int sum = 0;
		while (index > 0) {
			sum += bit[index];
			index = getParentIndex(index);
		}
		return sum;
	}
	void updateArray(int index, int diff) {
		updateBit(index+1, diff);
	}
}
public class BinaryIndexTree {
	public static void main(String[] args) {
		int ar[] = {1,2,3,4,5,6,7};
		BIT bt = new BIT(ar);
		assert 1 == bt.getSumUpToIndex(0);
		assert 3 == bt.getSumUpToIndex(1);
		assert 6 == bt.getSumUpToIndex(2);
		assert 10 == bt.getSumUpToIndex(3);
		assert 15 == bt.getSumUpToIndex(4);
		assert 21 == bt.getSumUpToIndex(5);
		//System.out.println(bt.getSumUpToIndex(6));
		assert 28 == bt.getSumUpToIndex(6): "Matching Error";
	}
	// --------------- ------fast input/ouput---------------------------///
	
	
	
		public static Object returnFirst(Object x, Object y) {
			return x;
		}
		public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		public static FastScanner in  = new FastScanner();

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
	

}
