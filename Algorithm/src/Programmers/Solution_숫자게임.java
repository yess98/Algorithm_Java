package Programmers;
import java.util.*; 
public class Solution_숫자게임 {
	public int solution(int[] A, int[] B) {
        int answer = -1;
        Arrays.sort(A);
        Arrays.sort(B); 
        int idx = 0 ; 
        int point = 0 ; 
        for(int i = 0 ; i < A.length ; i ++){
            int temp = A[i]; 
            for(int j = idx ; j < B.length  ; j ++){
                if (temp < B[j]){
                    // B가 이김 
                    idx = j + 1; 
                    point++; 
                    break; 
                }
                else { 
                    // 동점 or 짐 
                    continue; 
                }
            }
        }
        if (point == -1) answer = 0 ; 
        else answer = point; 
        return answer;
    }
}
