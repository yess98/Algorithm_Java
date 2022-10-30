package Programmers;
import java.util.*; 
public class Soluion_불량사용자 {
	static ArrayList al = new ArrayList <ArrayList<String > >(); 
    static HashSet answer_hs = new HashSet <>(); 
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        for(int i = 0 ; i < banned_id.length ; i ++){
            String s = banned_id[i]; 
            ArrayList <String > temp = new ArrayList <>(); 
            for(int j =0 ; j < user_id.length ; j ++){
                if (user_id[j].length () != s.length ()) continue; 
                boolean flag = true; 
                for(int k = 0 ; k < user_id[j].length () ; k ++){
                    if (s.charAt(k) == '*') continue; 
                    if (s.charAt(k ) == user_id[j].charAt(k)) continue; 
                    else {
                        flag = false; 
                        break; 
                    }
                }
                if(flag) {
                    temp.add(user_id[j]); 
                }
            }
            al.add(temp); 
        }
        dfs(new HashSet (), 0, al.size(),0); 
        return answer_hs.size(); 
    }
    public void dfs(HashSet hs, int cnt, int n, int start ) { 
        if(hs.size() == n){
            ArrayList <String> list = new ArrayList <>(hs);
            Collections.sort(list);
            if(!answer_hs.contains(list)){
            answer_hs.add(list);
            }
            
            return ; 
        }
        for(int i = start; i < al.size() ; i ++){
            ArrayList t = (ArrayList)al.get(i); 
            int size = t.size(); 
            for(int j = 0 ; j < size ; j++){
                String temp = (String)t.get(j); 
                if (hs.contains(temp)) continue; 
                else {
                    hs.add(temp); 
                    dfs(hs, cnt +1, n, i + 1); 
                    hs.remove(temp);
                }
            }
        }
    }
}

