import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] sel;
	static boolean[] visited;
	static Set<String> set;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		sel = new int[M];
		visited = new boolean[N];
		set = new LinkedHashSet<String>();
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		permutation(0,0);
		
		for(String element : set) {
			System.out.println(element);
		}
		
		
	}
	
	static void permutation(int idx, int Sidx) {
		//기저조건 
		if(Sidx == M) {
			//System.out.println(Arrays.toString(sel));
			String str = "";
			for(int i=0; i<M; i++) {
				str += sel[i] + " ";
			}
			//System.out.println(str);
			set.add(str);
			return;
		}
		
		//재귀함수 
		for(int pick=0; pick<N; pick++) {
				 sel[Sidx] = arr[pick];
				 permutation(pick, Sidx+1);
				 //permutation(pick+1, Sidx+1);

				 
		}
	}

}