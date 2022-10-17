package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_17086 {
	static int [][] map ; 
	static int row; 
	static int col; 
	static int [] dx = {1,-1,0,0,1,-1,1,-1}; 
	static int [] dy = {1,-1,1,-1,-1,1,0,0};
	static int max = Integer.MIN_VALUE; 
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		row = Integer.parseInt(st.nextToken()); 
		col = Integer.parseInt(st.nextToken()); 
		map = new int [row][col]; 
		for(int i = 0 ; i < row; i ++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j = 0 ; j < col; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		for(int i = 0 ; i < row; i ++) {
			for(int j = 0 ; j < col; j ++) {
				if(map[i][j] == 0) {
					bfs(i,j); 
				}
			}
		}
		System.out.println(max); 
	}
	
	public static void bfs(int r, int c) {
		Queue <int [] >queue = new ArrayDeque<>();
		queue.add(new int[] {r,c});
		int cnt = 0 ; 
		loop : while (!queue.isEmpty()) {
			int size = queue.size();
			while (size --> 0){
				int now[] = queue.poll();
				if(map[now[0]][now[1]] == 1) { 
					max = Math.max(max, cnt); 
					break loop; 
				} 
				for(int i = 0 ; i < dx.length; i ++) {
					int nx = dx[i] + now[0]; 
					int ny = dy[i] + now[1]; 
					if(nx < 0 || ny < 0 || nx >= row || ny >= col) continue; 
					if(map[nx][ny] != -1 ) {
						queue.add(new int[] {nx,ny}); 
						map[now[0]][now[1]] = -1; 
					}
				}
			}
			cnt ++; 
		}
		for(int i = 0 ; i < row; i ++) {
			for(int j = 0 ; j < col; j ++) {
				if(map[i][j] == -1 ) map[i][j] = 0; 
			}
		}
	}
}
