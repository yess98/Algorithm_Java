package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_연속합 {
	//05:07
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in )); 
		int n = Integer.parseInt(br.readLine()); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int nums[] = new int [n]; 
		for(int i = 0 ; i < n ; i ++)
		{
			nums[i] = Integer.parseInt(st.nextToken()); 
		}
		int [] dp = new int [n];
		dp[0] = nums[0]; 
		for(int i = 1; i < dp.length ; i ++) { 
			dp[i] = Math.max(nums[i], dp[i-1] + nums[i]); 
		}
		int max = Integer.MIN_VALUE; 
		for(int i = 0 ; i < dp.length; i ++) {
			max = Math.max(max, dp[i]); 
		}
		System.out.println(max); 
	}
}