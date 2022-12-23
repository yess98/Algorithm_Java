package Programmers;

import java.util.*; 
class Solution_귤고르기 {
    static HashMap <Integer, Integer> hm = new HashMap<>(); 
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        for(int i = 0 ; i < tangerine.length ; i ++){
            if (hm.containsKey(tangerine[i])) { 
                hm.put(tangerine[i], hm.get(tangerine[i]) + 1); 
            }
            else hm.put(tangerine[i], 1); 
        }
        ArrayList <Map.Entry<Integer, Integer>> al = new ArrayList<>(hm.entrySet()); 
        Collections.sort(al, new Comparator < Map.Entry<Integer, Integer>>() { 
        @Override 
            public int compare (Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue(); 
            }
        });
        for(int i = 0; i < al.size() ; i ++){
            int cnt = al.get(i).getValue(); 
            k=k - cnt; 
            answer ++; 
            if (k <= 0 ) break; 
        }
        return answer;
    }
}