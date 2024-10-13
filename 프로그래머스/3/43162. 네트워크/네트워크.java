import java.util.*;

class Solution {
    int[] p;
    
    public int solution(int n, int[][] computers) {
        //루트는 0~n-1 까지 있음
        p = new int[n];
        for(int x=0; x<n ; x++){
            p[x] = x; //초기에는 자기 자신이 자기 자신의 부모 노드 
        }
        
        boolean[][] visited = new boolean[n][n];
        
        //인접행렬 돌면서 연결되어 있는 것들 같은 집합에 넣어주기 
        for(int root = 0; root < n; root++){
            for(int other=0; other<n; other++){
                if(!visited[root][other] && computers[root][other] == 1){
                    unionSet(root, other);
                    visited[root][other] = true;
                    visited[other][root] = true;
                }
            }
        }
        
        int answer = 0;
        
        //이제 p[]에 각 부모 노드가 저장되었겠지?
        Set<Integer> set = new LinkedHashSet<>();
        for(int i=0; i<n; i++){
            set.add(findSet(p[i])) ;
        }
        
        answer = set.size();
        
        return answer;
    }
    
    void unionSet(int x, int y){
        p[findSet(y)] = findSet(x);
    }
    
    int findSet(int x){
        if(x != p[x]){
            p[x] = findSet(p[x]);
        }
        return p[x];
    }
}