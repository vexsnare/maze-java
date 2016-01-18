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
	

}
