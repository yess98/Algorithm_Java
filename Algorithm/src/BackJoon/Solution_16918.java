package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_16918 {
	static int R,C,N; 
	static char [][] map; 
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	static ArrayList<int []> al; 
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		R = Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken()); 
		map = new char [R][C]; 
		al  = new ArrayList<>(); 
		for(int i = 0 ; i < R; i ++) {
			String s = br.readLine(); 
			for(int j = 0 ; j < C; j ++) {
				map[i][j] = s.charAt(j); 
			}
		}

		dfs(1,N); 
		print(); 
	}
	public static void print() { 
		for(int i =0 ; i < map.length; i ++) {
			for(int j = 0 ; j < map[0].length; j ++) {
				System.out.print(map[i][j]);
			}
			System.out.println(); 
		}
		System.out.println(); 
	}
	public static void dfs(int cnt, int N ) {
		if(cnt == N) {
			return; 
		}
		if(cnt % 2 != 0 ) {
			map = setBomb(map);
			dfs(cnt + 1, N); 
		}
		else {
			explode();
			dfs(cnt + 1, N); 
		}
	}
	public static char [][] setBomb (char [][] map) {
		for(int i = 0 ; i < map.length; i ++) {
			for(int j = 0 ; j < map[0].length; j ++) {
				if(map[i][j] == 'O') { 
					al.add(new int[] {i,j}); 
				}
				if(map[i][j] == '.') {
					map[i][j] = 'O';
				}
			}
		}
		return map; 
	}
	public static void explode() { 
		for(int i = 0 ; i < al.size(); i ++) {
			int [] point = al.get(i); 
			map[point[0]][point[1]] = '.'; 
			for(int d = 0 ; d < dx.length; d++) {
				int nx = point[0] + dx[d]; 
				int ny = point[1] + dy[d]; 
				if(nx <0 || ny < 0 || nx >= R || ny >= C) continue; 
				map[nx][ny] = '.';
			}
		}
		al.clear();
		for(int i = 0 ; i < al.size(); i ++) {
			System.out.println(Arrays.toString(al.get(i)));
		}
	}
	
	
}
