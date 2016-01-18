import java.util.Comparator;
import java.util.PriorityQueue;

class NodeT implements Comparable<NodeT>{
	int x, y;
	NodeT(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(NodeT o) {
		return this.x - o.x;
	}
	public String toString() {
		return "{"+this.x+","+this.y+"}";
	}
}

public class PairExample {
	
	static int r, c;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static boolean inRange(int i, int j) {
		return i >= 0 && i < r && j >= 0 && j < c;
	}
	
	public static void main(String[] args) {
		PriorityQueue<NodeT> pq = new PriorityQueue<NodeT>();
		pq.add(new NodeT(3,4));
		pq.add(new NodeT(5,6));
		pq.add(new NodeT(11,2));
		while(!pq.isEmpty()) {
			System.out.println(pq.remove());
		}
	}
	
	public boolean isPalin(int n) {
		String s = String.valueOf(n);
		boolean res = false;
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		}
		return true;
	}
	
	public boolean isPrime(int n) {
		if (n == 2)
			return true;
		if (n == 1 || n % 2 == 0)
			return false;
		for (int i = 3; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
	
	
}
class VertexT{
	int x;
	int y;
	VertexT(int x,int y){
		this.x = x;
		this.y = y;
	}
	@Override

	public String toString() {
		return "{"+this.x+","+this.y+"}";
	}
}

class comparator implements Comparator<VertexT> {

	@Override
	public int compare(VertexT o1, VertexT o2) {
		// TODO Auto-generated method stub
		return o1.x - o2.x;
	}
}

class PairT implements Comparable<PairT>{
	int x, y;
	PairT(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(PairT o) {
		return this.x - o.x;
	}
	public String toString() {
		return "{"+this.x+","+this.y+"}";
	}
}
