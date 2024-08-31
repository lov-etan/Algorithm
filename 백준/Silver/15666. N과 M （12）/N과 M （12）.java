import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] sel;
	static Set<String> set;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		sel = new int[M];
		set = new LinkedHashSet<String>();
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		combination(0,0);
		
		for(String element : set) {
			System.out.println(element);
		}
		
	}
	
	static void combination(int idx, int Sidx) {
		//기저조건 
		if( Sidx == M ) {
			String str = "";
			for(int i=0; i<M; i++) {
				str += sel[i] + " ";	
			}
			set.add(str);
			return;
		}
		
		//재귀함수 
		for(int pick=idx; pick<N; pick ++) {
			sel[Sidx] = arr[pick];
			combination(pick,Sidx+1);
		}
	}

}