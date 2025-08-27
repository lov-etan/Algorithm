#include <iostream>
#include <vector>

using namespace std;

int N;

int main() {
    cin >> N;
    int ans = 0;
    string s; cin >> s;
    for(int i=0; i<N; i++) {
        ans = ans + s[i] - '0';
    }

    cout << ans;
    return 0;
}