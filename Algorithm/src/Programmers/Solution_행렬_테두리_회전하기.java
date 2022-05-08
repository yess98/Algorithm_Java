package Programmers;

import java.util.*;
public class Solution_행렬_테두리_회전하기 {
    static int [][] map ; 
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length]; 
        map = new int [rows][columns];
        int num = 1; 
        for(int i = 0 ; i < map.length ; i ++){
            for(int j = 0 ; j < map[0].length; j ++){
                map[i][j] = num++;
            }
        }
        for(int i = 0  ; i < queries.length ; i ++){
            int [] temp = queries[i]; 
            int sx = temp[0] - 1; 
            int sy = temp[1] - 1 ; 
            int ex = temp[2] - 1 ; 
            int ey = temp[3] - 1; 
            answer[i] = rotate(sx,sy,ex,ey); 
        }
        return answer;
    }
    public int rotate(int x, int y, int x2, int y2){
        int num = map[x][y];
        int min = num; 
        for(int i = x + 1 ; i <= x2; i ++){
            map[i-1][y] = map[i][y];  
            min = Math.min(min, map[i-1][y]); 
        }
        for(int i = y  + 1; i <= y2 ; i++){
            map[x2][i-1] = map[x2][i]; 
            min = Math.min(min, map[x2][i-1]); 
        }
        for(int i = x2 -1 ; i >= x ; i --){
            map[i + 1][y2] = map[i][y2]; 
            min = Math.min(min, map[i+1][y2]); 
        }
        for(int i = y2 -1 ; i >= y + 1 ; i --){
            map[x][i + 1] = map[x][i] ; 
            min = Math.min(min, map[x][i+1]); 
        }
        map[x][y + 1] = num; 
        return min; 

    }
}