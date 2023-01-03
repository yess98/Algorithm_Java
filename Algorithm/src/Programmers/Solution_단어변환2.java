package Programmers;

import java.util.*; 
class Solution_단어변환2 {
    static int min  = Integer.MAX_VALUE; 
    static boolean [] visited; 
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean [words.length ]; 
        dfs(begin, target, words, 0); 
        answer = min; 
        if(answer == Integer.MAX_VALUE) answer = 0; 
        return answer;
    }
    public static void dfs (String now, String target, String [] words, int cnt ){
        if(now.equals(target)){
            min = Math.min(min, cnt); 
            return ; 
        }
        for(int i = 0 ; i < words.length ; i ++){
            if (!visited[i]){
                if (match(words[i],now)){
                    visited[i] = true; 
                    dfs(words[i],target, words,cnt + 1); 
                    visited[i] = false; 
                }
            }
        }
    }
    public static boolean match(String next, String now){
        int count = 0 ; 
        for(int i = 0 ; i < now.length(); i ++){
            if (next.charAt(i) != now.charAt(i)) {
                count ++; 
            }
            if (count >=2) return false; 
        }
        return true; 
    }
}