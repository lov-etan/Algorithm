#include <iostream>
#include <vector>

using namespace std;

int main() {
    cin.tie(0); cout.tie(0); ios::sync_with_stdio(0);
    int N; cin >> N;
    vector<int> arr(N,0);

    for(int i=0; i<N; i++) {
        cin >> arr[i];
    }

    for(int i=0; i<N; i++) {
        for(int j=1; j<N-i; j++) {
            if(arr[j-1] > arr[j]) {
                int tmp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = tmp;
            }
        }
    }

    for(int i=0; i<N; i++) {
        cout << arr[i] << "\n";
    }
    return 0;
}