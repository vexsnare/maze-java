import java.util.Arrays;
import java.util.Scanner;

public class LIS_dp {
	static int[] memo;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ar = new int[n];
		for(int i = 0; i < n; i++) {
			ar[i]= sc.nextInt();
		}
		System.out.println(Arrays.toString(solve1(ar)));
		
		 memo = new int[ar.length];
		 System.out.println(solve2(ar));
	}
	// bottom - up
	public static int[] solve1(int[] ar) {
		int[] dp = new int[ar.length];
		int[] prev = new int[ar.length];
		for(int i = 0; i < ar.length; i++) prev[i] = i;
		int index = 0;
		int ans = 1;
		Arrays.fill(dp, 1);
		for(int i = 1; i < ar.length; i++) {
			for(int j = 0; j < i; j++) {
				if(ar[i] > ar[j]) {
					if(dp[i] < dp[j] + 1) {
						dp[i] = dp[j]+1;
						prev[i] = j;
					}
				}
			}
			if(ans < dp[i]) {
				index = i;
				ans = dp[i];
			}
		}
		int[] ret = getSeq(ar, prev, ans, index);
		return ret;
	}
	
	public static int[] getSeq(int[] ar, int[] prev, int ans, int index) {
		int [] seq = new int[ans];
		int i = ans-1;
		while(index != prev[index]) {
			seq[i--] = ar[index];
			index = prev[index];
		}
		seq[i] = ar[index];
		return seq;
	}
	
	// top - down recursive
	public static int solve2(int[] ar) {
		int ans = -1;
		for(int i = 0; i < ar.length; i++) {
			ans = Math.max(ans, solve(ar,i));
		}
		return ans;
	}
	
	public static int solve(int [] ar, int i) {
		if(memo[i] != 0) return memo[i];
		if(i == 0) return 1;
		int ret  = 1;
		for(int j = 0; j < i; j++) {
			if(ar[i] > ar[j])
				ret = Math.max(ret, 1 + solve(ar, j));
		}
		return memo[i] = ret;
	}
}
