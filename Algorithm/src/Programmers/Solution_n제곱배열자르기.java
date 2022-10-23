package Programmers;

import java.util.*; 
class n제곱배열자르기 {
    public int[] solution(int n, long left, long right) {
        long ln = new Long(n); 
        int startrow = Long.valueOf(left / ln).intValue();
        int startcol = Long.valueOf(left % ln).intValue(); 
        int endrow = Long.valueOf(right / ln).intValue(); 
        int endcol = Long.valueOf(right % ln).intValue();
        int size = Long.valueOf(right-left + 1).intValue(); 
        int answer[]  = new int[size]; 
        int cnt = 0 ; 
        for(int i = startrow; i <= endrow; i ++){
            if(i == startrow && i == endrow) { 
                for(int j = startcol ; j <= endcol; j ++){
                    answer[cnt++] = Math.max(i,j) + 1; 
                }
            }
            else if(i == startrow){
                for(int j = startcol; j < n ; j ++){
                      answer[cnt++] =  Math.max(i,j) + 1; 
                }
            }
            else if(i == endrow) { 
                for(int j = 0 ; j <= endcol; j ++){
                   answer[cnt++] = Math.max(i,j) + 1; 
                }
            }
            else {
                for(int j = 0 ; j < n; j ++){
                      answer[cnt++] =  Math.max(i,j) + 1; 
                }
            }
        }
        
        return answer;
    }
}