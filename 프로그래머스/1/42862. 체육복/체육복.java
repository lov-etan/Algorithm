import java.util.*;

class Solution {
    int n;
    boolean[] lostVis;
    boolean[] reserveVis;
    int answer = 0;
    
    void dfs(int idx, int cnt) {
        if(idx == n+1) {
            answer = Math.max(answer, cnt);
            return;
        }
        
        if(lostVis[idx]) {
            if(idx >= 2 && reserveVis[idx-1]) {
                lostVis[idx] = false; reserveVis[idx-1] = false;
                dfs(idx+1, cnt+1);
                lostVis[idx] = true; reserveVis[idx-1] = true;
            }
            if(idx <= n-1 && reserveVis[idx+1]) {
                lostVis[idx] = false; reserveVis[idx+1] = false;
                dfs(idx+1, cnt+1);
                lostVis[idx] = true; reserveVis[idx+1] = true;
            }
        }
        
        dfs(idx+1, cnt);
    }
    
    public int solution(int n, int[] lost, int[] reserve) {
        this.n = n;
        lostVis = new boolean[n+1];
        reserveVis = new boolean[n+1];
        
        int lostCnt = lost.length;
        for(int i=0; i<lost.length ;i++) {
            lostVis[lost[i]] = true;
        }
        for(int i=0; i<reserve.length ;i++) {
            reserveVis[reserve[i]] = true;
        }
        
        for(int i=1; i<=n; i++) {
            if(reserveVis[i] && lostVis[i]) {
                lostCnt--;
                reserveVis[i] = false;
                lostVis[i] = false;
            }
        }
        
        dfs(1, n-lostCnt);
        
        return answer;
    }
}