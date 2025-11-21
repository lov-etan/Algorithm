import java.util.*;

class Node {
    String w;
    int cnt;
    
    Node(String w, int cnt) {
        this.w = w;
        this.cnt = cnt;
    }
}

class Solution {
    String target;
    String[] words;
    boolean[] vis;
    
    boolean check(String a, String b) {
        int cnt = 0;
        // 다른게 오직 하나!
        for(int i=0; i<a.length(); i++) {
            char chA = a.charAt(i); char chB = b.charAt(i);
            if(chA != chB) cnt++;
        }
        
        return cnt == 1;
    }
    
    int bfs(String start) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            if(curr.w.equals(target)) {
                return curr.cnt;
            }
            
            for(int i=0; i<words.length; i++) {
                if(!vis[i] && check(curr.w, words[i])) {
                    vis[i] = true;
                    q.add(new Node(words[i], curr.cnt+1));
                }
            }
        }
        return 0;
    }
     
    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;
        
        vis = new boolean[words.length];
        return bfs(begin);
        
        // int answer = 0;
        // return answer;
    }
}