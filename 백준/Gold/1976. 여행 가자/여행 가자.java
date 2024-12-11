import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] adj;
	static int[] p;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String ans = "YES";
		N = Integer.parseInt(br.readLine()); //전체 도시의 개수 
		M = Integer.parseInt(br.readLine()); //계획한 도시의 수 
		p = new int[N]; //가장 부모 
		for(int i=0;i<N; i++) {
			p[i] = i; 
		}
		
		
		adj = new int[N][N]; 
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				adj[r][c] = Integer.parseInt(st.nextToken());
				//인접 도시들 union 하기 
				if(adj[r][c] == 1) {
					union(r,c);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine()); //도시 계획에 속한 도시들
		int[] travels = new int[M]; //{1, 2, 3}
		for(int i=0; i<M; i++) {
			int city = Integer.parseInt(st.nextToken());
			travels[i] = city;
			
			if(findset(travels[0]-1) != findset(city-1)) {
				ans = "NO";
				break;
			} 
			
		}
		
		System.out.println(ans);
		
		
		
		
	}
	
	static void union(int a, int b) {
		p[findset(b)] = findset(a);
	}
	
	static int findset(int a) {
		if(p[a] != a) {
			p[a] = findset(p[a]);
		}
		
		return p[a];
	}

}