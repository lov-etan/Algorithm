import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class Pos{
        int x;
        int y;

        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        int getY() {
            return y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        PriorityQueue<Pos> pq = new PriorityQueue<>(Comparator.comparingInt(Pos::getY).thenComparingInt(Pos:: getX));
        for (int i=0; i<N; i++){
            pq.add(new Pos(sc.nextInt(), sc.nextInt()));
        }

        for (int i=0; i<N; i++){
            Pos p = pq.poll();
            int x = p.x;
            int y = p.y;

            System.out.println(x + " " + y);
        }
    }
}