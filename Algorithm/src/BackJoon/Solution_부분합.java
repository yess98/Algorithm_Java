package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_부분합 {
	static int [] nums; 
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken()); 
		nums = new int [N]; 
		st = new StringTokenizer(br.readLine()); 
		for(int i = 0 ; i < nums.length ; i ++) {
			nums[i] = Integer.parseInt(st.nextToken()); 
		}
		int startIdx = 0 ; 
		int endIdx = 0 ; 
		int sum = 0 ; 
		int min = nums.length;
		while (true) { 
			if (endIdx < nums.length) {
				sum += nums[endIdx];
			}
			while (sum - nums[startIdx] >= S) {
				sum -= nums[startIdx++]; 
			}
			if (sum >= S) {
				min = Math.min(min, (endIdx - startIdx + 1)); 
			}
			if(endIdx == nums.length) break; 
			endIdx ++; 
		}
		System.out.println(min); 
		
	}
}
