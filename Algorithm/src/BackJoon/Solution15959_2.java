package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution15959_2 {
	static int dp [][]; 
	static int answer = 0 ; 
	public static void main(String [] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int tc = Integer.parseInt(br.readLine()); 
		StringBuilder sb = new StringBuilder (); 
		while (tc--> 0) {
			int g = Integer.parseInt(br.readLine());
			dp = new int [3][g];
			answer = 0 ; 
			init(); 
			findway(2,g-1);
			answer = dp[dp.length-1][dp[0].length-1]; 
			sb.append(answer).append("\n"); 
		}
		System.out.println(sb.toString()); 
	}
	static void init() {
		for(int i = 0 ; i < dp[0].length; i ++) {
			dp[0][i] = 1 ; 
		}
		for(int i = 0 ; i < dp.length; i ++) {
			dp[i][0] = 1; 
		}
	}
	static void print() {
		for(int i = 0 ; i < dp.length; i ++) {
			for(int j = 0 ; j < dp[0].length; j ++) {
				System.out.print(dp[i][j] + " "); 
			}
			System.out.println(); 
		}
	}
	static void findway(int r, int c ) {
		for(int i = 1 ; i < dp.length ; i ++) {
			for(int j = 1 ; j < dp[0].length; j ++) {
				if(j  == i) dp[i][j] = dp[i-1][j] + 1;
				else if (j-(i + 1)  >= 0) dp[i][j] = dp[i-1][j] + dp[i][j-(i+1)]; 
				else dp[i][j] = dp[i-1][j]; 
			}
		}
	}
}
