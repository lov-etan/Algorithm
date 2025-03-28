import java.util.*;

class Solution {
    static String alph[] = {"A", "E", "I", "O", "U"};
    static ArrayList<String> list;
     
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        dfs("", 0);
        
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
            }
        }
        
        return answer;
    }
    
    public void dfs(String str, int len) {
        list.add(str);
        if(len == 5) return; //5이상의 len 붙는건 막기 
        for(int i=0; i< 5; i++) {
           dfs(str+alph[i], len+1);
        }
    }
}