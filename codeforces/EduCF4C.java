import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class EduCF4C {
	public static void main(String[] args) {
		String s = in.next();
		char[] ar = s.toCharArray();
		LinkedList<Character> stack = new LinkedList<Character>();
		int ans = 0;
		try {
			for (int i = 0; i < ar.length; i++) {
				if (isOpeningType(ar[i])) {
					stack.add(ar[i]);
				} else {
					char c = stack.removeLast();
					if (!isRespective(c,ar[i])) {
						ans++;
					}
				}
			}
			if(!stack.isEmpty()) throw new IllegalArgumentException();
			out.println(ans);
		} catch (Exception e) {
			out.println("Impossible");
		}

		out.close();
	}

	public static boolean isOpeningType(char c) {
		return c == '<' || c == '[' || c == '(' || c == '{';
	}

	public static boolean isRespective(char a, char b) {
		return (a == '<' && b == '>') || (a == '[' && b == ']') || (a == '(' && b == ')') || (a == '{' && b == '}');
	}

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
}

class Bracket {
	char c;

	Bracket(char c) {
		this.c = c;
	}
}
