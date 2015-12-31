import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class BoardEscape
{
	static int r, c;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static boolean inRange(int i, int j) {
		return i >= 0 && i < r && j >= 0 && j < c;
	}
	public String findWinner(String[] s, int k)
	{
		// after k>4 it would be cycle 3,5,7,9.....same and 4,6,8,10,12,14.....also same
		if(k > 4) k= 4 - k%2;
		r = s.length;
		c = s[0].length();
		int[][][] nimbers = new int[r][c][5];
		for(int K = 1; K <= 4; K++) {
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					if(s[i].charAt(j) == 'E') nimbers[i][j][K] = 0;
					else if(s[i].charAt(j) != '#') {
						Set<Integer> set = new HashSet<>();
						for(int t = 0; t < 4; t++) {
							int next_i = i + dx[t];
							int next_j = j + dy[t];
							if(inRange(next_i, next_j) && s[next_i].charAt(next_j) != '#') {
								set.add(nimbers[next_i][next_j][K-1]);
							}
						}
						int nimber = 0;
						while(set.contains(nimber)) nimber++;
						nimbers[i][j][K] = nimber;
					}
				}
 			}
		}
		int xor = 0;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(s[i].charAt(j) == 'T') {
					xor ^= nimbers[i][j][k];
				}
			}
		}
		
		return xor == 0 ? "Bob" : "Alice";
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, int p1, boolean hasAnswer, String p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}" + "," + p1);
		System.out.println("]");
		BoardEscape obj;
		String answer;
		obj = new BoardEscape();
		long startTime = System.currentTimeMillis();
		answer = obj.findWinner(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p2 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p2);
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
		String p2;
		
		// ----- test 0 -----
		p0 = new String[]{"TE"};
		p1 = 2;
		p2 = "Alice";
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"E#E","#T#","E#E"};
		p1 = 1000000;
		p2 = "Bob";
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"T.T.T.",".E.E.E"};
		p1 = 1;
		p2 = "Alice";
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"TTE"};
		p1 = 6;
		p2 = "Alice";
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"..........................","......TTT..TTT..T...T.....",".....T.....T..T.TT.TT.....","......TTT..TTT..T.T.T.....",".........T.T.T..T...T.....","......TTT..T..T.T...T.....","..........................","...E#E#E#E#E#E#E#E#E#E#...","..........................","......TTT..TTT...TTT......",".....T........T.T.........","......TTT.....T..TTT......",".....T...T...T..T...T.....","......TTT....T...TTT......","..........................","...#E#E#E#E#E#E#E#E#E#E...","..........................","....TT...T...T..T.TTT.T...","...T.....T...T..T.T...T...","...T.TT..T...TTTT.TT..T...","...T..T..T...T..T.T.......","....TT...TTT.T..T.T...T...",".........................."};
		p1 = 987654321;
		p2 = "Bob";
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!