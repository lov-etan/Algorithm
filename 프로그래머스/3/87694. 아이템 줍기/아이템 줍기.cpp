#include <string>
#include <vector>
#include <queue>

using namespace std;
vector<vector<int>> maps;
vector<vector<int>> dp;
int tr, tc;
queue<pair<int,int>> q;

int dr[] = {1,0,-1,0};
int dc[] = {0,1,0,-1};

bool inRange(int r, int c) {
    return r>=0 && r<101 && c>=0 && c<101;
}

int bfs(int sr, int sc) {
    dp[sr][sc] = 0;
    q.push({sr,sc});
    
    while(!q.empty()) {
        auto[r,c] = q.front(); q.pop();
        if(r==tr && c==tc) {
            return dp[r][c]/2;
        }
        
        for(int d=0; d<4; d++) {
            int nr = r+dr[d]; int nc = c+dc[d];
            if(inRange(nr,nc) && dp[nr][nc] == -1 && maps[nr][nc] == 1) {
                dp[nr][nc] = dp[r][c]+1;
                q.push({nr,nc});
            }
        }
    }
    return -1;
}

int solution(vector<vector<int>> rectangle, int characterX, int characterY, int itemX, int itemY) {
    maps.resize(101, vector<int>(101,0));
    dp.resize(101, vector<int>(101,-1));
    tr = itemX*2; tc = itemY*2;
    
    for(int i=0; i<rectangle.size(); i++) {
        int sr = rectangle[i][0]*2; int sc = rectangle[i][1]*2;
        int er = rectangle[i][2]*2; int ec = rectangle[i][3]*2;
        
        for(int r=sr; r<=er; r++) {
            maps[r][sc] = 1;
            maps[r][ec] = 1;
        }
        
        for(int c=sc; c<=ec; c++) {
            maps[sr][c] = 1;
            maps[er][c] = 1;
        }
    }
    
    for(int i=0; i<rectangle.size(); i++) {
        int sr = rectangle[i][0]*2; int sc = rectangle[i][1]*2;
        int er = rectangle[i][2]*2; int ec = rectangle[i][3]*2;
        
        for(int r=sr+1; r<er; r++) {
            for(int c=sc+1; c<ec; c++) {
                maps[r][c] = 0;
            }
        }
    }
    
    return bfs(characterX*2, characterY*2);
}