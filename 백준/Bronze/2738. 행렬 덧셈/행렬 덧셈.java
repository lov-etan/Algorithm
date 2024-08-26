import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] Ar = new int[N][M];
        int[][] Br = new int[N][M];

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                Ar[r][c] = sc.nextInt();
            }
        }

        //System.out.println(Arrays.deepToString(Ar));

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                Br[r][c] = sc.nextInt();
            }
        }
        //System.out.println(Arrays.deepToString(Br));

        int[][] sumR = new int[N][M];

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                sumR[r][c] = Ar[r][c] + Br[r][c];
            }
        }

        //System.out.println(Arrays.deepToString(sumR));

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                System.out.print(sumR[r][c] + " ");
            }
            System.out.println();
        }

    }
}