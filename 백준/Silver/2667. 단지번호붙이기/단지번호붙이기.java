import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, cnt, houses;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Pos{
        int r,c;

        Pos(int r,int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //정사각형 지도의 크기 N * N
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int r=0; r<N; r++){
            String str = br.readLine();
            for(int c=0; c<N; c++){
                map[r][c] = str.charAt(c) - '0';
            }
        }

        //총 단지수 and 단지내 집의 수 오름차순 정렬 출력
        cnt = 0; //총 단지수
        List<Integer> res = new LinkedList<>(); //단지내 집의 수 오름차순
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(map[r][c] == 1 && !visited[r][c]){ //집이 있는 곳에서만!! dfs ㄱㄱ!!!
                    res.add(dfs(r,c));
                    //cnt++;
                }
            }
        }
        Collections.sort(res);


        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");
        for(int counts : res){
            sb.append(counts).append("\n");
        }

        System.out.println(sb);
    }//main

    static int dfs(int r, int c){
        houses = 0;
        Queue<Pos> q = new LinkedList<>();
        //시작점 큐에 넣어주기
        q.add(new Pos(r,c));
        visited[r][c] = true;

        //큐가 빌 때까지 사방탐색하여 dfs 진행
        while(!q.isEmpty()){
            Pos curr = q.poll();
            int x = curr.r;
            int y = curr.c;
            //visited[x][y] = true; //!!! 꺼낸 녀석을 방문 췤!! //여기서 꺼내면 중복이 될 수 있음
            houses++;
            //System.out.println("r" + r + "c" + c + " x" + x + " y" + y + " houses" + houses);


            for(int d=0; d<4; d++){
                int nr = x + dr[d];
                int nc = y + dc[d];

                if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc] ==1 && !visited[nr][nc]){
                    visited[nr][nc] = true; //여기서 해줘야지 방문 췍 된 애들이 큐에 들어가서 다시 중복 체크가 안됨 
                    q.add(new Pos(nr,nc));
                }
            }


        }
        cnt++; //총 섬의 수
        return houses;
    }
}