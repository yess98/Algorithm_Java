package Programmers;
import java.util.*; 
public class Solution_정수삼각형 {
	  static int [][] map; 
	    public int solution(int[][] triangle) {
	        int answer = 0;
	        map = new int [triangle.length][triangle.length];
	        for(int i = 0 ; i < triangle.length ; i ++){
	            for(int j = 0 ; j < triangle[i].length ; j ++){
	                map[i][j] = triangle[i][j]; 
	            }
	        }
	       
	        for(int i = 1 ; i < map.length ; i ++){
	            for(int j = 0 ; j <= i ; j ++){
	                if(j == 0 ){
	                    map[i][j] = map[i-1][j] + map[i][j]; 
	                }
	                else if (j == i ){
	                    map[i][j] = map[i-1][j-1] + map[i][j]; 
	                }
	                else {
	                    map[i][j] = Math.max(map[i-1][j-1] , map[i-1][j]) + map[i][j]; 
	                }
	            }
	        }
	        
	        for(int i = 0 ; i < map[map.length -1].length ; i ++){
	            answer = Math.max(answer, map[map.length-1][i]); 
	        }
	        return answer;
	    }
}
