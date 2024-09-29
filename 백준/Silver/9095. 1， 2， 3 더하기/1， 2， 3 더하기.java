import java.util.Scanner;

public class Main {
    static int n,cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){
            n = sc.nextInt(); //정수 n이 주어졌다.
            cnt = 0;
           //n을 1,2,3의 합으로 나타내는 방법의 수는?
           dfs(0); //여태까지 총합

            System.out.println(cnt);
        }//tc
    }//main

    static void dfs(int sum){
        //기저조건 if - return
        if(sum == n){
            cnt++;
            return;
        }

        if( sum > n){
            return;
        }

        //재귀
        dfs(sum+1);
        dfs( sum+2);
        dfs( sum+3);
    }

}