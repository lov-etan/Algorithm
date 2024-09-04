import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class Edge{
        int A;
        int B;
        int W;

        public Edge(int a, int b, int w) {
            this.A= a;
            this.B= b;
            this.W= w;
        }

        @Override
        public String toString() {
            return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
        }

        public int getW() {
            return W;
        }


    }

    static int[] p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); //정점의 개수
        int E = sc.nextInt(); //간선의 개수

        //크루스칼 제 1장: 간선을 가중치 기준으로 정렬
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getW));
        for(int i=0; i<E; i++) {
            int A= sc.nextInt();
            int B = sc.nextInt();
            int W = sc.nextInt();
            Edge edge = new Edge(A, B, W);
            pq.add(edge);
        }

        p = new int[V+1]; //정점 대표자 저장 //정점은 1번부터 V번까지 번호가 매겨져 있다.
        for(int i=1; i<V; i++){
            p[i] = i; //초기 자신의 부모는 자기
        }

        int distance = 0;
        //크루스칼 제 2장: V-1개의 간선을 뽑아라!<-기저조건 (while(!queue.isEmpty))
        while(!pq.isEmpty()) { //if(pick == V-1) break;
            Edge out = pq.poll();
            int a = out.A;
            int b = out.B;
            int w = out.W;

            //가장 가중치가 작은 순서대로 나오고 있다. //그 정점끼리 연결시켜준다.
            int px = findSet(a);
            int py = findSet(b);

            if(px != py) {
                union(px,py);
                distance += w;
            }

        }

        System.out.println(distance);


    }//main

    static void union(int a, int b){
            p[findSet(b)] = findSet(a);
    }

    static int findSet(int a) {
        if(p[a] ==a){
            return a;
        } else {
            p[a] = findSet(p[a]);
            return p[a];
        }
    }

}