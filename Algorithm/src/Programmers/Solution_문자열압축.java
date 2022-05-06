package Programmers;

import java.util.*; 
public class Solution_문자열압축 {

    static int min ; 
    public int solution(String s) {
        int answer = 0;
        min = s.length (); 
        int len = s.length () / 2; 
        for(int i = len ; i > 0 ; i --){
            findLength(i,s); 
        }
        answer = min; 
        return answer;
    }
    public void findLength(int len, String s){
        int size = s.length() % len == 0 ? s.length() / len : s.length() / len + 1; 
        String [] words = new String [size]; 
        int idx = 0 ; 
        for(int i = 0 ; i < s.length (); i = i + len ){
            if (i + len > s.length()) {
                words[idx++] = s.substring(i,s.length()); 
                break;
            }
            else words[idx ++ ] = s.substring(i,i + len); 
        }
        StringBuilder sb = new StringBuilder(); 
        String word = words[0]; 
        int cnt = 1 ; 
        for(int i = 1; i < words.length ; i ++)
        {
            if (word.equals(words[i])){
                cnt ++; 
            }
            else
            {
                if (cnt != 1) sb.append(cnt).append(word); 
                else sb.append(word); 
                word = words[i]; 
                cnt = 1; 
            }
        }
        if (cnt != 1 ) sb.append(cnt).append(word); 
        else sb.append(word); 
        int l = sb.toString().length(); 
        min = Math.min(l, min); 
    }
}