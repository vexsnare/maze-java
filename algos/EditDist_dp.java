import java.util.Scanner;

public class EditDist_dp {
	static String str1 = "";
	static String str2 = "";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str1 = sc.nextLine();
		str2 = sc.nextLine();
		System.out.println(solve(str1.length()-1, str2.length()-1));
		System.out.println(solve2());
	}
	static int solve(int i, int j) {
		if(i < 0) return j+1;
		if(j < 0) return i+1;
		if(str1.charAt(i) == str2.charAt(j)) return solve(i-1, j-1);
		else {
			return Math.min(1+solve(i, j-1), Math.min(1 + solve(i-1, j-1), 1+solve(i-1, j)));
			
		}
	}
	static int solve2() {
		int l1 = str1.length();
		int l2 = str2.length();
		int [][]dp = new int[l1][l2];
		boolean match = false;
		for(int i = 0; i < l1; i++) {
			if(str1.charAt(i) == str2.charAt(0)) match = true;
			dp[i][0] = match ? i : i +1;
		}
		match = false;
		for(int i = 0; i < l2; i++) {
			if(str1.charAt(0) == str2.charAt(i)) match = true;
			dp[0][i] = match ? i : i +1;
		}
		for(int i = 1; i < l1; i++) {
			for(int j = 1; j < l2; j++) {
				if(str1.charAt(i) == str2.charAt(j)) dp[i][j] = dp[i-1][j-1];
				else {
					int v = Integer.MAX_VALUE;
					v = Math.min(v, 1 + dp[i-1][j]);
					v = Math.min(v, 1 + dp[i][j-1]);
					v = Math.min(v, 1 + dp[i-1][j-1]);
					dp[i][j] = v;

				}
			}
		}
		return dp[l1-1][l2-1];
	}
	
}
