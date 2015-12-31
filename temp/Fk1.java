import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Fk1 {

	static int[][] dp = new int[55][55];
	
	static long toNumber(String s) {
		long ans = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			int shift = s.length() - i - 1;
			if (s.charAt(i) == '1') {
				ans = ans + ((long) 1 << shift);
			}
		}
		return ans;
	}

	static boolean isPowOfFive(long n) {
		while (n % 5 == 0) {
			n /= 5;
		}
		return n == 1;
	}

	static int getmin(String S) {
		for(int i = 0; i < 55; i++) Arrays.fill(dp[i], -1);
		int ans = solve(S, 0, S.length() - 1);
		ans = ans == Integer.MAX_VALUE ? -1 : ans;
		return ans;
	}
	


	static int solve(String s, int i, int j) {
		if(dp[i][j] != -1) return dp[i][j];
		if (isPowOfFive(toNumber(s.substring(i, j + 1))))
			return dp[i][j] = 1;
		int ret = Integer.MAX_VALUE;
		for (int k = i + 1; k < j; k++) {
			if (s.charAt(k) == '1') {
				int x1 = solve(s, i, k - 1);
				if (x1 != Integer.MAX_VALUE) {
					int x2 = solve(s, k, j);
					if (x2 != Integer.MAX_VALUE) {
						ret = Math.min(ret, x1 + x2);
					}
				}
			}
		}
		return dp[i][j] = ret;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final String fileName = in.nextLine();
		System.out.println(getmin(fileName));
	}

}
