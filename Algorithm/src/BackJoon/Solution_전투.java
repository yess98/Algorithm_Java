package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_전투 {
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	static char [][] map; 
	static boolean [][] visited;
	static boolean [][] visited2; 
	static int N , M; 
	static Queue <int [] >queue = new ArrayDeque<>(); 
	static int pointN, pointM; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); 
		map = new char[N][M]; 
		visited = new boolean [N][M]; visited2 = new boolean [N][M]; 
		for(int i = 0 ; i < N ; i ++) {
			String s =  br.readLine(); 
			for(int j = 0 ; j < M; j ++) {
				map[i][j] = s.charAt(j); 
			}
		}
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < M ; j ++) {
				if (map[i][j] == 'W' && !visited[i][j]) {
					queue.clear();
					queue.add(new int [] {i,j}); 
					visited[i][j] = true;
					bfs('W'); 
				}
				if (map[i][j]== 'B' && !visited2[i][j] ) {
					queue.clear();
					queue.add(new int [] {i,j}); 
					visited2[i][j] = true;
					bfs('B'); 
				}
			}
		}
		System.out.println(pointN +" "+ pointM); 
	}
	public static void bfs (char c ) {
		int count = 0 ; 
		while (!queue.isEmpty()) {
			int [] temp = queue.poll();
			count ++; 
			for(int i = 0 ; i < dx.length; i ++) {
				int nx = dx[i] + temp[0] ; 
				int ny = dy[i] + temp[1]; 
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue; 
				if (map[nx][ny] != c) continue;
				if (c == 'W' && !visited[nx][ny]) {
					queue.add(new int [] {nx,ny}); 
					visited[nx][ny] = true; 
				}
				if (c == 'B' && !visited2[nx][ny]) {
					queue.add(new int [] {nx,ny}); 
					visited2[nx][ny] = true; 
				}
			}
		}
		if (c == 'W') pointN += Math.pow(count, 2); 
		else pointM += Math.pow(count, 2);
	}
}	
