package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_소가길을건너간이유5 {
	// 10:35
	static boolean [] check; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st.nextToken()); 
		int k = Integer.parseInt(st.nextToken()); 
		int B = Integer.parseInt(st.nextToken()); 
		check = new boolean [N + 1]; 
		for(int i =0 ; i < B;  i++) {
			int sinho = Integer.parseInt(br.readLine()); 
			check[sinho] = true; 
		}
		int cnt = 0 ;
		int min = Integer.MAX_VALUE; 
		int bIndx = 1 + k; 
		for(int i = 1; i <= check.length - k ; i ++) {
			if (i == 1 ) {
				for(int j = i ; j < i + k; j ++) {
					if(check[j] == true) cnt ++; 
				}
				min = Math.min(min, cnt); 
			}
			else {
				if (check[bIndx++] == true) cnt ++; 
				if (check[i-1] == true) cnt --; 
				
				min = Math.min(min, cnt); 
			}
		}
		System.out.println(min); 
	}
}
