
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Edge{
		int no;
		int minDist;
		
		Edge(int no, int minDist) {
			this.no = no;
			this.minDist = minDist;
		}
		
		int getMinDist() {
			return minDist;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		List<int[]> edges = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			edges.add(new int[] {i,x,y,z});
		}
		
		List<Edge>[] list = new ArrayList[N+1];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int idx=1; idx<=3; idx++) { //x, y, z 좌표 정렬하기 위함 
			final int xyz = idx;
			Collections.sort(edges, (o1,o2) -> (o1[xyz]-o2[xyz]));
			for(int i=1; i<N; i++) { //인접한 점들끼리 연결 
				int[] A = edges.get(i-1); //{i-1, x,y,z}
				int[] B = edges.get(i);  //{i, x,y,z}
				int dis = Math.abs(A[idx] - B[idx]);
				
				list[A[0]].add(new Edge(B[0], dis)); //정점과 그 거리 넣어주기 
				list[B[0]].add(new Edge(A[0], dis));
			}
		}
		
		
		//프림 시작!
		int answer = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(Edge::getMinDist));
		boolean[] visited = new boolean[N+1]; //MST에 연결되었는지의 여부 
		
		pq.add(new Edge(1, 0));
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			if(visited[curr.no]) continue; //아래 과정에서 pq 안에 정점이 두 번 이상 들어갈 가능성이 있음. 한 번 넣으면 그 친구는 못 나오게 처리! 
			visited[curr.no] = true;
			answer += curr.minDist;
			
			for(Edge next : list[curr.no]) {
				if(visited[next.no]) continue;
				pq.add(next);
			}
			
		}
		
		System.out.println(answer);
		
	}

}
