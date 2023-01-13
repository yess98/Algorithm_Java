package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_후위표기식2 {
	static Stack <Double> stack = new Stack(); 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int [] num = new int  [N]; 
		for(int i = 0 ; i < num.length; i ++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		
		for(int i = 0 ; i < s.length(); i ++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				stack.add(Double.parseDouble(String.valueOf(num[s.charAt(i) - 'A'])));
				continue; 
			}
			else {
				double b = stack.pop(); 
				double  a = stack.pop(); 
				if (s.charAt(i) == '+') {
					stack.add(a + b); 
				}
				else if (s.charAt(i) == '-') {
					stack.add(a-b); 
				}
				else if (s.charAt(i) == '*') {
					stack.add(a*b); 
				}
				else if (s.charAt(i) == '/') {
					stack.add(a/b); 
				}
			}
		}
		System.out.println(String.format("%.2f", stack.peek())); 
	}
}
