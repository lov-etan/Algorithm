import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //정수 N


        //DP : 연산을 사용하는 횟수의 최솟값
        int[] dp = new int[N+1]; //dp[tmp ~ N]
        dp[1] = 0; // 1이면 연산이 끝나

        for(int tmp=2; tmp<=N; tmp++){ //N까지 단계 밟아가며 최종적으로는 가장 적은 횟수 만들어보기
            dp[tmp]  = dp[tmp-1] + 1; //1이 아니라면 무조건 -1 가능하므로 무조건 연산 횟수 +1
            if(tmp % 3 == 0) {
                dp[tmp] = Math.min(dp[tmp], dp[tmp/3] + 1); //-1 과 /3 결과 비교
            }
            if (tmp % 2 == 0){ //여기 else if면 안돼!! - 왜? [6과 같이 2,3의 배수인 경우 둘 다 고려해야 하는 상황도 있기 때문]
                dp[tmp] = Math.min(dp[tmp], dp[tmp/2] + 1); // -1과 /2 결과 비교
            }
        }

        System.out.println(dp[N]);


    }
}