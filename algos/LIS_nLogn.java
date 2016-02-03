import java.awt.Label;
import java.util.Scanner;

public class LIS_nLogn {
	static int[] memo;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 5;
		int[] ar = { 5,4,3,2,16};
		System.out.println(solve(ar));
	}
	static int solve(int[] ar) {
		//int[] trail  = new int[ar.length];
		int[] trailElementIndex = new int[ar.length];
		int[] prev = new int[ar.length];
		trailElementIndex[0] = 0;
		prev[0] = 0;
		int trailLastIndex = 0;
		for(int i = 1; i < ar.length; i++) {
			// binary search can be done here
			int j = bSearch(ar, trailElementIndex, 0, trailLastIndex, ar[i]);
			// storing index of last element in bucket instead of element itself, for tracking sequence this made trail array redundent
			trailElementIndex[j+1] = i;
			prev[i] = j >= 0 ? trailElementIndex[j] : i;
			if(j+1 > trailLastIndex) trailLastIndex = j+1;
		}
		printLIS(prev, ar, trailElementIndex[trailLastIndex]);
		System.out.println();
		return trailLastIndex+1;
	}
	static int bSearch(int[] ar, int[] trailElementIndex, int i, int j, int element) {
		while(i <= j) {
			int m = (i+j)/2;
			if(element > ar[trailElementIndex[m]]) i = m+1;
			else j = m-1;
		}
		return j;
	}
	static void printLIS(int[] prev, int [] ar, int lastIndex) {
		if(prev[lastIndex] == lastIndex) {
			System.out.print(ar[lastIndex] + " ");
			return;
		}
		printLIS(prev, ar, prev[lastIndex]);
		System.out.print(ar[lastIndex] + " ");
	}
}
