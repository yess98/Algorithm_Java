package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution16637 {
	static ArrayList <Character> opers; 
	static ArrayList<Integer> nums; 
	static int max = Integer.MIN_VALUE; 
	public static void main (String [] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine()); 
		String s = br.readLine(); 
		nums = new ArrayList <>(); 
		opers = new ArrayList <>(); 
		init(s);
		dfs(0,nums.get(0)); 
		System.out.println(max); 
		
	}
	static void init(String s ) {
		for(int i = 0 ; i < s.length() - 1 ; i = i + 2) {
			nums.add( s.charAt(i) - '0'); 
			opers.add(s.charAt(i + 1)); 
		}
		nums.add( s.charAt(s.length() -1) - '0');
	}
	static void dfs(int idx, int sum) {
		if(idx == opers.size()) {
			max = Math.max(sum, max); 
			return ; 
		}
		dfs(idx + 1, calculate(opers.get(idx), sum, nums.get(idx + 1))); 
		if(idx + 2 <= opers.size()) {
			dfs(idx + 2, calculate(opers.get(idx),sum,calculate(opers.get(idx + 1), nums.get(idx + 1), nums.get(idx + 2)))); 
		}
	}
	static int  calculate(char op, int num1, int num2 ) {
		if(op == '+') {
			return num1 + num2; 
		}
		else if(op == '-') {
			return num1 - num2; 
		}
		else  {
			return num1 * num2; 
		}
	}
	
	
}
