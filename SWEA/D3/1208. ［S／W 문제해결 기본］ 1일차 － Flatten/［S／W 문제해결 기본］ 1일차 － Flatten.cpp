#include <bits/stdc++.h>
using namespace std;

int N;
string s;
vector<int> boxs;

int main() {

    for(int tc=1; tc<=10; tc++) {
        cin >> N;
        boxs.assign(100,0);

        for(int i=0; i<100; i++) {
            cin >> boxs[i];
        }

        int answer;
        for(int i=0; i<N; i++) {
            sort(boxs.begin(), boxs.end());
            
            int min = boxs[0];
            int max = boxs[boxs.size()-1];

            if(min < max && max != 0) {
                boxs[0]++;
                boxs[boxs.size()-1]--;
            }
        }

        sort(boxs.begin(), boxs.end()); //최종 sort 해주기 
        cout << "#" << tc << " " << boxs[boxs.size()-1]-boxs[0] << "\n";
    }
    return 0;
}