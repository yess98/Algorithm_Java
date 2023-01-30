package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_17298 {
	// 11:21
	static int N ; 
	static int [] nums ; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		N = Integer.parseInt(br.readLine()); 
		nums = new int [N]; 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		for(int i = 0 ; i < N ; i ++) {
			nums[i] = Integer.parseInt(st.nextToken()); 
		}
		int [] answer = new int [N]; 
		Arrays.fill(answer, -1);
		Stack <Integer> stack = new Stack <>(); 
		for(int i = 0 ; i < nums.length ; i ++) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				answer[stack.pop()] = nums[i] ;
			}
			stack.add(i); 
		}
		
		StringBuilder sb = new StringBuilder(); 
		for(int i = 0 ; i < answer.length ; i ++) {
			sb.append(answer[i]).append(" "); 
		}
		System.out.println(sb.toString()); 
	}
}
 