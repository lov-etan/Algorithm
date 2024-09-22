import java.util.Arrays;
import java.util.Scanner;

public class Main {
	//인덱스 에러: 1일 때, 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] score = new int[N+2];
		
		for(int i=1; i<=N; i++) {
			score[i] = sc.nextInt();
		}
		
		int[] dp = new int[N+3]; //최댓값 출력한다.
		dp[0] = score[0];
		dp[1] = score[1];
		dp[2] = score[2] + score[1]; //두번째 칸은 무조건 첫번쨰와 두번째의 합일 수 밖에 없다.
		
		if(N >= 3) {
			for(int pick=3; pick<=N; pick++) {
				dp[pick] = dp[pick-2] +score[pick]; //두 칸 건너뛰기 두 칸 xx
				//System.out.println(Arrays.toString(dp));
				dp[pick] = Math.max(dp[pick], dp[pick-3]+score[pick-1]+score[pick]); //세 칸 전에서 하나 뛰고 두 칸 연속 뛰기 두 칸 ㅇㅇ
				//System.out.println(Arrays.toString(dp));
			}
		}
		
		
		System.out.println(dp[N]);
		
		
	}
	
}