import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){
            int A = sc.nextInt(); //초기값
            int B = sc.nextInt(); //목표값
            String ans = "";

            //bfs 시작~!
            Queue<Integer> q = new LinkedList<>();
            boolean[] vis = new boolean[10000];
            String[] commands = new String[10000]; //명령어 모으는 법. 공부하자. //dist 같은 역할 이전 명령어+지금 명령어

            //A 큐에 넣기
            q.add(A);
            vis[A] = true;
            Arrays.fill(commands, ""); //""로 초기화 해야 한다.

            while(!q.isEmpty()){
                int curr = q.poll();

                if(curr == B){
                    ans = commands[curr];
                }

                int num_D = (curr*2) % 10000;
                int num_S = curr == 0? 9999:curr-1;
                int num_L = (curr%1000)*10 + curr/1000;
                int num_R = (curr%10)*1000 + curr/10;

                if(!vis[num_D]){
                    vis[num_D] = true;
                    commands[num_D] = commands[curr]+"D";
                    q.add(num_D);
                }
                if(!vis[num_S]){
                    vis[num_S] = true;
                    commands[num_S] = commands[curr]+"S";
                    q.add(num_S);
                }
                if(!vis[num_L]){
                    vis[num_L] = true;
                    commands[num_L] = commands[curr]+"L";
                    q.add(num_L);
                }
                if(!vis[num_R]){
                    vis[num_R] = true;
                    commands[num_R] = commands[curr]+"R";
                    q.add(num_R);
                }

            }

            System.out.println(ans);


        } //tc
    }
}