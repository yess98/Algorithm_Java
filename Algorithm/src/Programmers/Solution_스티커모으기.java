package Programmers;
import java.util.*; 
public class Solution_스티커모으기 {
    static int  [] dp1; 
    static int [] dp2; 
    public int solution(int sticker[]) {
        int answer = 0;
        dp1 = new int [sticker.length -1 ]; 
        dp2 = new int [sticker.length -1];
        if (sticker.length == 1 ) return answer = sticker[0]; 
        else if (sticker.length ==2 ) return answer = Math.max(sticker[0], sticker[1]); 
            dp1[0] = sticker[1]; 
            dp1[1]  =  Math.max(sticker[1],sticker[2]); 
            for(int i = 3 ; i < sticker.length ; i ++){
                dp1[i-1] = Math.max(dp1[i-2] , sticker[i] + dp1[i-3]); 
            }
            dp2[0] = sticker[0];
            dp2[1] = Math.max(sticker[0], sticker[1]); 
            for(int i = 2; i < sticker.length -1; i ++){
                dp2[i] = Math.max(dp2[i-1], sticker[i] + dp2[i-2]); 
            }
        answer = Math.max(dp2[dp2.length -1], dp1[dp1.length -1]); 
        return answer; 
    }
}
