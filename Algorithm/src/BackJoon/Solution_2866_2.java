package BackJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
public class Solution_2866_2 {
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
		arr = new String [C];
		map = new char [R][C]; 
		StringBuilder sb;
		for(int i = 0 ; i < R;i ++) {
			map[i] = br.readLine().toCharArray();
		}
		for(int i = 0 ; i < C; i ++) {
			sb = new StringBuilder(); 
			for(int j = 0; j<R; j++) {
				sb.append(map[j][i]); 
			}
			arr[i] = sb.toString();
		}
		
		int start = 0 ; int end = R - 1; 
		Set<String> set = new HashSet<>(); 
		while (start <= end) {
			set.clear();
			int mid = (start+ end)/2; 
			String s = arr[0].substring(mid,arr[0].length()); 
			String temp; 
			set.add(s);
			for(int i = 1; i < arr.length; i ++) {
				temp = arr[i].substring(mid,arr[0].length());
				if(!set.contains(temp)) set.add(temp);
				else {
					break;
				}
			}
			if(set.size() == arr.length) {
				// 중복되는것 없다는 소리 
				start = mid + 1; 
			}
			else {
				// 중복 되는 것 있다는 소리
				end = mid -1; 
			}
			
		}
		System.out.println(end); 
	}
}


