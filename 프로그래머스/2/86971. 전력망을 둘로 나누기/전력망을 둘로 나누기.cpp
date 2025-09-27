#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int N;
vector<vector<int>> ws;
vector<bool> vis;

int bfs(int start) {
    queue<int> q;
    q.push(start);
    int cnt = 0;
    
    while(!q.empty()) {
        int curr = q.front(); q.pop();
        cnt++;
        
        for(int i=0; i<N-1; i++) {
            int a = ws[i][0];  int b = ws[i][1];
            if(curr == a && !vis[b]) {
                vis[b] = true;
                q.push(b);
            } else if(curr == b && !vis[a]) {
                vis[a]  = true;
                q.push(a);
            }
        }
    }
    return cnt;
}

int solution(int n, vector<vector<int>> wires) {
    N = n; ws = wires;
    int answer = 98765432;
    
    for(int i=0; i<ws.size(); i++) {
        vis.assign(n,false);
        
        int a = ws[i][0];  int b = ws[i][1];
        vis[a] = true; vis[b] = true;
        answer = min(abs(bfs(a)-bfs(b)), answer);
    }
    
    return answer;
}