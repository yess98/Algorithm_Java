package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_13910_개업 {
	static int N ; 
	static int M ; 
	static int [] weights; 
	static int [] dp ; 
	static ArrayList <Integer>al =new ArrayList<>(); 
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		weights = new int[M]; 
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M ; i ++) {
			weights[i] = Integer.parseInt(st.nextToken());
			al.add(weights[i]); 
		}
		for(int i = 0 ; i < M ; i ++) {
			comb(i,1,weights[i]);
		}
		dp = new int [N + 1]; 
		Arrays.fill(dp, Integer.MAX_VALUE); 
		dp[0] = 0; 
		Collections.sort(al, Collections.reverseOrder());
		for(int i = 1; i <= N ; i ++) {
			for(int j = 0 ; j < al.size(); j ++) {
				if (i < al.get(j)) {
					continue; 
				}
				else if (i == al.get(j)) {
					dp[i] = 1; 
					break;
				}
				else if (dp[i-al.get(j)] != Integer.MAX_VALUE){
					dp[i] = Math.min(dp[i], dp[i-al.get(j)] + 1); 
				}
			}
		}
		if(dp[N] == Integer.MAX_VALUE) System.out.println(-1); 
		else System.out.println(dp[N]); 
	}
	public static void comb (int idx, int cnt, int sum) {
		if (cnt == 2) {
			al.add(sum); 
			return ; 
		}
		for(int i = idx + 1; i < weights.length; i ++) {
			comb(i+1,cnt +1, sum + weights[i]);
		}
	}
}
