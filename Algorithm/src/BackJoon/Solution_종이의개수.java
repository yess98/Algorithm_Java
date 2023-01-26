package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_종이의개수 {
	// 10:13 - 
	static int [][] map;
	static int N ; 
	static int gray, white, black; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		N = Integer.parseInt(br.readLine()); 
		map = new int [N][N]; 
		for(int i = 0 ; i < N ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			for(int j = 0; j < N ; j ++)
			{
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		solution(0,0,N); 
		System.out.println(gray);
		System.out.println(white); 
		System.out.println(black); 
	}
	public static void solution(int x, int y , int size) { 
		int block = map[x][y]; 
		if (count (block, size, x, y)) {
			if (block == -1) {
				gray ++; 
			}
			else if(block == 0) {
				white++; 
			}
			else if (block == 1) {
				black++; 
			}
			return; 
		}
		size /= 3; 
		solution(x, y, size); // 왼 위
		solution (x,y + size, size);  // 중간 위
		solution (x + size, y , size);  // 왼 중간
		solution(x + 2 * size , y , size); // 왼 아래 
		solution(x, y + 2 * size , size);  // 오른 위 
		solution (x + size, y + size, size) ; // 중간 중간
		solution (x + size, y + 2 * size, size);  // 중간 오른 
		solution (x + 2 * size, y + 2 * size, size); // 아래 오른 
		solution (x + 2 * size , y + size, size); 
	
	}
	public static boolean count(int n, int size , int x, int y ) {
		for(int i = x ; i < x + size; i ++) {
			for(int j = y ; j < y + size; j ++) {
				if (map[i][j] == n) continue; 
				else return false; 
			}
		}
		return true; 
	}
}
