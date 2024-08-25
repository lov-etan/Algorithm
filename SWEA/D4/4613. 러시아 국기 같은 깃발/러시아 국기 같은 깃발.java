import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			int N = sc.nextInt(); //행의 개수 
			int M = sc.nextInt(); //열의 개수   
			
			char[][] Fr = new char[N][M];
			
			for(int r=0; r<N; r++) { //현재의 깃발판 채우기  
				String inputString = sc.next();
				for(int c=0; c<M; c++) {
					Fr[r][c] = inputString.charAt(c);
				}
			}
			
			int minCnt = Integer.MAX_VALUE;
			//해당 컬러로 어디서부터 어디까지 채울건지 미리 결정한다. 
			for(int w=0; w<N-2; w++) {
				for(int b=w+1; b<N-1; b++) {
					for(int r=b+1; r<N; r++) {
						
						int cnt = 0;
						
						//w, b, r 은 각 색을 행 어디까지 채울지를 나타낸다.
						//이제 해당 행들을 수행하면서 바꿔야 하는 칸을 센다. 
						for(int row=0; row<=w; row++) {
							for(int col=0; col<M; col++) {
								if(Fr[row][col] != 'W') {
									cnt++;
								}
							}
						}
						
						for(int row=w+1; row<=b; row++) {
							for(int col=0; col<M; col++) {
								if(Fr[row][col] != 'B') {
									cnt++;
								}
							}
						}
						
						for(int row=b+1; row<N; row++) {
							for(int col=0; col<M; col++) {
								if(Fr[row][col] != 'R') {
									cnt++;
								}
							}
						}
						
						minCnt = Math.min(cnt, minCnt);
						
						
					}
				}
			}
			
			System.out.println("#" + tc + " " + minCnt);
			
		}//테스트케이스 끝   
	}

}