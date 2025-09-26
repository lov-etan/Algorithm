#include <string>
#include <vector>

using namespace std;
int N; 
vector<vector<int>> coms;
vector<bool> vis;

void dfs(int idx) {
    if(idx == N) return;
    
    for(int i=0; i<N; i++) {
        if(!vis[i] && coms[idx][i] == 1) {
            vis[i] = true;
            dfs(i);
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    N = n; coms = computers;
    vis.resize(N,false);
    
    for(int i=0; i<N; i++) {
        if(!vis[i]) {
            answer++;
            vis[i] = true;
            dfs(i);
        }
    }
    
    return answer;
}