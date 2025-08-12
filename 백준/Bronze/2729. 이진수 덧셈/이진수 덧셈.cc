#include <iostream>
#include <vector>

using namespace std;

vector<int> num;

int main() {
    cin.tie(0); cout.tie(0); ios::sync_with_stdio(0);
    int T; cin >> T;
    while(T--) {
        num.assign(81,0);
        string str1, str2; cin >> str1 >> str2;
        
        for(int i=0; i<str1.length(); i++) {
            int end = str1.length() -1;
            num[end-i] += str1[i] - '0';
        }

        for(int i=0; i<str2.length(); i++) {
            int end = str2.length() -1;
            num[end-i] += str2[i] - '0';
        }

        int maxLen = max(str1.length(), str2.length());
        // 더한 값 2된 것들 처리
        for(int i=0; i<maxLen+1; i++) {
            if(num[i] >= 2) {
                num[i] -= 2;
                num[i+1]++;
            }
        }

        bool start = false;
        for(int i=maxLen; i>=0; i--) {
            if(num[i] == 1) start = true;
            if(i == 0 && !start) start = true; // 0일 때도 생각해야 함
            
            if(start) {
                cout << num[i];
            }
        }
        cout << "\n";
        
    }
    
    
    return 0;
}