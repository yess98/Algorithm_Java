package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2174_로봇시뮬레이션 {
	static int N ; 
	static int M ; 
	static int A; 
	static int B; 
	static int [][] map ; 
	static ArrayList < int [] > al ; 
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		A = Integer.parseInt(st.nextToken()); B = Integer.parseInt(st.nextToken()); 
		st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); 
		al = new ArrayList <>(); 
		map = new int [B][A]; 
		
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine()); 
			int r = Integer.parseInt(st.nextToken()); 
			int c = Integer.parseInt(st.nextToken()); 
			char t = st.nextToken().charAt(0); 
			if (t == 'E') {
				map[B-c][r-1] = i + 1; 
				al.add(new int [] {B-c, r-1, 1}); 
			}
			else if (t == 'S') {
				map[B-c][r-1] = i + 1;
				al.add(new int [] {B-c, r-1, 2}); 
			}
			else if(t == 'W') {
				map[B-c][r-1] = i + 1;
				al.add(new int [] {B-c, r-1, 3}); 
			}
			else if(t == 'N') {
				map[B-c][r-1] = i + 1;
				al.add(new int [] {B-c, r-1, 4}); 
			}
		
		}
		boolean flag = true ;
		
		
		loop : for(int i = 0 ; i < M ; i ++) {
			st = new StringTokenizer(br.readLine()); 
			int n = Integer.parseInt(st.nextToken());
			int [] temp = al.get(n-1); 
			int o = st.nextToken().charAt(0); 
			int t; 
			if (o == 'L') {
				t= Integer.parseInt(st.nextToken());
				t %= 4;
				al.get(n-1)[2] = ((4-t) + temp[2]) % 4 == 0? 4: ((4-t) + temp[2]) % 4 ; 
			}
			else if (o == 'R' ) {
				t= Integer.parseInt(st.nextToken());
				t = (temp[2] + t ) % 4 == 0 ?  4 : (temp[2] + t ) % 4; 
				al.get(n-1)[2] = t; 
			}
			else if (o == 'F') {
				int x = temp[0]; 
				int y = temp[1]; 
				int d = temp[2]; 
				t = Integer.parseInt(st.nextToken()); 
				if (d == 1 ) {
					for(int j = y + 1; j <= y + t ; j ++) {
						if (j >= A) {
							flag = false; 
							System.out.printf("Robot %d crashes into the wall\n",n); 
							break loop; 
						}		
						if(map[x][j] != 0 ) {
						flag = false; 
						System.out.printf("Robot %d crashes into robot %d\n", n, map[x][j]); 
						break loop; 
						}
					}
				
					map[x][y+t] = n; 
					map[x][y] = 0 ; 
					al.get(n-1)[0] = x; 
					al.get(n-1)[1] = y + t; 
				}
				else if (d == 2) {
					
					for(int j = x + 1; j <= x+ t ; j ++) {
						if ( j >= B) {
							flag = false; 
							System.out.printf("Robot %d crashes into the wall\n",n); 
							break loop; 
						}
						if (map[j][y] != 0 ) {
							flag = false; 
							System.out.printf("Robot %d crashes into robot %d\n", n, map[j][y]); 
							break loop; 
						}
					}
					map[x+t][y] = n; 
					map[x][y] = 0 ; 
					al.get(n-1)[0] = x+t; 
					al.get(n-1)[1] = y; 
				}
				else if (d == 3) {
				
					for(int j = y - 1; j >=  y - t ; j --) {
						if (j < 0 ) {
							flag = false; 
							System.out.printf("Robot %d crashes into the wall\n",n); 
							break loop; 
						}
						if (map[x][j] != 0 ) {
							flag = false; 
							System.out.printf("Robot %d crashes into robot %d\n", n, map[x][j]); 
							break loop; 
						}
						
					}
					map[x][y-t] = n; 
					map[x][y] = 0 ; 
					al.get(n-1)[0] = x; 
					al.get(n-1)[1] = y-t; 
				}
				else if (d == 4) {
					
					for(int j = x - 1; j >= x- t ; j --) {
						if(j  < 0 ) {
							flag = false; 
							System.out.printf("Robot %d crashes into the wall\n",n); 
							break loop; 
						}
						if (map[j][y] != 0 ) {
							flag = false; 
							System.out.printf("Robot %d crashes into robot %d\n", n, map[j][y]); 
							break loop;
						}	
					}
					map[x- t][y] = n; 
					map[x][y] = 0 ; 
					al.get(n-1)[0] = x-t; 
					al.get(n-1)[1] = y; 
				}
			}
		}
		if (flag) System.out.println("OK"); 
	}
}
