import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] sel;
	static boolean[] visited;
	static Set<String> set = new HashSet<>();
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		sel = new int[M];
		visited = new boolean[N];
		//existed = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		permutationA(0,0);
		
	}
	
	static void permutationA(int idx, int Sidx) {
		//기저조건 
		if(Sidx == M) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<M; i++) {
				sb.append(sel[i]).append(" ");
			}
			String result = sb.toString();
			
			if(set.add(result)) {
				System.out.println(result);
			}
			return;
		}
		
		//재귀
		for(int pick=0; pick<N; pick++) {

			if(!visited[pick]) {
				sel[Sidx] = arr[pick];
				visited[pick] = true;
				
				permutationA(pick+1, Sidx+1);
				visited[pick] = false;
				
			}
		}
		
	}

}