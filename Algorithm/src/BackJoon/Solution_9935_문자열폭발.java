package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_9935_문자열폭발 {
	static StringBuilder sb; 
	static String parent; 
	static String pattern; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		parent = br.readLine();
		pattern = br.readLine(); 
		sb = new StringBuilder(); 
		boolean flag = false; 
		for(int i = 0 ; i < parent.length();i ++) {
			char c1 = parent.charAt(i); 
			sb.append(c1);
			flag = true; 
			if(sb.length() >= pattern.length()) {
				for(int idx =0; idx < pattern.length(); idx ++) {
					char c = sb.charAt(sb.length() - pattern.length() + idx);
					char c2 = pattern.charAt(idx); 
					if(c != c2) {
						flag = false; 
						break;
					}
				}
				if(flag) {
					sb.delete(sb.length()-pattern.length(),sb.length());
					System.out.println(sb.toString()); 
				}
			}
	
		}
		if(sb.length() == 0 ) {
			System.out.println("FRULA");
		}
		else {
			System.out.println(sb.toString());
		}
	}

}
