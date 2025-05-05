#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> board;
vector<vector<bool>> visited;
int answer;

//좌 우 하
int dr[] = {0,0,1};
int dc[] = {-1,1,0};

bool isInRange(int nr, int nc) {
    if(nr>=0 && nr<100 && nc>=0 && nc<100) {
        return true;
    } else {
        return false;
    }
}

void dfs(int r, int c, int startC) {
    visited[r][c] = true;

    if(board[r][c] == 2) { //목표 지점에 도달
        answer = startC;
        return;
    }

    //좌우 방향만 먼저 탐색 
   for(int i=0; i<2; i++) {
       int nr = r + dr[i];
       int nc = c + dc[i];

       if(isInRange(nr, nc) && !visited[nr][nc] && (board[nr][nc] == 1 || board[nr][nc] == 2) ) {
           dfs(nr, nc, startC);
           return; // 좌,우 중에 있으면 다른 방향은 고려x
       }
   }

    // 아래 방향
    int nr = r + dr[2];
    int nc = c + dc[2];
    if(isInRange(nr, nc) && !visited[nr][nc] && (board[nr][nc] == 1 || board[nr][nc] == 2) ) {
       dfs(nr, nc, startC);
   }
    
}

int main() {

    for(int tc=1; tc<=10; tc++) {
        board.assign(100, vector<int>(100));
        int t;
        cin >> t;

        for(int r=0; r<100; r++) {
            for(int c=0; c<100; c++) {
                cin >> board[r][c];
            }
        }

        answer = -1;
        
        for(int c=0; c<100; c++) {
            if (board[0][c] == 1) {  // 사다리 있는 곳만 시작
                visited.assign(100, vector<bool>(100));
                dfs(0, c, c);
                if (answer != -1) break;
            }
        }

        cout << "#" << tc << " " << answer << "\n";
    }

    return 0;
}