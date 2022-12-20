package Programmers;

import java.util.*; 
public class Solution_기지국설치  {
    public int solution(int n, int[] stations, int w) {
      int answer = 0;
      int left = 1;

    for (int station : stations) {
        if (left < station - w){
            int right = station - w;

            int length = right - left;

            int count = length / (w * 2 + 1);
            if (length % (w * 2 + 1) != 0)
                count++;

            answer += count;
        
        }
        left = station + w + 1;
    }

    if(left <= n){

        int right = n + 1;

        int length = right - left;

        int count = length / (w * 2 + 1);
        if (length % (w * 2 + 1) != 0)
            count++;

        answer += count;
    }

    return answer;
    }
}