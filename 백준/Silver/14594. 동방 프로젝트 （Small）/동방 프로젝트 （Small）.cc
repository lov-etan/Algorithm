#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N, M;
    cin >> N >> M;
    vector<int> arr(N*2+1, -1);

    for(int i=1; i<=2*N; i++) {
        if(i % 2 == 0) arr[i] = i/2;
        else arr[i] = -1;
    }

    for(int m=0; m<M; m++) {
        int x, y; cin >> x >> y;

        for(int i=2*x; i<2*y; i++) {
            if(arr[i] == -1) arr[i] = 0;
        }
    }

    int cnt = 0;
    for(int i=1; i<2*N; i++) {
        if(arr[i] == -1) {
            cnt++;
        }
    }

    cout << cnt;
    
    return 0;
}