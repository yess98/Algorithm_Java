package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_1263 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine()); 
		int [][] times = new int [N][2]; 
		for(int i = 0 ; i < N ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			times[i][0] = Integer.parseInt(st.nextToken()); 
			times[i][1] = Integer.parseInt(st.nextToken()); 
		}
		Arrays.sort(times, (a1, a2) -> a2[1] - a1[1]);
		int time = times[0][1] - times[0][0]; 
		for(int i = 1; i < N ; i ++) {
			if(times[i][1] < time ) {
				time = times[i][1]; 
			}
			time -= times[i][0]; 
		}
		if(time < 0 ) System.out.println(-1); 
		else System.out.println(time); 
	}
}
