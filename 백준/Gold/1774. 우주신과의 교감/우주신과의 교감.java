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
		double minDist; //해당 정점이 mst에 연결되는데 필요한 최소거리 
		
		Edge(int no, double minDist) {
			this.no = no;
			this.minDist = minDist;
		}
		
		double getMinDist() {
			return minDist;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //정점의 개수 
		int M = Integer.parseInt(st.nextToken()); //이미 연결된 통로의 개수 
		
		// 좌표값 저장
		int[][] edges = new int[N+1][2];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()); 
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 정점들간의 거리 구하기
		double[][] dist = new double[N+1][N+1];
		for (int i = 1; i <= N; i++) {
		    Arrays.fill(dist[i], Double.MAX_VALUE);
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<i; j++) {
				dist[i][j] = dist[j][i] = Math.sqrt(Math.pow(edges[i][0]-edges[j][0], 2) + Math.pow(edges[i][1]-edges[j][1], 2));
			}
		}
		
		// 이미 연결된 정점들 간 거리는 없앤다. 
		for(int i=1; i<=M; i++) {
			st=new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			dist[A][B] = dist[B][A] = 0;
		}
		
		
		
		// 프림 시작!
		double answer = 0;
		
		double[] minDist = new double[N+1]; //각 정점들의 mst로 합류하기 위해서 필요한 최소 거리  
		Arrays.fill(minDist, Double.MAX_VALUE); //아직 모두 떨어져 있어 
		boolean[] visited = new boolean[N+1]; //mst에 연결되었는지의 여부 
		
		minDist[1] = 0; //1번을 시작정점으로 설정 
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingDouble(Edge::getMinDist));
		pq.add(new Edge(1,0));
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			if(visited[curr.no]) continue;
			visited[curr.no] = true;
			minDist[curr.no] = 0; //mst 합류 
			answer += curr.minDist; 
			
			for(int i=1; i<=N; i++) { //연결된 것들 구하기  
				if(visited[i]) continue;
				if(dist[curr.no][i] < minDist[i]) { //아직 mst에 연결되지 않았다면? 
					minDist[i] = dist[curr.no][i];
					pq.add(new Edge(i, minDist[i]));
				}
			}
		}
		
		System.out.printf("%.2f",answer);
		
		
		
	}

}
