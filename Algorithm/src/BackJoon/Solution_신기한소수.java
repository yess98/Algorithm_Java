package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_신기한소수 {
	static String [] sosuNum = {"1","3","7","9"};
	static StringBuilder sb = new StringBuilder(); 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine());
		String sosu [] = new String [] {"2","3","5","7"};
		for(int i = 0; i < sosu.length ; i ++) {
			makeNum(1, N, sosu[i]); 
		}
	}
	public static void makeNum(int cnt, int n, String s ) {
		if (cnt == n) {
			System.out.println(s); 
			return ; 
		}
		for(int i = 0 ; i < sosuNum.length; i ++) {
			if(isPrimeNum(s, sosuNum[i])) {
		  	makeNum(cnt + 1, n, s + sosuNum[i]);
			}
		}
	}
	public static boolean isPrimeNum(String s, String s2 ) {
		String newStr = s + s2;
		int newStrInt = Integer.parseInt(newStr); 
		for(int i = 2; i <= Math.sqrt(newStrInt); i ++) {
			if (newStrInt % i == 0 ) return false; 
		}
		return true ; 
	}
}
