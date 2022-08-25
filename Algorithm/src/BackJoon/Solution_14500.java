package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_14500 {
	static int N ; 
	static int M ; 
	static int [][] map; 
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	static boolean [][] check; 
	static int max = Integer.MIN_VALUE; 
	
	public static void dfs(int x, int y, int cnt, int n, int sum) {
		if(cnt == n) {
			max = Math.max(max, sum);
			return ; 
		}
		for(int i = 0 ; i < 4; i ++) {
			int nx = x + dx[i]; 
			int ny = y + dy[i]; 
			if (nx < 0 || ny < 0 || nx >= N  || ny >= M) continue; 
			if(!check[nx][ny]) {
				check[nx][ny] = true; 
				dfs(nx,ny,cnt +1, n, sum + map[nx][ny]); 
				check[nx][ny] = false; 
			}
		}
		
	}
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		map = new int [N][M]; 
		check = new boolean [N][M]; 
		for(int i = 0; i < N ; i ++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < M ; j ++) {
				check[i][j] = true; 
				dfs(i,j,1,4,map[i][j]); 
				check[i][j] = false; 
				dfs2(i,j); 
			}
		}
		
		System.out.println(max); 
	}
	public static void dfs2(int x, int y) {
		if (y < M -2 && x < N-1 ) {
			max = Math.max(max, map[x][y] + map[x][y+1] + map[x][y+2] + map[x+1][y+1]); 
		}
		if(x >= 1 && y < M-2) {
			max = Math.max(max, map[x][y] + map[x][y+1] + map[x][y+2] + map[x-1][y+1]); 
		}
		if(x < N -2 && y >= 1) {
			max = Math.max(max, map[x][y] + map[x+1][y] + map[x+2][y] + map[x+1][y-1]); 
		}
		if(x < N- 2 && y < M -1) {
			max = Math.max(max, map[x][y] + map[x+1][y] + map[x+2][y] + map[x+1][y+1]); 
		}
	}
}
