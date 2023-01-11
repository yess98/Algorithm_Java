package Programmers;

import java.util.*; 
class Solution_아이템줍기 {
    static int [][] map ; 
    static Queue <int [] > queue = new ArrayDeque<>(); 
    static int [] dx  = {-1,1,0,0}; 
    static int [] dy = {0,0,1,-1}; 
    static int answer = 0; 
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int [102][102];
        for(int i = 0 ; i < rectangle.length; i ++){
            int rect [] = rectangle[i]; 
            for(int j = rect[0] * 2; j <= rect[2] * 2; j ++){
                for(int k = rect[1]* 2; k <= rect[3] * 2; k ++) { 
                    map[j][k] = 1; 
                }
            }
        }
        for(int i = 0 ; i < rectangle.length ; i ++){
            int []rect =  rectangle[i]; 
               for(int j = rect[0] * 2 + 1; j <= rect[2] * 2 - 1; j ++){
                for(int k = rect[1]* 2 + 1; k <= rect[3] * 2 - 1; k ++) { 
                    map[j][k] = 0; 
                }
            }
        }
        int [] start = new int [] { characterX *2 , characterY * 2}; 
        int [] goal = new int [] {itemX * 2 , itemY * 2}; 
        bfs(start, goal, rectangle); 
            
        return answer;
    }
    static int step = 0; 
    public void bfs (int [] start, int [] goal , int [][] rectangle){
        queue.add(new int [] {start[0], start[1], 0 });
         while (!queue.isEmpty()) {
                int [] temp = queue.poll(); 
                map[temp[0]][temp[1]] = -1; 
                if(temp[0] == goal[0] && temp[1] == goal[1]) 
                {   
                    answer = temp[2] / 2; 
                    break ; 
                }
                for(int i = 0 ; i < dx.length ; i ++){
                    int nx = dx[i] + temp[0]; 
                    int ny = dy[i] + temp[1]; 
                    if (nx < 0  || nx >= 102 || ny < 0 || ny >= 102) continue; 
                    if (map[nx][ny] == 1) {
                        queue.add(new int [] { nx , ny, temp[2] + 1 }); 
                    }
                }
        }
    }
}