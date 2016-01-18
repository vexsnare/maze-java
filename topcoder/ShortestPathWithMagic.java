import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
/*
 *      Single Round Match 675 Round 1 - Division II, Level Two
 */
class Touple implements Comparable<Touple> {
	int value;
	int dist;
	int portion;

	Touple(int v, int d, int p) {
		this.value = v;
		this.dist = d;
		this.portion = p;
	}
	public int compareTo(Touple o) {
		return this.dist < o.dist ? -1 : 1;
	}

}

public class ShortestPathWithMagic {
	static int r, c;

	boolean inRange(int i, int j) {
		return i >= 0 && i < r && j >= 0 && j < c;
	}

	public double getTime(String[] dist, int k)
	{
		r = dist.length;
		c = dist[0].length();
		int[] visited = new int[r];
		PriorityQueue<Touple> pq = new PriorityQueue<>();
		pq.add(new Touple(0, 0, k));
		double result = 0.0;
		while(!pq.isEmpty()) {
			Touple current = pq.remove();
			if(current.value == 1) {
				result = current.dist;
				break;
			}
			visited[current.value] = 1;
			for(int i = 0; i < r; i++) {
				if(i != current.value && visited[i] == 0) {
					pq.add(new Touple(i, current.dist + 2*(dist[current.value].charAt(i)-'0'), k));
					if(current.portion>0)pq.add(new Touple(i, current.dist + (dist[current.value].charAt(i)-'0'), k-1));
				}
			}
		}
		return result/2.0;
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, int p1, boolean hasAnswer, double p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}" + "," + p1);
		System.out.println("]");
		ShortestPathWithMagic obj;
		double answer;
		obj = new ShortestPathWithMagic();
		long startTime = System.currentTimeMillis();
		answer = obj.getTime(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p2);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == answer && Math.abs(p2 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p2));
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
		} else if ((endTime - startTime) / 1000.0 >= 2) {
			System.out.println("FAIL the timeout");
			res = false;
		} else if (hasAnswer) {
			System.out.println("Match :-)");
		} else {
			System.out.println("OK, but is it right?");
		}
		System.out.println("");
		return res;
	}

	public static void main(String[] args) {
		boolean all_right;
		all_right = true;

		String[] p0;
		int p1;
		double p2;

		// ----- test 0 -----
		p0 = new String[] { "0919", "9091", "1904", "9140" };
		p1 = 1;
		p2 = 4.0D;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = new String[] { "094", "904", "440" };
		p1 = 2;
		p2 = 4.0D;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = new String[] { "094", "904", "440" };
		p1 = 50;
		p2 = 4.0D;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = new String[] { "094", "904", "440" };
		p1 = 0;
		p2 = 8.0D;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = new String[] { "076237", "708937", "680641", "296059", "334508", "771980" };
		p1 = 1;
		p2 = 3.5D;
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = new String[] { "00", "00" };
		p1 = 50;
		p2 = 0.0D;
		all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
		// ------------------

		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// END KAWIGIEDIT TESTING
}
// Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
