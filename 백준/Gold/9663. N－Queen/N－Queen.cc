#include <iostream>
#include <vector>

using namespace std;

int N; int ans = 0;
vector<vector<bool>> maps;
vector<bool> visCol;
vector<bool> visRow;

int dr[] = {-1,-1};
int dc[] = {-1,1};

bool inRange(int r, int c) {
    return r>=0 && r<N && c>=0 && c<N;
}

bool checkDiag(int r, int c) {

    for(int d=0; d<2; d++) {
        int nr = r;
        int nc = c;
        while(1) {
            nr += dr[d];
            nc += dc[d];
            if(inRange(nr,nc)) {
                if(maps[nr][nc]) return false;
            } else {
                break;
            }
        }
    }

    return true;
}

void dfs(int qIdx, int r) { // 놓은 퀸의 개수 / 위치
    if(qIdx == N) {
        ans++;
        return;
    }

    if(r == N) return;

    for(int c=0; c<N; c++) {
        if(!visCol[c] && !visRow[r] && checkDiag(r,c)) {
            visCol[c] = true;
            visRow[r] = true;
            maps[r][c] = true;
            
            dfs(qIdx+1, r+1);
    
            visCol[c] = false;
            visRow[r] = false;
            maps[r][c] = false;
        }
    }

    
}

int main() {
    cin.tie(0); cout.tie(0); ios::sync_with_stdio(0);
    cin >> N;
    maps.resize(N, vector<bool>(N,false));
    visCol.resize(N,false);
    visRow.resize(N,false);

    dfs(0,0);
    cout << ans;
    return 0;
}