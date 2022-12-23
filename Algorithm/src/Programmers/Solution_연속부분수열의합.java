package Programmers;

import java.util.*; 
public class Solution_연속부분수열의합 {
    static int [] new_elements; 
    public int solution(int[] elements) {
        int answer = 0;
        new_elements = new int [elements.length * 2]; 
        for(int i = 0 ; i < elements.length ; i ++){
            new_elements[i] = elements[i]; 
            new_elements[i + elements.length] = elements[i]; 
        }
        
        HashSet<Integer> hs = new HashSet<>(); 
        for(int i = 0 ; i < elements.length ; i ++){
            int sum = 0 ; 
            for(int j = i; j < i + elements.length ; j ++){
                sum += new_elements[j]; 
                if (!hs.contains(sum)) hs.add(sum); 
            }    
        }
        answer = hs.size(); 
        return answer;
    }
}