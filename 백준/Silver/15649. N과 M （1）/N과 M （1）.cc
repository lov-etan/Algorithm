//1부터 N까지 자연수 중 중복 없이 M개를 고른 수열

#include <iostream>
#include <vector>
using namespace std;
int N, M;
vector<int> sel;
vector<bool> visited;

void nCm(int selIdx) {

    if(selIdx == M) {
        for(int i=0; i<M ;i++) {
            cout << sel[i] << " ";
        }
            cout << '\n';
        return;
    }

    for(int num=1; num<=N; num++) {
        if(!visited[num]) {
            visited[num] = true;
            sel[selIdx] = num;
            nCm(selIdx+1);

            visited[num] = false; //방문 닫아주기!
        }
    }
}

int main() {
    cin >> N >> M;
    sel.assign(M+1, 0);
    visited.assign(N+1,false);

    nCm(0);
    
    return 0;
}
