package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_촌수계산 {
	static int N ; 
	static int [][] map; 
	static int x, y; 
	static int M; 
	static Queue<int []> queue= new ArrayDeque<>(); 
	static boolean [] visited ; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		N = Integer.parseInt(br.readLine());
		map = new int [N + 1][N + 1]; 
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine()); 
		for(int i = 0 ; i < M ; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1; 
			map[b][a] = 1; 
		}
		visited = new boolean [N + 1]; 
		queue.add(new int [] {x, 0});
		visited[x] = true;
		boolean flag = false; 
		int answer = 0 ; 
		while (!queue.isEmpty()) {
			int now[] = queue.poll();
			if(now[0] == y) {
				answer = now[1]; 
				flag = true; 
				break;
			}
			for(int i = 0 ; i <= N ; i ++) {
				if(map[now[0]][i] == 1 && !visited[i]) {
					queue.add(new int [] {i,now[1] + 1}); 
					visited[i] = true; 
				}
			}
		}
		if(!flag)System.out.println(-1); 
		else System.out.println(answer); 
	}
}
