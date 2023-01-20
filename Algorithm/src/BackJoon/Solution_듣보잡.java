package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_듣보잡 {
	// 10:30
	static HashSet <String> hs = new HashSet<>(); 
	static ArrayList <String> al = new ArrayList <>(); 
	public static void main(String[] args) throws IOException {
		int answer = 0 ; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st  = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken()); 
		for(int i = 0 ; i < N ; i ++) {
			String s = br.readLine(); 
			hs.add(s); 
		}
		for(int i = 0 ; i < M ; i ++) {
			String s = br.readLine(); 
			if(hs.contains(s)) {
				answer ++; 
				al.add(s); 
			}
		}
		Collections.sort(al);
		System.out.println(al.size()); 
		for(int i = 0 ; i < al.size(); i ++){
			System.out.println(al.get(i)); 
		}
	}
}
