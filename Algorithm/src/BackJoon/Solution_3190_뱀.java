package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_3190_뱀 {
	static int [] dx = {0,1,0,-1};
	static int [] dy = {1,0,-1,0};
	static int N ; 
	static int map [][]; 
	static boolean [][] visited; 
	static Queue <int []>  queue = new ArrayDeque<>(); 
	static ArrayList < int [] > al = new ArrayList <>(); 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		N = Integer.parseInt(br.readLine()); 
		map = new int [N][N];
		visited = new boolean [N][N]; 
		int K = Integer.parseInt(br.readLine()); 
		StringTokenizer st ; 
		for(int i = 0 ; i < K ; i ++ ) {
			st = new StringTokenizer(br.readLine()); 
			map[Integer.parseInt(st.nextToken()) -1 ][Integer.parseInt(st.nextToken()) -1] = 1; 
		}
		int d = Integer.parseInt(br.readLine()); 
		for(int i = 0 ; i < d; i ++) {
			st = new StringTokenizer(br.readLine()); 
			int time = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0); 
			if(c == 'D')
				queue.add(new int [] {time, 2});
			else queue.add(new int [] {time, 3});
		}
		al.add(new int [] {0,0}); 
		int time = 0 ; 
		int dir = 0;
		int headx = 0; 
		int heady = 0; 
		visited[headx][heady] = true; 
		while (true) { 
			time ++;
			int nx = headx + dx[dir]; 
			int ny = heady + dy[dir]; 
			if (nx < 0 || ny < 0 || nx >= N || ny >= N ) break;
			if (visited[nx][ny] == true) break; 
			if (map[nx][ny] == 1 ) {
				map[nx][ny] = 0 ;
				visited[nx][ny] = true; 
				al.add(new int [] {nx,ny}); 
			}
			else if (map[nx][ny] == 0 ) {
				int [] pos = al.get(0);
				visited[pos[0]][pos[1]] = false; 
				al.add (new int [] {nx,ny}); 
				visited[nx][ny] = true; 
				al.remove(0); 
				
			}
			headx = nx; 
			heady = ny;
			if (!queue.isEmpty()) { 
				int [] peek = queue.peek(); 
				if (peek[0] == time) {
					if (peek[1] == 2) {
						// 오른쪽 
						dir = (dir + 1) % 4; 
					}
					else {
						dir = dir - 1; 
						if (dir == -1 ) dir = 3; 
					}
					queue.poll();
				}
			}
			
		}
		
		System.out.println(time); 
		
	}
}
