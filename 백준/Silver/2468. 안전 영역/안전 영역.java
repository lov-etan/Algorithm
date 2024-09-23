import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, highest, cnt;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class pos{
        int r, c;

        pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); //N*N
        highest = 0;
        map = new int[N][N];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                int num = Integer.parseInt(st.nextToken());
                map[r][c] = num;
                highest = Math.max(highest, num); //가장 큰 수를 찾아라!
            }
        }

        //장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 출력한다.
        int max = 0; //최대 섬의 개수

        for(int rain=0; rain<=highest; rain++){ //rain 이하는 다 물에 잠겨 - 물에 잠기지 않은 영역 구하기
            //비가 아예 안 올 때도 고려해야 하는가? 
            //해당 강수량일 때, 안전한 영역의 개수를 구한다.
            cnt = 0;
            visited = new boolean[N][N];

            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(map[r][c] > rain && !visited[r][c]){
                        bfs(r,c,rain); //rain 이하는 갈 수 없는 bfs 실행
                    }
                }
            } //섬 짜기 끝 //해당 강수량일 때 섬의 개수가 여기서 결정지어짐

            max = Math.max(max, cnt);
            //System.out.println(cnt);
            //System.out.println(Arrays.deepToString(visited));
        }

        System.out.println(max);

    }//main

    static void bfs(int sr, int sc, int rain){
        Queue<pos> q = new LinkedList<>();
        //시작점 큐에 넣기
        q.add(new pos(sr, sc));
        visited[sr][sc] = true;

        while(!q.isEmpty()){
            pos curr = q.poll(); //큐에서 빼주기
            int r = curr.r, c = curr.c;

            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]>rain && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new pos(nr, nc));
                }
            }

        }

        cnt++; //하나의 섬이 완성되면 cnt++;
    }
}