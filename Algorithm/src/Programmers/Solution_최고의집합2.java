package Programmers;
import java.util.*; 
import java.util.Arrays;
class  Solution_최고의집합2 {
    public int[] solution(int n, int s) {
    int [] answer = new int [n];
      int [] temparr = new int [n]; 
        if(s <n) {
            answer =  new int [1]; 
            answer[0] = -1; 
            return answer; 
        }; 
        int cnt = 0; 
        while(s > 0){
            int temp = s/n;
            s-=temp; 
            n--;
            answer[cnt++] = temp; 
        } 
       return answer;
    }
}