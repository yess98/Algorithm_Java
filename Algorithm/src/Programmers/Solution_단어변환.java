package Programmers;
import java.util.*;
public class Solution_단어변환 {
	 static int min = Integer.MAX_VALUE; 
	    static boolean [] visited ; 
	    public int solution(String begin, String target, String[] words) {
	        int answer = 0;
	        if (!Arrays.asList(words).contains(target)){
	            return answer; 
	        }
	        visited = new boolean [words.length ]; 
	        dfs(begin,target,words,0); 
	        return answer = min;
	    }
	    public boolean compare (String s, String t){
	        int cnt = 0 ; 
	        for(int i = 0 ; i < s.length () ; i ++){
	            if(s.charAt(i) == t.charAt(i)) continue; 
	            else {
	                cnt ++;
	                if(cnt >= 2) return false; 
	            }
	        }
	        return true; 
	    }
	    public void dfs(String b, String t, String [] words, int cnt){
	        if(b.equals(t)){
	            min = Math.min(min,cnt);
	            return ; 
	        }
	        for(int i = 0 ; i < words.length ; i ++){
	            if(!visited[i] && compare(b, words[i]) == true){
	                visited[i] = true; 
	                dfs(words[i],t, words, cnt + 1); 
	                visited[i]  = false; 
	            }
	        }
	    }
}
