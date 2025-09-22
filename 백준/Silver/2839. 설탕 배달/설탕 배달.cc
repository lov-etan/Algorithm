#include <iostream>
#include <vector>

using namespace std;
int N;

int Solve() {
    int cnt = N/5;

    for(int i=cnt; i>=0; i--) {
        int left = N - 5*i;
        if(left%3 == 0) {
            return i+(left/3);
        }
    }
    return -1;
    
}

int main() {
    cin >> N;
    cout << Solve();
            
    return 0;
}