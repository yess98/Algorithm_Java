package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_3085 {
	// 10:30 - 10: 52
	static int N ; 
	static char [][] map ;
	static char [][] copymap ; 
	static int max = -1; 
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		N = Integer.parseInt(br.readLine()); 
		map = new char [N][N]; 
		for(int i = 0 ; i < N ; i ++) {
			String s = br.readLine();
			for(int j = 0 ; j < N ; j ++) {
				map[i][j] = s.charAt(j); 
			}
		}
		for(int i = 0 ; i < N ; i ++) {
			int cnt = 1;; 
			for(int j = 0  ; j < N - 1 ; j ++) {
				if (map[i][j] == map[i][j + 1]) cnt ++; 
				else cnt = 1; 
				max = Math.max(max, cnt); 	
			}
			
		}
		for(int i = 0; i < N ; i ++) {
			int cnt = 1; 
			for(int j =  0 ; j < N -1;  j ++) {
				if (map[j][i] == map[j + 1][i])cnt ++; 
				else cnt = 1; 
				max = Math.max(max, cnt);
			}
		}
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < N; j ++) {
				char c = map[i][j]; 
				for(int k = 0 ; k < 4; k ++) {
					int nx = i + dx[k]; 
					int ny = j + dy[k]; 
					if (nx < 0 || ny < 0 || nx >= N || ny >= N ) continue; 
					if (map[nx][ny] == c) continue; 
					copy(); 
					copymap[i][j] = map[nx][ny]; 
					copymap[nx][ny] = c ; 
					counting(); 
				}
			}
		}
		System.out.println(max); 
	}
	static void copy() { 
		copymap = new char [N][N]; 
		for(int i = 0 ; i < copymap.length ; i ++) {
			copymap[i] = map[i].clone();
		}
	}
	static void counting() {
		for(int i = 0 ; i < N ; i ++) {
			int cnt = 1;; 
			for(int j = 0  ; j < N - 1 ; j ++) {
				if (copymap[i][j] == copymap[i][j + 1]) cnt ++; 
				else cnt = 1; 
				max = Math.max(max, cnt); 	
			}
			
		}
		for(int i = 0; i < N ; i ++) {
			int cnt = 1; 
			for(int j =  0 ; j < N -1;  j ++) {
				if (copymap[j][i] == copymap[j + 1][i])cnt ++; 
				else cnt = 1; 
				max = Math.max(max, cnt);
			}
		}
	}
}
