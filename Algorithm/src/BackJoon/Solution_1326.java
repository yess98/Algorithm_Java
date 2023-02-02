package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1326 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine()); 
		int [] steps = new int [N]; 
		StringTokenizer st  = new StringTokenizer(br.readLine()); 
		for(int i = 0 ; i <N ; i++) {
			steps[i] = Integer.parseInt(st.nextToken()); 
		}
		st  = new StringTokenizer(br.readLine()); 
		int a = Integer.parseInt(st.nextToken()); 
		int b = Integer.parseInt(st.nextToken());
		boolean [] visited  = new boolean [N]; 
		Queue <int [] > queue = new ArrayDeque<>(); 
		queue.add(new int [] {a -1, 0} );
		visited[a-1] = true; 
		
		boolean flag = false; 
		while (!queue.isEmpty()) {
			int temp [] = queue.poll();
			if (temp[0] == b-1) {
				flag = true; 
				System.out.println(temp[1]); 
				break; 
			}
			if (flag) break; 
			int idx = 1; 
			int num = temp[0]  +  steps[temp[0]] * idx; 
			while (num < N) {
				if (!visited[num]) {
					queue.add(new int [] {num, temp[1] + 1}); 
					visited[num] = true; 
				}
				num = temp[0]  +  steps[temp[0]] * ++idx; 
			}
			idx = 1; 
			num = temp[0] - steps[temp[0]] * idx; 
			while (num >= 0 ) {
				if (!visited[num]) {
					queue.add(new int [] {num, temp[1] + 1}); 
					visited[num] = true; 
				}
				num = temp[0] - steps[temp[0]] * ++idx; 
			}
			
		}
		if (!flag) System.out.println(-1); 
	}
}
