#include <bits/stdc++.h>
using namespace std;
//완전한 n중 for문 - 중복 가능 

int N, M;
vector<int> sel;

void nCm (int sIdx) {
    if(sIdx == M) {
        for(int i=0; i<M; i++) {
            cout << sel[i] << " ";
        }
        cout << "\n";
        return;
    }  

    for(int num=1; num<=N; num++) {
        sel[sIdx] = num;
        nCm(sIdx+1);
    }
}

int main() {
    cin >> N >> M;
    sel.assign(M, 0);

    nCm(0);
    


    
    return 0;
}