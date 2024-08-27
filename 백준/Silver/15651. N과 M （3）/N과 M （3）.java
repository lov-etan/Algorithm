import java.util.Scanner;

public class Main {
	//중복순열은 문이 열려있든말든 신경 쓰지 말아야겠다.
	//시간초과 나서 StringBuilder로 
	static int N;
	static int M;
	static int[] sel;
	//static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		sel = new int[M];
		//visited = new boolean[N];
		
		permutationA(0);
		System.out.println(sb.toString());
	}
	
	static void permutationA(int Si) {
		//기저조건
		if( Si == M ) {
			for(int idx=0; idx<M; idx++) {
				sb.append(sel[idx]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		//재귀함수 
		for(int num=0; num<N; num++) {
			//문 열, 닫 신경쓰지 말아야지~ if(!visited) 안하기 
			sel[Si] = num+1; 
			permutationA(Si+1);
		}
	}

}