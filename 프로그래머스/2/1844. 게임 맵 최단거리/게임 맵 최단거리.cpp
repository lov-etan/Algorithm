#include <vector>
#include <queue>
using namespace std;
int N, M; 
vector<vector<int>> arr;
vector<vector<int>> dp;
queue<pair<int,int>> q;

int dr[] = {1,0,-1,0};
int dc[] = {0,1,0,-1};

bool inRange(int r, int c) {
    return r>=0 && r<N && c>=0 && c<M;
}

int bfs() {
    dp[0][0] = 1;
    q.push({0,0});
    while(!q.empty()) {
        
        auto[r,c] = q.front(); q.pop();
        
        if(r == N-1 && c == M-1) {
            return dp[r][c];
        }
        for(int d=0; d<4; d++) {
            int nr = r + dr[d]; int nc = c + dc[d];
            if(inRange(nr,nc) && dp[nr][nc] == -1 && arr[nr][nc] == 1) {
                dp[nr][nc] = dp[r][c]+1;
                q.push({nr,nc});
            }
        }
    }
    return -1;
}

int solution(vector<vector<int>> maps) {
    N = maps.size(); M = maps[0].size();
    arr = maps; dp.resize(N, vector(M, -1));
    
    
    return bfs();
}