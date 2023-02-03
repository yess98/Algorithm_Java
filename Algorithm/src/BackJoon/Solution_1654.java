package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int K = Integer.parseInt(st.nextToken()); 
		int N = Integer.parseInt(st.nextToken()); 
		int [] lamps = new int [K]; 
		for(int i = 0 ; i < K ; i ++) {
			lamps[i] = Integer.parseInt(br.readLine()); 
		}
		Arrays.sort(lamps);
		long left = 1 ; 
		long right = lamps[lamps.length-1]; 
		long mid = (left + right) / 2; 
		while (left < right) { 
			long sum = 0 ; 
			for(int i = 0 ;i < K ; i ++) {
				sum += lamps[i] / mid; 
			}
			if (sum >= N ) {
				left = mid + 1; 
			}
			else {
				right = mid - 1; 
			}
			mid = (left + right) / 2; 
		}
		System.out.println(right); 
	}
}
