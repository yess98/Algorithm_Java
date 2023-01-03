package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_숨바꼭질2 {
	static int N ; 
	static int K ; 
	static int  [] visited = new int [100001]; 
	static Queue <Integer> queue = new ArrayDeque(); 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken()); 
		Arrays.fill(visited, Integer.MAX_VALUE);
		int answer = 0; 
		int min = Integer.MAX_VALUE;
		visited[N] = 0;
		int step = 0 ; 
		queue.add(N); 
		while (!queue.isEmpty()) {
			int size = queue.size(); 
			step ++;
			for(int i = 0 ; i < size; i ++) {
				int  temp = queue.poll();
				int next = temp -1 ; 
				if(next >= 0 && visited[next] >= step ) {
					visited[next] = step; 
					queue.add(next); 
					if (next == K) answer ++; 
				}
				next = temp +  1;
				if (next <= 100000 && visited[next] >= step) {
					visited[next] = step; 
					queue.add(next); 
					if (next == K) answer ++; 
				}
				next = temp * 2; 
				if (next <= 100000 && visited[next] >= step) {
					visited[next] = step; 
					queue.add(next); 
					if (next == K) answer ++; 
				}
			}
		}
		System.out.println(visited[K]); 
		if (N == K)System.out.println(1); 
		else System.out.println(answer); 
	}
}
