import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, cnt, minDiff;
    static int[] population, area;
    static List<Integer>[] list;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //구역의 개수

        population = new int[N+1]; //인구 수
        list = new ArrayList[N+1]; //인접구역 정보
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            list[i] = new ArrayList<>(); //점점 안에 들어갈 노드 만들어주기(인접정보)
        }


        for(int i=1; i<=N; i++) { //인접구역 정보 저장
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken()); //인접 구역 수
            for(int j=1; j<=h; j++) {
                int num = Integer.parseInt(st.nextToken());
                list[i].add(num); //정점 i의 인접정점 num 저장
            }
        }

        //System.out.println(Arrays.toString(list));

        //선거구를 두 개로 나눈다. (인접한 것들을 따라)
        area = new int[N+1]; //area 결과는 1 또는 2 //area1 area2 결과값이 들어간다.
        minDiff = Integer.MAX_VALUE; //가장 작은 차이를 구하겠다.
        comb(1); //1번 정점부터 레츠고

        if(minDiff == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(minDiff);



    }

    static void comb(int curr) {
        //기저 조건
        if(curr == N+1){ //다 돌았다
            //각 집합의 인구 수 파악하기
            int area1pop = 0;
            int area2pop = 0;
            for(int i=1; i<=N; i++) {
                if(area[i]==1) area1pop += population[i];
                else area2pop += population[i];
            }

            //각 그룹이 서로 인접하여 이루어져 있는지 파악하기
            visited = new boolean[N+1];
            cnt = 0; //집합의 개수(area 무조건 2개이니까 2개 만들어져야 한다)
            for(int i=1; i<=N; i++) {
                if(!visited[i]) {
                    bfs(i, area[i]);
                }
            }

            //서로 연결된 그룹의 수가 2개 이면 그 수의 차이가 가장 작은 것으로 업데이트 한다.
            if(cnt == 2){
                minDiff = Math.min(minDiff, Math.abs(area1pop - area2pop));
            }
            return;

        }


        //재귀 파트
        area[curr] = 1; //1번 구역에 할당
        comb(curr+1); //다음 정점으로 넘어가기

        area[curr] = 2; //2번 구역에 할당
        comb(curr+1); //다음 정점으로 넘어가기
    }


    static void bfs(int v, int areaNum){
        Queue<Integer> q = new LinkedList<>();
        q.add(v); //해당 정점 넣기
        visited[v] = true;

        while(!q.isEmpty()) {
            int curV = q.poll();

            for(int next : list[curV]){
                if(!visited[next] && area[next] == areaNum){ //현재 지점과 다음 지점이 같은 집합(area)이고 연결되어 있으며 아직 방문하지 않았으면 bfs가 간다
                    visited[next] = true;
                    q.add(next);
                }
            }


        }
        cnt++; //섬 하나 만들어짐 (총 2개여야만 해)


    }




}