import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] picks;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); //1부터 N까지의 숫자
        M = sc.nextInt(); //길이가 M인 순열

        picks = new int[M];
        visited = new boolean[N+1];
        permutation(0); //선택된 아이들의 index
    }

    static void permutation(int pick){
        //기저조건
        if(pick == M){
            for(int i=0; i<M; i++){
                System.out.print(picks[i] + " ");
            }
            System.out.println();
            return;
        }

        //재귀
        for(int num=1; num<=N; num++){
            if(!visited[num]){
                visited[num] = true;
                picks[pick] = num;
                permutation(pick+1);
                visited[num] = false;
            }
        }
    }


}