package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_퇴사2 {
	static int dp []; 
	static int N ; 
	static int [][] works ; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		N = Integer.parseInt(br.readLine()); 
		works = new int [N][2]; 
		for(int i = 0 ; i < N ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			int t = Integer.parseInt(st.nextToken()); 
			int v = Integer.parseInt(st.nextToken()); 
			works[i][0] = t ; works[i][1] = v; 
		}
		dp = new int [N + 2];
		int maxIdx = 0 ; 
		int max = 0 ; 
		for(int i = 1 ; i <= N ; i ++) {
			int nt = works[i-1][0] + i; 
			if (max <= dp[i]) {
				max = dp[i]; 
				maxIdx = i; 
			}
			if (nt <= N + 1) {
				if(nt > maxIdx) dp[nt] = Math.max(dp[nt], max + works[i-1][1]); 
			}
		}
		int answer = 0 ; 
		for(int i : dp) {
			if(answer <= i ) answer = i; 
		}
		System.out.println(answer); 
	}
}
 