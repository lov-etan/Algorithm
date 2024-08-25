import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 큰 판
			int M = sc.nextInt(); // 작은 판

			int[][] Nr = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					Nr[r][c] = sc.nextInt();
				}
			}

			// 파리 퇴치 시작!
			int maxCnt = Integer.MIN_VALUE;
			for (int rs = 0; rs < N - M + 1; rs++) { // 시작점
				for (int cs = 0; cs < N - M + 1; cs++) {
					
					int cnt = 0;
					for (int r = 0; r < M; r++) {
						for (int c = 0; c < M; c++) {
							cnt += Nr[rs + r][cs + c];
						}
					}
					maxCnt = Math.max(maxCnt, cnt);
				}

				
			}

			System.out.println("#" + tc + " " + maxCnt);
		} // 테스트케이스 끝
	}

}