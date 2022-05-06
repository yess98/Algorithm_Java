package Programmers;
import java.util.*; 
public class Solution_k진수에서_소수_개수_구하기 {
    public int solution(int n, int k) {
        int answer = -1;
        answer = makeNnumber(n,k); 
        return answer;
    }
    public int  makeNnumber(int n , int k ){
        StringBuilder sb = new StringBuilder(); 
        while (n > 0 ){
            int num = n % k; 
            sb.append(num); 
            n /= k; 
        }
        String numstr = sb.reverse().toString(); 
        System.out.println(sb.reverse()); 
        String [] nums = numstr.split("0"); 
        int cnt = 0 ; 
        for(int i =0 ; i < nums.length ; i ++){
            if(nums[i].equals("")) continue; 
            if (isPrimeNumber(Long.parseLong(nums[i]))) cnt ++; 
        }
        return cnt; 
    }
    public boolean isPrimeNumber(long num){
        if (num == 1) return false; 
        for(int i = 2; i <= Math.sqrt(num) ; i ++){
            if (num % i  == 0 ) return false; 
        }
        return true; 
    }
}