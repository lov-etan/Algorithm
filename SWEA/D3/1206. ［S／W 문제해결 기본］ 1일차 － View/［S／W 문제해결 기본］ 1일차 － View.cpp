#include <bits/stdc++.h>
using namespace std;
int N;
vector<int> v;

int cntViewOk(int idx, int minCnt) {
    //왼 -1 왼 -2 오 +1 오 +2
    if(v[idx-1] < v[idx]) {
        minCnt = v[idx] - v[idx-1];
        
        if(v[idx-2] < v[idx]) {
        minCnt = min(minCnt, v[idx] - v[idx-2]);

            if(v[idx+1] < v[idx]) {
                minCnt = min(minCnt, v[idx] - v[idx+1]);

                if(v[idx+2] < v[idx]) {
                    minCnt = min(minCnt, v[idx] - v[idx+2]);
                } else {
                    return 0;
                }
            }  else {
                return 0;
            }
        } else {
            return 0;
        }
    } else {
        //cout << "조망권확보x " << idx << "\n";
        return 0;
    }
    //cout << idx << " " << minCnt << "\n";
    return minCnt;
}

int main() {
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