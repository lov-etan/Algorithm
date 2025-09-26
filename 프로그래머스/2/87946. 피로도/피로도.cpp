#include <string>
#include <vector>

using namespace std;
int ans = 0;
vector<vector<int>> duns;
vector<bool> vis;

void dfs(int power, int cnt) {
    ans = max(ans, cnt);
    
    for(int i=0; i<duns.size(); i++) {
        if(!vis[i] && power >= duns[i][0]) {
            vis[i] = true;
            dfs(power-duns[i][1], cnt+1);
            vis[i] = false;
        }
    }
}

int solution(int k, vector<vector<int>> dungeons) {
    
    duns = dungeons;
    vis.resize(duns.size(), false);
    
    dfs(k, 0);
    return ans;
}