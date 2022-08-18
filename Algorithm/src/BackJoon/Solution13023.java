package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution13023 {
	static int N ; 
	static int M ;
	static ArrayList<Integer> al[]; 
	static boolean [] visited; 
	static boolean flag = false; 
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		al = new ArrayList[N]; 
		for(int i = 0 ; i < al.length ; i ++) {
			al[i] = new ArrayList<>(); 
		}
		visited = new boolean [N]; 
		for(int i = 0 ; i < M ; i ++) {
			st = new StringTokenizer(br.readLine()); 
			int a  = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken());
			al[a].add(b); 
			al[b].add(a); 
		}
		for(int i = 0 ; i < N ; i ++) {
			visited = new boolean [N];
			visited[i] = true; 
			dfs(0,i); 
			if(flag ) break;
		
		}
		if(flag) System.out.println(1);
		else System.out.println(0); 
		
	}
	static void   dfs(int depth, int n ) {
		if(depth == 4) {
			flag = true; 
			return ; 
		}
		for(int i = 0 ; i < al[n].size(); i++) {
			int next = al[n].get(i); 
			if(visited[next] == false) {
				visited[next] = true;
				dfs(depth + 1, next);
				visited[next] = false; 
			}
		}
	}
}
