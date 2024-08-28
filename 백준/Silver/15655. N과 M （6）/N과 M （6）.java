import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] sel;
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		sel = new int[M];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		combination(0,0);
		
	}
	
	static void combination(int idx, int Sidx) {
		//기저조건 
		if(Sidx == M) {
			for(int i=0; i<M; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		
		//재귀
		for(int pick=idx; pick<N; pick++) {
			sel[Sidx] = arr[pick];
			combination(pick+1, Sidx+1);
		}
	}


}