#include <iostream>
#include <vector>

using namespace std;
int N; int ans;
vector<bool> Rvis;
vector<bool> Cvis;
vector<bool> cross1;
vector<bool> cross2;

void vis(int r, int c, int flag) {
    Rvis[r] = flag;
    Cvis[c] = flag;
    cross1[N+r-c] = flag;
    cross2[r+c] = flag;
}

bool check(int r, int c) {
    if(Rvis[r]) return false;
    if(Cvis[c]) return false;
    if(cross1[N+r-c]) return false;
    if(cross2[r+c]) return false;
    return true;
}

void dfs(int r) {
    if(r == N) {
        ans++;
        return;
    }

    for(int c=0; c<N; c++) {
        if(check(r,c)) {
            vis(r,c,true);
            dfs(r+1);
            vis(r,c,false);
        }
    }
}

int main() {
    cin >> N;
    Rvis.resize(N, false);
    Cvis.resize(N, false);
    cross1.resize(N*2 + 1, false);
    cross2.resize(N*2, false);

    dfs(0);
    
    cout << ans;
}