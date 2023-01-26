package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_로또 {
	// 10:03 - 10 :12
	static int k ; 
	static int [] nums;
	static StringBuilder sb = new StringBuilder(); 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		StringTokenizer st ; 
		while (true) {
			st = new StringTokenizer(br.readLine()); 
			k = Integer.parseInt(st.nextToken()); 
			if (k == 0 ) break; 
			nums = new int [k]; 
			for(int i = 0 ; i < k ; i ++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			int [] temp = new int [6]; 
			solution(6, 0, temp, 0); 
			sb.append("\n"); 
		}
		System.out.println(sb.toString()); 
	}
	public static void solution(int n, int cnt, int [] temp, int idx ) {
		if (cnt == n) {
			for(int t : temp) {
				sb.append(t).append(" "); 
			}
			sb.append("\n"); 
			return ; 
		}
		for(int i = idx; i < nums.length ; i ++) {
			temp[cnt]= nums[i]; 
			solution(n, cnt + 1, temp, i + 1);
		}
	}
}
