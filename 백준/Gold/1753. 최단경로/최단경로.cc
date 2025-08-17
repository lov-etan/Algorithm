#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

int V, E;
int SV; 
int INF = INT_MAX;
vector<vector<pair<int,int>>> adj;
vector<int> dp;
priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;

void bfs() {
    dp[SV] = 0;
    pq.push({0, SV});

    while(!pq.empty()) {
        auto [currDist, curr] = pq.top(); pq.pop();

        if(currDist > dp[curr]) continue;

        for(auto [nxt, w] : adj[curr]) {
            if(dp[nxt] > dp[curr] + w) {
                dp[nxt] = dp[curr] + w;
                pq.push({dp[nxt], nxt});
            }
        }
    }
}

int main() {
    cin.tie(0); cout.tie(0); ios::sync_with_stdio(0);
    cin >> V >> E >> SV;
    adj.resize(V+1);
    dp.resize(V+1, INF);

    for(int i=0; i<E; i++) {
        int a, b, w;
        cin >> a >> b >> w;

        adj[a].push_back({b,w});
    }

    bfs();

    for(int i=1; i<=V; i++) {
        if(dp[i] == INF) {
            cout << "INF";
        } else {
            cout << dp[i];
        }
        cout << "\n";
    }
    
    return 0;
}