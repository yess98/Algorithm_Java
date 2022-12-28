package Programmers;

import java.util.*; 
class Solution_징검다리건너기{
    public int solution(int[] stones, int k) {
        int answer = 0;
        if(stones.length == 1) return answer = stones[0]; 
        int min = Integer.MAX_VALUE;
        Deque <int []> queue = new ArrayDeque <>(); 
        answer = Integer.MAX_VALUE; 
        
        for(int i = 0 ; i < stones.length; i ++){
            int now = stones[i]; 
            while (!queue.isEmpty() && queue.peekLast()[1] < now ){
                queue.pollLast(); 
            }
            queue.add(new int []{i,now});
            if (queue.peekFirst()[0] <= i - k) {
                queue.pollFirst();
            }
            if (i >= k-1) answer = Math.min(answer, queue.peekFirst()[1]);
            
        } 
        return answer;
    }
}