package Programmers;
import java.util.*; 

class Solution_네트워크 {
    Queue <Integer> queue = new ArrayDeque<>(); 
    boolean [] visited; 
    public int solution(int n, int[][] computers) {
        visited = new boolean [computers.length]; 
        int answer = 0;
        for(int i = 0 ; i < computers.length ; i ++){
            if(!visited[i]){
                visited[i] = true; 
                queue.add(i); 
                answer ++; 
            }
            while (!queue.isEmpty()) {
                int now = queue.poll();
                for(int j = 0 ; j < computers[now].length ; j ++){
                    if(!visited[j] && computers[now][j] == 1) {
                        queue.add(j); 
                        visited[j] = true;
                    }
                }
            }
        }
        return answer;
    }
}