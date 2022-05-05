package Programmers;
import java.util.*; 
public class Solution_주차요금계산 {
    static int [] sfees; 
    public int[] solution(int[] fees, String[] records) {
       int [] answer ; 
        sfees =new int [4]; 
        sfees = fees.clone(); 
        ArrayList [] al = new ArrayList [10000]; 
        for(int i = 0 ; i < al.length ; i ++){
            al[i] = new ArrayList<Integer>(); 
        }
        int cnt = 0 ; 
        for(int i = 0; i < records.length ; i ++){
            String [] str = records[i].split(" ");
            int carNum = Integer.parseInt(str[1]); 
            if (al[carNum].size() == 0 ) cnt ++; 
            al[carNum].add(makeTime(str[0])); 
            
        }
        answer = new int [cnt ]; 
        int index = 0 ; 
        for(int i = 0 ; i < al.length ; i ++){
            if (al[i].size() != 0 ){
                if (al[i].size() % 2 == 0 ){
                    int price  = charge(al[i]); 
                                    answer[index++] = price; 
                }
                else{
                    al[i].add(1439); 
                    int price = charge(al[i]); 
                                    answer[index++] = price; 
                }
            }
        }
        
        return answer;
    }
    
    public int charge(ArrayList <Integer>  al ){
        int sum = 0 ; 
        for(int i = 0 ; i < al.size() ; i  = i + 2){
            sum += al.get(i + 1) - al.get(i);  
        }
        if (sum <= sfees[0]) return sfees[1]; 
        else{
            int hprice = (sum-sfees[0]) % sfees[2] ==  0 ? (sum-sfees[0]) / sfees[2]: (sum-sfees[0]) /sfees[2] + 1;
            return sfees[1] + hprice * sfees[3];
        }
    }
    public int  makeTime(String time){
        int hour = Integer.parseInt(time.substring(0,2));
        int bun = Integer.parseInt(time.substring(3,5)); 
        hour = hour * 60; 
        bun = hour + bun; 
        return bun; 
    }
}