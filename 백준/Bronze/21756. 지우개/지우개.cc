#include <iostream>
#include <vector>

using namespace std;

int N;
vector<int> arr1;
vector<int> arr2;

int main() {
    cin >> N;
    arr1.resize(N+1, 0);
    arr2.resize(1, 0);

    if(N==1) {
        cout << 1;
        return 0;
    }

    
    for(int i=1; i<=N; i++) {
        arr1[i] = i;
    }
    
    while(1) {
        for(int i=2; i<arr1.size(); i+=2) {
            arr2.push_back(arr1[i]);
        }

        if(arr2.size() == 2) {
            cout << arr2[1]; 
            break;
        }

        arr1 = arr2;
        arr2.assign(1, 0);
    }
    
    return 0;
}