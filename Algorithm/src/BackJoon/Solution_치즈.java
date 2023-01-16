package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_치즈 {
	static boolean [][][] map; 
	static int N ; 
	static int M ; 
	static int [][] cheese;
	static int cnt = 0 ; 
	static boolean [][] visited ; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		map = new boolean [N][M][4]; 
		cheese  = new int [N][M];
		visited = new boolean [N][M]; 
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j ++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if(cheese[i][j] == 1) cnt ++; 
			}
		}
		int answer = 0 ; 
		loop : while (true ) {
			if (cnt == 0)  break;
			visited = new boolean [N][M];
			map = new boolean [N][M][4]; 
			bfs(0,0);
			answer ++; 
		}
		System.out.println(answer); 
		
	}
	static Queue <int []> queue = new ArrayDeque<>();
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	
	public static void bfs(int x, int y ) {
		queue.add(new int [] {x,y}); 
		visited[x][y] = true; 
		while (!queue.isEmpty()) { 
			int temp[] = queue.poll(); 
			for(int i = 0 ;i < dx.length ; i ++) {
				int nx = temp[0] + dx[i]; 
				int ny = temp[1] + dy[i]; 
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue; 
				if (cheese[nx][ny] == 1 && !map[nx][ny][i]) { 
					map[nx][ny][i] = true; 
				}
				if (cheese[nx][ny] == 0 && !visited[nx][ny]) {
					visited[nx][ny] = true; 
					queue.add(new int [] {nx,ny}); 
				}
			}
		}
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < M; j ++) {
				int temp =0 ; 
				for(int k = 0 ; k < 4; k ++) {
					if (map[i][j][k]) temp ++; 
				}
				if (temp >= 2) {
				//	System.out.println(i + "," + j); 
					cheese[i][j] = 0; 
					cnt --; 
				}
			}
		}
		// System.out.println(cnt); 
	}
}
