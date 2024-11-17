import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static private class Pos{
        int r, c ;
        int sum;

        public Pos(int r, int c,  int sum){
            this.r = r;
            this.c = c;
            this.sum = sum;
        }

        public int getSum() { //q에 든 것 중 주변에 어디갈까? -> 루피 모인게 제일 적은 곳을 먼저 고려하자!
            return sum;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = 0;

        while(true){
            tc++;
            N = Integer.parseInt(br.readLine());

            if(N == 0){
                break;
            }

            int[][] map = new int[N][N];
            for(int r=0; r<N; r++){ //도둑루피 정보 채워넣기
                st = new StringTokenizer(br.readLine());
                for(int c=0; c<N; c++){
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            ///////////input/////////////////////
            /// Bfs 시작
            //다익스트라 - 제일 먼저 도착하는게 아니라 n-1, n-1 위치에서 제일 적은 루피를 모았길 원해
            int[][] dist = new int[N][N]; //해당 위치일 때 루치 최소 누적액
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    dist[r][c] = Integer.MAX_VALUE; //우선 최대값으로 채워넣기
                }
            }

            PriorityQueue<Pos> pq = new PriorityQueue<>(Comparator.comparing(Pos::getSum));
            pq.add(new Pos(0, 0, map[0][0])); // 0,0부터 시작
            dist[0][0] = map[0][0];

            while(!pq.isEmpty()){
                Pos curr = pq.poll();
                int r = curr.r, c = curr.c;

                for(int d=0; d<4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if(inRange(nr, nc)){
                        int newSum = curr.sum + map[nr][nc];

                        //현재 누적루피가 다음에 갈 곳의 최소누적루피(dist[nr][nc])보다 작으면
                        //아직 방문한 적 없고, 더 최소로 누적할 수 ㅇ
                        if(newSum < dist[nr][nc]){
                            dist[nr][nc] = newSum;
                            pq.add(new Pos(nr, nc , newSum));
                        }
                    }
                }
            }

            System.out.println("Problem " + tc + ": " + dist[N-1][N-1]);

        }




    }

    private static boolean inRange(int nr, int nc) {
        if(nr >= 0 && nr < N && nc >=0 && nc <N){
            return true;
        }
        return false;
    }
}