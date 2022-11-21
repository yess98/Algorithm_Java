package Programmers;
import java.util.*; 
public class Solution_광고삽입 {
	  static ArrayList <int [] > al = new ArrayList <>() ; 
	    static int max = Integer.MIN_VALUE; 
	    static int maxEnd = 0; 
	    static int [] time; 
	    public String solution(String play_time, String adv_time, String[] logs) {
	        String answer = "";
	        int adv = parseTime(adv_time);
	        int play = parseTime(play_time); 
	        time = new int [play + 1]; 
	        for(int i = 0 ; i < logs.length ; i ++){
	            String str[] = logs[i].split("-");
	            int start = parseTime (str[0]); 
	            int end = parseTime(str[1]); 
	            for(int j = start; j < end; j ++){
	                time[j] ++; 
	            }
	        }



	        long sum = 0 ; 
	        for(int i = 0 ; i < adv ; i ++){
	            sum += time[i]; 
	        }
	        long max = sum; 
	        int start = 0 ; 

	        for(int i = 1, j = adv; j < time.length ; i ++, j ++){
	                sum += time[j] -time[i -1 ]; 
	                if(max < sum ) {
	                    max = sum; 
	                    start = i; 
	                }
	        }

	        answer = parseTime2(start); 

	        return answer;
	    }
	    public String parseTime2(int t) {
	        String [] str = new String [3]; 
	        str[0] = t % 60  < 10 ? "0" + String.valueOf(t%60) : String.valueOf(t%60); 
	        t/=60; 
	        str[1] = t % 60  < 10 ? "0" + String.valueOf(t%60) : String.valueOf(t%60); 
	        t /=60; 
	        str[2] = t  < 10 ? "0" + String.valueOf(t) : String.valueOf(t); 

	        return str[2] + ":"  + str[1] + ":" +  str[0]; 
	    } 
	    public int parseTime(String s ) {
	        String [] str = s.split(":"); 
	        int time = 0 ; 
	        time += Integer.parseInt(str[0]) * 60 * 60 ; 
	        time += Integer.parseInt(str[1]) * 60 ; 
	        time += Integer.parseInt(str[2]); 
	        return time; 
	    }
}
