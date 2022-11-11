package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1111_IQ_TEST {
	static int A; 
	static int B; 
	static int [] arr; 
	static int N ; 
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		arr = new int [N]; 
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		if (arr.length > 2) {
			if (arr[1]  == arr[0]) {
				A = 1; 
				B = 0 ; 
			}
			else {
			A = (arr[2] - arr[1]) / (arr[1] - arr[0]);
			B = arr[1] - arr[0] *A; 
			}
			int j =1; 
			for(; j < arr.length; j ++) {
				if (arr[j] != arr[j-1] * A + B) break; 
			}
			if (j !=  arr.length) {
				System.out.println("B");  
				return ; 
			}
			else {
				System.out.println(arr[arr.length -1] * A + B); 
				return ; 
			}
			
		}
		else if (arr.length == 1) {
			System.out.println("A"); 
			return ; 
		}
		else  {
			if (arr[0] == arr[1]) {
				System.out.println(arr[1]); 
				return ; 
			}
			else { 
				System.out.println("A"); 
				return ; 
			}
		}
	}
	
}

 

