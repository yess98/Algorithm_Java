package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_14719_빗물 {
	static int H; 
	static int W; 
	static int [] arr; 
	static int answer = 0 ; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		H = Integer.parseInt(st.nextToken()); 
		W = Integer.parseInt(st.nextToken()); 
		arr = new int [W]; 
		st = new StringTokenizer(br.readLine()); 
		for(int i = 0 ; i < W; i ++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		for(int i = 1 ; i < arr.length-1  ;i ++ ) {
			int temp = arr[i]; 
			int maxLeft = 0 ; 
			for(int j = i - 1; j >= 0 ; j --) {
				maxLeft = Math.max(maxLeft, arr[j]); 
			}
			int maxRight = 0 ; 
			for(int j = i + 1; j < arr.length; j ++) {
				maxRight = Math.max(maxRight, arr[j]); 
			}
			int larger = Math.min(maxLeft, maxRight);
			if (maxLeft > temp && maxRight > temp) answer += larger - temp; 
			
			
			
		}
		System.out.println(answer); 
	}
}
