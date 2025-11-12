#include <iostream>
#include <vector>
#include <queue>

using namespace std;

bool inRange(int r) {
    return r>=0 && r<=100000;
}

int main() {
    vector<bool> vis(100001, false);
    int N, K; cin >> N >> K;
    
    queue<pair<int,int>> q;
    q.push({0,N});
    vis[N] = true;


    while(!q.empty()) {
        auto[time, curr] = q.front(); q.pop();
        if(curr == K) {
            cout << time;
            exit(0);
        }

        int nr = 2*curr;
        if(inRange(nr) && !vis[nr]) {
            vis[nr] = true;
            q.push({time, nr});
        }

        nr = curr-1;
        if(inRange(nr) && !vis[nr]) {
            vis[nr] = true;
            q.push({time+1, nr});
        }

        nr = curr+1;
        if(inRange(nr) && !vis[nr]) {
            vis[nr] = true;
            q.push({time+1, nr});
        }
        
    }
    
    return 0;
}