package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_킹 {
	static int [][]  map = new int [8][8];
	static int [] dx = {1,-1,0,0,1,-1,1,-1};
	static int [] dy = {0,0,1,-1,-1,-1,1,1}; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		String king = st.nextToken();
		int kingy = king.charAt(0)-'A'; int kingx = 8 - (king.charAt(1)-'0');  
		String stone = st.nextToken(); 
		int stoney = stone.charAt(0)-'A'; int stonex = 8 - (stone.charAt(1)-'0'); 
; 		map[kingx][kingy] = 1; 
		map[stonex][stoney] = 2; 
		int n = Integer.parseInt(st.nextToken()); 
		for(int i  = 0 ; i < n ; i ++) {
			String s = br.readLine(); 
			int nx = kingx; int ny = kingy; 
			int dir = -1; 
			switch(s) {
				case "B" : 
					nx  +=  1; 
					dir = 0; 
					break ; 
				case "T" : 
					nx -= 1; 
					dir = 1; 
					break; 
				case "R": 
					ny += 1; 
					dir = 2; 
					break; 
				case "L" : 
					ny -=1; 
					dir = 3; 
					break; 
				case "LB" : 
					nx += 1; 
					ny -=1; 
					dir = 4; 
					break; 
				case "LT" : 
					nx -= 1; 
					ny -=1; 
					dir = 5; 
					break; 
				case "RB" : 
					nx += 1; 
					ny +=1; 
					dir = 6; 
					break; 
				case "RT" : 
					nx -= 1; 
					ny +=1; 
					dir = 7; 
					break; 
				}
			if (nx < 0 || ny < 0 || nx >= 8 || ny>=8) continue; 
			if (map[nx][ny] == 2) {
				int snx = nx + dx[dir]; 
				int sny = ny + dy[dir]; 
				if (snx < 0 || sny < 0 || snx >= 8 || sny >= 8) {
					continue; 
				}
				else {
					map[snx][sny] = 2; 
					map[stonex][stoney] = 1 ; 
					stonex = snx; stoney = sny;
					kingx = nx; kingy = ny; 
				}
			}
			else {
				map[kingx][kingy] = 0; 
				map[nx][ny] = 1; 
				kingx = nx; 
				kingy = ny; 
			}
		}
		StringBuilder sb = new StringBuilder(); 
		char c = (char) (kingy + 'A'); char c2 = (char) (stoney + 'A'); 
		sb.append(c).append(String.valueOf(8-kingx)).append("\n"); 
		sb.append(c2).append(String.valueOf(8-stonex)).append("\n"); 
		System.out.println(sb.toString());
	
	}
}
