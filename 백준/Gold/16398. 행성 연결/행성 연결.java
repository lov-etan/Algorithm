
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Edge{
		int no; 
		long cost;
		
		Edge(int no, long cost) {
			this.no = no;
			this.cost = cost;
		}
		
		long getCost() {
			return cost;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//System.out.println(Arrays.deepToString(arr));
		
		//프림 
		long answer = 0; //비용이 0부터 1억까지임. 최악의경우, int 범위를 넘어설 수 있음 
		
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(Edge::getCost));
		boolean[] visited = new boolean[N+1];
		long[] minDist = new long[N+1]; //MST에 포함되기 위한 최소 비용 
		Arrays.fill(minDist, Integer.MAX_VALUE);
		
		pq.add(new Edge(1,0));
		minDist[1] = 0;
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			if(visited[curr.no]) continue;
			visited[curr.no] = true;
			answer += curr.cost;
			
			for(int i=1; i<=N ; i++) {
				if(!visited[i] && arr[curr.no][i] < minDist[i]) {
					minDist[i] = arr[curr.no][i]; //mst에 연결될 최소 비용 업데이트 //최소비용간선만 추가되도록 함!! 
					pq.add(new Edge(i, arr[curr.no][i]));
				}
			}
		}
		
		System.out.println(answer);
		
		
		
	}
	

}
