package Programmers;

import java.util.Arrays;

/**
 * 80
 * 최소 필요도와 소모 피로도 
 * [[80,20]
 * [50,40]
 * [30,10]]
 * 
 *	max length 8개 
 * 	8개 perm
 */
public class Solution_피로도 {
	static boolean [] visited;
	static int index; // 7개면 0-6
	static int max; 
	static int k; 
	static int [][]  dungeons ;
	public static void main(String[] args) {
		max = 0 ; 
		k = 80; 
		dungeons = new int [][]  {
				{80,20},{50,40},{30,10}
		};
		
		index = dungeons.length; 
		visited = new boolean[index]; 
		perm(new int [index], index, 0 ); 
		System.out.println(max); 
	}
	public static void Counting(int [] temp) {
		int tempk = k; 
		int cnt = 0 ; 
		for(int i = 0 ; i < index; i ++) {
			int minpiro = dungeons[temp[i]][0]; 
			if (tempk < minpiro) {
				max = Math.max(max, cnt);
				break;
			}
			tempk -= dungeons[temp[i]][1]; 
			cnt ++; 
		}
		max = Math.max(max, cnt);
	}
	public static void perm(int [] temp, int n, int  cnt) {
		
		if (cnt == n) {
			Counting(temp); 
			return ; 
		}
		
		for(int i = 0 ; i < index; i ++ ) {
			if (!visited[i]) {
				visited[i] = true; 
				temp[cnt] = i; 
				perm(temp, n, cnt + 1); 
				visited[i] = false;
			}
		}
		
	}
}
