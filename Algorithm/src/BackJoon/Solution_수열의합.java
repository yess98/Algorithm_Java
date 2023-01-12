package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_수열의합 {
	static int N ; 
	static int L ; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N= Integer.parseInt(st.nextToken()); 
		L = Integer.parseInt(st.nextToken());
		long sum = 0 ; 
		int front = 0 ; 
		int min = N; 
		int firstIdx = -1; int lastIdx = -1; 
		for(int i = 0 ; i <= N ; i ++) {
			sum += i; 
			while (sum > N ) {
				sum -= front; 
				front ++;
			}
			if (sum == N && i - front + 1 >= L) {
				if (min > i- front + 1) {
					min = i-front + 1; 
					firstIdx = front; 
					lastIdx = i; 
				}
				if (i-front + 1 == L) break; 
			}
		}
		if (firstIdx == 0  && min > L ) {
			firstIdx ++; 
		}
		if (firstIdx == -1 && lastIdx == -1  || min > 100 ) {
			System.out.println(-1); 
		}
		else { 
			for(int i = firstIdx ; i <= lastIdx; i ++) {
				System.out.print(i+" ");
			}
		}
	}
	
}
