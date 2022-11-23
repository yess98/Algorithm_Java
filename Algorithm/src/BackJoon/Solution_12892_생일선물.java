package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_12892_생일선물 {
	static int N ; 
	static int  D; 
	static ArrayList<long []> al ; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken()); 
		al = new ArrayList <>(); 
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine()); 
			al.add(new long[] {Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())}); 
		}
		Collections.sort(al, new Comparator <long []> () {
			@Override 
			public int compare(long [] l1, long [] l2) {
				if(l2[0] == l1[0]) {
					return (int) (l2[1]-l1[1]); 
				}
				return (int) (l2[0] - l1[0]); 
			}
		});
		// 무게 높은순서, 무게 같으면  가치 높은 순서 
		long max = -1; 
		int j = 1;
		long sum = al.get(0)[1]; 
		for(int i = 0 ; i < al.size(); i ++) {
			long [] temp = al.get(i);
			long p = temp[0]; 
			long v = temp[1];
			if (i != 0 ) sum -= al.get(i-1)[1];  
			for( ; j < al.size(); j ++ ) {
				long [] temp2 = al.get(j); 
				long p2 = temp2[0]; 
				long v2 = temp2[1]; 
				if (Math.abs(p-p2) >= D) break; 
				sum  += v2; 
			}
			max = Math.max(sum, max); 
		}
		System.out.println(max); 
	}
}
