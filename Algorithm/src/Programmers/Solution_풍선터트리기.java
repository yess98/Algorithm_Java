package Programmers;
import java.util.*;
class Solution_풍선터트리기 {
    static int leftmin []; 
    static int rightmin []; 
    public int solution(int[] a) {
        int answer = a.length; 
        leftmin = new int [a.length]; 
        rightmin = new int [a.length]; 
        leftmin[0] = a[0]; 
        for(int i = 1 ; i < a.length ; i ++){
            leftmin[i] = Math.min (leftmin[i-1],a[i]);
        }
        rightmin[a.length-1] = a[a.length-1];
        for(int i = a.length -2 ; i >= 0 ; i --){
            rightmin[i] = Math.min(rightmin[i+1],a[i]);
        }
        for(int i = 0 ; i < a.length ; i ++){
            if(a[i] > leftmin[i] && a[i] > rightmin[i]) answer --;
        }
        return answer;
    }
}