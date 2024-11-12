import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	//최소 가중치 경로 문제: '다익스트라 알고리즘'
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Pos{
		int r, c;
		int sum; 
		
		Pos(int r, int c, int sum){
			this.r = r;
			this.c = c;
			this.sum = sum;
		}
		
		public int getSum() {
			return sum;
		}
		
		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", sum=" + sum + "]";
		}

		

		
		
	}
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc=1;
		
		while(true) { //0 나올 때까지 테케 돌리기 
			
			int N = Integer.parseInt(br.readLine());
			if(N == 0) {
				break;
			}
			
			int[][] map = new int[N][N];
			int[][] dist = new int[N][N]; //최소 비용 저장배열 
			
			//dist = 누적합 저장소이자 visited 역할 
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					dist[i][j] = Integer.MAX_VALUE; // 최댓값으로 초기화 
				}
			}
			
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			
			//가중치 제일 적게 모으고 목적지(N-1, N-1)까지 가는 길은 무엇일까?
			//다익스트라 알고리즘 시~작! 
			PriorityQueue<Pos> pq = new PriorityQueue<>(Comparator.comparing(Pos::getSum));	
			pq.add(new Pos(0,0,map[0][0])); //0,0부터 시작 
			
			
			while(!pq.isEmpty()) {
				Pos curr = pq.poll();
				int r  = curr.r;
				int c = curr.c;
				
				if(curr.sum > dist[r][c]) { //이미 지나갔다는 말 (visited)
					continue;
				}
				
				for(int d=0; d<4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr>=0 && nr<N && nc>=0 && nc<N) {
						int newSum = curr.sum + map[nr][nc];
						
						//다음 갈 곳이 정해지면? 원래 있던 애에서 + 지금 지나갈 cost를 더해줘야겠지?
						if(newSum < dist[nr][nc]) {
							dist[nr][nc] = newSum;
							pq.add(new Pos(nr, nc, newSum));
						}
					}
				}
				
			}
			
			System.out.println("Problem " + tc++ + ": " + dist[N-1][N-1] );
			
		}
		
		
		
		
	}

}