import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++) {
            int n = sc.nextInt();
            int cnt = 0;
            int[] dp = new int[n+1];
            dp[0] = 1; //만약 0이라면 아무것도 안 더하는 경우 - 1가지가 존재한다.

            for(int tmp=1; tmp<=n; tmp++) {

                if(tmp>=1) dp[tmp] += dp[tmp-1];
                if(tmp>=2) dp[tmp] += dp[tmp-2];
                if(tmp>=3) dp[tmp] += dp[tmp-3];
            }

            System.out.println(dp[n]);


        }//tc
    }



}