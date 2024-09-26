import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map, dist;
    static boolean[][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class pos{
        int x,y, crush; // 0이면 아직 안 뿌심 1이면 뿌심

        pos(int x,int y,int crush) {
            this.x = x;
            this.y = y;
            this.crush = crush;
        }
    }

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
         map = new int[N][M];

        for(int r=0; r<N; r++){
            String s = br.readLine();
            for(int c=0; c<M; c++){
                map[r][c] = s.charAt(c) - '0';
            }
        }

        visited = new boolean[2][N][M];
        //[0][x][y]: 벽 안 부순 배열
        //[1][x][y]: 벽 부순 배열

        dist = new int[N][M]; //해당 좌표일 때 거리

        //bfs
        System.out.println(bfs(0,0,0));


    }

    static int bfs(int x,int y,int crush){
        //초기는 0,0 시작 + 아직 벽 안 부숨
        Queue<pos> q = new LinkedList<>();
        q.add(new pos(x,y,crush));
        visited[0][x][y] = true;
        visited[1][x][y] = true;

        while(!q.isEmpty()){
            //만약 중간에 (N-1, M-1) 만나서 안 빠지면? - -1 출력하라
            // (목표지점까지 도달을 못하는 map인 것이다. ex_ 벽을 한번 부숴도 도달 못하고 섬 만들어질 때
            pos curr=q.poll();
            if(curr.x == N-1 && curr.y == M-1){
                return dist[curr.x][curr.y] +1;
            }

            for(int d=0; d<4; d++){ //사방탐색하며 벽이 있는 경우와 없는 경우를 생각한다.
                int nr = curr.x +dr[d];
                int nc = curr.y +dc[d];
                if(nr>=0 && nr<N && nc>=0 && nc<M){

                    //만약 벽이 아닌(0) 경우 - 현재 상태에서 방문된 적 없다면
                    if(map[nr][nc]==0 && !visited[curr.crush][nr][nc]){
                        visited[curr.crush][nr][nc] = true;
                        dist[nr][nc] = dist[curr.x][curr.y] + 1;
                        q.add(new pos(nr,nc,curr.crush));

                    } else if(map[nr][nc] ==1 && curr.crush == 0) { //아직 벽이 부숴지지 않은 상태에서 벽을 마주한다면? // 어차피 한번도 부서진 적 없는 경우니까 조건에 !visited[1][][]는 필요 없겠다
                        //curr.crush = 1; //벽을 부신 전적이 생김
                        visited[1][nr][nc] = true;
                        dist[nr][nc] = dist[curr.x][curr.y] + 1;
                        q.add(new pos(nr, nc, 1));
                    }


                }

            }

        }
        return -1;
    }


}