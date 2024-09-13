import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //빨강, 초록, 파랑 셋 중 하나의 색으로 칠한다 - 배열 0빨강 1초록 2파랑
    //집에 따라 해당하는 비용이 주어진다. - 2차원 배열 cost[빨강][비용]
    //1번 집 색은 2번 집 색과 같지 않다.
    //N-1번 집의 색은 N번 집의 색과 같지 않다. dp[N] = min(dp[다른색1][], dp[다른색2][]) + cost[지금색][] )
    //모든 집(N)을 칠하는 비용의 최솟값은??

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //집의 개수
        int[][] cost = new int[N+1][3]; //집 [집numb][색깔-비용]
        for(int r=1; r<N+1; r++){
            for(int c=0; c<3; c++){
                cost[r][c] = sc.nextInt();
            }
        } //[집 번호][빨 - 비용]  [초-비용] [파-비용] 나열됨
        //System.out.println(Arrays.deepToString(cost));


        int[][] dp = new int[N+1][3]; //N집까지의 색깔 최소 비용 //초기값 모두 0
        dp[0][0] = 0; //0번 집을 짓는데는 어떤 비용도 들지 않는다
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[1][0] = cost[1][0]; //1번 집을 빨강으로 짓는 경우,
        dp[1][1] = cost[1][1]; //초록으로
        dp[1][2] = cost[1][2]; //파랑으로

        if(N>=2)
            //빨 초 파 다 넣어보면서 최솟값 구하면 되겠지?
            for(int r=2; r<=N; r++){ //집 번호
                for(int c=0; c<3; c++){ //빨 초 파
                    if(dp[r][c] == 0 ){ //최솟값이 구해지지 않았다면, 최솟값을 넣어줄게~

                        if(c==0){ //만약 현재 빨강이 칠해지려고 한다면?
                            dp[r][c] = Math.min(dp[r-1][1],dp[r-1][2]) + cost[r][c];
                            //System.out.println("r" + r + " c" + c + " "+ Arrays.deepToString(dp));
                        } else if(c==1){
                            dp[r][c] = Math.min(dp[r-1][0],dp[r-1][2]) + cost[r][c];
                            //System.out.println("r" + r + " c" + c + " "+ Arrays.deepToString(dp));
                        } else if(c==2){
                            dp[r][c] = Math.min(dp[r-1][0], dp[r-1][1]) + cost[r][c];
                            //System.out.println("r" + r + " c" + c + " "+ Arrays.deepToString(dp));
                        }

                    }
                }
            }

        int res = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));

        System.out.println(res);




    }

}