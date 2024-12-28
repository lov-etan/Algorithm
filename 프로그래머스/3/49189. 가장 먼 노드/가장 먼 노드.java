import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] distance = new int[n+1];
        boolean[] visited = new boolean[n+1];
        
        // graph - 연결된 노드끼리 묶어두기 
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<edge.length; i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        //System.out.println("graph" + graph);
        
        // 큐를 활용하여 1을 기준으로 distance 구하며 나열하기
        Queue<Integer> q = new LinkedList<>();
        visited[1] = true; 
        q.add(1);
        
        while(!q.isEmpty()){
            int curr = q.poll(); // 노드 꺼내기
            ArrayList<Integer> nodes = graph.get(curr); //현재 노드와 연결된 애들 찾기 
            
            for(int i=0; i<nodes.size(); i++) {
                int node = nodes.get(i);
                if(!visited[node]) { //아직 요놈 방문 안했어
                    q.add(node); 
                    visited[node] = true;
                    distance[node] = distance[curr]+1;
                }
            }
        }
        
        //distance가 쫘르륵 나열되어 있을 것
        Arrays.sort(distance);
        //System.out.println(Arrays.toString(distance));
        int max = distance[n]; 
        for(int i=0; i<=n; i++){
            if(max == distance[i]){
                answer++;
            }
        }
        
        return answer;
    }
}