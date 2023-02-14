package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_빵집 {
	// 2:00
	static int R; 
	static int C; 
	static char [][] map; 
	static int [] dx = { 0, -1, 1};
	static int [] dy = { 1, 1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		R = Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken()); 
		map = new char[R][C]; 
		for(int i = 0 ; i < R; i ++) {
			String s  = br.readLine();
			for(int j = 0 ; j < C; j ++) {
				map[i][j] = s.charAt(j);  
			}
		}
		int answer = 0 ; 
		for(int i = 0 ; i < R; i ++) {
			if (dfs(i, 0)) {
				answer ++;
				// print(); 
			}
		}
		System.out.println(answer); 
	}
	public static void print () { 
		for(int i = 0 ; i < R; i ++) {
			for(int j = 0 ; j < C; j ++) {
				System.out.print(map[i][j] + " "); 
			}
			System.out.println(); 
		}
		System.out.println("==========");
	}
	public static boolean  dfs (int x, int y ) {
		map[x][y]  = '-'; 
		if (y == C -1 ) { 
			return true;
		}
		if (y + 1 < C && x -1 >= 0 && map[x - 1][y + 1] == '.') { 
			if (dfs(x- 1, y + 1)) return true; 
		}
		if (y + 1 < C && map[x][y + 1] == '.') { 
			if (dfs(x , y + 1)) return true; 
		}
		if (y +  1 < C && x + 1 < R && map[x + 1][y + 1] == '.') { 
			if (dfs(x + 1, y + 1)) return true; 
		}
		
		return false; 
	}
	
}
