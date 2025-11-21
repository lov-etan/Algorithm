import java.util.*;

class Solution {
    int[][] maps;
    int N; int M;
    boolean[][] vis;
    
    int dr[] = {1,0,-1,0};
    int dc[] = {0,1,0,-1};
    
    boolean inRange(int r, int c) {
        return r>=0 && r<N && c>=0 && c<M;
    }
    
    int bfs(int sr, int sc) {
        Queue<int[]> q = new LinkedList<>();
        vis[sr][sc] = true;
        q.add(new int[]{sr,sc,1});
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0]; int c = curr[1]; int cnt = curr[2];
            if(r == N-1 && c==M-1) return cnt;
            
            for(int d=0; d<4; d++) {
                int nr = r+dr[d];
                int nc = c+dc[d];
                
                if(inRange(nr,nc) && maps[nr][nc] == 1 && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.add(new int[]{nr,nc,cnt+1});
                }
            }
        }
        return -1;
    }
    
    public int solution(int[][] maps) {
        this.maps = maps;
        N = maps.length; M = maps[0].length;
        vis = new boolean[N][M];
        
        return bfs(0,0);
        
    }
}