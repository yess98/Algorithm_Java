package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_행성탐사2 {
	static int N ; static int M ; static int K ; 
	static char [][] map ; 
	static int [][][] sum; 
	static StringBuilder sb = new StringBuilder(); 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(br.readLine());
		map = new char[N][M]; 
		for(int i = 0 ; i < map.length ; i ++) {
			String s = br.readLine(); 
			for(int j = 0 ; j < map[0].length ; j ++) {
				map[i][j] = s.charAt(j); 
			}
		}
		sum = new int [N][M][3]; 
		fillSum(); 
//		for(int i = 0; i < sum.length ; i ++) {
//			System.out.println(Arrays.deepToString(sum[i])); 
//		}
		for(int i = 0 ; i < K; i ++) {
			st = new StringTokenizer(br.readLine()); 
			int x1 = Integer.parseInt(st.nextToken()); 
			int y1 = Integer.parseInt(st.nextToken()); 
			int x2 = Integer.parseInt(st.nextToken()); 
			int y2 = Integer.parseInt(st.nextToken()); 
			find(x1-1, y1-1, x2-1, y2-1); 
		}
		System.out.println(sb.toString()); 
	}
	static void find (int x, int y, int x2, int y2) {
		 int ocount = sum[x2][y2][0] ; 
		 int icount = sum[x2][y2][1] ; 
		 int jcount = sum[x2][y2][2]; 
		if (x != 0) {
			 ocount = sum[x2][y2][0] - sum[x-1][y2][0];  
			 icount = sum[x2][y2][1] - sum[x-1][y2][1]; 
			 jcount = sum[x2][y2][2] - sum[x-1][y2][2]; 
		}
		if (y != 0 ) {
			 ocount = ocount - sum[x2][y-1][0];  
			 icount = icount - sum[x2][y-1][1]; 
			 jcount = jcount - sum[x2][y-1][2];
		}
		if (x !=  0 && y != 0 ) {
			ocount += sum[x-1][y-1][0]; 
			icount += sum[x-1][y-1][1]; 
			jcount += sum[x-1][y-1][2]; 
				
		}
		 sb.append(jcount).append(" ").append(ocount).append(" ").append(icount).append("\n"); 
	}
	static void fillSum() {
		if(map[0][0] == 'O') {
			sum[0][0][0] = 1;
		}
		if(map[0][0] == 'I') {
			sum[0][0][1] = 1;
			}
		if(map[0][0] == 'J') {
			sum[0][0][2] = 1;
		}
		
		for(int i = 1; i < map.length ; i ++) {
			if (map[i][0] == 'O') {
				sum[i][0][0]= sum[i-1][0][0] + 1; 
				sum[i][0][1] = sum[i-1][0][1]; 
				sum[i][0][2] = sum[i-1][0][2] ; 
			}
			if (map[i][0] == 'I') {
				sum[i][0][0]= sum[i-1][0][0] ; 
				sum[i][0][1] = sum[i-1][0][1] + 1; 
				sum[i][0][2] = sum[i-1][0][2] ; 		
						}
			if (map[i][0] == 'J') {
				sum[i][0][0]= sum[i-1][0][0] ; 
				sum[i][0][1] = sum[i-1][0][1]; 
				sum[i][0][2] = sum[i-1][0][2] + 1 ; 
				
			}
			
		}
		for(int i = 1; i < map[0].length ; i ++) {
			if (map[0][i] == 'O') {
				sum[0][i][0]= sum[0][i-1][0] + 1; 
				sum[0][i][1] = sum[0][i-1][1]; 
				sum[0][i][2] = sum[0][i-1][2] ; 
			}
			if (map[0][i] == 'I') {
				sum[0][i][0]= sum[0][i-1][0]; 
				sum[0][i][1] = sum[0][i-1][1] + 1; 
				sum[0][i][2] = sum[0][i-1][2] ; 	
						}
			if (map[0][i] == 'J') {
				sum[0][i][0]= sum[0][i-1][0]; 
				sum[0][i][1] = sum[0][i-1][1]; 
				sum[0][i][2] = sum[0][i-1][2] + 1 ; 
				
			}
			
		}
		for(int i = 1 ; i < map.length  ; i ++) {
			for(int j = 1 ; j < map[0].length ; j ++) {
				if(map[i][j] == 'O') {
					sum[i][j][0] = sum[i-1][j][0] + 1 + sum[i][j-1][0] - sum[i-1][j-1][0]; 
					sum[i][j][1] = sum[i-1][j][1] + sum[i][j-1][1]- sum[i-1][j-1][1]; 
					sum[i][j][2] = sum[i-1][j][2] + sum[i][j-1][2]- sum[i-1][j-1][2];
				}
				if(map[i][j] == 'I') {
					sum[i][j][0] = sum[i-1][j][0] + sum[i][j-1][0] - sum[i-1][j-1][0]; 
					sum[i][j][1] = sum[i-1][j][1] + 1 + sum[i][j-1][1]- sum[i-1][j-1][1]; 
					sum[i][j][2] = sum[i-1][j][2] + sum[i][j-1][2]- sum[i-1][j-1][2];
				}
				if(map[i][j] == 'J') {
					sum[i][j][0] = sum[i-1][j][0] + sum[i][j-1][0] - sum[i-1][j-1][0]; 
					sum[i][j][1] = sum[i-1][j][1] + sum[i][j-1][1]- sum[i-1][j-1][1]; 
					sum[i][j][2] = sum[i-1][j][2] +1 +  sum[i][j-1][2]- sum[i-1][j-1][2];
				}
			}
		}
	}
}
