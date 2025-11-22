import java.util.*;

class Solution {
    int n;
    int[][] computers;
    boolean[] vis;
    
    void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for(int i=0; i<n; i++) {
                if(i == curr) continue;
                if(!vis[i] && computers[curr][i] == 1) {
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        vis = new boolean[n];
        
        int answer = 0;
        
        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                vis[i] = true;
                bfs(i);
                answer++;
            }
        }
        
        
        return answer;
    }
}