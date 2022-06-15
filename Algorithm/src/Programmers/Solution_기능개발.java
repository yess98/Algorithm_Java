package Programmers;

import java.util.ArrayList;

public class Solution_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        for(int i = 0 ; i < progresses.length ; i ++){
            if((100-progresses[i]) % speeds[i] !=0){
                 progresses[i] = (100-progresses[i])/speeds[i] + 1;
            } 
            else{
                progresses[i] = (100-progresses[i])/speeds[i];
            }
        }
        ArrayList<Integer>al = new ArrayList<>(); 
    
        for(int i = 0 ; i < progresses.length;){
            int temp = progresses[i]; 
            int cnt = 0 ; 
            for(int j = i + 1; j < progresses.length ; j ++){
                if(progresses[j] > temp) break;
                else cnt ++; 
            }
            i = i + cnt + 1; 
            al.add(cnt + 1); 
        }
        answer = new int [al.size()]; 
        for(int i = 0 ; i < al.size(); i ++){
            answer[i] = al.get(i); 
        }
        return answer;
    }
    
}
