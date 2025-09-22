#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n; cin >> n;
    vector<int> p(n+1,0);
    p[0] = 0; p[1] = 1;

    int i=2;
    while(i <= n) {
        p[i] = p[i-1] + p[i-2];
        i++;
    }

    cout << p[n];
    return 0;
}