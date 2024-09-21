import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 최소 시간 고려를 못하겠다.
    // 건물들은 동시에 건설할 수 있다.
    // 이전에 계산된 시간과 현재 건물의 시간을 더한 값 중 더 큰 값을 선택해야 한다.

    public static void main(String[] args) throws IOException {
        //Input
        //최소 시간을 간과함.. Priority Queue가 나와야 할 것만 같다..
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bufferedReader.readLine()); //건물의 개수
        int[] time = new int[N + 1]; //각 건물이 제작에 총 걸리는 시간
        int[] result = new int[N + 1];
        int[] degree = new int[N + 1]; //각 건물의 선수 조건의 개수
        List<Integer>[] adjList = new ArrayList[N + 1]; //위에거 내가 원하는 형태로(내거 쓴 다음 후순위가 들어가게 재배치 해줄 것임)
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>(); //각 정점마다 리스트 생성해주기
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bufferedReader.readLine()); //10 -1 //4 3 1 -1
            int btime = Integer.parseInt(st.nextToken()); //정점이 걸리는 시간 저장
            time[i] = btime;
            result[i] = btime;

            while (true) { //-1이 나올 때까지 저장하기
                int V = Integer.parseInt(st.nextToken());
                //System.out.println("V" + V);
                if (V == -1) break;
                adjList[V].add(i);
                degree[i]++;
            }
            //System.out.println(Arrays.toString(adjList));
        }

        //N개의 각 건물이 완성되기까지 걸리는 최소 시간을 출력한다.
        Queue<Integer> queue = new LinkedList<>();
        //선수 조건 없는 애들 큐에 넣어주기
        for (int k = 1; k <= N; k++) {
            if (degree[k] == 0) {
                queue.add(k);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll(); //선수 조건 다 만족해서 나올 애들 빠지기 //2 ,3

            //그 애들의 인접한 애들 뽑아주기
            for (int adj : adjList[curr]) { //그 리스트에 있는 애들 정점 하나씩 뽑아주기 //2(20)-4(4), 3(30)-4(4)
                degree[adj]--;

                result[adj] = Math.max(result[adj], result[curr] + time[adj]); //20이 될테고 //30이 더 크니 30이 될테다
                //여기에 두면 동일한 degree 만족할 때의 상황에서 계산할 수 있게 된다.
                // 4의 누적시간 = 4의 누적시간 vs  20의 누적시간 + 20의 시간
                // 4의 누적시간 = (20을 고려한) 4의 누적시간 vs 30의 누적시간 + 30의 시간

                if (degree[adj] == 0) {
                    queue.add(adj);
                    //time[adj] += time[curr]; //선수 조건의 시간 계산이 다 끝난 후(degree가 0) -  현재 인접 시간에 추가해주기
                    //System.out.println(Arrays.toString(time));
                }
            }
        }

        for (int j = 1; j <= N; j++) {
            System.out.println(result[j]);
        }

        }
    }