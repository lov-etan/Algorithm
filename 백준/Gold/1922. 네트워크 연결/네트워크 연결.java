import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static class Edge{
        int A;
        int B;
        int W; //가중치

        public Edge(int a, int b, int w){
            this.A = a;
            this.B = b;
            this.W = w;
        }

        public int getW(){
            return W;
        }
    }

    static int[] p; //정점들의 대표자 표시 배열


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //정점의 수
        int M = sc.nextInt(); //간선의 수

        p = new int[N+1];
        for(int i=0; i<N+1; i++){ //0은 음이 아닌 정수이다. //a, b 정수이다.
            p[i] = i;
        }

        //크루스칼 알고리즘 제 1장: 가중치 기준으로 정렬
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getW));
        for(int i=0; i<M; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int W = sc.nextInt();

            Edge edge = new Edge(A, B, W);
            pq.add(edge);

        }

        int cost = 0;

        //크루스칼 알고리즘 제 2장: 간선의 개수-1 만큼 뽑으면 끝/ 우선순위큐에서는 큐가 비면 끝
        while(!pq.isEmpty()){
            Edge out = pq.poll();

            int a = out.A;
            int b = out.B;
            int w = out.W;

            int px = findSet(a);
            int py = findSet(b);

            if(px != py){
                union(px,py); //연결이 되었다면
                cost += w; //간선 check!!
            }
        }

        System.out.println(cost);


    }//main

    static void union(int a, int b){
        //p[findSet(b)] = findSet(a);
          p[b] = a;
    }
    static int findSet(int a){
        if(p[a] == a) {
            return a;
        } else {
            p[a] = findSet(p[a]);
            return p[a];
        }
    }
}