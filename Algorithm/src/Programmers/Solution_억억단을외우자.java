package Programmers;
import java.util.*; 

class Solution_억억단을외우자 {
    static int [] num; 
    public int[] solution(int e, int[] starts) {
        int[] answer = new int [starts.length ]; 
        num = new int [e + 1]; 
       
        makeNumArr(e); 
       
        int [] maxIdxArr = new int [e + 1];
        int maxNum = 0; 
        int maxIdx = -1; 
        for(int i = e; i >= 0 ; i --){
                if(maxNum <= num[i]) {
                    maxNum = num[i];
                    maxIdx = i; 
                    maxIdxArr[i] = maxIdx;
                }
                else maxIdxArr[i] = maxIdx; 
            
        }
        for(int i = 0 ; i < starts.length ; i ++){
            answer[i] = maxIdxArr[starts[i]];  
        }
        
        return answer;
    }
    public void makeNumArr(int e ) {
      
       for(int i = 1; i <= e; i ++){
           for(int j = 1; j <= e/i; j ++){
               num[i*j] ++;
           }
       }
      
    }
}