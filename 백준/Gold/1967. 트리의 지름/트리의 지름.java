import java.util.*;
import java.io.*;

class Main {
    static int N;
    static ArrayList<ArrayList<int[]>> adj;
    static boolean vis[];
    static int answer = 0;
    static int maxnode = 0;

    static void bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(answer < curr[1]) {
                answer = curr[1];
                maxnode = curr[0];
            }

            for(int[] nxt : adj.get(curr[0])) {
                if(!vis[nxt[0]]) {
                    vis[nxt[0]] = true;
                    q.add(new int[] {nxt[0], curr[1]+nxt[1]});
                }
            }
        }
    }

    // static void dfs(int curr, int sum) {
    //     if(answer < sum) {
    //         answer = sum;
    //         maxnode = curr;
    //     }

    //     for(int[] nxt : adj.get(curr)) {
    //         if(!vis[nxt[0]]) {
    //             vis[nxt[0]] = true;
    //             dfs(nxt[0], sum+nxt[1]);
    //         }
    //     }
    // }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(a).add(new int[]{b,w});
            adj.get(b).add(new int[]{a,w});
        }
        
        vis = new boolean[N+1];
        vis[1] = true;
        bfs(1);

        vis = new boolean[N+1];
        vis[maxnode] = true;
        bfs(maxnode);

        System.out.println(answer);
    }
}