#include <bits/stdc++.h>
using namespace std;
int N;
vector<int> v;

int cntViewOk(int idx, int minCnt) {
    //왼 -1 왼 -2 오 +1 오 +2
    int maxBuilding = max({v[idx-1], v[idx-2], v[idx+1], v[idx+2]});

    if(maxBuilding <v[idx]) {
        minCnt = v[idx] - maxBuilding;
    }
    
    return minCnt;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    
    for(int tc=1; tc<=10; tc++) {
        cin >> N;
        v.assign(N, 0);
        int answer = 0;

        for(int i=0; i<N; i++) {
            cin >> v[i];
        }

        for(int i=2; i<N-2; i++) {
            int minCnt = 0;
            answer += cntViewOk(i, minCnt);
        }

        cout << "#" << tc << " " << answer << "\n";
    }
    return 0;
}