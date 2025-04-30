#include <bits/stdc++.h>
using namespace std;
//본인 포함 for문

int N, M;
vector<int> sel;

void nCm (int sIdx, int curr) {

    if(sIdx == M) {
        for(int i=0; i<M; i++) {
            cout << sel[i] << " ";
        }
        cout << "\n";
        return;
    }

    for(int nxt=curr; nxt<=N; nxt++ ) {
        sel[sIdx] = nxt;
        nCm(sIdx+1, nxt);
    }

}

int main() {
    cin >> N >> M;
    sel.assign(M, 0);

    nCm(0, 1);
        
    return 0;
}