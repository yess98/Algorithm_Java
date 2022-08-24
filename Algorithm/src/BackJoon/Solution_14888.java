package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_14888 {
	static int N ; 
	static int [] oper = new int [4]; 
	static char [] opers; 
	static int [] nums; 
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static boolean [] check ; 
	static char [] temp; 
	public static void main(String [] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		N = Integer.parseInt(br.readLine()); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		nums = new int[N]; 
		for(int i = 0 ; i < N ; i ++) {
			nums[i] = Integer.parseInt(st.nextToken()); 
		}
		st = new StringTokenizer(br.readLine()); 
		for(int i = 0 ; i < 4; i ++) {
			oper[i] = Integer.parseInt(st.nextToken()); 
		}
		opers = new char[N-1];
		int idx = 0; 
		for(int i = 0 ; i < 4; i ++) {
			for(int j = 0 ; j < oper[i]; j ++) {
				if(i == 0) {
					opers[idx++] = '+';
				}
				else if(i == 1) {
					opers[idx++] = '-'; 
				}
				else if (i == 2) {
					opers[idx++] = '*'; 
				}
				else if (i == 3) {
					opers[idx++] = '/'; 
				}
			}
		}
		temp = new char [N-1]; 
		check = new boolean [N-1]; 
		perm(0,N-1); 
		System.out.println(max); 
		System.out.println(min); 
		
	}
	public static int calculation(char c, int a, int b) {
		if(c == '+') return a +b; 
		else if (c == '-') return a -b; 
		else if (c == '*') return a * b; 
		return a/b; 
	}
	public static void calc(char [] temp) {
		int sum = nums[0] ;
		for(int i = 0 ; i < temp.length; i ++) {
			sum = calculation(temp[i],sum,nums[i + 1]); 
		}
		if(sum > max) max  = sum; 
		if(sum < min) min = sum; 
	}
	public static void perm(int cnt, int n) {
		if(cnt == n) {
			calc(temp); 
			return ;
		}
		for(int i = 0 ; i < opers.length; i ++) {
			if(!check[i]) {
				check[i] = true;
				temp[cnt] = opers[i]; 
				perm(cnt + 1, n);
				check[i] = false; 
			}
		}
	}
}
