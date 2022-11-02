package Programmers;

import java.util.PriorityQueue;
import java.util.*; 
public class Solution_이중우선순위큐 {
	 static PriorityQueue <Integer> max; 
	    static PriorityQueue <Integer> min ;
	    public int[] solution(String[] operations) {
	        int[] answer = new int[2]; 
	        max = new PriorityQueue<Integer> (new Comparator <Integer>() { 
	            @Override 
	            public int compare (Integer a, Integer b ) {
	                return b-a; 
	            }
	        }) ;
	        min = new PriorityQueue <Integer> (new Comparator <Integer>() { 
	            @Override 
	            public int compare (Integer a, Integer b ) {
	                return a-b; 
	            }
	        }) ;
	        for(int i = 0 ; i < operations.length ; i ++){
	            StringTokenizer st = new StringTokenizer(operations[i]); 
	            String oper = st.nextToken() ; 
	            int num = Integer.parseInt(st.nextToken()); 
	            if(oper.equals("I")){
	                min.add(num); 
	                max.add(num); 
	            }
	            else if (oper.equals("D") && num == -1 && !min.isEmpty()){
	                int temp = min.poll(); 
	                max.remove(temp); 
	            }
	            else if (oper.equals("D") && num == 1 && !max.isEmpty()) {
	                int temp =max.poll() ; 
	                min.remove(temp);  
	            }
	        }
	        if(min.size() == 0 || max.size() == 0 ) {
	            answer[0] = 0; 
	            answer[1] = 0; 
	            return answer; 
	        }
	        if(min.size() != 0 )answer[0] = max.peek(); 
	        if (max.size() != 0 ) answer[1] = min.peek(); 
	        return answer;
	    }
}
