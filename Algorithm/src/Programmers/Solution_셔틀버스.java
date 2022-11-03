package Programmers;
import java.util.*; 
public class Solution_셔틀버스 {
	 static PriorityQueue <Integer> pq= new PriorityQueue<>(); 
	    public String solution(int n, int t, int m, String[] timetable) {
	        String answer = "";
	        for(int i = 0 ; i < timetable.length ; i ++){
	            String time[] = timetable[i].split(":"); 
	            pq.add(calculateTime(Integer.parseInt(time[0]), Integer.parseInt(time[1])));     
	        }
	        int startTime = calculateTime(9, 0);
	         int cnt = 0 ;
	        int last = 0 ; 
	       int temp = 0; 
	        for(int i = 0 ; i < n  ; i ++) {
	             temp = startTime + t * (i);
	            cnt = 0; 
	            last = 0; 
	            while (!pq.isEmpty() && pq.peek() <= temp) { 
	                last = pq.peek();
	                pq.poll(); 
	                cnt ++; 
	                if(cnt == m){
	                    break;
	                }
	            }
	        }
	        if(cnt == m){
	            answer = changetoString(last-1); 
	        }
	        else {
	            answer = changetoString(temp); 
	        }
	        return answer;
	    }
	    public String changetoString(int time){
	        StringBuilder sb = new StringBuilder(); 
	        int t = time / 60; 
	        if (t < 10) {
	            sb.append(0).append(t).append(":"); 
	        }
	        else sb.append(t).append(":"); 
	        int m = time % 60 ; 
	        if (m < 10 ){
	            sb.append(0).append(m); 
	        }
	        else sb.append(m);
	        return sb.toString(); 
	    }
	    public int calculateTime(int time, int min){
	        return time * 60 + min; 
	    }
}
