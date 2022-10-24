package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2866 {
	static int R; 
	static int C; 
	static char [][] map; 
	static String [] arr; 
	static int answer; 
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		R= Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken()); 
		map = new char [R][C]; 
		for(int i = 0 ; i < R;i ++) {
			String temp = br.readLine();
			for(int j = 0 ; j< C; j ++) {
				map[i][j] = temp.charAt(j);
			}
		}
		for(int i = R -1 ; i >= 0 ; i --) {
			boolean flag = check(i) ; 
			if(flag) {
				answer = i;
				break;
			}
		}
		System.out.println(answer); 
	}
	static boolean check(int row) {
		makeStrArr(row); 
		Arrays.sort(arr);
		boolean flag = findMultiString(); 
		if(flag) return true; 
		else return false; 
	}
	static  boolean findMultiString() { // 중복되는 문자열 찾으면 return false
		for(int i = 0 ; i < C; i ++) {
			String s = arr[i]; 
			int left = i+1; 
			int right = C-1;
			boolean flag = false; 
			while (left <= right) {
				int temp  = (left + right) / 2;
				if(s.equals(arr[temp])) {
					flag = true; 
					break;
				}
				if(s.compareTo(arr[temp]) < 0) {
					// 작다면 right가 temp -1;
					right = temp-1; 
				}
				else {
					// 크다면 left 가 temp + 1
					left = temp +1; 
				}
			}
			if(flag) {
				return false; 
			}
		}
		return true; 
	}
	static void makeStrArr(int row) {
		arr = new String[C]; 
		StringBuilder sb;
		for(int i = 0 ; i < C; i ++) {
			sb = new StringBuilder(); 
			for(int j = R-1; j >= row; j --) {
				sb.append(map[j][i]);
			}
			arr[i] = sb.toString();
		}
	}
}
