#include <iostream>
#include <vector>

using namespace std;
int INF = 2076543219;

int main() {
    cin.tie(0); cout.tie(0); ios::sync_with_stdio(0);
    int N; cin >> N;
    vector<int> dp(N+1, 0);
    dp[1] = 0; dp[2] = 1; dp[3] = 1;
    for(int i=4; i<=N; i++) {
        int a = INF, b = INF, c = INF;
                
        if(i%3 == 0) a = dp[i/3] + 1;
        if(i%2 == 0) b = dp[i/2] + 1;
        c = dp[i-1]+1;

        if(a <= b && a <= c) dp[i] = a;
        else if(b <= a && b <= c) dp[i] = b;
        else if(c <= a && c <= b) dp[i] = c;
    }

    cout << dp[N];
    
    return 0;
}