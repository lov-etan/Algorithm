#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int N;

        // 하 우 상 좌
int dr[] = {1, 0, -1, 0};
int dc[] = {0, 1, 0, -1};

bool inRange(int nr, int nc) {
    return nr>=0 && nr<N && nc>=0 && nc<N;
}

int main() {

    int target;
    cin >> N >> target;

    vector<vector<int>> v(N, vector<int>(N,0));
    pair<int, int> tRC;

    int curr = pow(N,2);
    int d = 0;
    int r = 0; int c = 0;

    v[r][c] = curr;
    curr--;
    
    while(curr >= 1) {

        int nr = r + dr[d];
        int nc = c + dc[d];

        if(!inRange(nr, nc) || v[nr][nc] != 0) {
            // cout << curr << "\n";
            d = (d+1) %4;
            nr = r + dr[d];
            nc = c + dc[d];
        }

        // cout << curr << "d " << d << " r " <<  nr << " c " <<  nc << "\n";

        r = nr; 
        c = nc;
        v[r][c] = curr;

        if(curr == target) {
            tRC = {r, c};
        }

        curr--;
    }

    for(int i=0; i<N; i++) {
        for(int j=0; j<N; j++) {
            cout << v[i][j] << " ";
        }
        cout << "\n";
    }

    cout << tRC.first+1 << " " << tRC.second+1;

    
    
    return 0;
}