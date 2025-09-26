#include <iostream>
#include <vector>

using namespace std;
vector<vector<int>> maps;
vector<vector<bool>> Rvis;
vector<vector<bool>> Cvis;
vector<vector<vector<bool>>> Nvis;

void vis(int r, int c, int num, bool flag) {
    Rvis[r][num] = flag;
    Cvis[c][num] = flag;
    Nvis[r/3][c/3][num] = flag;
}

bool check(int r, int c, int num) {
    if(Rvis[r][num]) return false;
    if(Cvis[c][num]) return false;
    if(Nvis[r/3][c/3][num]) return false;
    return true;
}

void dfs(int idx, int zCnt) {
    if(idx == 81) {
        if(zCnt > 0) return;
        for(int r=0; r<9; r++) {
            for(int c=0; c<9; c++) {
                cout << maps[r][c] << " ";
            }
            cout << "\n";
        }
        exit(0);
    }

    int r = idx/9;
    int c = idx%9;

    if(maps[r][c] == 0) {
        for(int i=1; i<=9; i++) {
            if(check(r,c,i)) {
                maps[r][c] = i; vis(r,c,i, true);
                dfs(idx+1, zCnt-1);
                maps[r][c] = 0; vis(r,c,i, false);
            }
        }
    } else {
        dfs(idx+1, zCnt);
    }
}

int main() {
    cin.tie(0); cout.tie(0); ios::sync_with_stdio(0);
    maps.resize(9, vector<int>(9,0));
    Rvis.resize(10, vector<bool>(10, false));
    Cvis.resize(10, vector<bool>(10, false));
    Nvis.resize(3, vector<vector<bool>>(3, vector<bool>(10,false)));

    int zCnt = 0;
    for(int r=0; r<9; r++) {
        for(int c=0; c<9; c++) {
            cin >> maps[r][c];
            Rvis[r][maps[r][c]] = true;
            Cvis[c][maps[r][c]] = true;
            Nvis[r/3][c/3][maps[r][c]] = true;
            if(maps[r][c] == 0) zCnt++;
        }
    }

    dfs(0, zCnt);
}