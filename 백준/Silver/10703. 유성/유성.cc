#include <iostream>
#include <vector>

using namespace std;

int R, S;
vector<vector<char>> maps;
vector<vector<char>> newMaps;
vector<int> mDp;
vector<int> gDp;

int main() {
    cin >> R >> S;
    maps.resize(R, vector<char>(S,'.'));
    newMaps.resize(R, vector<char>(S,'.'));
    mDp.resize(S,-1); // 첫 줄에 . 이 있을 때와 X가 있을 때를 분리해줘야 함
    gDp.resize(S,R); // 마지막 줄에 #이 있을 때와 .이 있을 때를 분리해줘야 함

    for(int r=0; r<R; r++) {
        for(int c=0; c<S; c++) {
            char a; cin >> a;
            maps[r][c] = a;
            if(a == 'X' && mDp[c] < r) {
                mDp[c] = r;
            }
            else if(a == '#' && gDp[c] > r) {
                gDp[c] = r;
            }
        }
    }

    int move = R-1;
    for(int c=0; c<S; c++) {
        if(mDp[c] != -1 && gDp[c] != R) { // 땅이 없으면 유성이 그냥 사라진다...
            move = min(move, gDp[c] - mDp[c] -1); 
        }
    }

    for(int r=0; r<R; r++) {
        for(int c=0; c<S; c++) {
            if(maps[r][c] == 'X' && r+move < R) { // 유성 사라진다...
                newMaps[r+move][c] = 'X';
            }
            else if(maps[r][c] == '#') {
                newMaps[r][c] = '#';
            }
        }
    }

    for(int r=0; r<R; r++) {
        for(int c=0; c<S; c++) {
            cout << newMaps[r][c];
        }
        cout << "\n";
    }
    
    return 0;
}