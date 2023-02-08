package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_숨바꼭질3 {
	// 11:38
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st.nextToken()); 
		int K = Integer.parseInt(st.nextToken()); 
		boolean [] check = new boolean [1000001]; 
		check[N] = true; 
		Queue <int [] > queue = new ArrayDeque<>(); 
		queue.add(new int [] {N, 0}) ;
		int answer = -1 ; 
		while (!queue.isEmpty()) {
			int [] temp = queue.poll(); 
			if (temp[0] == K) {
				answer  = temp[1]; 
				break;
			}
			if (temp[0]  * 2 <= 100000 && check[temp[0]  * 2] == false) {
				queue.add(new int [] {temp[0] * 2, temp[1]}) ; 
				check[temp[0]  *  2] = true; 
			}
			if (temp[0] - 1 >= 0 && check[temp[0] -1] == false) {
				queue.add(new int [] {temp[0] -1 , temp[1] + 1}); 
				check[temp[0] - 1] = true; 
			}
			if (temp[0]  +  1 <= 100000 && check[temp[0]  + 1] == false) {
				queue.add(new int [] {temp[0]  + 1 , temp[1] + 1}); 
				check[temp[0]  +  1] = true; 
			}
			
		}
		System.out.println(answer); 
	}
}
