#include <iostream>
#include <vector>

using namespace std;
int N, M; int ans = 0;
vector<vector<int>> maps;
vector<vector<bool>> dp;

int dr[] = {1, 0, -1, 0};
int dc[] = {0, 1, 0, -1};

bool inRange(int r, int c) {
    return r>=0 && r<N && c>=0 && c<M;
}
void dfs(int idx, int sum);
void check(int r, int c, int idx, int d1, int d2, int sum) {

    int nr = r + dr[d1]; int nc = c + dc[d1];
    int nr2 = r + dr[d2]; int nc2 = c+ dc[d2];
    if(inRange(nr,nc) && inRange(nr2, nc2) && !dp[r][c] && !dp[nr][nc] && !dp[nr2][nc2]) {
        dp[r][c] = dp[nr][nc] = dp[nr2][nc2] = true;
        dfs(idx+1, sum+maps[r][c]*2 + maps[nr][nc] + maps[nr2][nc2]);
        dp[r][c] = dp[nr][nc] = dp[nr2][nc2] = false;
    }
}

void dfs(int idx, int sum) {
    if(idx == N*M) {
        ans = max(ans, sum);
        return;
    }

    int r = idx/M;
    int c = idx%M;

    check(r,c,idx,0,3,sum);
    check(r,c,idx,2,3,sum);
    check(r,c,idx, 1,2,sum);
    check(r,c,idx,0,1,sum);
    dfs(idx+1, sum);
}

int main() {
    cin >> N >> M;
    maps.resize(N, vector<int>(M, 0));
    dp.resize(N, vector<bool>(M, false));
    for(int r=0; r<N; r++) {
        for(int c=0; c<M; c++) {
            cin >> maps[r][c];
        }
    }
    
    dfs(0, 0);
    cout << ans;
}