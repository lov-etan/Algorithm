class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] adjArr = new int[n+1][n+1];
        
        // 이겼을 경우 - 인접행렬에 1 표시
        for(int i=0; i<results.length; i++){
            adjArr[results[i][0]][results[i][1]] = 1; //results[4,3] -> 4>3 -> 인접행렬[4][3] = 1 (이 경우 이김) 
        }
        for(int a=0; a<=n; a++){ //A>B. B>C 이면 -> A>C 이다. // 플로이드-워셜 알고리즘 '무조건 중간 중심!'
            for(int b=0; b<=n; b++){
                for(int c=0; c<=n; c++){
                    if(adjArr[b][a] == 1 && adjArr[a][c] == 1){
                        adjArr[b][c] = 1;
                    }
                }
            }
        }
        
        //Node에 대한 경기결과(1)가 n-1개이면 정확한 순위 도출 가능
        for(int node=1; node<=n; node++){
            int play = 0;
            for(int c=1; c<=n; c++){
                if(adjArr[node][c] == 1 || adjArr[c][node] == 1){
                    play++;
                }
            }
            
            if(play == n-1){
                    answer++;
            }
        }
        
        return answer;
    }
}