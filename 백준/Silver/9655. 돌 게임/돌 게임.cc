#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N; cin >> N;
    vector<int> arr(10001, 0);
    for(int i=1; i<=1000; i+=2) {
        arr[i] = 1;
    }

    if(arr[N] == 1) {
        cout << "SK";
    } else {
        cout << "CY";
    }
            
    return 0;
}