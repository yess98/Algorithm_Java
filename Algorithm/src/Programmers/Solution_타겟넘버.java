package Programmers;

public class Solution_타겟넘버 {
	 static boolean [] check; 
	    static int [] oper = new int []{1,-1};
	    static int t; 
	    static int answer;
	    public static void main(String[] args) {
			int [] numbers = {1,1,1,1,1};
			int target = 3; 
			solution(numbers,target); 
	    }
	    public static int solution(int[] numbers, int target) {
	        answer = 0;
	        check = new boolean [numbers.length];
	        int d = 0 ; 
	        t  = target; 
	        dfs(0, numbers, d); 
	        return answer;
	    }
	    public static void dfs(int x , int [] numbers, int d ){
	        if (d == numbers.length) {
	        	if (t == x) {
	            answer ++; 
	        	}
	            
	            return; 
	        }
	        
	        int sum = x + numbers[d]; 
	        dfs(sum, numbers, d + 1); 
	        sum = x - numbers[d];
	        dfs(sum, numbers, d + 1); 
	    }
}
