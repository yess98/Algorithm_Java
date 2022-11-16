package Programmers;
import java.util.*; 
public class Solution_다단계_칫솔_판매 {
	  static HashMap <String, String > hm = new HashMap<>(); 
	    static HashMap <String , Integer> hm2 = new HashMap <>() ; 
	    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
	        int[] answer = new int [enroll.length ]; 
	        for(int i = 0 ; i < enroll.length ; i ++){
	            String name = enroll[i]; 
	            String ref = referral[i]; 
	            hm.put(name,ref); 
	            hm2.put(name, 0); 
	        }
	        hm2.put("-",0); 
	        for(int i = 0 ; i < seller.length ; i ++){
	            String s = seller[i]; 
	            int money = amount[i] * 100 ; 
	            while (money > 0) {
	                int mine = money - money/ 10; 
	                money = money/10; 
	                hm2.put(s, hm2.get(s) + mine); 
	                if(s.equals("-")) {
	                    hm2.put(s,hm2.get(s) + money); 
	                    break;
	                }
	                else s = hm.get(s);
	            }
	        }
	        for(int i = 0 ; i < enroll.length ; i ++){
	            answer[i] = hm2.get(enroll[i]); 
	        }
	        return answer;
	    }
}
