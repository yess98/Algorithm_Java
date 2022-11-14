package Programmers;
import java.util.*; 
public class Solution_보석쇼핑 {
	 HashMap <String , Integer> hm; 
	    HashMap <String , Integer> hm2; 
	    int min ; 
	    public int[] solution(String[] gems) {
	        int[] answer = new int[2];
	        hm = new HashMap<>(); 
	        hm2 = new HashMap<>(); 
	        min = gems.length + 1 ; 
	        for(int i = 0 ; i < gems.length ; i ++){
	            if (hm.containsKey(gems[i])) { 
	                hm.put(gems[i], hm.get(gems[i]) + 1); 
	            }
	            else hm.put(gems[i], 1); 
	        }
	        int size = hm.size() ; 
	        int right  = 0 ; 
	        int left = 0 ; 
	        while (true ){
	            if(hm2.size() == size) {
	                if (right  - left < min ) {
	                    min = Math.min(right - left , min); 
	                    answer[0] = left + 1; 
	                    answer[1] = right; 
	                }
	                if (hm2.get(gems[left]) == 1){
	                    hm2.remove(gems[left]); 
	                }
	                else hm2.put(gems[left], hm2.get(gems[left]) -1); 
	                left ++; 
	            }
	            else if (right == gems.length) break; 
	            else {
	                if(hm2.containsKey(gems[right])) hm2.put(gems[right], hm2.get(gems[right]) + 1); 
	                else hm2.put(gems[right] ,1 ); 
	                right ++; 
	            }
	        }
	        return answer;
	    }
}
