package Programmers;

import java.util.*; 
public class Solution_두큐합같게만들기 {
	  static long sum = 0 ; 
	    static long half = 0; 
	    static long  queue1sum = 0 ; 
	    static long queue2sum = 0 ; 
	    static int [] nums; 
	    public int solution(int[] queue1, int[] queue2) {
	        int answer = 0;
	        nums = new int [queue1.length + queue2.length + queue1.length]; 
	        for(int i = 0  ; i < queue1.length ; i ++){
	            sum += queue1[i]; 
	            queue1sum += queue1[i]; 
	            nums[i] = queue1[i]; 

	        }
	        for(int i = 0 ; i < queue2.length ; i ++){
	            sum += queue2[i];
	            queue2sum += queue2[i];
	            nums[i + queue1.length] = queue2[i]; 
	        }
	        for(int i = 0 ; i < queue1.length ; i ++){
	            nums[i + queue1.length + queue2.length] = queue1[i]; 
	        }
	        if (sum % 2 == 1) return -1; 
	        half = sum/2; 
	        if (queue1sum  == half && queue2sum == half) return 0; 
	        int idx = 0; 
	        int idx2 = queue1.length - 1; 
	        while (idx < nums.length -1  && idx2  < nums.length -1 ) { 
	            if (queue1sum < half) {

	                idx2++ ; 
	                queue1sum += nums[idx2]; 
	                answer ++; ㄴ
	            }
	            else if (queue1sum == half) break; 
	            else {
	                queue1sum -= nums[idx]; 
	                idx ++; 
	                answer ++; 
	            }
	        }
	        if (queue1sum != half) return -1; 
	        return answer;
	    }
}
  