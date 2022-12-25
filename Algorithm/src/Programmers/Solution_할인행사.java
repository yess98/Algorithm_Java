package Programmers;
import java.util.*; 
class  Solution_할인행사 {
    static HashMap <String, Integer> want_hm; 
    static HashMap<String, Integer> discount_hm; 
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        want_hm = new HashMap<>(); 
        discount_hm = new HashMap<>();
        for(int i = 0 ; i < want.length ; i ++){
            want_hm.put(want[i],number[i]); 
        }
        for(int i = 0 ; i < 10 ; i ++){
            if (discount_hm.containsKey(discount[i])) {
                discount_hm.put(discount[i], discount_hm.get(discount[i]) + 1); 
            }
            else discount_hm.put(discount[i], 1); 
        }
        if(isAvailable()) answer ++; 
        int startIdx = 0; 
        int endIdx = 10; 
        while(endIdx < discount.length){ 
            String out = discount[startIdx]; 
            if (discount_hm.get(out) == 1) {
                discount_hm.remove(out); 
            }
            else discount_hm.put(out, discount_hm.get(out) -1); 
            String in = discount[endIdx];; 
            if (discount_hm.containsKey(in)) discount_hm.put(in, discount_hm.get(in) + 1); 
            else discount_hm.put(in,1); 
            if (isAvailable()) answer ++;
            startIdx ++;
            endIdx ++;
        }
        return answer;
    }
    public boolean isAvailable() { 
        for(String product : want_hm.keySet()) { 
            int want = want_hm.get(product);
            if (!discount_hm.containsKey(product)) return false; 
            int sales = discount_hm.get(product); 
            if (want <= sales) continue; 
            else return false; 
        }
        return true; 
    }
}