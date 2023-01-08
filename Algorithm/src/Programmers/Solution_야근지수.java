package Programmers;

import java.util.*; 
class Solution_야근지수 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue <Integer> pq = new PriorityQueue <>(new Comparator <Integer>() {
            @Override 
            public int compare (Integer a, Integer b ){
                return b - a; 
            } 
        }); 
        for(int work : works) {
            pq.add( work); 
        }
        while (n --> 0) {
            pq.add(pq.poll() - 1);
        }
        while (!pq.isEmpty()){
            if (pq.peek() <= 0 ) {
                pq.poll(); 
                continue;
            }
            answer += Math.pow(pq.poll(),2);
        }
        return answer;
    }
}