package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution_순위검색 {
	 static HashMap <String, ArrayList<Integer>> hm = new HashMap <>();  
	    static HashMap <Integer, Integer> hm2 = new HashMap <>() ; 
	    public int[] solution(String[] info, String[] query) {
	        for(int i = 0 ; i < info.length ; i ++){
	            fillHashMap(info[i].split(" "),0,""); 
	        }
	        for(String s : hm.keySet()) { 
	            Collections.sort(hm.get(s)); 
	        }
	        int[] answer = new int [query.length];
	        for(int i = 0 ; i < query.length ; i ++){
	            String [] str = query[i].replaceAll(" and", "").split(" ");
	            StringBuilder sb = new StringBuilder() ; 
	            for(int j = 0 ; j < str.length-1 ; j ++){
	                sb.append(str[j]); 
	            }
	            if(hm.containsKey(sb.toString())) {
	                int limit = Integer.parseInt(str[str.length -1]); 
	                answer [i] = countMatching(sb.toString(), limit); 
	            }

	        }
	        return answer;
	    }
	    public int  countMatching(String key, int limit ) { 
	        ArrayList  al = hm.get(key); 
	        int left = 0 ; 
	        int right = al.size() - 1; 

	        while (left <= right ) { 
	            int mid = (left + right) / 2; 
	            if((int)al.get(mid) >= limit){
	                right= mid - 1;
	            }
	            else { 
	                left  = mid + 1;
	            }
	        }
	        return al.size() -left; 

	    }
	    public void print() { 
	        System.out.println(hm); 
	    }
	    public void fillHashMap(String  [] info, int cnt, String s) { 
	        if(cnt == 4) { 
	            if(hm.containsKey(s)) { 
	                    ArrayList <Integer> al = hm.get(s); 
	                    al.add(Integer.parseInt(info[info.length -1])); 
	                    hm.put(s, al); 
	            }
	            else { 
	                ArrayList <Integer> al = new ArrayList<>() ; 
	              al.add(Integer.parseInt(info[info.length -1])); 
	                hm.put(s, al); 
	            }
	            return ; 
	        }
	        fillHashMap(info, cnt + 1, s + "-"); 
	        fillHashMap(info, cnt + 1, s + info[cnt]); 
	    }
}
