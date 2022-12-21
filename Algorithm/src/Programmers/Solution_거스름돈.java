package Programmers;
import java.util.*; 
public class Solution_거스름돈{
    public int solution(int n, int[] money) {
        int answer = 0;
        int [] arr = new int [n + 1];
        arr[0] = 1; 
        for(int i = 0 ; i < money.length ; i ++){
            int now = money[i];
            
            for(int j = now ; j <= n ; j ++){
                arr[j] = arr[j-now] + arr[j];
            }
        }
        answer = arr[n] % 1000000007;
        return answer;
    }
}