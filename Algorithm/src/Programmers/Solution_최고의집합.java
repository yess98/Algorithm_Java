package Programmers;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Solution_최고의집합 {
	public static  int[] solution(int n, int s) {
	    int [] answer = new int [n];
        if(s <n) {
            answer =  new int [1]; 
            answer[0] = -1; 
            return answer; 
        }; 
        int cnt = 0; 
        while(s > 0){
            int temp = s/n;
            s-=temp; 
            n--;
            answer[cnt++] = temp; 
        } 
       return answer;
    }
	public static void main(String [] args) {
	System.out.println(Arrays.toString(solution(2,9))); 	
	}
}
