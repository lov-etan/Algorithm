import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] sel;
	static StringBuilder sb;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		sel = new int[M];
		sb = new StringBuilder();
		
		permutation(0,0);
		System.out.println(sb.toString());
		
		
	}
	
	static void permutation(int num, int Si) {
		//기저조건 
		if(Si == M) {
			//System.out.println(Arrays.toString(sel));
			
			for(int i=0; i<M; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			
			return;
		}
		
		//재귀함수 
		for(int pick=num; pick<N; pick++ ) { //여기서 num은 idx 성질 //그 수부터 pick 그 전 수는 pick 안하고 싶어 
			
			sel[Si] = pick+1;
			permutation(pick,Si+1);
			//permutation(pick+1,Si+1); //이러면 조합과 똑같아 
		}
	}

}