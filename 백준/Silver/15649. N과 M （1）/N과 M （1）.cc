#include <iostream>
#include <vector>

using namespace std;
int N, M;
vector<int> picks;
vector<bool> vis;

void dfs(int pIdx) {
    if(pIdx == M) {
        for(auto p : picks) {
            cout << p << " ";
        }
        cout << "\n";
        return;
    }
    
    for(int i=1; i<=N; i++) {
        if(vis[i]) continue;
        picks.push_back(i); vis[i] = true;
        dfs(pIdx+1);
        picks.pop_back(); vis[i] = false;
    }
}

int main() {
    cin >> N >> M;
    vis.assign(N, false);
    dfs(0);
    return 0;
}