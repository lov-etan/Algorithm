#include <iostream>
#include <vector>

using namespace std;
int N, M;
vector<int> picks;

void dfs(int start, int pIdx) {
    if(pIdx == M) {
        for(auto p : picks) {
            cout << p << " ";
        }
        cout << "\n";
        return;
    }
    
    for(int i=start; i<=N; i++) {
        picks.push_back(i); 
        dfs(i+1, pIdx+1);
        picks.pop_back(); 
    }
}

int main() {
    cin >> N >> M;
    dfs(1, 0);
    return 0;
}