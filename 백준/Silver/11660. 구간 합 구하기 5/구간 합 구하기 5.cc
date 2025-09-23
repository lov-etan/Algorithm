#include <iostream>
#include <vector>

using namespace std;
int N, M;

int main() {
    cin.tie(0); cout.tie(0); ios::sync_with_stdio(0);
    cin >> N >> M;
    vector<vector<int>> maps(N+1, vector<int>(N+1, 0));
    for(int r=1; r<=N; r++) {
        for(int c=1; c<=N; c++) {
            cin >> maps[r][c];
            maps[r][c] += maps[r][c-1] + maps[r-1][c] - maps[r-1][c-1];
        }
    }

    // M번의 총합 계산 해보기!
    for(int i=0; i<M; i++) {
        int sr, sc, er, ec; cin >> sr >> sc >> er >> ec;

        int ans = maps[er][ec] - maps[sr-1][ec] - maps[er][sc-1] + maps[sr-1][sc-1];
        cout << ans << "\n";
    }

    
    
    return 0;
}