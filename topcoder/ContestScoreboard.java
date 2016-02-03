import java.util.ArrayList;
import java.util.Collections;

class Node implements Comparable<Node>{
	int x, y;
	String z;
	Node(int x, int y, String z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	public int compareTo(Node o) {
		return this.y - o.y;
	}
	public String toString() {
		return "{"+this.x+","+this.y+"}";
	}
}
public class ContestScoreboard
{
	int n;
	String[] names;
	ArrayList<ArrayList<Node>> points;

	public int[] findWinner(String[] scores)
	{
		this.n = scores.length;
		int [] ret = new int[scores.length];
		this.names = new String[n];
		this.points = new ArrayList<ArrayList<Node>>(n);
		for(int i = 0; i < n; i++) {
			this.points.add(new ArrayList<Node>());
		}
		for(int i = 0; i < n; i++) {
			String s = scores[i];
			String [] temp = s.split(" ");
			names[i] = temp[0];
			for(int j = 1; j < temp.length; j++) {
				String[] xy = temp[j].split("/");
				Integer x = Integer.parseInt(xy[0]);
				Integer y = Integer.parseInt(xy[1]);
				points.get(i).add(new Node(x,y,temp[0]));
			}
		}
		for(int i = 0; i < n; i++) {
			 Collections.sort(points.get(i));
		}
		int h = 0;
		for(int i = 1; i < n; i++) {
			if(names[i].compareTo(names[h]) < 0) h = i;
		}
		
		for(int i = 0; i < n; i++) {
			int point = 0;
			int time = 0;
			boolean won = false;
			for(int j = 0; j < points.get(i).size(); j++) {
				Node nd = points.get(i).get(j);
				time = nd.y;
				point += nd.x;
				String name = nd.z;
				boolean highest = true;
				for(int k = 0; k < n; k++) {
					if(k != i) {
						int tpoint = 0;
						String tName = null;
						for(int l = 0; l < points.get(k).size(); l++) {
							Node nd1 = points.get(k).get(l);
							tName = nd1.z;
							if(nd1.y <= time) tpoint += nd1.x;
							else break;
						}
						if(tpoint > point) highest = false;
						else if(tpoint == point && tName.compareTo(name) < 0) {
							highest = false;
						}
						
					}
				}
				if(highest) won = true;
			}
			ret[i] = won ? 1: 0;
			
		}
		ret[h] = 1;
		return ret;
		
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, int[] p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		ContestScoreboard obj;
		int[] answer;
		obj = new ContestScoreboard();
		long startTime = System.currentTimeMillis();
		answer = obj.findWinner(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.print("\t" + "{");
			for (int i = 0; p1.length > i; ++i) {
				if (i > 0) {
					System.out.print(",");
				}
				System.out.print(p1[i]);
			}
			System.out.println("}");
		}
		System.out.println("Your answer:");
		System.out.print("\t" + "{");
		for (int i = 0; answer.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(answer[i]);
		}
		System.out.println("}");
		if (hasAnswer) {
			if (answer.length != p1.length) {
				res = false;
			} else {
				for (int i = 0; answer.length > i; ++i) {
					if (answer[i] != p1[i]) {
						res = false;
					}
				}
			}
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
		int[] p1;
		
		// ----- test 0 -----
		p0 = new String[]{"TVG 1/1 1/2 1/3","AJI 1/4 1/5 1/6"};
		p1 = new int[]{1,1};
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"GLP 1/114 1/195 1/171 1/19 1/146 1/29","BKPF 1/57 1/187 1/277 1/21 1/223 1/35"};
		p1 = new int[]{1,1};
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"AAA 248/2 495/5 993/7","BBB 244/6 493/7 990/10","CCC 248/2 495/5 993/10"};
		p1 = new int[]{1,0,0};
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"UBA 10/2 30/4 25/3 999/1000","UNC 1/3 3/20 40/50","UNLP 2/2 3/3 4/4 100/100","UNR 999/1000000 999/999999","UNS 999/100000000"};
		p1 = new int[]{1,0,1,1,0};
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
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