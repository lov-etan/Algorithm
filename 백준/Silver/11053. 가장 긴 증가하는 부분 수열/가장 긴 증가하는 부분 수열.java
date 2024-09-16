import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //어떤 한 숫자, 그리고 그 숫자에 이르기까지의 이전 숫자들 순회하며 그 자리값의 최대 증가 순열 길이를 계산한다.
    public static void main(String[] args) throws IOException {
        //Input 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //수열 A의 크기
        int[] Ar = new int[N];// 수열 A
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            Ar[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N]; // = 그 숫자까지의 가장 긴 증가하는 부분 수열 길이


        //가장 긴 증가하는 부분 수열의 길이
        for(int i=0;i<N;i++){
            dp[i] = 1; //일단 모든 애들은 1로부터 시작된다.

            for(int j=0; j<i; j++){ //해당 숫자 전 숫자들 차례로 탐색하기
                if( Ar[i] > Ar[j] && dp[i] < dp[j] +1) {
                    dp[i] = dp[j] + 1; //작은 것들 중 가장 큰 것의 dp에 하나만 더 올리면 얘가 된다.
                }
            }
        }

        int res = 1;
        //output
        for(int i=0;i<N;i++){
            res = Math.max(dp[i], res);
        }
        System.out.println(res);



    }
}