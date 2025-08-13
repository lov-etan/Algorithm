#include <iostream>
#include <vector>

using namespace std;

int N;
long long K;
vector<int> courses;

int main() {
    cin >> N >> K;
    courses.resize(N+1, 0);

    for(int i=1; i<=N; i++) {
        cin >> courses[i];
    }

    int idx = 1;
    bool goBack = false;
    while(1) {
        K -= courses[idx];
        if(K < 0) {
            cout << idx;
            return 0;
        }

        if(!goBack) {
            idx++;
            if(idx > N) {
                goBack = true;
                idx--;
            }
        } else {
            idx--;
        }
        
    }
    
    return 0;
}