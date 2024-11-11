import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int[] P;
	
	static class Edge{
		int A, B;
		long W; 
		
		Edge(int a, int b, long w){
			this.A = a;
			this.B = b;
			this.W = w;
		}
		
		//comparator 쓰는 용 
		public long getW() {
			return W;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}
		
		
		
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int T = Integer.parseInt(br.readLine()); //테케 수 
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine()); //섬의 개수 
			
			//각 섬의 x좌표,y좌표를 받는다. 
			int[] xs = new int[N];
			int[] ys = new int[N]; 
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				xs[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				ys[i] =Integer.parseInt(st.nextToken());
			}
			
			//크루스칼 1단계: 간선으로 기준으로 pq 정
			//간선 기준 Edge 저장 후 가중치 기준으로 pq에 정렬시키려고 함 
			PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(Edge::getW));
			for(int node1=0; node1<N-1; node1++) {
				for(int node2=node1+1; node2<N; node2++) {
					Edge edge = new Edge(node1, node2, (long)(Math.pow(xs[node1]-xs[node2],2) + Math.pow(ys[node1]-ys[node2],2)));
					pq.add(edge);
				}
			}
			
			//크루스칼 2단계: 간선의 w 낮은 순부터 union 해주기 
			//finset(정점) 비교. 둘의 findSet()이 다르면 -> union 해주기 
				//union할 준비 (처음엔 각자가 각자의 부모이다)
				P = new int[N];  
				for(int i=0; i<N; i++) {
					P[i] = i ; 
				}
			
			double E = Double.parseDouble(br.readLine()); //세율 
			long answer = 0 ;//총 비용. 최소가 되어야 함
			int edgCnt = 0; //뽑은 간선의 개수 
			
			while(!pq.isEmpty() && edgCnt < N-1) { //큐가 비거나 / 지금까지 고려한 간선의 개수가 N-1이 될 때 멈춘다(여기서의 간선은 무조건 N-1). 
				//자, 이제 union 시작해보자 
				Edge curr = pq.poll(); 
				//System.out.println(curr);
				int A = curr.A;
				int B = curr.B;
				
				if(findSet(A) != findSet(B)) { //만약 두 정점의 집합이 같지 않으면? 
					union(A, B); //연결해주기 
					edgCnt++; //간선 생겼지?
					answer += curr.W; //연결한 거리만큼의 돈 내야지 
				}
			}
			
			System.out.println( "#" + tc + " " + Math.round(answer * E));
			
		}//T
	}
	
	static int findSet(int a) {
		if(P[a] != a) {
			P[a] = findSet(P[a]);
		}
		return P[a];
	}
	
	static void union(int a, int b) {
		P[findSet(b)] = findSet(a);
	}

}