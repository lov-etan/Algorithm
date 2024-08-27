import java.util.Scanner;

public class Main {
	static int[] sel;
	static int N;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //nCm 의 n
		M = sc.nextInt(); //nCm 의 m
		
		sel = new int[M];
		
		combination(0, 0);
		
	}
	
	static void combination(int num, int Si) {
		//기저조건 
		if(Si == M) {
			for(int idx=0; idx<M; idx++) {
				System.out.print(sel[idx] + " ");
			}
			System.out.println();
			
			return;
		}
		
		//재귀함수 
		for(int pick=num; pick<= N-M+Si; pick++) {
			sel[Si] = pick+1; 
			combination(pick+1, Si+1);
		}
		
		
		
	}

}