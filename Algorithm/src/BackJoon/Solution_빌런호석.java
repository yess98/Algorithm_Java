package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_빌런호석 {
	static int N ; 
	static int K ; 
	static int P ; 
	static int X; 
	static int digits [][] = {{1, 1, 1, 0, 1, 1, 1}, //0
            {0, 0, 1, 0, 0, 0, 1}, //1
            {0, 1, 1, 1, 1, 1, 0}, //2
            {0, 1, 1, 1, 0, 1, 1}, //3
            {1, 0, 1, 1, 0, 0, 1}, //4
            {1, 1, 0, 1, 0, 1, 1}, //5
            {1, 1, 0, 1, 1, 1, 1}, //6
            {0, 1, 1, 0, 0, 0, 1}, //7
            {1, 1, 1, 1, 1, 1, 1}, //8
            {1, 1, 1, 1, 0, 1, 1}}; //9
	static int answer = 0 ; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
	        
	     N = Integer.parseInt(st.nextToken());
	     K = Integer.parseInt(st.nextToken());
	     P = Integer.parseInt(st.nextToken());
	     X = Integer.parseInt(st.nextToken());
	     int[] numbers = change(X);
	     check(numbers); 
	     System.out.println(answer); 
	}
	public static void check(int [] numbers) {
		for(int i = 1; i <= N ; i ++) {
		if (i == X) continue; 
		if (possible (numbers, i)) answer ++; 	
		}
	}
	public static boolean possible(int [] numbers, int max) {
		int [] max_numbers = change(max); 
		int dif = 0 ; 
		for(int i = 0 ; i  < max_numbers.length ; i ++) {
			int num1 = max_numbers[i]; 
			int num2 = numbers[i]; 
			
			for(int j = 0 ; j < 7 ; j ++) {
				if (digits[num1][j] != digits[num2][j]) dif ++; 
				if (dif > P) return false; 
			}
		}
		return true; 
	}
	public static int [] change(int n) {
		int [] numbers = new int [K];
		for(int i = 0 ; i < numbers.length ; i ++) {
			numbers[numbers.length -1 -i] = n % 10; 
			n /= 10; 
		}
		return numbers;
	}
	
}
