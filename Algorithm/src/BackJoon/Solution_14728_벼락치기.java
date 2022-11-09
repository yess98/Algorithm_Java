package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_14728_벼락치기 {
	static int N ; 
	static int T; 
	static int [][] map;
	static int [] dp; 
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); 
		T = Integer.parseInt(st.nextToken()); 
		map = new int [N ][2]; 
		for(int i =  0; i < N ; i ++) {
			st = new StringTokenizer(br.readLine()); 
			map[i][0] = Integer.parseInt(st.nextToken()); 
			map[i][1] = Integer.parseInt(st.nextToken()); 
		}
		dp  = new int [T + 1]; 
		for(int i = 0 ; i < map.length; i ++) {
			int temp = T - map[i][0]; 
			for(int j = T ; j >=map[i][0] ; j -- ) {
				dp[j] = Math.max(dp[j], dp[j- map[i][0]] + map[i][1]); 
			}
		}
		System.out.println(dp[T]); 
	}
}
