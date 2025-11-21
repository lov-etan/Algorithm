import java.util.*;

class Solution {
    int n;
    int[][] computers;
    Queue<Integer> q = new LinkedList<>();
    boolean vis[];
    
    void bfs(int start) {
        vis[start] = true;
        q.add(start);
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for(int i=0; i<n; i++) {
                if(computers[curr][i] == 1 && !vis[i]) {
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
        
        
    }
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        
        int answer = 0;
        vis = new boolean[n];
        for(int i=0; i<n ;i++) {
            if(!vis[i]) {
                bfs(i);
                answer++;
            }
        }
        
        
        return answer;
    }
}