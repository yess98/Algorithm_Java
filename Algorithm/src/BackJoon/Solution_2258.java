package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_2258 {
	static int N ; 
	static int M ;
	static int meat [][];
	static int minPrice = Integer.MAX_VALUE;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		meat = new int [N][2];
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine()); 
			meat[i][0] = Integer.parseInt(st.nextToken()); 
			meat [i][1] = Integer.parseInt(st.nextToken()); 
		}
		Arrays.sort(meat, new Comparator<int[]>() {
			@Override
			public int compare (int [] a, int [] b) {
				// a[1] 가격, a[0] 무게
				if(a[1] == b[1]) {
					return b[0] - a[0]; 
				}
				return a[1] - b[1]; 
			}
		});
		int totprice = 0; 
		int totweight = 0; 
		int answer = Integer.MAX_VALUE;
		boolean flag = false; 
		for(int i = 0 ; i < meat.length ; i ++) {
			totweight += meat[i][0];
			if(i > 0 && (meat[i][1] > meat[i-1][1])) {
				totprice = meat[i][1];
			}
			else {
				totprice += meat[i][1];
			}
			if(totweight >= M) {
				flag = true; 
				answer = Math.min(answer, totprice); 
			}
			
		}
		if(!flag) System.out.println(-1); 
		else System.out.println(answer); 
	}
}
