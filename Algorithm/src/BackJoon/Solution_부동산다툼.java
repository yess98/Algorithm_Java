package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_부동산다툼 {
	// 11:27
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		StringBuilder sb = new StringBuilder(); 
		int N = Integer.parseInt(st.nextToken()); 
		int Q = Integer.parseInt(st.nextToken()); 
		boolean [] check = new boolean [N + 1]; 
		for(int i = 0 ; i < Q; i ++) {
			int n = Integer.parseInt(br.readLine());
			int temp = n; 
			int step = -1 ; 
			while (n > 0 ) {
				if (check[n]) {
					step = n; 
				}
				n /= 2; 
			}
			if (step == -1) sb.append(0).append("\n"); 
			else sb.append(step).append("\n");
			check[temp] = true; 
		}
		System.out.println(sb.toString());
	}
}
