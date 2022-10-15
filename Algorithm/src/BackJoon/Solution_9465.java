package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9465 {
	static int [][] map; 
	static int [][] dp; 
	public static void main(String [] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int t = Integer.parseInt(br.readLine()); 
		StringBuilder sb = new StringBuilder(); 
		while (t-->0) {
			int n = Integer.parseInt(br.readLine()); 
			StringTokenizer st ;
			map = new int[2][n]; 
			dp = new int[2][n]; 
			for(int i = 0 ; i < 2; i ++) {
				st = new StringTokenizer(br.readLine()); 
				for(int j = 0 ; j < n ; j ++) {
						map[i][j] = Integer.parseInt(st.nextToken());
					}
			}
			dp(); 
			sb.append(Math.max(dp[0][n-1],dp[1][n-1]));
			sb.append("\n"); 
		}
		System.out.println(sb.toString()); 
	}
	static void dp() {
		dp[0][0] = map[0][0];
		dp[1][0] = map[1][0]; 
		dp[0][1] = map[1][0] + map[0][1]; 
		dp[1][1] = map[0][0] + map[1][1]; 
 		for(int i = 2 ; i < map[0].length ; i ++) {
			dp[0][i] = Math.max(dp[1][i-2] + map[0][i],Math.max(dp[1][i-1] + map[0][i], dp[0][i-2] + map[0][i])); 
			dp[1][i] = Math.max(dp[0][i-2] + map[1][i], Math.max(dp[0][i-1] + map[1][i], dp[1][i-2] + map[1][i]));
		}
// 		for(int i = 0 ; i < dp.length; i ++) {
// 			System.out.println(Arrays.toString(dp[i])); 
// 			
// 		}
	}
}
