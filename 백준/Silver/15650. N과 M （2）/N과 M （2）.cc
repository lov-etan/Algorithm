#include <bits/stdc++.h>
using namespace std;
int N, M;
vector<int> sel;

void nC2(int sIdx, int num) {
    if(sIdx == M) {
        for(int i=0; i<M; i++) {
            cout << sel[i] << " ";
        }
        cout << "\n";
        return;
    }

    for(int i=num; i<=N; i++) {
        sel[sIdx] = i;
        nC2(sIdx+1, i+1); //다음 number로 넘겨주기 잊지 않기       
    }
}

int main() {
    cin >> N >> M;
    sel.assign(M, 0);

    nC2(0,1);
    
    return 0;
}