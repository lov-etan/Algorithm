import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static class Edge{
        int A;
        int B;
        double W;

        public Edge(int a, int b, double w){
            this.A = a;
            this.B = b;
            this.W = w;
        }

        public double getW(){
            return this.W;
        }
    }

    static int[] p; //대표자 저장 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //정점의 개수

        double[][] map = new double[2][N+1]; //0행은 x좌표, 1행은 y좌표

        for(int i=1; i<=N; i++){
            map[0][i] = sc.nextDouble(); //i정점의 x좌표
            map[1][i] = sc.nextDouble(); //i정점의 y좌표

        }

        p = new int[N+1];
        for(int i=1; i<=N; i++){
            p[i] = i; //자기 자신의 대표자 되어주기
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(Edge::getW));
        for(int i=1; i<=N-1; i++){
            for(int j=i+1; j<=N; j++){ //각 정점끼리 이은 Edge 만들어주기
                int a = i;
                int b = j;
                double w = Math.sqrt(Math.pow(map[0][i]-map[0][j],2)+Math.pow(map[1][i]-map[1][j],2)) ;
                Edge e = new Edge(a,b,w);
                pq.add(e);
            }
        }

        double cost = 0;

        while(!pq.isEmpty()){
            Edge out = pq.poll();

            int a = out.A;
            int b = out.B;
            double w = out.W;

            int px = findSet(a);
            int py = findSet(b);

            if(px != py){
                union(px,py);
                cost += w;
            }
        }

        System.out.printf("%.2f",cost);
    }//main

    static void union(int a, int b) {
        p[a] = b;
    }

    static int findSet(int a){
        if(p[a] == a){
            return a;
        } else {
            p[a] = findSet(p[a]);
            return p[a];
        }
    }
}