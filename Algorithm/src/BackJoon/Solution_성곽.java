package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_성곽 {
	// 10:40
	// 서 : 1 , 북 : 2, 동 : 4 남 : 8
	static int [][][] map ; 
	static int N ;
	static int M ;
	static int maxCnt = -1; 
	static int maxCnt2 = -1; 
	static boolean [][] visited; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		map = new int [M][N][4]; 
		for(int i = 0 ; i < M ; i ++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j = 0 ; j < N ; j ++) {
				int num = Integer.parseInt(st.nextToken()); 
				for(int k = 0; k < 4; k ++) {
					int bit = num & (1<<k); 
					if (bit > 0 ) { 
						map[i][j][k] = 1;
					}
				}
			}
		}
//		for(int i = 0 ; i < M ; i ++) {
//			for(int j = 0 ; j <  N ; j ++) {
//				System.out.println(Arrays.toString(map[i][j])); 
//			}
//		}
		visited = new boolean [M][N]; 
		int cnt = 0 ; 
		for(int i = 0 ; i < map.length; i ++) {
			for(int j = 0 ; j < map[i].length; j ++) {
				if (!visited[i][j]) { 
					bfs(i,j,0); 
					cnt ++; 
				}
			}
		}
		 
		for(int i = 0 ; i < map.length; i ++) { 
			for(int j = 0 ; j < map[i].length; j ++) { 
				for(int k = 0 ; k < map[i][j].length ; k ++) { 
					if(map[i][j][k] == 1) {
						map[i][j][k] = 0 ;
						visited = new boolean [M][N];
						bfs(i,j,1); 
						map[i][j][k] = 1; 
					}
				}
			}
		}
		System.out.println(cnt); 
		System.out.println(maxCnt); 
		System.out.println(maxCnt2); 
	}
	public static void bfs(int x, int y ,int turn) {
		Queue <int [] > queue = new ArrayDeque <>(); 
		queue.add(new int [] {x,y}) ;
		visited[x][y] = true; 
		int cnt = 0 ; 
		while (!queue.isEmpty()) { 
			int [] temp = queue.poll(); 
			cnt ++; 
			for(int i = 0 ; i < 4; i ++) {
				if (i == 0 ) { 
					int nx = temp[0]; 
					int ny = temp[1] - 1; 
					if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue; 
					if (map[temp[0]][temp[1]][i] == 1) continue; 
					if (visited[nx][ny] == true) continue; 
					visited[nx][ny] = true; 
					queue.add(new int [] {nx,ny}); 
				}
				else if (i == 1) {
					int nx = temp[0] - 1; 
					int ny = temp[1] ; 
					if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue; 
					if (map[temp[0]][temp[1]][i] == 1) continue; 
					if (visited[nx][ny] == true) continue; 
					visited[nx][ny] = true; 
					queue.add(new int [] {nx,ny});
				}
				else if (i == 2) {
					int nx = temp[0]; 
					int ny = temp[1]  + 1; 
					if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue; 
					if (map[temp[0]][temp[1]][i] == 1) continue; 
					if (visited[nx][ny] == true) continue; 
					visited[nx][ny] = true; 
					queue.add(new int [] {nx,ny});
				}
				else if (i == 3) {
					int nx = temp[0] + 1; 
					int ny = temp[1]; 
					if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue; 
					if (map[temp[0]][temp[1]][i] == 1) continue; 
					if (visited[nx][ny] == true) continue; 
					visited[nx][ny] = true; 
					queue.add(new int [] {nx,ny});
				}
			}
			if (turn == 0 ) maxCnt = Math.max(maxCnt, cnt); 
			if (turn == 1) maxCnt2 = Math.max(maxCnt2, cnt); 
		}
		
	}
	
}
