import java.util.*;
class Solution {
    int answer = -1;
    int k; 
    int[][] dungeons;
    boolean[] vis;
    ArrayList<Integer> picks = new ArrayList<>();
    
    int Explore() {
        int cnt = 0;
        int energy = k;
        
        for(int p : picks) {
            if(dungeons[p][0] <= energy) {
                energy -= dungeons[p][1];
                cnt++;
            }
        }
        return cnt;
    }
    
    void dfs(int cnt) {
        if(cnt == dungeons.length) {
            answer = Math.max(answer, Explore());
        }
        
        for(int i=0; i<dungeons.length; i++) {
            if(!vis[i]) {
                vis[i] = true; picks.add(i);
                dfs(cnt+1);
                vis[i] = false; picks.remove(picks.size()-1);
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        this.k = k;
        this.dungeons = dungeons;
        vis = new boolean[dungeons.length];
        
        dfs(0);
        
        return answer;
    }
}