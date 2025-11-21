import java.util.*;
class Solution {
    int[][] maps;
    
    int dr[] = {1,0,-1,0};
    int dc[] = {0,1,0,-1};
    
    boolean inRange(int r, int c) {
        return r>=0 && r<101 && c>=0 && c<101;
    }
    
    int bfs(int sr, int sc, int er, int ec) {
        boolean[][] vis = new boolean[101][101];
        Queue<int[]> q = new LinkedList<>();
        
        vis[sr][sc] = true;
        q.add(new int[]{sr,sc,0});
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r=curr[0]; int c=curr[1];
            if(r == er && c == ec) return curr[2];
            
            for(int d=0; d<4; d++) {
                int nr = r+dr[d]; int nc = c+dc[d];
                if(inRange(nr,nc) && maps[nr][nc] == 1 && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.add(new int[]{nr,nc,curr[2]+1});
                }
            }
        }
        return 0;
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        maps = new int[101][101]; // 꼭지점 => 배열처럼 만들어주기 위해 모든 걸 2배!
        
        for(int i=0; i<rectangle.length; i++) {
            int sr = rectangle[i][0]*2; int sc = rectangle[i][1]*2;
            int er = rectangle[i][2]*2; int ec = rectangle[i][3]*2;
            
            for(int r=sr; r<=er; r++) {
                for(int c=sc; c<=ec; c++) {
                    maps[r][c] = 1;
                }
            }
        }
        
        for(int i=0; i<rectangle.length; i++) {
            int sr = rectangle[i][0]*2; int sc = rectangle[i][1]*2;
            int er = rectangle[i][2]*2; int ec = rectangle[i][3]*2;
            
            for(int r=sr+1; r<=er-1; r++) {
                for(int c=sc+1; c<=ec-1; c++) {
                    maps[r][c] = 0;
                }
            }
        }
        
        // for(int r=0; r<21; r++) {
        //     for(int c=0; c<21; c++) {
        //         System.out.print(maps[r][c]);
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        
        int cnt = bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        return cnt/2;
    }
}