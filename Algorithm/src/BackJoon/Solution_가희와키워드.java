package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_가희와키워드 {
	// 11:20 
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder(); 
		int N = Integer.parseInt(st.nextToken()); 
		int K = Integer.parseInt(st.nextToken());
		Set <String > set = new HashSet<>(); 
		for(int i = 0 ; i < N ; i ++) {
			String s = br.readLine(); 
			set.add(s); 
		}
		for(int i = 0 ; i < K; i ++) {
			String [] str = br.readLine().split(","); 
			for(String s : str) {
				if (set.contains(s)) {
					set.remove(s); 
				}
			}
			sb.append(set.size()).append("\n"); 
		}
		System.out.println(sb.toString()); 
	}
}
