import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //2*n 크기의 직사각형

        //dp : 2*n크기의 직사각형을 채우는 방법의 수
        //dp[tmp n] | tmp= 2 ~ n까지
        int[] dp = new int[n+2];
        dp[1] = 1;
        dp[2] = 2; //N이 1이 들어오면 2는 없는 값인데 선언했으니 처음에 배열 크기를 이 정도는 넓혀줘야해.
        for(int tmp=3; tmp<=n; tmp++){
            dp[tmp] = (dp[tmp-1] + dp[tmp-2]) % 10007;
        }

        System.out.println(dp[n]);


    }
}