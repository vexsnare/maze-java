import java.util.Arrays;
import java.util.Scanner;

import javax.tools.ToolProvider;

public class LCS {
	static String s1, s2;
	static int[][] memo = new int[55][55];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s1 = sc.nextLine();
		s2 = sc.nextLine();
		for(int i = 0; i < 55; i++) Arrays.fill(memo[i], -1);
		System.out.println(topDown(s1.length()-1, s2.length()-1));
		System.out.println(bottomUp(s1.length(), s2.length()));
	}
	static int topDown(int l1, int l2) {
		if(l1 < 0 || l2 < 0) {
			return 0;
		}
		if(memo[l1][l2] != -1) return memo[l1][l2];
		int ans= Integer.MIN_VALUE;
		ans = Math.max(ans, topDown(l1-1, l2-1) + (s1.charAt(l1) == s2.charAt(l2) ? 1: 0));
		ans = Math.max(ans, topDown(l1-1, l2));
		ans = Math.max(ans, topDown(l1, l2-1));
		return memo[l1][l2] = ans;
	}
	static int bottomUp(int l1, int l2) {
		int [][]dp = new int[l1][l2];
		char [][]track = new char[l1][l2];
		for(int i = 0; i < l1; i++) if(s1.charAt(i) == s2.charAt(0)) { dp[i][0] = 1; track[i][0] = '.';}
		for(int i = 0; i < l2; i++) if(s1.charAt(0) == s2.charAt(i)) { dp[0][i] = 1; track[0][i] = '.'; }
		for(int i = 1; i < l1; i++) {
			for(int j = 1; j < l2; j++) {
				if(dp[i][j-1] > dp[i][j]) { dp[i][j] = dp[i][j-1]; track[i][j] = 'u'; }
				if(dp[i-1][j] > dp[i][j]) { dp[i][j] = dp[i-1][j]; track[i][j] = 'l'; }
				if(dp[i][j] < dp[i-1][j-1] + (s1.charAt(i) == s2.charAt(j) ? 1 : 0)) { dp[i][j] = dp[i-1][j-1] + (s1.charAt(i) == s2.charAt(j) ? 1 : 0); track[i][j] = 'd';} 
			}
		}
		printLCS(track, l1-1, l2-1);
		System.out.println();
		return dp[l1-1][l2-1];
		
	}
	static boolean printLCS(char[][] track, int i, int j) {
		if(i == 0 || j == 0) {
			if(track[i][j] == '.') System.out.print(s1.charAt(i));
			return true;
		}
		if(track[i][j] == 'u') {
			return printLCS(track, i, j-1);
		}
		if(track[i][j] == 'l') {
			return printLCS(track, i-1, j);
		}
		if(track[i][j] == 'd') {
			boolean r = printLCS(track, i-1, j-1);
			if(r && s1.charAt(i) == s2.charAt(j)) {
				System.out.print(s1.charAt(i));
			}
			return r;
		}
		return false;
	}
	

}
