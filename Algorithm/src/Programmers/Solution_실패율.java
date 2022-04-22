package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_실패율 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(4,new int[]{4,4,4,4,4})));
	}
	 public static  int[] solution(int N, int[] stages) {
	        int[] answer = new int [N]; 
	        double [][] percentages = new double [N +1][2] ;
	        int [] count = new int [N + 1]; 
	        double  totalnum = stages.length ; 
	        for(int i = 0 ; i < stages.length ; i ++ )
	        {
	            if (stages[i] <= N){
	                count[stages[i]] ++; 
	            }
	            else{
	                continue; 
	            }
	        }   
	      
	        for(int i = 1; i <= N ; i++){
	            percentages[i][0] = i;
	            if (count[i] == 0 ) percentages[i][1] = 0 ; 
	            else {
	            percentages[i][1] = count[i] / totalnum;
	            totalnum -= count[i]; 
	            }
	        }
	      Arrays.sort(percentages, new Comparator<double [] >() {
			@Override
			public int compare(double[] o1, double[] o2) {
				if (Double.compare(o2[1],o1[1])== 0 ) {
					return Double.compare(o1[0], o2[0]);
				}
				return Double.compare(o2[1], o1[1]);
			}
	      });
	      int cnt = 0 ; 
	        for(int i = 0; i <= N ; i ++){
	            if(percentages[i][0] == 0 ) continue; 
	            answer[cnt] = (int) percentages[i][0];
	            cnt ++; 
	        }
	        
	        return answer;
	    }
	    
}
