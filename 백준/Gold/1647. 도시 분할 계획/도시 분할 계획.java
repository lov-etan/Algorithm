import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] p;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		// 집의 개수 
		N = Integer.parseInt(st.nextToken());
		// 길의 개수 
		M = Integer.parseInt(st.nextToken());
		
		p = new int[N+1];
		for(int i=1; i<=N; i++) {
			p[i] = i;
		}
 
		int[][] results = new int[M][3];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			results[i][0] = Integer.parseInt(st.nextToken());
			results[i][1] = Integer.parseInt(st.nextToken());
			results[i][2] = Integer.parseInt(st.nextToken());
		}
		
		
		//가중치 낮은 순으로 정렬
		Arrays.sort(results, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[]o2) {
				return o1[2] - o2[2];
			}
		});
		
		
		//한 마을을 최소 가중치로 묶기
		int answer = 0;
		int last = 0;
		for(int i=0; i<M; i++) {
			if(findset(results[i][0]) != findset(results[i][1])) {
				union(results[i][0], results[i][1]);
				last = results[i][2];
				answer += last;
			}
		}
		
		System.out.println(answer - last);
		
		
		
	}
	
	public static int findset(int a) {
		if(p[a] != a) {
			p[a] = findset(p[a]);
		}
		
		return p[a];
	}
	
	public static void union(int a, int b) {
		p[findset(b)] = findset(a);
	}

}