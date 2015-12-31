import java.util.ArrayList;
import java.util.Scanner;

public class BobToHome {
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	
	public static void main(String[] args) {
		ArrayList<String> grid = input();
		int[][] visited = new int[grid.size()][grid.get(0).length()];
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < grid.size(); i ++ ) { 
			for(int j = 0; j < grid.get(i).length(); j++) {
				if(grid.get(i).charAt(j) == 'B') {
					result = solve(i,j, grid, visited);
				}
			}
		}
		System.out.println(Integer.MAX_VALUE);
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
		
	public static int solve(int i, int j, ArrayList<String> ar, int[][] visited) {
		int rows = ar.size();
		int columns = ar.get(0).length();
		if(ar.get(i).charAt(j) == 'H') return 0;
		else {
			int distance = Integer.MAX_VALUE;
			visited[i][j] = 1;
			for(int k = 0; k < 4; k++) {
				int next_i = i + dx[k];
				int next_j = j + dy[k];
				if(inGrid(next_i, next_j, rows, columns) && (visited[next_i][next_j] == 0) && ar.get(next_i).charAt(next_j) != 'X') {
					int currentDistance = solve(next_i, next_j, ar, visited);
					if(currentDistance != Integer.MAX_VALUE) {
						distance = Math.min(distance, 1 + currentDistance);
					}
				}
			}
			return distance;
		}
	}
	public static boolean inGrid(int i, int j, int rows, int columns) {
		return i >= 0 && i < rows && j >= 0 && j < columns;
	}
	
	public static ArrayList<String> input() {
		Scanner sc= new Scanner(System.in);
		int n = new Integer(sc.nextLine()).intValue();
		ArrayList<String> grid = new ArrayList<String>();
		for(int i = 0; i < n; i++) {
			String road = sc.nextLine();
			grid.add(road);
		}
		sc.close();
		return grid;
	}
}
