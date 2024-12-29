import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] adjArr = new int[n+1][n+1];
        
        //인접행렬 - adjArr[이긴][진] = 1
        for(int i=0; i<results.length; i++){
            adjArr[results[i][0]][results[i][1]] = 1; //results 활용하여 이기고 진 것 판단
        }
        for(int a=1; a<=n; a++){
            for(int b=1; b<=n; b++){
                for(int c=1; c<=n; c++){
                    if(adjArr[b][a] == 1 && adjArr[a][c] == 1){  // && !!! 놓치지 않기@@@
                        //중간 b를 기준으로 하여 ( b>a,a>c 이면 b>c 
                        adjArr[b][c] = 1;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(adjArr));
        
        //정확한 순위는 언제 알아지지? - 해당하는 경기 결과가 N-1일 때
        for(int node=1; node<=n; node++){
            int cnt = 0;
            for(int c=1; c<=n ; c++){
                if(adjArr[node][c]==1 || adjArr[c][node]==1){
                    cnt++;
                }
            }
            
            if(cnt == n-1){
                answer++;
            }
        }
        
        
        
        return answer;
    }
}