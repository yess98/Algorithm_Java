package BackJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5427_불{
	static int w; 
	static int h ; 
	static char [][] map;
	static int blank; 
	static ArrayList <int []> fire; 
	static int startx;static int  starty; 
	static StringBuilder sb = new StringBuilder(); 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int tc = Integer.parseInt(br.readLine()); 
		for(int t = 1; t <= tc; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			w = Integer.parseInt(st.nextToken()); 
			h = Integer.parseInt(st.nextToken()); 
			map = new char[h][w];
			blank = 0 ; 
			fire = new ArrayList <>(); 
			for(int i = 0 ; i < h ; i ++) {
				String s = br.readLine(); 
				for(int j = 0 ; j < w; j ++) {
					map[i][j] = s.charAt(j); 
					if (map[i][j] == '.') blank ++; 
					if (map[i][j] == '*') {
						fire.add(new int[] {i,j}); 
					}
					if (map[i][j] == '@') {
						startx = i; 
						starty = j ; 
						blank ++; 
					}
				}
			}
			bfs(); 
		}

		System.out.println(sb.toString()); 
	}
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	
	public static void bfs() {
		Queue <int []> queue = new ArrayDeque<>(); 
		for(int i = 0 ; i < fire.size();i ++) {
			queue.add(fire.get(i)); 
		}
		queue.add(new int [] {startx, starty}); 
		boolean flag = false; 
		boolean impossible = false; 
		int size = fire.size();
		int size2 = 1; 
		int answer= 0 ; 
		loop: while (true) {
			answer ++; 
			int cnt1 = 0 ; 
			if (blank == 0) {
				impossible = true; 
				break loop; 
			}
			for(int s = 0 ; s < size; s ++) {
				
				int [] temp = queue.poll();
					// 불일때
					for(int i = 0 ; i < dx.length ; i ++) {
						int nx = temp[0] + dx[i]; 
						int ny = temp[1] + dy[i]; 
						if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue; 
						if (map[nx][ny] == '#') continue; 
						if (map[nx][ny] == '.' || map[nx][ny] == '@') {
							queue.add(new int [] {nx,ny}); 
							cnt1 ++; 
							map[nx][ny] = '*'; 
							blank --; 
							
						}
					
					}
				}
			size = cnt1; 
			int cnt2 = 0 ; 
			if (size2 == 0 ) {
				impossible  = true; 
				break loop; 
				
			}
			for(int s = 0 ; s < size2; s ++) {
				int temp [] = queue.poll();
				for(int i = 0 ; i < dx.length; i ++) {
					int nx = temp[0] + dx[i]; 
					int ny = temp[1] + dy[i]; 
					if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
						flag = true; 
						break loop; 
					}
					if (map[nx][ny] == '.') {
						queue.add(new int [] {nx,ny}); 
						cnt2 ++; 
						map[nx][ny] = '@'; 
					}
				}
			}
			size2 = cnt2; 
		}
		if (flag) {
			sb.append(answer).append("\n"); 
		}
		else if (impossible) {
			sb.append("IMPOSSIBLE").append("\n"); 
		}
		
	}
}
