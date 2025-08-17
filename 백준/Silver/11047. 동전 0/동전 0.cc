#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int N, K;
    cin >> N >> K;

    vector<int> coins(N, 0);
    for(int i=0; i<N; i++) {
        cin >> coins[i];
    }
    sort(coins.rbegin(), coins.rend());
    

    int ans = 0;
    int idx = 0;
    while(K) {
        ans += K/coins[idx];
        K = K%coins[idx];

        idx++;
    }
    
    cout << ans;
    
    return 0;
}