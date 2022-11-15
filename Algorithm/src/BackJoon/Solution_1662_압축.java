package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Solution_1662_압축 {
	static Stack <int []> stack = new Stack<>();
	static Queue <int [] > queue = new ArrayDeque<>(); 
	public static void main(String [] args) throws IOException {
		int answer = 0 ; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String s = br.readLine();
		for(int i = 0 ; i < s.length(); i ++) {
			if (s.charAt(i) == '(' ) queue.add(new int [] {-1,0}); 
			else if (s.charAt(i) == ')') queue.add(new int [] {-2,0}); 
			else queue.add(new int[] {s.charAt(i) - '0', 0 }); 
		}
		while (!queue.isEmpty()) { 
			int [] temp = queue.poll(); 
			if(temp[0] == -2) {
				int len = 0 ; 
				while (!stack.isEmpty()) {
					int temp2 [] = stack.pop(); 
					//System.out.println(Arrays.toString(temp2)); 
					
					if(temp2[0] == -1) {
						int cnt[] = stack.pop(); 
						stack.add(new int [] {len * cnt[0], 1});
						break; 
					}
					if (temp2[1] == 0) {
						len ++; 
					}
					else if (temp2[1] == 1) {
						len += temp2[0]; 
					}
				}
			}
			else stack.add(temp); 
		}
		while (!stack.isEmpty()) {
			int [] temp = stack.pop(); 
			System.out.println(Arrays.toString(temp)); 
			if(temp[1] == 1) {
				answer += temp[0]; 
			}
			else if (temp[1] == 0) {
				answer ++; 
			}
		}
		System.out.println(answer); 
	}
}
