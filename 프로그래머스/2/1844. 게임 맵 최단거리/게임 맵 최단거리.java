//최단거리, bfs //0-벽 | 1-갈 수 있는 길
import java.util.*;

class Solution {
    int n, m, min;
    int[][] maps;
    boolean[][] visited;
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    
    class pos{
        int r, c, distance;
        
        pos(int r, int c, int distance){
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }
    
    public int solution(int[][] maps) {
        this.maps = maps;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        
        
        min = 987654321; // 지나가야 하는 칸의 개수의 최솟값 
        //내 위치: 0,0 상대위치: n-1, m-1
        bfs(0,0,1); //r,c
        
        
        int answer = 0;
        if(min == 987654321) {
            answer = -1;
        } else {
            answer = min;
        }
        return answer;
    }
    
    void bfs(int x, int y, int distance){
        Queue<pos> q = new LinkedList<>();
        q.add(new pos(x,y,distance));
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            pos curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            
            //기저조건
            if(r == n-1 && c == m-1){
                min = curr.distance;
                break;
            }
            
            for(int d=0;d<4;d++){
                int nr = r + dr[d];
                int nc = c+ dc[d];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && maps[nr][nc] == 1){
                    visited[nr][nc] = true;
                    //System.out.println(curr.distance);
                    q.add(new pos(nr, nc, curr.distance+1));
                }
            }
            
            
        }//while
        
        return;
    }
    
}