package Programmers;

import java.util.Arrays;

import javax.sound.sampled.Port.Info;

public class Solution_양궁대회 {
	  static int maxPoint = 0 ;
	  static int [] sinfo;
	  static int [] answer; 
	  public static void main(String [] args) {
		  int [] a = {0,0,2,3,4,1,0,0,0,0,0};
		  int [] b= {9,0,0,0,0,0,0,0,1,0,0};
		  
		  int [] ret = check(a,b); 
		  System.out.println(a); 
		  System.out.println(b); 
		  System.out.println(ret); 
		  int [] ret2 = ret.clone(); 
		  
		  System.out.println(Arrays.toString(ret2)); 
		  
		  System.out.println(ret.clone()); 
	  }
	  public static int[] solution(int n, int[] info) {
	        sinfo = new int[info.length]; 
	        for(int i = 0 ; i < info.length; i ++) {
	        	sinfo[i] = info[i]; 
	        }
	        int [] temp = new int [info.length]; 
	        answer = new int [info.length]; 
	        dfs(0,0,0,n,0,temp); 
	        if (maxPoint == 0 ) {
	        	answer = new int [1]; 
	        	answer[0] = -1;
	        	return answer; 
	        }
	        else {
	        	return answer;
	        }
	       
	 }
	  public static int [] check(int [] arr, int [] answer) {
		  for(int i = 10 ; i >= 0 ; i --) {
			  System.out.println(arr[i] + " vs " + answer[i]); 
			  if (arr[i] > answer[i]) {
				
				  return arr; 
			  }
		  }
		  return answer; 
		  
	  }
	  // 라이언이 이기는 경우 
      // 어피치가 0인 경우 1, 아닌경우 어피치 점수 + 1
      
      // 어피치가 이기는 경우 
      // 라이언은 : 0 , 어피치 > 0 
	  public static void dfs(int sumA, int sumL, int cnt, int n, int i, int []arr ) {
		 
		  if (i == 10 ) {
			  if (sumL - sumA >= maxPoint) {
				  arr[10] = n - cnt; 
				  if (sumL-sumA > maxPoint) {
					  maxPoint = sumL-sumA; 
					  answer = arr.clone(); 
				  }
				  else if (sumL-sumA == maxPoint) {
					  answer = check(arr, answer).clone(); 
				  }
			  }
			  return ; 
		  }
		  
		  //라이언이 이기는 경우 
		  if(sinfo[i] + 1 + cnt  <= n ) {
			  arr[i] = sinfo[i] + 1; 
			  dfs(sumA, sumL+10-i, cnt + sinfo[i] + 1 , n, i + 1 , arr ); 
		  }
		  // 어피치가 이기는 경우 
		  arr[i] = 0 ; 
		  dfs(sumA + (sinfo[i] > 0 ? 10-i : 0), sumL, cnt, n, i + 1, arr); 
	  }
	  
}
