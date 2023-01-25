package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_a와b2 {
	static String s; 
	static String t; 
	static boolean flag = false; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		s = br.readLine(); 
		t = br.readLine(); 
		backtrack2(s.length(), t.length(), t) ; 
		if(flag) System.out.println(1); 
		else System.out.println(0); 
		
	}
	public static void backtrack(int n , int depth , String str ) {
		if (n == depth) {
			if (str.equals(t)) {
				flag = true; 
				return ; 
			}
			else return ; 
		}
		if (flag) return ; 
		if(depth > n) return ; 
		backtrack(n, depth + 1, str + "A");
		StringBuilder sb = new StringBuilder(str); 
		String nextStr = sb.reverse().toString(); 
		backtrack(n, depth + 1, "B" + nextStr); 
	}
	public static void backtrack2(int n, int d, String str ) {
		if (n == d) {
			if(str.equals(s)) {
				flag = true; 
				return; 
			}
			return ; 
		}
		if (flag) return ; 
		if(d < n ) return ; 
		if (str.charAt(0) == 'B') {
			StringBuilder sb = new StringBuilder(str); 
			String nextStr = sb.reverse().substring(0,sb.length() - 1).toString(); 
			backtrack2(n, d-1, nextStr); 
		}
		if(str.charAt(str.length() - 1) == 'A' ) {
			String nextStr = str.substring(0,str.length() -1); 
			backtrack2(n, d-1, nextStr); 
		}
	}
}
